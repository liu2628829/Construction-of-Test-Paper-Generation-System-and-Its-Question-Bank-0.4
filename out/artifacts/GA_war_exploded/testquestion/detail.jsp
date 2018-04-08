<%@ page language="java" contentType="text/html; charset=GB18030"
		 pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
	<link href="style/ga.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/public.js"></script>
	<title>试题详情</title>
	<!-- 试题详情    详情是  detail  -->
</head>
<body>
<center>
	<form action="testQuestion.do" method="post">
		<input type="hidden" name="method" value="add">
		<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
			<TBODY>
			<TR>
				<!-- 这里是添加、编辑界面的标题 -->
				<td align="center" class="tdEditTitle">试题详情</TD>
			</TR>
			<TR>
				<td>
					<!-- 主输入域开始 -->
					<table class="tableEdit" style="width:780px;" cellspacing="0" border="0" cellpadding="0">

						<tr>
							<td class="tdEditLabel" >课程：</td>
							<td class="tdEditLabel" align=left>${testQuestion.course.name }</td>
							<td class="tdEditLabel" >章：</td>
							<td class="tdEditLabel">${testQuestion.chapter.name }</td>
							<td class="tdEditLabel" >小节：</td>
							<td class="tdEditLabel">${testQuestion.section.name }</td>
						</tr>

						<tr>
							<td class="tdEditLabel" Colspan=1 >知识点</td>
							<td class="tdEditContent">${testQuestion.knowledgePoint.name }</td>
							<td class="tdEditLabel" Colspan=1 >试题类型</td>
							<td class="tdEditContent">${testQuestion.type.name }</td>
							<td class="tdEditLabel" >难度</td>
							<td class="tdEditContent">${testQuestion.difficulty }</td>
						</tr>

						<tr>
							<td class="tdEditLabel" >区分度</td>
							<td class="tdEditContent">${testQuestion.differentiate}</td>
							<td class="tdEditLabel" >曝光次数</td>
							<td class="tdEditContent">${testQuestion.count}</td>
							<td class="tdEditLabel"  >答题时间</td>
							<td class="tdEditContent">${testQuestion.adviceTime}</td>
						</tr>
						<tr>
							<td class="tdEditLabel" >最近组卷时间</td>
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
							<td  Colspan=6><font color=red size=5>试题内容</font></td>
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
							<td  Colspan=6><font color=red size=5>试题答案</font></td>
						</tr>
						<tr>
							<TD Colspan=6>
								<c:if test="${empty(testQuestion.result)}">
									此题无答案
									<a href="#" onclick="openWin('testQuestion.do?id=${testQuestion.id}&method=addResultInput','addSection',600,200);">添加答案</a>
								</c:if>
								<c:if test="${!empty(testQuestion.result)}">
									${testQuestion.result }
								</c:if>
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
					<input type="button" class="MyButton"
						   value="返回" onclick="window.close()">

				</TD>
			</TR>
		</TABLE>
	</form>
</center>
</body>
</html>