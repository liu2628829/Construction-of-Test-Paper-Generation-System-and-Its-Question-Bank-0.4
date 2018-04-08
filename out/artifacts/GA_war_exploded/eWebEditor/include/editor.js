
/*
*������������������������������������
*��                                                                  ��
*��                eWebEditor - eWebSoft�����ı��༭�������޸İ�     ��
*��                                                                  ��
*��  ��Ȩ����: eWebSoft.com                                          ��
*��                                                                  ��
*��  ��������: eWeb�����Ŷ�                                          ��
*��            email:webmaster@webasp.net                            ��
*��            QQ:589808                                             ��
*��                                                                  ��
*��  �����ַ: [ԭ���ַ]http://www.eWebSoft.com/Product/eWebEditor/ ��
*��            [֧����̳]http://bbs.eWebSoft.com/                    ��
*��                                                                  ��
*��  ��ҳ��ַ: http://www.fiyu.net/   ������̳                       ��
*��           ��ʲô���⻶ӭ��������̳�����                         ��
*��                                                                  ��
*��                                                                  ��
*������������������������������������
*/
// ��ǰģʽ
var sCurrMode = null;
var bEditMode = null;
// ���Ӷ���
var oLinkField = null;
var sBaseUrl = document.location.protocol + '//' + document.location.host ;

// ������汾���
var BrowserInfo = new Object() ;
BrowserInfo.MajorVer = navigator.appVersion.match(/MSIE (.)/)[1] ;
BrowserInfo.MinorVer = navigator.appVersion.match(/MSIE .\.(.)/)[1] ;
BrowserInfo.IsIE55OrMore = BrowserInfo.MajorVer >= 6 || ( BrowserInfo.MajorVer >= 5 && BrowserInfo.MinorVer >= 5 ) ;

var yToolbars = new Array();  // ����������

// ���ĵ���ȫ����ʱ�����г�ʼ��
var bInitialized = false;
//function document.onreadystatechange(){
document.onreadystatechange=function(){
	if (document.readyState!="complete") return;
	if (bInitialized) return;
	bInitialized = true;

	var i, s, curr;

	// ��ʼÿ��������
	for (i=0; i<document.body.all.length;i++){
		curr=document.body.all[i];
		if (curr.className == "yToolbar"){
			InitTB(curr);
			yToolbars[yToolbars.length] = curr;
		}
	}

	oLinkField = parent.document.getElementsByName(sLinkFieldName)[0];
	if (ContentFlag.value=="0") { 
		ContentEdit.value = oLinkField.value;
		ContentLoad.value = oLinkField.value;
		ContentFlag.value = "1";
	}
	
	setMode(config.InitMode);
	setLinkedField() ;
	eWebEditor.document.body.onpaste = onPaste ;
	eWebEditor.focus();
}

// ��ʼ��һ���������ϵİ�ť
function InitBtn(btn) {
	btn.onmouseover = BtnMouseOver;
	btn.onmouseout = BtnMouseOut;
	btn.onmousedown = BtnMouseDown;
	btn.onmouseup = BtnMouseUp;
	btn.ondragstart = YCancelEvent;
	btn.onselectstart = YCancelEvent;
	btn.onselect = YCancelEvent;
	btn.YUSERONCLICK = btn.onclick;
	btn.onclick = YCancelEvent;
	btn.YINITIALIZED = true;
	return true;
}

//Initialize a toolbar. 
function InitTB(y) {
	// Set initial size of toolbar to that of the handle
	y.TBWidth = 0;
		
	// Populate the toolbar with its contents
	if (! PopulateTB(y)) return false;
	
	// Set the toolbar width and put in the handle
	y.style.posWidth = y.TBWidth;
	
	return true;
}


// Hander that simply cancels an event
function YCancelEvent() {
	event.returnValue=false;
	event.cancelBubble=true;
	return false;
}

// Toolbar button onmouseover handler
function BtnMouseOver() {
	if (event.srcElement.tagName != "IMG") return false;
	var image = event.srcElement;
	var element = image.parentElement;
	
	// Change button look based on current state of image.
	if (image.className == "Ico") element.className = "BtnMouseOverUp";
	else if (image.className == "IcoDown") element.className = "BtnMouseOverDown";

	event.cancelBubble = true;
}

