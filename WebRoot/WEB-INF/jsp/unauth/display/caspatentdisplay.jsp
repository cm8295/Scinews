<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Tpatentbasicinfo" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
String[] adfacet = (String[])request.getAttribute("adfacet");
Integer[] adfacetcount = (Integer[])request.getAttribute("adfacetcount");
String[] icmfacet = (String[])request.getAttribute("icmfacet");
Integer[] icmfacetcount = (Integer[])request.getAttribute("icmfacetcount");
String[] fpafacet = (String[])request.getAttribute("fpafacet");
Integer[] fpafacetcount = (Integer[])request.getAttribute("fpafacetcount");
String[] typefacet = (String[])request.getAttribute("typefacet");
Integer[] typefacetcount = (Integer[])request.getAttribute("typefacetcount");
List<Tpatentbasicinfo> patents = (List<Tpatentbasicinfo>) request.getAttribute("patentItems");
int totalcount = Integer.parseInt(request.getAttribute("totalcount").toString());
int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());

//年代逆序排序
if(adfacet!=null)
{
for (int i=0;i<adfacet.length-1 ;i++ )
{
    int min=i;
    for (int j=i+1;j<adfacet.length ;j++ )
    {
      if ((adfacet[min].compareTo(adfacet[j]))<0) //如果这里是>0，则为顺序排
      {
          min=j;
      }
    }
    if (min!=i)
    {
      String temp=adfacet[i];
      adfacet[i]=adfacet[min];
      adfacet[min]=temp;
      
      int temp1 = adfacetcount[i];
      adfacetcount[i] = adfacetcount[min];
      adfacetcount[min]=temp1;
    }
  }
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联创通-中科院专利浏览</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="static/template/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="static/template/js/bootstrap.min.js"></script>
        <link href="static/template/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="static/template/css/template.css">
        <link href="static/template/css/main.css" rel="stylesheet">
        <style type="text/css">
        .dw {
	          font-size: 20px;
	          color: #FFFFFF;
	          font-weight: bold;
	          margin-bottom: 20px;
	          display: block;
	          margin-top: 20px;}
        </style>
</head>


    <body>
        <!-- 导航条 -->
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> 
                    <a class="navbar-brand"><font size="4">联创通 </font>四川产业技术创新信息数据中心</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="/index.html">首页</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">信息资源<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="Patentdisplay?pagetype=init&currentpage=0">中科院专利</a>
                                </li>
                                <li>
                                    <a href="Kjcgdisplay?pagetype=init&currentpage=0">科技成果</a>
                                </li>
                                <li>
                                    <a href="Techenterprisedisplay?pagetype=init&currentpage=0">技术性企业</a>
                                </li>
                                 <li>
                                    <a href="#">企业需求</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="Policydisplay?pagetype=init&currentpage=0">政策法规</a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">技术评估 <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="#">新产品新技术鉴定</a>
                                </li>
                                <li>
                                    <a href="#">企业技术创新能力</a>
                                </li>
                                <li>
                                    <a href="#">专利价值评估</a>
                                </li>
                                
                                <li>
                                    <a href="#">技术评价</a>
                                </li>
                                
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">服务中心 <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="#">科技成果转化服务</a>
                                </li>
                                <li>
                                    <a href="#">知识产权信息服务</a>
                                </li>
                                <li>
                                    <a href="#">科技查新服务</a>
                                </li>
                             
                                <li>
                                    <a href="#">产业技术咨询服务</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">创新创业金融服务</a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">市场 <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="#">企业项目管理系统</a>
                                </li>
                                <li>
                                    <a href="#">主体报告生成系统</a>
                                </li>
                                <li>
                                    <a href="#">个性化推送系统</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">在线展会系统</a>
                                </li>
                               
                            </ul>
                        </li>
                        
                        
                    </ul>
                </div>
            </div>
        </div>
        <!--评估系统-->
        <div class="jumbotron text-center">
            <div class="container">
               
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <span class="lv">专利信息浏览 (<%=totalcount %> 条)</span>
                      <%
                         int i=0;
                         if(patents!=null)
                         {
                           for(Tpatentbasicinfo patent : patents)
                           {            
                      %>
                        <div class="media">                          
                          <div class="media-body">
                             <h4  class="media-heading"><a href="patentdetail?patentan=<%=patent.getPatentAn()%>" target="_blank" title="<%=patent.getPatentTi()%>" class="hei3"><%=patent.getPatentTi().trim().length()>70?patent.getPatentTi().trim().substring(0,70)+"...":patent.getPatentTi().trim()%></a></h4>
                             <p><span class="class="lv2">申请号：</span><%=patent.getPatentAn()%>;
                             <span class="class="lv2"> 公开日:</span><%=patent.getPatentAd()==null ?"":patent.getPatentAd()%> 
                             <span class="class="lv2"> 专利类型:</span><%=patent.getPatentType()%></p>
                             <p><%=patent.getPatentAb()==null ?"":patent.getPatentAb()%>
                          </div>
                      </div>
                      <%
                           }
                         }
                      %>
 


                        <div class="row">
                            <div class="col-md-12 text-right">
                                <ul class="pagination">
                                    <li>
                                        <A href="Patentdisplay?currentpage=0&pagetype=init" class="lan"><spring:message code="Display.FirstPage"/></A>
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A>
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump" class="fy">1</A>
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A>
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A>
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A>
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A>
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                                    </li>
                                    <li>
                                        <A href="Patentdisplay?currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A> 
                                    </li>
                                    
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                    
                     <div class="thumbnail">
                       <div class="caption">
                         <span class="lv">专利申请年份</span>
                           <ul>
      					    <%
					           if(adfacet!=null)
					           {
					             if(adfacet.length>=10)
					             {    	  
					               for(int m=0; m<10; m++)
					               {
					        %>
                                      <li class="lanmu"><a href="PatentFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=patentad&content=<%=adfacet[m]%>"  class="hei3"><%=adfacet[m]%></a>年 [<%=adfacetcount[m]%>]</li>
                            <%
					               }
					             }
					             else
					             {
						            for(int m=0; m<adfacet.length; m++)
						            {
						     %>
                                      <li class="lanmu"><a href="PatentFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=patentad&content=<%=adfacet[m]%>"  class="hei3"><%=adfacet[m]%></a>年 [<%=adfacetcount[m]%>]</li>						            
						     <%       	
						            }
					             }
					           }                             
                             %>     
                                </ul>
                                <ul>
                                  <ui></ui>
                                </ul>
                          </div>
                        </div>
                        
                      <div class="thumbnail">
                       <div class="caption">
                         <span class="lv">专利权人</span>
                           <ul>
      					    <%
  					           if(fpafacet!=null)
					           {
					             if(fpafacet.length>10)
					             { 	
					               for(int m=0; m<10; m++)
					               {
					        %>
                                      <li class="lanmu"><a href="PatentFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=patentinst&content=<%=fpafacet[m]%>" class="hei3"><%=fpafacet[m].replace("中国科学院","")%></a> [<%=fpafacetcount[m]%>]</li>
                            <%
					               }
					             }
					             else
					             {
						            for(int m=0; m<fpafacet.length; m++)
						            {
						     %>
                                      <li class="lanmu"><a href="PatentFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=patentinst&content=<%=fpafacet[m]%>" class="hei3"><%=fpafacet[m].replace("中国科学院","")%></a> [<%=fpafacetcount[m]%>]</li>						            
						     <%       	
						            }
					             }
					           }                             
                             %>     
                                </ul>
                                <ul>
                                  <ui></ui>
                                </ul>
                          </div>
                        </div>
                        
                        <div class="thumbnail">
                            <div class="caption">
                              <span class="lv">专利IPC号</span>
                                <ul>
                         <%
					         if(icmfacet!=null)
					         {  	 
					           if(icmfacet.length>=6)
					           {   
					    	     for(int m=0; m<6; m++)
					             {
					     %>
                                    <li class="lanmu"><a href="PatentFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=patenticm&content=<%=icmfacet[m]%>" class="hei3"><%=icmfacet[m]%></a> [<%=icmfacetcount[m]%>]</li>                                 
                         <%                                    
					             }
					           }
					           else
					           {
						          for(int m=0; m<icmfacet.length; m++)
						          {
						 %>
                                     <li class="lanmu"><a href="PatentFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=patenticm&content=<%=icmfacet[m]%>" class="hei3"><%=icmfacet[m]%></a> [<%=icmfacetcount[m]%>]</li>						            
						 <%      	
						          }
					           }
					         }                             
                          %>     
                                    <ui></ui>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      <footer class="section section-primary">
  <div class="container">
    <div class="row">    
      <div class="col-sm-4"> 
        <span class="dw"><font size="5">联创通</font> </span>    
      <span class="dw">四川产业技术创新信息数据中心</span>
        <p>版权所有：中国科学院成都文献情报中心</p>
        <p>请用HTML5浏览器访问</p>
          
      </div>
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <div class="row"> 
          
          <!--分享图标 -->
          
      
        <img src="images/wx.jpg" width="30" height="30">
        <img src="images/xlwb.jpg" width="25" height="25">
        <img src="images/yx.jpg" width="25" height="25">
        <img src="images/qqzone.jpg" width="30" height="30">       
        <img src="images/ewm.png" width="98" height="96">  </div>
      </div>
    </div>
  </div>
</footer>
        <!--转移转化-->
    </body>

</html>