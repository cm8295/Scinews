<%@ page language="java" import="java.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.print(basePath);
%>

<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专家管理</title>
</head>
<body>
    <a href="manage/evluation1">查看评审信息</a>
</body>
</html>