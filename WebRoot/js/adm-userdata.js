﻿$(function(){
	alert("测试");
	/*$("#add").click(function(){
		alert("fff");
		$.post("/Scinews/manage/patentmanagement1",
		{
		    name:"asdf",
		    aaa:"mmm"
		},
		function(data,status){
		//$("#tt").val(data);
	    alert("ak");
	  });
	});*/
	var mydata;
	$.ajax({
        url: "/Scinews/manage/patentmanagement",
        data: "{\"a\":\"a\"}",
        type: "post",
        datatype:"json",
        contentType:"application/json",
        success: function (data) {
        	mydata = data;
          //$("#tt").val(data);
      	  //alert(data);
         console.log(mydata);
        }
    });
	 /*$.getJSON("/Scinews/manage/patentmanagement", function(data) {
	        $("#tt").append(data.total+"<hr/>");
	        $("#tt").append(data.loginname+"<hr/>");
	        //jquery解析map数据
	        $.each(data.infomap,function(key,value){
	            $("#mapinfo").append(key+"----"+value+"<br/><hr/>");
	        });
	        //解析数组
	        $.each(data.comments, function(i, item) {
	            $("#info").append(
	                    "<div>" + item.id + "</div>" + 
	                    "<div>" + item.nickname    + "</div>" +
	                    "<div>" + item.content + "</div><hr/>");
	        });
	        //alert("aaa");
	        });*/
	
	/*$('#add').click(function(){
		alert("aaa");
	});*/
});

function abc(){
	alert("aaa");
	$.ajax({
        url: "/Scinews/manage/patentmanagement",
        //data: "name=dfsdf",
        type: "post",
        datatype:'json',
        contentType:"application/json",
        success: function (result) {
      	  JSONObject json = JSONObject.fromObject(result);
      	  alert(json.toString());
        }
    });
}