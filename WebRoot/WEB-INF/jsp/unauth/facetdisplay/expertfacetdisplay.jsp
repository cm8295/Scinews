<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Texperts" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
List<Texperts> experts = (List<Texperts>) request.getAttribute("expertItems");
int totalcount = Integer.parseInt(request.getAttribute("totalcount").toString());
int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());
String content = (request.getAttribute("content").toString());
String facet = (request.getAttribute("facet").toString());
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专利信息</title>
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
                        <td width="97" align="center" valign="middle"><span class="bt"><strong class="bt"><spring:message code="Home.Conference.View"/></strong></span></td>
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
                              </table></td>
                            <td>
                              
						  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="40" align="right" class="lan">
                          <A href="ExpertFacetDisplay?currentpage=0&facet=<%=facet%>&content=<%=content%>&pagenumber=1&pagetype=jump&facet=<%=facet%>&content=<%=content%>&pagetype=init%>" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
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
                      int i=0;
                      if(experts!=null)
                      {
                        for(Texperts expert : experts)
                        {            
        	              i = i + 1;
                   %>   
   				  <table width="903" border="0">
                    <tr>
                      <td width="897" class="bb"><table width="900" border="0" cellspacing="0" cellpadding="0">
                           <tr bgcolor="#E8F9FD">
                            <td width="25" height="30" align="left" valign="middle" ><img src="images/374.gif" width="16" height="16" class="lan"></td>
                            <td height="30"  colspan="4" align="left" valign="middle" class="big"><a href="expertdetail?expertid=<%=expert.getId()%>" target="_blank" title="<%=expert.getExpname()%>" class="hong"><%=expert.getExpname()%></a></td>
                          </tr>
                          <tr>
                            <td width="15" height="30" align="left" valign="middle" ></td>                          
                            <td width="83" height="30" align="center" valign="middle" class="lan">工作机构:</td>
                            <td width="237" align="left" class="hui"><%=expert.getExpwork1()==null ?"":expert.getExpwork1()%></td>
                            <td width="86" height="30" align="left" class="lan">省份:</td>
                            <td width="298" height="30" align="left" class="hui"><%=expert.getExpaddress()==null ?"":expert.getExpaddress()%></td>
                          </tr>
                          <tr bgcolor="#41A4DE">
                            <td height="1" colspan="5" align="center" valign="middle" bgcolor="#DAECF5" class="lan"></td>
                          </tr>                          <tr>
                            <td width="15" height="30" align="left" valign="middle" ></td>                          
                            <td width="83" height="30" align="center" valign="middle" class="lan">级别:</td>
                            <td width="237" align="left" class="hui"><%=expert.getExptitle()%></td>
                            <td width="86" height="30" align="left" class="lan">研究领域:</td>
                            <td width="298" height="30" align="left" class="hui"><%=expert.getExpdomain()==null ?"":expert.getExpdomain()%></td>
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
                        }
                      }
				  %>			  
			   <!--<spring:message code="Home.conference.View"/>结束 --> 
			   <form name="jumpSubject" action="SubjectDisplay" method="POST" onsubmit="return ifDigital1();">
			 <table width="720"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="40" align="right" class="lan">
                          <A href="ExpertFacetDisplay?currentpage=0&facet=<%=facet%>&content=<%=content%>&pagenumber=1&pagetype=jump&facet=<%=facet%>&content=<%=content%>&pagetype=init%>" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="ExpertFacetDisplay?currentpage=<%=currentpage%>&facet=<%=facet%>&content=<%=content%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
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
