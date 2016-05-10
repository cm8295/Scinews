<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Tpatentbasicinfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%>
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@ page import="org.jfree.chart.urls.CategoryURLGenerator"%>
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
<%@ page import="org.jfree.chart.axis.ValueAxis"%>
<%@ page import="org.jfree.chart.labels.*"%>
<%@ page import="org.jfree.chart.util.*"%>
<%@ page import="org.jfree.chart.ChartFactory"%>
<%@ page import="org.jfree.chart.JFreeChart"%>
<%@ page import="org.jfree.ui.TextAnchor"%>
<%@ page import="org.jfree.chart.urls.StandardCategoryURLGenerator"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="org.jfree.chart.renderer.category.LineAndShapeRenderer"%>


<%
//int confcount = Integer.parseInt(request.getAttribute("confcount").toString());
String[] yearfacet = (String[])request.getAttribute("yearfacet");
Integer[] yearfacetcount = (Integer[])request.getAttribute("yearfacetcount");
int yearspan = (Integer)request.getAttribute("yearspan");

//年代逆序排序
for (int i=0;i<yearfacet.length-1 ;i++ )
{
    int min=i;
    for (int j=i+1;j<yearfacet.length ;j++ )
    {
      if (Integer.parseInt(yearfacet[min])<Integer.parseInt(yearfacet[j])) //如果这里是>0，则为顺序排
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

int count = 0;
if(yearspan==0)
   count = yearfacet.length;
else
   count = yearspan;	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专利类别分布统计</title>
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
  
       <tr> 
        <td >请选择年份跨度：
         <form method="GET" action="StatisticByAd" >
          <select name="yearspan">
           <option value="5">近5年</option>
           <option value="8">近8年</option>
           <option value="10">近10年</option>
           <option value="15">近15年</option>
           <option value="20">近20年</option>
          </select> 
          <input type="submit" value="GO">                  
         </form>
        </td>
       </tr>  
       
  <tr>
    <td colspan="4">	
     <div class="mainmsg">
  <%
    DefaultCategoryDataset data = new DefaultCategoryDataset();
    for(int i=count-1;i>=0;i--)
    {   
      if(yearfacet[i]!=null)	
        data.addValue(yearfacetcount[i],"专利年份",yearfacet[i]+" 年"); 
    }
  %>	
  </div>
<br />

    <%
        JFreeChart chart = ChartFactory.createBarChart3D("中国科学院专利申请年统计图","年份","专利数量",data,PlotOrientation.VERTICAL,true,true,true);        
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        Font font = new Font("隶书", Font.BOLD,10);
        renderer.setMinimumBarLength(0.02);
        renderer.setMaximumBarWidth(0.01);
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.15);
        renderer.setDrawBarOutline(false);
        renderer.setSeriesPaint(0, new Color(0, 255, 0));
        
        CategoryAxis domainAxis = plot.getDomainAxis();          
        domainAxis.setTickLabelPaint(Color.BLUE) ; // 字体颜色      
        domainAxis.setLabelFont(font);
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的label斜显示  

        
        //renderer.setItemLabelGenerator( new StandardCategoryItemLabelGenerator());
        //renderer.setItemLabelsVisible( true );
        // 注意：下面这句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题(3D的才需要这句，2D的上面那句足矣)
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));        
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator("CirculationByMonth", "year", ""));
        renderer.setItemLabelAnchorOffset(10D);
        
        //ItemLabelPosition itemLabelPosition= new ItemLabelPosition(ItemLabelAnchor.INSIDE12,TextAnchor.CENTER_RIGHT,TextAnchor.CENTER_RIGHT,-1.57D);
        StandardEntityCollection sec = new StandardEntityCollection(); 
        ChartRenderingInfo info = new ChartRenderingInfo(sec); 
        PrintWriter w = new PrintWriter(out);//输出MAP信息 
        renderer.setWallPaint(Color.gray);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        plot.setRenderer(renderer);

         //  设置柱的透明度
        plot.setForegroundAlpha(0.8f);
        
        NumberAxis numberaxis = (NumberAxis)plot.getRangeAxis(); 
        numberaxis.setTickUnit(new NumberTickUnit(1000));
         
        String filename = ServletUtilities.saveChartAsJPEG(chart,800,600,info,session); 
        ChartUtilities.writeImageMap(w,"mapbar",info,false); 
        String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
   %>
  <p align="center"> 
  	<img src="<%=graphURL%>" width=800 height=600 border=0 usemap="#mapbar"></img> 
  </p> 
</td>
</tr>

<tr>
<td>
     <div class="mainmsg">
     <%
        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
        String series = "中国科学院专利申请年折线图";
        String[] month = new String[yearfacet.length];
        String[] monthcount = new String[yearfacet.length];
        for(int i=count-1;i>=0;i--)
        {   
          if(yearfacet[i]!=null)	
        	linedataset.addValue(yearfacetcount[i],series,yearfacet[i]+"年"); // 对应的横轴 
        }

        JFreeChart linechart = ChartFactory.createLineChart(
        "专利申请年折线图", // 横轴  类别名称","馆藏数量
        "年份", // 纵轴
        "专利数量", // 获得数据集
        linedataset,
        PlotOrientation.VERTICAL, // 图标方向垂直
        true, // 显示图例
        false, // 不用生成工具
        false // 不用生成URL地址
        );
