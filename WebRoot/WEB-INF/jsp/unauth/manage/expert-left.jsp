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
<base target="expert1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=path_content %>/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=path_content %>/js/expert-left.js"></script>
<title>专家左侧导航栏</title>
</head>
<body>
    <div>
        <div><a href="/Scinews/manage/expert2">评估任务</a></div>
        <div><a href="/Scinews/manage/expert1">已评审</a></div>
        <%-- <input type ="text" value=<%=jsonData %>>
        <input type="button" id="bt1" value="获取值" onclick="getdata()"/> --%>
    </div>
    
    
</body>
</html>