<%@ page language="java" import="net.sf.json.JSONObject" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
String path_content = request.getContextPath();
String basePath_content = request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+path_content+"/";

JSONObject jsonData = (JSONObject)request.getAttribute("jsonData");

%>
<html>
<head>
<base href="<%=basePath_content%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=path_content %>/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=path_content %>/js/expert-left.js"></script>
<title>test</title>
</head>
<body>
    <a href="/Scinews/manage/getData">数据请求</a>
    <input type ="text" value=<%=jsonData %>>
    <input type="button" id="bt1" value="获取值" onclick="getdata()"/>
</body>
</html>