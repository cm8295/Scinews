<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<%
String year = request.getAttribute("year").toString();
String source = "static/conference" + year + ".js";
System.out.println(source);
%>
<html>

<head>
   <!-- See http://developer.yahoo.com/yui/grids/ for info on the grid layout -->

   <title>Local Timeline Example</title>

   <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />


   <!-- See http://developer.yahoo.com/yui/ for info on the reset, font and base css -->

   <link rel="stylesheet" href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css" type="text/css">
   <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.7.0/build/base/base-min.css"> 


   <!-- Load the Timeline library after reseting the fonts, etc -->

   <script src="static/timeline-api.js?bundle=true" type="text/javascript"></script>

 
   <link rel="stylesheet" href="static/local_example.css" type="text/css">

   <!-- Since we don't have our own server, we do something tricky and load our data here as if it were a library file -->
   <script src="<%=source%>" type="text/javascript"></script>
   
   <script>        
        var tl;
        function onLoad() {
            var tl_el = document.getElementById("tl");
            var eventSource1 = new Timeline.DefaultEventSource();
            
            var theme1 = Timeline.ClassicTheme.create();
            theme1.autoWidth = true; // Set the Timeline's "width" automatically.
                                     // Set autoWidth on the Timeline's first band's theme,
                                     // will affect all bands.
            theme1.timeline_start = new Date(Date.UTC(<%=year%>, 1, 1));
            theme1.timeline_stop  = new Date(Date.UTC(<%=year%>, 12, 31));
            
            var d = Timeline.DateTime.parseGregorianDateTime("<%=year%>")
            var bandInfos = [
                Timeline.createBandInfo({
                    width:          55, // set to a minimum, autoWidth will then adjust
                    intervalUnit:   Timeline.DateTime.MONTH, 
                    intervalPixels: 100,
                    eventSource:    eventSource1,
                    date:           d,
                    theme:          theme1,
                    layout:         'original'  // original, overview, detailed
                })
            ];
                                                            
            // create the Timeline
            tl = Timeline.create(tl_el, bandInfos, Timeline.HORIZONTAL);
            
            var url = '.'; // The base url for image, icon and background image
                           // references in the data
            eventSource1.loadJSON(timeline_data, url); // The data was stored into the 
                                                       // timeline_data variable.
                                                                   
            tl.layout(); // display the Timeline
        }
        
        var resizeTimerID = null;
        function onResize() {
            if (resizeTimerID == null) {
                resizeTimerID = window.setTimeout(function() {
                    resizeTimerID = null;
                    tl.layout();
                }, 500);
            }
        }
   </script>

</head>

<body onload="onLoad();" onresize="onResize();">

<div id="doc3" class="yui-t7">

   <div id="hd" role="banner">
     <h1>Local Timeline Example</h1>
     <p>This example reads a local data file from the disk and displays it using the Simile Timeline library. The software library is retrieved from servers via the Internet.</p>
     <p>The Timeline will grow automatically to fit the events. Scroll towards 2030 to see it grow. Click on an event to see its details.</p>
   </div>

   <div id="bd" role="main">

	   <div class="yui-g">

	     <div id='tl'></div>
	     <p>To move the Timeline: use the mouse scroll wheel, the arrow keys or grab and drag the Timeline.</p>

	   </div>

	 </div>

   <div id="ft" role="contentinfo">
     <p>Thanks to the <a href=''>Simile Timeline project</a> Timeline version <span id='tl_ver'></span></p>
     <script>Timeline.writeVersion('tl_ver')</script> 
   </div>

</div>


</body>

</html>


