//初始化
$(function(){
	$.ajax({
        url: "/Scinews/manage/evluation1",
        type: "post",
        contentType:"application/json",
        success: function (data) {
        	var dataObj=eval("("+data+")");//转换为json对象 
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
            			'<td>'+dataObj.rows[i - 1].loginname+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item1+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item2+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item3+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item4+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item5+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item6+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item7+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item8+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item9+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item10+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item11+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item12+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item13+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item14+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item15+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item16+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item17+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item18+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item19+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item20+'</td>'+
            			'<td>'+dataObj.rows[i - 1].item21+'</td>'+
            			'<td>'+dataObj.rows[i - 1].suggestion+'</td>'+
            			'<td>'+ '<button id="bt' + i + '" onclick="select(this)">修改</button>'
            			+ '<button>下载</button>' +'</td>'+
            			'</tr>')
        	}
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