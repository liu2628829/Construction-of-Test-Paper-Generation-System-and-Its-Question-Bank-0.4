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
<title>策略详情</title>


</head>
<body >
<center>
<form action="policy.do" method="post">
<input type="hidden" name="method" value="next">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">策略详情</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="2" cellpadding="0">
	<tr>
		<td class="tdEditLabel" align="left">策略名称:</td>			
		<td class="tdEditContent" align="left">${policy.name}
		<td class="tdEditLabel" align="left">组卷课程:</td>			
		<td class="tdEditContent" align="left" colspan=2>${policy.course.name }
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" align="left">整卷难度</td>
		<td class="tdEditContent" align="left">${policy.difficulty}</td>	
		<td class="tdEditLabel" align="left" >整卷区分度</td>	
		<td class="tdEditContent" align="left" colspan=2>${policy.differentiate}
			
		</td>	
	</tr>
		
	<tr>
		<td class="tdEditLabel" align="left">试卷总分</td>
		<td class="tdEditContent" align="left">${policy.mark }</td>	
		<td class="tdEditLabel" align="left" >总题量</td>	
		<td class="tdEditContent" align="left" colspan=2>${policy.count }
			
		</td>	
	</tr>
	<tr>
		<td class="tdEditLabel" align="left">考试时间</td>
		<td class="tdEditContent" align="left">${policy.time }</td>	
		<td class="tdEditLabel" align="left" >组卷用户</td>	
		<td class="tdEditContent" align="left" colspan=2>${user.name }</td>	
	</tr>
	
	<tr>
		<td class="tdEditLabel" align="left">整卷曝光度</td>
		<td class="tdEditContent" align="left">${policy.exposure}</td>	
		<td class="tdEditLabel" align="left" ></td>	
		<td class="tdEditContent" align="left" colspan=2>
			
		</td>	
	</tr>
	
	<tr>
		<td colspan=5><font color=red>考查知识结构</font></td>
	</tr>
		<c:forEach items="${chapters}"  var="chapter" varStatus="status">
			<tr>
				<td class="tdEditLabel" colspan=5>${chapter.name}[${ra[status.index] }%]</td>
			</tr>
			<c:forEach items="${sections}"  var="section">			
			<tr>
				<c:forEach items="${chapter.children}"  var="sectionc">
				<c:if test="${sectionc.id==section.id}">
							<td class="tdEditLabel" colspan=2>${sectionc.name}<br></td>
							<td class="tdEditLabel" colspan=3><c:forEach items="${section.children}"  var="knowledgePoint">
									<c:forEach items="${knowledgePoints}"  var="knowledgePointc">
										<c:if test="${knowledgePoint==knowledgePointc}">
											${knowledgePointc.name}<br>
										</c:if>
									</c:forEach>
							</c:forEach>
							</td>				
				</c:if>		
				</c:forEach>
			</tr>
			</c:forEach>
		</c:forEach>
	<tr>
		<td colspan=5><font color=red>考查题型</font></td>
	</tr>
	<tr>
		<td>题型</td>
		<td>题量</td>
		<td colspan=3>分值</td>
	
		<c:forEach  items="${types}" var="type"  varStatus="status">
			<tr>
			<td class="tdEditLabel" >${type.name }</td>
			<td class="tdEditLabel" >${tycs[status.index] }</td>
			<td colspan=3 class="tdEditLabel" >${ses[status.index] }</td>
		</tr>
		</c:forEach>
		
	
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