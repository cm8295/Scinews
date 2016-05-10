<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="gov.lct.model.Tpatentbasicinfo" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FPA</title>
<style>

body {
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  margin: auto;
  position: relative;
  width: 960px;
}

form {
  position: absolute;
  right: 10px;
  top: 10px;
}

.node {
  border: solid 1px white;
  font: 10px sans-serif;
  line-height: 12px;
  overflow: hidden;
  position: absolute;
  text-indent: 2px;
}
</style>
<script type="text/javascript" src="js/d3.min.js"></script>
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
  <td>请选择专利权人数量：
         <form method="GET" action="StatisticByTibetFpa" >
          <select name="count">
           <option value="20">20个</option>
           <option value="30">30个</option>
           <option value="50">50个</option>
           <option value="80">80个</option>
           <option value="100">100个</option>
          </select> 
          <input type="submit" value="GO">                  
         </form>
  </td>
 </tr>  

 <tr>
  <td id="svg">
  <script>
var margin = {top: 40, right: 10, bottom: 10, left: 10},
    width = 960 - margin.left - margin.right,
    height = 500 - margin.top - margin.bottom;

var color = d3.scale.category20c();

var treemap = d3.layout.treemap()
    .size([width, height])
    .sticky(true)
    .value(function(d) { return d.size; });

var div = d3.select("#svg").append("div")
    .style("position", "relative")
    .style("width", (width + margin.left + margin.right) + "px")
    .style("height", (height + margin.top + margin.bottom) + "px")
    .style("left", margin.left + "px")
    .style("top", margin.top + "px");

d3.json("/rssfeed/tibetfpa.json", function(error, root) {
  var node = div.datum(root).selectAll(".node")
      .data(treemap.nodes)
    .enter().append("div")
      .attr("class", "node")
      .call(position)
      .style("background", function(d) { return d.children ? color(d.name) : null; })
      .on("click",function(d,i){
   	    var url = 'TibetPatentFpaDisplay?currentpage=0&pagenumber=1&pagetype=jump&content='+d.name;
        GetPatentbyAjax(url);
	   })			
      
      .text(function(d) { return d.children ? null : d.name + ":" + d.value; });

  d3.selectAll("input").on("change", function change() {
    var value = this.value === "count"
        ? function() { return 1; }
        : function(d) { return d.size; };

    node
        .data(treemap.value(value).nodes)
      .transition()
        .duration(1500)
        .call(position);
  });
});

function position() {
  this.style("left", function(d) { return d.x + "px"; })
      .style("top", function(d) { return d.y + "px"; })
      .style("width", function(d) { return Math.max(0, d.dx - 1) + "px"; })
      .style("height", function(d) { return Math.max(0, d.dy - 1) + "px"; });
}

</script>
</td>
</tr>

<tr>
<td id="_partmessage">

</td>
</tr>
</table>

<table>

</table>

</body>
</html>
