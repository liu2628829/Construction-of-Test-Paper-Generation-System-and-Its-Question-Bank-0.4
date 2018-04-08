<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/ga.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<%@include file="/script/addInput.jsp" %>
<title>组卷参数</title>
<script type="text/javascript">
function chState(id){
	var states = document.getElementsByName("state");
	gaModleManager.updateState(Number(id));
	for(var i=0;i<states.length;i++){
		states[i].checked=false;
	}
	document.getElementById(id).checked=true;
}


</script>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
      <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>组卷参数<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
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
            <% 
            /**
            * 在这里定义“添加”，“查询”等按钮
            * <input type="image" name="find" value="find" src="images/cz.gif">
            * &nbsp;&nbsp;&nbsp;&nbsp; 
            * <a href="#" onClick="openWin('document.do?method=addInput','470')">
            * <img src="images/addpic.gif" border=0 align=absMiddle style="CURSOR: hand"></a>
            */
            %>
            <a href="#" onclick="openWin('gaModle.do?method=addInput','addGaModle',600,200);">参数添加</a>
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
	      	 	<td width="5%" height="37" align="center"><b>编号</b></td>
		      <td width="5%" height="37" align="center"><b>初始种群</b></td>
		      <td width="18%" height="37" align="center"><B>繁殖代数</B></td>
		      <td width="18%" height="37" align="center"><b>交叉概率</b></td>
		      <td width="18%" height="37" align="center"><b>变异概率</b></td> 
		      <td width="18%" height="37" align="center"><b>选择</b></td> 
		       <td width="18%" height="37" align="center"><b>修改</b></td>
          </tr>
          <!-- 列表数据栏 -->
          <c:if test="${!empty pm.datas}">
           <c:forEach items="${pm.datas }" var="gamodle" varStatus="status">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		      <td align="center" vAlign="center">${gamodle.id }</td>
		      <td align="center" vAlign="center">${gamodle.population }</td>
	          <td align="center" vAlign="center">${gamodle.generation }</td>
	          <td align="center" vAlign="center">${gamodle.crossoverPossibility}</td>
	          <td align="center" vAlign="center">${gamodle.mutationPossibility}</td>
	          <td align="center" vAlign="center">
	          <c:choose>
	          	<c:when test="${gamodle.state==true}">
	          		<input type=checkbox name=state checked=false id="${gamodle.id }" onclick=chState(${gamodle.id })>
	          	</c:when>
	      		<c:otherwise>
	      			<input type=checkbox name=state id="${gamodle.id }" onclick=chState(${gamodle.id })>
	      		</c:otherwise>
	      		</c:choose>
	          </td>
	          
	          <td align="center" vAlign="center">
	          		 <a href="#" onclick="del('gaModle.do?method=del&id=${gamodle.id }');">删除</a>
	          	  <a href="#" onclick="openWin('gaModle.do?method=updateInput&id=${gamodle.id}','updategaModle',600,200);">修改</a>
	        </td>
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
<pg:pager url="gaModle.do" items="${pm.total }" export="currentPageNumber=pageNumber">
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
