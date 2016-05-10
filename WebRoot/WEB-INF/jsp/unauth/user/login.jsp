<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String error=(String)request.getAttribute("error");
    if(error.equals("false"))
    	error = "";
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>登录</title>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
}
.lan {
	font-size: 9pt;
	color: #808080;
	text-decoration: none;
}
.hei {
	font-size: 10pt;
	color: #000000;
}
-->
</style>
<style type="text/css">  
        .code  
        {  
            background-image:url(code.jpg);  
            font-family:Arial;  
            font-style:italic;  
            color:Red;  
            border:0;  
            padding:2px 3px;  
            letter-spacing:3px;  
            font-weight:bolder;  
        }  
        .unchanged  
        {  
            border:0;  
        }  
    </style>  
    <script language="javascript" type="text/javascript">  
      
     var code ; //在全局 定义验证码  
     function createCode()  
     {   
       code = "";  
       var codeLength = 4;//验证码的长度  
       var checkCode = document.getElementById("checkCode");  
       var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的  
          
       for(var i=0;i<codeLength;i++)  
       {  
        
          
       var charIndex = Math.floor(Math.random()*36);  
       code +=selectChar[charIndex];  
         
         
       }  
	   //alert(code);  
       if(checkCode)  
       {  
         checkCode.className="code";  
         checkCode.value = code;  
       }  
         
     }  
       
      function validate ()  
     {  
       var inputCode = document.getElementById("input1").value.toUpperCase();//转换为大写
       
       if(inputCode.length <=0)  
       {  
           alert("请输入验证码！");  
           return false;
       }  
       else if(inputCode != code )  
       {  
          alert("验证码输入错误！");  
          createCode();//刷新验证码  
          return false;
       }  
       //else  alert("^-^ OK");  
       
       return true;
         
       }  
         
    </script>  

</head>

<body onload="createCode()">
<form name="form1" method="post" action="logincheck" onsubmit="return validate();">
  <br>
  <br>
  <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="733" height="343" background="images/3.jpg"><table width="339" height="196" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="109"></td>
        </tr>
        <tr>
          <td height="79"><table width="550" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="123" height="38">&nbsp;</td>
              <td width="71" height="38" class="hei">用户名</td>
              <td width="130" height="38"><input name="loginname" type="text" size="24"></td>
              <td width="190" height="38">&nbsp;</td>
            </tr>
            <tr>
              <td height="38">&nbsp;</td>
              <td height="38" class="hei">密码</td>
              <td height="38"><input name="passwd" type="password" size="24"></td>
              <%
            	if (error.equals("true")) 
            	{
            		
             %>
             	<td><font color="#ff0000">用户名密码错误</font></td>
             <%
             	}
              %>
            </tr>
            <tr>
              <td width="123" height="38">&nbsp;</td>
              <td width="71" height="38" class="hei">验证码</td>	
              <td align="left">
               	<input  type="text" id="input1"  size="10"/>  
    			<input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 60px"  />
               </td>
               <td><input type="image" src="images/2.jpg" width="49" height="18"></td>                
            </tr>
            <tr>
              <td width="123" height="38">&nbsp;</td>
              <td width="71" height="38" class="hei"></td>
              <td width="130" height="38">
              <%
                 if(error.equals(""))                	 
              %>
                 <%=error%>                 
              </td>
              <td width="190" height="38">&nbsp;</td>
            </tr>
            <tr>
            <td width="123" height="38" align="center" valign="top">
              <input type="submit" value="登录"/>
            </td>
          </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
  </table>
  
 
  
  
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="1" bgcolor="#ACACAC"></td>
    </tr>
	  <tr>
      <td height="40"><div align="center" class="lan">版权所有：中国科学院国家科学图书馆成都分馆</div></td>
    </tr>
  </table>
</form>
</body>
</html>
