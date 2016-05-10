﻿﻿﻿﻿﻿﻿﻿<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	 String userName=(String)request.getAttribute("userName");
	 String roleName=(String)request.getAttribute("roleName");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #D0EBFC;
}
.lan {	font-size: 9pt;
	color: #2A4D59;
	text-decoration: none;
}
.qlan {
	font-size: 9pt;
	color: #438ABE;
	text-decoration: none;
}
-->
</style></head>

<body>
<br />
<table width="190" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" align="center" valign="middle"><table width="162" border="0" align="center" cellpadding="0" cellspacing="0" background="images/left-bj1.jpg">
      <tr>
        <td width="152"><img src="images/jsqh.jpg" width="182" height="17" /></td>
      </tr>            
      <tr>
        <td width="182" height="60" align="right" background="images/yhdl.jpg"><table width="149" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="67" height="24" align="right" valign="middle" class="lan">用户：</td>
          <td width="82" height="24" align="left" class="lan"><%=userName %></td>
          </tr>
          <tr>
            <td height="24" align="right" class="lan">角色：</td>
          <td height="24" align="left" class="lan"><%=roleName %></td>
          </tr>
        </table></td>
      </tr>
      
      
      
      <tr>
        <td><table width="182" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="182" ><a href="javascript:showmenu(lay0)"><img src="images/l-0.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay0' style="display:table;">
            <td height="80" align="center" valign="middle" background="images/left-bj1.jpg" ><table width="175" border="0" cellspacing="0">
                <tr>
                  <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg" class="lan"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left"><a href="moveInsertPermission" target="mainFrame" class="lan">权限添加</a></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left" class="lan"><a href="updatePermissionPage" target="mainFrame" class="lan">权限修改</a> </td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left" class="lan"><a href="deletePermissionPage" target="mainFrame" class="lan">权限删除 </a> </td>
                      </tr>
                  </table></td>
                </tr>				
            </table></td>
          </tr>
          
          
          <tr>
            <td bgcolor="#99CCFF"><a href="javascript:showmenu(lay1)"><img src="images/l-1.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay1' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
                <tr>
                  <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left" class="lan"><a href="moveInsertRole" target="mainFrame" class="lan">角色添加</a></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left" class="lan"><a href="updateRolePage" target="mainFrame" class="lan">角色修改</a></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="deleteRolePage" target="mainFrame" class="lan">角色删除</a></td>
                    </tr>
                  </table></td>
                </tr>
				
				
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#99CCFF"><a href="javascript:showmenu(lay2)"><img src="images/l-2.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay2' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
                <tr>
                  <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left" class="lan"><a href="moveInsertUserInfo" target="mainFrame" class="lan">用户添加</a></td>
                      </tr>
                  </table></td>
                </tr>
            
				<tr>
                  <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left" class="lan"><a href="updateUserInfoPage" target="mainFrame" class="lan">用户修改</a> </td>
                      </tr>
                  </table></td>
                </tr>      
                
                <tr>
                  <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="51">&nbsp;</td>
                        <td width="112" align="left" class="lan"><a href="deleteUserInfoPage" target="mainFrame" class="lan">用户删除</a> </td>
                      </tr>
                  </table></td>
                </tr>
            </table></td>
          </tr>
		  
          <!-- 行业信息源-->		  
          <tr>
          <td><table width="182" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="182" ><a href="javascript:showmenu(lay11)"><img src="images/l-0.jpg" width="182" height="33" border="0" /></a></td>
            </tr>
            <tr id='lay11' style="display:none;">
              <td height="80" align="center" valign="middle" background="images/left-bj1.jpg" ><table width="175" border="0" cellspacing="0">
                  <tr>
                    <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg" class="lan"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="51">&nbsp;</td>
                          <td width="112" align="left"><a href="moveInsertSource" target="mainFrame" class="lan">信息源添加</a></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="51">&nbsp;</td>
                          <td width="112" align="left" class="lan"><a href="updateSourcePage" target="mainFrame" class="lan">信息源修改</a> </td>
                        </tr>
                    </table></td>
                  </tr>
                  
                  <tr>
                    <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="51">&nbsp;</td>
                          <td width="112" align="left" class="lan"><a href="deleteSourcePage" target="mainFrame" class="lan">信息源删除 </a> </td>
                        </tr>
                    </table></td>
                  </tr>				
    
            <tr>
            <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="51">&nbsp;</td>
                <td width="112" align="left" class="lan"><a href="AreaInfoCrawlSourcePage" target="mainFrame" class="lan">行业资讯自动采集</a> </td>
              </tr>
            </table></td>
         </tr>      
         
         </table></td>
         </tr>
          
		  
          <tr>
            <td bgcolor="#99CCFF"><a href="javascript:showmenu(lay3)"><img src="images/l-3.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay3' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="moveInsertAreaInfo" target="mainFrame" class="lan">行业资讯添加</a></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="updateAreaInfoPage" target="mainFrame" class="lan">行业资讯修改</a> </td>
                    </tr>
                </table></td>
              </tr>              
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="deleteAreaInfoPage" target="mainFrame" class="lan">行业资讯删除 </a></td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
      
          
          <tr>
            <td align="center" valign="middle" background="images/left-bj1.jpg"><a href="javascript:showmenu(lay4)"><img src="images/l-4.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay4' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="moveInsertNoticeInfoNEWS" target="mainFrame" class="lan">新闻添加</a></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="updateNoticeInfoNEWSPage" target="mainFrame" class="lan">新闻修改</a> </td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
       
          <tr>
            <td align="center" valign="middle" background="images/left-bj1.jpg"><a href="javascript:showmenu(lay5)"><img src="images/l-5.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay5' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="moveInsertNoticeInfo" target="mainFrame" class="lan">通知添加</a></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="updateNoticeInfoPage" target="mainFrame" class="lan">通知修改</a> </td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
         
          <tr>
            <td align="center" valign="middle" background="images/left-bj1.jpg"><a href="javascript:showmenu(lay6)"><img src="images/l-6.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay6' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan">成果添加</td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="updateKjcgPage" target="mainFrame" class="lan">状态修改</a> </td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
     
            <td align="center" valign="middle" background="images/left-bj1.jpg"><a href="javascript:showmenu(lay7)"><img src="images/l-7.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay7' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan">专利添加</td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="updatePatentBasicInfoPage" target="mainFrame" class="lan">状态修改</a></td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
       
            <td align="center" valign="middle" background="images/left-bj1.jpg"><a href="javascript:showmenu(lay8)"><img src="images/l-8.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay8' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="moveInsertRequire" target="mainFrame" class="lan">需求添加</a></td>
                    </tr>
                </table></td>
              </tr>

              <tr>
              <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="51">&nbsp;</td>
                    <td width="112" align="left" class="lan"><a href="checkRequirePage" target="mainFrame" class="lan">需求审核</a></td>
                  </tr>
              </table></td>
            </tr>
              
              
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="updateRequirePage" target="mainFrame" class="lan">需求修改</a></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="deleteRequirePage" target="mainFrame" class="lan">需求删除</a></td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        
            <td align="center" valign="middle" background="images/left-bj1.jpg"><a href="javascript:showmenu(lay9)"><img src="images/l-9.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay9' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="moveInsertPolice" target="mainFrame" class="lan">法规添加</a></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="updatePolicePage" target="mainFrame" class="lan">法规修改</a> </td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan"><a href="deletePolicePage" target="mainFrame" class="lan">法规删除</a> </td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
       
            <td align="center" valign="middle" background="images/left-bj1.jpg"><a href="javascript:showmenu(lay10)"><img src="images/l-10.jpg" width="182" height="33" border="0" /></a></td>
          </tr>
          <tr id='lay10' style="display:none;">
            <td align="center" valign="middle" background="images/left-bj1.jpg"><table width="175" border="0" cellspacing="0">
              <tr>
                <td width="100%" height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan">反馈回答</td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35" align="center" valign="middle" background="images/left-bj2.jpg"><table width="163" height="21" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="51">&nbsp;</td>
                      <td width="112" align="left" class="lan">状态修改 </td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><img src="images/tcxt.jpg" width="182" height="37" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td width="29" height="30" align="center" valign="middle"><div align="left"></div></td>
  <td width="161" align="left" valign="middle">&nbsp;</td>
  </tr>
</table>

<script language=JavaScript> 
function showmenu(strID){ 
    var i; 
    for(i=0;i<=10;i++){ 
        var lay; 
        lay = eval('lay' + i); 
        if (lay.style.display=="block" && lay!=eval(strID)){ 
            lay.style.display = "none"; 
        } 
    } 
    if (strID.style.display=="none"){ 
        strID.style.display = "block"; 
    }else{ 
        strID.style.display = "none"; 
    } 
} 
</script> 

</body>
</html>
