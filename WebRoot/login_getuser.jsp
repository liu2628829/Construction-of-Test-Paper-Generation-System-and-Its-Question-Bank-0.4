<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <link href="style/ga.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="script/public.js"></script>
    <title>用户管理</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
    <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
        <TR height=35>
            <TD align=middle width=20 background=images/title_left.gif
                bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=images/title_left.gif
                bgColor=#dee7ff><FONT color=#f7f7f7> 用户管理<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
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
                <a href="#" onclick="openWin('user.do?method=addInput','adduser',600,200);">添加用户</a>
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
            <td width="5%" height="37" align="center"><b>用户编号</b></td>
            <td width="18%" height="37" align="center"><B>用户称呼</B></td>
            <td width="18%" height="37" align="center"><b>用户名</b></td>
            <td width="18%" height="37" align="center"><b>密码</b></td>
            <td width="18%" height="37" align="center"><b>用户权限</b></td>
            <td width="18%" height="37" align="center"><b>相关操作</b></td>
        </tr>
        <!-- 列表数据栏 -->
        <c:if test="${!empty pm.datas}">
            <c:forEach items="${pm.datas }" var="user">
                <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
                    <td align="center" vAlign="center">${user.id }</td>
                    <td align="center" vAlign="center">${user.name }</td>
                    <td align="center" vAlign="center">${user.userName}</td>
                    <td align="center" vAlign="center">${user.password}</td>
                    <td align="center" vAlign="center">
                        <c:choose>
                            <c:when test="${user.popedom eq '0'}">
                                普通用户
                            </c:when>
                            <c:when test="${user.popedom eq '1'}">
                                专家用户
                            </c:when>
                            <c:otherwise>
                                系统管理员
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td align="center" vAlign="center">
                        <a href="#" onclick="del('user.do?method=del&id=${user.id }');">删除</a>
                        <a href="#" onclick="openWin('user.do?method=updateInput&id=${user.id }','updateuser',600,200);">修改</a>
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
    <table width="1002" border="0" align="center" cellpadding="0" cellspacing="0" class="log">
        <tr>
            <td align="center"><table width="500" border="0" cellspacing="0" cellpadding="0" style="margin-top:70px">
                <tr><td>&nbsp;</td><td>${message }</td></tr>
                <tr>
                    <td width="180" height="30" align="right">用户名：</td>
                    <td width="140" align="left"><input name="sid" type="text" class="login-input" id="textfield" /></td>
                    <td>&nbsp;</td>
                </tr>
                if(user.userName != 'admin'){

                alert("用户名不能为空");

                }



                <tr>
                    <td height="30" align="right">密 &nbsp;码：</td>
                    <td align="left"><input name="pwd" type="password" class="login-input" id="textfield2" /></td>
                    <td align="left"><input name="button" type="submit" class="login-button" id="button" onclick="window.location.href='index.jsp'" value="登录" /></td>
                </tr>


            </table>
    <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
        <TR>
            <TD height=28 align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
                <!-- 可以在这里插入分页导航条 -->
                <pg:pager url="user.do" items="${pm.total }" export="currentPageNumber=pageNumber">

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
