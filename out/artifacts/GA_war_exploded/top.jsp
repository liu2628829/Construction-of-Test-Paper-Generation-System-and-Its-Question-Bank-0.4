<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<STYLE>
.clear{
	clear:both;
}

.top{
	width:100%;
}
.top_top{
	width:100%;
	background:#211d1f;
	line-height:25px;
	color:#fff;
}
.logo_bg{

	height:100%;
	width:100%;
	
}

</STYLE>
</head>




  <div class="top">
    <div class="top_top"><span style="float:left; margin-left:14px;">欢迎访问智能组卷系统！ </span><span style="float:right; margin-right:14px;">管理员，你好    <a href="login.jsp" target="_top">退出</a> </span>
      <div class="clear"></div>
    </div>
    <div class="logo_bg"><img src="images/logo.png" style="float: left;" width="100%" height="53">
      <div class="clear"></div>
    </div>
   

      
</html>
