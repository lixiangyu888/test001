<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title><s:text name="DR.title"/></title>
  </head>
  <body>
  <s:property value="msgg" escape="false"/>
    <center>
    	<s:a action="userInformationJsp"><s:text name="user"></s:text></s:a>
    	<s:a action="workerInformationJsp"><s:text name="worker"></s:text></s:a>
    	<s:a action="repairMainJsp"><s:text name="repair"></s:text></s:a>
    	<s:a action="reLogin"><s:text name="return.Sy.submit"></s:text></s:a>
    </center>
  </body>
</html>
