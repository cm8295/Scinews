<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Tpatentbasicinfo" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%
List<Tpatentbasicinfo> patents = (List<Tpatentbasicinfo>) request.getAttribute("patentItems");
int totalcount = Integer.parseInt(request.getAttribute("totalcount").toString());
int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());
String content = request.getAttribute("content").toString(); 
%>

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
                        <td width="97" align="center" valign="middle"><span class="bt"><strong class="bt"></strong></span></td>
                        </tr>
                      </table></td>
                    </tr>
                  <tr align="left">
                    <td height="2" colspan="6" bgcolor="#BD4D00"></td>
                    </tr>
                  <tr align="left">
                    <td height="48" colspan="6">
                      
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="100%">
                              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                               <tr>
                                <td height="33" align="left" valign="middle" class="lan"><spring:message code="Display.Totalcount"/><strong><font color="blue"><%=content%></font></strong>&nbsp;所拥有专利<%=totalcount%><spring:message code="Display.Item"/></td>
                                <td height="33" align="left"  valign="middle" class="lan">&nbsp;&nbsp;<a href="TibetPatentFpaAll?currentpage=0&pagenumber=1&pagetype=jump&content=<%=content%>">点击浏览</a>所有记录</td>
                               </tr>
                              </table>
                            </td>
                        </tr>
                      </table>
					  
					  </td>
                    </tr>
                  </table> 
                   <%
                      int i=0;
                      if(patents!=null)
                      {
                        for(Tpatentbasicinfo patent : patents)
                        {            
        	              i = i + 1;
                   %>   
   				  <table width="903" border="0">
                    <tr>
                      <td width="897" id="partmessage">
                      <table width="900" border="0" cellspacing="0" cellpadding="0">
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
              <%
                        }
                      }
              %>              
			  </td>
              </tr>
          </table></td>
        </tr>
      </table>
    <!-- 主题代码结束 -->