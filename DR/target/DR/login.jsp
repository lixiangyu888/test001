<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title><s:text name="DR.title"/></title>
  </head>
  <s:head/>
  <body>
  <br>
  <s:text name="login.title"></s:text>
   <br>
   <center>
   <s:property value="msg" escape="false"/>
   <s:form name="login" action="login" namespace="/" method="post">
   <s:textfield key="userid" name="userid"></s:textfield>
   <s:password key="password" name="password"></s:password>
   <s:radio key="identity" name="identity" list="#{'0':'学生','1':'维修人员','2':'管理员'}" value="0" />
   <s:submit key="login.submit" ></s:submit>
   <s:submit key="reg.submit" action="regJsp"></s:submit>
   </s:form>
   </center>
  </body>
</html>