<%@ page language="java" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>suc.jsp</title>

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
<font color="red" size="20">组卷成功！！</font>
<br>
该试卷所选试题的
<br>
<font size="5">难度误差 为：${diff_distribute_error} <br>
知识点分布误差 为：${bestrow_error} <br>
适应度 为${fitness} <br />
组卷所用时间约为：${runTime }秒</font>
<br>
</body>
</html>
