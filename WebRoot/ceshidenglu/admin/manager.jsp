<%@ page language="java" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


	<title>manage.jsp</title>

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

		<table width="601" border="1" height="241">
			<tr>
				<td>
					试题管理
				</td>
				<td>
					新增与查询试题
				</td>
				<td>
					<a href="/hrbuedu/jsp/admin/addQuestion.jsp">新增试题</a>/
					<a href="/hrbuedu/questionsAction!showQuestionsByPage.action">查看全部试题</a>
				</td>
			</tr>
			<tr>
				<td>
					题库管理
				</td>
				<td>
					新增、修改、删除题库
				</td>
				<td>
					<a href="/hrbuedu/jsp/admin/addSubject.jsp"> 新增题库</a> /
					<a href="/hrbuedu/subjectAction!selectAllSubjects.action">题库操作</a>
				</td>
			</tr>
			<tr>
				<td>
					章节管理
				</td>
				<td>
					新增、修改、删除章节
				</td>
				<td>
					<a href="/hrbuedu/jsp/admin/showCharpter.jsp">章节管理</a>
					
				</td>
			</tr>
			<tr>
				<td>
					知识点管理
				</td>
				<td>
					新增、修改、删除知识点
				</td>
				<td>
					<a href="/hrbuedu/jsp/admin/addKnowledge.jsp">知识点管理</a> 
					
				</td>
			</tr>
			<tr>
				<td>
					管理题型
				</td>
				<td>
					查看题型
				</td>
				<td>
				<!--  	<a href="/hrbuedu/jsp/admin/addType.jsp"> 新增题型</a> /-->
					<a href="/hrbuedu/typesAction!selectAllTypes.action">题型管理</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
