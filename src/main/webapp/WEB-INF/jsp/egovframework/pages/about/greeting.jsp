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
				<span><a href="#">도서관 소개</a> <i></i></span>
				<span><a href="#">인사말</a></span>
			</div>
			<!--// nav -->
		</div>
		<!--// sub_visual -->

		<jsp:include page="include/navbar.jsp" />

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">인사말</h3>

			<div class="cont_greeting clearfix">
				<div class="bg_img">
					<img src="/resources/images/img/img_introduce.jpg" alt="인사말 이미지">
				</div>
				<div class="intro_txt">
					<h4>안녕하십니까,<span><strong>춘천시립도서관</strong> 홈페이지 방문을 진심으로 환영합니다.</span> </h4>
					<p>우리 시는 21세기 지식정보화 시대를 선도하는 독서, 문화, 문학 종합 정보망으로써의 역할을 다하기 위하여
					   도·농 통합시의 지리적 특성을 살려서 본관인 시립도서관을 비롯하여 동내, 신사우, 소양, 남산, 서면 도서관을
					   운영하고 있습니다.
					</p>
					<p>또한 도서관 수 증가와 함께 서비스의 질에서도 앞서가기 위해 내실 있는 자료수집은 물론 다양한 문학교실 및
						문화 행사 등을 온/오프라인으로 확대 시행함으로써 시민과 함께하는 도서관, 다시 찾고 싶은 도서관으로의 역할에
						최선을 다하고자 합니다.
					</p>
					<p>앞으로도 이용자 여러분의 변함없는 사랑과 관심을 부탁드립니다.</p>
					<p class="from">- 춘천시립도서관장 올림</p>
				</div>
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

</body>
</html>