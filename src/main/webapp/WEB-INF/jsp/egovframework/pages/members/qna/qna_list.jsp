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
<link rel="stylesheet" href="/resources/css/bbs.css" />
<link rel="stylesheet" href="/resources/css/main.css" />
<link rel="stylesheet" href="/resources/css/jquery-ui.min.css"/>
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
	
	<jsp:include page="../../include/header.jsp" />

	<div id="sub_container" class="sub_container sub_container_intro">
		<div class="sub_visual sub_visual4">
			<h2><span class="ico_round">이용자마당</span></h2>
			<div class="nav">
				<span><a href="#">HOME</a><i></i></span>
				<span><a href="#">이용자마당</a> <i></i></span>
				<span><a href="#">공지사항</a></span>
			</div>
			<!--// nav -->
		</div>
		<!--// sub_visual -->

		<jsp:include page="../include/navbar.jsp"/>

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">
		

					<!-- ====================== 내용시작 ====================== -->
		
			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">묻고답하기</h3>

					<div class="bbs_wrap">

						<!-- 검색 -->
						<fieldset>
						<legend>게시물 검색</legend>
						<form action="#">
							<div class="search_wrap">
								<select name="search_select" title="구분 선택">
									<option>전체선택</option>
									<option value="0">제목</option>
									<option value="1">내용</option>
								</select>
								<input type="text" name="search_word" title="검색어 입력" class="srh_word">
								<a href="#" class="btn inverse btn_small"><span class="ico ico_search"></span>검색</a>
							</div><!-- //search_wrap -->
						</form>
						</fieldset>

						<div class="guide_total">
							총 <strong>132</strong>개의 글이 있습니다.
						</div>

						<table class="table_bbs">
							<caption>리스트</caption>
							<colgroup>
								<col style="width:5%;" class="mobile_hidden" />
								<col style="width:auto;" />
								<col style="width:10%;" class="mobile_hidden" />
								<col style="width:12%;" class="mobile_hidden" />
								<col style="width:8%;" class="mobile_hidden" />
								<col style="width:8%;" class="mobile_hidden" />
								<col style="width:14%;" />
							</colgroup>
							<thead>
								<tr>
									<th scope="col" class="mobile_hidden">번호</th>
									<th scope="col">제목</th>
									<th scope="col" class="mobile_hidden">작성자</th>
									<th scope="col" class="mobile_hidden">작성일</th>
									<th scope="col" class="mobile_hidden">첨부</th>
									<th scope="col" class="mobile_hidden">조회</th>
									<th scope="col">처리상태</th>
								</tr>
							</thead>
							<tbody>
								<!-- 등록된 글이 없으면 -->
								<tr>
									<td colspan="7" class="none">등록된 글이 없습니다.</td>
								</tr>
								<!-- //등록된 글이 없으면 -->
								<tr>
									<td class="mobile_hidden">132</td>
									<td class="subject"><a href="view.html">질문과 답변 제목입니다.</a> <span class="ico ico_new">새글</span></td>
									<td class="mobile_hidden">
										<!--공개글이거나 작성자, 관리자가 로그인 상태면 이름이 나옴  -->
										홍길동
									</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden"><span class="ico ico_file">첨부파일</span></td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_default">질문등록</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">131</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a> <span class="ico ico_new">새글</span></td>
									<td class="mobile_hidden">
										<!--비공개면 -->
										<span class="ico ico_rock">잠금글</span>
									</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden"><span class="ico ico_file">첨부파일</span></td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_ing">처리중</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">130</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">
										<!--비공개면 -->
										<span class="ico ico_rock">잠금글</span>
									</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden"><span class="ico ico_file">첨부파일</span></td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_fin">답변완료</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">129</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">
										<!--비공개면 -->
										<span class="ico ico_rock">잠금글</span>
									</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden">-</td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_none">답변없음</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">128</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden">-</td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_ing">처리중</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">127</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden">-</td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_ing">처리중</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">126</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden">-</td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_ing">처리중</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">125</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden">-</td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_ing">처리중</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">124</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden">-</td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_ing">처리중</span></td>
								</tr>
								<tr>
									<td class="mobile_hidden">123</td>
									<td class="subject"><a href="#">질문과 답변 제목입니다.</a></td>
									<td class="mobile_hidden">홍길동</td>
									<td class="mobile_hidden">2016-08-16</td>
									<td class="mobile_hidden">-</td>
									<td class="mobile_hidden">26</td>
									<td><span class="state state_ing">처리중</span></td>
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
							<a href="write.html" class="btn btn_basic">글쓰기</a>
						</div>

					</div><!-- //bbs_wrap -->

					<!-- ====================== 내용종료 ====================== -->

		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../../include/footer.jsp" />
	
</div>
<!--// wrap -->

<jsp:include page="../../include/scripts.jsp" />

</body>
</html>