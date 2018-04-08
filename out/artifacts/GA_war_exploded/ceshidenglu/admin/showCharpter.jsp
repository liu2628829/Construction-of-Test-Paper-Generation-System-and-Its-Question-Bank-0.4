<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>showSubject.jsp</title>

 <script type="text/javascript" src="/hrbuedu/js/jquery-132min2.js"></script>
 <script type="text/javascript" src="/hrbuedu/js/showCharpter.js"></script>
</head>

<body>

<div id = 'div3' align = 'center'>
<table >
<tr>
	<td>请选择题库：</td>
	<td>
	<select id="subject"  name="sid"> 
							
							<s:iterator value = "#session.subjectList" status = "stat" >
								<option value="<s:property value = "sid" />">
									<s:property value = "sname" />
								</option>
							</s:iterator>
						</select>
	</td>
</tr>
<tr>
	<td>章节名称：</td>
	<td><input type="text" name="name" id="cNameID"></td>
</tr>
</table>
<input id="addcharpter" type="button"  value="增加章节"/><br></br>
<span  id = 'span1'></span>
</div>

<table border="2"  align = 'center' id = 'table1'width="500">
	<tr>
		<td width='60'>序号</td>
		<td>名称</td>
		<td width='100'>操作</td>
	</tr>
	
	<s:iterator value = "#request.cList" id = "c" status = "stat" >
		<tr>
			<td>&nbsp; <s:property value = "#stat.index +1"  /></td>
			<td> <s:property value = "cname" /></td>
			<td><a href="javascript:del('<s:property value = 'cid'/>','<s:property value = 'cname'/>')">删除</a> 
			/ <a id = 'modify'
				href="/hrbuedu/charpterAction!preModifyCharpter.action?cid=<s:property value = 'cid'/>">修改</a>

			</td>
		</tr>
	</s:iterator>
	
</table>

<div align="center" id = "div1" style="display:none">
<br/><hr></hr><br/>
 章节编号：<input type = 'text' id = 'cid1' readonly /><br/>
 章节名称：<input type = 'text' id = 'cname1'/><br></br>
 <input type = 'button' id = 'modify1' value = '修改' />

</div>
<div align="center" id = "div2"  style='color:red;' ></div>
</body>
</html>
