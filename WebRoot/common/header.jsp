<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<%
   String[] subjectname = (String[])session.getAttribute("subjectname");
   int[] subjectgid = (int[])session.getAttribute("subjectgid");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="200">
<script language="javascript" type="text/javascript" src="${ctx}/static/jquery-1.4.4.min.js"></script>
</head>

<body>
<table width="1002"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="113" align="right" valign="top" background="images/title.jpg"><table width="53%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="33" align="right"><div align="right" class="ju"></div>          <div align="right">
          <table width="67%" height="19"  border="0" cellpadding="0" cellspacing="0" bordercolor="#ECE9D8">
            <tr>
              <td width="260" align="center"></td>
              <td width="183" align="right"></td>
            </tr>
          </table>
        </div></td>
        </tr>
      <tr>
        <td height="63"><table width="95%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="80%" height="41">	   
 			</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="52" background="images/dht.jpg"><div align="center" class="bai">
    
    <a href="index" class="bai">首页</a>&nbsp; 
    <%
       for(int ii=0; ii<subjectname.length; ii++)
       {
    	 if(!subjectname[ii].equals("激光技术")) 
    	 {
    %> 
          <a href="SubjectNews?pagetype=init&currentpage=0&groupid=<%=subjectgid[ii]%>" target="_self" class="bai"><%=subjectname[ii]%></a>&nbsp;
    <%	  
    	 }
       }
    %> 
   </div>   
  </tr>
</table>


</body>
</html>