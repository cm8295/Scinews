﻿//初始化
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
        			'<td width="50" bgcolor="#96E0E2">'+'序号'+'</td>'+
        			'<td bgcolor="#96E0E2">'+'用户姓名'+'</td>'+
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
            			'<td>'+dataObj.rows[i - 1].expert+'</td>'+
            			'<td>'+dataObj.rows[i - 1].file1+'</td>'+
            			'<td>'+dataObj.rows[i - 1].uploadtime+'</td>'+
            			'<td>'+dataObj.rows[i - 1].suggestion+'</td>'+
            			'<td>'+ '<button id="bt' + i + '" onclick="select(this)">修改</button><button>下载</button>' +'</td>'+
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
    alert("序号：" + elementId.parentNode.parentNode.children[0].innerHTML +
        "用户：" + elementId.parentNode.parentNode.children[1].innerHTML);
}

function abc(){
	window.showModalDialog("/Scinews/manage/upload");
	/*var mydata = null;
	$.ajax({
        url: "/Scinews/manage/patentmanagement",
        type: "post",
        //datatype:"",
        contentType:"application/json",
        success: function (data) {
        	var dataObj=eval("("+data+")");//转换为json对象 
        	alert(dataObj.rows.length);//输出root的子对象数量 
        	alert(dataObj.rows[0].file1);
        	//var parsedJson = jQuery.parseJSON(data); 
        	//alert(parsedJson.rows[1].id);
        	//alert(parsedJson.total);
        	//var parsedJson1 = jQuery.parseJSON(data.rows); 
        	//alert(parsedJson1.id);
        	//var ddd = data.toJSONString();
        	//alert(ddd);
        	 $.each(data.rows, function(i, item) {
                 alert(item.file1);
             });
        	 
        }
    });*/
	/*$.ajax({
        url: "/Scinews/manage/patentmanagement",
        //data: "name=dfsdf",
        type: "post",
        //datatype:"json",
        contentType:"application/json",
        success: function (result) {
      	  JSONObject json = JSONObject.fromObject(result);
      	  alert(json.toString());
        }
    });*/
}