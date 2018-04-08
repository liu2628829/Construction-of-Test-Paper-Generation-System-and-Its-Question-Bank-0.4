<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<title>upSubject.jsp</title>

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
	<form action="/hrbuedu/charpterAction!modifyCharpter.action" method="post">

		<input type = "hidden" name = "cid" value = <s:property value = "#request.cvo.cid"/> />
		请输入你要改的章节新名称：
		<input type="text" name="cname" value="<s:property value = "#request.cvo.cname"/>">
		<input type="submit" value="提交">
	</form>

</body>
</html>
