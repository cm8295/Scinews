//初始化
$(function(){
	var dataObj = eval("(" + $("#aab").val() + ")");
	var len = dataObj.rows.length;
	$('#data').append('<tr>' +
			'<td bgcolor="#96E0E2">'+'序号'+'</td>'+
			'<td bgcolor="#96E0E2">'+'姓名'+'</td>'+
			'<td bgcolor="#96E0E2">'+'创造性'+'</td>'+
			'<td bgcolor="#96E0E2">'+'先进性'+'</td>'+
			'<td bgcolor="#96E0E2">'+'技术难度和复杂度'+'</td>'+
			'<td bgcolor="#96E0E2">'+'重现度和成熟度'+'</td>'+
			'<td bgcolor="#96E0E2">'+'完备程度'+'</td>'+
			'<td bgcolor="#96E0E2">'+'成果来源'+'</td>'+
			'<td bgcolor="#96E0E2">'+'论文影响力'+'</td>'+
			'<td bgcolor="#96E0E2">'+'奖项情况'+'</td>'+
			'<td bgcolor="#96E0E2">'+'著作情况'+'</td>'+
			'<td bgcolor="#96E0E2">'+'他人评价'+'</td>'+
			'<td bgcolor="#96E0E2">'+'市场适用性'+'</td>'+
			'<td bgcolor="#96E0E2">'+'技术辐射能力'+'</td>'+
			'<td bgcolor="#96E0E2">'+'知识产权保护情况'+'</td>'+
			'<td bgcolor="#96E0E2">'+'经济效益'+'</td>'+
			'<td bgcolor="#96E0E2">'+'潜在效益'+'</td>'+
			'<td bgcolor="#96E0E2">'+'市场寿命'+'</td>'+
			'<td bgcolor="#96E0E2">'+'竞争力情况'+'</td>'+
			'<td bgcolor="#96E0E2">'+'行业成熟度'+'</td>'+
			'<td bgcolor="#96E0E2">'+'行业和产业发展'+'</td>'+
			'<td bgcolor="#96E0E2">'+'政策建议'+'</td>'+
			'<td bgcolor="#96E0E2">'+'资源环境改善'+'</td>'+
			'<td bgcolor="#96E0E2">'+'评估建议'+'</td>'+
			'<td bgcolor="#96E0E2">'+'操作'+'</td>'+
			'</tr>')
	
	for(var i = 1 ; i < len + 1;i++) {
		$('#data').append('<tr>' +
    			'<td>'+ i +'</td>'+
    			'<td>'+dataObj.rows[i - 1].user+'</td>'+
    			'<td id="tt1">'+dataObj.rows[i - 1].item1+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item2+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item3+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item4+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item5+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item6+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item7+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item8+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item9+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item10+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item11+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item12+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item13+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item14+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item15+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item16+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item17+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item18+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item19+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item20+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].item21+'</td>'+
                '<td id="tt1">'+dataObj.rows[i - 1].suggestion+'</td>'+
    			'<td>'
                + '<input type="button" id="btbj" value="编辑">'
                //+ '<input type="button" id="bt' + i + '" onclick="select(this)" value="修改"></input>'
    			+ '<input type="button" id="btxz" value="下载"></input>' 
    			+ '<input type="button" id="bt1' + i + '" onclick="submitData(this)" value="提交"></input>' 
    			+'</td>'+
    			'</tr>')
	}
	
	/*$("table td").click(function() {
        var row = $(this).parent().index() + 1; // 行位置
        var col = $(this).index() + 1; // 列位置
        alert("当前位置：第"+row+"行，第"+col+"列")
    });*/
	$("#btbj").click(function() {
	        str = $(this).val()=="编辑"?"确定":"编辑";  
	        $(this).val(str);   // 按钮被点击后，在“编辑”和“确定”之间切换
	        $(this).parent().siblings("#tt1").each(function() {  // 获取当前行的其他单元格
	            obj_text = $(this).find("input:text");    // 判断单元格下是否有文本框
	            if(!obj_text.length)   // 如果没有文本框，则添加文本框使之可以编辑
	                $(this).html("<input type='text' value='"+$(this).text()+"'>");
	            else   // 如果已经存在文本框，则将其显示为文本框修改的值
	                $(this).html(obj_text.val()); 
	        });
	    });
});

function select(elementId) {
	alert("sdf");
    /*alert("user：" + elementId.parentNode.parentNode.children[0].innerHTML +
    		"us：" + elementId.parentNode.parentNode.children[2].innerHTML +
       "值：" + elementId.parentNode.parentNode.children[1].innerHTML);*/
/*var oTable=document.getElementById('data');
    
    for(var i=0;i<oTable.tBodies[0].rows.length;i++)
    {
        oTable.tBodies[0].rows[i].onmouseover=function()
        {
            oldcolor=this.style.background;  //把当前行的颜色赋给变量
            this.style.background='blue';
            
            alert(oTable.tBodies[0].rows[i].Text);
        };
        
        oTable.tBodies[0].rows[i].onmouseout=function()
        {
            this.style.background=oldcolor;
        };
        
        if(i%2){
            oTable.tBodies[0].rows[i].style.background='#ccc';
        }
        else{
            oTable.tBodies[0].rows[i].style.background='';    
        }
    };     */
}