// Toolbar button onmouseout handler
function BtnMouseOut() {
	if (event.srcElement.tagName != "IMG") {
		event.cancelBubble = true;
		return false;
	}

	var image = event.srcElement;
	var element = image.parentElement;
	yRaisedElement = null;
	
	element.className = "Btn";
	image.className = "Ico";

	event.cancelBubble = true;
}

// Toolbar button onmousedown handler
function BtnMouseDown() {
	if (event.srcElement.tagName != "IMG") {
		event.cancelBubble = true;
		event.returnValue=false;
		return false;
	}

	var image = event.srcElement;
	var element = image.parentElement;

	element.className = "BtnMouseOverDown";
	image.className = "IcoDown";

	event.cancelBubble = true;
	event.returnValue=false;
	return false;
}

// Toolbar button onmouseup handler
function BtnMouseUp() {
	if (event.srcElement.tagName != "IMG") {
		event.cancelBubble = true;
		return false;
	}

	var image = event.srcElement;
	var element = image.parentElement;

	//if (element.YUSERONCLICK) eval(element.YUSERONCLICK + "anonymous()");
    if(navigator.appVersion.match(/MSIE (7|8)\./i)!=null || navigator.appVersion.match(/MAXTHON/i)=='MAXTHON')
    {
        if (element.YUSERONCLICK) eval(element.YUSERONCLICK + "onclick(event)");
    }else{
        if (element.YUSERONCLICK) eval(element.YUSERONCLICK + "anonymous()");
    }

	element.className = "BtnMouseOverUp";
	image.className = "Ico";

	event.cancelBubble = true;
	return false;
}

// Populate a toolbar with the elements within it
function PopulateTB(y) {
	var i, elements, element;

	// Iterate through all the top-level elements in the toolbar
	elements = y.children;
	for (i=0; i<elements.length; i++) {
		element = elements[i];
		if (element.tagName == "SCRIPT" || element.tagName == "!") continue;
		
		switch (element.className) {
		case "Btn":
			if (element.YINITIALIZED == null) {
				if (! InitBtn(element)) {
					alert("Problem initializing:" + element.id);
					return false;
				}
			}
			
			element.style.posLeft = y.TBWidth;
			y.TBWidth += element.offsetWidth + 1;
			break;
			
		case "TBGen":
			element.style.posLeft = y.TBWidth;
			y.TBWidth += element.offsetWidth + 1;
			break;
			
		case "TBSep":
			element.style.posLeft = y.TBWidth + 2;
			y.TBWidth += 5;
			break;
			
		case "TBHandle":
			element.style.posLeft = 2;
			y.TBWidth += element.offsetWidth + 7;
			break;
			
		default:
			alert("Invalid class: " + element.className + " on Element: " + element.id + " <" + element.tagName + ">");
			return false;
		}
	}

	y.TBWidth += 1;
	return true;
}


// �������������ύ��reset�¼�
function setLinkedField() {
	if (! oLinkField) return ;
	var oForm = oLinkField.form ;
	if (!oForm) return ;
	// ����submit�¼�
	oForm.attachEvent("onsubmit", AttachSubmit) ;
	if (! oForm.submitEditor) oForm.submitEditor = new Array() ;
	oForm.submitEditor[oForm.submitEditor.length] = AttachSubmit ;
	if (! oForm.originalSubmit) {
		oForm.originalSubmit = oForm.submit ;
		oForm.submit = function() {
			if (this.submitEditor) {
				for (var i = 0 ; i < this.submitEditor.length ; i++) {
					this.submitEditor[i]() ;
				}
			}
			this.originalSubmit() ;
		}
	}
	// ����reset�¼�
	oForm.attachEvent("onreset", AttachReset) ;
	if (! oForm.resetEditor) oForm.resetEditor = new Array() ;
	oForm.resetEditor[oForm.resetEditor.length] = AttachReset ;
	if (! oForm.originalReset) {
		oForm.originalReset = oForm.reset ;
		oForm.reset = function() {
			if (this.resetEditor) {
				for (var i = 0 ; i < this.resetEditor.length ; i++) {
					this.resetEditor[i]() ;
				}
			}
			this.originalReset() ;
		}
	}
}

