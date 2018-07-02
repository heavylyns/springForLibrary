<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
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
				<span class="active"><a href="#">신착도서</a></span>
				<span><a href="#">대출베스트</a></span>
			</div>
		</div>
		<!--// sub_nav_section -->

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- ====================== 내용시작 ====================== -->

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">신착도서</h3>
					<div class="bbs_wrap">

						<!-- 검색 -->
						<fieldset>
						<legend>게시물 검색</legend>
						<form action="#">
							<div class="search_wrap2">
								<div class="searchArea">
									<p class="col-item col100">
										<span class="sh_title">검색일자</span>
										<input type="radio" name="period" id="period1"><label for="period1">1주</label>&nbsp;&nbsp;&nbsp;
										<input type="radio" name="period" id="period2"><label for="period2">2주</label>&nbsp;&nbsp;&nbsp;
										<input type="radio" name="period" id="period3"><label for="period3">1달</label>&nbsp;&nbsp;&nbsp;
										<input type="radio" name="period" id="period4"><label for="period4">2달</label>&nbsp;&nbsp;&nbsp;
										<input type="radio" name="period" id="period5"><label for="period5">3달</label>&nbsp;&nbsp;&nbsp;
										<input type="radio" name="period" id="period6"><label for="period6">6달</label>
									</p>
									<p class="col-item col100">
										<span class="sh_title">교육도서관</span>
										<select name="search_select" title="도서관 선택">
											<option>도서관 선택</option>
											<option value="0">춘천시립도서관</option>
											<option value="1">청소년도서관</option>
											<option value="2">동내도서관</option>
											<option value="3">신사우도서관</option>
											<option value="4">소양도서관</option>
											<option value="5">남산도서관</option>
											<option value="6">서면도서관</option>
										</select>
									</p>
									<p class="col-item col100">
										<span class="sh_title">쪽당출력건수</span>
										<select name="search_select" title="쪽당출력건수 선택">
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
											<option value="40">40</option>
											<option value="50">50</option>
										</select>
									</p>
									<p class="btnArea">
										<a href="#" class="btn btn_small btn_basic"><span class="ico ico_search"></span> 검색</a>
									</p>
								</div><!-- //search_area -->
							</div><!-- //search_wrap -->

						</form>
						</fieldset>


			<div class="depth3_menu">
				<a href="#" class="on">춘천시립<br>도서관 <span class="result_num"><i class="arrow"></i>20</span></a>
				<a href="#">동내<br>도서관 <span class="result_num"><i class="arrow"></i>20</span></a>
				<a href="#">신사우<br>도서관 <span class="result_num"><i class="arrow"></i>20</span></a>
				<a href="#">소양<br>도서관 <span class="result_num"><i class="arrow"></i>20</span></a>
				<a href="#">남산<br>도서관 <span class="result_num"><i class="arrow"></i>20</span></a>
				<a href="#">서면<br>도서관 <span class="result_num"><i class="arrow"></i>20</span></a>
				<a href="#">청소년<br>도서관 <span class="result_num"><i class="arrow"></i>20</span></a>
			</div>
			<!--// tab_title -->

						<div class="guide_total">
							총 <strong>132</strong>개의 글이 있습니다.
						</div>

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
									<th scope="col">번호</th>
									<th scope="col" class="mobile_hidden">소장도서관</th>
									<th scope="col">제목</th>
									<th scope="col" class="mobile_hidden">저자</th>
									<th scope="col" class="mobile_hidden">출판사</th>
									<th scope="col" class="mobile_hidden">발행년도</th>
								</tr>
							</thead>
							<tbody>
								<!-- 등록된 글이 없으면 -->
								<tr>
									<td colspan="6" class="none">검색결과가 없습니다.</td>
								</tr>
								<!-- //등록된 글이 없으면 -->

								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
								<tr>
									<td>132</td>
									<td class="mobile_hidden">시립</td>
									<td class="subject"><a href="accession_view.html">인문학 디자인 : 통합사고력과 논술력을 기르는 창의적인 독서법과 글쓰기</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">북하우스</td>
									<td class="mobile_hidden">2016</td>
								</tr>
							</tbody>
						</table>

						<!-- 페이지 -->
						<div class="pagenate_wrap">
							<div class="pagenation">
								<a href="#" class="ico ico_arrow_first">처음</a>
								<a href="#" class="ico ico_arrow_prev">이전</a>
								<a href="#">1</a>
								<span>2</span>
								<a href="#">3</a>
								<a href="#">4</a>
								<a href="#">5</a>
								<a href="#" class="ico ico_arrow_next">다음</a>
								<a href="#" class="ico ico_arrow_last">마지막</a>
							</div>
						</div><!-- //pagenate_wrap -->

						<div class="btn_wrap float_right">
							<a href="program_write.html" class="btn btn_basic">등록</a>
						</div>

					</div><!-- //bbs_wrap -->

			<!-- ====================== 내용종료 ====================== -->
		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../include/footer.jsp"/>
	
</div>
<!--// wrap -->

<!-- script -->
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/stellar.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
</body>
</html>