//整个大的框架属于chart  可以设置chart的背景颜色


// 生成图形
CategoryPlot lineplot = linechart.getCategoryPlot();
// 图像属性部分
lineplot.setBackgroundPaint(Color.white);
lineplot.setDomainGridlinesVisible(true);  //设置背景网格线是否可见
lineplot.setDomainGridlinePaint(Color.BLACK); //设置背景网格线颜色
lineplot.setRangeGridlinePaint(Color.GRAY);
lineplot.setNoDataMessage("没有数据");//没有数据时显示的文字说明。 
// 数据轴属性部分
NumberAxis linerangeAxis = (NumberAxis) lineplot.getRangeAxis();
linerangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
linerangeAxis.setAutoRangeIncludesZero(true); //自动生成
linerangeAxis.setUpperMargin(0.20);
linerangeAxis.setLabelAngle(Math.PI / 2.0); 
linerangeAxis.setAutoRange(false);
linerangeAxis.setTickUnit(new NumberTickUnit(1000));

domainAxis = lineplot.getDomainAxis();          
domainAxis.setTickLabelPaint(Color.BLUE) ; // 字体颜色      
domainAxis.setLabelFont(font);
domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的label斜显示  

// 数据渲染部分 主要是对折线做操作
LineAndShapeRenderer linerenderer = (LineAndShapeRenderer) lineplot.getRenderer();
linerenderer.setBaseItemLabelsVisible(true);
linerenderer.setSeriesPaint(0, Color.black);    //设置折线的颜色
linerenderer.setBaseShapesFilled(true);
linerenderer.setBaseItemLabelsVisible(true);     
linerenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
linerenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  

linerenderer.setBaseItemLabelFont(new Font("Dialog", 1, 14));  //设置提示折点数据形状
lineplot.setRenderer(linerenderer);
//区域渲染部分
double lowpress = 4.5; 
double uperpress = 8;   //设定范围
IntervalMarker inter = new IntervalMarker(lowpress, uperpress);  
//inter.setLabelOffsetType(LengthAdjustmentType.EXPAND); //  范围调整——扩张
inter.setPaint(Color.LIGHT_GRAY);// 域顏色  

inter.setLabelFont(new Font("SansSerif", 41, 14));  
inter.setLabelPaint(Color.RED);  
inter.setLabel("中国科学院专利申请年统计折线图");    //设定区域说明文字
//lineplot.addRangeMarker(inter,Layer.BACKGROUND);  //添加mark到图形   BACKGROUND使得数据折线在区域的前端

StandardEntityCollection linesec = new StandardEntityCollection(); 
ChartRenderingInfo lineinfo = new ChartRenderingInfo(linesec); 
PrintWriter linew = new PrintWriter(out);//输出MAP信息 
String lingfilename = ServletUtilities.saveChartAsJPEG(linechart,800,600,lineinfo,session); 
ChartUtilities.writeImageMap(linew,"mapbar",lineinfo,false); 
String linegraphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + lingfilename;
   %>
  <p align="center"> 
  	<img src="<%=linegraphURL%>" width=800 height=600 border=0 usemap="#mapbar"></img> 
  </p>
</div>
</td>
</tr>

 <tr>
 <td>
  
  <table align="center" width="60%" height="17"  border="0" cellpadding="0" cellspacing="0">
  <thead>
	<tr bgcolor="#B1C4D1">
	<td height="32" align="center" class="red2" width="5%"><font size="3">ID</font></td>
	<td height="32" align="center" class="red2" width="15%" ><font size="3">年份</font></td>
	<td height="32" align="center" class="red2" width="10%" ><font size="3">专利数量</font></td>
	</tr>
    <tr align="left">
      <td height="1" colspan="3" bgcolor="#C6C6C6"></td>
    </tr>	
  </thead>
  <%
    for(int i=0;i<yearfacet.length;i++)
    {   
      if(yearfacet[i]!=null)
      {
  %> 
	<tr>
	  <td height="30" align="center"><font size="3"><%=i+1%></font></td>    
 	  <td height="30" align="center"><a href="PatentIcmDeatilSummary?icm=<%=yearfacet[i]%>" class="hei"><font size="3"><%=yearfacet[i]%></font></a></td>
      <td height="30" align="center"><font size="3"><%=yearfacetcount[i]%></font></td>
	</tr>
    <tr align="left" class="red">
      <td height="1" colspan="3" bgcolor="#C6C6C6"></td>
    </tr>    	
  <% 
      }
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
    <td>
     <!--插入页尾 -->   
     <%@ include file="/common/footer.jsp"%>
    <!--插入页尾完毕 -->    
    </td>
  </tr>
</table>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;
</p>

</body>
</html>
