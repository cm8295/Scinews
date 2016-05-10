<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Texperts" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科技专家信息</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
</head>

<body>
<table width="1002"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td>
     <!--插入页头 -->   
      <%@ include file="/common/header.jsp"%>
     <!--插入页头完毕 -->   
    </td>
  </tr>
  <tr>
    <td><!-- 主题代码开始 -->	
	  <table width="1002" border="0" align="left" cellpadding="0" cellspacing="0">
        <tr>
          <td height="2" bgcolor="#FFFFFF">
            <form name="GetMap" action="GetMap" method="POST"> 
              <input type="text"  id="url" name="url" size="100"/>
              <input type="submit" value="确认"/>
            </form>
          </td>
        </tr>
      </table>
    </td>
    </tr>  
  
  <tr>
    <td>
     <!--插入页尾 -->   
     <%@ include file="/common/footer.jsp"%>
    <!--插入页尾完毕 -->    
    </td>
  </tr>
</table>

</body>
</html>
