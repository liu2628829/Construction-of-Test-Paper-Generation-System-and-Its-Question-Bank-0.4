<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>organizationQue.jsp</title>
<script type="text/javascript" src="/hrbuedu/js/jquery-132min2.js"></script>
<script type="text/javascript" src="/hrbuedu/js/autoOrg.js"></script>
</head>
<body>
<form action="/hrbuedu/quesRTestAction!autoPaper.action" name="form1"
	method="post">
<div align="center">
<table border='0'>
	<tr>
		<td>题库：</td>
		<td><select id="subject" name="subjectId">

			<s:iterator value="#session.subjectList" status="stat">
				<option value="<s:property value = "sid" />"><s:property
					value="sname" /></option>
			</s:iterator>
		</select></td>
	</tr>
	<tr>
		<td>章节所占比例：<br/><font color="red" >${error }</font></td>
		<td>
		<div id="mydiv">
		<table id='innerTable'>

		</table>
		</div>
		</td>
	</tr>

	<tr>
		<td>试卷名称：(请输入该试卷名称)</td>
		<td><input type="text" name="testPaperName" value="试卷名称">
		</td>
	</tr>
	<tr>
		<td>试题平均难度系数：</td>
		<td><select name="difficulty">
			<option value="1">简单</option>
			<option value="2" selected>中等</option>
			<option value="3">偏难</option>
		</select></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>试题类型及相应数量：<br/><font color="red" >${message }</font></td>
		<td>
		<div>
		<table>
			<s:iterator value="#session.typesList" status="stat">
				<tr>
					<td>题型： <input type=checkbox name="types"
						value="<s:property value = 'tid' />" checked> <s:property
						value='tname' /></td>
					<td><font color='red'>数量：</font> <input type="text"
						name="typesAmount" size="5" value='' /></td>
				</tr>
			</s:iterator>
		</table>

		</div>
		</td>
	</tr>
	<!--  <tr><td>总时间：</td><td><input type="text" name="altogetherTime" value="90" />（分钟）</td></tr> -->
</table>

<input type="submit" value="确定组卷"></div>
</form>
</body>
</html>
