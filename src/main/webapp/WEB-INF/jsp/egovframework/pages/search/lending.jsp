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
				<span><a href="#">원문검색</a></span>
				<span><a href="#">신착도서</a></span>
				<span class="active"><a href="#">대출베스트</a></span>
			</div>
		</div>
		<!--// sub_nav_section -->

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- ====================== 내용시작 ====================== -->

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">대출베스트</h3>

			<div class="depth3_menu">
				<a href="#" class="on">춘천시립<br>도서관</a>
				<a href="#">동내<br>도서관</a>
				<a href="#">신사우<br>도서관</a>
				<a href="#">소양<br>도서관</a>
				<a href="#">남산<br>도서관</a>
				<a href="#">서면<br>도서관</a>
				<a href="#">청소년<br>도서관</a>
			</div>
			<!--// tab_title -->

			<table class="table_bbs">
				<caption>리스트</caption>
				<colgroup>
					<col style="width:auto;"/>
					<col style="width:auto;" class="mobile_hidden" />
					<col style="width:auto;" />
					<col style="width:auto;"  class="mobile_hidden"/>
					<col style="width:auto;" class="mobile_hidden" />
					<col style="width:auto;"  class="mobile_hidden"/>
				</colgroup>
				<thead>
					<tr>
						<th scope="col">순위</th>
						<th scope="col" class="mobile_hidden">청구기호</th>
						<th scope="col">제목</th>
						<th scope="col" class="mobile_hidden">저자</th>
						<th scope="col" class="mobile_hidden">발행자</th>
						<th scope="col" class="mobile_hidden">대출횟수</th>
					</tr>
				</thead>
				<tbody>
					<!-- 등록된 글이 없으면 -->
					<tr>
						<td colspan="6" class="none">검색결과가 없습니다.</td>
					</tr>
					<!-- //등록된 글이 없으면 -->

					<tr>
						<td>1</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>2</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>3</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>4</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>5</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>16</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>7</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>8</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>9</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
					<tr>
						<td>10</td>
						<td class="mobile_hidden">J321.55-ㅇ135ㅌ-7 </td>
						<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
						<td class="mobile_hidden">홍길동</td>
						<td class="mobile_hidden">북하우스</td>
						<td class="mobile_hidden">5</td>
					</tr>
				</tbody>
			</table>

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