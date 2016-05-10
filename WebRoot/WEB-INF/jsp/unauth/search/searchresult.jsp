<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="gov.lct.model.Tpatentbasicinfo" %>
<%@page import="gov.lct.model.Tkjcg" %>
<%@page import="gov.lct.model.Texperts" %>
<%@page import="gov.lct.model.Tpolice" %>

<%
  List<Tpatentbasicinfo> patents = (List<Tpatentbasicinfo>) request.getAttribute("patentItems");
  List<Tkjcg> kjcgs = (List<Tkjcg>) request.getAttribute("kjcgItems");
  List<Texperts> experts = (List<Texperts>) request.getAttribute("expertItems");
  
  String resourcetype = (String) request.getAttribute("resourcetype");
  String term = (String) request.getAttribute("term");
  
  int totalcount = 500;
  int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
  int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<script type="text/javascript"  language="javascript">
function tabChange(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("ul"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "display";
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
        <td width="1" height="1250" bgcolor="#FDFDFD"></td>
        <td align="center" valign="top">
		
		<!--页头开始-->
		<%@ include file="/common/header.jsp"%>
		<!--页头结束  -->	
       </td>
      </tr>
  <tr>
     <td align="right"></td>
     <td align="right" valign="middle" class="bj5">
      <div class="tabmenu">
       <ul>                      
        <li onmouseover="tabChange(this,'tabcontent')" class="display">专利信息</li>
        <li onmouseover="tabChange(this,'tabcontent')">科技成果信息 </li>
        <li onmouseover="tabChange(this,'tabcontent')">科技专家信息 </li>
       </ul>
      </div>
     </td>
  </tr>  
  
  <div id="tabcontent">
    <ul class="display">
  <%
    if(patents!=null)
    {
    	String[] adfacet = (String[])request.getAttribute("adfacet");
    	Integer[] adfacetcount = (Integer[])request.getAttribute("adfacetcount");
    	String[] icmfacet = (String[])request.getAttribute("icmfacet");
    	Integer[] icmfacetcount = (Integer[])request.getAttribute("icmfacetcount");
    	String[] instfacet = (String[])request.getAttribute("instfacet");
    	Integer[] instfacetcount = (Integer[])request.getAttribute("instfacetcount");    	
  %>
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
					        if(adfacet!=null)
					        {
					          if(adfacet.length>=10)
					          {    	  
					            for(int i=0; i<4; i++)
					            {
                                  int n = i*2;
					    %>
                                 <tr>
                                   <td width="60" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=adfacet[n]%>"  class="hei3"><%=adfacet[n]%></a>年</td>
                                   <td width="48" height="27" align="left" class="hei3">[<%=adfacetcount[n]%>]</td>
                                   <%
                                        n++;
                                   %>
                                   <td width="45" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=adfacet[n]%>"  class="hei3"><%=adfacet[n]%></a>年</td>
                                   <td width="34" height="27" align="left" class="hei3">[<%=adfacetcount[n]%>]</td>
                                 </tr>
                         <%
                                }
					          }
					          else
					          {
						        for(int i=0; i<adfacet.length; i++)
						        {
	                              int n = i*2;
	                              if(n<adfacet.length)
	                              {
					     %>
                                 <tr>
                                   <td width="60" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=adfacet[n]%>" class="hei3"><%=adfacet[n]%></a>年</td>
                                   <td width="48" height="27" align="left" class="hei3">[<%=adfacetcount[n]%>]</td>
                                 <%
	                              }
                                  n++;
                                  if(n<adfacet.length)
	                              {                                 
                                 %>
                                   <td width="45" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=adfacet[n]%>" class="hei3"><%=adfacet[n]%></a>年</td>
                                   <td width="34" height="27" align="left" class="hei3">[<%=adfacetcount[n]%>]</td>
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
					     if(icmfacet!=null)
					     {  	 
					       if(icmfacet.length>=6)
					       {   
					    	 for(int i=0; i<6; i++)
					         {
					  %>
					  <tr>
                        <td width="155" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=country&content=<%=icmfacet[i]%>" class="hei3"><%=icmfacet[i]%></a></td>
                        <td width="35" height="22" align="left" class="hei3">[<%=icmfacetcount[i]%>]</td>
                      </tr>
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>                      
                      <% 
					    	 }
					       }
					       else
					       {
					    	 for(int i=0; i<icmfacet.length; i++)
						     {  
	         		  %>
	         		  <tr>
	                    <td width="155" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=country&content=<%=icmfacet[i]%>" class="hei3"><%=icmfacet[i]%></a></td>
	                    <td width="35" height="22" align="left" class="hei3">[<%=icmfacetcount[i]%>]</td>
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
					      if(instfacet!=null)
					      {
					        if(instfacet.length>6)
					        { 	
					          for(int i=0; i<6; i++)
					          {
					  %>
                      <tr>
                        <td width="170" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=source&content=<%=instfacet[i]%>" class="hei3"><%=instfacet[i]%></a></td>
                        <td width="24" height="22" align="left" class="hei3">[<%=instfacetcount[i]%>]</td>
                      </tr>
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>                      
                      <%
					          }
					        }
					        else
					        {
					          for(int i=0; i<instfacet.length; i++)
						      {
                      %>
                      <tr>
                        <td width="170" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=source&content=<%=instfacet[i]%>" class="hei3"><%=instfacet[i]%></a></td>
                        <td width="24" height="22" align="left" class="hei3">[<%=instfacetcount[i]%>]</td>
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
                </table></td>
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
                      if(patents!=null)
                      {
                        for(Tpatentbasicinfo patent : patents)
                        {            
        	              i = i + 1;
                   %>   
   				  <table width="712" border="0">
                    <tr>
                      <td width="706" class="bb"><table width="704" border="0" cellspacing="0" cellpadding="0">
                           <tr bgcolor="#E8F9FD">
                            <td width="25" height="30" align="left" valign="middle" ><img src="images/374.gif" width="16" height="16" class="lan"></td>
                            <td height="30"  colspan="4" align="left" valign="middle" class="big"><a href="patentdetail?patentan=<%=patent.getPatentAn()%>" target="_blank" title="<%=patent.getPatentTi()%>" class="hei3"><%=patent.getPatentTi().trim().length()>70?patent.getPatentTi().trim().substring(0,70)+"...":patent.getPatentTi().trim()%></a></td>
                          </tr>
                          <tr>
                            <td width="25" height="30" align="left" valign="middle" ></td>                          
                            <td width="83" height="30" align="center" valign="middle" class="lan">申请号:</td>
                            <td width="237" align="left" class="hui"><%=patent.getPatentAn()==null ?"":patent.getPatentAn()%></td>
                            <td width="86" height="30" align="left" class="lan">申请日:</td>
                            <td width="298" height="30" align="left" class="hui"><%=patent.getPatentAd()==null ?"":patent.getPatentAd()%></td>
                          </tr>
                          <tr>
                            <td width="25" height="30" align="left" valign="middle" ></td>                          
                            <td width="83" height="30" align="center" valign="middle" class="lan">专利权人:</td>
                            <td width="237" align="left" class="hui">                                                        
                            <%
                                if(patent.getPatentFpa()!=null)
                                {
                            %>
                                  <%=patent.getPatentFpa()%>
                            <%
                                }
                            %>    
                            </td>
                            <td width="86" height="30" align="left" class="lan">ICM分类号:</td>
                            <td width="298" height="30" align="left" class="hui"><%=patent.getPatentIcm()==null ?"":patent.getPatentIcm()%></td>
                          </tr>
                          <tr bgcolor="#41A4DE">
                            <td height="1" colspan="4" align="center" valign="middle" bgcolor="#DAECF5" class="lan"></td>
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
    <!-- 主题代码结束 -->
    </td>
  </tr>  
  <%
    }  // end of if
  %>
  </ul>
  
  <ul class="hidden">
  <%
  if(experts!=null)
  {
    	String[] xkfacet = (String[])request.getAttribute("xkfacet");
    	Integer[] xkfacetcount = (Integer[])request.getAttribute("xkfacetcount");
    	String[] workfacet = (String[])request.getAttribute("workfacet");
    	Integer[] workfacetcount = (Integer[])request.getAttribute("workfacetcount");
    	String[] exprovfacet = (String[])request.getAttribute("exprovfacet");
    	Integer[] exprovfacetcount = (Integer[])request.getAttribute("exprovfacetcount");
  %>
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
  <%
     }
  %> 
  </ul>
  
  <ul class="hidden">
  <%
  if(kjcgs!=null)
  {
  String[] yearfacet = (String[])request.getAttribute("yearfacet");
  Integer[] yearfacetcount = (Integer[])request.getAttribute("yearfacetcount");
  String[] provfacet = (String[])request.getAttribute("provfacet");
  Integer[] provfacetcount = (Integer[])request.getAttribute("provfacetcount");
  String[] instfacet = (String[])request.getAttribute("instfacet");
  Integer[] instfacetcount = (Integer[])request.getAttribute("instfacetcount");

  String[] province = new String[provfacet.length]; 
  for(int i=0; i<provfacet.length; i++)
  {
     province[i] = provfacet[i];
  }
  
  for(int i=0; i<provfacet.length; i++)
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
					        if(yearfacet!=null)
					        {
					          if(yearfacet.length>=10)
					          {    	  
					            for(int i=0; i<4; i++)
					            {
                                  int n = i*2;
					    %>
                                 <tr>
                                   <td width="60" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=yearfacet[n]%>"  class="hei3"><%=yearfacet[n]%></a>年</td>
                                   <td width="48" height="27" align="left" class="en-hei">[<%=yearfacetcount[n]%>]</td>
                                   <%
                                        n++;
                                   %>
                                   <td width="45" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=yearfacet[n]%>"  class="hei3"><%=yearfacet[n]%></a>年</td>
                                   <td width="34" height="27" align="left" class="en-hei">[<%=yearfacetcount[n]%>]</td>
                                 </tr>
                         <%
                                }
					          }
					          else
					          {
						        for(int i=0; i<yearfacet.length; i++)
						        {
	                              int n = i*2;
	                              if(n<yearfacet.length)
	                              {
					     %>
                                 <tr>
                                   <td width="60" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=yearfacet[n]%>" class="hei3"><%=yearfacet[n]%></a>年</td>
                                   <td width="48" height="27" align="left" class="en-hei">[<%=yearfacetcount[n]%>]</td>
                                 <%
	                              }
                                  n++;
                                  if(n<yearfacet.length)
	                              {                                 
                                 %>
                                   <td width="45" height="27" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=year&content=<%=yearfacet[n]%>" class="hei3"><%=yearfacet[n]%></a>年</td>
                                   <td width="34" height="27" align="left" class="en-hei">[<%=yearfacetcount[n]%>]</td>
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
					     if(provfacet!=null)
					     {  	 
					       if(provfacet.length>=6)
					       {   
					    	 for(int i=0; i<6; i++)
					         {
					  %>
					  <tr>
                        <td width="155" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=country&content=<%=province[i]%>" class="hei3"><%=provfacet[i]%></a></td>
                        <td width="35" height="22" align="left" class="hei3">[<%=provfacetcount[i]%>]</td>
                      </tr>
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>                      
                      <% 
					    	 }
					       }
					       else
					       {
					    	 for(int i=0; i<provfacet.length; i++)
						     {  
	         		  %>
	         		  <tr>
	                    <td width="155" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=country&content=<%=province[i]%>" class="hei3"><%=provfacet[i]%></a></td>
	                    <td width="35" height="22" align="left" class="hei3">[<%=provfacetcount[i]%>]</td>
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
					      if(instfacet!=null)
					      {
					        if(instfacet.length>6)
					        { 	
					          for(int i=0; i<6; i++)
					          {
					  %>
                      <tr>
                        <td width="170" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=source&content=<%=instfacet[i]%>" class="hei3"><%=instfacet[i]%></a></td>
                        <td width="24" height="22" align="left" class="hei3">[<%=instfacetcount[i]%>]</td>
                      </tr>
					  <tr>
                        <td height="10" align="left" class="hei3" colspan="2"><hr/></td>
                      </tr>                      
                      <%
					          }
					        }
					        else
					        {
					          for(int i=0; i<instfacet.length; i++)
						      {
                      %>
                      <tr>
                        <td width="170" height="22" align="left" class="hei3"><a href="SubjectFacetDisplay?&currentpage=0&pagenumber=1&pagetype=jump&resourcetype=<%=resourcetype%>&term=<%=term%>&facet=source&content=<%=instfacet[i]%>" class="hei3"><%=instfacet[i]%></a></td>
                        <td width="24" height="22" align="left" class="hei3">[<%=instfacetcount[i]%>]</td>
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
                </table></td>
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
                      if(kjcgs!=null)
                      {
                        for(Tkjcg kjcg : kjcgs)
                        {            
        	              i = i + 1;
                   %>   
   				  <table width="712" border="0">
                    <tr>
                      <td width="706" class="bb"><table width="704" border="0" cellspacing="0" cellpadding="0">
                           <tr bgcolor="#E8F9FD">
                            <td width="25" height="30" align="left" valign="middle" ><img src="images/374.gif" width="16" height="16" class="lan"></td>
                            <td height="30"  colspan="4" align="left" valign="middle" class="big"><a href="kjcgdetail?kjcgid=<%=kjcg.getId()%>" target="_blank" title="<%=kjcg.getITEM_3()%>" class="hei3"><%=kjcg.getITEM_3().trim().length()>70?kjcg.getITEM_3().trim().substring(0,70)+"...":kjcg.getITEM_3().trim()%></a></td>
                          </tr>
                          <tr>
                            <td width="25" height="30" align="left" valign="middle" ></td>                          
                            <td width="83" height="30" align="center" valign="middle" class="lan">所属机构:</td>
                            <td width="277" align="left" class="hui"><%=kjcg.getITEM_9()==null ?"":kjcg.getITEM_9()%></td>
                            <td width="110" height="30" align="left" class="lan">关键词:</td>
                            <td width="298" height="30" align="left" class="hui"><%=kjcg.getITEM_14()==null ?"":kjcg.getITEM_14()%></td>
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
  <%
  }
  %>
  </ul>  
  </div>
 
 <!-- 三类信息显示完成 -->
 
  
  <tr>
    <td>
     <!--插入页尾 -->   
     <%@ include file="/common/footer.jsp"%>
    <!--插入页尾完毕 -->    
    </td>
  </tr>
</table>


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