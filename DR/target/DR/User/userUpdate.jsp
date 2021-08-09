<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <jsp:include page="/User/userMain.jsp"/>
    <s:text name="update.title"></s:text>
    <s:property value="msg" escape="false"/>
    <center>
    <s:form name="updateU" action="userUpdate" namespace="/" method="post">
	  <tr><td><s:text name="userid">:</s:text></td>  <td><input type="text" name="userid" value="${user.userid}" readonly="true"></td></tr>
  	  <tr><td><s:text name="password"></s:text></td> <td><input type="text" name="password" value="${user.password}"></td></tr>
  	  <tr><td><s:text name="realname"></s:text></td> <td><input type="text" name="realname" value="${user.realname}"></td></tr>
  	  <tr>
  	  <s:if test='user.sex=="男"'><s:radio key="sex" name="sex" list="#{'0':'男','1':'女'}" value="0" /></s:if>
 	  <s:else><s:radio key="sex" name="sex" list="#{'0':'男','1':'女'}" value="1" /></s:else></tr>
  	  <tr><td><s:text name="phone"></s:text></td>    <td><input type="text" name="phone" value="${user.phone}"></td></tr>
 	  <tr><s:submit key="true.submit"></s:submit>
    </s:form>
    </center>
  </body>
</html>
