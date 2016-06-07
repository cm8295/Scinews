<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.Collection" %>
<%@ page import="gov.lct.model.Tevaluation" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginname = (String) request.getAttribute("loginname");
String realname = (String) request.getAttribute("realname");
String user = (String)request.getAttribute("user");
Collection availableItems = (Collection)request.getAttribute("availableItems");
Iterator evalu = null;
if(availableItems!=null)
{
	evalu = availableItems.iterator();
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<SCRIPT src="${ctx }/js/flashobj.js" type=text/javascript></SCRIPT>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-image: url(images/bj.jpg);
	background-repeat: repeat-x;
}

.searchinput{
	padding-left: 3px;
	width: 288px;
	font-family: arial;
	float: left;
	color: #DB7801;
	margin-left: 4px;
	font-size: 10pt;
	vertical-align: middle;
	margin-right: 3px;
	background-color: #12285A;
	border: 1px #FF6600;
	height: 25px;
}
.tab_search{
	height: 27px;
	border: 1px solid #DB7801;
}
.searchaction{
	width: 111px;
	float: left;
	height: 25px;
}

.ju {
	font-size: 12px;
	color: #F8BA3A;
	text-decoration: none;
}
.bai {
	font-size: 14px;
	color: #FFFFFF;
	text-decoration: none;
	font-weight: bolder;
}
.hui {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #666666;
	text-decoration: none;
	background-position: left;
	line-height: 140%;
	font-weight: lighter;
}
.zong {
	font-size: 13px;
	color: #A0944C;
	text-decoration: none;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}
.hei {
	font-size: 12px;
	color: #000000;
	text-decoration: none;
}
.hui_ch {
	font-size: 12px;
	color: #4D4D4D;
	text-decoration: none;
}
.bigblue {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #006882;
	text-decoration: none;
	font-weight: bold;
}
.bai2 {
	font-size: 12px;
	color: #FFFFFF;
	text-decoration: none;
	line-height: 150%;
}

-->
</style>

<SCRIPT type="text/javascript" language="javascript">
//function $(id){return document.getElementById(id);}
function chk_userreg(){
  var loginname=document.getElementById('loginname');
  var loginnameval=document.getElementById('loginname').value;
  var password=document.getElementById('password');
  var passwordval=document.getElementById('password').value; 
  var checkpassword=document.getElementById('repassword');
  var checkpasswordval=document.getElementById('repassword').value;  
  var email=document.getElementById('email');
  var emailval=document.getElementById('email').value;
  var realname=document.getElementById('realname');
  var realnameval=document.getElementById('realname').value;    
            
	if(loginnameval=="" || loginnameval.length<6 || loginnameval.length>12){
	  alert("登录名输入有误！");
	  loginname.focus();
	  return false;
	}

	var pattern_uname = /^[a-zA-Z][a-zA-Z0-9_]{3,11}[a-zA-Z0-9]$/i;
	if(!pattern_uname.test(loginnameval)){
	  alert('请输入5-12位由字母开头，不能有中文、空格和特殊符号！');
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

	var pattern_mail = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+.)+[A-Za-z0-9]{2,3}$/;	
  if(emailval== '' || !pattern_mail.test(emailval)) {
	  alert("请输入正确的邮箱地址!") 
	  email.focus();
	  return false; 
	 }
}
</script>
</head>

<body onload="createCode()">
<table width="1002"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="73" colspan="3" background="images/bj2.jpg"><table width="22%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="55" height="33">&nbsp;</td>
        <td width="5" bgcolor="#FFFFFF"></td>
        <td width="11"></td>
        <td width="149"><span class="bai">用户注册</span></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="718" colspan="3" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="62%" height="718" align="center" valign="top" bgcolor="#FFFFFF"><table width="91%"  border="0" cellspacing="0" cellpadding="0">

          <tr>
            <td height="2" bgcolor="#04ABDF"></td>
          </tr>
          <tr>
            <td height="40"></td>
          </tr>
          <tr>
            <td height="40">
            <%
              if(loginname!=null)
              {
            %>
                <div class="zong"><%=realname%>,您已经注册成功！</div> 
            <%
              }
            %>
            </td>
          </tr>
          <tr>
            <td height="414" valign="top">
        	<form name="user_register" action="userSuggestion" method="post" onsubmit="return chk_userreg();">
        	<table width="80%"  border="1" cellspacing="0" cellpadding="0">
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">登录名 </td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="text" id="loginname" name="loginname" size="40" readonly="readonly" maxlength="100" height="40" value=<%=user %>></input></td>
        	  </tr>  
        	  <!-- <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">密码 </td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="password" id="passwd" name="passwd" size="30" maxlength="50" height="40" ></input> <font color="red">*</font> <div class="hui">(长度在6-15位之间)</div></td>
        	  </tr>  
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">确认密码</td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="password" id="repasswd" name="repasswd" size="30" maxlength="50" height="40" ></input> <font color="red">*</font></td>
        	  </tr>  
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">真实姓名</td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="text" id="realname" name="realname" size="30" maxlength="50" height="40" ></input></td>
        	  </tr>  
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">电子邮箱</td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="text" id="email" name="email" size="40" maxlength="50" height="40" ></input></td>
        	  </tr>  --> 
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">建议</td>
        	    <td width="70%" height="50" align="left" valign="middle">
        	  	  <select name="suggest" multiple="multiple" size="5">
	              <%
	                 if(availableItems!=null)
	                 {
                       while(evalu.hasNext())
                       {
                    	 Tevaluation roleinfo = (Tevaluation)evalu.next();  
                    	 if(roleinfo.getSuggestion() == null){
                    		 continue;
                    	 }
                  %>
                 
                         <option value=<%=roleinfo.getSuggestion()%>><%=roleinfo.getSuggestion()%></option>
                  <%
                       }
	                 }
                  %> 
          </select>        	    
        	    </td>
        	  </tr>  
 
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle">&nbsp;&nbsp;</td>
        	    <td width="70%" height="50" align="center" valign="middle"><input type="submit" value="提交"></td>
        	  </tr>          	  
        	 </table> 
        	 </form>
          </tr>
          <tr>
            <td height="15" background="images/bj6.jpg">&nbsp;</td>
          </tr>
         </table>
       </td>
      </tr>
     
     </table>
    </td>
  </tr>

</table>
</body>
</html>
