<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/script/addInput.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>添加答案</title>
<script type="text/javascript">
function closewindow(){
	if(window.opener){
		window.opener.location.reload(true);
		window.close();
	}
}

function checkall(){
	
	document.getElementById("result").value=eWebEditor1.getHTML();
	//alert(document.getElementById("result").value);
	if(document.getElementById("result").value==0){
		alert("答案内容不能为空");
	}
}

</script>
</head>
<body>
<center>
<form action="testQuestion.do" method="post">
<input type="hidden" name="id" value="${testQuestion.id }">
<input type="hidden" name="method" value="update">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">添加答案</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
<table class="tableEdit" style="width:780px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td  Colspan=6><font color=red size=5>试题内容</font></td>						
	</tr>
		<TD Colspan=6>
			${testQuestion.content}
	    </TD>						
	<tr>
		<td  Colspan=6><font color=red size=5>答案内容</font></td>						
	</tr>
	
	<tr>
		<TD Colspan=6>
		<INPUT type="hidden" name="aa" id="aa">
		<INPUT type="hidden" name="result" id="result">
	
		<IFRAME ID="eWebEditor1" src="eWebEditor/eWebEditor.jsp?id=aa&style=standard" frameborder="0" scrolling="no" width="800" height="350"></IFRAME>
	    </TD>						
	</tr>
	
	

	
	
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
				class="MyButton" value="添加答案"  onmousedown="checkall()"> 
			<input type="button" class="MyButton"
				value="暂不添加答案" onclick="closewindow()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>