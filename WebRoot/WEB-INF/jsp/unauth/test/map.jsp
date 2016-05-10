<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
   String[] lat = {"51.508742","52.508742","53.508742"};
   String[] lng = {"-0.120850","-0.220850","-0.320850"};
   String lats = "[", lngs="[";
   
   for(int i=0; i<lat.length; i++)
   {
	 if(i<lat.length-1)
	 {
	   lats = lats + lat[i] + ",";
	   lngs = lngs + lng[i] + ",";
	 }
	 else
	 {
	   lats = lats + lat[i];
	   lngs = lngs + lng[i];
	 }		 
   }
   lats = lats + "]";
   lngs = lngs + "]";
   System.out.println(lats);
   //System.out.println(lngs);
%>

<html>
<head>
<script
src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
</script>

<script>

function initialize()
{

var lat = <%=lats%>;
var lng = <%=lngs%>;    
var myCenter=new google.maps.LatLng(39.917, 116.397);
//var myCenter=new google.maps.LatLng(85, -180);	

var mapProp = {
  center:myCenter,
  zoom:5,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

}
google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>

<body>
<div id="googleMap" style="width:1024px;height:768px;"></div>
</body>
</html>
			