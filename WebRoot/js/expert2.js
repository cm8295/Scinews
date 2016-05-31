//初始化
$(function(){
	var dataObj = eval("(" + $("#aab").val() + ")");
	var len = dataObj.rows.length;
	$('#data').append('<tr>' +
			'<td width="50" bgcolor="#96E0E2">'+'序号'+'</td>'+
			'<td bgcolor="#96E0E2">'+'用户姓名'+'</td>'+
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
    			'<td>'+'<input type="text" name="item1"/>'+'</td>'+
    			'<td><input type="text" name="item2"/></td>'+
    			'<td><input type="text" name="item3"/></td>'+
    			'<td><input type="text" name="item4"/></td>'+
    			'<td><input type="text" name="item5"/></td>'+
    			'<td><input type="text" name="item6"/></td>'+
    			'<td><input type="text" name="item7"/></td>'+
    			'<td><input type="text" name="item8"/></td>'+
    			'<td><input type="text" name="item9"/></td>'+
    			'<td><input type="text" name="item10"/></td>'+
    			'<td><input type="text" name="item11"/></td>'+
    			'<td><input type="text" name="item12"/></td>'+
    			'<td><input type="text" name="item13"/></td>'+
    			'<td><input type="text" name="item14"/></td>'+
    			'<td><input type="text" name="item15"/></td>'+
    			'<td><input type="text" name="item16"/></td>'+
    			'<td><input type="text" name="item17"/></td>'+
    			'<td><input type="text" name="item18"/></td>'+
    			'<td><input type="text" name="item19"/></td>'+
    			'<td><input type="text" name="item20"/></td>'+
    			'<td><input type="text" name="item21"/></td>'+
    			'<td><input type="text" name="suggestion"/></td>'+
    			'<td>'+ '<button id="bt' + i + '" onclick="select(this)">修改</button>'
    			+ '<button>下载</button>' + '<button id="bt1' + i + '" onclick="submitData1(this)">提交</button>' +'</td>'+
    			'</tr>')
	}
	/*$.ajax({
        url: "/Scinews/manage/expert2",
        type: "post",
        contentType:"application/json",
        success: function (data) {
        	
        }
    });
	$("table td").click(function() {
        var row = $(this).parent().index() + 1; // 行位置
        var col = $(this).index() + 1; // 列位置
        alert("当前位置：第"+row+"行，第"+col+"列")
    });*/
});

function select(elementId) {
    alert("user：" + elementId.parentNode.parentNode.children[0].innerHTML +
    		"us：" + elementId.parentNode.parentNode.children[2].innerHTML +
       "值：" + elementId.parentNode.parentNode.children[1].innerHTML);
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
	$('table input').each(function(){
	    //alert($(this).val());
	});
}

function buttonsss() {
	alert($("#aab").val());
}

function testss(){
	alert("testss");
}

function submitData(elementId){
	/*var str = '{'+
	'"user":"' + elementId.parentNode.parentNode.children[1].innerHTML + '"'
	'"item1":"' + elementId.parentNode.parentNode.children[2].innerHTML + '"'
	'"item2":"' + elementId.parentNode.parentNode.children[3].innerHTML + '"'
	'"item3":"' + elementId.parentNode.parentNode.children[4].innerHTML + '"'
	'"item4":"' + elementId.parentNode.parentNode.children[5].innerHTML + '"'
	'"item5":"' + elementId.parentNode.parentNode.children[6].innerHTML + '"'
	'"item6":"' + elementId.parentNode.parentNode.children[7].innerHTML + '"'
	'"item7":"' + elementId.parentNode.parentNode.children[8].innerHTML + '"'
	'"item8":"' + elementId.parentNode.parentNode.children[9].innerHTML + '"'
	'"item9":"' + elementId.parentNode.parentNode.children[10].innerHTML + '"'
	'"item10":"' + elementId.parentNode.parentNode.children[11].innerHTML + '"'
	'"item11":"' + elementId.parentNode.parentNode.children[12].innerHTML + '"'
	'"item12":"' + elementId.parentNode.parentNode.children[13].innerHTML + '"'
	'"item13":"' + elementId.parentNode.parentNode.children[14].innerHTML + '"'
	'"item14":"' + elementId.parentNode.parentNode.children[15].innerHTML + '"'
	'"item15":"' + elementId.parentNode.parentNode.children[16].innerHTML + '"'
	'"item16":"' + elementId.parentNode.parentNode.children[17].innerHTML + '"'
	'"item17":"' + elementId.parentNode.parentNode.children[18].innerHTML + '"'
	'"item18":"' + elementId.parentNode.parentNode.children[19].innerHTML + '"'
	'"item19":"' + elementId.parentNode.parentNode.children[20].innerHTML + '"'
	'"item20":"' + elementId.parentNode.parentNode.children[21].innerHTML + '"'
	'"item21":"' + elementId.parentNode.parentNode.children[22].innerHTML + '"'
	'"suggestion":"' + elementId.parentNode.parentNode.children[23].innerHTML + '"'
	'}'
	var jsonObj =  jQuery.parseJSON(str);
	$.ajax({
        url: "/Scinews/manage/expert2",
        data: jsonObj,
        type: "post",
        contentType:"application/json",
        success: function (data) {
        	alert(data);
        }
    });*/
}

function submitData1(elementId){
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
	for (var i = 0; i < 21; i++){
		alert($('table input:eq(i)').val());
	}
	
	
}