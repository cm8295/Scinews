

function $(id){return document.getElementById(id)}//获取ID

//系统管理登录验证
function chk_adm_login(){
	if($("adm-u").value=="" || $("adm-u").value=="请输入管理员账号" || $("adm-u").value.length<4 || $("adm-u").value.length>13){
		alert("账号输入有误！");
		$("adm-u").focus();
		return false;
	}
	if($("adm-p").value=="" || $("adm-p").value=="请输入账号密匙" || $("adm-p").value.length<4 || $("adm-p").value.length>15){
		alert("密匙输入有误！");
		$("adm-p").focus();
		return false;
	}
}

function cg_adm_left(id){
	$("adm-left-menu-bg-"+id).className="adm-left-menu-bgt";
}

function cc_adm_left(id){
	$("adm-left-menu-bg-"+id).className="adm-left-menu-bg";
}
//-->