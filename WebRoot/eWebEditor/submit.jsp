<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*"%>
<%
	String sContent = new String(request.getParameter("content1").getBytes("GBK"));
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.print("ȡ�õ�html��ǣ�"+"\n"+sContent+"\n"+"��Ҫ������ܳ�����upload.jsp��ĵ�202�е�setHtml()");
        out.println("�༭���������£�<br><br>"+sContent);
        out.println(
        "<br><br><p><input type=button value=' �˻� ' onclick='history.back()'></p>");
%>