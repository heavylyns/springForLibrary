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

		<jsp:include page="../include/navbar.jsp" />

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">
		

					<!-- ====================== 내용시작 ====================== -->
		
			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">묻고답하기</h3>

					<div class="bbs_wrap">

						<div class="step_wrap">
							<ul>
								<li class="active"><span class="step_no">?</span><span class="step_txt">질문등록</span><span class="step_arrow"></span></li>
								<li><span class="step_no">∞</span><span class="step_txt">처리중</span><span class="step_arrow"></span></li>
								<li><span class="step_no">!</span><span class="step_txt">답변완료</span><span class="step_arrow"></span></li>
								<li><span class="step_no">X</span><span class="step_txt">답변없음</li>
							</ul>
						</div>

						<fieldset>
						<legend>글쓰기</legend>
						<form action="#">

							<table class="table_form">
								<caption>글쓰기</caption>
								<colgroup>
									<col style="width:15%;" />
									<col style="width:85%;" />
								</colgroup>
								<tbody>
									<tr>
										<th>제목</th>
										<td><input type="text" name="bbs_title" class="col100"></td>
									</tr>
									<tr>
										<th>비밀글</th>
										<td>
											<input type="checkbox" name="bbs_open" id="bbs_open"> <label for="bbs_open">공개</label> &nbsp;&nbsp;&nbsp;
											<input type="checkbox" name="bbs_rock" id="bbs_rock"> <label for="bbs_rock">비공개</label>
										</td>
									</tr>
									<tr>
										<th>작성자</th>
										<td>홍길동</td>
									</tr>
									<tr>
										<th>첨부파일</th>
										<td><input type="file" name="bbs_file"></td>
									</tr>
									<tr>
										<td class="context" colspan="2">
										<!-- 에디터 위치 -->
										<textarea class="col100" rows="30"></textarea>
										</td>
									</tr>
								</tbody>
							</table>

						</form>
						</fieldset>

						<div class="btn_wrap float_right">
							<a href="#" class="btn btn_point">답변</a>
							<a href="list.html" class="btn">취소</a>
							<a href="#" class="btn btn_basic">완료</a>
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