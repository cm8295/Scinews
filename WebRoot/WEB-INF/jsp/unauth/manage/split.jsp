<%@page contentType="text/html;charset=UTF-8"%>
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<STYLE type=text/css>BODY {
	BACKGROUND-COLOR: #e7e7e5
}
</STYLE>

<META content="MSHTML 6.00.3790.2795" name=GENERATOR></HEAD>
<BODY>
<TABLE height="100%" cellSpacing=0 cellPadding=0 border=0>
  <TBODY>
  <TR height="100%">
    <TD height="100%" align=middle background="images/split_bg.jpg" class=spiltBtn><!-- <img alt="开关" src="images/split_left.jpg" name="right" id="right" style="cursor:hand" onClick="showHide();"  /> --></TD>
  </TR></TBODY></TABLE>

<script language="javascript"> 
<!-- 
function showHide() 
{ 
	var right = document.getElementById("right");
	var left = document.getElementById("left");
	var center = parent.document.getElementById("center");
	if(right==null)
	{
		center.cols="184,10,*"; 
		left.src="images/split_left.jpg"; 
		left.id="right"; 
	}
	else if (left==null)
	{

		center.cols="0,10,*"; 
		right.src="images/split_right.jpg"; 
		right.id="left";
	}
	else if (left!=null && right!=null)
	{
		if(left.name=="left")
		{
		if(left.name=="left"){
			center.cols="0,10,*"; 
			right.src="images/split_right.jpg"; 
			right.id="left";
			}
		}
		else if(left.name=="right")
		{
		center.cols="184,10,*"; 
		left.src="images/split_left.jpg"; 
		left.id="right";
		}
	}
} 
//--> 
</script> 
</BODY></HTML>
