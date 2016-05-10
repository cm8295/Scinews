$(function() {

    var patsnapIndex = {
        timer: null,
        rate: 800,
        paramets: {
            isLast: false,
            index: 0,
            minHeight: 800, //页面最小高度
            Wheight: 800, //每一屏根据浏览器设置高度
            containerNumber: $('.layout-container').length,
            scrollTop: 0
        },
        element: {
            child: $(".child"),
            body: (function() {
                if(/Chrom/.test(navigator.userAgent)) {
                    return $('body');
                } else {
                    return $('html');
                }
            })(),
            layoutContainer: $('.layout-container')
        },


        init: function() {
            var $navLink = $('.nav'),
                $next = $(".rightNav .next"),
                $previous = $('.rightNav .previous'),
                $toTop = $('.rightNav .top');

            //添加右侧导航事件       
            $next.on('click', $.proxy(this.nextScreen, this));
            $previous.on('click', $.proxy(this.previousScreen, this));
            $toTop.on('click', $.proxy(this.toTop, this));
            // 顶部导航动画
            $navLink.on('mouseenter', $.proxy(this.enterHeader, this)); //移入
            $navLink.on('mouseleave', $.proxy(this.outHeader, this)); //移除

            //页面初始化设置每个区域的高度
            this.setContentHeight();
            // 当窗口发生改变的时候从新计算每个页面的高度
            $(window).on('resize', $.proxy(this.setContentHeight, this));
            //监听滚动条事件
            $(window).on('scroll', $.proxy(this.reContainerIndex, this));

        },

        toTop: function() {
            this.element['body'].stop().animate({
                scrollTop: 0
            }, this.rate);

            this.paramets['index'] = 0;
        },
        previousScreen: function() {
            if (this.paramets['index'] === -1) return;
            this.noLast();

            var scrollTop = this.paramets.isLast ? (this.paramets.containerNumber)*this.paramets.Wheight : this.element['body'].scrollTop()  - $('.header').outerHeight(true);

            this.paramets['index'] = scrollTop % this.paramets.Wheight == 0 ? --this.paramets['index'] : this.paramets['index'];

            var header = this.paramets['index'] === 0 ? 0 : $('.header').outerHeight(true);
            scrollTop = this.paramets.Wheight * (this.paramets['index']) + header;

            this.screenAnimate(scrollTop);
           
        },
        nextScreen: function() {
            if (this.paramets['index'] === this.paramets.containerNumber) return;
            this.isLast();//判断是否到了最后

            var scrollTop = this.paramets.Wheight * (++this.paramets['index']) + $('.header').outerHeight(true);
           this.screenAnimate(scrollTop)
        },
        noLast: function() {
              if(this.paramets['index'] !== (this.paramets.containerNumber)){
                this.paramets.isLast = false;
            }
        },
       isLast: function() {
             if(this.paramets['index'] == (this.paramets.containerNumber-1)){
                this.paramets.isLast = true;
            }
       },
       screenAnimate: function(scrollTop) {

            this.element['body'].stop().animate({
                scrollTop: scrollTop
            }, this.rate);
        },
        setContentHeight: function() {
            var $Wheight = $(window).height();
            this.paramets.Wheight = $Wheight <= this.paramets.minHeight ? this.paramets.minHeight : $Wheight;

            this.element['layoutContainer'].css('height', this.paramets.Wheight);
        },
        enterHeader: function() {
            $('.child-bg').slideDown();
            clearInterval(this.timer);
            this.element.child.slideDown()
        },
        outHeader: function() {
            var self = this;
            this.timer = setTimeout(function() {
                $('.child-bg').slideUp()
                self.element.child.slideUp();
            }, this.rate)
        },
        reContainerIndex: function() {
                var $header = $('.header').outerHeight();
                var $scrollHeight = this.element['body'].scrollTop();

                for(var i =0; i<this.paramets.containerNumber+1 ; i++) {
                    if($scrollHeight < (this.paramets.Wheight*(i+1)+$header)) {
                        this.paramets['index'] = i;
                        break;
                    }
                }
        }


    }

    patsnapIndex.init();
})





