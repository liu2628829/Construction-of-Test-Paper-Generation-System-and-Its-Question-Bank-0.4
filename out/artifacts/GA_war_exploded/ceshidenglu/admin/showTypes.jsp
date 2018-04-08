<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	

	<title>showTypes.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript" type="text/javascript"> 
	function del(id,name){
	 if(confirm("确定要删除所有"+name+"题？")){
		 window.location.href= "/hrbuedu/typesAction!deleteType.action?tid="+id;
		 }
         
 }
</script>
</head>

<body>
<form action = '/hrbuedu/jsp/admin/addType.jsp'>
<div align = 'center'> 
<input type = 'submit' value = '新增题型'/> <br/>
	<table border="2" width="300">
		<tr>
			<td>
				序号
			</td>
			<td>
				名称
			</td>
			<td>操作</td>
		</tr>
		<s:iterator value = "#session.typesList" status = "stat">
			<tr>
				<td>
					<s:property value = "#stat.index +1"  />
				</td>
				<td>
					<s:property value = "tname"/>
				</td>
				<td>
				<a
				href="javascript:del('<s:property value = 'tid'/>','<s:property value = 'tname'/>')">删除</a> 
			/ <a
				href="/hrbuedu/typesAction!selectByTid.action?tid=<s:property value = 'tid'/>">修改</a>
				</td>

			</tr>
		</s:iterator>
	</table>
	
	</div>
	
</form>
</body>

</html>
