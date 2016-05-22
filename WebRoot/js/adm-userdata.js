$(function(){
	//alert("测试");
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
	
	/*$.ajax({
        url: "/Scinews/manage/patentmanagement",
        data: "name=dfsdf",
        type: "post",
        //datatype:'json',
        //contentType:"application/json",
        success: function (data) {
        	
          $("#tt").val(data);
      	  alert(data);
        }
    });*/
	 $.getJSON("/Scinews/manage/patentmanagement", function(data) {
	        $("#tt").append(data.total+"<hr/>");
	        $("#tt").append(data.loginname+"<hr/>");
	        /*//jquery解析map数据
	        $.each(data.infomap,function(key,value){
	            $("#mapinfo").append(key+"----"+value+"<br/><hr/>");
	        });
	        //解析数组
	        $.each(data.comments, function(i, item) {
	            $("#info").append(
	                    "<div>" + item.id + "</div>" + 
	                    "<div>" + item.nickname    + "</div>" +
	                    "<div>" + item.content + "</div><hr/>");
	        });*/
	        alert("aaa");
	        });
	$('#filename').validatebox({   
	    required: false,   
	}); 
	
	var number_style = [
	                    {text:'等于',value:'0'},
	                    {text:'小于',value:'2'},
	                    {text:'小于等于',value: '3'},
	                    {text:'大于',value:'4'},
	                    {text:'大于等于',value:'5'},
	                    {text:'不等于',value:'6'}
	                   ];
	
	var style_ids = ['age_style','height_style','weight_style'];
	var style_panelHeight = 4+number_style.length*20;
	for(var i=0;i<style_ids.length;i++){
		$('#'+style_ids[i]).combobox({
			width:80,
			panelHeight:style_panelHeight,
			valueField:'value',
			textField:'text',
			data: number_style,
			editable:false
		});
		$('#'+style_ids[i]).combobox('select','3');
	}
		
	var content_width = parseInt($('#content').css('width')) - 17;
	var parentWidth = content_width - 80;
	//var widths = parentWidth*0.1;
	var widths = parentWidth*0.088;
	
	var myPagesize = 25;//jQuery.cookie("pageSize");
	if(!myPagesize){
		 myPagesize = 25;
	}
	$('#patient_list').datagrid({   
		title:'病者列表1',
	    url:'/Scinews/manage/patentmanagement',
	    width:content_width,
	    rownumbers:true,
	    fitColumns:true,
	    pagination:true,
	    loadMsg:'数据加载中',
	    singleSelect:true,
	    pageNumber:1,
	    pageSize:myPagesize,
	    pageList:[5,10,15,20,30,35,40,45,50,myPagesize],
	    striped:true,
	    toolbar:'#searchcondition',
	    columns:[[
	              {field:'loginname',title:'姓名',width:widths,align:'center',sortable:false},
	              {field:'file1',title:'文件1',width:widths,align:'center',sortable:true},   
	              {field:'file2',title:'年龄',width:widths,align:'center'},   
	              {field:'file3',title:'身高',width:widths,align:'center'},
	              {field:'file4',title:'体重',width:widths,align:'center'},
	              {field:'file5',title:'bpm',width:widths,align:'center'},
	              {field:'file6',title:'bpd',width:widths,align:'center'},
	              {field:'file7',title:'日期',width:widths,align:'center'},
	              {field:'file8',title:'ope',width:widths,align:'center'},
	              {field:'file9',title:'操作',width:widths,formatter:formatOper,align:'center'},
	              ]],
	    onDblClickRow: function(rowIndex, rowData){
	    	numToString(rowData);
	    	location.href = "/tee/main/getpatient_video?uid="+rowData.flapa;
		},
		onLoadError:function(){
			alert("加载失败！");
		}
	});
	
	$('#patient_list').datagrid('getPager').pagination({
		onChangePageSize:function(pageSize){
			//此处可将用户设置每页显示条数保存到cookies
			//$.cookie("pageSize", pageSize);
		}
	});
	
    $('.pagination-page-list > option:last-child').remove();
	
	//实现病者列表的查询和清空功能
	$('#search').click(function(){
		var attributeName = ["name","sex","age","height","weight"];	//五个查询条件	
		var values = [
		              	$('#name').val(),
		              	$("input[name='sex']:checked").length==0?"":$("input[name='sex']:checked").val(),
		              	$('#age').val(),
		              	$('#height').val(),
		              	$('#weight').val(),
		             ];
		var styles = [1-$('#name_style:checked').length, //$('#name_style:checked').length是精确选择框长度，只有1(选中，精确查询)、0(空，模糊查询)
		              0,
		              $('#age_style').combobox('getValue'),
		              $('#height_style').combobox('getValue'),
		              $('#weight_style').combobox('getValue')
		              ];
		
		var array = new Array();
		for(var i=0;i<values.length;i++){	//未输入值的查询条件就不需要再传到后台。
			if(values[i]!=""){
				var conditionObject = {};
				conditionObject.name = attributeName[i];
				conditionObject.value = values[i];
				conditionObject.style = styles[i];
				array.push(conditionObject);
			}
		}
		var conds = JSON.stringify(array);		//将js对象转为json字符串
		$('#patient_list').datagrid('load',{"conds":conds});//将此json字符串传到后台
	});
	
	$('#clean').click(function(){
		$('#name').val('');
		$('input[name="sex"]').removeAttr('checked');
		$('#age').val('');
		$('#height').val('');
		$('#weight').val('');
	});
	
	$('#dlg-t').dialog({
	    closed:true,
	    width: 1000,
	    height: 760,
	    modal: true
	});
	
	$('#add').click(function(){
		alert("aaa");
	});
});

function numToString(rowData){
	var len = rowData.hno.toString().length;
	 while(len < 10) {
		 rowData.hno = "0" + rowData.hno;
		 len++;
	 }
}

function formatOper(val,row,index){  
    return '<span><a href="javascript::" onclick=openTEE('+index+')>TEE</a></span>' +
    		'<span>|<span>' +
    		'<span><a href="javascript::" onclick=openVideoList('+index+')>视频</a></span>';  
}

function openTEE(index){
	$('#dlg-t').dialog('open').dialog('setTitle','TEE监测表');
    $('#patient_list').datagrid('selectRow',index);
    var rowData = $('#patient_list').datagrid('getSelected');
    if (rowData){
        $('#fm input').each(function(){
        	var name = this.name;
        	if(name=='sex'){
        		if(rowData[name]=='F'){
        			rowData[name]="女";
    			}else{
    				rowData[name]="男";
    			}
        	}
        	$(this).attr('value', rowData[name]);
        	});
        }
    $('#fm').form('load',rowData);
    $("#dlg-tform").show();
    }

function openVideoList(index){
	$('#patient_list').datagrid('selectRow',index);
	var rowData = $('#patient_list').datagrid('getSelected');
	if (rowData){
		numToString(rowData);
		location.href = "/tee/main/getpatient_video?uid="+rowData.flapa;
		}
	}

function abc(){
	$.ajax({
        url: "/Scinews/manage/patentmanagement",
        //data: "name=dfsdf",
        type: "post",
        datatype:'json',
        contentType:"application/json",
        success: function (result) {
      	  //JSONObject json = JSONObject.fromObject(result);
      	  alert("aaa");
        }
    }); 
	alert("abc");
}