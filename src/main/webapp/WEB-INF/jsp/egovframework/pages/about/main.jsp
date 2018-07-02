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
	
	<jsp:include page="../include/header.jsp" />

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
			<h3 class="title_h3">도서관안내</h3>

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<div class="intro_effect_section">
				<div class="intro_txt" id="intro_article1">
					<div class="intro_txt_l">
						<h3>춘천시립도서관</h3>
						<p>미래로<br />뻗어나가는 춘천시의<br />지식의 뿌리입니다.</p>
					</div>

					<div class="intro_txt_r">
						<h4>춘천의 지식의 뿌리가 되는 춘천시립도서관에 오신 것을 환영합니다.</h4>
						<p>우리 춘천시립도서관은 1960년에 도립도서관으로 개관해 현재는 춘천시립도서관으로 춘천시민의 지식의 뿌리로 꾸준히 노력해오고 있습니다. 다양한 독서활동과 문화행사 프로그램 등 지역사회의 종합 문화 공간의 역할에 최선을 다하고 있습니다. 어린이실, 제1자료실, 제2자료실, 정보검색실, 열람실 등을 항시 운영하고 있으며 이외에 다양한 문화환경을 조성하기 위해 많은 시설을 유지해오고 있습니다. 춘천시민에게 언제나 가까운 곳에서 문화생활의 질을 높여주는 공공기관으로 여러분의 소중한 목소리에 귀 기울여 배려와 협력으로 모두가 행복한 춘천교육을 위하여 전 직원 모두가 정성을 다하고 있습니다.</p>
						<a href="info1.html" class="btn_library_go"><strong class="ico_library_go_1">춘천시립도서관</strong> 바로가기</a>
					</div>
				</div>
				<!--// intro_txt -->

				<div class="intro_effect intro_effect1" data-stellar-background-ratio="0.5"></div>

				<div class="intro_txt" id="intro_article7">
					<div class="intro_txt_l">
						<h3>청소년도서관</h3>
						<p>미래로<br />뻗어나가는 춘천시의<br />지식의 뿌리입니다.</p>
					</div>

					<div class="intro_txt_r">
						<h4>춘천의 지식의 뿌리가 되는 청소년도서관에 오신 것을 환영합니다.</h4>
						<p>우리 춘천시립도서관은 1960년에 도립도서관으로 개관해 현재는 춘천시립도서관으로 춘천시민의 지식의 뿌리로 꾸준히 노력해오고 있습니다. 다양한 독서활동과 문화행사 프로그램 등 지역사회의 종합 문화 공간의 역할에 최선을 다하고 있습니다. 어린이실, 제1자료실, 제2자료실, 정보검색실, 열람실 등을 항시 운영하고 있으며 이외에 다양한 문화환경을 조성하기 위해 많은 시설을 유지해오고 있습니다. 춘천시민에게 언제나 가까운 곳에서 문화생활의 질을 높여주는 공공기관으로 여러분의 소중한 목소리에 귀 기울여 배려와 협력으로 모두가 행복한 춘천교육을 위하여 전 직원 모두가 정성을 다하고 있습니다.</p>
						<a href="#" class="btn_library_go"><strong class="ico_library_go_7">청소년도서관</strong> 바로가기</a>
					</div>
				</div>

				<div class="intro_effect intro_effect2" data-stellar-background-ratio="0.5"></div>

				<div class="intro_txt" id="intro_article2">
					<div class="intro_txt_l">
						<h3>동내도서관</h3>
						<p>미래로<br />뻗어나가는 춘천시의<br />지식의 뿌리입니다.</p>
					</div>

					<div class="intro_txt_r">
						<h4>춘천의 지식의 뿌리가 되는 동내도서관에 오신 것을 환영합니다</h4>
						<p>우리 춘천시립도서관은 1960년에 도립도서관으로 개관해 현재는 춘천시립도서관으로 춘천시민의 지식의 뿌리로 꾸준히 노력해오고 있습니다. 다양한 독서활동과 문화행사 프로그램 등 지역사회의 종합 문화 공간의 역할에 최선을 다하고 있습니다. 어린이실, 제1자료실, 제2자료실, 정보검색실, 열람실 등을 항시 운영하고 있으며 이외에 다양한 문화환경을 조성하기 위해 많은 시설을 유지해오고 있습니다. 춘천시민에게 언제나 가까운 곳에서 문화생활의 질을 높여주는 공공기관으로 여러분의 소중한 목소리에 귀 기울여 배려와 협력으로 모두가 행복한 춘천교육을 위하여 전 직원 모두가 정성을 다하고 있습니다.</p>
						<a href="#" class="btn_library_go"><strong class="ico_library_go_2">동내도서관</strong> 바로가기</a>
					</div>
				</div>
				<!--// intro_txt -->

				<div class="intro_effect intro_effect3" data-stellar-background-ratio="0.5"></div>

				<div class="intro_txt" id="intro_article3">
					<div class="intro_txt_l">
						<h3>신사우도서관</h3>
						<p>미래로<br />뻗어나가는 춘천시의<br />지식의 뿌리입니다.</p>
					</div>

					<div class="intro_txt_r">
						<h4>춘천의 지식의 뿌리가 되는 신사우도서관에 오신 것을 환영합니다.</h4>
						<p>우리 춘천시립도서관은 1960년에 도립도서관으로 개관해 현재는 춘천시립도서관으로 춘천시민의 지식의 뿌리로 꾸준히 노력해오고 있습니다. 다양한 독서활동과 문화행사 프로그램 등 지역사회의 종합 문화 공간의 역할에 최선을 다하고 있습니다. 어린이실, 제1자료실, 제2자료실, 정보검색실, 열람실 등을 항시 운영하고 있으며 이외에 다양한 문화환경을 조성하기 위해 많은 시설을 유지해오고 있습니다. 춘천시민에게 언제나 가까운 곳에서 문화생활의 질을 높여주는 공공기관으로 여러분의 소중한 목소리에 귀 기울여 배려와 협력으로 모두가 행복한 춘천교육을 위하여 전 직원 모두가 정성을 다하고 있습니다.</p>
						<a href="#" class="btn_library_go"><strong class="ico_library_go_3">신사우도서관</strong> 바로가기</a>
					</div>
				</div>
				<!--// intro_txt -->

				<div class="intro_effect intro_effect4" data-stellar-background-ratio="0.5"></div>

				<div class="intro_txt" id="intro_article4">
					<div class="intro_txt_l">
						<h3>소양도서관</h3>
						<p>미래로<br />뻗어나가는 춘천시의<br />지식의 뿌리입니다.</p>
					</div>

					<div class="intro_txt_r">
						<h4>춘천의 지식의 뿌리가 되는 소양도서관에 오신 것을 환영합니다.</h4>
						<p>우리 춘천시립도서관은 1960년에 도립도서관으로 개관해 현재는 춘천시립도서관으로 춘천시민의 지식의 뿌리로 꾸준히 노력해오고 있습니다. 다양한 독서활동과 문화행사 프로그램 등 지역사회의 종합 문화 공간의 역할에 최선을 다하고 있습니다. 어린이실, 제1자료실, 제2자료실, 정보검색실, 열람실 등을 항시 운영하고 있으며 이외에 다양한 문화환경을 조성하기 위해 많은 시설을 유지해오고 있습니다. 춘천시민에게 언제나 가까운 곳에서 문화생활의 질을 높여주는 공공기관으로 여러분의 소중한 목소리에 귀 기울여 배려와 협력으로 모두가 행복한 춘천교육을 위하여 전 직원 모두가 정성을 다하고 있습니다.</p>
						<a href="#" class="btn_library_go"><strong class="ico_library_go_4">소양도서관</strong> 바로가기</a>
					</div>
				</div>
				<!--// intro_txt -->

				<div class="intro_effect intro_effect5" data-stellar-background-ratio="0.5"></div>

				<div class="intro_txt" id="intro_article5">
					<div class="intro_txt_l">
						<h3>남산도서관</h3>
						<p>미래로<br />뻗어나가는 춘천시의<br />지식의 뿌리입니다.</p>
					</div>

					<div class="intro_txt_r">
						<h4>춘천의 지식의 뿌리가 되는 남산도서관에 오신 것을 환영합니다.</h4>
						<p>우리 춘천시립도서관은 1960년에 도립도서관으로 개관해 현재는 춘천시립도서관으로 춘천시민의 지식의 뿌리로 꾸준히 노력해오고 있습니다. 다양한 독서활동과 문화행사 프로그램 등 지역사회의 종합 문화 공간의 역할에 최선을 다하고 있습니다. 어린이실, 제1자료실, 제2자료실, 정보검색실, 열람실 등을 항시 운영하고 있으며 이외에 다양한 문화환경을 조성하기 위해 많은 시설을 유지해오고 있습니다. 춘천시민에게 언제나 가까운 곳에서 문화생활의 질을 높여주는 공공기관으로 여러분의 소중한 목소리에 귀 기울여 배려와 협력으로 모두가 행복한 춘천교육을 위하여 전 직원 모두가 정성을 다하고 있습니다.</p>
						<a href="#" class="btn_library_go"><strong class="ico_library_go_5">남산도서관</strong> 바로가기</a>
					</div>
				</div>
				<!--// intro_txt -->

				<div class="intro_effect intro_effect6" data-stellar-background-ratio="0.5"></div>

				<div class="intro_txt" id="intro_article6">
					<div class="intro_txt_l">
						<h3>서면도서관</h3>
						<p>미래로<br />뻗어나가는 춘천시의<br />지식의 뿌리입니다.</p>
					</div>

					<div class="intro_txt_r">
						<h4>춘천의 지식의 뿌리가 되는 서면도서관에 오신 것을 환영합니다.</h4>
						<p>우리 춘천시립도서관은 1960년에 도립도서관으로 개관해 현재는 춘천시립도서관으로 춘천시민의 지식의 뿌리로 꾸준히 노력해오고 있습니다. 다양한 독서활동과 문화행사 프로그램 등 지역사회의 종합 문화 공간의 역할에 최선을 다하고 있습니다. 어린이실, 제1자료실, 제2자료실, 정보검색실, 열람실 등을 항시 운영하고 있으며 이외에 다양한 문화환경을 조성하기 위해 많은 시설을 유지해오고 있습니다. 춘천시민에게 언제나 가까운 곳에서 문화생활의 질을 높여주는 공공기관으로 여러분의 소중한 목소리에 귀 기울여 배려와 협력으로 모두가 행복한 춘천교육을 위하여 전 직원 모두가 정성을 다하고 있습니다.</p>
						<a href="#" class="btn_library_go"><strong class="ico_library_go_6">서면도서관</strong> 바로가기</a>
					</div>
				</div>
				<!--// intro_txt -->
				<!--// intro_txt -->
			</div>
			<!--// intro_effect_section -->


		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../include/footer.jsp" />
	
</div>
<!--// wrap -->

<jsp:include page="include/scripts.jsp" />

</body>
</html>