<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.print(basePath);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.11.1.js"></script>
 <script type="text/javascript" src="<%=basePath %>/js/expert1.js"></script>
<title></title>
</head>
<body>
    <input type="text" value="sdfsdf"/>
    <div>
        <table border="0" cellpadding="2" cellspacing="1" id="data" style="table-layout:fixed;"></table>
    </div>
</body>
</html>