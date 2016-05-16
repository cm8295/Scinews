<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
								<th align="center">文件</th>
								<th align="center">上传时间</th>
								<th align="center">审核状态</th>
								<th width="200" align="center">操作</th>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox2"
									id="checkbox2"></TD>
								<TD align="center">科技查新报告</TD>
								<TD align="center"><input type="file" name="file1" id="file1"></TD>
								<TD align="center"></TD>
								<TD align="center">通过</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox7"
									id="checkbox7"></TD>
								<TD align="center">研制报告</TD>
								<TD align="center"><input type="file" name="file2" id="file2"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox8"
									id="checkbox8"></TD>
								<TD align="center">背景材料</TD>
								<TD align="center"><input type="file" name="file3" id="file3"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">成果的审批文件</TD>
								<TD align="center"><input type="file" name="file4" id="file4"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">论文发表收录及引用证明材料</TD>
								<TD align="center"><input type="file" name="file5" id="file5"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">知识产权证明材料</TD>
								<TD align="center"><input type="file" name="file6" id="file6"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">推广应用所产生的经济效益或者社会效益</TD>
								<TD align="center"><input type="file" name="file7" id="file7"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">奖项证明材料</TD>
								<TD align="center"><input type="file" name="file8" id="file8"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">著作证明材料</TD>
								<TD align="center"><input type="file" name="file9" id="file9"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							
							<!-- 非必须提交材料 -->
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">测试分析报告</TD>
								<TD align="center"><input type="file" name="file10" id="file10"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">主要实验</TD>
								<TD align="center"><input type="file" name="file11" id="file11"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">测试记录报告</TD>
								<TD align="center"><input type="file" name="file12" id="file12"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR>
								<TD align="center"><input type="checkbox" name="checkbox10"
									id="checkbox10"></TD>
								<TD align="center">产品检测报告</TD>
								<TD align="center"><input type="file" name="file13" id="file13"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox9"
									id="checkbox9"></TD>
								<TD align="center">环境生态效益证明</TD>
								<TD align="center"><input type="file" name="file14" id="file14"></TD>
								<TD align="center"></TD>
								<TD align="center">待审核</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
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

</body>
</html>