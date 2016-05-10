<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资料提交</title>
<link href="../css/style1.css" rel="stylesheet" type="text/css" />
<link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
<script type="text/javascript" src="../js/dtree.js"></script>
</head>
<body scroll="no">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="79" background="../images/top_bg.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="500"><img src="../images/top_left.gif" width="500" height="79"></td>
          <td>&nbsp;</td>
          <td width="500" height="79"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="../images/top_right_a.gif" width="500" height="47"></td>
              </tr>
              <tr>
                <td><table width="500" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="150"><img src="../images/top_right_b1.gif" width="150" height="32"></td>
                    <td width="146" height="32" background="../images/top_right_b2.gif" class="white">用户：administrator</td>
                    <td width="74"><a href="pages/based/passwd.html" target="page"><img src="../images/top_right_b6.gif" width="74" height="32" border="0"></a></td>
                    <td width="50"><a href="login.html"><img src="../images/top_right_b3.gif" width="50" height="32" border="0"></a></td>
                    <td width="50"><a href="#"><img src="../images/top_right_b4.gif" width="50" height="32" border="0"></a></td>
                    <td width="30"><img src="../images/top_right_b5.gif" width="30" height="32"></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="100%"><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="background-repeat: repeat-x;">
        <tr>
          <td width="175" height="100%" valign="top"><table width="175" height="100%" border="0" cellspacing="0" cellpadding="0" background="../images/menu_bg.gif">
              <tr>
                <td height="25"><img src="../images/menu_top.gif" width="175" height="25"></td>
              </tr>
              <tr>
                <td height="100%" style="background-image:url(../images/menu_bgT.gif); background-repeat:no-repeat" valign="top"><div class="dtree">
                    <script type="text/javascript">
					d = new dTree('d');
					d.config.stepDepth = 1;
					d.config.useStatusText = true;
					 
					d.add(0,-1,' <strong>后台管理</strong>');
					d.add(5,0,'扶持项目专区');
					d.add(501,5,'服务券申请');
					d.add(50101,501,'企业信息管理','pages/fwj/01_list.html',"",'page');
					d.add(50102,501,'合同信息管理','pages/fwj/02_list.html',"",'page');
					d.add(50103,501,'回访信息管理','pages/fwj/03_list.html',"",'page');
					d.add(50104,501,'企业信息统计','pages/fwj/04_list.html',"",'page');
					d.add(50105,501,'服务券统计','pages/fwj/05_list.html',"",'page');
					d.add(50106,501,'合同信息统计','pages/fwj/06_list.html',"",'page');
					d.add(50107,501,'机构回访统计','pages/fwj/07_list.html',"",'page');
					d.add(50108,501,'扶持效果统计','pages/fwj/08_list.html',"",'page');
					d.add(502,5,'认定机构申请');
					d.add(50201,502,'机构信息管理','pages/rdjg/01_list.html',"",'page');
					d.add(1,0,'会员管理');
					d.add(101,1,'企业会员','pages/based/query.html',"",'page');
					d.add(102,1,'机构会员','pages/based/query.html',"",'page');
					d.add(103,1,'政府部门','pages/based/query.html',"",'page');
					d.add(2,0,'筛选管理');
					d.add(201,2,'筛选设置','pages/based/shaixuan_a.html',"",'page');
					d.add(202,2,'筛选列表','pages/based/shaixuan_b.html',"",'page');
					d.add(3,0,'信息管理');
					d.add(301,3,'机构资讯','pages/based/info.html',"",'page');
					d.add(302,3,'服务信息','pages/based/info.html',"",'page');
					d.add(303,3,'服务产品','pages/based/info.html',"",'page');
					d.add(304,3,'专业小贴士','pages/based/info.html',"",'page');
					d.add(4,0,'消息管理');
					d.add(401,4,'发送消息','pages/based/msg.html',"",'page');
					document.writeln(d);
					</script>
                </div></td>
              </tr>
              <tr>
                <td height="31"><img src="../images/menu_foot.gif" width="175" height="31"></td>
              </tr>
            </table></td>
          <td><iframe src="pages/fwj/01_list.html" width="100%" height="100%" frameborder="0" scrolling="no" name="page"></iframe></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>