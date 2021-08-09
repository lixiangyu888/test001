<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
     <jsp:include page="/User/userMain.jsp"/>
     <s:text name="addRepair.title"></s:text>
     <s:property value="msgg" escape="false"/>
     <center>
   	 	<s:form name="repair" action="addRepair" namespace="/" method="post">
   	 		<s:set name="buildingList" value="# {'1#':'1#','2#':'2#','2A#':'2A#','3#':'3#','4#':'4#','5#':'5#',
   	 		'6#':'6#','7#':'7#','8#':'8#','9#':'9#','10#':'10#'}"></s:set>
   	 		<s:select list="#buildingList" key="building" name="building" headerKey="1#" headerValue="-选择楼栋-"></s:select>
   	 		<s:set name="floorList" value="# {'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6'}"></s:set>
   	 		<s:select list="#floorList" key="floor" name="floor" headerKey="1" headerValue="-选择楼层-"></s:select>
   	 		<s:set name="roomList" value="# {'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10',
   	 		'11':'11','12':'12','13':'13','14':'14','15':'15','16':'16','17':'17','18':'18','19':'19','20':'20',
   	 		'21':'21','22':'22','23':'23','24':'24','25':'25','26':'26','27':'27','28':'28','29':'29','30':'30',
   	 		'31':'31','32':'32','33':'33','34':'34','35':'35','36':'36','37':'37','38':'38','39':'39','40':'40'}"></s:set>
   	 		<s:select list="#roomList" key="room" name="room" headerKey="1" headerValue="-选择房间号-"></s:select>
   	 		<input type="hidden" name="userid" value="${userid}">
      		<s:radio key="scope" name="scope" list="#{'0':'网络','1':'水电','2':'门窗'}" value="0" />
      		<s:submit key="true.submit"></s:submit>
     	</s:form>
     </center>
  </body>
</html>