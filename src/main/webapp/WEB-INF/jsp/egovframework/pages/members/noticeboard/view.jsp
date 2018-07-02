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
<!-- script -->
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resources/js/stellar.js"></script>
<script type="text/javascript" src="/resources/js/slick.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
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
			<h3 class="title_h3">공지사항</h3>

					<div class="bbs_wrap">
						<div class="bbs_view">
							<div class="title">
								<h4>홈페이지 개편 안내사항 공지</h4>
								<div class="author">
									<span class="writer">작성자 : 관리자</span>
									<span class="date">작성일 : 2016-08-16</span>
									<span class="hit">조회수 : 201</span>
								</div>
								<div class="sns_wrap">
									<a href="#" class="ico_sns sns_fb">페이스북</a>
									<a href="#" class="ico_sns sns_tw">트위터</a>
								</div>
							</div>
							<div class="file_wrap">
								<span class="ico ico_file">첨부파일</span> 첨부파일 : <a href="#">abcdefg.hwp</a>, <a href="#">abcdefg.hwp</a>
							</div><!-- //file_wrap -->
							<div class="context">
								<!-- 게시글 내용 -->
								
								홈페이지 개편 안내사항입니다.<br>
								홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 홈페이지 개편 안내사항입니다. 

								<!-- //게시글 내용 -->
							</div>
						</div><!-- //bbs_view -->

						<div class="btn_wrap float_right">
							<a href="list.html" class="btn btn_point">수정</a>
							<a href="list.html" class="btn btn_basic">목록</a>
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