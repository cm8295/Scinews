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
	<form name="userForm2" action="/Scinews/file/user-upload"
		enctype="multipart/form-data" method="post" onsubmit="return check()">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td
					style="height: 34px; background-image: url(../../images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<!-- <td width="20" height="34"><img
								src="../../images/main_headerL.gif" width="20" height="34"></td>
							<td style="color: #90c8e8;"><img
								src="../../images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>企业信息管理</strong></td> -->
							<td align="right" class="white" style="padding-right: 20px"><!-- <a
								href="01_edit.html" class="barBtn"
								onClick="location.href='01_edit.html'"><img
									src="../../images/5.png" align="absmiddle"> 新增</a> <a
								href="#" class="barBtn" onClick="javascript:history.go(-1);"><img
									src="../../images/btn_left.gif" align="absmiddle"> 后退</a> <a
								href="#" class="barBtn" onClick="javascript:history.go(+1);"><img
									src="../../images/btn_right.gif" align="absmiddle"> 前进</a> <a
								href="#" class="barBtn"><img
									src="../../images/btn_refresh.gif" align="absmiddle"> 刷新</a> -->
								<label name="username">用戶名：<%=request.getSession().getAttribute("loginname")%></label>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<!-- <tr>
				<td
					style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;"><table
						width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1">
						<TR>
							<th width="10%" align="center">企业名称</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="textfield" id="textfield"></td>
							<th width="10%" align="center">营业执照</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="textfield2" id="textfield2"></td>
							<th width="10%" align="center"><STRONG>经营范围</STRONG></th>
							<td width="20%" class="BGCgray"><select name="select2"
								id="select2">
									<option>全部</option>
									<option>信息服务</option>
									<option>创业辅导</option>
									<option>管理咨询</option>
									<option>人员培训</option>
									<option>技术创新</option>
									<option>市场拓展</option>
									<option>法律事物</option>
									<option>财税服务</option>
									<option>人才代理</option>
							</select></td>
							<th width="10%" align="center"><BUTTON style="HEIGHT: 25px"
									onClick="javascript:if (confirm('查询数据？')) location.href='#';else return;">
									<img src="../../images/btn_search.gif" width="16" height="16"
										align="absmiddle"> 查询
								</BUTTON></th>
						</TR>
					</table></td>
			</tr> -->
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
								<TD align="center"><input type="file" name="file_1" id="file_1"></TD>
								<TD align="center"></TD>
								<TD align="center">通过</TD>
								<TD width="200" align="center"><BUTTON
										style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('查看该信息？')) location.href='S';else return;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px"
										onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
							</TR>
							<TR class="BGCgray">
								<TD align="center"><input type="checkbox" name="checkbox3"
									id="checkbox3"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
								<TD align="center">通过</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox4"
									id="checkbox4"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
								<TD align="center">通过</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox5"
									id="checkbox5"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
								<TD align="center">通过</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox6"
									id="checkbox6"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
								<TD align="center">不通过</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox7"
									id="checkbox7"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
								<TD align="center">不通过</TD>
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
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
								<TD align="center">不通过</TD>
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
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
								<TD align="center">不通过</TD>
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
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox11"
									id="checkbox11"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox2"
									id="checkbox2"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox3"
									id="checkbox3"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox4"
									id="checkbox4"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox5"
									id="checkbox5"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox6"
									id="checkbox6"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox7"
									id="checkbox7"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
								<TD align="center"><input type="checkbox" name="checkbox11"
									id="checkbox11"></TD>
								<TD align="center">成都汇龙湾商贸有限公司</TD>
								<TD align="center">张三</TD>
								<TD align="center">13880123123</TD>
								<TD align="center">成都市金牛区沙湾路21号</TD>
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
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20%" height="25"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#"><img src="../../images/prev_top.gif"
													width="16" height="16" border="0"></a></td>
											<td><a href="#"><img src="../../images/prev.gif"
													width="16" height="16" border="0"></a></td>
											<td><a href="#"><img src="../../images/next.gif"
													width="16" height="16" border="0"></a></td>
											<td><a href="#"><img src="../../images/prev_end.gif"
													width="16" height="16" border="0"></a></td>
										</tr>
									</table></td>
								<td width="20%" align="center"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#"><img src="../../images/next.gif"
													width="16" height="16" border="0"></a></td>
											<td><input name="textfield23" type="text" size="3"
												style="width: 25; height: 18"> /页</td>
										</tr>
									</table></td>
								<td width="20%" align="right">共10条记录显示到1/1</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<div id="newUpload2">
			<input type="file" name="file_1" id="file_1">
		</div>
		<div id="div1">
			<input type="hidden" name="file1" id="file1" value="womeiyou" />
		</div>
		<input type="text" id="text" name="text1" value="nihao" /> <input
			type="button" id="btn_add2" name="b2" value="增加一行"> <input
			type="submit" name="submit" value="上传">
	</form>

</body>
</html>