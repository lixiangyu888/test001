<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script language="JavaScript" type="text/javascript">
	function repair_satrt() {
  		event.returnValue = confirm("确认接受并进行维修吗？");
	}
	function repair_wait() {
  		event.returnValue = confirm("确认维修待完成吗？");
	}
	function repair_end() {
  		event.returnValue = confirm("确认维修已完成吗？");
	}
</script>
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
  	<jsp:include page="/Worker/workerMain.jsp"/>
    <s:text name="searchRepair.title"></s:text>
    <table border="2" cellspacing="0" align="center">
    	<tr align="center">
    		<td><s:text name="number"></s:text></td>
    		<td><s:text name="equipmentid"></s:text></td>
    		<td><s:text name="userRepair"></s:text></td>
    		<td><s:text name="userDate"></s:text></td>
    		<td><s:text name="state"></s:text></td>
    		<td><s:text name="workerRepair"></s:text></td>
    		<td><s:text name="workerDate"></s:text></td>
    		<td><s:text name="score"></s:text></td>
    	</tr>
    	<s:iterator value="repairs" var="p" status="st">
    	<tr>
    		<td align="center">${st.count}</td>
    		<td align="center">${p.eid}</td>
    		<td align="center">${p.uid}</td>
    		<td align="center">${p.userDate}</td>
    		<td align="center">
    		<c:if test="${p.state=='未开始'}">
    		<s:url id="start" action="updateRepairStart"><s:param name="workerid">${workerid}</s:param>
    		<s:param name="repairid">${p.repairid}</s:param></s:url>
    		<s:a href="%{start}" id="start" onclick="repair_satrt()"><p class="red">${p.state}</p></s:a></c:if>
    		<c:if test="${p.state=='进行中'}">
    		<s:url id="wait" action="updateRepairWait"><s:param name="workerid">${p.wid}</s:param>
    		<s:param name="repairid">${p.repairid}</s:param></s:url>
    		<s:a href="%{wait}" id="wait" onclick="repair_wait()"><p class="orange">${p.state}</p></s:a></c:if>
    		<c:if test="${p.state=='待完成'}">
    		<s:url id="end" action="updateRepairEnd"><s:param name="workerid">${p.wid}</s:param>
    		<s:param name="repairid">${p.repairid}</s:param></s:url>
    		<s:a href="%{end}" id="end" onclick="repair_end()"><p class="yellow">${p.state}</p></s:a></c:if>
    		<c:if test="${p.state=='已维修'}"><p class="blue">${p.state}</p></c:if>
    		<c:if test="${p.state=='已结束'}"><p class="grey">${p.state}</p></c:if></td>
    		<td align="center">${p.wid}</td>
    		<td align="center">${p.workeDate}</td>
    		<td align="center">${p.score}</td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>