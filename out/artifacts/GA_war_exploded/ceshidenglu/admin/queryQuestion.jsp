<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	

	<title>organizationQue.jsp</title>
	<script type = "text/javascript" src = "/hrbuedu/js/jquery-132min2.js"></script>
	<script type = "text/javascript" src = "/hrbuedu/js/addQuestion.js"></script>
</head>

<BODY>
	<form action="/hrbuedu/questionsAction!showQuestionsByPage.action?page=1" method="post">
		<div id = 'div1'>
		<table id = 'table1'  border = '0' >
			<tr>
				<td>
					题目所属科目：
				</td>
				<td>
					<select id="subject"  name="sid"> 
						<option value="-1" selected>
							--还未选择--
						</option>
						<s:iterator value = "#session.subjectList" status = "stat" >
							<option value="<s:property value = "sid" />">
								<s:property value = "sname" />
							</option>
						</s:iterator>
					</select>
				</td>
					
			</tr>
			<tr>
					<td>
						题目所属章节：
					</td>
					<td>
						<select id="charpter"  name="cid">
							<option value="-1" selected>
								--还未选择--
							</option>
						</select>

					</td>
			</tr>
			<tr>
				<td>
						题目所属知识点：
				</td>
				<td>
					<select  id="knowledge" name="kid">
						<option value="-1" selected>--还未选择--
						</option>
					</select>

				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="查看全部试题">
				</td>
			</tr>
		</table>
		
	</div>
         
	</form>
</BODY>
</html>
