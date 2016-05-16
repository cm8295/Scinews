<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.print(basePath);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<base target="userupload"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/css/adm.css" />
<title></title>
</head>
<body>

<div id="adm-left-menubg">
  <div id="adm-left-menu-header" title="用户菜单"></div>
  <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/userstate">状态</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/userupload">资料提交</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"></div>

</div>

</body>
</html>