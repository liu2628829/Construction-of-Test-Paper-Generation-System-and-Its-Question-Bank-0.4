<%@ page language="java" contentType="text/html; charset=GB18030"
		 pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<link href="style/ga.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/public.js"></script>
	<title>��������</title>
	<!-- ��������    ������  detail  -->
</head>
<body>
<center>
	<form action="testQuestion.do" method="post">
		<input type="hidden" name="method" value="add">
		<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
			<TBODY>
			<TR>
				<!-- ��������ӡ��༭����ı��� -->
				<td align="center" class="tdEditTitle">��������</TD>
			</TR>
			<TR>
				<td>
					<!-- ��������ʼ -->
					<table class="tableEdit" style="width:780px;" cellspacing="0" border="0" cellpadding="0">

						<tr>
							<td class="tdEditLabel" >�γ̣�</td>
							<td class="tdEditLabel" align=left>${testQuestion.course.name }</td>
							<td class="tdEditLabel" >�£�</td>
							<td class="tdEditLabel">${testQuestion.chapter.name }</td>
							<td class="tdEditLabel" >С�ڣ�</td>
							<td class="tdEditLabel">${testQuestion.section.name }</td>
						</tr>

						<tr>
							<td class="tdEditLabel" Colspan=1 >֪ʶ��</td>
							<td class="tdEditContent">${testQuestion.knowledgePoint.name }</td>
							<td class="tdEditLabel" Colspan=1 >��������</td>
							<td class="tdEditContent">${testQuestion.type.name }</td>
							<td class="tdEditLabel" >�Ѷ�</td>
							<td class="tdEditContent">${testQuestion.difficulty }</td>
						</tr>

						<tr>
							<td class="tdEditLabel" >���ֶ�</td>
							<td class="tdEditContent">${testQuestion.differentiate}</td>
							<td class="tdEditLabel" >�ع����</td>
							<td class="tdEditContent">${testQuestion.count}</td>
							<td class="tdEditLabel"  >����ʱ��</td>
							<td class="tdEditContent">${testQuestion.adviceTime}</td>
						</tr>
						<tr>
							<td class="tdEditLabel" >������ʱ��</td>
							<td class="tdEditContent">${testQuestion.lateTime}</td>
							<td class="tdEditLabel" ></td>
							<td class="tdEditContent"></td>
							<td class="tdEditLabel"  ></td>
							<td class="tdEditContent"></td>
						</tr>
						<tr>
							<td class="tdEditLabel" Colspan=6 Rowspan=1 ></td>
						</tr>

						<tr>
							<td  Colspan=6><font color=red size=5>��������</font></td>
						</tr>

						<tr>
							<TD Colspan=6>
								${testQuestion.content}
							</TD>
						</tr>
						<tr>
							<TD Colspan=6 class="tdEditLabel"></TD>
						</tr>
						<tr>
							<td  Colspan=6><font color=red size=5>�����</font></td>
						</tr>
						<tr>
							<TD Colspan=6>
								<c:if test="${empty(testQuestion.result)}">
									�����޴�
									<a href="#" onclick="openWin('testQuestion.do?id=${testQuestion.id}&method=addResultInput','addSection',600,200);">��Ӵ�</a>
								</c:if>
								<c:if test="${!empty(testQuestion.result)}">
									${testQuestion.result }
								</c:if>
							</TD>
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
					<input type="button" class="MyButton"
						   value="����" onclick="window.close()">

				</TD>
			</TR>
		</TABLE>
	</form>
</center>
</body>
</html>