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
<title>添加策略</title>


</head>
<body onload=findcs()>
<center>
<form action="policy.do" method="post">
<input type="hidden" name="method" value="next">
<input type="hidden" name=typeQuantityMark value="">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">添加策略</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" align="left">策略名称</td>			
		<td class="tdEditContent" align="left"><input type="text" name="name">
		<td class="tdEditLabel" align="left">组卷课程</td>			
		<td class="tdEditContent" align="left" colspan=2>
		<select name=courseId id=course>
			
		</select>
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" align="left">整卷难度</td>
		<td class="tdEditContent" align="left">
			<select name=difficulty>
		      			<c:forEach var="x" begin="0" end="10">
		      				<option value=${x/10 }>${x/10 }</option>
		      			</c:forEach>
		      	</select>
		</td>	
		<td class="tdEditLabel" align="left" >整卷区分度</td>	
		<td class="tdEditContent" align="left" colspan=2>
			<select name=differentiate>
		      			<c:forEach var="x" begin="0" end="10">
		      				<option value=${x/10 }>${x/10 }</option>
		      			</c:forEach>
		      	</select>
		</td>	
	</tr>
		<tr>
		<td class="tdEditLabel" align="left">试卷总分</td>
		<td class="tdEditContent" align="left"><input type=text name=mark value=0 size=5 onchange="avr()"></td>	
		<td class="tdEditLabel" align="left">考试时间</td>
		<td class="tdEditContent" align="left" colspan=2><input type=text name=time value=0 size=5></td>	
		
	</tr>
	<tr>
		
		<td class="tdEditLabel" align="left" >总题量</td>	
		<td class="tdEditContent" align="left" colspan=2><input type=text name=count value=0 size=5 onchange="avr()">
		<td class="tdEditLabel"></td>
		<td class="tdEditLabel">
		</td>	
	</tr>
	
	<tr>
	<td colspan=5>选择题型</td>
		
	</tr>
	<tr>
		
		<td>题目分数：</td>	
		<td id=countsum align=left>待分配</td>
		<td>题目数量：</td>
		<td id=typesum align=left>待分配</td>	
		<td></td>	
	</tr>
	<tr>
	      	  <td >选择</td>
		      <td >题型</td>
	          <td >分值</td>
	          <td >题量</td>
	          <td >每题分值</td>
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
		<input type=button value=全选 onclick="selectall()"><input type=button value="反选" onclick="resetall()">
		</td>
		<td colspan=4></td>
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
							<input type="submit" name="saveButton" class="MyButton"
								value="下一步" onmousedown="soursecount();typecount();typeStr();checkForm()">
							<input type="button" class="MyButton"
				value="取消添加" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>