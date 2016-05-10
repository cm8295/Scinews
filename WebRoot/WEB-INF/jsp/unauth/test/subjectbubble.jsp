<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
   <title>Subject Bubble</title>
   <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
   <script type="text/javascript" src="js/d3.min.js"></script>
<style>

text {
  font: 10px sans-serif;
}

</style>
</head>
<body>
<script>

var diameter = 960,
    format = d3.format(",d"),
    color = d3.scale.category20();

var bubble = d3.layout.pack()
    .sort(null)
    .size([diameter, diameter])
    .padding(1.5);

var svg = d3.select("body").append("svg")
    .attr("width", diameter)
    .attr("height", diameter)
    .attr("class", "bubble");

d3.json("/rssfeed/confsubject.json", function(error, root) {
  var node = svg.selectAll(".node")
      .data(bubble.nodes(classes(root))
      .filter(function(d) { return !d.children; }))
    .enter().append("g")
      .attr("class", "node")
      .attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });

  node.append("title")
      .text(function(d) { return d.className + ": " + format(d.value); });

  circle = node.append("circle")
      .attr("r", function(d) { return d.r; })
      .style("fill", function(d) { return color(d.packageName); });

  node.append("text")
      .attr("dy", ".3em")
      .style("text-anchor", "middle")
      .on("click",function(d){
    	  window.open ('http://localhost/OpenResource/SubjectDisplay?currentpage=0&pagetype=init&subject='+d.className.substring(0, d.r/3)) ; 
			})
      .text(function(d) { return d.className.substring(0, d.r / 3) + ":" + d.value; });
});


// Returns a flattened hierarchy containing all leaf nodes under the root.
function classes(root) {
  var classes = [];

  function recurse(name, node) {
    if (node.children) node.children.forEach(function(child) { recurse(node.name, child); });
    else classes.push({packageName: name, className: node.name, value: node.size});
  }

  recurse(null, root);
  return {children: classes};
}

d3.select(self.frameElement).style("height", diameter + "px");

</script>
        </body>
</html>