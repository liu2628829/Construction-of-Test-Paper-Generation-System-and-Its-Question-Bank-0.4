<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Charpter</title>
		
		<script type="text/javascript" src="js/jquery-132min2.js"></script>
		<script type="text/javascript" src="js/addCharpter.js"></script>
	</head>
	<script type="text/javascript">
	function checkOnSubmit(){
		var name =document.getElementById("s_id");
		var charpterName = document.getElementById("cname").value;
		if(name.value=="-1"){
			alert("请选择所属科目！");
			return false;
		}
		
		if(charpterName == ""){
			alert("章节名不能为空！");
			return false;
		}
	}
</script>
	<body>
	<form action = "charpterAction!insertCharpter.action" method = "post" onsubmit = " return checkOnSubmit()">
	<div align="center"><font size=6 >增加章节</font></div><br><br>
		
			请输入章节：
			<input type="text" name="cname" id="cname">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			所属科目：
			<select name="s_id" id="s_id" >
				<option value = "-1"> --选择科目--</option>
				<s:iterator value = "#session.subjectList" status = "stat">
					<option value = "<s:property value = "sid"/>" > 
						<s:property value = "sname"/>
					</option>
				</s:iterator>
			</select>
			
			<br>
			<br>
			<input id="addcharpter" type="submit" value="增加章节"/>
		
</form>
	</body>
</html>
