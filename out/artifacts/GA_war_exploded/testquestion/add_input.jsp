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
<title>�������</title>
	<script type="text/javascript">
function findcs(){
	    courseManager.findCoursesScript(
		function(courses){
			   DWRUtil.addOptions("courseId",[{name:'��ѡ��',id:0}],'id','name'); 
			   DWRUtil.addOptions("courseId",courses,'id','name');
			   
		}
	);
}

function findcp(){
	chapterManager.findChapterScript(
			DWRUtil.getValue("courseId"),
			function(chapters){
				DWRUtil.removeAllOptions("chapterId");
				DWRUtil.removeAllOptions("sectionId");
				DWRUtil.removeAllOptions("knowledgePointId");
				DWRUtil.addOptions("chapterId",[{name:'��ѡ��',id:0}],'id','name'); 
				DWRUtil.addOptions("sectionId",[{name:'��ѡ��',id:0}],'id','name'); 
				DWRUtil.addOptions("knowledgePointId",[{name:'��ѡ��',id:0}],'id','name'); 
				DWRUtil.addOptions("chapterId",chapters,'id','name');
			}
		);
	
}

function findsc(){
	sectionManager.findSectionScript(
			DWRUtil.getValue("chapterId"),
			function(sections){
				DWRUtil.removeAllOptions("sectionId");
				DWRUtil.removeAllOptions("knowledgePointId");
				DWRUtil.addOptions("sectionId",[{name:'��ѡ��',id:0}],'id','name'); 
				DWRUtil.addOptions("knowledgePointId",[{name:'��ѡ��',id:0}],'id','name'); 
				DWRUtil.addOptions("sectionId",sections,'id','name');
			}
		);
	
}

function findkp(){
	knowledgePointManager.findKnowledgePointScript(
			DWRUtil.getValue("sectionId"),
			function(sections){
				DWRUtil.removeAllOptions("knowledgePointId");
				DWRUtil.addOptions("knowledgePointId",[{name:'��ѡ��',id:0}],'id','name'); 
				DWRUtil.addOptions("knowledgePointId",sections,'id','name');
			}
		);
	
}

function findtype(){
	typeManager.getScriptTypes(
			function(types){
				//alert(types);
				 DWRUtil.addOptions("typeId",[{name:'��ѡ��',id:0}],'id','name'); 
				DWRUtil.addOptions("typeId",types,'id','name');
			}
		);
	
}

function checkall(){
	document.getElementById("content").value=eWebEditor1.getHTML();
	if(document.getElementById("courseId").value==0){
		alert("��ѡ��γ�");
	}else if(document.getElementById("chapterId").value==0){
		alert("��ѡ����");
	}else if(document.getElementById("sectionId").value==0){
		alert("��ѡ��С��");
	}else if(document.getElementById("knowledgePointId").value==0){
		alert("��ѡ��֪ʶ��");
	}else if(document.getElementById("typeId").value==0){
		alert("��ѡ������");
	}else if(document.getElementById("difficulty").value==0.0){
		alert("�ѶȲ���Ϊ0");
	}else if(document.getElementById("differentiate").value==0.0){
		alert("���ֶȲ���Ϊ0");
	}else if(document.getElementById("content").value==""){
		alert("�������ݲ���Ϊ��");
	}
}

</script>
</head>
<body onload="findcs();findtype()">
<center>
<form action="testQuestion.do" method="post">
<input type="hidden" name="method" value="add">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">�������</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:780px;" cellspacing="0" border="0" cellpadding="0">
	
	<tr>
		<td class="tdEditLabel" >�γ�</td>			
		<td class="tdEditContent">  
						<select name="courseId" id=courseId onchange="findcp()">
                        </select>
		</td>
		<td class="tdEditLabel" >��</td>	
		<td class="tdEditContent">  
						<select name="chapterId" id=chapterId onchange="findsc()">
                          <option selected="selected" value="0">��ѡ��</option>
                        </select>
		</td>
		<td class="tdEditLabel" >С��</td>	
		<td class="tdEditContent">  
						<select name="sectionId" id=sectionId onchange="findkp()"> 
                          <option selected="selected" value="0">��ѡ��</option>
                        </select>
		</td>		
	</tr>
	
	<tr>
		<td class="tdEditLabel" Colspan=1 >֪ʶ��</td>	
		<td class="tdEditContent">  
						<select name="knowledgePointId" id=knowledgePointId>
                          <option selected="selected" value="0">��ѡ��</option>
                        </select>
		</td>
		<td class="tdEditLabel" Colspan=1 >��������</td>	
		<td class="tdEditContent">  
						<select name="typeId" id=typeId>
                        </select>
		</td>
		
		<td class="tdEditLabel" >�Ѷ�</td>			
		<td class="tdEditContent">
				<select name=difficulty id=difficulty>
		      			<c:forEach var="x" begin="0" end="10">
		      				<option value=${x/10 }>${x/10}</option>
		      			</c:forEach>
		      	</select>
		</td>				
	</tr>
	
	<tr>
		<td class="tdEditLabel" >���ֶ�</td>			
		<td class="tdEditContent">
			<select name=differentiate id=differentiate>
		      			<c:forEach var="x" begin="0" end="10">
		      				<option value=${x/10 }>${x/10}</option>
		      			</c:forEach>
		      	</select>
		</td>
		<td class="tdEditLabel"  >����ʱ��</td>			
		<td class="tdEditContent">
		<input type="text" name="adviceTime" size=5>��
		</td>
		<td class="tdEditLabel"  ></td>			
		<td class="tdEditContent">
		</td>					
	</tr>
	<tr>
		<td class="tdEditLabel" Colspan=6 Rowspan=1 ></td>						
	</tr>
	<tr>
		<td class="tdEditLabel" Colspan=6 Rowspan=1 ></td>						
	</tr>
	
	<tr>
		<td  Colspan=6><font color=red size=10>��������</font></td>						
	</tr>
	
	<tr>
		<TD Colspan=6>
		<INPUT type="hidden" name="aa" id="aa">
		<INPUT type="hidden" name="content" id="content">
		<IFRAME ID="eWebEditor1" src="eWebEditor/eWebEditor.jsp?id=aa&style=standard" frameborder="0" scrolling="no" width="800" height="350"></IFRAME>
	    </TD>						
</table>

			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="��������"  onmousedown="checkall()"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>