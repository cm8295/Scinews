<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" width="1000" >
  <tr>
    <td valign="top" align="center" bgcolor="#6da9fb">用户反馈列表</td>
  </tr>
</table>
<c:out value="{$session.getParameter('sessionMessage')}"/>
<table>
  <tr>
    <td>标题</td><td>关键词</td><td>内容</td><td>反馈人</td><td>反馈时间</td><td>当前状态</td>
  </tr>
<c:forEach var="item" items="${feedbackmap}"> 
 <tr>
   <td>${item.value.title}</td>
   <td>${item.value.keyword}</td>
   <td>${item.value.content}</td>
   <td>${item.value.loginname}</td>
   <td>${item.value.createDate}</td>
   <td><c:if test="${item.value.status==0}">未回复</c:if></td>
 </tr>    
</c:forEach>
</table> 

</body>
</html>