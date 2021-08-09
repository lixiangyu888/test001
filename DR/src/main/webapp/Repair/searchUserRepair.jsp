<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style>
.blue{ color:blue }
.orange{ color:orange }
.red{ color:red }
.yellow{ color:yellow }
.grey{ color:grey }
</style>
  <head>
  </head>
  <body>
    <jsp:include page="/User/userMain.jsp"/>
    <s:text name="searchRepair.title"></s:text>
    <table border="2" cellspacing="0" align="center">
    	<tr align="center">
    		<td><s:text name="number"></s:text></td>
    		<td><s:text name="equipmentid"></s:text></td>
    		<td><s:text name="scope"></s:text></td>
    		<td><s:text name="userDate"></s:text></td>
    		<td><s:text name="state"></s:text></td>
    		<td><s:text name="worker"></s:text></td>
    		<td><s:text name="workerDate"></s:text></td>
    		<td><s:text name="score"></s:text></td>
    		<td><s:text name="operation"></s:text></td>
    	</tr>
    	<s:iterator value="repairs" var="p" status="st">
    	<tr>
    		<td align="center">${st.count}</td>
    		<td align="center">${p.eid}</td>
    		<td align="center">${p.scope}</td>
    		<td align="center">${p.userDate}</td>
    		<td align="center">
    		<c:if test="${p.state=='未开始'}"><p class="red">${p.state}</p></c:if>
    		<c:if test="${p.state=='进行中'}"><p class="orange">${p.state}</p></c:if>
    		<c:if test="${p.state=='待完成'}"><p class="yellow">${p.state}</p></c:if>
    		<c:if test="${p.state=='已维修'}"><p class="blue">${p.state}</p></c:if>
    		<c:if test="${p.state=='已结束'}"><p class="grey">${p.state}</p></c:if></td>
    		<td align="center">${p.wid}</td>
    		<td align="center">${p.workeDate}</td>
    		<td align="center">${p.score}</td>
    		<td><s:if test='#p.state=="已维修"'>
    		<s:a action="scoreRepairJsp"><s:param name="repairid">${p.repairid}</s:param><s:text name="score.submit"></s:text></s:a></s:if>
    		</td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>