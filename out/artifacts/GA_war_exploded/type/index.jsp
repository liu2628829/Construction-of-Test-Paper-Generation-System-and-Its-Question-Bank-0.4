<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>题型管理</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
      <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7> 题型管理<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
            <TD align=middle width=11 background=images/title_middle.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
            <TD align=middle background=images/title_right.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD width="82%" height=14 align=right vAlign=center noWrap>
            </TD>
            <TD width="18%" align=right vAlign=center noWrap>　</TD>
          </TR>
          <TR>
            <TD height=14 align=right vAlign=center noWrap><!-- 在这里插入查询表单 -->
            </TD>
            <TD height=14 align="left" vAlign=center noWrap>
    
            <a href="#" onclick="openWin('type.do?method=addInput','addType',600,200);">添加题型</a>
            </TD>
          </TR>
          <TR>
            <TD height=28 colspan="2" align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
            <!-- 可以在这里插入分页导航条 -->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
          <!-- 列表标题栏 -->
      
	      <tr bgcolor="#EFF3F7" class="TableBody1">
		      <td width="5%" height="37" align="center"><b>题型编号</b></td>
		      <td width="18%" height="37" align="center"><B>题型名称</B></td>
		      <td width="18%" height="37" align="center"><b>相关操作</b></td> 
          </tr>
          <!-- 列表数据栏 -->
          <c:if test="${!empty pm.datas}">
         <c:forEach items="${pm.datas }" var="type">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		      <td align="center" vAlign="center">${type.id }</td>
	          <td align="center" vAlign="center">${type.name }</td>
	          <td align="center" vAlign="center">
	          	  <a href="#" onclick="del('type.do?method=del&id=${type.id }');">删除</a>
	          	 
	          	 <a href="#" onclick="openWin('type.do?method=updateInput&id=${type.id }','updateType',600,200);">修改</a>
        </tr>
        </c:forEach>
		</c:if>
        <!-- 在列表数据为空的时候，要显示的提示信息 -->
	    <c:if test="${empty pm.datas}">
	    <tr>
	    	<td colspan="7" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	    </tr>
	    </c:if>
      </table>
      <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD height=28 align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
            <!-- 可以在这里插入分页导航条 -->
<pg:pager url="type.do" items="${pm.total }" export="currentPageNumber=pageNumber">
	<pg:first>
		<a href="${pageUrl}">首页</a>
	</pg:first>
	<pg:prev>
		<a href="${pageUrl }">前页</a>
	</pg:prev>
	<pg:pages>
		<c:choose>
			<c:when test="${currentPageNumber eq pageNumber }">
			<font color="red">${pageNumber }</font>
			</c:when>
			<c:otherwise>
				<a href="${pageUrl }">${pageNumber }</a>
			</c:otherwise>
		</c:choose>
	</pg:pages>
	<pg:next>
		<a href="${pageUrl }">后页</a>
	</pg:next>
	<pg:last>
		<a href="${pageUrl }">尾页</a>
	</pg:last>
</pg:pager>
    		</TD>
          </TR>
        </TBODY>
      </TABLE>
</center>

</body>

</html>
