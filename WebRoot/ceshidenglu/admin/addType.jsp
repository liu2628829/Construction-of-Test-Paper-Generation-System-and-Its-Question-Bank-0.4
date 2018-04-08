<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Type</title>
</head>
<script type="text/javascript">
	function checkOnSubmit(){
		var name=document.getElementById("typeName");
		if(name.value==""){
			alert("题型不能为空");
		return false;}
	}
</script>
<body>
  <form action="/hrbuedu/typesAction!insertTypes.action" method="post" onsubmit=" return checkOnSubmit()">
   		
   		<div align = 'center'>
		<table >
		<tr>
			<td>新增试题类型：</td>
			<td ><input type="text" name="name" id="typeName" ></td>
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
		
		<input type="submit" value="保存">
		</div>
    </form>
</body>
</html>