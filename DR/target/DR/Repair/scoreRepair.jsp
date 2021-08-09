<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:text name="DR.title"/></title>
  </head>
  <body>
    <jsp:include page="/User/userMain.jsp"/>
    <s:text name="Please rate the repaired results!"></s:text>
    <center>
    <s:form name="repair" action="repairScore" namespace="/" method="post">
    	<input type="hidden" name="repairid" value="${repair.repairid}">
    	<s:textfield key="equipmentid" value="%{repair.eid}" readonly="true"></s:textfield>
    	<s:textfield key="building" value="%{equipment.building}" readonly="true"></s:textfield>
    	<s:textfield key="floor" value="%{equipment.floor}" readonly="true"></s:textfield>
    	<s:textfield key="room" value="%{equipment.building}" readonly="true"></s:textfield>
    	<s:textfield key="scope" value="%{equipment.scope}" readonly="true"></s:textfield>
   		<s:radio key="score" name="score" list="# {'1':'1','2':'2','3':'3','4':'4','5':'5'}" value="1" />
   		<s:submit key="true.submit"></s:submit>
    </s:form>
    </center>
  </body>
</html>
