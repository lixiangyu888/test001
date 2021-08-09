<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <jsp:include page="/Admin/adminMain.jsp"/>
    <s:text name="admin.addWorker"></s:text>
    <s:property value="msg" escape="false"/>
    <center>
    <s:form name="addWorker" action="addWorker" namespace="/" method="post">
	  <s:textfield key="workerid" name="workerid"/>
  	  <s:textfield key="password" name="password"/>
  	  <s:textfield key="realname" name="realname"/>
  	  <s:textfield key="phone" name="phone"/>
  	  <s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="0" />
  	  <s:token/>
 	  <tr><s:submit key="true.submit"></s:submit>
    </s:form>
    </center>
  </body>
</html>