// ����submit�ύ�¼�,��������ύ,Զ���ļ���ȡ,����eWebEditor�е�����
var bDoneAutoRemote = false;
function AttachSubmit() { 
	var oForm = oLinkField.form ;
	if (!oForm) return;
	
	if ((config.AutoRemote=="1")&&(!bDoneAutoRemote)){
		parent.event.returnValue = false;
		bDoneAutoRemote = true;
		remoteUpload();
	} else {
		var html = getHTML();
		ContentEdit.value = html;
		if (sCurrMode=="TEXT"){
			html = HTMLEncode(html);
		}
		splitTextField(oLinkField, html);
	}
} 

// �ύ��
function doSubmit(){
	var oForm = oLinkField.form ;
	if (!oForm) return ;
	oForm.submit();
}

// ����Reset�¼�
function AttachReset() {
	if (!bEditMode) setMode('EDIT');
	if(bEditMode){
		eWebEditor.document.body.innerHTML = ContentLoad.value;
	}else{
		eWebEditor.document.body.innerText = ContentLoad.value;
	}
}

// ճ��ʱ�Զ�����Ƿ���Դ��Word��ʽ
function onPaste() {
	if (config.AutoDetectPasteFromWord && BrowserInfo.IsIE55OrMore) {
		var sHTML = GetClipboardHTML() ;
		var re = /<\w[^>]* class="?MsoNormal"?/gi ;
		if ( re.test( sHTML ) )
		{
			if ( confirm( "��Ҫճ�������ݺ����Ǵ�Word�п������ģ��Ƿ�Ҫ�����Word��ʽ��ճ����" ) )
			{
				cleanAndPaste( sHTML ) ;
				return false ;
			}
		}
	}
	else
		return true ;
}

function GetClipboardHTML() {
	var oDiv = document.getElementById("eWebEditor_Temp_HTML")
	oDiv.innerHTML = "" ;
	
	var oTextRange = document.body.createTextRange() ;
	oTextRange.moveToElementText(oDiv) ;
	oTextRange.execCommand("Paste") ;
	
	var sData = oDiv.innerHTML ;
	oDiv.innerHTML = "" ;
	
	return sData ;
}

function cleanAndPaste( html ) {
	// Remove all SPAN tags
	html = html.replace(/<\/?SPAN[^>]*>/gi, "" );
	// Remove Class attributes
	html = html.replace(/<(\w[^>]*) class=([^ |>]*)([^>]*)/gi, "<$1$3") ;
	// Remove Style attributes
	html = html.replace(/<(\w[^>]*) style="([^"]*)"([^>]*)/gi, "<$1$3") ;
	// Remove Lang attributes
	html = html.replace(/<(\w[^>]*) lang=([^ |>]*)([^>]*)/gi, "<$1$3") ;
	// Remove XML elements and declarations
	html = html.replace(/<\\?\?xml[^>]*>/gi, "") ;
	// Remove Tags with XML namespace declarations: <o:p></o:p>
	html = html.replace(/<\/?\w+:[^>]*>/gi, "") ;
	// Replace the &nbsp;
	html = html.replace(/&nbsp;/, " " );
	// Transform <P> to <DIV>
	var re = new RegExp("(<P)([^>]*>.*?)(<\/P>)","gi") ;	// Different because of a IE 5.0 error
	html = html.replace( re, "<div$2</div>" ) ;
	
	insertHTML( html ) ;
}

// �ڵ�ǰ�ĵ�λ�ò���.
function insertHTML(html) {
	if (!validateMode()) return;
	if (eWebEditor.document.selection.type.toLowerCase() != "none")
		eWebEditor.document.selection.clear() ;
	eWebEditor.document.selection.createRange().pasteHTML(html) ; 
}

