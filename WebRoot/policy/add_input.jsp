<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">

<script language="javascript" src="script/public.js"></script>
<script language="javascript" src="script/policy.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/courseManager.js"></script>
<title>��Ӳ���</title>


</head>
<body onload=findcs()>
<center>
<form action="policy.do" method="post">
<input type="hidden" name="method" value="next">
<input type="hidden" name=typeQuantityMark value="">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">��Ӳ���</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" align="left">��������</td>			
		<td class="tdEditContent" align="left"><input type="text" name="name">
		<td class="tdEditLabel" align="left">���γ�</td>			
		<td class="tdEditContent" align="left" colspan=2>
		<select name=courseId id=course>
			
		</select>
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" align="left">�����Ѷ�</td>
		<td class="tdEditContent" align="left">
			<select name=difficulty>
		      			<c:forEach var="x" begin="0" end="10">
		      				<option value=${x/10 }>${x/10 }</option>
		      			</c:forEach>
		      	</select>
		</td>	
		<td class="tdEditLabel" align="left" >�������ֶ�</td>	
		<td class="tdEditContent" align="left" colspan=2>
			<select name=differentiate>
		      			<c:forEach var="x" begin="0" end="10">
		      				<option value=${x/10 }>${x/10 }</option>
		      			</c:forEach>
		      	</select>
		</td>	
	</tr>
		<tr>
		<td class="tdEditLabel" align="left">�Ծ��ܷ�</td>
		<td class="tdEditContent" align="left"><input type=text name=mark value=0 size=5 onchange="avr()"></td>	
		<td class="tdEditLabel" align="left">����ʱ��</td>
		<td class="tdEditContent" align="left" colspan=2><input type=text name=time value=0 size=5></td>	
		
	</tr>
	<tr>
		
		<td class="tdEditLabel" align="left" >������</td>	
		<td class="tdEditContent" align="left" colspan=2><input type=text name=count value=0 size=5 onchange="avr()">
		<td class="tdEditLabel"></td>
		<td class="tdEditLabel">
		</td>	
	</tr>
	
	<tr>
	<td colspan=5>ѡ������</td>
		
	</tr>
	<tr>
		
		<td>��Ŀ������</td>	
		<td id=countsum align=left>������</td>
		<td>��Ŀ������</td>
		<td id=typesum align=left>������</td>	
		<td></td>	
	</tr>
	<tr>
	      	  <td >ѡ��</td>
		      <td >����</td>
	          <td >��ֵ</td>
	          <td >����</td>
	          <td >ÿ���ֵ</td>
    </tr>
	<c:if test="${!empty pm.datas}">
         <c:forEach items="${pm.datas}"  var="type" varStatus="status">
         <input type=hidden name=id value=${type.id }>
	      <tr >
	      	  <td ><input type="checkbox" name=selecttype  onclick="select1(${status.index})"></td>
		      <td > ${type.name}</td>
	          <td id=${status.index}so></td>
	          <td id=${status.index}ty></td>
	          <td id=${status.index}tf></td>
          </tr>
        </c:forEach>
	</c:if>
	<tr>
		<td>
		<input type=button value=ȫѡ onclick="selectall()"><input type=button value="��ѡ" onclick="resetall()">
		</td>
		<td colspan=4></td>
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
							<input type="submit" name="saveButton" class="MyButton"
								value="��һ��" onmousedown="soursecount();typecount();typeStr();checkForm()">
							<input type="button" class="MyButton"
				value="ȡ�����" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>