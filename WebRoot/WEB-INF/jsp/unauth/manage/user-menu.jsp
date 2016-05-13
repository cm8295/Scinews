<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<frameset NAME="global" rows="111,*,32" framespacing="0" frameborder="0" border="10">
	<frame src="top" name="top" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset name="center" rows="*" cols="184,5,*" framespacing="0"
		frameborder="no" border="0">
		<frame border="1" src="userleft" name="left" scrolling="no"
			noresize="noresize" id="leftFrame" title="leftFrame" target="main"/>
		<frame name="split" scrolling="no" noresize src="split"
			marginwidth="0" marginheight="0" />
		<frame name="userState" src="userState" scrolling="yes" />
	</frameset>
	<frame src="bottom" name="bottom" scrolling="No"
		noresize="noresize" id="botFrame" title="botFrame" />
  </frameset>
  
<body>

</body>
</html>