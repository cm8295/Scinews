<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ page import="java.util.Collection"%>
<%@ page import="gov.lct.model.Tupload"%>
<%
String endtime = (String)request.getAttribute("endtime");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"  language="javascript">
</script>
<script type="text/javascript" language="javascript">
/* function bn_click(){
    $(".newFile").toggle();
} */
function check(form){
	if(form.file1.value=="" || form.file2.value=="" || form.file3.value=="" || form.file4.value=="" || form.file5.value=="" 
		|| form.file6.value=="" || form.file7.value=="" || form.file8.value=="" || form.file9.value==""){
		alert("第(1-9)项为必填项");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div>
	<form name="userForm2" action="/Scinews/manage/upload"
		enctype="multipart/form-data" method="post" onsubmit="return check(this)">
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
								<!-- <th align="center"><input type="checkbox" name="checkbox"
									id="checkbox"></th> -->
								<th align="center">文件类别</th>
								<th align="center" class="newFile" id="newFile"">新上传文件</th>
								<!-- <th align="center">上传时间</th> -->
								<th width="200" align="center">操作</th>
							</TR>
							<TR>
								<!-- <TD align="center"><input type="checkbox" name="checkbox2"
									id="checkbox2"></TD> -->
								<TD align="center" name="type1">科技查新报告</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file1" id="file1"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='/manage/require';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<!-- <TD align="center"><input type="checkbox" name="checkbox7"
									id="checkbox7"></TD> -->
								<TD align="center" name="type2">研制报告</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file2" id="file2"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<!-- <TD align="center"><input type="checkbox" name="checkbox8"
									id="checkbox8"></TD> -->
								<TD align="center" name="type3">背景材料</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file3" id="file3"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<!-- <TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD> -->
								<TD align="center" name="type4">成果审批文件</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file4" id="file4"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<!-- <TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD> -->
								<TD align="center" name="type5">论文发表收录及引用证明</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file5" id="file5"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<!-- <TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD> -->
								<TD align="center" name="type6">知识产权证明</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file6" id="file6"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<!-- <TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD> -->
								<TD align="center" name="type7">推广应用产生的经济效益或者社会效益</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file7" id="file7"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<!-- <TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD> -->
								<TD align="center" name="type8">奖项证明</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file8" id="file8"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<!-- <TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD> -->
								<TD align="center" name="type9">著作证明</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file9" id="file9"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							
							<!-- 非必须提交材料 -->
							<TR class="BGCgray">
								<!-- <TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD> -->
								<TD align="center" name="type10">测试分析报告</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file10" id="file10"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<!-- <TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD> -->
								<TD align="center" name="type11">主要实验</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file11" id="file11"></TD>
								<%-- <TD align="center"><%=uploadtime%></TD> --%>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<!-- <TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD> -->
								<TD align="center" name="type12">测试记录报告</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file12" id="file12"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<!-- <TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD> -->
								<TD align="center" name="type13">产品检测报告</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file13" id="file13"></TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<!-- <TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD> -->
								<TD align="center" name="type14">环境生态效益证明</TD>
								<TD align="center" class="newFile"><input type="file" accept=".jpg,.docx,.doc,.jpeg,.xls,.png,.pdf" name="file14" id="file14"></TD>
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
		<input type="submit" name="submit" value="上传">
	</form>
	</div>
</body>
</html>