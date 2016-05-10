<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
   String ifAdd = (String)request.getAttribute("ifAdd");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色添加</title>
<SCRIPT type="text/javascript" language="javascript">
//function $(id){return document.getElementById(id);}
function chk_role(){
  var loginname=document.getElementById('loginname');
  var loginnameval=document.getElementById('loginname').value;
  var checkpassword=document.getElementById('repassword');
            
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
<body>
<table width="800"  border="0" align="center" cellpadding="0" cellspacing="0">
<%
   if(!ifAdd.equals("0"))
   {
%>
  <tr>
    <td width="80%" height="73" colspan="3" background="images/bj2.jpg"><table width="22%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="55" height="33">&nbsp;</td>
        <td width="5" bgcolor="#FFFFFF"></td>
        <td width="11"></td>
        <td width="149"><span class="bai"><%=ifAdd%>角色添加成功</span></td>
      </tr>
    </table></td>
  </tr>
<%
   }
%>
  <tr>
    <td height="73" colspan="3" background="images/bj2.jpg"><table width="22%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="55" height="33">&nbsp;</td>
        <td width="5" bgcolor="#FFFFFF"></td>
        <td width="11"></td>
        <td width="149"><span class="bai">角色添加</span></td>
      </tr>
    </table></td>
  </tr>
   <tr>
       <td height="414" valign="top">
        <!-- <form name="role_add" action="rolesave" method="post" onsubmit="return chk_role();"> -->
         <form name="role_add" action="rolesave" method="post" onsubmit="return chk_role();"> 
        	<table width="80%"  border="1" cellspacing="0" cellpadding="0">
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">角色名称 </td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="text" id="rolename" name="rolename" size="40" maxlength="100" height="40"></input> <font color="red">*</font></td>
        	  </tr>  
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">角色代码 </td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="text" id="rolecode" name="rolecode" size="30" maxlength="50" height="40" ></input> <font color="red">*</font></td>
        	  </tr>  
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">角色说明</td>
        	    <td width="70%" height="50" align="left" valign="middle"><input type="text" id="roledesc" name="roledesc" size="30" maxlength="50" height="40" ></input> <font color="red">*</font></td>
        	  </tr>  
        	  <tr>
        	    <td width="30%" height="50" align="center" valign="middle">&nbsp;&nbsp;</td>
        	    <td width="70%" height="50" align="center" valign="middle"><input type="submit" value="提交"></td>
        	  </tr>          	          	  
           </table> 
        </form>
      </td>
   </tr>
</table>
</body>
</html>