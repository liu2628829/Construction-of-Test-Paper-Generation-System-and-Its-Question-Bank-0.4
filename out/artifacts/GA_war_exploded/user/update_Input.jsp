<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<script>
 function se(){
    document.getElementById("pm").value=document.getElementById("select").options[document.getElementById("select").selectedIndex].value;   
  }   
  
  function ob(){
  	document.getElementById("select").selectedIndex=${user.popedom}; 
  }
</script>
<title>����û�</title>
</head>
<body onload="ob()">
<center>
<form action="user.do" method="post">
<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="${UserForm.id }">
<input type="hidden" name="popedom" id=pm value="${user.popedom }">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">����û�</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel">�û��ƺ�</td>			
		<td class="tdEditContent">
		<input type="text" name="name" value=${user.name }>
		</td>
		<td class="tdEditLabel">�û���</td>			
		<td class="tdEditContent">
		<input type="text" name="userName" value=${user.userName }>
		</td>		
	</tr>
	<tr>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent">
		<input type="text" name="password" value=${user.password }>
		</td>	
		<td class="tdEditLabel" >�û�Ȩ��</td>			
		<td class="tdEditContent">
			<select id=select onchange="se()">
				<option value="0">��ͨ�û�</option>
				<option value="1">ר���û�</option>
				<option value="2">ϵͳ����Ա</option>
			</select>
		</td>	
	</tr>

	
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
				class="MyButton" value="�����û�"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>