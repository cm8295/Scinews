<%@ page language="java" import="net.sf.json.JSONObject" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
JSONObject jsonData = (JSONObject)request.getAttribute("jsonData");
%>
<html>
<head>
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.11.1.js"></script>

<script type="text/javascript" src="<%=basePath %>/js/expert2.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评审任务</title>
</head>
<body>
    <input type="hidden" id="aab" value=<%=jsonData %> >
    <!-- <a href="/Scinews/manage/download">下载</a> -->
    <!-- <form action="/Scinews/manage/download?fileName=test" enctype="multipart/form-data" method="post">
       <input type="submit" value="下载">
    </form> -->
    <div>
       <!-- <table border="0" cellpadding="2" cellspacing="1" id="data" style="table-layout:fixed;width:100%"></table> -->
       <table border="0" id="data" style="table-layout:fixed"></table>
    </div>
</body>
</html>