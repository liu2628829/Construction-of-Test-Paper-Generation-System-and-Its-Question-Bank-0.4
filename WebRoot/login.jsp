<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户登录</title>
    <script src="js/jquery-1.11.1.js"></script>
    <script src="js/login.js"></script>
    <!--  -->
    <link href="ceshidenglu/style.css" rel="stylesheet" type="text/css" />
</head>
<!--  -->
<body bgcolor="#016aa9" >
<s:form action = "/loginAction.action" method = "post">
    <table width="1002" border="0" align="center" cellpadding="0" cellspacing="0" class="log">
        <tr>
            <td align="center"><table width="500" border="0" cellspacing="0" cellpadding="0" style="margin-top:70px">
                <tr><td>&nbsp;</td><td>${message }</td></tr>
                <tr>
                    <div class="loginform_row">
                    <td width="180" height="30" align="right">用户名：</td>
                    <td width="140" align="left"><input type="text" class="loginform_input" name="username" /></td>
                    <td>&nbsp;</td>
                    </div>
                </tr>
                <tr>
                    <td height="30" align="right">密 &nbsp;码：</td>
                    <td align="left"><input name="password" type="password" class="loginform_input" id="textfield2" /></td>
                    <div class="loginform_row">
                                            <span class = "returnInfo"></span>
                        <td align="left"><input name="button" type="submit" class="loginform_submit" id="button"  value="登录" /></td>
                                           
                                        </div>
                </tr>


            </table>
            </td>
        </tr>
    </table>
</s:form>

</body>
</html>