<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<%@include file="/script/addInput.jsp" %>
<script language="javascript" src="script/public.js"></script>
<script language="javascript" src="script/next.js"></script>
<title>添加策略</title>

</head>
<body>
<center>
<form action="policy.do" method="post">
<input type="hidden" name="method" value="startTest">
<input type="hidden" name="courseId" value=${course.id }>
<input type="hidden" name=chapterIdInverse>
<input type="hidden" name=sections>
<input type="hidden" name=knowledgePointIds>

<input type="hidden" name=difficulty value=${PolicyForm.difficulty  }>
<input type="hidden" name=differentiate value=${PolicyForm.differentiate }>
<input type="hidden" name=exposure value=${PolicyForm.exposure }>
<input type="hidden" name=mark value=${PolicyForm.mark  }>
<input type="hidden" name=count value=${PolicyForm.count }>
<input type="hidden" name=typeQuantityMark value=${PolicyForm.typeQuantityMark }>
<input type="hidden" name=time value=${PolicyForm.time }>
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:780px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">选择知识点</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
<table class="tableEdit" style="width:780px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >策略名称</td>			
		<td class="tdEditContent"><input type="text" name="name" value=${PolicyForm.name }>	</td>		
		<td class="tdEditLabel" >课程名称</td>			
		<td class="tdEditContent">${course.name}</td>		
	</tr>
	<tr>
		<td colspan=4>知识结构选择</td>			
	</tr>
	<tr>
		<td class="tdEditLabel" >章的名称</td>				
		<td class="tdEditLabel" >节的名称</td>			
		<td class="tdEditLabel" >知识点</td>
		<td class="tdEditLabel" ></td>	
	</tr>
	 <c:if test="${!empty pm.datas}">
         <c:forEach items="${pm.datas}"  var="chapter" varStatus="statusCp">
	      <input type=hidden name=cpid value=${chapter.id}>
	      <tr>
		      <td class="tdEditLabel">
		      	${chapter.name }<br>
		      	<select name=radio>
		      			<c:forEach var="x" begin="0" end="100">
		      				<option value=${x }>${x }</option>
		      			</c:forEach>
		      	</select>%
               </td>
	          <td class="tdEditLabel"></td>
	          <td class="tdEditLabel"></td>
	          <td class="tdEditLabel"><input type=checkbox name=cp onclick="selectcp(${statusCp.index})">章</td>
          </tr>
          <c:forEach items="${chapter.children}"  var="section" varStatus="statusSe">
          		 <input type=hidden name=${statusCp.index}seid value=${section.id}>
	             <tr>
			      	<td class="tdEditLabel"></td>
		          	<td class="tdEditLabel">${section.name}</td>
		          	<td class="tdEditLabel"></td>
		          	<td class="tdEditLabel"><input type=checkbox name=${statusCp.index}se id="${statusCp.index}${statusSe.index}se" onclick="selectse(${statusCp.index},${statusSe.index})" >节</td>
	         	 </tr>
          		 <c:forEach items="${section.children}"  var="knowledgePoint" varStatus="statusKp">
		             <input type=hidden name=${statusCp.index}${statusSe.index}kpid value=${knowledgePoint.id}>
		             <tr>
				        <td class="tdEditLabel"></td>
				        <td class="tdEditLabel"></td>
				        <td class="tdEditLabel">${knowledgePoint.name }</td>
			          	<td class="tdEditLabel"><input type=checkbox name=${statusCp.index}${statusSe.index}kp id=${statusCp.index}${statusSe.index}${statusKp.index}kp onclick="selectkp(${statusCp.index},${statusSe.index},${statusKp.index})">点</td>
		          	 </tr>
		          </c:forEach>
          </c:forEach>
       </c:forEach>
      </c:if>

</table>

			<!-- 主输入域结束 -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="下一步" onmousedown="checkratio();skipall()"> 
			<input type="button" class="MyButton"
				value="取消添加" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>