<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>�Ծ�</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">

<center>
	<form action="test.do" method=post>
  	 <table>
  	 	<tr align=center>
  	 		<td ><font size=6>${TestForm.name}</font></td>
  	 	</tr>
  	 	<tr align=center>
  	 		<td><font size=4>����ʱ��:${TestForm.countTime}�ܷ�:${TestForm.mark}</font></td> 
  	 	</tr>
  	 	<c:forEach items="${types}" var="ty" varStatus="statustype">
  	 		<tr><td><font size=4>��${statustype.index+1}����:&nbsp;${ty.name }&nbsp;��${tycs[statustype.index] }��,�ܹ�${ses[statustype.index] }��,ÿ��${ses[statustype.index]/tycs[statustype.index] }</font></td></tr>
  	 		<tr><td></td></tr>
	  	 	<c:forEach items="${testList}" var="tq" varStatus="status">
	  	 			<c:if test="${tq.type.id eq ty.id}">
	  	 			<tr>
	  	 				<td colspan=2><font size=4>��${status.index+1 }��:${tq.result }</font></td>
	  	 			</tr>
	  	 			</c:if>
	  	 	</c:forEach>
	  	 	<tr><td></td></tr>
  	 	</c:forEach>
   		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
				<input type="button" class="MyButton" value="����" onclick="window.close()">
			</TD>	
   		</tr>
  	 	
  	 </table>
   	</form>
</center>
	
</body>

</html>
