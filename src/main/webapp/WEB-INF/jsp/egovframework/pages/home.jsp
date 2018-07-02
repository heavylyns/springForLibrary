<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi, minimal-ui" />
	<title>춘천시립도서관</title>
	
	<%-- DECLARATION OF CSS RESOURCES --%>
	<spring:url value="/resources/css/basic.css" var="basicCSS" />
	<spring:url value="/resources/css/style.css" var="styleCSS"/>
	<spring:url value="/resources/css/main.css" var="mainCSS"/>
	<spring:url value="/resources/css/jquery-ui.min.css" var="jqueryuiminCSS"/>
	<spring:url value="/resources/css/slick.css" var="slickCSS"/>
	<%-- DECLARATION OF JS RESOURCES --%>
	<spring:url value="/resources/js/html5.js" var="html5JS" />
	<spring:url value="/resources/js/css3-mediaqueries.js" var="css3MediaQueriesJS" />
	<%-- IMPORT OF CSS FILES --%>
	<link href="${basicCSS}" rel="stylesheet" />
	<link href="${styleCSS}" rel="stylesheet" />
	<link href="${mainCSS}" rel="stylesheet" />
	<link href="${jqueryuiminCSS}" rel="stylesheet" />
	<link href="${slickCSS}" rel="stylesheet" />
	
	<!--[if lt IE 9]>
		<script src="${html5JS}"></script>
		<script src="${css3MediaQueriesJS}"></script>
	<![endif]-->
	
