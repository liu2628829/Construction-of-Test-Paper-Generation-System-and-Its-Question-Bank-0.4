<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>ModifyType.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<form action="/hrbuedu/typesAction!modifyTypes.action" method="post">

<input type="hidden" name="tid"
	value=<s:property value = "#request.tvo.tid"/> />
<div align='center'>
<table>
	<tr>
		<td>请输入你要改的科目新名称：</td>
		<td><input type="text" name="newName"
			value="<s:property value = "#request.tvo.tname"/>"></td>
	</tr>
	<tr>
		<td>答案样式：</td>
		<td>
		<table>
			<tr>
				<td><input name='style' type='radio' value='1' checked /></td>
				<td><img src="/hrbuedu/jsp/images/1.jpg" alt="答案有多个选项"
					width="220" height="140" align="left"></td>
				<td><input name='style' type='radio' value='4' /></td>
				<td><img src="/hrbuedu/jsp/images/4.jpg" alt="判断题" align="left">
				</td>
			</tr>
			<tr>
				<td><input name='style' type='radio' value='2' /></td>
				<td><img src="/hrbuedu/jsp/images/2.jpg" alt="编辑格式比较简单的答案"
					width="430" height="163" align="left"></td>
			</tr>
			<tr>
				<td><input name='style' type='radio' value='3' /></td>
				<td><img src="/hrbuedu/jsp/images/3.jpg" alt="编辑格式比较复杂的答案"
					align="left"></td>

			</tr>

		</table>

		</td>
	</tr>
</table>

<input type="submit" value="保存"></div>

</form>

</body>
</html>
