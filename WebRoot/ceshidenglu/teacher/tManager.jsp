<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<html:base />

	<title>tManage.jsp</title>

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
	<div align="center">
		<table border="1" width="600">
			
			<tr>
				<td>
				<!-- quesRTestAction!preAuto.action -->
					<a href="/hrbuedu/jsp/teacher/autoOrg.jsp">自动组卷</a>
				</td>
				<td>
					(选择科目题型及数量，系统会随机抽取一套符合条件的试卷)
				</td>
			</tr>
			<tr>
				<td>
					<a href="/hrbuedu/jsp/teacher/showTestBase.jsp">预览试卷</a>
				</td>
				<td>
					(选择科目即可看到该科目的试卷内容、导出试卷)
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
