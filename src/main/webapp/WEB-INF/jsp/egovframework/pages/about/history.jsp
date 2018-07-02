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
<!-- script -->
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
				<span><a href="#">연혁</a></span>
			</div>
			<!--// nav -->
		</div>
		<!--// sub_visual -->

		<jsp:include page="include/navbar.jsp" />

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- 서브페이지마다 클래스가 붙음 -->
			<h3 class="title_h3">연혁</h3>
			<div class="cont_history tabClick">
				<div class="tab_title">
					<ul>
						<li class="on">
							<a class="tab_title_a">일반연혁</a>
						</li>
						<li class="">
							<a class="tab_title_a">자매결연도서관</a>
						</li>
					</ul>
				</div>
				<!--// tab_title -->

				<div class="tab_content" style="display: block;">
					<ul class="clearfix">
						<li class="point clearfix">
							<div class="rig"><p>2016 - 현재</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">2013.01.31</span>소양정보도서관을 소양도서관으로 명칭 변경</p></div>
						</li>
						<li class="clearfix">
							<div class="rig"><p><span class="date">2006.11.23</span>서면도서관 개관(서면 금산리 402-4)</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">2005.11.16</span>신사우도서관 개관(신사우동 99-7)</p></div>
						</li>
						<li class="point clearfix">
							<div class="rig"><p>2000 - 2005</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">2004.06.28</span>중국 대련시도서관 협정 체결</p></div>
						</li>
						<li class="clearfix">
							<div class="rig"><p><span class="date">2003.05.27</span>동내도서관 개관(동내면 학곡리 산24-6)</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">2003.04.22</span>일본 호후시립도서관 협정 체결</p></div>
						</li>
						<li class="clearfix">
							<div class="rig"><p><span class="date">2003.02.05</span>제주시립탐라도서관 협정 체결</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">2002.09.09</span>홈페이지 구축<br />시립도서관 본관 디지털자료실 개관</p></div>
						</li>
						<li class="clearfix">
							<div class="rig"><p><span class="date">2001.07.03</span>소양정보도서관 바로북닷컴과 DB교류 협력 조인식</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">2001.05.21</span>남산도서관 개관(남산면 방곡리 629-30)</p></div>
						</li>
						<li class="point clearfix">
							<div class="rig"><p>설립 - 1999</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">1997.06.13</span>일본 돗토리현립도서관 자매결연</p></div>
						</li>
						<li class="clearfix">
							<div class="rig"><p><span class="date">1997.01.10</span>직제규칙 개정으로 열람계 신설(규칙 제136호)</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">1990.06.12</span>현 위치로(춘천시 삼천동 산9-3)으로 이전 개관</p></div>
						</li>
						<li class="clearfix">
							<div class="rig"><p><span class="date">1970.12.10</span>춘천시 이관(구 춘천시 조례 387호)</p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">1960.01.15</span>춘천시 옥천동에서 도립도서관으로 개관</p></div>
						</li>

					</ul>
				</div>
				<!--// tab_content01 -->

				<div class="tab_content">

					<ul class="relative">
						<li class="clearfix">
							<div class="rig"><p><span class="date">중국대련시도서관</span>협정체결 : 2004.06.28<br />상호방문 : 3회<br />연 1회 도서교류<br /><a class="btn_go" href="#">홈페이지 바로가기</a></p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">일본 호후시립호후도서관</span>협정체결 : 2003.04.22<br />상호방문 : 3회<br />연 1회 도서교류<br /><a class="btn_go" href="#">홈페이지 바로가기</a></p></div>
						</li>
						<li class="clearfix">
							<div class="rig"><p><span class="date">제주차치도탐라도서관</span>협정체결 : 2003.02.05<br />어린이회원 홈스테이 실시 : 9회<br />운영내용 : 춘천 ↔ 제주 상호 가정방문<br /><a class="btn_go" href="#">홈페이지 바로가기</a></p></div>
						</li>
						<li class="clearfix">
							<div class="lef"><p><span class="date">일본 돗토리현립도서관</span>협정체결 : 1997.06.13<br />상호방문 : 4회<br />연 1회 도서교류<br /><a class="btn_go" href="#">홈페이지 바로가기</a></p></div>
						</li>
					</ul>
				</div>
				<!--// tab_content02 -->
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
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/stellar.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// tab_title
		tabClick('.tab_title_a', '.tab_content');
	});
</script>
</body>
</html>