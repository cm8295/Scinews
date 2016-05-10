<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Tpatentbasicinfo" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
String[] icmfacet = (String[])request.getAttribute("icmfacet");
Integer[] icmfacetcount = (Integer[])request.getAttribute("icmfacetcount");

List<Tpatentbasicinfo> patents = (List<Tpatentbasicinfo>) request.getAttribute("patentItems");
int totalcount = Integer.parseInt(request.getAttribute("totalcount").toString());
int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专利饼环图</title>
<script src="js/d3.min.js" charset="UTF-8"></script>  
<script src="js/jquery-1.11.1.js" charset="UTF-8"></script> 
<script type="text/javascript">
 function GetPatentbyAjax(url)
 {
    $.get(url, function(_html) 
    {
  	   $("#_partmessage").html(_html);　
    });
    	    
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
</table>

<table width="1002" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">  
  <tr>
  <td align="center" id="svg">
   	<script type="text/javascript">		
		var icmcount= new Array();
		var icm= new Array();
        <%
           for(int i=0; i<icmfacet.length; i++)
           {
        %>
             icmcount[<%=i%>] = <%=icmfacetcount[i]%>;
             icm[<%=i%>] = <%="\"" + icmfacet[i] + "\""%>;          
		<%
           }
		%>
		var pie=d3.layout.pie(icmcount);
				
		var h=400;
		var w=400;
		
		var outerRadius=w/2;//外半径
		//(7)圆环内半径
		var innerRadius=w/3;
		//(2)用svg的path绘制弧形的内置方法
		var arc=d3.svg.arc()//设置弧度的内外径，等待传入的数据生成弧度
		.outerRadius(outerRadius)
		.innerRadius(innerRadius);
		
		var svg=d3.select("#svg")
				.append("svg")
				.attr("width",w)
				.attr("height",h);
		//(3)颜色函数
		var color=d3.scale.category10();//创建序数比例尺和包括10中颜色的输出范围
		//(4)准备分组,把每个分组移到图表中心
		var arcs=svg.selectAll("g.arc")
		.data(pie(icmcount))
		.enter()
		.append("g")
		.attr("class","arc")
		//移到图表中心
		.attr("transform","translate("+outerRadius+","+outerRadius+")");//translate(a,b)a表示横坐标起点，b表示纵坐标起点
		
		//(5)为组中每个元素绘制弧形路路径
		arcs.append("path")//每个g元素都追加一个path元素用绑定到这个g的数据d生成路径信息
		.attr("fill",function(d,i){//填充颜色
			return color(i);
		})
		.attr("d",arc);//将角度转为弧度（d3使用弧度绘制）
		
		//(6)为组中每个元素添加文本
		arcs.append("text")//每个g元素都追加一个path元素用绑定到这个g的数据d生成路径信息
		.attr("transform",function(d){ 
			return "translate("+arc.centroid(d)+")";//计算每个弧形的中心点（几何中心）
		})
		.attr("text-anchor","middle")	
        .on("click",function(d,i){
    	  //window.open ('PatentFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=patenticm&content='+icm[i]);
    	  var url = 'PatentIcmDisplay?currentpage=0&pagenumber=1&pagetype=jump&content='+icm[i];
    	  GetPatentbyAjax(url);
			})			
		.text(function(d,i){
		       var label = icm[i]+":"+d.value
		       return label;
		});				
	  </script>  
    </td>		
  </tr>
  
  
  <tr>
    <td id="_partmessage"><!-- 主题代码开始 -->	
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
                          <A href="PatentIcmpie?currentpage=0&pagenumber=1&pagetype=jump&pagetype=init%>" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
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
                      <td width="897" class="bb"><table width="900" border="0" cellspacing="0" cellpadding="0">
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
                          <A href="PatentIcmpie?currentpage=0&pagenumber=1&pagetype=jump&pagetype=init%>" class="lan"><spring:message code="Display.FirstPage"/></A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump"  class="fy">1</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A> 
                          <A href="PatentIcmpie?currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A>                           
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
 
 
</body>
</html>
