<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
        <head>
                <meta charset="utf-8">
                <title>D3: Axis moved to the bottom</title>
                <script type="text/javascript" src="static/d3.v3.js"></script>
                <style type="text/css">
                        
 div.bar {
                                display: inline-block;
                                width: 20px;
                                height: 75px;        /* Gets overriden by D3-assigned height below */
                                margin-right: 2px;
                                background-color: teal;
                        }

                </style>
        </head>
        <body>
        <%
           Integer[] point = new Integer[5];
           for(int p=0; p<5; p++)
           {
        	  point[p]= p * 10 + 5;         	  
           }   
        %>  
                      
   <script type="text/javascript">

                        var dataset = new Array();
                        <% for(int i=0;i< 5; i++) 
                          {
                        %>   
                            dataset[<%=i%>] = "<%=point[i]%>";    
                        <%
                          }
                        %> 
                        
                        d3.select("body").selectAll("div")
                                .data(dataset)
                                .enter()
                                .append("div")
                                .attr("class", "bar")
                                .style("height", function(d) {
                                        var barHeight = d * 5;
                                        return barHeight + "px";
                                });                        
                </script>
        </body>
</html>