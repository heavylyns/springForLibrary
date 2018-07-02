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
				<span><a href="#">통합검색</a></span>
				<span class="active"><a href="#">원문검색</a></span>
				<span><a href="#">신착도서</a></span>
				<span><a href="#">대출베스트</a></span>
			</div>
		</div>
		<!--// sub_nav_section -->

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- ====================== 내용시작 ====================== -->

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">원문검색</h3>

			<div class="original">
				<div class="subscript">
					국립중앙도서관 및 국회도서관 원문DB(온라인) 열람 및 출력이 가능합니다.<br>
					<strong>춘천시립도서관은 국립중앙 및 국회도서관의 전자도서관과 협약체결기관입니다.</strong>
				</div>
				<div class="ori_background"></div>
				<div class="ori_text">
					<dl>
						<dt><strong>도서관보상금제</strong>란</dt>
						<dd>
							<p>도서관간 디지털정보의 원활한 유통과 저작권자의 권리보호를 위하여 2004년 7월1일부터 저작권법(제28조)에서 정하는 바에 따라 도서관보상금제도(문화관광부 고시2003-9 호)를 시행함에 따라 국립중앙 및 국회도서관의 전자도서관에서 제공되는 원문DB의 열람 및 출력은 일부 협약체결기관에서만 가능하며, 열람 및 출력 보상금을 정보이용자가 지불하는 제도입니다.</p>
						</dd>
						<dt>이용 방법</dt>
						<dd>
							<p>시립도서관 정보검색실(1층) 지정 좌석에서 열람 및 출력 가능합니다.<br>프린트 출력 요금 : A4 장당 50원</p>
						</dd>
						<dt>서비스 자료 조회</dt>
						<dd>
							<dl class="sitelist">
								<dt><span><img src="/resources/images/img/original_logo1.png" alt="국립중앙도서관"></span></dt>
								<dd>
									<p>고서, 관보, 문화관광부발간자료, 1945년 이전 신문, 한국관련외국자료, eBOOK, 기타 등</p>
									<a href="#" class="btn_link">사이트 바로가기<span class="ico_arrow"></span></a>
								</dd>
								<dt><span><img src="/resources/images/img/original_logo2.png" alt="국회도서관"></span></dt>
								<dd>
									<p>고서, 관보, 문화관광부발간자료, 1945년 이전 신문, 한국관련외국자료, eBOOK, 기타 등</p>
									<a href="#" class="btn_link">사이트 바로가기<span class="ico_arrow"></span></a>
								</dd>
							</dl>
						</dd>
					</dl>
				</div>
			</div><!-- //original -->

			<!-- ====================== 내용종료 ====================== -->
		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../include/footer.jsp" />
	
</div>
<!--// wrap -->

<!-- script -->
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/stellar.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
</body>
</html>