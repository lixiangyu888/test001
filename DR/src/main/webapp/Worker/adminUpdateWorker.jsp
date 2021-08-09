<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <jsp:include page="/Admin/adminMain.jsp"/>
    <s:text name="admin.updateWorker"></s:text>
    <s:property value="msg" escape="false"/>
    <center>
    <s:form name="updateWorker" action="adminUpdateWorker" namespace="/" method="post">
	  <s:textfield key="workerid" name="workerid" value="%{worker.workerid}" readonly="true"></s:textfield>
   	  <s:password key="password" name="password" value="%{worker.password}"></s:password>
   	  <s:textfield key="realname" name="realname" value="%{worker.realname}"></s:textfield>
  	  <s:textfield key="phone" name="phone" value="%{worker.phone}"></s:textfield>
  	  <s:if test='worker.scope=="网络"'>
  	  <s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="0" />
 	  </s:if>
 	  <s:elseif test='worker.scope=="水电"'>
 	  <s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="1" />
 	  </s:elseif>
 	  <s:else>
 	  <s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="2" />
 	  </s:else>
 	  <s:submit key="true.submit"></s:submit>
    </s:form>
    </center>
  </body>
</html>
