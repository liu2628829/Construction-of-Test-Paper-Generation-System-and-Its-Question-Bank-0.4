<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>���ɹ�</title>
</head >
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<br><br><br><br><br><br><br><br><br><br>
<center>
   <font size=10 color=red>���ɹ�</font>
</center>
<br><br>
<center>
   <form action="test.do" method=post>
   	<input type=hidden name=types value=${policy.typeQuantityMark }>
   	<input type=hidden name=testQuestions value=${tqIds }>
   	<input type=hidden name=mark value=${policy.mark  }>
   	 <input type=hidden name=countTime value=${policy.time  }>
   	<input type=hidden name=method value="detail">
   	<table>
   		<tr>
   			<td>����д�Ծ�����</td>
   			<td><input type=text name=name></td>
   		</tr>
   			<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="�鿴�����Ծ�"> 
			<input type="button" class="MyButton"
				value="ȡ��" onclick="window.close()">
			</TD>	
   		</tr>
   	
   	
   	</table>
   
   
   </form>
</center>	
</body>

</html>
