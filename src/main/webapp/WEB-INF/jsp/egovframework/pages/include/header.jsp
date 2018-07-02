<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!--  HEADER.JSP -->
	<div id="header" class="header">
			<button type="button" class="m_menu"></button>
			<h1 class="m_logo"><a href="\"><img src="/resources/images/img/logo.gif" alt="춘천시립도서관" /></a></h1>
			<div class="m_lnb_section lnb_section">
				<i class="dim"></i>
				<button type="button" class="slide_menu_close"></button>
				<div class="m_lnb_article">
					<div class="gnb_wrap">
						<div class="gnb">
							<a href="#">HOME</a>
							<a href="#">로그인</a>
							<a href="about/join">회원가입</a>
							<a href="#">사이트맵</a>
							<a href="#" class="mypage">나의공간</a>
						</div>
						<!--// gnb -->
					</div>
					<!--// gnb_wrap -->
					<div id="lnb" class="lnb">
						<i class="bg_lnb">
							 <div class="bg_lnb_some">
								<img src="/resources/images/img/img_lnb_bg.jpg" alt="">
								<p>
									<i class="ico_some">ABOUT CHUNCHEON CITY LIBRARY</i>
									<span>춘천의 미래를 춘천시립도서관이 함께하겠습니다.</span>
								</p>
							</div>
						</i>
						<div class="lnb_area clearfix">
							<h1><a href="\"><img src="/resources/images/img/logo.gif" alt="춘천시립도서관" /></a></h1>
							<div class="m_search_article">
								<form>
									<fieldset>
										<legend>도서검색</legend>
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
											<button type="button" class="btn_search"><span class="blind">검색</span></button>
										</div>
	
									</fieldset>
								</form>
							</div>
							<!--// m_search_article -->
							<ul class="menu clearfix">
								<li class="dep1 m_home"><a href="#">HOME</a></li>
								<li class="dep1">
									<a href="/about">도서관소개</a>
									<div class="dep2">
										
										
										<!--  -->
										<ul class="clearfix">
											<li><a href="/about">도서관안내</a>
												<ul>
													<li><a href="/about/info01">춘천시립도서관</a></li>
													<li><a href="/about/info02">청소년도서관</a></li>
													<li><a href="/about/info03">동내도서관</a></li>
													<li><a href="/about/info04">신사우도서관</a></li>
													<li><a href="/about/info05">소양도서관</a></li>
													<li><a href="/about/info06">남산도서관</a></li>
													<li><a href="/about/info07">서면도서관</a></li>
												</ul>
											</li>
											<li><a href="/about/join">회원가입</a></li>
											<li><a href="/about/greeting">인사말</a></li>
											<li><a href="/about/history">연혁</a></li>
											<li><a href="/about/regulations">도서관 자치법규</a></li>
											<li><a href="/about/charter">도서관 헌장</a></li>
										</ul>
										<!--  -->
									</div>
								</li>
								<li class="dep1">
									<a href="search">자료검색</a>
									<div class="dep2">
										<ul class="clearfix">
											<li><a href="/search">통합검색
											<li><a href="/search/original">원문검색</a></li>
											<li><a href="/search/newarrivals">신작도서</a></li>
											<li><a href="/search/topten">대출베스트</a></li>
										</ul>
									</div>
								</li>
								<li class="dep1">
									<a href="#">전자도서관</a>
									<div class="dep2">
										<ul class="clearfix">
											<li><a href="#">전자도서관 안내
											<li><a href="#">전자책</a></li>
											<li><a href="#">웹진</a></li>
											<li><a href="#">오디오북</a></li>
	
										</ul>
									</div>
								</li>
								<li class="dep1">
									<a href="#">문화마당</a>
									<div class="dep2">
										<ul class="clearfix">
											<li><a href="#">문화행사 개요</a></li>
											<li><a href="#">문화행사 안내 / 신청</a></li>
										</ul>
									</div>
								</li>
								<li class="dep1">
									<a href="#">이용자마당</a>
									<div class="dep2">
										<ul class="clearfix">
											<li><a href="/members/noticeboard">공지사항</a></li>
											<li><a href="/members/faq">자주하는 질문</a></li>
											<li><a href="/members/qna">묻고 답하기</a></li>
											<li><a href="/members/freeboard">자유게시판</a></li>
											<li><a href="#">희망도서 신청</a></li>
											<li><a href="#">책나래</a></li>
											<li><a href="#">책바다</a></li>
											<li><a href="#">책이음</a></li>
											<li><a href="/members/volunteering">봉사활동 신청</a></li>
											<li><a href="/members/excursions">견학신청</a></li>
											<li><a href="#">모바일회원증</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</div>
						<!--// lnb_area -->
					</div>
					<!--// lnb -->
				</div>
				<!--// m_lnb_article -->
			</div>
			<!--// m_lnb_section -->
		</div>
		<!--  END OF HEADER.JSP -->