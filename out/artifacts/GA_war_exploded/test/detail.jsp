<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>试卷</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">

<center>
	<form action="test.do" method=post>
	<input type=hidden name=types value=${TestForm.types }>
   	<input type=hidden name=testQuestions value=${TestForm.testQuestions}>
   	<input type=hidden name=mark value=${TestForm.mark  }>
   	<input type=hidden name=countTime value=${TestForm.countTime }>
   	<input type=hidden name=name value=${TestForm.name }>
	<input type="hidden" name="method" value="add">
	
  	 <table>
  	 	<tr align=center>
  	 		<td ><font size=6>${TestForm.name}</font></td>
  	 	</tr>
  	 	<tr align=center>
  	 		<td><font size=4>考试时间:${TestForm.countTime}总分:${TestForm.mark}</font></td> 
  	 	</tr>
  	 	<c:forEach items="${types}" var="ty" varStatus="statustype">
  	 		<tr><td><font size=4>第${statustype.index+1}大题:&nbsp;${ty.name }&nbsp;共${tycs[statustype.index] }题,总共${ses[statustype.index] }分,每题${ses[statustype.index]/tycs[statustype.index] }</font></td></tr>
  	 		<tr><td></td></tr>
			<%-- 计算每个题型的题目数量 --%>
			<%--
			<c:forEach>标签的items属性支持Java平台所提供的所有标准集合类型。此外，您可以使用该操作来迭代数组（包括基本类型数组）中的元素。
	  	 	--%>
	  	 	<c:forEach items="${testList}" var="tq" varStatus="status">
	  	 			<c:if test="${tq.type.id eq ty.id}">
	  	 			<tr>
	  	 				<td colspan=2><font size=4>第${status.index+1 }题:${tq.content }</font></td>
	  	 			</tr>
	  	 			</c:if>
	  	 	</c:forEach>
	  	 	<tr><td></td></tr>
  	 	</c:forEach>
   		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<c:if test="${zu!=1}">
			<input type="submit" name="saveButton"
				class="MyButton" value="保存试卷"> 
			</c:if>
			<input type="button" class="MyButton"
				value="返回" onclick="window.close()">
			</TD>	
   		</tr>
  	 	
  	 </table>
   	</form>
</center>
	
</body>

</html>
