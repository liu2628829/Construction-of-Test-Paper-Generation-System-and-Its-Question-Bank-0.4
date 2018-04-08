<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
	<head>
		<title>page</title>
	</head>
	
	<script type = "text/javascript" src = "/hrbuedu/js/jquery-132min2.js"></script>
	<script type = "text/javascript" src = "/hrbuedu/js/showQuestions.js"></script>
	<body>

	
	<div id = 'div1' >
		<!-- style = "display:none" width="400" width="95%"-->

<table width="100%" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>序号</th>
			<th>题目名称</th>
			<th>试题难度</th>
			<th>知识点</th>
			<th>章 节</th>
			<th>科 目</th>
		 	<!-- <th width="80px" nowrap>操 作</th>  -->
		</tr>
	</thead>
	<s:iterator value="#request.pageResultSet.list" id='q' status="stat">
		<tr>
			<td><s:property
				value="(#request.pageResultSet.pageInfo.currentPage-1)*10+#stat.index +1" /></td>
			<td><s:property value="#q.qtext" escape="false" /></td>
			
			<td>
			<s:if test="#q.qdifficult == 1">易</s:if>
			<s:if test="#q.qdifficult == 2">中</s:if>
			<s:if test="#q.qdifficult == 3">难</s:if>
			</td>
			
			<td><s:property value="#q.kname" /></td>
			<td><s:property value="#q.cname" /></td>
			<td><s:property value="#q.sname" /></td>
	<!--   <td><a href="#?id=<s:property value="#q.qid" />">修改</a>&nbsp;<a  href="#?id=<s:property value="#q.qid" />">删除</a></td></tr> -->
	</s:iterator>
		
		
	

</table>
<br/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">页码:&nbsp;&nbsp;<s:property
					value="#request.pageResultSet.pageInfo.currentPage" />&nbsp;/&nbsp;
				<s:property value="#request.pageResultSet.pageInfo.totalPage" />&nbsp;&nbsp;&nbsp;
				<s:if test="#request.pageResultSet.pageInfo.bof">
	        			首页    第一页
	        		</s:if> <s:else>
					<a
						href="/hrbuedu/questionsAction!showQuestionsByPage.action?page=1">首页</a>
					<a
						href="/hrbuedu/questionsAction!showQuestionsByPage.action?page=<s:property value="#request.pageResultSet.pageInfo.currentPage-1"/>">上一页</a>
				</s:else> <s:if test="#request.pageResultSet.pageInfo.eof">
						下一页   末页
					</s:if> <s:else>
					<a
						href="/hrbuedu/questionsAction!showQuestionsByPage.action?page=<s:property value="#request.pageResultSet.pageInfo.currentPage+1"/>">下一页</a>
					<a
						href="/hrbuedu/questionsAction!showQuestionsByPage.action?page=<s:property value="#request.pageResultSet.pageInfo.totalPage"/>">末页</a>
				</s:else></td>
			</tr>
		</table>

	</div>
		<br/>
		<br/>
	
	</body>

</html>
