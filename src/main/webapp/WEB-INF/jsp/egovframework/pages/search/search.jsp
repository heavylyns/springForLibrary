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
		<div class="sub_visual sub_visual2">
			<h2><span class="ico_round">자료검색</span></h2>
			<div class="nav">
				<span><a href="#">HOME</a><i></i></span>
				<span><a href="#">자료검색</a> <i></i></span>
				<span><a href="#">통합검색</a></span>
			</div>
			<!--// nav -->
		</div>
		<!--// sub_visual -->

		<div class="sub_nav_section">
			<div class="sub_nav_article">
				<span class="active"><a href="#">통합검색</a></span>
				<span><a href="#">원문검색</a></span>
				<span><a href="#">신착도서</a></span>
				<span><a href="#">대출베스트</a></span>
			</div>
		</div>
		<!--// sub_nav_section -->

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- ====================== 내용시작 ====================== -->

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">통합검색</h3>

			<!-- ====================== 내용종료 ====================== -->
		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<div id="footer" class="footer">
		<div class="info_are_wrap">
			<div class="info_are clearfix">
			   	<p>
					<span><a href="">개인정보처리방침</a></span>
					<span><a href="">저작권보호정책</a></span>
					<span><a href="">이메일무단수집거부</a></span>
					<span><a href="">뷰어다운로드</a></span>
				</p>

			</div>
			<!--// info_are -->
		</div>
		<!--// info_are_wrap -->

		<div class="m_foot_section">
			<div class="m_foot_article">
				<a href="#" class="m_foot_address"><span class="">도서관 주소보기</span></a>

				<div class="sitemap">
					<h4>유관기관<span> 바로가기</span></h4>
					<div class="sitemapList">
						<ul>
							<li><a href="#">시립도서관</a></li>
							<li><a href="#">동내도서관</a></li>
							<li><a href="#">신사우도서관</a></li>
							<li><a href="#">소양도서관</a></li>
							<li><a href="#">서면도서관</a></li>
							<li><a href="#">남산도서관</a></li>
							<li><a href="#">청소년도서관</a></li>
						</ul>
					</div>
					<!--// sitemapList -->
				</div>
				<!--// sitemap -->
			</div>
			<!--// m_foot_article -->

			<div class="infoAdd">
				<p class="infoAdd_area">
				   <a href="#" class="pop_close"></a>
				   <span>시립</span>(24428) 강원도 춘천시 옛경춘로 830-24 (삼천동) 춘천시립도서관 TEL. 033-245-5102<br />
				   <span>동내</span>(24428) 강원도 춘천시 동내면 학곡동1길 17-4 (동내면 학곡리 24-6) 동내도서관 TEL. 033-245-5102<br />
				   <span>신사우</span>(24428) 강원도 춘천시 사우4길 26 (사농동 99-7) 신사우도서관 TEL. 033-245-5102<br />
				   <span>소양</span>(24428) 강원도 춘천시 삭주로 145번길 69-8(후평동) 소양도서관 TEL. 033-245-5102<br />
				   <span>서면</span>(24428) 강원도 춘천시 서면 박사로 948 (서면 금산리 402-11) 서면도서관 TEL. 033-245-5102<br />
				   <span>남산</span>(24428) 강원도 춘천시 남산면 강촌로 311 (남산면 방곡리 629-30) 남산도서관 TEL. 033-245-5102<br />
				   <span>청소년</span>(24428) 강원도 춘천시 옛경춘로 830-24(삼천동)  청소년도서관 TEL. 033-245-5102
				</p>
				<h2 class="logo">
					<a href=""><img src="/resources/images/img/logo_foot.gif" alt="춘천시립도서관 로고"></a>
					<p>Copyright© by Chuncheon City Library. All rights reserved.  </p>
				</h2>
			</div>
			<!-- infoAdd -->
		</div>
		<!--// m_foot_section -->
	</div>
	<!--// footer -->
</div>
<!--// wrap -->

<!-- script -->
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/stellar.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
</body>
</html>