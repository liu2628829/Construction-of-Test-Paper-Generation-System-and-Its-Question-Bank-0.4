	function selectcp(indexcp){
		var cp = document.getElementsByName("cp")[Number(indexcp)].checked;
		if(cp==true){
			var ses = document.getElementsByName(indexcp+"se");
			for(var i=0;i<ses.length;i++){
				ses[i].checked=true;
				var kps = document.getElementsByName(indexcp+String(i)+"kp");
				for(var j=0;j<kps.length;j++){
					kps[j].checked=true;
				}
			}
		}else{
			var ses = document.getElementsByName(indexcp+"se");
			for(var i=0;i<ses.length;i++){
				ses[i].checked=false;
				var kps = document.getElementsByName(indexcp+String(i)+"kp");
				for(var j=0;j<kps.length;j++){
					kps[j].checked=false;
				}
			}
		}
	}
	
	function selectse(indexcp,indexse){
		var ses =document.getElementById(String(indexcp)+String(indexse)+"se").checked;
		if(ses==true){
			var kps = document.getElementsByName(String(indexcp)+String(indexse)+"kp");
			for(var j=0;j<kps.length;j++){
				kps[j].checked=true;
			}
		}else{
			var kps = document.getElementsByName(String(indexcp)+String(indexse)+"kp");
			for(var j=0;j<kps.length;j++){
				kps[j].checked=false;
			}
		}
		quxiaocp(indexcp,indexse);
	}
	
	function quxiaocp(indexcp,indexse){
		var count=0;
		var ses = document.getElementsByName(indexcp+"se");
		
		for(var j=0;j<ses.length;j++){
				if(ses[j].checked==true){
					count+=1;
				}
		}
		if(count==0){
			document.getElementsByName("cp")[Number(indexcp)].checked=false;
		}else{
			document.getElementsByName("cp")[Number(indexcp)].checked=true;
		}
	}
	
	function selectkp(indexcp,indexse,indexkp){
		var kp = document.getElementById(String(indexcp)+String(indexse)+String(indexkp)+"kp").checked;
		if(kp==true){
			document.getElementsByName("cp")[Number(indexcp)].checked=true;
			document.getElementById(String(indexcp)+String(indexse)+"se").checked=true;
		}
		
		var count=0;
		var kpss = document.getElementsByName(String(indexcp)+String(indexse)+"kp");
		for(var j=0;j<kpss.length;j++){
				if(kpss[j].checked==true){
					count+=1;
				}
		}
		if(count==0){
			document.getElementById(String(indexcp)+String(indexse)+"se").checked=false;
		}
		quxiaocp(indexcp,indexse);
	}
	
	function skipall(){
		var cpstrs="";
		var sestrs="";
		var kpstrs="";
		var cps = document.getElementsByName("cp");
		for(var i=0;i<cps.length;i++){
			if(cps[i].checked==true){
				var cpstr = document.getElementsByName("cpid")[i].value;
				var r = document.getElementsByName("radio");
				var ratio = r[i].options[r[i].selectedIndex].value;
				cpstrs+=cpstr+","+ratio+",";
				var ses = document.getElementsByName(String(i)+"se");
				for(var j=0;j<ses.length;j++){
					if(ses[j].checked==true){
						var sestr = document.getElementsByName(String(i)+"seid")[j].value;
						sestrs +=sestr+",";
						var kps = document.getElementsByName(String(i)+String(j)+"kp");
	
						for(var k=0;k<kps.length;k++){
							if(kps[k].checked==true){
								var kpstr = document.getElementsByName(String(i)+String(j)+"kpid")[k].value;
								kpstrs+=kpstr+",";
							}
						}
					}
				}
			}
		}
		
		document.getElementsByName("chapterIdInverse")[0].value=cpstrs;
		document.getElementsByName("sections")[0].value=sestrs;
		document.getElementsByName("knowledgePointIds")[0].value=kpstrs;
		//alert(kpstrs);
		//alert(cpstrs);
		//alert(sestrs);
	}
	
	function checkratio(){
		var r = document.getElementsByName("radio");
		var p =document.getElementsByName("cp");
		var count=0;
		
		for(var i=0;i<r.length;i++){
			if(p[i].checked){
				count+=Number(r[i].options[r[i].selectedIndex].value);
			}
		}
		if(count>100){
			var co = count-100;
			alert("各章总比例超过了"+co+"%");
		}
		
		if(count<100){
			var co = 100-count;
			alert("各章总比例少了"+co+"%");
		}
		
	}