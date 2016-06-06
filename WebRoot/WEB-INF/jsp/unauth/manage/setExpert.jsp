<%@page import="gov.lct.model.Tuser"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="gov.lct.model.Tuser" %>

<%
   String loginname = (String)session.getAttribute("loginname");
%>
<%
String path_content = request.getContextPath();
String basePath_content = request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+path_content+"/";
String user = (String)request.getAttribute("user");
String number = (String)request.getAttribute("number");
Collection availableItems = null;
availableItems = (Collection)request.getAttribute("availableItems");
Iterator iterator = null;
if(availableItems != null){
	iterator = availableItems.iterator();
}
%>


<html>
    <head>
        <script type="text/javascript" src="<%=path_content %>/js/jquery-1.11.1.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
        <title></title>
    </head>
    <body>
    <script type="text/javascript">
	$(function(){
		$('.date_picker').date_input();
	})
	</script>
         <div>
   <form id="setId" action="/Scinews/manage/sureexpert">
   	   <div>
           <table width="502"  border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
                 <td width="30%" height="50" align="center" valign="middle" class="bigblue">被评审序列号： </td>
        	    <td width="70%" height="50" align="left" valign="middle">
        	    <input type="text" id="number" name="number" size="40" maxlength="100" height="40" readonly="readonly" value=<%=number %>></input></td>
               </tr>
               <tr>
                 <td width="30%" height="50" align="center" valign="middle" class="bigblue">被评审人姓名： </td>
        	    <td width="70%" height="50" align="left" valign="middle">
        	    <input type="text" id="user" name="user" size="40" maxlength="100" height="40" readonly="readonly" value=<%=user %>></input></td>
               </tr>
               <tr>
        	    <td width="30%" height="50" align="center" valign="middle" class="bigblue">分配评审专家：</td>
        	    <td width="70%" height="50" align="left" valign="middle">
        	  	  <select name="search" multiple="multiple" size="5">
	              <%
	                 if(availableItems!=null)
	                 {
                       while(iterator.hasNext())
                       {
                    	 Tuser userinfo = (Tuser)iterator.next();  
                  %>
                         <option value=<%=userinfo.getLoginname()%>><%=userinfo.getLoginname()%></option>
                  <%
                       }
	                 }
                  %> 
           </table>
       </div>
       <!-- <input type="button" onclick="subSetting()" value="提交"/> -->
       <input type="submit" value="提交"/>
   </form>
   </div>
   
   </body>
</html> 
  		