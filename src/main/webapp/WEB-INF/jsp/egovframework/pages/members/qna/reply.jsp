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
			<h3 class="title_h3">공지사항</h3>

					<div class="bbs_wrap">

						<div class="step_wrap">
							<ul>
								<li class="active"><span class="step_no">?</span><span class="step_txt">질문등록</span><span class="step_arrow"></span></li>
								<li><span class="step_no">∞</span><span class="step_txt">처리중</span><span class="step_arrow"></span></li>
								<li><span class="step_no">!</span><span class="step_txt">답변완료</span><span class="step_arrow"></span></li>
								<li><span class="step_no">X</span><span class="step_txt">답변없음</li>
							</ul>
						</div>


						<div class="bbs_view">
							<div class="title">
								<h4>질문과 답변 제목입니다.</h4>
								<div class="author">
									<span class="writer">작성자 : 관리자</span>
									<span class="date">작성일 : 2016-08-16</span>
									<span class="hit">조회수 : 201</span>
								</div>
							</div>
							<div class="file_wrap">
								<span class="ico ico_file">첨부파일</span> 첨부파일 : <a href="#">abcdefg.hwp</a>, <a href="#">abcdefg.hwp</a>
							</div><!-- //file_wrap -->
							<div class="context">
								<!-- 게시글 내용 -->
								
								질문내용입니다.<br>
								질문은 이러궁저러쿵 이리저리해서 요리조리한데 이럴땐 어떻게 해야하나요?

								<!-- //게시글 내용 -->
							</div>
						</div><!-- //bbs_view -->

						<fieldset>
						<legend>글쓰기</legend>
						<form action="#">

							<div class="bbs_reply">
								<span class="ico_a">답변.</span>
								<!-- 에디터 위치 -->
								<textarea class="col100" rows="10"></textarea>
							</div>

						</form>
						</fieldset>

						<div class="btn_wrap textAlign_right">
							<div class="float_left">
								<span class="ico ico_guide"></span> 처리상태 : 
								<select name="state" title="처리상태 선택">
									<option value="0">질문등록</option>
									<option value="1">처리중</option>
									<option value="2">답변완료</option>
									<option value="3">답변없음</option>
								</select>
							</div>
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