function findcs(){
	    courseManager.findCoursesScript(
		function(courses){ 
			   DWRUtil.addOptions("course",[{name:'请选择课程',id:0}],'id','name'); 
			   DWRUtil.addOptions("course",courses,'id','name');
			   
		}
	);
}


/*
 计算分数是否分配正确
 * */
function soursecount(){
    var count=0;
    //getElementsByName() 方法可返回带有指定名称的对象的集合
    for(var i=0;i<document.getElementsByName("sourse").length;i++){
        if(document.getElementsByName("selecttype")[i].checked){
            count=count+Number(document.getElementsByName("sourse")[i].value);
        }
    }
    //mark获取总分数
    var mark=document.getElementsByName("mark")[0].value;
    //count为用户分配的分数
    if(mark<count){
        alert("多分配了"+String(count-mark)+"分");
    }
    if(mark>count){
        alert("还有"+String(mark-count)+"分未分配");
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
		alert("多分配了"+String(count-mark)+"题");
	}
	if(mark>count){
		alert("还有"+String(mark-count)+"题未分配");
	}
	
}


function avr(){
	var a; 
	for(var i=0;i<document.getElementsByName("type").length;i++){
		if(document.getElementsByName("selecttype")[i].checked){
			if(Number(document.getElementsByName("type")[i].value)==0){
				document.getElementById(i+"tf").innerHTML="每题分值0";
			}else{
				a = Number(document.getElementsByName("sourse")[i].value)/Number(document.getElementsByName("type")[i].value);
				document.getElementById(i+"tf").innerHTML="每题分值为"+a;
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
		document.getElementById("countsum").innerHTML="还有"+j+"分未分配";
	}
	if(mark<soursesum){
		var j =soursesum-mark;
		document.getElementById("countsum").innerHTML="多分配了"+j+"分";
	}
	if(mark==soursesum){
		document.getElementById("countsum").innerHTML="分配完毕";
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
		document.getElementById("typesum").innerHTML="还有"+j+"题未分配";
	}
	if(count<typesum){
		var j = typesum-count;
		document.getElementById("typesum").innerHTML="多分配了"+j+"题";
	}
	if(count==typesum){
		document.getElementById("typesum").innerHTML="分配完毕";
	}
	
}

function selectall(){
	var b = document.getElementsByName("selecttype");

	for(var i=0;i<b.length;i++){
			b[i].checked=true;
			document.getElementById(i+"so").innerHTML="<input type=text name=sourse value=0 onchange=avr() size=5>";
			document.getElementById(i+"ty").innerHTML="<input type=text name=type value=0 onchange=avr() size=5>";
			document.getElementById(i+"tf").innerHTML="每题分值为0";
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
			document.getElementById(i+"tf").innerHTML="每题分值为0";
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
		alert("课程未选择");
	}
	var p = document.getElementsByName("name")[0].value;
	if(trim(p)==""){
		alert("请输入策略名");
	}
}

//去左空格; 
function ltrim(s){ 
return s.replace( /^\s*/, ""); 
} 
//去右空格; 
function rtrim(s){ 
return s.replace( /\s*$/, ""); 
} 
//去左右空格; 
function trim(s){ 
return rtrim(ltrim(s)); 
} 


















