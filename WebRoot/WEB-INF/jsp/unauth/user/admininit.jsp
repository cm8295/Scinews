<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String email = (String) request.getAttribute("email");
String realname = (String) request.getAttribute("realname");
String loginname = (String) request.getAttribute("loginname");
String institute = (String) request.getAttribute("institute");
int totalcount = Integer.parseInt(request.getAttribute("totalcount").toString());
System.out.println(loginname);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户推荐</title>
<link rel="stylesheet" type="text/css" href="static/css/main.css" />
<script type="text/javascript" language="javascript">
function chk_confreg(){
    var conferencename=document.getElementById('conferencename');
    var conferencenameval=document.getElementById('conferencename').value;
              
    var conferenceurl=document.getElementById('conferenceurl');
    var conferenceurlval=document.getElementById('conferenceurl').value;

    if(conferenceurlval=="" && conferencenameval==""){
	  alert("请输入会议名称 或者 会议网址(URL)！");
	  conferencename.focus();
	  return false;	  
	}	
}
</script>
</head>

<body>
<table width="1002"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
  <td>
   <table>
     <tr>
     <td class="lan"></td>
     </tr>
   </table>
  </td>
  </tr>
  <tr>
    <td>	
	  <table width="1002" border="0" align="left" cellpadding="0" cellspacing="0">
        <tr>
          <td height="2" bgcolor="#FFFFFF"></td>
        </tr>
        <tr>
          <td height="8" align="center" valign="top" bgcolor="#F1F7FE" >
          
            <table width="950"  border="0" cellspacing="0" cellpadding="0">
              <tr bgcolor="#999999">
                <td height="1" colspan="3" bgcolor="#D4D4D4"></td>
              </tr>
              <tr>
                <td width="1" bgcolor="#D4D4D4"></td>
                <td align="center" valign="top" bgcolor="#FFFFFF">
                 <table width="948" border="0" align="center" cellpadding="0" cellspacing="0">
                   <tr align="left" valign="middle" bgcolor="#FFFFFF">
                    <td height="57" colspan="2"><table width="50%"  border="0" align="left" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="62" height="23">&nbsp;</td>
                          <td width="5" bgcolor="#BF4D00"></td>
                          <td width="300" align="center" valign="bottom"><span class="style3"><spring:message code="User.Recommand"/> | <a href="ReConferenceDisplay?currentpage=0&amp;pagetype=init"><spring:message code="User.Search.Recommend"/></a></span></td>
                        </tr>
                  </table></td>
                  </tr>
                  <tr>
                    <td height="1" colspan="2" align="left" bgcolor="#D0E1DF"></td>
                  </tr>
                  <tr>
                    <td width="67" height="264" align="center" valign="middle" bgcolor="#FFFFFF" class="lan"><span class="bai3"> </span> </td>
                    <td width="881" align="left" valign="top" bgcolor="#FFFFFF" class="lan">
                    
                    <form name="ConferenceAdd" method="post" action="ConferenceAdd" onsubmit="return chk_confreg();" >
                      <table width="55%" border="0" align="left" cellpadding="0" cellspacing="0">
                        <tr bgcolor="#FFFFFF">
                          <td width="12" height="38" align="left" class="lan style1">&nbsp;</td>
                          <td width="111" height="38" align="right" class="red2"><spring:message code="Detail.Conference.Title"/>：</td>
                          <td width="363" height="38" align="right" valign="middle" class="bai3"><input id="conferencename" name="conferencename" type="text" style="width:345px"/>
                          </td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                          <td width="12" height="38" align="left" class="lan style1">&nbsp;</td>
                          <td width="111" height="38" align="right" class="red2"><spring:message code="Detail.Conference.Url"/>：</td>
                          <td width="363" height="38" align="right" valign="middle" class="bai3"><input id="conferenceurl" name="conferenceurl" type="text" style="width:345px"/>
                          </td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                          <td width="12" height="38" align="left" class="lan style1">&nbsp;</td>
                          <td width="111" height="38" align="right" class="red2"><spring:message code="Detail.Conference.Sponsor"/>：</td>
                          <td width="363" height="38" align="right" valign="middle" class="bai3"><input id="conferencesponsor" name="conferencesponsor" type="text" style="width:345px"/>
                          </td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                          <td width="12" height="38" align="left" class="lan style1">&nbsp;</td>
                          <td width="111" height="38" align="right" class="red2"><spring:message code="Detail.Conference.Location"/>：</td>
                          <td width="363" height="38" align="right" valign="middle" class="bai3"><input id="conferencelocation" name="conferencelocation" type="text" style="width:345px"/>
                          </td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                          <td width="12" height="38" align="left" class="lan style1">&nbsp;</td>
                          <td width="111" height="38" align="right" class="red2"><spring:message code="Detail.Conference.Date"/>：</td>
                          <td width="363" height="38" align="right" valign="middle" class="bai3"><input id="conferencestartdat" name="conferencestartdat" type="text" style="width:345px"/>
                          </td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                          <td width="12" height="38" align="left" class="lan style1">&nbsp;</td>
                          <td width="111" height="38" align="right" class="red2"><spring:message code="User.email"/>：</td>
                          <td width="363" height="38" align="right" valign="middle" class="bai3"><input id="email" name="email" type="text" style="width:345px"/>
                          </td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                          <td width="12" height="81" align="left" class="lan style1">&nbsp;</td>
                          <td height="40" align="right" valign="middle" bgcolor="#FFFFFF" class="bai">&nbsp;</td>
                          <td height="40" align="right" valign="middle" bgcolor="#FFFFFF" class="bai"><input   type=submit  style="width:350px;height:30px;" value="提 交"/></td>
                        </tr>
                      </table>
                    </form></td>
                  </tr>
                </table>
                </td>
                <td width="1" bgcolor="#D4D4D4"></td>
              </tr>
              <tr>
                <td height="1" colspan="3" bgcolor="#D4D4D4"></td>
              </tr>
            </table>
         
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