// ���ñ༭��������
/*function setHTML(html) {
	ContentEdit.value = html;
	switch (sCurrMode){
	case "CODE":
		eWebEditor.document.designMode="On";
		eWebEditor.document.open();
		eWebEditor.document.write(config.StyleEditorHeader);
		eWebEditor.document.body.innerText=html;
		eWebEditor.document.body.contentEditable="true";
		eWebEditor.document.close();
		bEditMode=false;
		break;
	case "EDIT":
		eWebEditor.document.designMode="On";
		eWebEditor.document.open();
		eWebEditor.document.write(config.StyleEditorHeader+html);
		eWebEditor.document.body.contentEditable="true";
		eWebEditor.document.execCommand("2D-Position",true,true);
		eWebEditor.document.execCommand("MultipleSelection", true, true);
		eWebEditor.document.execCommand("LiveResize", true, true);
		eWebEditor.document.close();
		doZoom(nCurrZoomSize);
		bEditMode=true;
		eWebEditor.document.onselectionchange = function () { doToolbar();}
		break;
	case "TEXT":
		eWebEditor.document.designMode="On";
		eWebEditor.document.open();
		eWebEditor.document.write(config.StyleEditorHeader);
		eWebEditor.document.body.innerText=html;
		eWebEditor.document.body.contentEditable="true";
		eWebEditor.document.close();
		bEditMode=false;
		break;
	case "VIEW":
		eWebEditor.document.designMode="off";
		eWebEditor.document.open();
		eWebEditor.document.write(config.StyleEditorHeader+html);
		eWebEditor.document.body.contentEditable="false";
		eWebEditor.document.close();
		bEditMode=false;
		break;
	}

	eWebEditor.document.body.onpaste = onPaste ;
	eWebEditor.document.body.onhelp = onHelp ;
	eWebEditor.document.onkeydown = new Function("return onKeyDown(eWebEditor.event);");
	eWebEditor.document.oncontextmenu=new Function("return showContextMenu(eWebEditor.event);");

	if ((borderShown != "0")&&bEditMode) {
		borderShown = "0";
		showBorders();
	}

	initHistory();
}*/
// ���ñ༭��������
function setHTML(html) {
	if (!validateMode()) return;
	ContentEdit.value = html;
	if(bEditMode){
		eWebEditor.document.body.innerHTML = html;
	}else{
		eWebEditor.document.body.innerText = html;
	}
}

