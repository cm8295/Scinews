<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Texperts" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
String[] provfacet = (String[])request.getAttribute("provfacet");
Integer[] provfacetcount = (Integer[])request.getAttribute("provfacetcount");
//int totalcount = 500;
//int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
//int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());

int totalcount = 500;
int currentpage = 1;
int pagecount = 1;
int i = 0;
String[] province = new String[provfacet.length]; 
for(i=0; i<provfacet.length; i++)
{
   province[i] = provfacet[i];
}

for(i=0; i<provfacet.length; i++)
{
		    if(provfacet[i].equals("11"))
			  provfacet[i] = "北京";	
			if(provfacet[i].equals("34"))
			  provfacet[i] = "安徽";	
			if(provfacet[i].equals("33"))
			  provfacet[i] = "浙江";	
			if(provfacet[i].equals("13"))
			  provfacet[i] = "河北";	
			if(provfacet[i].equals("46"))
			  provfacet[i] = "海南";	
			if(provfacet[i].equals("53"))
			  provfacet[i] = "云南";	
			if(provfacet[i].equals("54"))
			  provfacet[i] = "西藏";	
			if(provfacet[i].equals("65"))
			  provfacet[i] = "新疆";	
			if(provfacet[i].equals("12"))
			  provfacet[i] = "天津";	
			if(provfacet[i].equals("51"))
			  provfacet[i] = "四川";	
				if(provfacet[i].equals("43"))
				  provfacet[i] = "湖南";	
				if(provfacet[i].equals("42"))
				  provfacet[i] = "湖北";	
				if(provfacet[i].equals("50"))
				  provfacet[i] = "重庆";	
				if(provfacet[i].equals("35"))
				  provfacet[i] = "福建";	
				if(provfacet[i].equals("62"))
				  provfacet[i] = "甘肃";	
				if(provfacet[i].equals("44"))
				  provfacet[i] = "广东";	
				
			if(provfacet[i].equals("32"))
				  provfacet[i] = "江苏";	
				if(provfacet[i].equals("43"))
				  provfacet[i] = "湖南";	
				if(provfacet[i].equals("42"))
				  provfacet[i] = "湖北";	
				if(provfacet[i].equals("41"))
				  provfacet[i] = "河南";	
				if(provfacet[i].equals("23"))
				  provfacet[i] = "黑龙江";	
				if(provfacet[i].equals("52"))
				  provfacet[i] = "贵州";	
				if(provfacet[i].equals("45"))
				  provfacet[i] = "广西";	
			
			
			if(provfacet[i].equals("61"))
			  provfacet[i] = "陕西";	
			if(provfacet[i].equals("14"))
			  provfacet[i] = "山西";	
			if(provfacet[i].equals("31"))
			  provfacet[i] = "上海";	
			if(provfacet[i].equals("37"))
			  provfacet[i] = "山东";	
			if(provfacet[i].equals("63"))
			  provfacet[i] = "青海";	
			if(provfacet[i].equals("64"))
			  provfacet[i] = "宁夏";	
			if(provfacet[i].equals("15"))
			  provfacet[i] = "内蒙古";	
			if(provfacet[i].equals("21"))
			  provfacet[i] = "辽宁";	
			if(provfacet[i].equals("22"))
			  provfacet[i] = "吉林";	
			if(provfacet[i].equals("36"))
			  provfacet[i] = "江西";
	  
}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科技成果信息</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />

<script type="text/javascript" language="javascript">
function ifDigital(){
  
  var pagenumbervalue = document.getElementById('pagenumber').value;  
  var pagenumber = document.getElementById('pagenumber');

  if(pagenumbervalue=="")
  {
	 alert("请不要输入空值");
	 return false;
  }
  else 
  {
	 if(isNaN(pagenumbervalue))
	 {	
	    alert("输入的内容不是数值");
		pagenumber.focus();
		return false;
	 }
	 else
	 {
		 var r = /^[1-9]+[0-9]*]*$/　　//正整数
	     if(r.test(pagenumbervalue))
	     {
			return true;
		 } 
		 else
		 { 
		    alert("输入的不是整数");
		    return false;         
		 }
	 }
  }

  return true;
}

function ifDigital1(){

	  var pagenumbervalue1 = document.getElementById('pagenumber1').value;  
	  var pagenumber1 = document.getElementById('pagenumber1');

	  if(pagenumbervalue1=="")
	  {
		 alert("请不要输入空值");
		 return false;
	  }
	  else 
	  {
		 if(isNaN(pagenumbervalue1))
		 {	
		    alert("输入的内容不是数值");
			pagenumber1.focus();
			return false;
		 }
		 else
		 {
			 var r = /^[1-9]+[0-9]*]*$/　　//正整数
		     if(r.test(pagenumbervalue1))
		     {
				return true;
			 } 
			 else
			 { 
			    alert("输入的不是整数");
			    return false;         
			 }
		 }
	  }

	  return true;
}

</script>
</head>

