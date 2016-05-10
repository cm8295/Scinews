<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
   String reason= (String) request.getAttribute("reason");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联创通出错处理页面</title>
</head>

<body>
<table>
<%
  if(reason.equals("NOSESSION"))
  { 
%>
<tr>
<td>页面长时间没有使用，SESSION 已经失效。请您重新登陆。</td>
</tr>
<%
  }
%>
</table>
</body>