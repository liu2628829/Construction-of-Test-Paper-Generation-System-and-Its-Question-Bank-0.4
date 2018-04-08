<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>查询试卷</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="/hrbuedu/js/jquery-132min2.js"></script>
<script type="text/javascript" src="/hrbuedu/js/exportWord.js"></script>


</head>

<body>

<form id = 'form1' action="" method = 'post'>
<input type = 'button' id = 'export' name = 'export' value = '导出word'>
<input type = 'hidden' name = "tbId" id = "tbId" value = '${testPaperId }'>
<div align="center"><!--  
<table id = 'table1'>
	<tr>
		<td>题目所属科目：</td>
		<td><select id="subject" name="sid">
			<option value="-1" selected>--还未选择--</option>
			<s:iterator value="#session.subjectList" status="stat">
				<option value="<s:property value = "sid" />"><s:property
					value="sname" /></option>
			</s:iterator>
		</select></td>
	</tr>
</table>
--> 


<table id='table3' border='1'>
	<tr>
		<th>序号</th>
		<th>题型</th>
		<th>试题</th>
		<th>备选答案</th>
		<th>章节</th>
		<th>试题难度</th>
	</tr>

	<s:iterator value="#request.qlist" id="qvo" status="status">
		<tr>
			<th><s:property value='#status.index +1' escape="false" /></th>
			<td><s:property value='#qvo.types.tname' /></td>
			<td><s:property value='#qvo.qtext' escape="false" /></td>
			<td><s:iterator value='#qvo.answerses' id='avo' status='status'>
				<s:if test="#qvo.types.tid == 20">
					<!-- 如果是选择题 -->
					<s:if test="#status.index == 0">A.</s:if>
					<s:if test="#status.index == 1">B.</s:if>
					<s:if test="#status.index == 2">C.</s:if>
					<s:if test="#status.index == 3">D.</s:if>
					<s:property value='#avo.answer' escape="false" />
					<br />
				</s:if>
				<s:if test='#qvo.types.tid == 23'>
					<!-- 判断题 -->
					<s:if test="#avo.answer == 0"> 错</s:if>
					<s:if test="#avo.answer == 1"> 对</s:if>
				</s:if>
				<s:if test='#qvo.types.tid  in{19,22,32}'>
					<!--  其它  -->
				答案：<br />
					<s:property value='#avo.answer' escape="false" />
				</s:if>
			</s:iterator></td>
			
			<th><s:property value='#qvo.charpter.cname' /></th>
			<th><s:if test="#qvo.qdifficult ==1 ">易</s:if> <s:if
				test="#qvo.qdifficult ==2 ">中</s:if> <s:if
				test="#qvo.qdifficult ==3 ">难</s:if></th>
		</tr>

	</s:iterator>

</table>


</div>
</form>

</body>
</html>
