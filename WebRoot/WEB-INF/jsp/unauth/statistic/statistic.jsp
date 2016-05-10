<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%>
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@ page import="java.io.*"%>
<%@ page import="org.jfree.data.*"%>
<%@ page import="org.jfree.data.category.*"%>
<%@ page import="java.awt.Color"%>
<%@ page import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator"%>
<%@ page import="java.awt.Font"%>
<%@ page import="org.jfree.chart.axis.AxisLocation"%>
<%@ page import="java.awt.event.WindowAdapter"%>
<%@ page import="java.awt.event.WindowEvent"%>
<%@ page import="java.awt.Toolkit"%>
<%@ page import="java.awt.Dimension"%>
<%@ page import="org.jfree.chart.axis.CategoryAxis"%>
<%@ page import="org.jfree.chart.axis.CategoryLabelPositions"%>
<%@ page import="org.jfree.chart.plot.CategoryPlot"%>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>
<%@ page import="org.jfree.chart.renderer.category.BarRenderer3D"%>
<%@ page import="org.jfree.chart.axis.NumberAxis"%>
<%@ page import="org.jfree.chart.axis.NumberTickUnit"%>
<%@ page import="org.jfree.chart.plot.CategoryPlot"%>
<%@ page import="org.jfree.chart.axis.CategoryAxis"%>
<%@ page import="org.jfree.chart.labels.*"%>
<%@ page import="org.jfree.chart.util.*"%>
<%@ page import="org.jfree.chart.ChartFactory"%>
<%@ page import="org.jfree.chart.JFreeChart"%>;
<%@ page import="org.jfree.ui.TextAnchor"%>;

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
int confcount = Integer.parseInt(request.getAttribute("confcount").toString());
//String[] subjectfacet = (String[])request.getAttribute("subjectfacet");
//Integer[] subjectfacetcount = (Integer[])request.getAttribute("subjectfacetcount");
String[] countryfacet = (String[])request.getAttribute("countryfacet");
Integer[] countryfacetcount = (Integer[])request.getAttribute("countryfacetcount");
//String[] confyearfacet = (String[])request.getAttribute("confyearfacet");
//Integer[] confyearfacetcount = (Integer[])request.getAttribute("confyearfacetcount");
//String[] sponsorfacet = (String[])request.getAttribute("sponsorfacet");
//Integer[] sponsorfacetcount = (Integer[])request.getAttribute("sponsorfacetcount");
//String[] sourcefacet = (String[])request.getAttribute("sourcefacet");
//Integer[] sourcefacetcount = (Integer[])request.getAttribute("sourcefacetcount");
//String[] societyfacet = (String[])request.getAttribute("societyfacet");
//Integer[] societyfacetcount = (Integer[])request.getAttribute("societyfacetcount");
String searchtime = request.getAttribute("searchtime").toString();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>按会议举办国家统计</title>
<link rel="stylesheet" type="text/css" href="static/css/main.css" />
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
  <tr><td><br/><br/></td></tr>
  <tr>
    <td><!-- 主题代码开始 -->	
	  <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
       <tr bgcolor="#dfe6ec">
        <td><a href="StatisticbyCountry">按举办国统计</a></td><td><a href="StatisticbySubject">按主题统计</a></td><td><a href="StatisticbySponsor">按举者者统计</a></td><td>按学协会统计</td><td><a href="StatisticbyYear?yearspan=5">按时间统计</a></td>
       </tr>
      </table>  
    </td>
  </tr>
  <tr>
    <td><!-- 主题代码开始 -->	
     <div class="mainmsg">
  <%
    DefaultCategoryDataset data = new DefaultCategoryDataset();
    for(int i=0;i<10;i++)
    {   
      data.addValue(countryfacetcount[i],"举办会议数量",countryfacet[i]); 
    }
  %>	
  </div>
