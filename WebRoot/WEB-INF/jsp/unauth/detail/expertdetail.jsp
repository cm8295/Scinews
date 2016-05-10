<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="gov.lct.model.Texperts" %>

<%
  List<Texperts> experts = (List<Texperts>) request.getAttribute("expertItems");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家详细信息</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<script language="javascript">
function tabChange(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("ul"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "cli";
   arrayul[i].className = "";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "hidden";
  }
 }
}
</script>
</head>

<body>
<table width="77"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td width="15%" valign="top"><img src="images/1_01.jpg" width="141" height="519"></td>
    <td width="71%" align="center" valign="top">
	
	<!--主体表格开始  -->
	
	
	<table width="1000"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1" height="503" bgcolor="#FDFDFD"></td>
        <td height="503" align="center" valign="top">
		
		<!--页头开始-->
		<%@ include file="/common/header.jsp"%>
		<!--页头结束  -->
	
		
		<!--中间空白部分-->
		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="327" align="center" valign="top"> <!-- 中间最外层的TD开始 -->

             <!-- 专利详细信息开始 --> 
			   <table width="80%"  border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="30%" height="33"><div align="center"><span class="style6"> <span class="style9">【　科技专家详细信息　】</span></span></div></td>
	                    <td width="70%" align="left" class="zhong">&nbsp;</td>
	                  </tr>
	           </table>
	           <br/>
			   <table width="80%"  border="0" cellspacing="0" cellpadding="0">
	            <tr>
	              <td height="100%" align="left" valign="top">	              
	              <table width="98%" height="52"  border="0" align="center" cellpadding="0" cellspacing="0">
	                  <tr bgcolor="#A3D0DC">
	                  <th height="3"   class="hong2" scope="row"></th>
	                </tr>
					  <tr>
					  	<td>
					  	<table>
					  		<%
					  		   if(experts!=null)
					  		   {
					  		     for(Texperts expert : experts)
					  		     {
					  		%>
					  		<tr>
					  			<td width="250px" height="30" align="center"   bgcolor="#F0F8FD"><strong class="hong">姓名</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExpname()%>   <%=expert.getExpgender()==null?"":"("+expert.getExpgender()+")"%> </td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			              <%
			                  if(expert.getExpaddress()!=null)
			                  {			               
			              %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">地址</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExpaddress()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			               <%
			                  }
			                  if(expert.getExpdomain()!=null)
			                  {			               			                  
			               %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">领域</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExpdomain()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			               <%
			                  }
			                  if(expert.getExpeexphonor()!=null)
			                  {				                  
			               %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">所获荣誉</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExpeexphonor().replace("^A","").replace("^B"," ").replace("^C"," ")%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			                <%
			                  }
			                  if(expert.getExpjob()!=null)
			                  {				                  
			                  
			                %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">社会身份</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExpjob().replace("^A","").replace("^B"," ").replace("^C"," ")%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			                <%
			                  }
			                  if(expert.getExpwork1()!=null)
			                  {				                  			                  
			                %>			               
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">所属机构</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExpwork1()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			                <%
			                  }
			                  if(expert.getExparea()!=null)
			                  {				                  			                  
			                %>			               
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">擅长领域</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExparea()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			               <%
			                  }
			                  if(expert.getExptitle()!=null)
			                  {				                  			                  
			                %>			               
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">级别</strong></td>
					  			<td width="750px" height="30" class="lan"><%=expert.getExptitle()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			                <% 
			                  }
					  		     }
					  		   }
			               %> 
					     </table>
					   </td>
			  	     </tr>
                  </table>
                </td>
              </tr>
           </table> 
            <!-- 专利详细信息结束 --> 

            </td><!-- 中间最外层的TD结束 -->
          </tr>
         
        </table>

	           <br/>	
	
	
		
<!--尾文件开始-->
  <%@ include file="/common/footer.jsp"%>
<!--尾文件结束-->
		
		
		</td>
        <td width="1" bgcolor="#FDFDFD"></td>
      </tr>
    </table>
	
<!--主体表格结束  -->
	
	
	
	</td>
    <td width="14%" valign="top"><img src="images/1_05.jpg" width="139" height="519"></td>
  </tr>
</table>
</body>
</html>
