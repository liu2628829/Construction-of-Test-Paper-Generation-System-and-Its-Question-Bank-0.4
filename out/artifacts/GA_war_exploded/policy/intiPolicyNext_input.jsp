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
<title>��Ӳ���</title>

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
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">ѡ��֪ʶ��</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:780px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >��������</td>			
		<td class="tdEditContent"><input type="text" name="name" value=${PolicyForm.name }>	</td>		
		<td class="tdEditLabel" >�γ�����</td>			
		<td class="tdEditContent">${course.name}</td>		
	</tr>
	<tr>
		<td colspan=4>֪ʶ�ṹѡ��</td>			
	</tr>
	<tr>
		<td class="tdEditLabel" >�µ�����</td>				
		<td class="tdEditLabel" >�ڵ�����</td>			
		<td class="tdEditLabel" >֪ʶ��</td>
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
	          <td class="tdEditLabel"><input type=checkbox name=cp onclick="selectcp(${statusCp.index})">��</td>
          </tr>
          <c:forEach items="${chapter.children}"  var="section" varStatus="statusSe">
          		 <input type=hidden name=${statusCp.index}seid value=${section.id}>
	             <tr>
			      	<td class="tdEditLabel"></td>
		          	<td class="tdEditLabel">${section.name}</td>
		          	<td class="tdEditLabel"></td>
		          	<td class="tdEditLabel"><input type=checkbox name=${statusCp.index}se id="${statusCp.index}${statusSe.index}se" onclick="selectse(${statusCp.index},${statusSe.index})" >��</td>
	         	 </tr>
          		 <c:forEach items="${section.children}"  var="knowledgePoint" varStatus="statusKp">
		             <input type=hidden name=${statusCp.index}${statusSe.index}kpid value=${knowledgePoint.id}>
		             <tr>
				        <td class="tdEditLabel"></td>
				        <td class="tdEditLabel"></td>
				        <td class="tdEditLabel">${knowledgePoint.name }</td>
			          	<td class="tdEditLabel"><input type=checkbox name=${statusCp.index}${statusSe.index}kp id=${statusCp.index}${statusSe.index}${statusKp.index}kp onclick="selectkp(${statusCp.index},${statusSe.index},${statusKp.index})">��</td>
		          	 </tr>
		          </c:forEach>
          </c:forEach>
       </c:forEach>
      </c:if>

</table>

			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="��һ��" onmousedown="checkratio();skipall()"> 
			<input type="button" class="MyButton"
				value="ȡ�����" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>