<br />

    <%
        JFreeChart chart = ChartFactory.createBarChart3D("会议举办国","国家名","会议数量",data,PlotOrientation.VERTICAL,true,true,false);        
        final CategoryPlot plot = chart.getCategoryPlot();
        final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setMinimumBarLength(0.02);
        renderer.setMaximumBarWidth(0.05);
        renderer.setDrawBarOutline(false);               
        renderer.setItemLabelGenerator( new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible( true );
        
        ItemLabelPosition itemLabelPosition= new ItemLabelPosition(ItemLabelAnchor.INSIDE12,TextAnchor.CENTER_RIGHT,TextAnchor.CENTER_RIGHT,-1.57D);
        StandardEntityCollection sec = new StandardEntityCollection(); 
        ChartRenderingInfo info = new ChartRenderingInfo(sec); 
        PrintWriter w = new PrintWriter(out);//输出MAP信息 
        //500是图片长度，300是图片高度
        //String filename = ServletUtilities.saveChartAsPNG(chart,500,300,info,session);

        plot.setRenderer(renderer);

         //  设置柱的透明度
        plot.setForegroundAlpha(0.8f);
        
        NumberAxis numberaxis = (NumberAxis)plot.getRangeAxis(); 
        numberaxis.setTickUnit(new NumberTickUnit(200));
         
        String filename = ServletUtilities.saveChartAsJPEG(chart,700,400,info,session); 
        ChartUtilities.writeImageMap(w,"mapbar",info,false); 
        String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
   %>
  <p align="center"> 
  	<img src="<%=graphURL%>" width=600 height=400 border=0 usemap="#mapbar"></img> 
  </p> 

     <%
        DefaultPieDataset piedata = new DefaultPieDataset(); 
        for(int i=0;i<10;i++)
        {   
        	piedata.setValue(countryfacet[i],countryfacetcount[i]); 
        }
    %>
    <%
        JFreeChart chartpie = ChartFactory.createPieChart3D("会议举办国",piedata,true,false,false);
        PiePlot3D plotpie = (PiePlot3D) chartpie.getPlot();  
        plot.setForegroundAlpha(0.8f);  
        chartpie.setTitle("会议举办国分布饼图");
        // 图形边框颜色  
        plotpie.setBaseSectionOutlinePaint(Color.BLUE); 
        // 设置鼠标悬停提示  
        plotpie.setToolTipGenerator(new StandardPieToolTipGenerator());  
        filename = ServletUtilities.saveChartAsJPEG(chartpie,700,500,info,session); 
        ChartUtilities.writeImageMap(w,"mappie",info,false); 
        graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
   %>
   
  <p align="center"> 
  	<img src="<%=graphURL%>" width=600 height=400 border=0 usemap="#mappie"></img> 
  </p> 


  <div>
  <table align="center" width="60%" height="17"  border="0" cellpadding="0" cellspacing="0">
  <thead>
	<tr bgcolor="#B1C4D1">
	<td height="32" align="center" class="red2" width="5%"><font size="3">ID</font></td>
	<td height="32" align="center" class="red2" width="15%" ><font size="3">国家名称</font></td>
	<td height="32" align="center" class="red2" width="10%" ><font size="3">会议数量</font></td>
	</tr>
    <tr align="left">
      <td height="1" colspan="3" bgcolor="#C6C6C6"></td>
    </tr>	
  </thead>
  <%
    for(int i=0;i<10;i++)
    {   
  %> 
	<tr>
	  <td height="30" align="center"><font size="3"><%=i+1%></font></td>    
 	  <td height="30" align="center"><a href="CountryDisplay?currentpage=0&pagetype=init&country=<%=countryfacet[i]%>" class="hei"><font size="3"><%=countryfacet[i]%></font></a></td>
      <td height="30" align="center"><font size="3"><%=countryfacetcount[i]%></font></td>
	</tr>
    <tr align="left" class="red">
      <td height="1" colspan="3" bgcolor="#C6C6C6"></td>
    </tr>    	
  <% 
  }
  %>
      <tr align="left" class="red">
      <td height="1" colspan="3" bgcolor="#C6C6C6"></td>
    </tr>	
  </table>
  <br/>
  </div>
  
    <!-- 主题代码结束 --></td>
  </tr>
  <tr>
    <td><!-- 页尾开始 -->
      <table width="1002" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center" valign="top" bgcolor="#FFFFFF" ><table width="990" border="0" cellpadding="0" cellspacing="0">
          
          
            <tr>
              <td height="49" align="center" valign="middle" bgcolor="#CCCCCC" class="hei">&copy; 2014 中国科学院文献情报中心 版权所有 京ICP备100256382号 </td>
            </tr>
            <tr>
              <td height="3" align="center" valign="middle" bgcolor="#FFFFFF" class="hei"></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="3" bgcolor="#FFFFFF"></td>
      </tr>
    </table><!-- 页尾结束 --></td>
  </tr>
</table>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;
</p>
</body>
</html>
