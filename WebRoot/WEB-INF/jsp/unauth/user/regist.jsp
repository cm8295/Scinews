<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginname = (String) request.getAttribute("loginname");
String realname = (String) request.getAttribute("realname");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<link rel="stylesheet" type="text/css"  href="css/main.css" />
<SCRIPT language="javascript" >
//function $(id){return document.getElementById(id);}
<!--
function chk_userreg(){
    var loginname=document.getElementById('loginname');
    var loginnameval=document.getElementById('loginname').value;
    var password=document.getElementById('password');
    var passwordval=document.getElementById('password').value; 
    var checkpassword=document.getElementById('repassword');
    var checkpasswordval=document.getElementById('repassword').value;  
    var email=document.getElementById('email');
    var emailval=document.getElementById('email').value;
    var department=document.getElementById('institute');
    var departmentval=document.getElementById('institute').value;
    var realname=document.getElementById('realname');
    var realnameval=document.getElementById('realname').value;    
              
	if(loginnameval=="" || loginnameval.length<6 || loginnameval.length>15){
	  alert("登录名为6-12位！");
	  loginname.focus();
	  return false;
	}

	var pattern_uname = /^[a-zA-Z][a-zA-Z0-9_]{3,11}[a-zA-Z0-9]$/i;
	if(!pattern_uname.test(loginnameval)){
	  alert('请输入6-12位由字母开头，不能有中文、空格和特殊符号！');
	  loginname.focus();
	  return false;
	}	

	if(passwordval=="" || passwordval.length<6 || passwordval.length>15){
	  alert("密码有误，请确保密码为6-15位合法字符！");
	  password.focus();
	  return false;
    }
	if(checkpasswordval.length!=passwordval){
	  alert("两次密码输入内容不一致！");
	  checkpassword.focus();
	  return false;
    }

    if(emailval== '') {
  	  alert("请输入邮箱地址!") 
  	  email.focus();
  	  return false; 
  	 }

	var pattern_mail = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+.)+[A-Za-z0-9]{2,3}$/;	
    if(emailval== '' || !pattern_mail.test(emailval)) {
	  alert("请输入正确的邮箱地址!") 
	  email.focus();
	  return false; 
	 }
	 
}
//-->
</script>
<style type="text/css">
#user-reg li{margin-top:6px;}
#verfiy{cursor:pointer;border:1px solid #000;}
</style>
</head>

<body>
	<form name="user_register" action="insertuser" method="post" onsubmit="return chk_userreg();">
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
	    <td width="30%" height="25" align="center" valign="top">确认密码</td>
	    <td width="70%" height="25" align="center" valign="top"><input type="password" id="repasswd" name="repasswd" size="30" maxlength="50" ></input></td>
	  </tr>  
	  <tr>
	    <td width="30%" height="25" align="center" valign="top">真实姓名</td>
	    <td width="70%" height="25" align="center" valign="top"><input type="text" id="realname" name="realname" size="30" maxlength="50" ></input></td>
	  </tr>  
	  <tr>
	    <td width="30%" height="25" align="center" valign="top">电子邮箱</td>
	    <td width="70%" height="25" align="center" valign="top"><input type="text" id="email" name="email" size="40" maxlength="50" ></input></td>
	  </tr>
	  <tr>
	    <td width="30%" height="25" align="center" valign="top">所属单位名称</td>
	    <td width="70%" height="25" align="center" valign="top">
	    <select name="institute">
	     <option value="中国科学院成都文献情报中心">中国科学院成都文献情报中心</option>
	     <option value="中国科学院成都生物研究所">中国科学院成都生物研究所</option>
	     <option value="中国科学院山地灾害与环境研究所">中国科学院山地灾害与环境研究所</option>
	     <option value="中国科学院光电技术研究所">中国科学院光电技术研究所</option>
	     <option value="中国科学院成都有机化学公司">中国科学院成都有机化学公司</option>
	     <option value="中国科学院成都信息技术有限公司">中国科学院成都信息技术有限公司</option>
	     <option value="中国科学院重庆绿色智能技术研究院">中国科学院重庆绿色智能技术研究院</option>
	     <option value="中国科学院昆明动物研究所">中国科学院昆明动物研究所</option>
	     <option value="中国科学院昆明植物研究所">中国科学院昆明植物研究所</option>
	     <option value="中国科学院西双版纳植物园">中国科学院西双版纳植物园</option>
	     <option value="中国科学院地球化学研究所">中国科学院地球化学研究所</option>
	     <option value="中国科学院云南天文台">中国科学院云南天文台</option>
	    </select> 
	    </td>
	  </tr>
	  	    
	  <tr>
	    <td width="100%" height="25" align="center" valign="top"><input type="submit" value="提交"/></td>
	  </tr>  
	  
	 </table> 
  </form>
  <p/>
  <%
    if(loginname!=null)
    {
  %>
       <%=loginname%>
  <%
    }
  %>     

  <%
  if(realname!=null)
  {
  %>
     <%=realname%>
  <%
  }
  %>     
</body>
</html>
