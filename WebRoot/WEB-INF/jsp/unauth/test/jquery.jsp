<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<link rel="stylesheet" type="text/css"  href="css/main.css" />
<script src="static/jquery-2.1.0.js" type=text/javascript></script>
<script language="javascript" type="text/javascript">
function _show() {
var loginname = document.getElementById("loginname").value;
var _url = 'jqueryuser?name=' + loginname;
alert(loginname);
alert(_url);
$.get(_url, function() {
    alert('aa');
}); 
}	
</script>

<style type="text/css">
#user-reg li{margin-top:6px;}
#verfiy{cursor:pointer;border:1px solid #000;}
</style>
</head>

<body>
	<form name="user_register" method="post">
	<table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30%" height="25" align="center" valign="top">登录名 (登录名长度在6-15位之间，不能有中文、空格和特殊符号)</td>
	    <td width="70%" height="25" align="center" valign="top"><input type="text" id="loginname" name="loginname" size="40" maxlength="100" ></input></td>
	  </tr>  
	  <tr>
	    <td width="30%" height="25" align="center" valign="top">密码  (密码长度在6-15位之间)</td>
	    <td width="70%" height="25" align="center" valign="top"><input type="password" id="passwd" name="passwd" size="30" maxlength="50" ></input></td>
	  </tr> 
	  <tr>
	    <td width="100%" height="25" align="center" valign="top"><input type="submit" value="提交" onclick="_show()"/></td>
	  </tr> 	   
	 </table> 
  </form>
  
</body>
</html>
