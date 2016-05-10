<%@page contentType="text/html;charset=utf-8" errorPage="err.jsp"%>
<%@page import="java.util.*"%>

<%
	String realname = (String) session.getAttribute("realname");
%>

<script>
function checkForm()  
{
   if(document.form1.userName.value=="")
   {
      alert("用户名不能为空!");
      return false;
   }
   if(document.form1.password.value=="")
   {
       alert("密码不能为空!");
       return false;
   }  
}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧功能栏</title>
<LINK href="css/style.css" type=text/css rel=stylesheet>
<style type="text/css">
<!---->
body {
	margin-left: 0px;
	margin-right: 0px;
	background-color: #FFFFFF;
}
</style>
</head>
<body name="menu">
<table width="182" border="0" cellpadding="0" cellspacing="0" class="t"  height="100%">
	 
	<tr>
		<td height="30" align="left" scope="col" bgcolor="ffffdd">资源分类:</td>
	</tr>
	<tr>
		<td height="70%">
		<div id=dvBody2 style="overflow: auto; border-top: 0px; height: 100%; vertical-align: top;">
		<table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td height="25" align="left" class=liststyle2 style="text-indent: 25px;"><label>
				&nbsp;<strong><a
					href="site/site_list.jsp?type=category&categoryId="
					target="main">
					</a></strong></label></td>
			</tr>

		</table>
		</div>
		</td>
	</tr>
	 
</table>
</body>
</html>
