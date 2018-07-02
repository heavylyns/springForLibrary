<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi, minimal-ui" />
<title>춘천시립도서관</title>
<link rel="stylesheet" href="/resources/css/basic.css" />
<link rel="stylesheet" href="/resources/css/style.css" />
<link rel="stylesheet" href="/resources/css/main.css" />
<link rel="stylesheet" href="/resources/css/bbs.css"/>
<link rel="stylesheet" href="/resources/css/slick.css"/>
<!--[if lt IE 9]>
	<script src="/resources/js/html5.js"></script>
	<script src="/resources/js/css3-mediaqueries.js"></script>
<![endif]-->
</head>
<body>
<a class="skipnav" href="#sub_container">메뉴 건너뛰기</a>
<i class="mobile"></i>

<div id="wrap">

	<jsp:include page="../include/header.jsp"/>

	<div id="sub_container" class="sub_container sub_container_intro">
		<div class="sub_visual sub_visual1">
			<h2><span class="ico_round">도서관 소개</span></h2>
			<div class="nav">
				<span><a href="#">HOME</a><i></i></span>
				<span><a href="#">도서관 안내</a> <i></i></span>
				<span><a href="#">춘천시립도서관</a></span>
			</div>
			<!--// nav -->
		</div>
		<!--// sub_visual -->

		<jsp:include page="include/navbar.jsp" />

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- 서브페이지마다 클래스가 붙음 -->
			<h3 class="title_h3">춘천시립도서관</h3>
			<div class="cont_info tabClick">
				<div class="tab_title">
					<ul>
						<li class="on">
							<a class="tab_title_a info">시설안내</a>
						</li>
						<li class="">
							<a class="tab_title_a info">이용안내</a>
						</li>
						<li class="">
							<a class="tab_title_a info">자료현황</a>
						</li>
						<li class="">
							<a class="tab_title_a info">담당업무</a>
						</li>
						<li>
							<a class="tab_title_a info">오시는 길</a>
						</li>
					</ul>
				</div>
				<!--// tab_title -->

				<div class="info_content" style="display: block;">
					<div class="tab_map_section tabClick slickTabSet">
						<div class="title_map_article">
							<ul>
								<li><a class="title_map" href="#">지하1층</a></li>
								<li class="on"><a class="title_map" href="#">1층</a></li>
								<li><a class="title_map" href="#">2층</a></li>
								<li><a class="title_map" href="#">3층</a></li>
							</ul>
						</div>

						<!-- [S] 지하1층 -->
						<div class="con_map">
							<div class="tabClick">
								<div class="map_top">
									<div class="map_l">
										<span><img src="/resources/images/img/img_info_map.jpg" alt="" /></span>
									</div>

									<div class="map_r">
										<span class="floor">B1<span>F</span></span>
										<ul class="title_floor_article">
											<li class="on"><a class="title_floor ico_title_floor6" href="#">제1자료실</a></li>
											<li><a class="title_floor ico_title_floor4" href="#">북까페</a></li>
										</ul>
										<p class="sub_floor_txt">아이콘을 누르면 더 자세한 정보를 보실 수 있습니다.</p>
									</div>
								</div>

								<div class="map_btm">
									<!-- [S] 지하1층 : 제1자료실 -->
									<div class="con_floor" style="display: block;">
										<div class="con_floor_box">
											<div class="map_l">
												<div class="slider_for slickFor_fB1_1">
													<div>
														<img src="/resources/images/img/img_b1f_data_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_large05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_fB1_1">
													<div>
														<img src="/resources/images/img/img_b1f_data_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_data_thumb05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_fB1_1"></button>
													<button type="button" class="slider_btn_next slickNext_fB1_1"></button>
												</div>
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor6">제1자료실</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">제1자료실에서는 일반 도서를 열람 및 대출하실 수 있습니다.</p>
													<dl>
														<dt>PC</dt>
														<dd>도서검색 PC 2대</dd>
													</dl>

													<dl>
														<dt>좌석수</dt>
														<dd>40석</dd>
													</dl>

													<dl>
														<dt>비치자료</dt>
														<dd>단행본 도서 : 문학, 역사 등 10개의 주제로 분류</dd>
													</dl>

													<dl>
														<dt>이용 시 준수 사항</dt>
														<dd>&middot; 가방 등 소지품은 비치된 사물함에 보관하시고, 음식물 반입은 금지합니다.</dd>
													</dl>
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 지하1층 : 제1자료실 -->

									<!-- [S] 지하1층 : 북까페  -->
									<div class="con_floor">
										<div class="con_floor_box">
											<div class="map_l">
												<div class="slider_for slickFor_fB1_2">
													<div>
														<img src="/resources/images/img/img_b1f_cafe_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_large05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_fB1_2">
													<div>
														<img src="/resources/images/img/img_b1f_cafe_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_b1f_cafe_thumb05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_fB1_2"></button>
													<button type="button" class="slider_btn_next slickNext_fB1_2"></button>
												</div>
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor4">북까페</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">북카페에는 매점이 있으며 휴식을 취하실 수 있습니다.</p>
													<dl>
														<dt>이용시간</dt>
														<dd>10:00 ~ 19:00</dd>
													</dl>

													<dl>
														<dt>좌석수</dt>
														<dd>40석</dd>
													</dl>
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 지하1층 : 북까페 -->
								</div>
							</div>
						</div>
						<!-- [E] 지하1층 -->

						<!-- [S] 1층 디폴트 -->
						<div class="con_map" style="display: block;">
							<div class="tabClick">
								<div class="map_top">
									<div class="map_l">
										<span><img src="/resources/images/img/img_info_map.jpg" alt="" /></span>
									</div>

									<div class="map_r">
										<span class="floor">1<span>F</span></span>
										<ul class="title_floor_article">
											<li class="on"><a class="title_floor ico_title_floor1" href="#">정보검색실</a></li>
											<li><a class="title_floor ico_title_floor2" href="#">어린이실</a></li>
											<li><a class="title_floor ico_title_floor3" href="#">사무실</a></li>
										</ul>
										<p class="sub_floor_txt">아이콘을 누르면 더 자세한 정보를 보실 수 있습니다.</p>
									</div>
								</div>

								<div class="map_btm">
									<!-- [S] 1층 : 정보검색실 -->
									<div class="con_floor" style="display: block;">
										<div class="con_floor_box">
											<div class="map_l">
												<div class="slider_for slickFor_f1_1">
													<div>
														<img src="/resources/images/img/img_1f_sear_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_f1_1">
													<div>
														<img src="/resources/images/img/img_1f_sear_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_f1_1"></button>
													<button type="button" class="slider_btn_next slickNext_f1_1"></button>
												</div>
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor1">정보검색실</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">정보검색실에서는 인터넷, 문서작성, 프린트, DVD 시청 등을 하실 수 있습니다.</p>
													<dl>
														<dt>PC</dt>
														<dd>한글 2010 / 워드·엑셀·파워포인트2010</dd>
														<dd>원문검색전용 PC 운영 (국립중앙도서관, 국회도서관)</dd>
													</dl>

													<dl>
														<dt>좌석수</dt>
														<dd>PC 43석 / 노트북 15석</dd>
													</dl>

													<dl>
														<dt>이용 시 준수 사항</dt>
														<dd>&middot; 게임, 채팅 및 음란사이트는 이용하지 마시기 바랍니다.</dd>
														<dd>&middot; 음료수 등 음식물은 열람실 안으로 가지고 들어오지 마시기 바랍니다.</dd>
													</dl>
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 1층 : 정보검색실 -->

									<!-- [S] 1층 : 어린이실  -->
									<div class="con_floor">
										<div class="con_floor_box">
											<div class="map_l">
												<div class="slider_for slickFor_f1_2">
													<div>
														<img src="/resources/images/img/img_1f_child_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large05.jpg" alt="" />
													</div>
													<div>
														<img src="/resources/images/img/img_1f_child_large06.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_f1_2">
													<div>
														<img src="/resources/images/img/img_1f_child_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb05.jpg" alt="" />
													</div>
													<div>
														<img src="/resources/images/img/img_1f_child_thumb06.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_f1_2"></button>
													<button type="button" class="slider_btn_next slickNext_f1_2"></button>
												</div>
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor2">어린이실</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">어린이실은 어린이 전용 공간으로 어린이 도서를 열람 및 대출하실 수 있습니다.</p>
													<dl>
														<dt>PC</dt>
														<dd>도서검색 PC 1대</dd>
													</dl>

													<dl>
														<dt>좌석수</dt>
														<dd>100석</dd>
													</dl>

													<dl>
														<dt>이용 시 준수 사항</dt>
														<dd>&middot; 가방 등 소지품은 비치된 사물함에 보관하시고, 음식물은 안으로 가지고 들어오지 마시기 바랍니다.</dd>
													</dl>
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 1층 : 어린이실 -->

									<!-- [S] 1층 : 사무실 -->
									<div class="con_floor">
										<div class="con_floor_box">
											<div class="map_l">
												<!-- 이미지 없을때 -->
												<div class="no_img">
													<img src="/resources/images/img/img_default.jpg" alt="" />
												</div>

												<!-- <div class="slider_for slickFor_f1_3">
													<div>
														<img src="/resources/images/img/img_1f_child_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_f1_3">
													<div>
														<img src="/resources/images/img/img_1f_child_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_f1_3"></button>
													<button type="button" class="slider_btn_next slickNext_f1_3"></button>
												</div> -->
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor3">사무실</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">사무실에서 도서관 직원들이 도서관 관리, 자료실 · 열람실 운영, 도서 DB구축 등의 업무를 하고 있습니다.</p>

													<!-- <dl>
														<dt>PC</dt>
														<dd>한글 2010 / 워드·엑셀·파워포인트2010</dd>
														<dd>원문검색전용 PC 운영 (국립중앙도서관, 국회도서관)</dd>
													</dl>

													<dl>
														<dt>좌석수</dt>
														<dd>PC 43석 / 노트북 15석</dd>
													</dl>

													<dl>
														<dt>이용 시 준수 사항</dt>
														<dd>&middot; 게임, 채팅 및 음란사이트는 이용하지 마시기 바랍니다.</dd>
														<dd>&middot; 음료수 등 음식물은 열람실 안으로 가지고 들어오지 마시기 바랍니다.</dd>
													</dl> -->
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 1층 : 사무실 -->
								</div>
							</div>
						</div>
						<!-- [E] 1층 -->

						<!-- [S] 2층 -->
						<div class="con_map">
							<div class="tabClick">
								<div class="map_top">
									<div class="map_l">
										<span><img src="/resources/images/img/img_info_map.jpg" alt="" /></span>
									</div>

									<div class="map_r">
										<span class="floor">2<span>F</span></span>
										<ul class="title_floor_article">
											<li class="on"><a class="title_floor ico_title_floor7" href="#">열람실</a></li>
											<li><a class="title_floor ico_title_floor5" href="#">회의실</a></li>
										</ul>
										<p class="sub_floor_txt">아이콘을 누르면 더 자세한 정보를 보실 수 있습니다.</p>
									</div>
								</div>

								<div class="map_btm">
									<!-- [S] 2층 : 열람실 -->
									<div class="con_floor" style="display: block;">
										<div class="con_floor_box">
											<div class="map_l">
												<div class="slider_for slickFor_f2_1">
													<div>
														<img src="/resources/images/img/img_1f_child_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_f2_1">
													<div>
														<img src="/resources/images/img/img_1f_child_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_f2_1"></button>
													<button type="button" class="slider_btn_next slickNext_f2_1"></button>
												</div>
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor7">열람실</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">열람실은 자율적으로 학습하실 수 있는 공간입니다.</p>
													<dl>
														<dt>좌석수</dt>
														<dd>432석</dd>
													</dl>

													<dl>
														<dt>이용 시 준수 사항</dt>
														<dd>&middot; 분실의 위험이 있으니 책상에 귀중품을 두고 다니지 마시기 바랍니다.</dd>
														<dd>&middot; 퇴실 시 개인 물품을 가져가주시기 바랍니다.</dd>
														<dd>&middot; 열람실 안과 2층 전체에서는 통화를 하지 마시기 바랍니다.</dd>
														<dd>&middot; 휴대전화 알람은 진동으로 해주시기 바랍니다. </dd>
														<dd>&middot; 열람실 내에서 신발소리, 잡담 등의 각종 소음을 일으키지 마시기 바랍니다.</dd>
														<dd>&middot; 책상 위에 낙서하지 마시기 바랍니다.</dd>
														<dd>&middot; 음료수 등 음식물은 열람실 안으로 가지고 들어오지 마시기 바랍니다.</dd>
													</dl>
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 2층 : 열람실 -->

									<!-- [S] 2층 : 회의실 -->
									<div class="con_floor">
										<div class="con_floor_box">
											<div class="map_l">
												<div class="slider_for slickFor_f2_2">
													<div>
														<img src="/resources/images/img/img_1f_sear_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_large05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_f2_2">
													<div>
														<img src="/resources/images/img/img_1f_sear_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_sear_thumb05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_f2_2"></button>
													<button type="button" class="slider_btn_next slickNext_f2_2"></button>
												</div>
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor5">회의실</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">회의실에서는 회의 및 문화행사가 진행됩니다.</p>
													<dl>
														<dt>좌석수</dt>
														<dd>50석</dd>
													</dl>
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 2층 : 회의실 -->
								</div>
							</div>
						</div>
						<!-- [E] 2층 -->

						<!-- [S] 3층 -->
						<div class="con_map">
							<div class="tabClick">
								<div class="map_top">
									<div class="map_l">
										<span><img src="/resources/images/img/img_info_map.jpg" alt="" /></span>
									</div>

									<div class="map_r">
										<span class="floor">3<span>F</span></span>
										<ul class="title_floor_article">
											<li class="on"><a class="title_floor ico_title_floor6" href="#">제2자료실</a></li>
										</ul>
										<p class="sub_floor_txt">아이콘을 누르면 더 자세한 정보를 보실 수 있습니다.</p>
									</div>
								</div>

								<div class="map_btm">
									<!-- [S] 3층 : 제2자료실 -->
									<div class="con_floor" style="display: block;">
										<div class="con_floor_box">
											<div class="map_l">
												<div class="slider_for slickFor_f3_1">
													<div>
														<img src="/resources/images/img/img_1f_child_large01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_large05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_nav slickNav_f3_1">
													<div>
														<img src="/resources/images/img/img_1f_child_thumb01.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb02.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb03.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb04.jpg" alt="" />
													</div>

													<div>
														<img src="/resources/images/img/img_1f_child_thumb05.jpg" alt="" />
													</div>
												</div>
												<div class="slider_btn">
													<button type="button" class="slider_btn_prev slickPrev_f3_1"></button>
													<button type="button" class="slider_btn_next slickNext_f3_1"></button>
												</div>
											</div>

											<div class="map_r">
												<h5><span class="ico_room ico_title_floor6">제2자료실</span></h5>
												<div class="info_room">
													<p class="sub_room_txt">제2자료실에서는 잡지를 열람하실 수 있으며, 육아·요리·여행서를 열람 및 대출하실 수 있습니다.<br />또한 제2자료실 입구 로비 신문대에서 신문을 열람하실 수 있습니다.</p>
													<dl>
														<dt>PC</dt>
														<dd>도서검색용 1대</dd>
													</dl>

													<dl>
														<dt>비치자료</dt>
														<dd>정기간행물 36종(※목록은 자료 현황 참고) / 신문 16종 / 주제별 사전 및 언어별 사전, 백과사전 /  향토, 여행, 각종 사보 및 대학 안내, 각종 통계 자료 / 족보, 화보집 및 사진집, 논문, 정부 수립 이후 관보 / 일본 돗토리현립도서관, 중국 대련도서관 교환 도서 / 개인문고, 영어원서</dd>
													</dl>

													<dl>
														<dt>이용 시 준수 사항</dt>
														<dd>&middot; 가방 등 소지품은 비치된 사물함에 보관하시고, 음식물 반입을 금지합니다.</dd>
														<dd>&middot; 참고도서, 잡지, 신문 등은 대출 불가합니다.</dd>
													</dl>
												</div>
											</div>
										</div>
									</div>
									<!-- [E] 3층 : 제2자료실 -->
								</div>
							</div>
						</div>
						<!-- [E] 3층 -->

					</div>
                    	</div>
				<!--// info_content : 1 시설안내-->

				<div class="info_content">
					<h5 class="title_h5">휴관일</h5>
					<div class="operation_guide_article info_guide">
						<ul class="info_guide_style1">
							<li>
								<div class="ico_info_guide tb_info_guide">
									<div class="col4"><span class="ico_info_guide1">정보검색실</span></div>
									<div class="col4"><span class="ico_info_guide2">어린이실</span></div>
									<div class="col4"><span class="ico_info_guide3">제1자료실</span></div>
									<div class="col4"><span class="ico_info_guide4">제2자료실</span></div>
								</div>

								<div class="txt_info_guide">
									<ul>
										<li>매주 월요일</li>
										<li>정부 지정 공휴일</li>
										<li>매년 12.30 ~ 12.31(연말 대청소)</li>
									</ul>
								</div>
							</li>

							<li>
								<div class="ico_info_guide"><span class="ico_info_guide4">열람실</span></div>
								<div class="txt_info_guide">
									<ul>
										<li>정부 지정 공휴일</li>
										<li class="line2">매년 12.30 ~ 12.31 <span class="block">(연말 대청소)</span></li>
									</ul>
								</div>
							</li>
						</ul>
					</div>

					<h5 class="title_h5">이용시간</h5>
					<div class="operation_guide_article info_guide">
						<ul class="info_guide_style2">
							<li>
								<div class="ico_info_guide"><span class="ico_info_guide1">정보검색실</span></div>
								<div class="txt_info_guide">
									<ul>
										<li class="line">09:00~18:00</li>
									</ul>
								</div>
							</li>

							<li>
								<div class="ico_info_guide"><span class="ico_info_guide2">어린이실</span></div>
								<div class="txt_info_guide">
									<ul>
										<li class="line">09:00~18:00</li>
									</ul>
								</div>
							</li>

							<li>
								<div class="ico_info_guide"><span class="ico_info_guide3">제1자료실</span></div>
								<div class="txt_info_guide">
									<ul>
										<li>화~토요일 : 09:00~22:00</li>
										<li>일요일 : 08:00~18:00</li>
									</ul>
								</div>
							</li>

							<li>
								<div class="ico_info_guide"><span class="ico_info_guide3">제2자료실</span></div>
								<div class="txt_info_guide">
									<ul>
										<li class="line">09:00~18:00</li>
									</ul>
								</div>
							</li>

							<li>
								<div class="ico_info_guide"><span class="ico_info_guide4">열람실</span></div>
								<div class="txt_info_guide">
									<ul>
										<li>3월~10월 : 07:00~23:00</li>
										<li>11월~2월 : 08:00~23:00</li>
									</ul>
								</div>
							</li>
						</ul>
					</div>

					<h5 class="title_h5">대출/반납 안내</h5>
					<div class="operation_guide_article info_return">
						<ul>
							<li>
								<dl>
									<dt>대출</dt>
									<dd>
										<div class="ico_operationguide_line">도서 대출은 회원증을 소지한 <strong>본인만 가능</strong>합니다.</div>
										<div class="ico_operationguide_line">대출 건수: <strong>1인 5권</strong><br />
											<span class="txt_red pt">※ 춘천시립도서관에서는 문화가 있는 날(매달 마지막 주 수요일) 18시부터 22시까지 15권 대출 가능합니다.</span>
										</div>
										<div class="ico_operationguide_line">대출 기간: <strong>2주(14일),</strong> 대출 기간은 연장 안 됩니다.</div>
									</dd>
								</dl>
							</li>

							<li>
								<dl>
									<dt>반납</dt>
									<dd>
										<div class="ico_operationguide_line">도서관 운영 시간 중에는 도서를 빌리신 <strong>자료실에 반납</strong>하시면 됩니다.<br />
											<span class="txt_red">반납 시간 이후에는 1층 사무실에 반납해주시기 바랍니다.</span>
										</div>
										<div class="ico_operationguide_line"><strong>연체 일수만큼 대출 정지</strong>됩니다</div>
									</dd>
								</dl>
							</li>
							<li>
								<dl>
									<dt>유의사항</dt>
									<dd>
										<div class="ico_operationguide_line">열람실 내에서는 <span class="txt_red">음식물 반입을 할 수 없습니다.</span></div>
										<div class="ico_operationguide_line">정기간행물 및 참고도서의 경우 <span class="txt_red">대출이 불가</span>합니다.</div>
										<div class="ico_operationguide_line">도서대출 회원증 춘천시립, 동내, 신사우, 소양, 남산, 서면 도서관에서 <span class="txt_red">공유 가능</span>합니다.</div>
										<div class="ico_operationguide_line">대출한 자료의 분실 및 훼손한 경우에는 <span class="txt_red">동일 도서로 변상</span>해야 합니다.</div>
									</dd>
								</dl>
							</li>
						</ul>
					</div>

					<h5 class="title_h5">프린트/복사안내</h5>
					<p class="info_sub_txt">춘천시립도서관에서는 유료로 프린트 및 복사 서비스를 이용할 수 있습니다.</p>
					<table summary="프린트/복사안내" class="info_tb_style">
						<caption>프린트/복사안내</caption>
						<thead>
							<tr>
								<th scope="col" style="width:20%;">구분</th>
								<th scope="col" style="width:20%;">요금</th>
								<th scope="col" style="width:20%;">장소</th>
								<th scope="col" style="width:20%;">이용시간</th>
								<th scope="col" style="width:20%;">결제방법</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>프린트 (흑백)</td>
								<td>A4 장당 50원</td>
								<td>정보검색실 (1층)</td>
								<td>09:00 ~ 18:00</td>
								<td>체크카드/신용카드/티머니카드/선불카드</td>
							</tr>
							<tr>
								<td>복사 (흑백)</td>
								<td>A4/B4 장당 50원</td>
								<td>제2 자료실 (3층)</td>
								<td>09:00 ~ 18:00</td>
								<td>선불카드</td>
							</tr>
						</tbody>
					</table>

					<p class="info_txt_matter">* 선불카드(3000원)는 지하1층 북카페 안 매점에서 구입하시기 바랍니다.</p>

                    	</div>
				<!--// info_content : 2 이용안내-->

				<div class="info_content">
                    	</div>
				<!--// info_content : 3 자료현황-->

				<div class="info_content">
					<h4 class="title_h4">담당업무</h4>
					<div class="work_article_con box_list_style_article clearfix tabClick">
						<ul class="organ">
							<li class="first on"><span class="charge">관장</span>
							    <ul class="sec clearfix">
								     <li><span class="charge">관리담당</span></li>
								     <li><span class="charge">사서담당</span></li>
								     <li><span class="charge">열람담당</span></li>
							    </ul>
							</li>
						</ul>

						<div class="charge_content" style="display: block;">
							<table summary="담당업무" class="info_tb_style">
								<caption>담당업무</caption>
								<thead>
									<tr>
										<th scope="col" style="width:20%;">직위</th>
										<th scope="col" style="width:20%;">이름</th>
										<th scope="col" style="width:40%;">업무</th>
										<th scope="col" style="width:20%;">전화번호</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>관장</td>
										<td>김옥분</td>
										<td>도서관 업무 총괄</td>
										<td>033-245-5100</td>
									</tr>
									<tr>
										<td>관리담당</td>
										<td>성기문</td>
										<td>관리담당 업무 총괄, 위탁도서관 총괄 관리</td>
										<td>033-245-5107</td>
									</tr>

									<tr>
										<td>주무관</td>
										<td>성수연</td>
										<td>회계, 예산</td>
										<td>033-245-5106</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>강희정</td>
										<td>서무</td>
										<td>033-245-5102</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>김주열</td>
										<td>책배달 서비스, 청사 환경정비, 공공근로 관리</td>
										<td>033-245-5105</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>한덕근</td>
										<td>본·분관 시설 관리</td>
										<td>033-245-5116</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>고창규</td>
										<td>본·분관 시설 관리</td>
										<td>033-245-5111</td>
									</tr>
									<tr>
										<td>청원경찰</td>
										<td>이종학</td>
										<td>청사관리 및 방호</td>
										<td>033-245-5108</td>
									</tr>
									<tr>
										<td>청원경찰</td>
										<td>이상화</td>
										<td>청사관리 및 방호</td>
										<td>033-245-5108</td>
									</tr>
									<tr>
										<td>청원경찰</td>
										<td>박진수</td>
										<td>청사관리 및 방호</td>
										<td>033-245-5108</td>
									</tr>
									<tr>
										<td>사서담당</td>
										<td>이춘복</td>
										<td>사서담당 업무 총괄, 자료 수집</td>
										<td>033-245-5104</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>엄법현</td>
										<td>도서 정리, 시립 원부 관리 및 도서 제적 </td>
										<td>033-245-5112</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>정영란</td>
										<td>도서 정리, 기증자료 관리</td>
										<td>033-245-5113</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>김성희</td>
										<td>위탁도서관 도서 정리, 작은도서관 지원 관리</td>
										<td>033-245-5114</td>
									</tr>
									<tr>
										<td>열람담당</td>
										<td>최순임</td>
										<td>열람담당 업무 총괄</td>
										<td>033-245-5103</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>함영미</td>
										<td>일반인 대상 문화행사 기획 운영, 국내외 도서관 교류 협력 업무</td>
										<td>033-245-5109</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>박천응</td>
										<td>제2자료실 운영 관리</td>
										<td>033-245-5121</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>강태욱</td>
										<td>제1자료실 운영 관리, 야간개관사업 추진</td>
										<td>033-245-5115</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>이영주</td>
										<td>어린이실 운영 관리, 어린이 대상 문화행사 기획 운영</td>
										<td>033-245-5119</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>송은혜</td>
										<td>제1자료실 운영 관리, 책바다·책누리 서비스 진행</td>
										<td>033-245-5138</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>양시은</td>
										<td>디지털자료실 운영 관리, 시립도서관 홈페이지 운영 관리</td>
										<td>033-245-5110</td>
									</tr><tr>
										<td>주무관</td>
										<td>장도영</td>
										<td>야간 열람실 관리</td>
										<td>033-245-5115</td>
									</tr>
									<tr>
										<td>주무관</td>
										<td>김영욱</td>
										<td>야간 제1자료실 관리</td>
										<td>033-245-5102</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- //charge_content01-->
						<div class="charge_content">
							<table summary="관리담당" class="info_tb_style">
								<caption>관리담당</caption>
								<thead>
									<tr>
										<th scope="col" style="width:20%;">직위</th>
										<th scope="col" style="width:20%;">이름</th>
										<th scope="col" style="width:40%;">업무</th>
										<th scope="col" style="width:20%;">전화번호</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>관리담당</td>
										<td>성기문</td>
										<td>관리담당 업무 총괄, 위탁도서관 총괄 관리</td>
										<td>033-245-5107</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- //charge_content02-->
						<div class="charge_content">
							<table summary="사서담당" class="info_tb_style">
								<caption>사서담당</caption>
								<thead>
									<tr>
										<th scope="col" style="width:20%;">직위</th>
										<th scope="col" style="width:20%;">이름</th>
										<th scope="col" style="width:40%;">업무</th>
										<th scope="col" style="width:20%;">전화번호</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>관장</td>
										<td>김옥분</td>
										<td>도서관 업무 총괄</td>
										<td>033-245-5100</td>
									</tr>
									<tr>
										<td>관리담당</td>
										<td>성기문</td>
										<td>관리담당 업무 총괄, 위탁도서관 총괄 관리</td>
										<td>033-245-5107</td>
									</tr>

									<tr>
										<td>주무관</td>
										<td>성수연</td>
										<td>회계, 예산</td>
										<td>033-245-5106</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- //charge_content03-->
						<div class="charge_content">
							<table summary="열람담당" class="info_tb_style">
								<caption>열람담당</caption>
								<thead>
									<tr>
										<th scope="col" style="width:20%;">직위</th>
										<th scope="col" style="width:20%;">이름</th>
										<th scope="col" style="width:40%;">업무</th>
										<th scope="col" style="width:20%;">전화번호</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>관장</td>
										<td>김옥분</td>
										<td>도서관 업무 총괄</td>
										<td>033-245-5100</td>
									</tr>
									<tr>
										<td>관리담당</td>
										<td>성기문</td>
										<td>관리담당 업무 총괄, 위탁도서관 총괄 관리</td>
										<td>033-245-5107</td>
									</tr>

								</tbody>
							</table>
						</div>
						<!-- //charge_content04-->
					</div>
                    </div>
				<!--// info_content : 4 담당업무-->

				<div class="info_content">
					<h4 class="title_h4">오시는 길</h4>
					<div id="daumRoughmapContainer1476681954379" class="root_daum_roughmap root_daum_roughmap_landing"></div>
					<div class="location_article_con box_list_style_article clearfix">
						<dl class="location_info box_list_style">
							<dt><span class="ico_location add"></span>주소</dt>
							<dd>강원도 춘천시 옛경춘로 830-24 (삼천동 28-79) 춘천시립도서관</dd>
						</dl>
						<dl class="location_info box_list_style">
							<dt><span class="ico_location tel"></span>전화번호</dt>
							<dd>033 - 245 - 5102</dd>
						</dl>
						<dl class="location_info box_list_style">
							<dt><span class="ico_location parking"></span>주차시설</dt>
							<dd>119면</dd>
						</dl>
						<dl class="box_list_style no_pd">
							<dt><span class="ico_location traffic"></span>교통편</dt>
							<dd>
								<p>PC에서는 춘천-홍천축 광역 버스정보시스템 http://www.chbis.kr/realTimeBusInfo.do 아래 정류장명을 치시면 버스번호를 검색하실 수 있습니다.<br />
								스마트폰에서는 춘천시 버스 어플리케이션을 사용하시면 편리합니다.</p>
								<table summary="교통편" class="info_tb_style">
									<caption>교통편</caption>
									<thead>
										<tr>
											<th scope="col">정류장명</th>
											<th scope="col">정류장 번호</th>
											<th scope="col">비고</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>공지천 분수대</td>
											<td>2080</td>
											<td>도보 7분</td>
										</tr>

										<tr>
											<td>삼천동 시립도서관</td>
											<td>2059</td>
											<td>도보 5분</td>
										</tr>
									</tbody>
								</table>
							</dd>
						</dl>
					</div>
				</div>
				<!--// info_content : 5 오시는 길-->
			</div>
			<!--// cont -->
		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../include/footer.jsp" />
	
