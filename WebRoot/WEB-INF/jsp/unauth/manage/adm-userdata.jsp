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
        <script type="text/javascript" src="<%=path_content %>/js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="<%=path_content %>/js/adm-userdata.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
        <title>增加Table行</title>
    </head>
    <body>
    <div id="content">
  		<table id="patient_list"></table>
  	</div>
  	<div>
  	    <input type="text" id="tt" name="tt" class="tt" value=<%=path_content %>>
  	</div>
         <div>
  <table width="613" border="0" cellpadding="2" cellspacing="1" id="SignFrame">
              <tr id="trHeader">
                <td width="27" bgcolor="#96E0E2">序号</td>
                <td width="64" bgcolor="#96E0E2">用户姓名</td>
                <td width="98" bgcolor="#96E0E2">评审专家</td>
                <td width="92" bgcolor="#96E0E2">已提交资料</td>
                <td width="86" bgcolor="#96E0E2">时间</td>
                <td width="153" bgcolor="#96E0E2">意见</td>
                <td width="57" align="center" bgcolor="#96E0E2">&nbsp;</td>
              </tr>
        </table>
   </div>
   <div>
        <input type="button" name="Submit" value="添加参与人" onclick="AddSignRow()" />
     <input type="button" name="Submit2" value="清空" onclick="ClearAllSign()" />
     <input name='txtTRLastIndex' type='hidden' id='txtTRLastIndex' value="1" />
     <a href="/Scinews/manage/patentmanagement">数据请求</a>
     <input type="button" id="add" class="add" name="add" value="获取值" onclick="abc()">
     <a href="/Scinews/manage/sendEmail">发送邮件</a>
   </div>
    </body>
</html> 
  		