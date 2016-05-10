<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Tip" %>
<%@page import="gov.lct.model.Tuser" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>知识产权委托信息</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
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
	               <td width="30%" height="33"><div align="center"><span class="style6"> <span class="style9">【　知识产权委托信息　】</span></span></div></td>
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
				 <form name="ipadd" action="iprequestadd" method="post" enctype="multipart/form-data" onsubmit="return chk_ipadd();">	
 	        	 <table width="98%"  border="0" cellspacing="0" cellpadding="0">
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">委托事务名称:&nbsp;&nbsp;&nbsp;&nbsp; </td>
        	        <td width="80%" height="50" align="left" valign="middle"><input type="text" id="title" name="title" size="80" maxlength="100" height="40"></input> <font color="red">*</font></td>
        	      </tr>   	        	 				  		
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">委托机构 :&nbsp;&nbsp;&nbsp;&nbsp; </td>
        	        <td width="80%" height="50" align="left" valign="middle"><input type="text" id="client" name="client" size="70" maxlength="100" height="40"></input> <font color="red">*</font></td>
        	      </tr>  
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">受委托机构:&nbsp;&nbsp;&nbsp;&nbsp;  </td>
        	        <td width="80%" height="50" align="left" valign="middle"><input type="text" id="agent" name="agent" size="70" maxlength="50" height="40" ></input> <font color="red">*</font> <div class="hui">(长度在6-15位之间)</div></td>
        	      </tr>  
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">委托需求:&nbsp;&nbsp;&nbsp;&nbsp; </td>
        	        <td width="80%" height="50" align="left" valign="middle"><textarea id="request" name="request" rows="15" cols="80"></textarea> <font color="red">*</font></td>
        	      </tr>  
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">经办人:&nbsp;&nbsp;&nbsp;&nbsp; </td>
        	        <td width="80%" height="50" align="left" valign="middle"><input type="text" id="person" name="person" size="50" maxlength="50" height="40" ></input></td>
        	      </tr>  
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">经办人电子邮箱:&nbsp;&nbsp;&nbsp;&nbsp; </td>
        	        <td width="80%" height="50" align="left" valign="middle"><input type="text" id="email" name="email" size="40" maxlength="50" height="40" ></input></td>
        	      </tr>  
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">经办人联系电话:&nbsp;&nbsp;&nbsp;&nbsp; </td>
        	        <td width="80%" height="50" align="left" valign="middle"><input type="text" id="telephone" name="telephone" size="40" maxlength="50" height="40" ></input></td>
        	      </tr>    
        	      <tr>
        	        <td width="20%" height="50" align="right" valign="middle" class="bigblue">上传附件:&nbsp;&nbsp;&nbsp;&nbsp; </td>
        	        <td width="80%" height="50" align="left" valign="middle"><input type="file" id="attachment" name="attachment" size="40" maxlength="50" height="40" ></input></td>
        	      </tr>         	      
        	      <tr>
        	        <td colspan="2" height="50" align="left" valign="middle"><input type="submit" name="GO" ></input></td>
        	      </tr>   
			    </table>  		               
                     </form>
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