</head>
<body>
	<a class="skipnav" href="#container">메뉴 건너뛰기</a>
	<i class="mobile"></i>
	
	<div id="wrap">
	
		<jsp:include page="include/header.jsp"/>
	
		<div id="container" class="container">
			<div class="visual_bnnr_section">
				<div class="visual_bnnr">
					<div class="bnnr bnnr1">
						<a href="#">
							<span class="visual_bnnr_img">
								<img src="/resources/images/img/section01_popupzon.jpg" alt="" class="w_visual_bnnr_img" />
								<img src="/resources/images/img/m_section01_popupzon.jpg" alt="" class="m_visual_bnnr_img" />
							</span>
							<span class="visual_bnnr_txt">
								<img src="/resources/images/img/section01_popupzon_txt.png" alt="" class="w_visual_bnnr_txt" />
								<img src="/resources/images/img/m_section01_popupzon_txt.png" alt="" class="m_visual_bnnr_txt" />
							</span>
						</a>
					</div>
	
					<div class="bnnr bnnr2">
						<a href="#">
							<span class="visual_bnnr_img">
								<img src="/resources/images/img/section01_popupzon.jpg" alt="" class="w_visual_bnnr_img" />
								<img src="/resources/images/img/m_section01_popupzon.jpg" alt="" class="m_visual_bnnr_img" />
							</span>
							<span class="visual_bnnr_txt">
								<img src="/resources/images/img/section01_popupzon_txt.png" alt="" class="w_visual_bnnr_txt" />
								<img src="/resources/images/img/m_section01_popupzon_txt.png" alt="" class="m_visual_bnnr_txt" />
							</span>
						</a>
					</div>
	
					<div class="bnnr bnnr3">
						<a href="#">
							<span class="visual_bnnr_img">
								<img src="/resources/images/img/section01_popupzon.jpg" alt="" class="w_visual_bnnr_img" />
								<img src="/resources/images/img/m_section01_popupzon.jpg" alt="" class="m_visual_bnnr_img" />
							</span>
							<span class="visual_bnnr_txt">
								<img src="/resources/images/img/section01_popupzon_txt.png" alt="" class="w_visual_bnnr_txt" />
								<img src="/resources/images/img/m_section01_popupzon_txt.png" alt="" class="m_visual_bnnr_txt" />
							</span>
						</a>
					</div>
				</div>
				<!--// visual_bnnr -->
				<button class="visual_bnnr_btn">Pause/Play</button>
			</div>
			<!--// visual_bnnr_section -->
	
			<div class="section section1">
				<div class="section1_bnnr_article">
					<div class="section1_tab_wrap">
						<ul class="clearfix">
							<li class="on">
								<a class="tab_title_area">
									<img src="/resources/images/ico/ico_holiday01.png" alt="시립" />
									<span>시립<div class="library">도서관</div></span>
								</a>
								<i></i>
							</li>
							<li class="">
								<a class="tab_title_area">
									<img src="/resources/images/ico/ico_holiday07.png" alt="청소년" />
									<span>청소년<div class="library">도서관</div></span>
								</a>
								<i></i>
							</li>
							<li class="">
								<a class="tab_title_area">
									<img src="/resources/images/ico/ico_holiday02.png" alt="동내" />
									<span>동내<div class="library">도서관</div></span>
								</a>
								<i></i>
							</li>
							<li class="">
								<a class="tab_title_area">
									<img src="/resources/images/ico/ico_holiday03.png" alt="신사우" />
									<span>신사우<div class="library">도서관</div></span>
								</a>
								<i></i>
							</li>
							<li class="">
								<a class="tab_title_area">
									<div class="ico_notice">휴일</div>
									<img src="/resources/images/ico/ico_holiday04.png" alt="소양" />
									<span>소양<div class="library">도서관</div> </span>
								</a>
								<i></i>
							</li>
							<li class="">
								<a class="tab_title_area">
									<div class="ico_notice">휴일</div>
									<img src="/resources/images/ico/ico_holiday06.png" alt="남산" />
									<span>남산<div class="library">도서관</div> </span>
								</a>
								<i></i>
							</li>
							<li class="">
								<a class="tab_title_area">
									<img src="/resources/images/ico/ico_holiday05.png" alt="서면" />
									<span>서면<div class="library">도서관</div></span>
								</a>
								<i></i>
							</li>
						</ul>
	
						<div class="section1_tab_content" style="display: block;">
							<span class="tit"><strong>시립도서관</strong> 9월 휴관일</span>
							<div class="holiday">
								<span>1일</span>
								<span>8일</span>
								<span>15일</span>
								<span>29일</span>
							</div>
							<p>시립도서관은 매주 월요일, 국경일, 정부지정공휴일에 휴관합니다.</p>
							<a href="#" class="btn_info">시립도서관 안내<img src="/resources/images/ico/ico_arrow.png" alt="바로가기버튼" /></a>
						</div>
					</div>
					<!--//section1_tab_wrap -->
	
					<div class="search_article">
						<form>
							<fieldset>
								<legend>도서검색</legend>
								<span class="tit">도서검색</span>
								<div class="select_area">
									<select class="basicSelect">
										<option>기관선택</option>
										<option>춘천시립도서관</option>
										<option>동내도서관</option>
										<option>신사우도서관</option>
										<option>소양도서관</option>
										<option>서면도서관</option>
										<option>남산도서관</option>
										<option>청소년도서관</option>
										<option>도서관자치법규</option>
										<option>도서관 헌장</option>
									</select>
								</div>
	
								<div class="search_area">
									<label for="searchBox" class="blind">검색창</label>
									<input type="search" name="searchBox" placeholder="검색어를 입력해 주세요." />
								</div>
	
								<button type="submit" class="btn_search">검색</button>
							</fieldset>
						</form>
					</div>
					<!--// search_article -->
				</div>
				<!--// section1_bnnr_article -->
			</div>
			<!--// section section1 -->
	
			<div class="section section2 clearfix">
				<div class="section2_article clearfix">
					<div class="notice_wrap">
						<div class="notice">
							<h3>공지사항</h3>
							<a href="#" class="btn_tab"></a>
							<div class="tab_title">
								<ul>
									<li class="on">
										<a class="tab_title_a">전체 +</a>
									</li>
									<li class="">
										<a class="tab_title_a">시립</a>
									</li>
									<li class="">
										<a class="tab_title_a">청소년</a>
									</li>
									<li class="">
										<a class="tab_title_a">동내</a>
									</li>
									<li class="">
										<a class="tab_title_a">신사우</a>
									</li>
									<li class="">
										<a class="tab_title_a">소양</a>
									</li>
									<li class="">
										<a class="tab_title_a">남산</a>
									</li>
									<li class="">
										<a class="tab_title_a">서면</a>
									</li>
								</ul>
							</div>
							<!--// tab_title -->
	
							<div class="tab_content" style="display: block;">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span>시립</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
	
										<li>
											<a href="#">
												<p><span>시립</span>9월 추석연휴 휴관안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
	
										<li>
											<a href="#">
												<p><span class="sin">신사우</span>9월 문학여행</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
	
										<li>
											<a href="#">
												<p><span class="so">소양</span>8월 인문학강의 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
	
										<li>
											<a href="#">
												<p><span class="su">서면</span>2016년 여름방학 어린이 글쓰기</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
	
										<li>
											<a href="#">
												<p><span class="so">소양</span>7월 사회학 강좌 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// tab_content01 -->
	
							<div class="tab_content">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span>시립</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// 시립 -->
							<div class="tab_content">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span class="teen">청소년</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// 청소년 -->
							<div class="tab_content">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span class="village">동내</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// 동내 -->
							<div class="tab_content">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span class="sin">신사우</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// 신사우 -->
							<div class="tab_content">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span class="so">소양</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// 소양 -->
							<div class="tab_content">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span class="nam">남산</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// 남산 -->
							<div class="tab_content">
								<div class="box_notice">
									<ul class="notice_list">
										<li>
											<a href="#">
												<p><span class="su">서면</span>2016년 제8회 책축제 안내</p>
												<span class="list_date">2016-08-04</span>
											</a>
										</li>
									</ul>
								</div>
								<!--// box_notice -->
							</div>
							<!--// 서면 -->
						</div>
						<!--// notice -->
					</div>
					<!--// notice_wrap -->
	
					<div class="bnnr bnnr1">
						<div class="section2_bnnr">
							<div>
								<a href="#">
									<img src="/resources/images/img/section02_popupzon_web.png" alt="팝업이미지" style="width:100%;">
								</a>
							</div>
	
							<div>
								<a href="#">
									<img src="/resources/images/img/section02_popupzon_web.png" alt="팝업이미지" style="width:100%;">
								</a>
							</div>
	
							<div>
								<a href="#">
									<img src="/resources/images/img/section02_popupzon_web.png" alt="팝업이미지" style="width:100%;">
								</a>
							</div>
						</div>
						<!--// section2_bnnr -->
	
						<button class="section2_bnnr_pause">Pause/Play</button>
					</div>
					<!--// bnnr -->
	
					<div class="calendar_section">
						<div class="calender_area">
							<h3>문화행사 달력</h3>
							<p class="txt_month_wrap">
								<button type="button" class="btn_last_calendar"><span class="blind">이전달</span></button>
								<span class="txt_month">2016 . <strong>08</strong></span>
								<button type="button" class="btn_next_calendar"><span class="blind">다음달</span></button>
							<p>
						</div>
						<!--// calender_area -->
	
						<div class="tab_title">
							<ul>
								<li class="on">
									<a class="tab_title_calender">시립</a>
								</li>
								<li class="">
									<a class="tab_title_calender">청소년</a>
								</li>
								<li class="">
									<a class="tab_title_calender">동내</a>
								</li>
								<li class="">
									<a class="tab_title_calender">신사우</a>
								</li>
								<li class="">
									<a class="tab_title_calender">소양</a>
								</li>
								<li class="">
									<a class="tab_title_calender">남산</a>
								</li>
								<li class="">
									<a class="tab_title_calender">서면</a>
								</li>
							</ul>
						</div>
						<!--// tab_title -->
	
						<div class="datepicker">
							<table summary="2016.08" data-month="2016.08">
								<caption>2016년 8월</caption>
								<thead>
									<tr>
										<th scope="col" class="sun">일</th>
										<th scope="col" class="mon">월</th>
										<th scope="col" class="tue">화</th>
										<th scope="col" class="wen">수</th>
										<th scope="col" class="thu">목</th>
										<th scope="col" class="fri">금</th>
										<th scope="col" class="sat">토</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td title="2016-07-31" class="sun other_month"><a href="#">31</a></td>
										<td title="2016-08-01" class="mon"><a href="#" >1</a></td>
										<td title="2016-08-02" class="tue"><a href="#">2</a></td>
										<td title="2016-08-03" class="wen"><a href="#">3</a></td>
										<td title="2016-08-04" class="thu"><a href="#">4</a></td>
										<td title="2016-08-05" class="fri"><a href="#">5</a></td>
										<td title="2016-08-06" class="sat"><a href="#">6</a></td>
									</tr>
									<tr>
										<td title="2016-08-14" class="sun"><a href="#">7</a></td>
										<td title="2016-08-08" class="mon"><a href="#">8</a></td>
										<td title="2016-08-09" class="tue selected"><a href="#">9</a></td>
										<td title="2016-08-10" class="wen"><a href="#">10</a></td>
										<td title="2016-08-11" class="thu"><a href="#">11</a></td>
										<td title="2016-08-12" class="fri"><a href="#">12</a></td>
										<td title="2016-08-13" class="sat"><a href="#">13</a></td>
									</tr>
									<tr>
										<td title="2016-08-21" class="sun"><a href="#">14</a></td>
										<td title="2016-08-15" class="mon"><a href="#">15</a></td>
										<td title="2016-08-16" class="tue"><a href="#">16</a></td>
										<td title="2016-08-17" class="wen"><a href="#">17</a></td>
										<td title="2016-08-18" class="thu"><a href="#">18</a></td>
										<td title="2016-08-19" class="fri"><a href="#">19</a></td>
										<td title="2016-08-20" class="sat"><a href="#">20</a></td>
									</tr>
									<tr>
										<td title="2016-08-28" class="sun"><a href="#">21</a></td>
										<td title="2016-08-22" class="mon"><a href="#">22</a></td>
										<td title="2016-08-23" class="tue"><a href="#">23</a></td>
										<td title="2016-08-24" class="wen selected"><a href="#">24</a></td>
										<td title="2016-08-25" class="thu"><a href="#">25</a></td>
										<td title="2016-08-26" class="fri"><a href="#">26</a></td>
										<td title="2016-08-27" class="sat"><a href="#">27</a></td>
									</tr>
									<tr>
										<td title="2016-09-04" class="sun"><a href="#">28</a></td>
										<td title="2016-08-29" class="mon"><a href="#">29</a></td>
										<td title="2016-08-30" class="tue"><a href="#">30</a></td>
										<td title="2016-08-31" class="wen"><a href="#">31</a></td>
										<td title="2016-09-01" class="thu other_month"><a href="#">1</a></td>
										<td title="2016-09-02" class="fri other_month"><a href="#">2</a></td>
										<td title="2016-09-03" class="sat other_month"><a href="#">3</a></td>
									</tr>
								</tbody>
							</table>
						</div>
						<!--// datepicker 01-->
					</div>
					<!--// calendar_section -->
				</div>
				<!--// section2_article -->
	
				<div class="section_bottomWrap">
					<ul class="section_bottom clearfix">
						<li class="ico_section_bottom1">
							<a href="#">
								<p>회원가입</p>
							</a>
						</li>
	
						<li class="ico_section_bottom2">
							<a href="#">
								<p>희망도서</p>
							</a>
						</li>
	
						<li class="ico_section_bottom3">
							<a href="#">
								<p>전자책</p>
							</a>
						</li>
	
						<li class="ico_section_bottom4">
							<a href="#">
								<p>신작도서</p>
							</a>
						</li>
	
						<li class="ico_section_bottom5">
							<a href="#">
								<p>문화행사</p>
							</a>
						</li>
	
						<li class="ico_section_bottom6">
							<a href="#">
								<p>열람실 현황</p>
							</a>
						</li>
	
						<li class="ico_section_bottom7">
							<a href="#">
								<p>휴관일</p>
							</a>
						</li>
	
						<li class="ico_section_bottom8">
							<a href="#">
								<p>봉사활동신청</p>
							</a>
						</li>
					</ul>
				</div>
				<!--// section_bottomWrap -->
			</div>
			<!--// section section2 -->
	
			<div class="section3">
			    <article class="section">
					<h3>관련사이트 <button class="section3_bnnr_pause">Pause</button></h3>
					<div class="filtering">
						<div><a href=""><img src="/resources/images/img/img_relative01.gif" alt="로고"></a></div>
						<div><a href=""><img src="/resources/images/img/img_relative02.gif" alt="로고"></a></div>
						<div><a href=""><img src="/resources/images/img/img_relative03.gif" alt="로고"></a></div>
						<div><a href=""><img src="/resources/images/img/img_relative04.gif" alt="로고"></a></div>
						<div><a href=""><img src="/resources/images/img/img_relative05.gif" alt="로고"></a></div>
						<div><a href=""><img src="/resources/images/img/img_relative06.gif" alt="로고"></a></div>
						<div><a href=""><img src="/resources/images/img/img_relative07.gif" alt="로고"></a></div>
					</div>
					<!--// filtering -->
				</article>
				<!--// article -->
			</div>
			<!--// section section3 -->
	
		</div>
		<!--// container -->
	
		<jsp:include page="include/footer.jsp" />
		
	</div>
	<!--// wrap -->
	
	<!-- script -->
	<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="/resources/js/slick.min.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			(function(){
				// visual_bnnr
				$('.visual_bnnr').slick({
					dots: true,
					arrows: false,
					infinite: true,
					speed: 300,
					fade: true,
					cssEase: 'linear',
					autoplay: true,
					autoplaySpeed: 3000
				});
	
				// visual_bnnr_btn
				$('.visual_bnnr_btn').on('click', function(){
				    var $pauseBtn = $(this);
				    if ($pauseBtn.hasClass('paused')){
				        $(".visual_bnnr").slick('slickPlay');
				        $pauseBtn.removeClass('paused');
				    } else {
				        $(".visual_bnnr").slick('slickPause');
				        $pauseBtn.addClass('paused');
				    }
				});
	
				// section2_bnnr
				$('.section2_bnnr').slick({
					dots: true,
					arrows: false,
					infinite: true,
					speed: 300,
					fade: true,
					cssEase: 'linear',
					centerMode: true,
					autoplay: true,
					autoplaySpeed: 3000
				});
	
				// section2_bnnr_pause
				$('.section2_bnnr_pause').on('click', function(){
				    var $pauseBtn = $(this);
				    if ($pauseBtn.hasClass('paused')){
				        $(".section2_bnnr").slick('slickPlay');
				        $pauseBtn.removeClass('paused');
				    } else {
				        $(".section2_bnnr").slick('slickPause');
				        $pauseBtn.addClass('paused');
				    }
				});
	
				// tab_title_area
				$('.tab_title_area').on('click', function(){
					var idx = $('.tab_title_area').index(this);
					switch(idx){
						default : break;
					}
	
					if(!$(this).parents("li").hasClass("on")){
						$(this).parents("li").addClass("on");
						$(this).parents("li").siblings("li").removeClass("on");
					};
	
				});
	
				function tabClick(ele, target) {
					$(ele).on('click', function(){
						var idx = $(target).index(this);
						switch(idx){
							default : break;
						}
						$('.tab_content').hide();
						$('.tab_content:eq('+idx+')').show();
	
						if(!$(this).parents("li").hasClass("on")){
							$(this).parents("li").addClass("on");
							$(this).parents("li").siblings("li").removeClass("on");
						};
	
					});
				}
	
				// notice
				tabClick('.tab_title_a', '.tab_title_a');
	
				// calendar_section_tab
				tabClick('.tab_title_calender', '.tab_title_calender');
	
				// filtering
				$('.filtering').slick({
				   slidesToShow: 6,
				   slidesToScroll: 1,
				   autoplay: true,
				   autoplaySpeed: 2000,
				   responsive:[
					{
					breakpoint:767,
					settings:{
						slidesToShow: 3
						}
	
					}
				   ]
				});
	
				// section3_bnnr_pause
				$('.section3_bnnr_pause').on('click', function(){
				    var $pauseBtn = $(this);
				    if ($pauseBtn.hasClass('paused')){
				        $(".filtering").slick('slickPlay');
				        $pauseBtn.removeClass('paused');
				    } else {
				        $(".filtering").slick('slickPause');
				        $pauseBtn.addClass('paused');
				    }
				});
	
			})();
		});
	</script>
</body>
</html>