<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>addQuestion.jsp</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type = "text/javascript" src = "/hrbuedu/js/jquery-132min2.js"></script>
	<script type = "text/javascript" src = "/hrbuedu/js/addQuestion.js"></script>
	
	<script type="text/javascript" src="ueditor/editor_config.js"></script>
	<script type="text/javascript" src="ueditor/editor_all.js"></script>
	<link rel="stylesheet" href="ueditor/themes/default/ueditor.css"/>
</head>

<script>
    var num=0;
	function rem(i){
		var oDiv=document.getElementById("myDiv");
		var text =document.getElementById("text"+i);
		var but=document.getElementById("but"+i);
		var br=document.getElementById("br"+i);
		var checkbox=document.getElementById("checkbox"+i);
		oDiv.removeChild(text);
		oDiv.removeChild(but);
		oDiv.removeChild(checkbox);
		oDiv.removeChild(br);
	}
  
 function addB(){
	  var oDiv=document.getElementById("myDiv");
	  var br=document.createElement("br");
	  br.setAttribute("id","br"+num);
	  
	 
	  oDiv.innerHTML+="<input type='text' id=text"+num+" name ='answers'>";
	  
	   oDiv.innerHTML+="<input type='checkbox' id=checkbox"+num+" name ='just"+num+"'value='1'/>";
	  oDiv.innerHTML+="<input type='button' id=but"+num+" name ='bb' value ='删除本条答案' onClick='rem("+num+")'>";
	num++;
     // oDiv.innerHTML=oDiv.innerHTML+"sss"
      oDiv.appendChild(br);
   }
  function checkOnSubmit(){
  	var type=document.getElementById("t_type");
  	var subject=document.getElementById("subject");
  	var charapter=document.getElementById("charpter");
  	var knowdge=document.getElementById("knowledge");
  	if(type.value=="-1"){
  		alert("请选择题型");
  			return false;
  	}
  	if(subject.value=="-1"){
  		alert("请选择题库");
  			return false;
  	}
  	if(charapter.value=="-1"){
  		alert("请选择章节");
  			return false;
  	}
  	if(knowdge.value=="-1"){
  		alert("请选择知识点");
  			return false;
  	}
  	return true;
  }

</script>


<body>

	<form id="form1" action="/hrbuedu/questionsAction!insertQuestion.action" method="post" onsubmit="return checkOnSubmit() ">
		<div > 
			<table>
				<tr>
					<td width="130">
						题目类型：
					</td>
					<td>
						<select name="tid" id="t_type">
							<option value="-1" selected>
							  --还未选择--
							</option>
							<s:iterator value = "#session.typesList"  status = "stat" >
								<option value=" <s:property value = "tid"  />">
									<s:property value = "tname" />
								</option>
							</s:iterator>
						</select>

					</td>
				</tr>

				<tr>
					<td>
						题目所属题库：
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
						<select name="kid" id="knowledge">
							<option value="-1" selected>--还未选择--
							</option>
						</select>

					</td>
				</tr>
				<!--  <tr>
					<td>
						试题分数：
					</td>
					<td>
						<input type="text" name="qscore"  value  = '2' />
					</td>
				</tr>
				-->
				<tr>
					<td>
						题目内容:
					</td>
					<td>
						<div>
							<script type="text/plain" id="qContent">欢迎使用自动组卷系统</script>
							<script type="text/javascript">
							    var editor = new baidu.editor.ui.Editor({
							        textarea:'qtext'
							    });
							    editor.render("qContent");
							</script>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>
						答案内容:
					</td>
					<td>
						<table>
							<tr>
								<td>
									<div id="myDiv">
										<div id = "selectDiv" style ="display:none" >
											<div id = "selectSpan"  >
													 <input type = "text" name = "answerText"/><input type = "checkbox" name = "answerText" value = 'thisMeanRightAnswerYouKnowFuck'>
												<br/><input type = "text" name = "answerText"/><input type = "checkbox" name = "answerText" value = 'thisMeanRightAnswerYouKnowFuck'></input>
												<br/><input type = "text" name = "answerText"/><input type = "checkbox" name = "answerText" value = 'thisMeanRightAnswerYouKnowFuck'></input>
												<br/><input type = "text" name = "answerText"/><input type = "checkbox" name = "answerText" value = 'thisMeanRightAnswerYouKnowFuck'></input>
											</div>
											<div style="color:rgb(255, 0, 0);">是正确答案请勾选</div>
											<div id = "buttonSpan" >
												<input type="button" id = "newAnswer" name="but" value="增加答案"  />
											</div>
										</div>
										<div id = 'judgeDiv' style ="display:none" >
											<div id = "judgeSpan"  >
													 对<input type = "radio" name = "judgeAnswer" value = '1' checked>
												<br/>错<input type = "radio" name = "judgeAnswer" value = '0'></input>
												
											</div>
										</div>
										
										
										
										<div id = "notSelectDiv" style ="display:none" >
											<span id = "notSelectSpan">
												<textarea id = "qtextarea" name = "ptAnswer" rows="10" cols="30"></textarea>
												
												<a id = "higherAnswerLink"><span style="text-decoration:underline; color:rgb(0, 85, 255); ">切换高级答案编辑</span></a>
											</span>
										
										 <span id = "higherAnswer" style = "display:none">
												<script type="text/plain" id="qContentAnswer"></script>
												<script type="text/javascript">
												    var editor = new baidu.editor.ui.Editor({
												        textarea:'qAnswer'
												    });
												    editor.render("qContentAnswer");
												</script>
												<a id = "ptAnswerLink" ><span style="text-decoration:underline; color:rgb(0, 85, 255); ">切换普通答案编辑</span></a>
											</span>
											
											
										</div>
										
									</div>
									
									
								</td>
							</tr>

						</table>

					</td>
				</tr>

				<tr>
					<td>
						难度等级:
					</td>
					<td>
						
						<select name = 'qdifficult'>
						<option value = '1'>易</option>
						<option value = '2'selected>中</option>
						<option value = '3'>难</option>
						</select>
					</td>
				</tr>
			</table>
			<hr color="blue">
			<input type="submit" value="录入试题">
			
			<div style="visibility:hidden" >
				<input type="text" name="qmaxexposure" value="10" />
				<br/><input type="text" name="qexposed" value="0" />
				<br/><input type="text" name="qtime" value="2" />
				<br/><input type="text" name="remark" value="0" />
				<br/><input type = 'text' id = 'flg' name = 'flg' />
			</div>
			
		</div>
	</form>



</body>
</html>
