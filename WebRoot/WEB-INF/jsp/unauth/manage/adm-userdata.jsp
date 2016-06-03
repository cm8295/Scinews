<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%
   String loginname = (String)session.getAttribute("loginname");
%>
<%
String path_content = request.getContextPath();
String basePath_content = request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+path_content+"/";
%>


<html>
    <head>
        <link rel="stylesheet" href="<%=path_content %>/css/jquery.date_input.pack.css" />
        <script type="text/javascript" src="<%=path_content %>/js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="http://www.js-css.cn/jscode/jquery.min.js"></script> 
        <script language="javascript" src="<%=path_content %>/js/jquery.date_input.pack.js"></script> 
        <script type="text/javascript" src="<%=path_content %>/js/adm-userdata.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
        <title>增加Table行</title>
    </head>
    <body>
    <script type="text/javascript">
	$(function(){
		$('.date_picker').date_input();
	})
	</script>
    <div id="content">
  		<table id="patient_list"></table>
  	</div>
         <div>
<!--    <table width="613" border="0" cellpadding="2" cellspacing="1" id="SignFrame">
              <tr id="trHeader">
                <td width="27" bgcolor="#96E0E2">序号</td>
                <td width="64" bgcolor="#96E0E2">用户姓名</td>
                <td width="98" bgcolor="#96E0E2">评审专家</td>
                <td width="92" bgcolor="#96E0E2">已提交资料</td>
                <td width="86" bgcolor="#96E0E2">时间</td>
                <td width="153" bgcolor="#96E0E2">意见</td>
                <td width="57" align="center" bgcolor="#96E0E2">&nbsp;</td>
              </tr>
        </table> -->
   </div>
   <div>
      <table width="613" border="0" cellpadding="2" cellspacing="1" id="data"></table>
   </div>
   <div>
     <input type="button" id="add" class="add" name="add" value="获取值" onclick="abc()">
     <a href="/Scinews/manage/sendEmail">发送邮件</a>
   </div>
   <div>
   <form id="setId" action="/Scinews/manage/setTime">
   	   <div>
       <lable>设置项目</lable>
       <p><label>项目名称</label>
       <input type="text" name="proName"/>
       </p>
       <p><label>起始日期：</label>
       <input name="startTime" style="width:226px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;padding: 7px;border-radius: 3px;" type="text" class="date_picker"></p>
       <p><label>截至日期：</label>
       <input name="endTime" style="width:226px;background: #fefefe;border: 1px solid #bbb;font-size: 14px;color: #333;padding: 7px;border-radius: 3px;" type="text" class="date_picker"></p>
       </p>
       </div>
       <input type="button" onclick="subSetting()" value="提交"/>
   </form>
   </div>
   </body>
</html> 
  		