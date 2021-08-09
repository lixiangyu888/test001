<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script language="JavaScript" type="text/javascript">
	function delete_user() {
  		event.returnValue = confirm("删除是不可恢复的，你确认要删除该学生吗？");
	}
</script>
  <head>
  </head>
  <body>
    <jsp:include page="/Admin/adminMain.jsp"/>
    <s:text name="admin.user"></s:text>
    <s:property value="msg_u" escape="false"/>
    <table border="2" cellspacing="0" align="center">
    	<tr align="center">
    		<td><s:text name="number"></s:text></td>
    		<td><s:text name="userid"></s:text></td>
    		<td><s:text name="realname"></s:text></td>
    		<td><s:text name="sex"></s:text></td>
    		<td><s:text name="phone"></s:text></td>
    		<td><s:text name="update"></s:text></td>
    		<td><s:text name="delete"></s:text></td>
    	</tr>
    	<s:iterator value="users" var="p" status="st">
    	<tr>
    		<td align="center">${st.count}</td>
    		<td align="center">${p.userid}</td>
    		<td>${p.realname}</td>
    		<td align="center">${p.sex}</td>
    		<td>${p.phone}</td>
    		<td>
    		<s:a action="adminUpdateUserJsp"><s:param name="userid">${p.userid}</s:param><s:text name="update"></s:text></s:a>
    		</td>
    		<td>
    		<s:a action="deleteUser" id="delete" onclick="delete_user()"><s:param name="userid">${p.userid}</s:param><s:text name="delete"></s:text></s:a>
    		</td>
    	</tr>
    	</s:iterator>
    	<tr>
    		<s:a action="adminAddUserJsp"><s:text name="addUser"></s:text></s:a>
    	</tr>
    </table>
  </body>
</html>
