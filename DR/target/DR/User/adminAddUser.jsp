<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <jsp:include page="/Admin/adminMain.jsp"/>
    <s:text name="admin.addUser"></s:text>
    <s:property value="msg" escape="false"/>
    <center>
    <s:form name="addUser" action="addUser" namespace="/" method="post">
	  <s:textfield key="userid" name="userid"/>
  	  <s:textfield key="password" name="password"/>
  	  <s:textfield key="realname" name="realname"/>
  	  <s:radio key="sex" name="sex" list="#{'0':'男','1':'女'}" value="0" />
  	  <s:textfield key="phone" name="phone"/>
 	  <tr><s:submit key="true.submit"></s:submit>
    </s:form>
    </center>
  </body>
</html>
