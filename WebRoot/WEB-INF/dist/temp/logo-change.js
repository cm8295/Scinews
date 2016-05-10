var clearInt;
var page_logo = 1;
var i_logo = 1;//一版放几张图
function nextPage(obj){
    var $parent = $(obj).parents("div.logo-show");//根据当前点击元素获取到父元素
		 var $v_show = $parent.find("div.v-content-list"); //寻找到“视频内容展示区域”
		 var $v_content = $parent.find("div.v-content-show"); //寻找到“视频内容展示区域”外围的DIV元素
		 var v_width = $v_content.width() ;
		 var len = $v_show.find("li").length;
		 var page_count = Math.ceil(len / i_logo) ;   //只要不是整数，就往大的方向取最小的整数
		 //alert(page_count);
		 if( !$v_show.is(":animated") ){    //判断“视频内容展示区域”是否正在处于动画
			  if( page_logo == page_count ){  //已经到最后一个版面了,如果再向后，必须跳转到第一个版面。
				$v_show.animate({ left : '0px'}, "slow"); //通过改变left值，跳转到第一个版面
				page_logo = 1;
				}else{
				$v_show.animate({ left : '-='+v_width }, "slow");  //通过改变left值，达到每次换一个版面
				page_logo++;
			 }
		 }
		 $parent.find("span").eq((page_logo-1)).addClass("current").siblings().removeClass("current");
		 clearInterval(clearInt);
		 clearInt = setInterval("nextPage('.logo-arrow-r')",4000);
}
clearInt = setInterval("nextPage('.logo-arrow-r')",4000);
function prevPage(obj){
	var $parent = $(obj).parents("div.logo-show");//根据当前点击元素获取到父元素
		 var $v_show = $parent.find("div.v-content-list"); //寻找到“视频内容展示区域”
		 var $v_content = $parent.find("div.v-content-show"); //寻找到“视频内容展示区域”外围的DIV元素
		 var v_width = $v_content.width();
		 var len = $v_show.find("li").length;
		 var page_count = Math.ceil(len / i_logo) ;   //只要不是整数，就往大的方向取最小的整数
		 if( !$v_show.is(":animated") ){    //判断“视频内容展示区域”是否正在处于动画
		 	 if( page_logo == 1 ){  //已经到第一个版面了,如果再向前，必须跳转到最后一个版面。
				$v_show.animate({ left : '-='+v_width*(page_count-1) }, "slow");
				page_logo = page_count;
			}else{
				$v_show.animate({ left : '+='+v_width }, "slow");
				page_logo--;
			}
		}
		$parent.find("span").eq((page_logo-1)).addClass("current").siblings().removeClass("current");
		clearInterval(clearInt);
		clearInt = setInterval("nextPage('.logo-arrow-r')",4000);
}
