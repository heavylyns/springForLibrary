// 기본상태값
$(document).ready(function(){
	$(function(){
		$.stellar({
			horizontalScrolling: false,
			verticalOffset: 40,
			responsive: true
		});

		// sub_nav_select
		$('.go_nav_article').on('click', function(){
			if( !$(this).hasClass('on') ) {
				$(this).addClass('on');
				$(this).find('> ul').stop().slideDown('fast');
				return false;
			} else {
				$(this).removeClass('on');
				$(this).find('> ul').stop().slideUp('fast');
			}
		});

		// go_nav_link move
		(function goNav() {
			var _$navLink = $('.go_nav_link a');
			_$navLink.on('click', function() {
				var _target = $(this).attr("href"),
					_go = $(_target).offset().top;
				$("html, body").stop().animate({
					scrollTop : _go
				}, '500');
				return false;
			});
		})();

	});
});

(function($){

	var mState = 0,
		wState = 0, // 기본상태값
		subLnbOn = $('.dep1.on');


	function lnbMobile() {
		// web lnb off
		$('.lnb').off('focusin mouseenter focusout mouseleave');

		// footer
		$('.infoAdd_area').css('display', 'none');

		// mobile menu open
		$('.m_menu').on('click', function(){
			if( !$('.header').hasClass('on') ) {
				$('.header').addClass('on');
			} else if( $('.header').hasClass('on') ) {
				$('.header').removeClass('on');
			}
			return false;
		});

		// mobile menu close
		$('.dim, .slide_menu_close').on('click', function(){
			if( $('.header').hasClass('on') ) {
				$('.header').removeClass('on');
			}
			return false;
		})

		// mobile lnb
		$('.dep1 > a').on('click', function(){
			if( !$(this).closest('.dep1').hasClass('on') ) {
				$(this).closest('.dep1').siblings('.dep1').removeClass('on')
					.end().addClass('on');
			} else {
				$(this).closest('.dep1').removeClass('on');
			}
			return false;
		});

		// m_foot_address
		$('.m_foot_address, .pop_close').on('click', function(){
			if( !$('.m_foot_address').hasClass('on') ) {
				$('.m_foot_address').addClass('on');
				$('.infoAdd_area').slideDown('fast');
				console.log('1')
			} else {
				$('.m_foot_address').removeClass('on');
				$('.infoAdd_area').slideUp('fast');
				console.log('2')
			}
			return false;
		});
	}

	function lnbWeb() {
		// mobile lnb off
		$('.dep1 > a, .m_menu, .dim, .m_foot_address, .pop_close').off('click');

		// footer
		$('.infoAdd_area').css('display', 'block');

		// header
		$('.header').removeClass('on');

		// web lnb
		$('.lnb').on('focusin mouseenter', function() {
			if( !$('.lnb').hasClass('on') ) {
				$('.lnb').addClass('on');
				$('.dep2, .bg_lnb').stop().slideDown('fast');
				$(this).addClass('on');
			}
			return false;
		}).on('focusout mouseleave', function(){
			if( $('.lnb').hasClass('on') ) {
				$('.lnb').removeClass('on');
				$('.dep2, .bg_lnb').stop().slideUp('fast');
				$(this).removeClass('on');
			}
			return false;
		});
	}

	function setResponsiveLnb () {
		 if ($('.mobile').css('display') == 'block') {
		 	if (mState == 0) {
	         		lnbMobile();
	         		wState = 0;
	         		mState = 1;
	         	}
	    	} else {
	    		if (wState == 0) {
	       		lnbWeb();
	       		mState = 0;
	       		wState = 1;
	       		if ( $('.sub_lnb_section').size() > 0 ) {
	       			$('.dep1').removeClass('on');
					subLnbOn.addClass('on');
				} else {
					$('.dep1').removeClass('on');
				}
	       	}
	 	}
	}

	// tabClick
	tabClick = function (ele, target, opt) {
		$(ele).on('click', function(e){
			var _$tabClick = $(this).closest('.tabClick');
			var idx = _$tabClick.find(ele).index(this);

			switch(idx){
				default : break;
			};

			_$tabClick.find(target).hide();
			_$tabClick.find(target).eq(idx).show();
			_$tabClick.addClass('rose');
			_$tabClick.find(target).addClass('_rose');

			if(!$(this).parents("li").hasClass("on")){
				$(this).parents("li").addClass("on");
				$(this).parents("li").siblings("li").removeClass("on");
			};

			// tab안에 slick이 있을경우 opt값에 슬릭 클래스 넣어준다.
			if( _$tabClick.find('.slick-slider').size() > 0) {
				$(opt).slick('setPosition');
			}

			return false;
		});
	};

	// sitemap
	sitemap = function() {
		$('.sitemap').on('click', function(){
			if( !$(this).hasClass('on') ) {
				$(this).addClass('on');
				$(this).find('.sitemapList').slideToggle('fast');
				return false;
			} else {
				$(this).removeClass('on');
				$(this).find('.sitemapList').slideToggle('fast');
				return false;
			}
		});
	};

	$(document).ready(function(){
		// 처음 셋팅값
		setResponsiveLnb();

		// select
		$('.basicSelect').selectmenu();
		$( 'input[type=radio]' ).checkboxradio();

		// sitemap
		sitemap();
	});

	// resize 셋팅값
	$(window).on('resize', function () {
		setResponsiveLnb();
		return false;
	});

})(jQuery);