<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="gov.lct.model.Tkjcg" %>

<%
  List<Tkjcg> kjcgs = (List<Tkjcg>) request.getAttribute("kjcgItems");
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
                        <span class="lv">科技成果详细信息</span>
                      <%
                          int i=0;
                          if(kjcgs!=null)
                          {
                        	Tkjcg kjcg = kjcgs.get(0);  
                      %>
                        <div class="media">                          
                          <div class="media-body">
                             <h4  class="media-heading"><a href="kjcgdetail?kjcgid=<%=kjcg.getId()%>" target="_blank" title="<%=kjcg.getITEM_3()%>" class="hong"><%=kjcg.getITEM_3().trim().length()>70?kjcg.getITEM_3().trim().substring(0,70)+"...":kjcg.getITEM_3().trim()%></a></h4>
                             <p><span class="lv2">完成机构:</span><%=kjcg.getITEM_9()==null ?"":kjcg.getITEM_9()%>;
                           　　　　　　　　　　<%
			                     if(kjcg.getITEM_14()!=null)
			                     {
			                 %> 			  
                                   <p><span class="lv2"> 关键词:</span><%=kjcg.getITEM_14()==null ?"":kjcg.getITEM_14()%>
                             <%
			                     }
                                 if(kjcg.getKjcgfinishperson()!=null)
		                         {			                		                            
                             %>  
                                   <p><span class="lv2">完成人:</span><%=kjcg.getKjcgfinishperson()==null ?"":kjcg.getKjcgfinishperson()%>;
                             <%
			                     }
			                     if(kjcg.getITEM_12()!=null)
			                     {			                   
			                 %>
                                    <p><span class="lv2">中图分类号:</span><%=kjcg.getITEM_12()==null ?"":kjcg.getITEM_12()%>;
                            <%
			                     }
			                     if(kjcg.getKjcgsource()!=null)
			                     {			                   
			                %>			               
			                     <p><span class="lv2">项目来源:</span><%=kjcg.getKjcgsource()==null ?"":kjcg.getKjcgsource()%>; 
			                <%
			                     }
			                     if(kjcg.getKjcgtime()!=null)
			                     {			                   
			                %>			                			               
			                        <p><span class="lv2">完成时间:</span><%=kjcg.getKjcgtime()==null ?"":kjcg.getKjcgtime()%>;
			                <%
			                     }
			                     if(kjcg.getKjcgtype()!=null)
			                     {			                   
			                %>
			                        <p><span class="lv2">奖励类型:</span><%=kjcg.getKjcgtype()==null ?"":kjcg.getKjcgtype()%>;
			                <%
			                     }
			                     if(kjcg.getITEM_13()!=null)
			                     {			                   
			                %>
			                        <p><span class="lv2">摘要:</span><%=kjcg.getITEM_13()==null ?"":kjcg.getITEM_13()%>;
			               <%
			                     }
			               %> 
                          </div>
                      </div>
                      <%
                         }
                      %>
 


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
          
        <img src="images/wx.jpg" width="25" height="25">
        <img src="images/xlwb.jpg" width="25" height="25">
        <img src="images/yx.jpg" width="25" height="25">
        <img src="images/qqzone.jpg" width="25" height="25">       
        <img src="images/ewm.png" width="98" height="96">  </div>
      </div>
    </div>
  </div>
</footer>
        <!--转移转化-->
    </body>

</html>