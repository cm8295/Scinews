<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ page import="java.util.Collection"%>
<%@ page import="gov.lct.model.Tupload"%>
<%
String endtime="",file1="",file2="",file3="",file4="",file5="",file6="",file7="",
file8="",file9="",file10="",file11="",file12="",file13="",file14="",
state1="",state2="",state3="",state4="",state5="",state6="",state7="",state8="",
state9="",state10="",state11="",state12="",state13="",state14="",uploadtime="",suggestion="";
endtime = (String)request.getAttribute("endtime");
file1 = (String)request.getAttribute("file1");
file2 = (String)request.getAttribute("file2");
file3 = (String)request.getAttribute("file3");
file4 = (String)request.getAttribute("file4");
file5 = (String)request.getAttribute("file5");
file6 = (String)request.getAttribute("file6");
file7 = (String)request.getAttribute("file7");
file8 = (String)request.getAttribute("file8");
file9 = (String)request.getAttribute("file9");
file10 = (String)request.getAttribute("file10");
file11 = (String)request.getAttribute("file11");
file12 = (String)request.getAttribute("file12");
file13 = (String)request.getAttribute("file13");
file14 = (String)request.getAttribute("file14");
state1 = (String)request.getAttribute("state1");
state2 = (String)request.getAttribute("state2");
state3 = (String)request.getAttribute("state3");
state4 = (String)request.getAttribute("state4");
state5 = (String)request.getAttribute("state5");
state6 = (String)request.getAttribute("state6");
state7 = (String)request.getAttribute("state7");
state8 = (String)request.getAttribute("state8");
state9 = (String)request.getAttribute("state9");
state10 = (String)request.getAttribute("state10");
state11 = (String)request.getAttribute("state11");
state12 = (String)request.getAttribute("state12");
state13 = (String)request.getAttribute("state13");
state14 = (String)request.getAttribute("state14");
uploadtime = (String)request.getAttribute("uploadtime");
suggestion = (String)request.getAttribute("suggestion");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"  language="javascript">
</script>
<script type="text/javascript" language="javascript">
function bn_click(){
	//var user_name=$("#bn1").attr("value");
	//alert(user_name);
	//$(".newfile").css('display','block');
    $(".newFile").toggle();
}
function check(){
	
}
</script>
</head>
<body>
	<form name="userForm2" action="/Scinews/manage/upload"
		enctype="multipart/form-data" method="post" onsubmit="return check()">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td
					style="height: 34px; background-image: url(../../images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						    <td align="left" class="white" style="padding-left: 20px">
								<label name="username">材料提交截至时间：<%=endtime%></label>
							</td>
							<td align="right" class="white" style="padding-right: 20px">
								<label name="username">用戶名：<%=request.getSession().getAttribute("loginname")%></label>
							</td>
						</tr>
					</table>
				</td>
			</tr>		
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th align="center"><input type="checkbox" name="checkbox"
									id="checkbox"></th>
								<th align="center">文件类别</th>
								<th align="center">已上传文件</th>
								<th align="center" class="newFile" id="newFile" style="display:none">新上传文件</th>
								<th align="center">上传时间</th>
								<th align="center">审核状态</th>
								<th width="200" align="center">操作</th>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox2"
									id="checkbox2"></TD>
								<TD align="center">科技查新报告</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file1%>>
								</TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file1" id="file1"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state1%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='/manage/require';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox7"
									id="checkbox7"></TD>
								<TD align="center">研制报告</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file2%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file2" id="file2"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state2%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox8"
									id="checkbox8"></TD>
								<TD align="center">背景材料</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file3%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file3" id="file3"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state3%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">成果的审批文件</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file4%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file4" id="file4"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state4%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">论文发表收录及引用证明材料</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file5%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file5" id="file5"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state5%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">知识产权证明材料</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file6%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file6" id="file6"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state6%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">推广应用所产生的经济效益或者社会效益</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file7%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file7" id="file7"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state7%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">奖项证明材料</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file8%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file8" id="file8"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state8%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">著作证明材料</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file9%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file9" id="file9"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state9%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							
							<!-- 非必须提交材料 -->
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">测试分析报告</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file10%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file10" id="file10"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state10%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">主要实验</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file11%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file11" id="file11"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state11%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">测试记录报告</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file12%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file12" id="file12"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state12%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">产品检测报告</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file13%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file13" id="file13"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state13%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">环境生态效益证明</TD>
								<TD align="center"><input type="text" name="tfile" id="tfile" value=<%=file14%>></TD>
								<TD align="center" class="newFile" style="display:none"><input type="file" name="file14" id="file14"></TD>
								<TD align="center"><%=uploadtime%></TD>
								<TD align="center"><%=state14%></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<div><label>反馈意见：</label><textarea disabled="disabled" style="resize:none" rows="2" cols="80" name="content" id="content"><%=suggestion%></textarea></div>
		<input type="button" class="bn1" id="bn1" value="增加..."  onClick="bn_click()">
		<input type="submit" name="submit" value="上传">
	</form>

</body>
</html>