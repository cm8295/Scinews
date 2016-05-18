<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%
   String loginname = (String)session.getAttribute("loginname");
%>
<%
String path_content = request.getContextPath();
String basePath_content = request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+path_content+"/";
%>
<script type="text/javascript" src="<%=path_content %>/js/adm-userdata.js"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
        <title>增加Table行</title>
    </head>
<script language="javascript">// Example: obj = findObj("image1");
function findObj(theObj, theDoc){ 
var p, i, foundObj;
    if(!theDoc) theDoc = document; 
    if( (p = theObj.indexOf("?")) > 0 && parent.frames.length) 
    {   
        theDoc = parent.frames[theObj.substring(p+1)].document; 
        theObj = theObj.substring(0,p); 
    }  
    if(!(foundObj = theDoc[theObj]) && theDoc.all)
        foundObj = theDoc.all[theObj]; 
    for (i=0; !foundObj && i < theDoc.forms.length; i++)
        foundObj = theDoc.forms[i][theObj];
    for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++) 
        foundObj = findObj(theObj,theDoc.layers[i].document);  
    if(!foundObj && document.getElementById) 
        foundObj = document.getElementById(theObj);   
    return foundObj;
}
//添加一个参与人填写行
function AddSignRow(){ //读取最后一行的行号，存放在txtTRLastIndex文本框中
 var txtTRLastIndex = findObj("txtTRLastIndex",document);
 var rowID = parseInt(txtTRLastIndex.value);
 
 var signFrame = findObj("SignFrame",document);
 //添加行
 var newTR = signFrame.insertRow(signFrame.rows.length);
 newTR.id = "SignItem" + rowID;
 
 //添加列:序号
 var newNameTD=newTR.insertCell(0);
 //添加列内容
 newNameTD.innerHTML = newTR.rowIndex.toString();
 
 //添加列: 姓名
 var newNameTD=newTR.insertCell(1);
 //添加列内容
 newNameTD.innerHTML = "<input name='txtName" + rowID + "' id='txtName" + rowID + "' type='text' size='12' style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px ' />";
 
 //添加列:电子邮箱
 var newEmailTD=newTR.insertCell(2);
 //添加列内容
 newEmailTD.innerHTML = "<input name='txtEMail" + rowID + "' id='txtEmail" + rowID + "' type='text' size='20' style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px '/>";
 
 //添加列:电话
 var newTelTD=newTR.insertCell(3);
 //添加列内容
 newTelTD.innerHTML = "<input name='txtTel" + rowID + "' id='txtTel" + rowID + "' type='text' size='10' style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px '/>";
 
 //添加列:手机
 var newMobileTD=newTR.insertCell(4);
 //添加列内容
 newMobileTD.innerHTML = "<input name='txtMobile" + rowID + "' id='txtMobile" + rowID + "' type='text' size='12' style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px '/>";
 
 //添加列:公司名
 var newCompanyTD=newTR.insertCell(5);
 //添加列内容
 newCompanyTD.innerHTML = "<input name='txtCompany" + rowID + "' id='txtCompany" + rowID + "' type='text' size='20' style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px '/>";
 
 
 //添加列:删除按钮
 var newDeleteTD=newTR.insertCell(6);
 //添加列内容
 newDeleteTD.innerHTML = "<div align='center' style='width:40px'><a href='javascript:;' onclick=\"DeleteSignRow('SignItem" + rowID + "')\">删除</a></div>";
 
 //将行号推进下一行
 txtTRLastIndex.value = (rowID + 1).toString() ;
}
//删除指定行
function DeleteSignRow(rowid){
 var signFrame = findObj("SignFrame",document);
 var signItem = findObj(rowid,document);
 
 //获取将要删除的行的Index
 var rowIndex = signItem.rowIndex;
 
 //删除指定Index的行
 signFrame.deleteRow(rowIndex);
 
 // 重新排列序号，如果没有序号，这一步省略
 for(i=rowIndex;i<signFrame.rows.length;i++){
  signFrame.rows[i].cells[0].innerHTML = i.toString();
 }
}//清空列表
function ClearAllSign(){
 if(confirm('确定要清空所有参与人吗？')){
  var signFrame = findObj("SignFrame",document);
  var rowscount = signFrame.rows.length;
 
  //循环删除行,从最后一行往前删除
  for(i=rowscount - 1;i > 0; i--){
   signFrame.deleteRow(i);
  }
 
  //重置最后行号为1
  var txtTRLastIndex = findObj("txtTRLastIndex",document);
  txtTRLastIndex.value = "1";
 
  //预添加一行
  AddSignRow();
 }
}
</script>

    <body>
         <div>
  <table width="613" border="0" cellpadding="2" cellspacing="1" id="SignFrame">
              <tr id="trHeader">
                <td width="27" bgcolor="#96E0E2">序号</td>
                <td width="64" bgcolor="#96E0E2">用户姓名</td>
                <td width="98" bgcolor="#96E0E2">电子邮箱</td>
                <td width="92" bgcolor="#96E0E2">固定电话</td>
                <td width="86" bgcolor="#96E0E2">移动手机</td>
                <td width="153" bgcolor="#96E0E2">公司名称</td>
                <td width="57" align="center" bgcolor="#96E0E2">&nbsp;</td>
              </tr>
        </table>
   </div>
   <div>
        <input type="button" name="Submit" value="添加参与人" onclick="AddSignRow()" />
     <input type="button" name="Submit2" value="清空" onclick="ClearAllSign()" />
     <input name='txtTRLastIndex' type='hidden' id='txtTRLastIndex' value="1" />
   </div>
    </body>
</html> 
  		