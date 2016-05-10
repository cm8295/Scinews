<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Tkjcg" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
String[] yearfacet = (String[])request.getAttribute("yearfacet");
Integer[] yearfacetcount = (Integer[])request.getAttribute("yearfacetcount");
String[] provfacet = (String[])request.getAttribute("provfacet");
Integer[] provfacetcount = (Integer[])request.getAttribute("provfacetcount");
String[] instfacet = (String[])request.getAttribute("instfacet");
Integer[] instfacetcount = (Integer[])request.getAttribute("instfacetcount");

List<Tkjcg> kjcgs = (List<Tkjcg>) request.getAttribute("kjcgItems");
int totalcount = Integer.parseInt(request.getAttribute("totalcount").toString());
//int totalcount = 500;
int currentpage = Integer.parseInt(request.getAttribute("currentpage").toString());
int pagecount = Integer.parseInt(request.getAttribute("pagecount").toString());
String term = (String)request.getAttribute("term");
String resourcetype = (String)request.getAttribute("resourcetype");


//年代逆序排序
if(yearfacet!=null)
{
for (int i=0;i<yearfacet.length-1 ;i++ )
{
    int min=i;
    for (int j=i+1;j<yearfacet.length ;j++ )
    {
      if ((yearfacet[min].compareTo(yearfacet[j]))<0) //如果这里是>0，则为顺序排
      {
          min=j;
      }
    }
    if (min!=i)
    {
      String temp=yearfacet[i];
      yearfacet[i]=yearfacet[min];
      yearfacet[min]=temp;
      
      int temp1 = yearfacetcount[i];
      yearfacetcount[i] = yearfacetcount[min];
      yearfacetcount[min]=temp1;
    }
  }
}


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

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联创通科技成果浏览</title>
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
                    <a class="navbar-brand"><font size="4">联创通 </font>四川产业技术创新-信息数据中心</a>
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
                        <span class="lv">科技成果信息浏览 (<%=totalcount %> 条)</span>
                      <%
                          int i=0;
                          if(kjcgs!=null)
                          {
                            for(Tkjcg kjcg : kjcgs)
                            {            
                      %>
                        <div class="media">                          
                          <div class="media-body">
                             <h4  class="media-heading"><a href="kjcgdetail?kjcgid=<%=kjcg.getId()%>" target="_blank" title="<%=kjcg.getITEM_3()%>" class="hong"><%=kjcg.getITEM_3().trim().length()>70?kjcg.getITEM_3().trim().substring(0,70)+"...":kjcg.getITEM_3().trim()%></a></h4>
                             <p><span class="class="lv2">完成机构:</span><%=kjcg.getITEM_9()==null ?"":kjcg.getITEM_9()%>;
                             <span class="class="lv2"> 关键词:</span><%=kjcg.getITEM_14()==null ?"":kjcg.getITEM_14()%> 
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
                                        <A href="Kjcgdisplay?currentpage=0&pagetype=init" class="lan"><spring:message code="Display.FirstPage"/></A>
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagetype=previous" class="lan"><spring:message code="Display.PreviousPage"/></A>
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagenumber=1&pagetype=jump" class="fy">1</A>
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagenumber=2&pagetype=jump" class="fy">2</A>
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagenumber=3&pagetype=jump" class="fy">3</A>
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagenumber=4&pagetype=jump" class="fy">4</A>
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagenumber=5&pagetype=jump" class="fy">5</A>
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagetype=next" class="lan"><spring:message code="Display.NextPage"/></A> 
                                    </li>
                                    <li>
                                        <A href="Kjcgdisplay?currentpage=<%=currentpage%>&pagetype=last&totalcount=<%=totalcount%>" class="lan"><spring:message code="Display.LastPage"/></A> 
                                    </li>
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        
                      <div class="thumbnail">
                        <div class="caption">                             
                          <span class="lv">科技成果完成年份</span>
                          <ul>
  					    <%
					        if(yearfacet!=null)
					        {
					          if(yearfacet.length>=10)
					          {    	  
					            for(int m=0; m<10; m++)
					            {
					              if(!yearfacet[m].equals("2202"))	
					              {
					    %>
                                  <li class="lanmu"><a href="KjcgFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=kjcgyear&content=<%=yearfacet[m]%>"  class="hei3"><%=yearfacet[m]%></a> [<%=yearfacetcount[m]%>]</li>
                        <%
					              }
                                }
					          }
					          else
					          {
						        for(int m=0; m<yearfacet.length; m++)
						        {
						          if(!yearfacet[m].equals("2202"))	
						          {
					     %>
                                  <li class="lanmu"><a href="KjcgFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=kjcgyear&content=<%=yearfacet[m]%>"  class="hei3"><%=yearfacet[m]%></a>年 [<%=yearfacetcount[m]%>]</li>
                         <% 
						          }
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
                          <span class="lv">科技成果权利人</span>
                          <ul>
  					    <%
					        if(instfacet!=null)
					        {
					          if(instfacet.length>=10)
					          {    	  
					            for(int m=0; m<10; m++)
					            {
					    %>
                                  <li class="lanmu"><a href="KjcgFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=kjcginst&content=<%=instfacet[m]%>" class="hei3"><%=instfacet[m]%></a> [<%=instfacetcount[m]%>]</li>
                        <%
                                }
					          }
					          else
					          {
						        for(int m=0; m<instfacet.length; m++)
						        {
					     %>
                                  <li class="lanmu"><a href="KjcgFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=kjcginst&content=<%=instfacet[m]%>" class="hei3"><%=instfacet[m]%></a> [<%=instfacetcount[m]%>]</li>
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
                              <span class="lv">科技成果所属省份</span>
                                <ul>
					  <%
					     if(provfacet!=null)
					     {  	 
					       if(provfacet.length>=10)
					       {   
					    	 for(int m=0; m<10; m++)
					         {
					  %>                                
                                <li class="lanmu"><a href="KjcgFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=kjcgprov&content=<%=province[m]%>" class="hei3"><%=provfacet[m]%></a> [<%=provfacetcount[m]%>]</li>
                      <%
					         }
					       }
					       else
					       {
						      for(int m=0; m<provfacet.length; m++)
							  {                        
                      %>
                                <li class="lanmu"><a href="KjcgFacetDisplay?currentpage=0&pagenumber=1&pagetype=jump&facet=kjcgprov&content=<%=province[m]%>" class="hei3"><%=provfacet[m]%></a> [<%=provfacetcount[m]%>]</li>
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