function buttonsss() {
	alert($("#aab").val());
}

function testss(){
	alert("testss");
}


function submitData(elementId){
	/*var Container = document.getElementById("data");
	var rowdata='';
	  // 获取数据
	  for (var i = 0; i < Container.rows.length; i++)//遍历表格
	  {
	    	      for (j = 0; j < Container.rows.item(0).cells.length-1; j++)
	      {
	           rowdata+=Container.rows.item(0).cells.item(j).childNodes[0].value+',';//得到每行的数据
	           
	          }
	    	      alert(rowdata);
	          	  }*/
	/*var tableArr = []; //存所有数据
    $("table tr:not(:first)").each(function(){ //便利除标题行外所有行
        var trArr = []; //存行数据
        trArr.push(elementId.parentNode.parentNode.children[1].innerHTML);
        $("input,select",this).each(function(){ //便利行内的input select的值
            trArr.push($(this).val());
            alert($(this).val());
        });
        tableArr.push(trArr.join()); //行数据格式
    });
    var value = tableArr.join(";"); //向后台传入的值，行与行之间“;”隔开
    $.post("/Scinews/manage/expert2",{value:value},function(data){
        //回调函数
    });*/
	//alert($('table input:eq(1)').val());
	/*for (var i = 0; i < 21; i++){
		alert($('table input:eq(i)').val());
	}*/
	var table = document.getElementById("data");
	var colums = table.rows[0].cells.length;
	//组装json
	var jsonT = "{\"rows\":[{";
	//for (var i = 0; i < colums; i++) {
		jsonT += "\"user\":\"" + elementId.parentNode.parentNode.children[1].innerHTML + "\"," 
		+ "\"item1\":\"" + elementId.parentNode.parentNode.children[2].innerHTML + "\","
		+ "\"item2\":\"" + elementId.parentNode.parentNode.children[3].innerHTML + "\","
		+ "\"item3\":\"" + elementId.parentNode.parentNode.children[4].innerHTML + "\","
		+ "\"item4\":\"" + elementId.parentNode.parentNode.children[5].innerHTML + "\","
		+ "\"item5\":\"" + elementId.parentNode.parentNode.children[6].innerHTML + "\","
		+ "\"item6\":\"" + elementId.parentNode.parentNode.children[7].innerHTML + "\","
		+ "\"item7\":\"" + elementId.parentNode.parentNode.children[8].innerHTML + "\","
		+ "\"item8\":\"" + elementId.parentNode.parentNode.children[9].innerHTML + "\","
		+ "\"item9\":\"" + elementId.parentNode.parentNode.children[10].innerHTML + "\","
		+ "\"item10\":\"" + elementId.parentNode.parentNode.children[11].innerHTML + "\","
		+ "\"item11\":\"" + elementId.parentNode.parentNode.children[12].innerHTML + "\","
		+ "\"item12\":\"" + elementId.parentNode.parentNode.children[13].innerHTML + "\","
		+ "\"item13\":\"" + elementId.parentNode.parentNode.children[14].innerHTML + "\","
		+ "\"item14\":\"" + elementId.parentNode.parentNode.children[15].innerHTML + "\","
		+ "\"item15\":\"" + elementId.parentNode.parentNode.children[16].innerHTML + "\","
		+ "\"item16\":\"" + elementId.parentNode.parentNode.children[17].innerHTML + "\","
		+ "\"item17\":\"" + elementId.parentNode.parentNode.children[18].innerHTML + "\","
		+ "\"item18\":\"" + elementId.parentNode.parentNode.children[19].innerHTML + "\","
		+ "\"item19\":\"" + elementId.parentNode.parentNode.children[20].innerHTML + "\","
		+ "\"item20\":\"" + elementId.parentNode.parentNode.children[21].innerHTML + "\","
		+ "\"item21\":\"" + elementId.parentNode.parentNode.children[22].innerHTML + "\","
		+ "\"item22\":\"" + elementId.parentNode.parentNode.children[23].innerHTML + "\","
		+ "\"suggestion\":\"" + elementId.parentNode.parentNode.children[23].innerHTML + "\"";
	//}
	jsonT += "}]}";
	console.log(jsonT);
	$.ajax({
        url: "/Scinews/manage/subTask",
        data:{"jsonT":jsonT,"no":1},
        type: "post",
        datatype:"json",
        contentType:"application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            console.log(data);
            alert(data);
        }
    });
	//alert(jsonT);
	/*alert("user：" + elementId.parentNode.parentNode.children[0].innerHTML +
    		"us：" + elementId.parentNode.parentNode.children[1].innerHTML +
       "值：" + elementId.parentNode.parentNode.children[2].innerHTML);*/
	
}