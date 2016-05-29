<%@ page language="java" import="java.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专家评审</title>
</head>
<frameset NAME="global" rows="111,*,32" framespacing="0" frameborder="no" border="1">
	<frame src="top" name="top" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset name="center" rows="*" cols="184,10,*" framespacing="0"
		frameborder="no" border="0">
		<frame border="1" src="expertleft" name="expertleft" scrolling="no"
			noresize="noresize" id="leftFrame" title="leftFrame" target="expert1"/>
		<frame name="split" scrolling="no" noresize src="split"
			marginwidth="0" marginheight="0" />
		<frame name="expert1" src="expert1" scrolling="yes" />
	</frameset>
	<frame src="bottom" name="bottom" scrolling="No"
		noresize="noresize" id="botFrame" title="botFrame" />
  </frameset>
<body>
    <!-- <a href="manage/evluation1">查看评审信息</a> -->
</body>
</html>