</div>
<!--// wrap -->

<!-- script -->

<jsp:include page="include/scripts.jsp" />

<script class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// info tab
		tabClick('.info', '.info_content');

		// map tab
		tabClick('.title_map', '.con_map', '.slider_for, .slider_nav');

		// floor tab
		tabClick('.title_floor', '.con_floor', '.slider_for, .slider_nav');

		// charge tab
		tabClick('.charge', '.charge_content');

		// 지하1층 - 1
		$('.slickFor_fB1_1').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			dots: false,
			fade: true,
			speed: 100,
			cssEase: 'linear',
			asNavFor: '.slickNav_fB1_1'
		});
		$('.slickNav_fB1_1').slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			asNavFor: '.slickFor_fB1_1',
			arrows: false,
			dots: false,
			infinite: true,
			touchMove:false,
			focusOnSelect: true,
			responsive:[
				{
				breakpoint:768,
				settings:{
					touchMove:true
				}
				}
			]
		});
		// slider btn
		$('.slickPrev_fB1_1').on('click', function(){
		       $(".slickFor_fB1_1").slick('slickPrev');
		});
		$('.slickNext_fB1_1').on('click', function(){
		       $(".slickFor_fB1_1").slick('slickNext');
		});

		// 지하1층 - 2
		$('.slickFor_fB1_2').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			dots: false,
			fade: true,
			speed: 100,
			cssEase: 'linear',
			asNavFor: '.slickNav_fB1_2'
		});
		$('.slickNav_fB1_2').slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			asNavFor: '.slickFor_fB1_2',
			arrows: false,
			dots: false,
			infinite: true,
			touchMove:false,
			focusOnSelect: true,
			responsive:[
				{
				breakpoint:768,
				settings:{
					touchMove:true
				}
				}
			]
		});
		// slider btn
		$('.slickPrev_fB1_2').on('click', function(){
		       $(".slickFor_fB1_2").slick('slickPrev')
		});
		$('.slickNext_fB1_2').on('click', function(){
		       $(".slickFor_fB1_2").slick('slickNext');
		});

		// 1층 - 1
		$('.slickFor_f1_1').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			dots: false,
			fade: true,
			speed: 100,
			cssEase: 'linear',
			asNavFor: '.slickNav_f1_1'
		});
		$('.slickNav_f1_1').slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			asNavFor: '.slickFor_f1_1',
			arrows: false,
			dots: false,
			infinite: true,
			touchMove:false,
			focusOnSelect: true,
			responsive:[
				{
				breakpoint:768,
				settings:{
					touchMove:true
				}
				}
			]
		});
		// slider btn
		$('.slickPrev_f1_1').on('click', function(){
		       $(".slickFor_f1_1").slick('slickPrev')
		});
		$('.slickNext_f1_1').on('click', function(){
		       $(".slickFor_f1_1").slick('slickNext');
		});

		// 1층 - 2
		$('.slickFor_f1_2').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			dots: false,
			fade: true,
			speed: 100,
			cssEase: 'linear',
			asNavFor: '.slickNav_f1_2'
		});
		$('.slickNav_f1_2').slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			asNavFor: '.slickFor_f1_2',
			arrows: false,
			dots: false,
			infinite: true,
			touchMove:false,
			focusOnSelect: true,
			responsive:[
				{
				breakpoint:768,
				settings:{
					touchMove:true
				}
				}
			]
		});
		// slider btn
		$('.slickPrev_f1_2').on('click', function(){
		       $(".slickFor_f1_2").slick('slickPrev');
		});
		$('.slickNext_f1_2').on('click', function(){
		       $(".slickFor_f1_2").slick('slickNext');
		});

		// 1층 - 3
		// $('.slickFor_f1_3').slick({
		// 	slidesToShow: 1,
		// 	slidesToScroll: 1,
		// 	arrows: false,
		// 	dots: false,
		// 	fade: true,
		// 	speed: 100,
		// 	cssEase: 'linear',
		// 	asNavFor: '.slickNav_f1_3'
		// });
		// $('.slickNav_f1_3').slick({
		// 	slidesToShow: 5,
		// 	slidesToScroll: 1,
		// 	asNavFor: '.slickFor_f1_3',
		// 	arrows: false,
		// 	dots: false,
		// 	infinite: false,
		// 	touchMove:false,
		// 	focusOnSelect: true,
		// 	responsive:[
		// 		{
		// 		breakpoint:768,
		// 		settings:{
		// 			touchMove:true
		// 		}
		// 		}
		// 	]
		// });
		// // slider btn
		// $('.slickPrev_f1_3').on('click', function(){
		//        $(".slickFor_f1_3").slick('slickPrev')
		//        });

		// });
		// $('.slickNext_f1_3').on('click', function(){
		//        $(".slickFor_f1_3").slick('slickNext');
		// });

		// 2층 - 1
		$('.slickFor_f2_1').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			dots: false,
			fade: true,
			speed: 100,
			cssEase: 'linear',
			asNavFor: '.slickNav_f2_1'
		});
		$('.slickNav_f2_1').slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			asNavFor: '.slickFor_f2_1',
			arrows: false,
			dots: false,
			infinite: true,
			touchMove:false,
			focusOnSelect: true,
			responsive:[
				{
				breakpoint:768,
				settings:{
					touchMove:true
				}
				}
			]
		});
		// slider btn
		$('.slickPrev_f2_1').on('click', function(){
		       $(".slickFor_f2_1").slick('slickPrev');
		});
		$('.slickNext_f2_1').on('click', function(){
		       $(".slickFor_f2_1").slick('slickNext');
		});

		// 2층 - 2
		$('.slickFor_f2_2').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			dots: false,
			fade: true,
			speed: 100,
			cssEase: 'linear',
			asNavFor: '.slickNav_f2_2'
		});
		$('.slickNav_f2_2').slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			asNavFor: '.slickFor_f2_2',
			arrows: false,
			dots: false,
			infinite: true,
			touchMove:false,
			focusOnSelect: true,
			responsive:[
				{
				breakpoint:768,
				settings:{
					touchMove:true
				}
				}
			]
		});
		// slider btn
		$('.slickPrev_f2_2').on('click', function(){
		       $(".slickFor_f2_2").slick('slickPrev');

		});
		$('.slickNext_f2_2').on('click', function(){
		       $(".slickFor_f2_2").slick('slickNext');
		});

		// 3층 - 1
		$('.slickFor_f3_1').slick({
			slidesToShow: 1,
			slidesToScroll: 1,
			arrows: false,
			dots: false,
			fade: true,
			speed: 100,
			cssEase: 'linear',
			asNavFor: '.slickNav_f3_1'
		});
		$('.slickNav_f3_1').slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			asNavFor: '.slickFor_f3_1',
			arrows: false,
			dots: false,
			infinite: true,
			touchMove:false,
			focusOnSelect: true,
			responsive:[
				{
				breakpoint:768,
				settings:{
					touchMove:true
				}
				}
			]
		});
		// slider btn
		$('.slickPrev_f3_1').on('click', function(){
		       $(".slickFor_f3_1").slick('slickPrev');
		});
		$('.slickNext_f3_1').on('click', function(){
		       $(".slickFor_f3_1").slick('slickNext');
		});

	});
</script>

<script>
	// Daum Map
	new daum.roughmap.Lander({
		"timestamp" : "1476681954379",
		"key" : "dkis",
		"mapWidth" : "1600",
		"mapHeight" : "554"
	}).render();
</script>
</body>
</html>