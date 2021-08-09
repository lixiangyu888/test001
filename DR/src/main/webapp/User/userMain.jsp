<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title><s:text name="DR.title"/></title>
  </head>
  <body>
  <br>
  <s:property value="msg" escape="false"/>
    <center>
    	<s:a action="userUpdateJsp"><s:param name="userid">${userid}</s:param><s:text name="update.information"></s:text></s:a>
    	<s:a action="searchUserRepairJsp"><s:param name="userid">${userid}</s:param><s:text name="repair"></s:text></s:a>
    	<s:a action="addRepairJsp"><s:param name="userid">${userid}</s:param><s:text name="addRepair"></s:text></s:a>
    	<s:a action="reLogin"><s:text name="return.Sy.submit"></s:text></s:a>
    </center>
  </body>
</html>
