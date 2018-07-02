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
			<h3 class="title_h3">견학 신청</h3>

			<div class="reservation_calendar">

			<div class="depth3_menu">
				<a href="#">춘천시립<br>도서관</a>
				<a href="#" class="on">동내<br>도서관</a>
				<a href="#">신사우<br>도서관</a>
				<a href="#">소양<br>도서관</a>
				<a href="#">남산<br>도서관</a>
				<a href="#">서면<br>도서관</a>
				<a href="#">청소년<br>도서관</a>
			</div>
			<!--// tab_title -->

			<div class="calendar_month">
				<a href="#" class="ico ico_prev">이전달</a>
				<p>2016년 10월</p>
				<a href="#" class="ico ico_next">다음달</a>
			</div>
			<table class="table_calendar">
				<colgroup>
					<col width="14.2857%">
					<col width="14.2857%">
					<col width="14.2857%">
					<col width="14.2857%">
					<col width="14.2857%">
					<col width="14.2857%">
					<col width="14.2857%">
				</colgroup>
				<thead>
					<tr>
						<th>일</th>
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th>토</th>
					</tr>
				</thead>
				<tbody>
					
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><span style='color:red'>1</span><br><a href="tour_view.html">신청</a></td>
					</tr>
					<tr>
						<td><span style='color:red'>2</span><br><a href="#">신청(마감)</a></td>
						<td><span>3</span><br><span class="holiday">휴일</span></td>
						<td><span>4</span></td>
						<td><span>5</span></td>
						<td><span>6</span></td>
						<td><span>7</span></td>
						<td><span style='color:red'>8</span><br><a href="#">신청(마감)</a></td>
					</tr>
					<tr>
						<td><span style='color:red'>9</span><br><a href="#">신청(마감)</a></td>
						<td><span>10</span><br><span class="holiday">휴일</span></td>
						<td><span>11</span></td>
						<td><span>12</span></td>
						<td><span>13</span></td>
						<td><span>14</span></td>
						<td><span style='color:red'>15</span><br><a href="#">신청(마감)</a></td>
					</tr>
					<tr>
						<td><span style='color:red'>16</span><br><a href="#">신청(마감)</a></td>
						<td><span>17</span><br><span class="holiday">휴일</span></td>
						<td><span>18</span></td>
						<td><span>19</span></td>
						<td><span>20</span></td>
						<td><span>21</span></td>
						<td><span style='color:red'>22</span><br><a href="#">신청(마감)</a></td>
					</tr>
					<tr>
						<td><span style='color:red'>23</span><br><a href="#">신청(마감)</a></td>
						<td><span>24</span><br><span class="holiday">휴일</span></td>
						<td><span>25</span></td>
						<td><span>26</span></td>
						<td><span>27</span></td>
						<td><span>28</span></td>
						<td><span style='color:red'>29</span><br><a href="#">신청(마감)</a></td>
					</tr>
					<tr>
						<td><span style='color:red'>30</span><br><a href="#">신청(마감)</a></td>
						<td><span>31</span><br><span class="holiday">휴일</span></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>

			</div>



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