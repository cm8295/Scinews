//初始化
$(function(){
	$.ajax({
        url: "/Scinews/manage/patentmanagement",
        type: "post",
        contentType:"application/json",
        success: function (data) {
        	var dataObj=eval("("+data+")");//转换为json对象 
        	var len = dataObj.rows.length;
        	//alert(dataObj.rows.length);
        	$('#data').append('<tr>' +
        			'<td bgcolor="#96E0E2">'+'序号'+'</td>'+
        			'<td bgcolor="#96E0E2">'+'姓名'+'</td>'+
        			'<td bgcolor="#96E0E2">' + '单位' + '</td>' +
        			'<td bgcolor="#96E0E2">' + '邮箱' + '</td>' +
        			'<td bgcolor="#96E0E2">' + '电话' + '</td>' +
        			'<td bgcolor="#96E0E2">'+'评审专家'+'</td>'+
        			'<td bgcolor="#96E0E2">'+'已提交资料'+'</td>'+
        			'<td bgcolor="#96E0E2">'+'时间'+'</td>'+
        			'<td bgcolor="#96E0E2">'+'意见'+'</td>'+
        			'<td bgcolor="#96E0E2">'+'操作'+'</td>'+
        			'</tr>')
        	
        	for(var i = 1 ; i < len + 1;i++) {
        		$('#data').append('<tr>' +
            			'<td>'+ i +'</td>'+
            			'<td>'+dataObj.rows[i - 1].loginname+'</td>'+
            			'<td>'+ /*dataObj.rows[i - 1].institute*/'中科院文献情报中心' +'</td>'+
            			'<td>'+ /*dataObj.rows[i - 1].email*/'cm8295@163.com' +'</td>'+
            			'<td>'+ /*dataObj.rows[i - 1].mobile*/'18595647894' +'</td>'+
            			'<td>'+dataObj.rows[i - 1].expert+'</td>'+
            			'<td>'+dataObj.rows[i - 1].file1+'</td>'+
            			'<td>'+dataObj.rows[i - 1].uploadtime+'</td>'+
            			'<td>'+dataObj.rows[i - 1].suggestion+'</td>'+
            			'<td>'+ '<button id="bt' + i + '" onclick="select(this)">修改意见</button>'
            			+ '<input type="button" id="btxz1" onclick="down(this)" value="下载"/>' + '</td>'+
            			'</tr>'
        				)
        	}
        	//alert(dataObj.rows[0].file1);
        }
    });
	$("table td").click(function() {
        var row = $(this).parent().index() + 1; // 行位置
        var col = $(this).index() + 1; // 列位置
        alert("当前位置：第"+row+"行，第"+col+"列")
    });
});


function select(elementId) {
	//alert(elementId.parentNode.parentNode.children[1].innerHTML);
	window.showModalDialog("/Scinews/manage/getSuggestion?user=" + elementId.parentNode.parentNode.children[1].innerHTML);
	/*val dataObj="";
	$.ajax({
        url: "/Scinews/manage/getSuggestion",
        data:{"user":elementId.parentNode.parentNode.children[1].innerHTML},
        type: "post",
        contentType:"application/json",
        success: function (data) {
        	dataObj=eval("("+data+")");//转换为json对象 
        	var len = dataObj.rows.length;
        	'<select name="role" multiple="multiple" size="5">'
              	for(var i = 1 ; i < len + 1;i++) {
                   '<option value='+ dataObj.rows[i - 1].expert + ':' + dataObj.rows[i - 1].suggestion +'</option>'
              	}
               '</select>'   
        }
    });*/
	
	/*var d = dialog({
	    title: 'message',
	    content: '<input autofocus />'
	});
	d.showModal();*/
    /*alert("序号：" + elementId.parentNode.parentNode.children[0].innerHTML +
        "用户：" + elementId.parentNode.parentNode.children[1].innerHTML);*/
}

function abc(){
	window.showModalDialog("/Scinews/manage/getSuggestion?user=test");
}

function down(elementId) {
	var username = elementId.parentNode.parentNode.children[1].innerHTML;
	var form=$("<form>");//定义一个form表单
	form.attr("style","display:none");
	form.attr("target","");
	form.attr("method","post");
	form.attr("enctype","multipart/form-data");
	form.attr("action","/Scinews/manage/download?fileName=" + username);
	var input1=$("<input>");
	input1.attr("type","hidden");
	input1.attr("name","exportData");
	input1.attr("value","test");
	$("body").append(form);//将表单放置在web中
	form.append(input1);
	form.submit();//表单提交
}
function subSetting() {
	alert("sdf");
	$.ajax({
        url: $("#setId").submit(),
        data:{"":""},
        type: "post",
        datatype:"json",
        contentType:"application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            console.log(data);
            alert(data);
        }
    });
}