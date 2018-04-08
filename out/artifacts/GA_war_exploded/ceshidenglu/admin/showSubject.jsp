<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>showSubject.jsp</title>
 <script language="javascript" type="text/javascript"> 
 function del(id,name){
	 if(confirm("确定要删除题库 "+name+" ？")){
		 window.location.href= "/hrbuedu/subjectAction!deleteSubjectById.action?sid="+id;
		 }
         
 }

 </script>
</head>

<body>
<table border="2" width="500">
	<tr>
		<td width="60">序号</td>
		<td>名称</td>
		<td width="100">操作</td>
	</tr>
	
	<s:iterator value = "#session.subjectList" id = "subject" status = "stat" >
		<tr>
			<td>&nbsp; <s:property value = "#stat.index +1"  /></td>
			<td> <s:property value = "sname" /></td>
			<td><a
				href="javascript:del('<s:property value = 'sid'/>','<s:property value = 'sname'/>')">删除</a> 
			/ <a
				href="/hrbuedu/subjectAction!preModifySubject.action?sid=<s:property value = 'sid'/>">修改</a>

			</td>
		</tr>
	</s:iterator>
</table>
</body>
</html>
