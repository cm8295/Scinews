<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.print(basePath);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<base target="main"/>
<link rel="stylesheet" type="text/css" href="/css/adm.css" />
<script type="text/javascript" src="/js/adm.js" language="javascript"></script>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script type="text/javascript">
<!--
function stats_submenu(){
  var submenustyle = document.getElementById("adm-left-menu-submenu");
  if(submenustyle.style.display!="none"){
  submenustyle.style.display="none";
  }
  else{
  submenustyle.style.display="block";
  }
}
//-->
</script>
</head>

<body>


<div id="adm-left-menubg">
  <div id="adm-left-menu-header" title="内容发布管理系统"></div>
  <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">角色管理</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/roleadd">角色增加</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">角色修改</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">角色删除</div>
  <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">管理用户</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="regist">用户增加</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">用户修改</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">用户删除</div>
  <div class="adm-left-menu-bg" id="adm-left-menu-bg-3" onmouseover="cg_adm_left(3)" onmouseout="cc_adm_left(3)">专家管理</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">专家增加</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">专家修改</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">专家删除</div>
  <div class="adm-left-menu-bg" id="adm-left-menu-bg-3" onmouseover="cg_adm_left(3)" onmouseout="cc_adm_left(3)"><a href="#">专利管理</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/patentmanage">推荐专利查看</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/patentrecommend">专利推荐</a></div>
  <div class="adm-left-menu-bg" id="adm-left-menu-bg-3" onmouseover="cg_adm_left(3)" onmouseout="cc_adm_left(3)">需求管理</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/require">需求增加</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/requireauth">需求审核</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)">需求删除</div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/admuserdata">用户材料提交</a></div>
      <div class="adm-left-menu-bg" id="adm-left-menu-bg-2" onmouseover="cg_adm_left(2)" onmouseout="cc_adm_left(2)"><a href="manage/admuserdata"></a></div>
</div>
</body>
</html>

