<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<title>addKnowledge.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type = "text/javascript" src = "/hrbuedu/js/jquery-132min2.js"></script>
	<script type = "text/javascript" src = "/hrbuedu/js/addKnowledge.js"></script>
</head>



<body>
	<form action="/#" method="post" onsubmit="return checkonSubmit()">
		<div align = 'center'>
		<table>
		<tr>
			<td>所属题库：</td>
			<td>
			<select id="subject"  name = "subjectId">
			
			<s:iterator value = "#session.subjectList" status = "stat">
					<option value = "<s:property value = "sid"/>" > 
						<s:property value = "sname"/>
					</option>
				</s:iterator>
		</select>
			</td>
		</tr>
		<tr>
			<td>
			所属章节：
			</td>
			<td>
				<select id="charpater" name="chpt">
				
				</select>
			</td>
		</tr>
		<tr>
			<td>
			增加知识点：
			</td>
			<td>
			<input type="text" name="name" id="knowledge">
			</td>
		</tr>
		</table>
		<input type="button" id = 'sub' value="新增知识点"><br/>
		<span id = 'span1'></span><br/>
		
		</div>
		
		<div id = 'div3' align = 'center' style="display:none">
			<table border = '1'  id = 'table2'>
				<tr>
				<th>编号</th><th>名称</th><th>操作</th>
				</tr>
			</table>
		</div>
		
		<div align="center" id = "div1" style="display:none">
<br/><hr></hr><br/>
知识点编号：<input type = 'text' id = 'kid1' readonly /><br/>
 知识点名称：<input type = 'text' id = 'kname1'/><br></br>
 <input type = 'button' id = 'modify1' value = '修改' />

</div>
<div align="center" id = "div2"  style='color:red;' ></div>
		
	</form>
</body>
</html>
