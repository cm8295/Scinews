<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Collection"%>
<%@ page import="gov.lct.model.Trequire"%>
<%
Collection availableItems = (Collection)request.getAttribute("availableItems");
Iterator requires = null;
if(availableItems!=null)
{
   requires = availableItems.iterator();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员需求信息审核</title>
</head>
<body>
   <form name="require" id="require" action="requireauthsave" method="post">         
     <table width="80%" height="50%" border=1 align="center" cellpadding=0 cellspacing=0 bgcolor="#FFFFFF">
       <tr>
         <td align="center">ID</td><td align="center">需求名称</td><td align="center">需求内容</td><td align="center">提交机构</td><td align="center">需求状态</td>
       </tr>
       <%
          int i=1;
          while(requires.hasNext())
          {
        	Trequire reqinfo = (Trequire)requires.next();
       %>       
       <tr>
         <td><%=i%></td><td><%=reqinfo.getName()%></td><td><%=reqinfo.getContent()%></td><td><%=reqinfo.getUnitName()%></td><td><input type="checkbox" name="reqradio" value="<%=reqinfo.getId()%>" checked></td>
       </tr>
       <%
           i=i+1;
          }
       %>
       <tr>
         <td colspan="6" align="center"><input class="button" type="submit" value="添加信息"/>&nbsp;&nbsp;<input  class="button" type="reset" value="重置数据"/></td>
       </tr>
     
     </table>
   </form>    
</body>
</html>