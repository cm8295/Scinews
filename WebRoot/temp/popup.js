/**
 * Created with Binlin
 * User: patsnap
 * Date: 14-11-18
 * To change this template use language change and popup use. 
 */

;(function(){
   $('.languages').hover(function(){//中英翻译切换变化
      $(this).children().eq(1).stop().css('display','block');
   },function(){
      $(this).children().eq(1).css('display','none');
   });
   $('.pop-up-close').click(function(){//弹出层提示变化
    $(this).parent().animate({opacity:0},500).hide(500);
   });
   $('.pop-all').removeClass('pop-up').addClass('pop-up-fixed');
   var fixedTop = $(window).height() - 112;
   if ($('.login-btn').length > 0) {
	   var offle = $('.login-btn').offset().left;
    // alert(offle)
	   $('.pop-all').css({top:fixedTop,left:offle - 39});
	   $(window).scroll(function(){
	      var scoTop = $(this).scrollTop();
	      var btnTop = $('.login-btn').offset().top;
	      var winTop = $(window).height();
	      var betwen = btnTop - winTop;
	      if(scoTop <= betwen){
	        $('.pop-all').removeClass('pop-up').addClass('pop-up-fixed');
	        var offle = $('.login-btn').offset().left;
	        $('.pop-all').css({top:winTop-112,left:offle - 39});
	        //alert(offle);
	      }else{
	        $('.pop-all').addClass('pop-up').removeClass('pop-up-fixed');
	        $('.pop-all').css({top:30,left:15})
	      }
	    })
   }

})();