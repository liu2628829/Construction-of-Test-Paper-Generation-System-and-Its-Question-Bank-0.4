function findcs(){
	    courseManager.findCoursesScript(
		function(courses){ 
			   DWRUtil.addOptions("course",[{name:'��ѡ��γ�',id:0}],'id','name'); 
			   DWRUtil.addOptions("course",courses,'id','name');
			   
		}
	);
}


/*
 ��������Ƿ������ȷ
 * */
function soursecount(){
    var count=0;
    //getElementsByName() �����ɷ��ش���ָ�����ƵĶ���ļ���
    for(var i=0;i<document.getElementsByName("sourse").length;i++){
        if(document.getElementsByName("selecttype")[i].checked){
            count=count+Number(document.getElementsByName("sourse")[i].value);
        }
    }
    //mark��ȡ�ܷ���
    var mark=document.getElementsByName("mark")[0].value;
    //countΪ�û�����ķ���
    if(mark<count){
        alert("�������"+String(count-mark)+"��");
    }
    if(mark>count){
        alert("����"+String(mark-count)+"��δ����");
    }
}

function typecount(){
	var count=0;
	for(var i=0;i<document.getElementsByName("type").length;i++){
		if(document.getElementsByName("selecttype")[i].checked)
			count=count+Number(document.getElementsByName("type")[i].value);
	}
	var mark=document.getElementsByName("count")[0].value;
	if(mark<count){
		alert("�������"+String(count-mark)+"��");
	}
	if(mark>count){
		alert("����"+String(mark-count)+"��δ����");
	}
	
}


function avr(){
	var a; 
	for(var i=0;i<document.getElementsByName("type").length;i++){
		if(document.getElementsByName("selecttype")[i].checked){
			if(Number(document.getElementsByName("type")[i].value)==0){
				document.getElementById(i+"tf").innerHTML="ÿ���ֵ0";
			}else{
				a = Number(document.getElementsByName("sourse")[i].value)/Number(document.getElementsByName("type")[i].value);
				document.getElementById(i+"tf").innerHTML="ÿ���ֵΪ"+a;
			}
		}
	}
		
	var soursesum=0;
	for(var i=0;i<document.getElementsByName("sourse").length;i++){
		if(document.getElementsByName("selecttype")[i].checked==true){
			soursesum=soursesum+Number(document.getElementsByName("sourse")[i].value);
		}
	}
	var mark=document.getElementsByName("mark")[0].value;
	if(mark>soursesum){
		var j = mark-soursesum;
		document.getElementById("countsum").innerHTML="����"+j+"��δ����";
	}
	if(mark<soursesum){
		var j =soursesum-mark;
		document.getElementById("countsum").innerHTML="�������"+j+"��";
	}
	if(mark==soursesum){
		document.getElementById("countsum").innerHTML="�������";
	}
	
	var typesum=0;
	for(var i=0;i<document.getElementsByName("type").length;i++){
		if(document.getElementsByName("selecttype")[i].checked==true){
			typesum=typesum+Number(document.getElementsByName("type")[i].value);
		}
	}
	
	var count=document.getElementsByName("count")[0].value;
	if(count>typesum){
		var j = count-typesum;
		document.getElementById("typesum").innerHTML="����"+j+"��δ����";
	}
	if(count<typesum){
		var j = typesum-count;
		document.getElementById("typesum").innerHTML="�������"+j+"��";
	}
	if(count==typesum){
		document.getElementById("typesum").innerHTML="�������";
	}
	
}

function selectall(){
	var b = document.getElementsByName("selecttype");

	for(var i=0;i<b.length;i++){
			b[i].checked=true;
			document.getElementById(i+"so").innerHTML="<input type=text name=sourse value=0 onchange=avr() size=5>";
			document.getElementById(i+"ty").innerHTML="<input type=text name=type value=0 onchange=avr() size=5>";
			document.getElementById(i+"tf").innerHTML="ÿ���ֵΪ0";
	}
	avr();
}

function resetall(){
	var b = document.getElementsByName("selecttype");

	for(var i=0;i<b.length;i++){
			b[i].checked=false;
			document.getElementById(i+"so").innerHTML="<input type=hidden name=sourse value=0 onchange=avr()>";
			document.getElementById(i+"ty").innerHTML="<input type=hidden name=type value=0 onchange=avr()>";
			document.getElementById(i+"tf").innerHTML="";
	}
	avr();
}

function select1(i){

		
		var b = document.getElementsByName("selecttype");

		if(b[i].checked==false){
			document.getElementById(i+"so").innerHTML="<input type=hidden name=sourse value=0 onchange=avr()>";
			document.getElementById(i+"ty").innerHTML="<input type=hidden name=type value=0 onchange=avr()>";
			document.getElementById(i+"tf").innerHTML="";
		
		}else{
			document.getElementById(i+"so").innerHTML="<input type=text name=sourse value=0 onchange=avr() size=5>";
			document.getElementById(i+"ty").innerHTML="<input type=text name=type value=0 onchange=avr() size=5>";
			document.getElementById(i+"tf").innerHTML="ÿ���ֵΪ0";
		}
		
		avr();
	
}

function typeStr(){
	var typestr="";
	for(var i=0;i<document.getElementsByName("type").length;i++){
		if(document.getElementsByName("selecttype")[i].checked==true){
			typestr+=document.getElementsByName("id")[i].value+",";
			typestr+=document.getElementsByName("sourse")[i].value+",";
			typestr+=document.getElementsByName("type")[i].value+",";
		}
	}
		
		document.getElementsByName("typeQuantityMark")[0].value=typestr;
}

function checkForm(){
	var cs = document.getElementById("course").value;
	if(cs==0){
		alert("�γ�δѡ��");
	}
	var p = document.getElementsByName("name")[0].value;
	if(trim(p)==""){
		alert("�����������");
	}
}

//ȥ��ո�; 
function ltrim(s){ 
return s.replace( /^\s*/, ""); 
} 
//ȥ�ҿո�; 
function rtrim(s){ 
return s.replace( /\s*$/, ""); 
} 
//ȥ���ҿո�; 
function trim(s){ 
return rtrim(ltrim(s)); 
} 


















