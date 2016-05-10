<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]>      <html class="no-js"> <![endif]-->
<head>
  <title>四川省产业创新信息数据中心</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
   <!-- Mobile viewport optimized: h5bp.com/viewport -->
   <meta name="viewport" content="width=device-width">

   <meta name="robots" content="noindex, nofollow">
   <meta name="description" content="BootMetro : Simple and complete web UI framework to create web apps with Windows 8 Metro user interface." />
   <meta name="keywords" content="bootmetro, modern ui, modern-ui, metro, metroui, metro-ui, metro ui, windows 8, metro style, bootstrap, framework, web framework, css, html" />
   <meta name="author" content="AozoraLabs by Marcello Palmitessa"/>
   <link rel="publisher" href="https://plus.google.com/117689250782136016574">

   <!-- remove or comment this line if you want to use the local fonts -->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>

   <link rel="stylesheet" type="text/css" href="${cssPath}/bootmetro.css">
   <link rel="stylesheet" type="text/css" href="${cssPath}/bootmetro-responsive.css">
   <link rel="stylesheet" type="text/css" href="${cssPath}/bootmetro-icons.css">
   <link rel="stylesheet" type="text/css" href="${cssPath}/bootmetro-ui-light.css">
   <link rel="stylesheet" type="text/css" href="${cssPath}/datepicker.css">
     <link href="${cssPath}/MetroJs.lt.css" rel="stylesheet" type="text/css">

   <!--  these two css are to use only for documentation -->
   <link rel="stylesheet" type="text/css" href="${cssPath}/demo.css">

   <!-- Le fav and touch icons -->
   <link rel="shortcut icon" href="../assets/ico/favicon.ico">
   <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
   <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
   <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
   <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
   <style type="text/css">
   body {
	background-color: #327CBB;
}
   </style>
  
   <!-- All JavaScript at the bottom, except for Modernizr and Respond.
      Modernizr enables HTML5 elements & feature detects; Respond is a polyfill for min/max-width CSS3 Media Queries
      For optimal performance, use a custom Modernizr build: www.modernizr.com/download/ -->
   <script src="${jsPath}/modernizr-2.6.2.min.js"></script>

   <script type="text/javascript">
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-3182578-6']);
      _gaq.push(['_trackPageview']);
      (function() {
         var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
         ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
         var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();
   </script>
</head>

<body>
   <!--[if lt IE 7]>
   <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
   <![endif]-->

<div id="wrap">
   
      <!-- Header
      ================================================== -->
      <div id="nav-bar" class="">
         <div class="pull-left">
            <div id="header-container">
            
               <div class="dropdown">
                  <a class="header-dropdown dropdown-toggle accent-color" data-toggle="dropdown" href="template.html">
                    联创通
                     <b class="caret"></b>
                  </a>

                  <p class="tile3">四川省产业技术协同创新信息数据中心
                  <ul class="dropdown-menu">

                  
                  <li class="divider">	信息资源</li>
                  <li><a href="Patentdisplay?pagetype=init&currentpage=0" target='_blank'>中科院专利</a></li>
                  <li><a href="Kjcgdisplay?pagetype=init&currentpage=0" target='_blank'>科技成果</a></li>
                  <li><a href="Techenterprisedisplay?pagetype=init&currentpage=0"  target='_blank'>技术性企业</a></li>
                  <li><a href="./appbar-demo.html">企业技术需求</a></li>
                  <li><a href="Policydisplay?pagetype=init&currentpage=0" target='_blank'>政策法规</a></li>
                     
                      <li class="divider">评估评价</li>
               
                  <li><a href="http://jd.sclct.cn">新产品新技术鉴定</a></li>
                  <li><a href="./icons.html">企业技术创新能力评价</a></li>
                  <li><a href="./toast.html">专利价值评估</a></li>
                  <li><a href="./pivot.html">科技服务</a></li>
                  <li><a href="./metro-components.html">技术评价</a></li>
               
                 
                  <li class="divider">服务中心</li>
                 
                  
                  
                  <li><a href="./javascript.html">科技成果转化</a></li>
                  <li><a href="./javascript.html">知识产权信息</a></li>
                  <li><a href="./javascript.html">科技查新</a></li>
                  <li><a href="./javascript.html">产业技术咨询</a></li>
                  <li><a href="./javascript.html">创新创业金融</a></li>
                  
                   
                  <li class="divider">市场</li>
                 
                  
                  
                  <li><a href="./javascript.html">企业项目管理系统</a></li>
                  <li><a href="./javascript.html">主题报告生成系统</a></li>
                  <li><a href="./javascript.html">个性化推送系统</a></li>
                  <li><a href="./javascript.html">在线展会系统</a></li>
               
                  
                  <li class="divider"></li>
                  <li><a href="Home">Home</a></li>
               </ul>
            </div>
            </div>
         </div>
         
      </div>
   
      <div id="alerts-container">
      </div>
   
      <!--<div id="metro-container" class="-container">-->
         <!--<div class="row">-->
            <!--<div id="hub" class="metro">-->
               <div class="metro panorama">
                  <div class="panorama-sections">
   
                     <div class="panorama-section tile-span-3">
   
                        <h2>信息资源</h2>
   
                                      <a class="tile square image" href="Patentdisplay?pagetype=init&currentpage=0">
                              <img src="${imgPath}/tu1.jpg" alt=""/>
                              <div class="textover-wrapper transparent">
                                 <div class="text2"><span class="app-label">中科院专利</span></div>
                              </div>
                           </a>
   
                         <a class="tile square image" href="Kjcgdisplay?pagetype=init&currentpage=0">
                              <img src="${imgPath}/tu5.jpg" alt=""/>
                              <div class="textover-wrapper transparent">
                                 <div class="text2"><span class="app-label">科技成果</span></div>
                              </div>
                           </a>
   
               
                                 <a class="tile wide imagetext bg-color-greenDark" href="Techenterprisedisplay?pagetype=init&currentpage=0">
                           <div class="image-wrapper">
                                <img src="${imgPath}/iocn-6.png" alt="" />
                           </div>
                         
                           <div class="app-label">技术型企业</div>
                        </a>
                        
                        
                <a class="tile app bg-color-blue" href="static/template.html">
                           <div class="image-wrapper">
                              <img src="${imgPath}/iocn-7.png" alt="" />
                           </div>
                           <span class="app-label">企业技术需求</span>
                        </a>                        
                          
                          
   
                        <a class="tile app bg-color-purple" href="Policydisplay?pagetype=init&currentpage=0">
                           <div class="image-wrapper">
                              <img src="${imgPath}/iocn-5.png" alt="" />
                           </div>
                           <div class="app-label">政策法规</div>
                        </a>
   
     
     <div class="tiles"></div>
    
     
     
     
     
     
     
   
                     </div>
                     
                     <div class="panorama-section tile-span-3">
   
                        <h2>评估评价</h2>
   
         <a class="tile wide imagetext wideimage bg-color-blue" href="static/template.html">
                              <img src="${imgPath}/tu13.jpg" alt=""/>
                              <div class="textover-wrapper bg-color-blueDark">
                                
                                   <div class="app-label">
                                     <p><a href="http://jd.sclct.cn">新产品新技术鉴定</a></p>
                                
                                 </div>
                              </div>
                           </a>
                        
   
   
       <a class="tile wide imagetext bg-color-blue" href="static/template.html">
                           <div class="image-wrapper">
                                <img src="${imgPath}/iocn-15.png" alt="" />
                           </div>
                    
                           <span class="app-label">企业创新能力评估</span>
                        </a>
   
   
                   
                        
                        
    <a class="tile app bg-color-blue" href="http://www.caspvs.ac.cn/">
                           <div class="image-wrapper">
                              <img src="${imgPath}/iocn-8.png" alt="" />
                           </div>
                           <span class="app-label">专利价值评估</span>
                        </a>

               
                        
                <a class="tile app bg-color-orange" href="static/template.html">
                           <div class="image-wrapper">
                              <img src="${imgPath}/iocn-11.png" alt="" />
                           </div>
                           <span class="app-label">技术评价</span>
                        </a>
                       
     
     <div class="tiles"></div>
    
     
     
     
     
     
     
   
                     </div>
   
                     
   
   
                     <div class="panorama-section tile-span-3">
   
                        <h2>服务中心</h2>
   
                        <a class="tile app bg-color-orange" href="static/template.html">
                           <div class="image-wrapper">
                                <img src="${imgPath}/iocn-16.png" alt="" />
                           </div>
                           <div class="app-label">科技成果转化</div>
                           <div class="app-count"></div>
                        </a>
   
                        <a class="tile app bg-color-blue" href="static/template.html">
                           <div class="image-wrapper">
                               <img src="${imgPath}/iocn-10.png" alt="" />
                           </div>
                           <div class="app-label">知识产权信息</div>
                        </a>
   
               
                        
                                <a class="tile wide imagetext wideimage bg-color-blue" href="static/template.html">
                            <img src="${imgPath}/tu2.jpg" alt=""/>
                              <div class="textover-wrapper bg-color-blueDark">
                                 <div class="text2">
                                   <div class="app-label">
                                     <p>科技查新</p>
                                   </div>
                                 </div>
                              </div>
                           </a>
   
                        <a class="tile app bg-color-purple" href="static/template.html">
                           <div class="image-wrapper">
                                <img src="${imgPath}/iocn-1.png" alt="" />
                           </div>
                           <div class="app-label">产业技术咨询</div>
                        </a>
   
                        <a class="tile app bg-color-green" href="static/template.html">
                           <div class="image-wrapper">
                                 <img src="${imgPath}/iocn-14.png" alt="" />
                           </div>
                           <div class="app-label">创新创业金融</div>
                        </a>
   
     
     <div class="tiles"></div>
    
     
     
     
     
     
     
   
                     </div>
   
                     <div class="panorama-section tile-span-3">
   
                        <h2>市场</h2>
   
                        <a class="tile wide imagetext bg-color-blue" href="static/template.html">
                           <div class="image-wrapper">
                                <img src="${imgPath}/iocn-18.png" alt="" />
                           </div>
                    
                           <span class="app-label">企业项目管理系统</span>
                        </a>
   
                        <a class="tile wide imagetext bg-color-greenDark" href="http://159.226.140.104/report/">
                           <div class="image-wrapper">
                              <img src="${imgPath}/iocn-2.png" />
                           </div>
                     
                           <span class="app-label">主题报告生成系统</span>
                        </a>
   
                        <a class="tile app bg-color-green" href="static/template.html">
                           <div class="image-wrapper">
                              <img src="${imgPath}/iocn-17.png" alt="" />
                           </div>
                           <span class="app-label">个性化推送系统</span>
                        </a>
   
               
                        <a class="tile square image" href="static/template.html">
                            
                            <img src="${imgPath}/tu6.jpg" alt="" />
                                <div class="textover-wrapper transparent">
                                 <div class="text2"><span class="app-label">在线展会系统</span></div>
                              </div>
                           </a>

                        
                  
   
                     </div>
                     
                   <div class="panorama-section tile-span-3">
   
                        <h2>平台介绍</h2>
   
   <div  class="wz">

&nbsp;&nbsp;&nbsp;&nbsp;联创通是在四川省经济和信息化委员会的支持下，由中国科学院成都文献情报中心和四川省技术创新服务中心合作，面向四川产业技术创新的人、财、物服务模块，以用户为中心、以需求为牵引，以信息流引领技术流、资金流、人才流，以开放合作、兼容并包的模式，打造的四川省“互联网+产学研协同创新”核心骨干平台，旨在贯彻创新驱动发展战略，多方位支撑四川省产业技术创新，推动四川省企业创新发展和产业转型升级。



<P>
<hr/>
主办单位：四川省经济和信息化委员会
<P>承办单位：四川省技术创新服务中心
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国科学院成都文献情报中心

    </div> 
                     </div>  
                     
                     
                     
                     
   
                  </div>
               </div>
               <a id="panorama-scroll-prev" href="static/template.html"></a><a id="panorama-scroll-next" href="static/template.html"></a><!--</div>-->
         <!--</div>-->
      <!--</div>-->
   
   </div>

   <!-- Grab Google CDN's jQuery. fall back to local if necessary -->
   <script src="${jsPath}/jquery-1.10.0.min.js"></script>
   <script>window.jQuery || document.write("<script src='${jsPath}/jquery-1.10.0.min.js'>\x3C/script>")</script>

   <!--[if IE 7]>
   <script type="text/javascript" src="scripts/bootmetro-icons-ie7.js">
   <![endif]-->

   <script type="text/javascript" src="${jsPath}/min/bootstrap.min.js"></script>
   <script type="text/javascript" src="${jsPath}/bootmetro-panorama.js"></script>
   <script type="text/javascript" src="${jsPath}/bootmetro-pivot.js"></script>
   <script type="text/javascript" src="${jsPath}/bootmetro-charms.js"></script>
   <script type="text/javascript" src="${jsPath}/bootstrap-datepicker.js"></script>

   <script type="text/javascript" src="${jsPath}/jquery.mousewheel.min.js"></script>
   <script type="text/javascript" src="${jsPath}/jquery.touchSwipe.min.js"></script>

   <script type="text/javascript" src="${jsPath}/holder.js"></script>
   <!--<script type="text/javascript" src="../assets/js/perfect-scrollbar.with-mousewheel.min.js"></script>-->
   <script type="text/javascript" src="${jsPath}/demo.js"></script>


   <script type="text/javascript">

      $('.panorama').panorama({
         //nicescroll: false,
         showscrollbuttons: true,
         keyboard: true,
         parallax: true
      });

//      $(".panorama").perfectScrollbar();

      $('#pivot').pivot();

   </script>
   
     <script src="${jsPath}/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="${jsPath}/MetroJs.lt.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".live-tile,.flip-list").liveTile();
        });
    </script>

</body>
</html>
