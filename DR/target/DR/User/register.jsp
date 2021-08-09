<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title><s:text name="DR.title"/></title>
  </head>
  <body>
  <s:text name="register.title"></s:text>
   <br>
   <center>
   	<s:form name="user" action="register" namespace="/" method="post">
   		<s:textfield key="userid" name="userid"></s:textfield>
   		<s:password key="password" name="password"></s:password>
   		<s:password key="repassword" name="repassword"></s:password>
   		<s:textfield key="realname" name="realname"></s:textfield>
   		<s:radio key="sex" name="sex" list="#{'0':'男','1':'女'}" value="0" />
   		<s:textfield key="phone" name="phone"></s:textfield>
   		<s:token/>
   		<s:submit key="true.submit"></s:submit>
   		<s:submit key="return.submit" action="reLogin" ></s:submit>
   	</s:form>
   </center>
  </body>
</html>
