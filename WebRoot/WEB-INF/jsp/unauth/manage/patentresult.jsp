<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ page import="java.util.Collection"%>
<%@ page import="gov.lct.model.Tpatentbasicinfo"%>
<%
Collection availableItems = (Collection)request.getAttribute("availableItems");
Iterator patents = null;
if(availableItems!=null)
{
	patents = availableItems.iterator();
}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form name="require" id="require" action="patentrecommendsave" method="post">                    
   <table width="80%" height="50%" border=1 align="center" cellpadding=0 cellspacing=0 bgcolor="#FFFFFF">
     <tr>
       <td align="center" colspan="6">专利展示 </td>
     </tr>
     <tr>
       <td align="center">ID</td><td align="center">专利名称</td><td align="center">专利申请号</td><td align="center">专利权人</td><td align="center">是否推荐</td>
     </tr>
       <%
          int i=1;
          while(patents.hasNext())
          {
        	 Tpatentbasicinfo patentinfo = (Tpatentbasicinfo)patents.next();
       %>       
       <tr>
         <td><%=i%></td><td><%=patentinfo.getPatentTi()%></td><td><%=patentinfo.getPatentAn()%></td><td><%=patentinfo.getPatentFpa()%></td><td><input type="checkbox" name="patentcheck" value="<%=patentinfo.getId()%>" checked></td>
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