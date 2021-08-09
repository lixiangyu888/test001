<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <jsp:include page="/Worker/workerMain.jsp"/>
    <s:text name="update.title"></s:text>
    <s:property value="msg" escape="false"/>
    <center>
    <s:form name="update" action="workerUpdate" namespace="/" method="post">
	  <tr><td><s:text name="workerid">:</s:text></td>  <td><input type="text" name="workerid" value="${worker.workerid}" readonly="true"></td></tr>
  	  <tr><td><s:text name="password"></s:text></td> <td><input type="text" name="password" value="${worker.password}"></td></tr>
  	  <tr><td><s:text name="realname"></s:text></td> <td><input type="text" name="realname" value="${worker.realname}"></td></tr>
  	  <tr><td><s:text name="phone"></s:text></td>    <td><input type="text" name="phone" value="${worker.phone}"></td></tr>
  	  <tr><td>
  	  <s:if test="worker.scope=='网络'"><s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="0" />
  	  </s:if>
  	  <s:elseif test="worker.scope=='水电'"><s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="1" />
  	  </s:elseif>
  	  <s:else><s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="2" /></s:else></td></tr>
 	  <s:submit key="true.submit"></s:submit>
    </s:form>
    </center>
  </body>
</html>
