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
<script type="text/javascript" src="/hrbuedu/js/showTestBase.js"></script>

</head>

<body>

<div align="center">
<table id='table1'>
	<tr>
		<td>题目所属科目：</td>
		<td><select id="subject" name="sid">
			
			<s:iterator value="#session.subjectList" status="stat">
				<option value="<s:property value = "sid" />"><s:property
					value="sname" /></option>
			</s:iterator>
		</select></td>
	</tr>
</table>
<form id='form1' action='/hrbuedu/queryTestBaseAction!analyseTestbase.action' method='post'>
<table id='table2' border='1'>


</table>
<input type = 'hidden' value = '${error }' id = 'error'/>
<span id = 'analyse'></span>
<br/>
</form>
</div>


</body>
</html>
