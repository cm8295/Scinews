<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="gov.lct.model.Tpolice" %>

<%
  List<Tpolice> policys = (List<Tpolice>) request.getAttribute("policyItems");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>政策法规信息</title>
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
	                    <td width="30%" height="33"><div align="center"><span class="style6"> <span class="style9">【　政策法规详细信息　】</span></span></div></td>
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
					  		   if(policys!=null)
					  		   {
					  		     for(Tpolice policy : policys)
					  		     {
					  		%>
					  		<tr>
					  			<td width="250px" height="30" align="center"   bgcolor="#F0F8FD"><strong class="hong">政策法规名称</strong></td>
					  			<td width="750px" height="30" class="lan"><%=policy.getTitle()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			               <%
			                  if(policy.getCountry()!=null)
			                  {
			               %>
					  		<tr>
					  			<td width="250px" height="30" align="center"   bgcolor="#F0F8FD"><strong class="hong">国家</strong></td>
					  			<td width="750px" height="30" class="lan"><%=policy.getCountry()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			              <%
			                  }
			                  if(policy.getProvince()!=null)
			                  {			               
			              %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">省市</strong></td>
					  			<td width="750px" height="30" class="lan"><%=policy.getProvince()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			               <%
			                  }
			                  if(policy.getInstitute()!=null)
			                  {			               			                  
			               %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">发布机构</strong></td>
					  			<td width="750px" height="30" class="lan"><%=policy.getInstitute()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			               <%
			                  }
			                  if(policy.getPublishdate()!=null)
			                  {				                  
			               %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">发布时间</strong></td>
					  			<td width="750px" height="30" class="lan"><%=policy.getPublishdate()%></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			                <%
			                  }
			                  if(policy.getUrl()!=null)
			                  {				                  
			                  
			                %>
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">访问地址</strong></td>
					  			<td width="750px" height="30" class="lan"><a href="<%=policy.getUrl()%>" target="_blank"><%=policy.getUrl()%></a></td>
					  		</tr>
					  		<tr bgcolor="#A3D0DC">
			                  <th height="1" colspan="2" bgcolor="#A3D0DC" class="hong2" scope="row"></th>
			                </tr>
			                <%
			                  }
			                  if(policy.getContent()!=null)
			                  {				                  			                  
			                %>			               
			                <tr>
					  			<td width="250px" height="30" align="center"  bgcolor="#F0F8FD"><strong class="hong">内容</strong></td>
					  			<td width="750px" height="30" class="lan"><textarea rows="10" cols="80"><%=policy.getContent()%></textarea></td>
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
