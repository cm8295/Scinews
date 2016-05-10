<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Texperts" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
String[] xkfacet = (String[])request.getAttribute("xkfacet");
Integer[] xkfacetcount = (Integer[])request.getAttribute("xkfacetcount");
String[] workfacet = (String[])request.getAttribute("workfacet");
Integer[] workfacetcount = (Integer[])request.getAttribute("workfacetcount");
String[] exprovfacet = (String[])request.getAttribute("exprovfacet");
Integer[] exprovfacetcount = (Integer[])request.getAttribute("exprovfacetcount");

List<Texperts> experts = (List<Texperts>) request.getAttribute("expertItems");
//int totalcount = Integer.parseInt(request.getAttribute("totalcount").toString());
int totalcount = 500;
int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());
String term = (String)request.getAttribute("term");
String resourcetype = (String)request.getAttribute("resourcetype");

%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科技专家信息</title>
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
          <td height="8" align="center" valign="top" ><table width="996" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="216" height="782" align="center" valign="top" bgcolor="#dfe6ec"><table width="216" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="15" height="35" bgcolor="#627289">&nbsp;</td>
                    <td width="176" align="left" bgcolor="#627289" class="bai"><spring:message code="Display.conference.Date"/></td>
                    <td width="25" bgcolor="#627289"><span class="bai"><img src="images/more.jpg" width="11" height="11" align="middle"></span></td>
                  </tr>
                  <tr>
                    <td height="84" colspan="3" align="center" valign="middle">
                      
					  <!--<spring:message code="Display.conference.Date"/>开始 --> 
					  
					  <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
					    <%
					        if(exprovfacet!=null)
					        {
					          if(exprovfacet.length>=10)
					          {    	  
					            for(int i=0; i<4; i++)
					            {
                                  int n = i*2;
					    %>
                                 <tr>
                                   <td width="60" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=exprovfacet[n]%>"  class="hei3"><%=exprovfacet[n]%></a>年</td>
                                   <td width="48" height="27" align="left" class="hei3">[<%=exprovfacetcount[n]%>]</td>
                                   <%
                                        n++;
                                   %>
                                   <td width="45" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=exprovfacet[n]%>"  class="hei3"><%=exprovfacet[n]%></a>年</td>
                                   <td width="34" height="27" align="left" class="hei3">[<%=exprovfacetcount[n]%>]</td>
                                 </tr>
                         <%
                                }
					          }
					          else
					          {
						        for(int i=0; i<exprovfacet.length; i++)
						        {
	                              int n = i*2;
	                              if(n<exprovfacet.length)
	                              {
					     %>
                                 <tr>
                                   <td width="60" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=exprovfacet[n]%>" class="hei3"><%=exprovfacet[n]%></a>年</td>
                                   <td width="48" height="27" align="left" class="hei3">[<%=exprovfacetcount[n]%>]</td>
                                 <%
	                              }
                                  n++;
                                  if(n<exprovfacet.length)
	                              {                                 
                                 %>
                                   <td width="45" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=exprovfacet[n]%>" class="hei3"><%=exprovfacet[n]%></a>年</td>
                                   <td width="34" height="27" align="left" class="hei3">[<%=exprovfacetcount[n]%>]</td>
                                 </tr>					          	  
					     <%   	  
	                              }
						        }
					          }
					        }
                         %>         
                      </table>
					  
				      <!--<spring:message code="Display.conference.Date"/>结束 -->                      </td>
                  </tr>
                  <tr>
                    <td height="35" bgcolor="#627289">&nbsp;</td>
                    <td height="35" align="left" bgcolor="#627289" class="bai"><spring:message code="Home.conference.Country"/></td>
                    <td height="35" bgcolor="#627289"><span class="bai"><img src="images/more.jpg" width="11" height="11" align="middle"></span></td>
                  </tr>
                  <tr valign="top">
                    <td height="109" colspan="3" align="center">
					
					<!--国家分组开始 -->
					<br>
					<table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
					  <%
					     if(xkfacet!=null)
					     {  	 
					       if(xkfacet.length>=6)
					       {   
					    	 for(int i=0; i<6; i++)
					         {
					  %>
					  <tr>
                        <td width="155" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=country&content=<%=xkfacet[i]%>" class="hei3"><%=xkfacet[i]%></a></td>
                        <td width="35" height="22" align="left" class="hei3">[<%=xkfacetcount[i]%>]</td>
                      </tr>
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>                      
                      <% 
					    	 }
					       }
					       else
					       {
					    	 for(int i=0; i<xkfacet.length; i++)
						     {  
	         		  %>
	         		  <tr>
	                    <td width="155" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=country&content=<%=xkfacet[i]%>" class="hei3"><%=xkfacet[i]%></a></td>
	                    <td width="35" height="22" align="left" class="hei3">[<%=xkfacetcount[i]%>]</td>
	                  </tr>
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>	                    
	                  <%
 	                         }
					       }
					     }
                      %>
                    </table>
					
					</td>
                  </tr>
                  <tr>
                    <td height="35" bgcolor="#627289">&nbsp;</td>
                    <td height="35" align="left" bgcolor="#627289" class="bai"><spring:message code="Home.conference.Source"/></td>
                    <td height="35" bgcolor="#627289"><span class="bai"><img src="images/more.jpg" width="11" height="11" align="middle"></span></td>
                  </tr>
                  <tr valign="top">
                    <td height="105" colspan="3" align="center">
					<!--举办国家开始 --> 
					<br>
					<table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
					  <%
					      if(workfacet!=null)
					      {
					        if(workfacet.length>6)
					        { 	
					          for(int i=0; i<6; i++)
					          {
					  %>
                      <tr>
                        <td width="170" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=source&content=<%=workfacet[i]%>" class="hei3"><%=workfacet[i]%></a></td>
                        <td width="24" height="22" align="left" class="hei3">[<%=workfacetcount[i]%>]</td>
                      </tr>
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>                      
                      <%
					          }
					        }
					        else
					        {
					          for(int i=0; i<workfacet.length; i++)
						      {
                      %>
                      <tr>
                        <td width="170" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=source&content=<%=workfacet[i]%>" class="hei3"><%=workfacet[i]%></a></td>
                        <td width="24" height="22" align="left" class="hei3">[<%=workfacetcount[i]%>]</td>
                      </tr> 
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>                                           
                      <%
						      }
					        }
					      }
                      %>
                    </table>

					<!--举办国家结束 -->					</td>
                  </tr>
                  
                  <tr>
                    <td height="69" colspan="3" align="center" valign="middle"><!--咨询电话 -->
                      <img src="images/1_67.jpg" width="200" height="53"></td>
                  </tr>
                </table>
                </td>
                
                <td width="1" valign="top" bgcolor="#B1C4D1"></td>
                <td width="782" align="center" valign="top"><table width="716" border="0" cellspacing="0" cellpadding="0">
                    <tr align="left">
                      <td height="48" colspan="6"><table width="16%"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="5" bgcolor="#BF4D00"></td>
                          <td width="97" align="center" valign="middle"><span class="bt"><strong class="bt"><spring:message code="Home.conference.View"/></strong></span></td>
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
                          <A href="QuickSearch?currentpage=0&pagetype=init&resourcetype=<%=resourcetype%>&term=<%=term%>" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
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
   				  <table width="712" border="0">
                    <tr>
                      <td width="706" class="bb"><table width="704" border="0" cellspacing="0" cellpadding="0">
                           <tr bgcolor="#E8F9FD">
                            <td width="25" height="30" align="left" valign="middle" ><img src="images/374.gif" width="16" height="16" class="lan"></td>
                            <td height="30"  colspan="4" align="left" valign="middle" class="big"><a href="expertdetail?expertan=<%=expert.getId()%>" target="_blank" title="<%=expert.getExpname()%>" class="hei3"><%=expert.getExpname()%></a></td>
                          </tr>
                          <tr>
                            <td width="25" height="30" align="left" valign="middle" ></td>                          
                            <td width="83" height="30" align="center" valign="middle" class="lan">工作机构:</td>
                            <td width="237" align="left" class="hui"><%=expert.getExpwork()==null ?"":expert.getExpwork()%></td>
                            <td width="86" height="30" align="left" class="lan">学科:</td>
                            <td width="298" height="30" align="left" class="hui"><%=expert.getExpxkname()==null ?"":expert.getExpxkname()%></td>
                          </tr>
                          <tr bgcolor="#41A4DE">
                            <td height="1" colspan="5" align="center" valign="middle" bgcolor="#DAECF5" class="lan"></td>
                          </tr>                          <tr>
                            <td width="25" height="30" align="left" valign="middle" ></td>                          
                            <td width="83" height="30" align="center" valign="middle" class="lan">擅长领域:</td>
                            <td width="237" align="left" class="hui">                                                        
                            <%
                                if(expert.getExpdomain()!=null)
                                {
                            %>
                                  <%=expert.getExpdomain()%>
                            <%
                                }
                            %>    
                            </td>
                            <td width="86" height="30" align="left" class="lan">省份:</td>
                            <td width="298" height="30" align="left" class="hui"><%=expert.getExpprovince()==null ?"":expert.getExpprovince()%></td>
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
                          <A href="QuickSearch?currentpage=0&pagetype=init&resourcetype=<%=resourcetype%>&term=<%=term%>" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="QuickSearch?resourcetype=<%=resourcetype%>&term=<%=term%>&currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
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
