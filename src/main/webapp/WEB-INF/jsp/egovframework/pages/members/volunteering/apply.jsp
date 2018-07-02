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
	
	<jsp:include page="../../include/header.jsp"/>

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
			<h3 class="title_h3">봉사활동 신청</h3>

			<div class="bbs_wrap">

				<div class="bbs_view2">
					<div class="title">
						<h4>2016년 10월 1일 봉사활동</h4>
						<div class="author">
							<ul>
								<li class="wid33"><span class="author_title wid50">장 소</span> 동내도서관</li>
								<li class="wid33"><span class="author_title wid50">인 원</span> 4명</li>
								<li class="wid33"><span class="author_title wid50">내 용</span> 봉사활동:도서배열 및 정리</li>
								<li class="wid100"><span class="author_title wid50">일 시</span> 오후 2:00:00 ~ 오후 6:00:00</li>
							</ul>
						</div>
					</div>
				</div><!-- //bbs_view -->

				<h4 class="title_4">봉사활동 신청</h4>


				<div class="bbs_write">
					<fieldset>
					<legend>신청하기</legend>
					<form action="#">
					<dl>
						<dt>이름</dt>
						<dd><input type="text" name="apply_name" style="width:200px;" title="이름 입력" value="홍길동"></dd>
						<dt>대상</dt>
						<dd>
							<input type="radio" name="apply_target" id="apply_target1"> <label for="apply_target1">성인</label>&nbsp;&nbsp;
							<input type="radio" name="apply_target" id="apply_target2" checked="checked"> <label for="apply_target2">청소년</label>&nbsp;&nbsp;
							<input type="radio" name="apply_target" id="apply_target3"> <label for="apply_target3">대학생</label>&nbsp;&nbsp;
						</dd>
						<dt>학교정보</dt>
						<dd>
							<!-- 청소년 -->
							<p>
								<input type="text" name="apply_school" style="width:200px;" title="학교명 입력" placeholder="학교명을 입력해주세요.">&nbsp;&nbsp;
								<span>
									<input type="text" name="apply_year" style="width:50px;" title="학년 입력" placeholder=""> 학년&nbsp;&nbsp;
									<input type="text" name="apply_class" style="width:50px;" title="반 입력" placeholder=""> 반
								</span>
							</p>
							<!-- 대학생
							<p>
								<input type="text" name="apply_school" style="width:200px;" title="학교명 입력" placeholder="학교명을 입력해주세요.">&nbsp;&nbsp;
								<input type="text" name="apply_major" style="width:200px;" title="전공 입력" placeholder="전공을 입력해주세요.">
							</p>
							-->
						</dd>
						<dt>연락처</dt>
						<dd>
							<select name="apply_tel1" title="국번 선택">
								<option value="010">010</option>
								<option value="033">033</option>
							</select> -
							<input type="text" name="apply_tel2" style="width:50px;" title="전화번호 입력"> -
							<input type="text" name="apply_tel3" style="width:50px;" title="전화번호 입력">
						</dd>
						<dt>비밀번호</dt>
						<dd><input type="password" name="apply_pass" style="width:200px;" title="비밀번호 입력"></dd>
					</dl>
					</form>
					</fieldset>

					<div class="btn_wrap">
						<a href="#" class="btn btn_point">등록</a>
						<a href="volunteer.html" class="btn btn_basic">취소</a>
					</div>

					<div class="apply_list">
						<p class="apply_guide">봉사활동 신청 인원 : <strong>2</strong>/4명</p>
						<ul>
							<li>
								<span class="name">홍**</span>
								<span>강원대학교</span>
								<span>정보통신학과</span>
								<span>010-****-2233</span>
								<span class="date">2016-10-07 10:00</span>
								<a href="#" class="ico ico_delete">삭제</a>
							</li>
							<li>
								<span class="name">홍**</span>
								<span>대룡중학교</span>
								<span>2학년 3반</span>
								<span>010-****-2233</span>
								<span class="date">2016-10-07 10:00</span>
								<a href="#" class="ico ico_delete">삭제</a>
							</li>
						</ul>
					</div>
				</div>

			</div><!-- //bbs_wrap -->




			<!-- ====================== 내용종료 ====================== -->
		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../../include/footer.jsp"/>

</div>
<!--// wrap -->

<!-- script -->
<jsp:include page="../../include/scripts.jsp"/>

<script type="text/javascript">
	$(document).ready(function(){
		$(function(){
			// sub_nav_select
			$('.go_nav_article').on('click', function(){
				if( !$(this).hasClass('on') ) {
					$(this).addClass('on');
					$(this).find('> ul').stop().slideDown('fast');
					return false;
				} else {
					$(this).removeClass('on');
					$(this).find('> ul').stop().slideUp('fast');
				}
			});
		});
	});
</script>
</body>
</html>