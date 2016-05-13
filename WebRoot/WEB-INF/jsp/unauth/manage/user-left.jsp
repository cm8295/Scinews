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
<base target="userState"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/css/adm.css" />
<title>Insert title here</title>
</head>
<body>

<div id="adm-left-menubg">
  <div id="adm-left-menu-header" title="用户菜单"></div>
  <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">状态</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/pageUpload">资料提交</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">角色删除</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">管理用户</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="regist">用户增加</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">用户修改</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">用户删除</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-3" onmouseover="cg_adm_left(3)" onmouseout="cc_adm_left(3)">专家管理</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">专家增加</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">专家修改</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">专家删除</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-3" onmouseover="cg_adm_left(3)" onmouseout="cc_adm_left(3)">专利管理</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/patentmanage">推荐专利查看</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/patentrecommend">专利推荐</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-3" onmouseover="cg_adm_left(3)" onmouseout="cc_adm_left(3)">需求管理</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/require">需求增加</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/requireauth">需求审核</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">需求删除</div>

</div>

</body>
</html>