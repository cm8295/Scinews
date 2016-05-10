<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%
   String loginname = (String)session.getAttribute("loginname");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>需求信息添加</title>
</head>
<body>
   <form name="require" id="require" action="requiresave" method="post">         
          <table>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">需求名称</div><font color="red">*</font></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="name" id="name" type="text" size="60"  maxlength="200"/></div></td>
              </tr>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">需求内容</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><textarea rows="5" cols="80" name="content" id="content"></textarea></div></td>
              </tr>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">主要难题</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><textarea rows="5" cols="80" name="problem" id="problem"></textarea></div></td>
              </tr>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">所属领域</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="industry" id="industry" type="text" size="60"  maxlength="20"/></div></td>
              </tr>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">需求机构</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="unitName" id="unitName" type="text" size="60"  maxlength="20"/></div></td>
              </tr>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">合作要求</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><textarea rows="5" cols="80" name="cooperation" id="cooperation"></textarea></div></td>
              </tr>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">具备条件</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><textarea rows="5" cols="80" name="haveCondition" id="haveCondition"></textarea></div></td>
              </tr>
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">联系人</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="linkman" id="linkman" type="text" size="30" maxlength="50"/></div>
                </td>
              </tr>              
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">联系电话</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="phone" id="phone" type="text" size="30" maxlength="50"/></div>
                </td>
              </tr>              
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">通讯地址</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="address" id="address" type="text" size="60" maxlength="200"/></div>
                </td>
              </tr>              
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">邮编</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="zipcode" id="zipcode" type="text" size="10" /></div>
                </td>
              </tr>              
              <tr>
                <td height="25" colspan="6"><div class="bulk-actions align-left">电子邮件</div></td>
                <td height="25" colspan="6"><div class="bulk-actions align-left"><input name="email" id="email" type="text" size="50" /></div>
                </td>
              </tr>                         
              <tr>
                <td height="25" colspan="6"></td>
                <td height="25" colspan="6"></td>
              </tr>              
              <tr>
                <td height="25" colspan="6"></td>
                <td height="25" colspan="6"><input class="button" type="submit" value="添加信息"/><input  class="button" type="reset" value="重置数据"/></td>
              </tr>
           </table>
           <input type="hidden" name="createPerson" value="<%=loginname%>" />
       </form>
</body>
</html>