// ȡ�༭��������
function getHTML() {
	var html;
	if(bEditMode){
		html = eWebEditor.document.body.innerHTML;
	}else{
		html = eWebEditor.document.body.innerText;
	}
	var re = new RegExp(sBaseUrl.replace(/\//,"\/"),"gi");
	html = html.replace(re, "");
	if ((html.toLowerCase()=="<p>&nbsp;</p>")||(html.toLowerCase()=="<p></p>")){
		html = "";
	}
	return html;
}

// ��β��׷������
function appendHTML(html) {
	if (!validateMode()) return;
	if(bEditMode){
		eWebEditor.document.body.innerHTML += html;
	}else{
		eWebEditor.document.body.innerText += html;
	}
}

// ��Word��ճ����ȥ����ʽ
function PasteWord(){
	if (!validateMode()) return;
	eWebEditor.focus();
	if (BrowserInfo.IsIE55OrMore)
		cleanAndPaste( GetClipboardHTML() ) ;
	else if ( confirm( "�˹���Ҫ��IE5.5�汾���ϣ��㵱ǰ���������֧�֣��Ƿ񰴳���ճ�����У�" ) )
		format("paste") ;
	eWebEditor.focus();
}

// ճ�����ı�
function PasteText(){
	if (!validateMode()) return;
	eWebEditor.focus();
	var sText = HTMLEncode( clipboardData.getData("Text") ) ;
	insertHTML(sText);
	eWebEditor.focus();
}

// ��⵱ǰ�Ƿ�����༭
function validateMode() {
	if (bEditMode) return true;
	alert("��ת��Ϊ�༭״̬�����ʹ�ñ༭���ܣ�");
	eWebEditor.focus();
	return false;
}

// ��ʽ���༭���е�����
function format(what,opt) {
	if (!validateMode()) return;
	eWebEditor.focus();
	if (opt=="RemoveFormat") {
		what=opt;
		opt=null;
	}

	if (opt==null) eWebEditor.document.execCommand(what);
	else eWebEditor.document.execCommand(what,"",opt);
	
	eWebEditor.focus();
}

// ȷ�������� eWebEditor ��
function VerifyFocus() {
	if ( eWebEditor )
		eWebEditor.focus();
}

// �ı�ģʽ�����롢�༭��Ԥ��
function setMode(NewMode){
	if (NewMode!=sCurrMode){
		var sBody = "";
		switch(sCurrMode){
		case "CODE":
			sBody = eWebEditor.document.body.innerText;
			break;
		case "EDIT":
		case "VIEW":
			sBody = eWebEditor.document.body.innerHTML;
			break;
		default:
			sBody = ContentEdit.value;
			break;
		}
		// ��ͼƬ
		try{
			document.all["eWebEditor_CODE"].className = "StatusBarBtnOff";
			document.all["eWebEditor_EDIT"].className = "StatusBarBtnOff";
			document.all["eWebEditor_VIEW"].className = "StatusBarBtnOff";
			document.all["eWebEditor_"+NewMode].className = "StatusBarBtnOn";
			}
		catch(e){
			}
		// ������
		switch (NewMode){
		case "CODE":
			eWebEditor.document.designMode="On";
			eWebEditor.document.open();
			eWebEditor.document.write(config.StyleEditorHeader);
			eWebEditor.document.body.innerText=sBody;
			eWebEditor.document.body.contentEditable="true";
			eWebEditor.document.oncontextmenu=new Function("return showContextMenu(eWebEditor.event);");
			eWebEditor.document.close();
			bEditMode=false;
			break;
		case "EDIT":
			eWebEditor.document.designMode="On";
			eWebEditor.document.open();
			eWebEditor.document.write(config.StyleEditorHeader);
			eWebEditor.document.body.innerHTML=sBody;
			eWebEditor.document.body.contentEditable="true";
			eWebEditor.document.oncontextmenu=new Function("return showContextMenu(eWebEditor.event);");
			eWebEditor.document.execCommand("2D-Position",true,true);
			eWebEditor.document.execCommand("MultipleSelection", true, true);
			eWebEditor.document.execCommand("LiveResize", true, true);
			eWebEditor.document.close();
			doZoom(nCurrZoomSize);
			bEditMode=true;
			break;
		case "VIEW":
			eWebEditor.document.designMode="off";
			eWebEditor.document.open();
			eWebEditor.document.write(config.StyleEditorHeader+sBody);
			eWebEditor.document.body.contentEditable="false";
			eWebEditor.document.close();
			bEditMode=false;
			break;
		}
		sCurrMode=NewMode;
		disableChildren(eWebEditor_Toolbar);

		if ((borderShown != "no")&&bEditMode) {
			borderShown = "no";
			showBorders()
		}

	}
	eWebEditor.focus();
}

// ʹ��������Ч
function disableChildren(obj){
	if (obj){
		obj.disabled=(!bEditMode);
		for (var i=0; i<obj.children.length; i++){
			disableChildren(obj.children[i]);
		}
	}
}



// ��ʾ��ģʽ�Ի���
function ShowDialog(url, width, height, optValidate) {
	if (optValidate) {
		if (!validateMode()) return;
	}
	eWebEditor.focus();
	var arr = showModalDialog(url, window, "dialogWidth:" + width + "px;dialogHeight:" + height + "px;help:no;scroll:no;status:no");
	eWebEditor.focus();
}

// ȫ���༭
function Maximize() {
	if (!validateMode()) return;
	window.open("dialog/fullscreen.htm?style="+config.StyleName, 'FullScreen'+sLinkFieldName, 'toolbar=no,location=no,directories=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,fullscreen=yes');
}

// �滻�����ַ�
function HTMLEncode(text){
	text = text.replace(/&/g, "&amp;") ;
	text = text.replace(/"/g, "&quot;") ;
	text = text.replace(/</g, "&lt;") ;
	text = text.replace(/>/g, "&gt;") ;
	text = text.replace(/'/g, "&#146;") ;
	text = text.replace(/\ /g,"&nbsp;");
	text = text.replace(/\n/g,"<br>");
	text = text.replace(/\t/g,"&nbsp;&nbsp;&nbsp;&nbsp;");
	return text;
}

// �����������
function insert(what) {
	if (!validateMode()) return;
	eWebEditor.focus();
	var sel = eWebEditor.document.selection.createRange();

	switch(what){
	case "excel":		// ����EXCEL���
		insertHTML("<object classid='clsid:0002E510-0000-0000-C000-000000000046' id='Spreadsheet1' codebase='file:\\Bob\software\office2000\msowc.cab' width='100%' height='250'><param name='HTMLURL' value><param name='HTMLData' value='&lt;html xmlns:x=&quot;urn:schemas-microsoft-com:office:excel&quot;xmlns=&quot;http://www.w3.org/TR/REC-html40&quot;&gt;&lt;head&gt;&lt;style type=&quot;text/css&quot;&gt;&lt;!--tr{mso-height-source:auto;}td{black-space:nowrap;}.wc4590F88{black-space:nowrap;font-family:����;mso-number-format:General;font-size:auto;font-weight:auto;font-style:auto;text-decoration:auto;mso-background-source:auto;mso-pattern:auto;mso-color-source:auto;text-align:general;vertical-align:bottom;border-top:none;border-left:none;border-right:none;border-bottom:none;mso-protection:locked;}--&gt;&lt;/style&gt;&lt;/head&gt;&lt;body&gt;&lt;!--[if gte mso 9]&gt;&lt;xml&gt;&lt;x:ExcelWorkbook&gt;&lt;x:ExcelWorksheets&gt;&lt;x:ExcelWorksheet&gt;&lt;x:OWCVersion&gt;9.0.0.2710&lt;/x:OWCVersion&gt;&lt;x:Label Style='border-top:solid .5pt silver;border-left:solid .5pt silver;border-right:solid .5pt silver;border-bottom:solid .5pt silver'&gt;&lt;x:Caption&gt;Microsoft Office Spreadsheet&lt;/x:Caption&gt; &lt;/x:Label&gt;&lt;x:Name&gt;Sheet1&lt;/x:Name&gt;&lt;x:WorksheetOptions&gt;&lt;x:Selected/&gt;&lt;x:Height&gt;7620&lt;/x:Height&gt;&lt;x:Width&gt;15240&lt;/x:Width&gt;&lt;x:TopRowVisible&gt;0&lt;/x:TopRowVisible&gt;&lt;x:LeftColumnVisible&gt;0&lt;/x:LeftColumnVisible&gt; &lt;x:ProtectContents&gt;False&lt;/x:ProtectContents&gt; &lt;x:DefaultRowHeight&gt;210&lt;/x:DefaultRowHeight&gt; &lt;x:StandardWidth&gt;2389&lt;/x:StandardWidth&gt; &lt;/x:WorksheetOptions&gt; &lt;/x:ExcelWorksheet&gt;&lt;/x:ExcelWorksheets&gt; &lt;x:MaxHeight&gt;80%&lt;/x:MaxHeight&gt;&lt;x:MaxWidth&gt;80%&lt;/x:MaxWidth&gt;&lt;/x:ExcelWorkbook&gt;&lt;/xml&gt;&lt;![endif]--&gt;&lt;table class=wc4590F88 x:str&gt;&lt;col width=&quot;56&quot;&gt;&lt;tr height=&quot;14&quot;&gt;&lt;td&gt;&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;&lt;/body&gt;&lt;/html&gt;'> <param name='DataType' value='HTMLDATA'> <param name='AutoFit' value='0'><param name='DisplayColHeaders' value='-1'><param name='DisplayGridlines' value='-1'><param name='DisplayHorizontalScrollBar' value='-1'><param name='DisplayRowHeaders' value='-1'><param name='DisplayTitleBar' value='-1'><param name='DisplayToolbar' value='-1'><param name='DisplayVerticalScrollBar' value='-1'> <param name='EnableAutoCalculate' value='-1'> <param name='EnableEvents' value='-1'><param name='MoveAfterReturn' value='-1'><param name='MoveAfterReturnDirection' value='0'><param name='RightToLeft' value='0'><param name='ViewableRange' value='1:65536'></object>");
		break;
	case "nowdate":		// ���뵱ǰϵͳ����
		var d = new Date();
		insertHTML(d.toLocaleDateString());
		break;
	case "nowtime":		// ���뵱ǰϵͳʱ��
		var d = new Date();
		insertHTML(d.toLocaleTimeString());
		break;
	case "br":			// ���뻻�з�
		insertHTML("<br>")
		break;
	case "code":		// ����Ƭ����ʽ
		insertHTML('<table width=95% border="0" align="Center" cellpadding="6" cellspacing="0" style="border: 1px Dotted #CCCCCC; TABLE-LAYOUT: fixed"><tr><td bgcolor=#FDFDDF style="WORD-WRAP: break-word"><font style="color: #990000;font-weight:bold">�����Ǵ���Ƭ�Σ�</font><br>'+HTMLEncode(sel.text)+'</td></tr></table>');
		break;
	case "quote":		// ����Ƭ����ʽ
		insertHTML('<table width=95% border="0" align="Center" cellpadding="6" cellspacing="0" style="border: 1px Dotted #CCCCCC; TABLE-LAYOUT: fixed"><tr><td bgcolor=#F3F3F3 style="WORD-WRAP: break-word"><font style="color: #990000;font-weight:bold">����������Ƭ�Σ�</font><br>'+HTMLEncode(sel.text)+'</td></tr></table>');
		break;
	case "big":			// ������
		insertHTML("<big>" + sel.text + "</big>");
		break;
	case "small":		// �����С
		insertHTML("<small>" + sel.text + "</small>");
		break;
	default:
		alert("����������ã�");
		break;
	}
	sel=null;
}

// ��ʾ������ָ������
var borderShown = "no";
function showBorders() {
	if (!validateMode()) return;
	
	var allForms = eWebEditor.document.body.getElementsByTagName("FORM");
	var allInputs = eWebEditor.document.body.getElementsByTagName("INPUT");
	var allTables = eWebEditor.document.body.getElementsByTagName("TABLE");
	var allLinks = eWebEditor.document.body.getElementsByTagName("A");

	// ��
	for (a=0; a < allForms.length; a++) {
		if (borderShown == "no") {
			allForms[a].runtimeStyle.border = "1px dotted #FF0000"
		} else {
			allForms[a].runtimeStyle.cssText = ""
		}
	}

	// Input Hidden��
	for (b=0; b < allInputs.length; b++) {
		if (borderShown == "no") {
			if (allInputs[b].type.toUpperCase() == "HIDDEN") {
				allInputs[b].runtimeStyle.border = "1px dashed #000000"
				allInputs[b].runtimeStyle.width = "15px"
				allInputs[b].runtimeStyle.height = "15px"
				allInputs[b].runtimeStyle.backgroundColor = "#FDADAD"
				allInputs[b].runtimeStyle.color = "#FDADAD"
			}
		} else {
			if (allInputs[b].type.toUpperCase() == "HIDDEN")
				allInputs[b].runtimeStyle.cssText = ""
		}
	}

	// ���
	for (i=0; i < allTables.length; i++) {
			if (borderShown == "no") {
				allTables[i].runtimeStyle.border = "1px dotted #BFBFBF"
			} else {
				allTables[i].runtimeStyle.cssText = ""
			}

			allRows = allTables[i].rows
			for (y=0; y < allRows.length; y++) {
			 	allCellsInRow = allRows[y].cells
					for (x=0; x < allCellsInRow.length; x++) {
						if (borderShown == "no") {
							allCellsInRow[x].runtimeStyle.border = "1px dotted #BFBFBF"
						} else {
							allCellsInRow[x].runtimeStyle.cssText = ""
						}
					}
			}
	}

	// ���� A
	for (a=0; a < allLinks.length; a++) {
		if (borderShown == "no") {
			if (allLinks[a].href.toUpperCase() == "") {
				allLinks[a].runtimeStyle.border = "1px dashed #000000"
				allLinks[a].runtimeStyle.width = "20px"
				allLinks[a].runtimeStyle.height = "16px"
				allLinks[a].runtimeStyle.backgroundColor = "#FFFFCC"
				allLinks[a].runtimeStyle.color = "#FFFFCC"					
			}
		} else {
			allLinks[a].runtimeStyle.cssText = ""		
		}
	}

	if (borderShown == "no") {
		borderShown = "yes"
	} else {
		borderShown = "no"
	}

	scrollUp()
}

// ����ҳ�����ϲ�
function scrollUp() {
	eWebEditor.scrollBy(0,0);
}

// ���Ų���
var nCurrZoomSize = 100;
var aZoomSize = new Array(10, 25, 50, 75, 100, 150, 200, 500);
function doZoom(size) {
	eWebEditor.document.body.runtimeStyle.zoom = size + "%";
	nCurrZoomSize = size;
}

// ƴд���
function spellCheck(){
	ShowDialog('dialog/spellcheck.htm', 300, 220, true)
}

// �����滻
function findReplace(){
	ShowDialog('dialog/findreplace.htm', 320, 165, true)
}

// ���(absolute)�����λ��(static)
function absolutePosition(){
	var objReference	= null;
	var RangeType		= eWebEditor.document.selection.type;
	if (RangeType != "Control") return;
	var selectedRange	= eWebEditor.document.selection.createRange();
	for (var i=0; i<selectedRange.length; i++){
		objReference = selectedRange.item(i);
		if (objReference.style.position != 'absolute') {
			objReference.style.position='absolute';
		}else{
			objReference.style.position='static';
		}
	}
	eWebEditor.content = false;
	eWebEditor.setActive();
}

// ����(forward)������(backward)һ��
function zIndex(action){
	var objReference	= null;
	var RangeType		= eWebEditor.document.selection.type;
	if (RangeType != "Control") return;
	var selectedRange	= eWebEditor.document.selection.createRange();
	for (var i=0; i<selectedRange.length; i++){
		objReference = selectedRange.item(i);
		if (action=='forward'){
			objReference.style.zIndex  +=1;
		}else{
			objReference.style.zIndex  -=1;
		}
		objReference.style.position='absolute';
	}
	eWebEditor.content = false;
	eWebEditor.setActive();
}

// �Ƿ�ѡ��ָ�����͵Ŀؼ�
function isControlSelected(tag){
	if (eWebEditor.document.selection.type == "Control") {
		var oControlRange = eWebEditor.document.selection.createRange();
		if (oControlRange(0).tagName.toUpperCase() == tag) {
			return true;
		}	
	}
	return false;
}

// �ı�༭���߶�
function sizeChange(size){
	for (var i=0; i<parent.frames.length; i++){
		if (parent.frames[i].document==self.document){
			var obj=parent.frames[i].frameElement;
			var height = parseInt(obj.offsetHeight);
			if (height+size>=300){
				obj.height=height+size;
			}
			break;
		}
	}
}
// ���ļ������Զ����
function splitTextField(objField, html) { 
	var strFieldName = objField.name;
	var objForm = objField.form;
	var objDocument = objField.document;
	objField.value = html;

	//������ֵ�趨������ֵ��102399�����ǵ�������Ϊһ��
	var FormLimit = 50000 ;

	// �ٴδ���ʱ���ȸ���ֵ
	for (var i=1;i<objDocument.getElementsByName(strFieldName).length;i++) {
		objDocument.getElementsByName(strFieldName)[i].value = "";
	}

	//�����ֵ�������ƣ���ɶ������
	if (html.length > FormLimit) { 
		objField.value = html.substr(0, FormLimit) ;
		html = html.substr(FormLimit) ;
		while (html.length > 0) { 
			var objTEXTAREA = objDocument.createElement("TEXTAREA") ;
			objTEXTAREA.name = strFieldName ;
			objTEXTAREA.style.display = "none" ;
			objTEXTAREA.value = html.substr(0, FormLimit) ;
			objForm.appendChild(objTEXTAREA) ;

			html = html.substr(FormLimit) ;
		} 
	} 
} 

// Զ���ϴ�
function remoteUpload() { 
	if (sCurrMode=="TEXT") return;
	
	var objField = document.getElementsByName("eWebEditor_UploadText")[0];
	splitTextField(objField, getHTML());

	divProcessing.style.top = (document.body.clientHeight-parseFloat(divProcessing.style.height))/2;
	divProcessing.style.left = (document.body.clientWidth-parseFloat(divProcessing.style.width))/2;
	divProcessing.style.display = "";
	eWebEditor_UploadForm.submit();
} 

// Զ���ϴ����
function remoteUploadOK() {
	divProcessing.style.display = "none";
	if (bDoneAutoRemote){
		doSubmit();
	}
}
