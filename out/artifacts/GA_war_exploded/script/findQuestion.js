function findcs(){
	    courseManager.findCoursesScript(
		function(courses){ 
			   DWRUtil.addOptions("courseId",[{name:'���пγ�',id:0}],'id','name'); 
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
				DWRUtil.addOptions("chapterId",[{name:'�����½�',id:0}],'id','name'); 
				DWRUtil.addOptions("sectionId",[{name:'����С��',id:0}],'id','name'); 
				DWRUtil.addOptions("knowledgePointId",[{name:'����֪ʶ��',id:0}],'id','name'); 
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
				DWRUtil.addOptions("sectionId",[{name:'����С��',id:0}],'id','name'); 
				DWRUtil.addOptions("knowledgePointId",[{name:'����֪ʶ��',id:0}],'id','name'); 
				DWRUtil.addOptions("sectionId",sections,'id','name');
			}
		);
	
}

function findkp(){
	knowledgePointManager.findKnowledgePointScript(
			DWRUtil.getValue("sectionId"),
			function(sections){
				DWRUtil.removeAllOptions("knowledgePointId");
				DWRUtil.addOptions("knowledgePointId",[{name:'����֪ʶ��',id:0}],'id','name'); 
				DWRUtil.addOptions("knowledgePointId",sections,'id','name');
			}
		);
	
}


function chState(id){
	//alert(id);
	var st = document.getElementById(id);
	//alert(st.checked);
	testQuestionManager.updateDwrState(Number(id),st.checked);
}


