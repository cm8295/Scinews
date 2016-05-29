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
    <%-- <form action="/Scinews/manage/expert2" method="post">
         <table border="0" cellpadding="2" cellspacing="1" id="data11" style="table-layout:fixed;">
             <tr>
                 <th>姓名</th>
                 <th>创造性</th>
                 <th>先进性</th>
                 <th>技术难度和复杂度</th>
                 <th>重现度和成熟度</th>
                 <th>完备程度</th>
                 <th>成果来源</th>
                 <th>论文影响力</th>
                 <th>奖项情况</th>
                 <th>著作情况</th>
                 <th>他人评价</th>
                 <th>市场适用性</th>
                 <th>技术辐射能力</th>
                 <th>市场迫切度</th>
                 <th>知识产权保护情况</th>
                 <th>经济效益</th>
                 <th>潜在效益</th>
                 <th>市场寿命</th>
                 <th>竞争力情况</th>
                 <th>行业成熟度</th>
                 <th>行业和产业发展</th>
                 <th>政策建议</th>
                 <th>资源环境改善</th>
                 <th>评审建议</th>
             </tr>
             <tr>
                 <td><a href="#" onclick="select(this)">张三</a></td>
                 <td><input type="text" id="aab" value=<%=jsonData %>></td>
             </tr>
         </table>
       <!--  <div>
            <table border="0" cellpadding="2" cellspacing="1" id="data" style="table-layout:fixed;"></table>
        </div> -->
        <input type="submit" value="提交" onclick="testss()"/>
    </form> --%>
    <%-- <input type="button" onclick="buttonsss()" value="<%=jsonData%>" id="ipd"/> --%>
    <input type="hidden" id="aab" value=<%=jsonData %> >
    <div>
            <table border="0" cellpadding="2" cellspacing="1" id="data" style="table-layout:fixed;"></table>
    </div>
</body>
</html>