<body>
<table width="1002"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">

  <tr>
    <td><!-- 主题代码开始 -->	
	  <table width="1002" border="0" align="left" cellpadding="0" cellspacing="0">
        <tr>
          <td height="2" bgcolor="#FFFFFF"></td>
        </tr>
        <tr>
          <td height="8" align="center" valign="top" >
          <table width="996" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="782" align="center" valign="top">
                <table width="905" border="0" cellspacing="0" cellpadding="0">
                  <tr align="left">
                    <td width="905" height="48" colspan="6"><table width="16%"  border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="5" bgcolor="#BF4D00"></td>
                        <td width="120" align="center" valign="middle"><span class="bt"><strong class="bt">成果所属省市</strong></span></td>
                        </tr>
                      </table></td>
                    </tr>
                  <tr align="left">
                    <td height="2" colspan="6" bgcolor="#BD4D00"></td>
                    </tr>
                  <tr align="left">
                    <td height="48" colspan="6">
                      
                      <form name="jumpSubject" action="SubjectDisplay" method="POST" onsubmit="return ifDigital1();"> 
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="38%"><table width="300" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="33" align="left" valign="middle" class="lan"></td>
                                <td height="33" align="left"  valign="middle" class="lan"><spring:message code="Display.Totalcount"/><%=totalcount%><spring:message code="Display.Item"/></td>
                                </tr>
                              </table>
                              </td>
                              
                          <td>    
						  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="40" align="right" class="lan">
                          <A href="QuickSearch?currentpage=0&pagetype=init" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
                             <spring:message code="Display.Jump"/> 
                            <input type="hidden" name="currentpage" value="<%=currentpage%>"/>
                            <input type="hidden" name="pagetype" value="jump"/>
                            <input type="text" name="pagenumber" id="pagenumber1" value="" size="3"/>
                            <input type="submit" value="确认"/><spring:message code="Display.Page"/>
                           </td>
                        </tr>
                    </table>
						  </td>
                        </tr>
                      </table>
					  
					   </form>
					  </td>
                    </tr>
                     
                    <!--分页代码开始 --> 
                  </table> 
                   <!--分页代码结束 -->

                   <%
                      
                      if(provfacet!=null)
                      {
                        for(int m=0; m<provfacet.length; m++)
                        {         
                           if(provfacet[m]!=null && !provfacet[m].equals("null"))
                           {
	                       int n = m + 1 ;
                   %>   
   				  <table width="903" border="0">
                    <tr>
                      <td width="897" class="bb">
                        <table width="900" border="0" cellspacing="0" cellpadding="0">
                          <tr bgcolor="#E8F9FD">
                            <td width="20" height="30" align="left" valign="middle" ><img src="images/374.gif" width="16" height="16" class="lan"></td>
                            <td height="30"  colspan="4" align="left" valign="middle" class="big"><a href="KjcgProvdisplay?prov=<%=province[m]%>&currentpage=0&pagetype=init" target="_blank" class="hei3" title="<%=provfacet[m]%>"><%=provfacet[m]%></a>&nbsp;<span class="red3">(<%=provfacetcount[m]%>)</span></td>
                           <%
                              if(n<provfacet.length)
                              {
                           %>
                            <td width="20" height="30" align="left" valign="middle" ><img src="images/374.gif" width="16" height="16" class="lan"></td> 
                            <td height="30"  colspan="4" align="left" valign="middle" class="big"><a href="KjcgProvdisplay?prov=<%=province[n]%>&currentpage=0&pagetype=init" target="_blank" class="hei3" title="<%=provfacet[n]%>"><%=provfacet[n]%></a>&nbsp;<span class="red3">(<%=provfacetcount[n]%>)</span></td>
                           <%
                              }
                              if((n+1)<provfacet.length)
                              {
                           %> 
                            <td width="20" height="30" align="left" valign="middle" ><img src="images/374.gif" width="16" height="16" class="lan"></td> 
                            <td height="30"  colspan="4" align="left" valign="middle" class="big"><a href="KjcgProvdisplay?prov=<%=province[n]%>&currentpage=0&pagetype=init" target="_blank" class="hei3" title="<%=provfacet[n+1]%>"><%=provfacet[n+1]%></a>&nbsp;<span class="red3">(<%=provfacetcount[n+1]%>)</span></td>                           
                           <%
                              }
                           %>
                          </tr>
                          <tr bgcolor="#41A4DE">
                            <td height="1" colspan="5" align="center" valign="middle" bgcolor="#DAECF5" class="lan"></td>
                          </tr>
                         </table>
                      </td>
                    </tr>
                  </table>		    
                  <br/>
				  <% 
				        m=m+2;
  				         }
                        }
                      }
				  %>			  
			   <!--<spring:message code="Home.conference.View"/>结束 --> 
			   <form name="jumpSubject" action="SubjectDisplay" method="POST" onsubmit="return ifDigital1();">
			 <table width="720"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="40" align="right" class="lan">
                          <A href="QuickSearch?currentpage=0&pagetype=init" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="QuickSearch?currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
                             <spring:message code="Display.Jump"/> 
                            <input type="hidden" name="currentpage" value="<%=currentpage%>"/>
                            <input type="hidden" name="pagetype" value="jump"/>
                            <input type="text" name="pagenumber" id="pagenumber1" value="" size="3"/>
                            <input type="submit" value="确认"/><spring:message code="Display.Page"/>
                          </td>
                        </tr>
                    </table>
					   
			      </form>
					   			  
			  </td>
              </tr>
          </table></td>
        </tr>
      </table>
    <!-- 主题代码结束 --></td>
  </tr>
  
  
  <tr>
    <td>
     <!--插入页尾 -->   
     <%@ include file="/common/footer.jsp"%>
    <!--插入页尾完毕 -->    
    </td>
  </tr>
</table>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;
</p>
</body>
</html>
