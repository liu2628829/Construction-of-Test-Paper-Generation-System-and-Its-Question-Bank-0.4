<%@ page language="java" contentType="text/html; charset=GB18030"
		 pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>

<html>
<head>
	<%@include file="/script/addInput.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<link href="style/ga.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/public.js"></script>
	<script language="javascript" src="script/findQuestion.js"></script>
	<title>�������</title>
	<script type="text/javascript">
        function findTestQuestion(){
            var course = document.getElementById("courseId").value;
            var chapter = document.getElementById("chapterId").value;
            var section = document.getElementById("sectionId").value;
            var knowledgePoint=document.getElementById("knowledgePointId").value;
            document.getElementById("show").innerHTML="<A href=testQuestion.do?courseId="+course+
                "&chapterId="+chapter+
                "&sectionId="+section+
                "&knowledgePointId="+knowledgePoint+
                ">�鿴��ѡ����</A>";
        }
	</script>

</head>
<body bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0" onload="findcs()">
<center>
	<TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
		<TBODY>
		<TR height=35>
			<TD align=middle width=20 background=images/title_left.gif
				bgColor=#dee7ff></TD>
			<TD align=middle width=120 background=images/title_left.gif
				bgColor=#dee7ff><FONT color=#f7f7f7> �������<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
			<TD align=middle width=11 background=images/title_middle.gif
				bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
			<TD align=middle background=images/title_right.gif
				bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
		<TBODY>

		<TR>
			<TD height=14 align=right vAlign=center colspan="7" noWrap>
			</TD>
		</TR>

		<TR>
			<TD height=14 align=right vAlign=center noWrap>�γ�
			</TD>
			<TD height=14 align=left vAlign=center noWrap>
				<select id=courseId onchange="findcp();findTestQuestion()">

				</select>
			</TD>
			<TD height=14 align=right vAlign=center noWrap>��
			</TD>
			<TD height=14 align=left vAlign=center noWrap>
				<select id="chapterId" onchange="findsc();findTestQuestion()">
					<option value=0>���е���</option>
				</select>
			</TD>
			<TD height=14 align=right vAlign=center noWrap>��
			</TD>
			<TD height=14 align=left vAlign=center noWrap>
				<select id="sectionId" onchange="findkp();findTestQuestion()">
					<option value=0>����С��</option>
				</select>
			</TD>
			<TD height=14 align=right vAlign=center noWrap>֪ʶ��
			</TD>
			<TD height=14 align=left vAlign=center noWrap>
				<select id=knowledgePointId onchange="findTestQuestion()">
					<option value=0 >����֪ʶ��</option>
				</select>
			</TD>
			<TD height=14 align=right vAlign=center noWrap id="show">
				<A href=testQuestion.do?courseId=0&chapterId=0&sectionId=0&knowledgePointId=0>�鿴��ѡ����</A>
			</TD>
			<TD height=14 align="right" vAlign=center  noWrap>
				<a href="#" onclick="openWin('testQuestion.do?method=addInput','addtestQuestion',600,200);">�������</a>
			</TD>
		</TR>

		<TR>
			<TD height=28 colspan="10" align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
				<!-- ��������������ҳ������ -->
			</TD>
		</TR>
		</TBODY>
	</TABLE>
	<table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
		<!-- �б������ -->
		<tr bgcolor="#EFF3F7" class="TableBody1">
			<td width="5%" height="37" align="center"><b>������</b></td>
			<td width="10%" height="37" align="center"><B>��������</B></td>
			<td width="10%" height="37" align="center"><b>�γ�</b></td>
			<td width="10%" height="37" align="center"><b>��</b></td>
			<td width="10%" height="37" align="center"><b>��</b></td>
			<td width="10%" height="37" align="center"><b>֪ʶ��</b></td>
			<td width="10%" height="37" align="center"><b>״̬</b></td>
			<td width="30%" height="37" align="center"><b>��ز���</b></td>
		</tr>
		<!-- �б������� -->
		<c:if test="${!empty pm.datas}">
			<c:forEach items="${pm.datas }" var="testQuestion">
				<tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
					<td align="center" vAlign="center">${testQuestion.id }<br></td>
					<td align="center" vAlign="center">${testQuestion.type.name}<br></td>
					<td align="center" vAlign="center">${testQuestion.course.name}</td>
					<td align="center" vAlign="center">${testQuestion.chapter.name }</td>
					<td align="center" vAlign="center">${testQuestion.section.name }</td>
					<td align="center" vAlign="center">${testQuestion.knowledgePoint.name }</td>
					<td align="center" vAlign="center">
						<c:if test="${empty(testQuestion.result)}">
							<a href="#" onclick="openWin('testQuestion.do?id=${testQuestion.id}&method=addResultInput','addSection',600,200);">��Ӵ�</a>
						</c:if>
						<c:if test="${!empty(testQuestion.result)}">
							<c:if test="${testQuestion.state eq 1}">
								ѡ������<input type=checkBox checked onclick=chState(${testQuestion.id }) id=${testQuestion.id }>
							</c:if><c:if test="${testQuestion.state eq 0}">
							ѡ������<input type=checkBox onclick=chState(${testQuestion.id }) id=${testQuestion.id }>
						</c:if>
						</c:if>
					</td>
					<td align="center" vAlign="center">
						<a href="#" onclick="openWin('testQuestion.do?id=${testQuestion.id}&method=detail','addSection',600,200);">�鿴 </a>
						<a href="#" onclick="openWin('testQuestion.do?id=${testQuestion.id}&method=update','addSection',600,200);">����</a>
						<a href="#" onclick="del('testQuestion.do?method=del&id=${testQuestion.id }');">ɾ��</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
		<c:if test="${empty pm.datas}">
			<tr>
				<td colspan="10" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
					û���ҵ���Ӧ�ļ�¼
				</td>
			</tr>
		</c:if>
	</table>
	<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
		<TBODY>
		<TR>
			<TD height=28 align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
				<!-- ��������������ҳ������ -->
				<pg:pager url="testQuestion.do" items="${pm.total }" export="currentPageNumber=pageNumber">
					<pg:param name="courseId"/>
					<pg:param name="chapterId"/>
					<pg:param name="sectionId"/>
					<pg:param name="knowledgePointId"/>
					<pg:first>
						<a href="${pageUrl}">��ҳ</a>
					</pg:first>
					<pg:prev>
						<a href="${pageUrl }">ǰҳ</a>
					</pg:prev>
					<pg:pages>
						<c:choose>
							<c:when test="${currentPageNumber eq pageNumber }">
								<font color="red">${pageNumber }</font>
							</c:when>
							<c:otherwise>
								<a href="${pageUrl }">${pageNumber }</a>
							</c:otherwise>
						</c:choose>
					</pg:pages>
					<pg:next>
						<a href="${pageUrl }">��ҳ</a>
					</pg:next>
					<pg:last>
						<a href="${pageUrl }">βҳ</a>
					</pg:last>
				</pg:pager>
			</TD>
		</TR>
		</TBODY>
	</TABLE>
</center>


</html>
