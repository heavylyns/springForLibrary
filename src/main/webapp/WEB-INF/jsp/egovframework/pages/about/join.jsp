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
		<div class="sub_visual sub_visual1">
			<h2><span class="ico_round">도서관 소개</span></h2>
			<div class="nav">
				<span><a href="#">HOME</a><i></i></span>
				<span><a href="#">도서관 소개</a> <i></i></span>
				<span><a href="#">회원가입</a></span>
			</div>
			<!--// nav -->
		</div>
		<!--// sub_visual -->

		<jsp:include page="include/navbar.jsp" />

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">회원가입</h3>

			<div class="cont_join box_list_style_section">
				<div class="join_article join_article_intro box_list_style_article">
					<h4 class="title_h4">회원가입 자격</h4>
					<p>춘천시에 주민등록이 되어 있는 자 <span>춘천시 소재 직장 또는 학교에 재직하거나 재학 중인 자 </span><span>춘천시에 거주 중인 재외동포, 국내거소 신고자 및 외국인 등록자 </span><span>기타 관장이 필요하다고 인정한 자</span></p>
				</div>

				<div class="join_article join_article_con box_list_style_article">
					<h4 class="title_h4">회원증 발급안내</h4>

					<dl class="box_list_style no_pd">
						<dt><span class="ico_membership">회원증 발급 방법</span></dt>
						<dd>
							<ul>
								<li><i class="bull_blue">&bull;</i>홈페이지 회원 가입 후 <strong class="underline">구비서류</strong> 지참하여 도서관에 방문해주시기 바랍니다.<br />
								<span class="pr">(<span class="txt_red">* 어린이는 반드시 보호자께서 동반해주셔야 합니다.</span>)</span></li>
								<li><i class="bull_blue">&bull;</i>회원증 발급 비용 없음</li>
								<li><i class="bull_blue">&bull;</i>발급장소
									<table summary="회원증 발급장소">
										<caption>회원증 발급장소</caption>
										<thead>
											<tr>
												<th scope="col">도서관명</th>
												<th scope="col">회원증 발급장소</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><strong>춘천시립도서관</strong></td>
												<td>유아 ~ 초등학생 : 어린이자료실 / 중학생 ~ 일반 : 제1자료실</td>
											</tr>

											<tr>
												<td><strong>청소년도서관</strong></td>
												<td>미정</td>
											</tr>

											<tr>
												<td><strong>동내도서관</strong></td>
												<td>사무실</td>
											</tr>

											<tr>
												<td><strong>신사우도서관</strong></td>
												<td>미정</td>
											</tr>

											<tr>
												<td><strong>소양도서관</strong></td>
												<td>유아 ~ 초등학생 : 어린이자료실 / 중학생 ~ 일반 : 제1자료실</td>
											</tr>

											<tr>
												<td><strong>남산도서관</strong></td>
												<td>종합자료실</td>
											</tr>

											<tr>
												<td><strong>서면도서관</strong></td>
												<td>종합자료실</td>
											</tr>
										</tbody>
									</table>
								</li>

							</ul>
						</dd>
					</dl>

					<dl class="box_list_style list_line">
						<dt>유의사항</dt>
						<dd>
							<ul>
								<li><i class="bull_blue">&bull;</i>도서대출 시 반드시 제시해주시기 바랍니다.</li>
								<li><i class="bull_blue">&bull;</i>회원증 분실 시 즉시 도서관에 통보해주시기 바랍니다.</li>
								<li><i class="bull_blue">&bull;</i>회원증 재발급 3회시 90일간 도서 대출 자격이 정지됩니다.</li>
								<li><i class="bull_blue">&bull;</i>주소, 전화번호 등 개인 정보 변경 시 도서관에 통보해주시기 바랍니다.</li>
							</ul>
						</dd>
					</dl>

					<dl class="box_list_style list_line">
						<dt>회원증 발급/<br />재발급 구비서류 안내</dt>
						<dd>
							<table summary="회원증 발급/재발급 구비서류 안내">
								<caption>회원증 발급/재발급 구비서류 안내</caption>
								<thead>
									<tr>
										<th scope="col" colspan="2"><strong>구분</strong></th>
										<th scope="col" colspan="2"><strong>구비서류</strong></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan="2"><strong>만14세 어린이</strong></td>
										<td colspan="2" class="align_left">보호자 신분증과 가족관계증빙서류 (3개월 이내 발급된 가족관계 증명서, 주민등록등본, 건강보험증 중 택1)</td>
									</tr>

									<tr>
										<td rowspan="5"><strong>만14세 이상</strong></td>
										<td><strong>만14세 어린이</strong></td>
										<td colspan="2" class="align_left">학생증</td>
									</tr>

									<tr>
										<td rowspan="2"><strong>만14세 어린이</strong></td>
										<td colspan="2" class="align_left">주민등록상 주소 확인 가능한 주민등록증 또는 운전면허증</td>
									</tr>

									<tr>
										<td class="align_left">재직⁄재학 증명서</td>
										<td class="align_left">주소지가 춘천이 아닌 경우에만 해당</td>
									</tr>

									<tr>
										<td><strong>재외국인</strong></td>
										<td colspan="2" class="align_left">재외국민 주민등록증</td>
									</tr>

									<tr>
										<td><strong>외국인</strong></td>
										<td colspan="2" class="align_left">외국인등록증</td>
									</tr>
								</tbody>
							</table>
							<p class="txt_red pt">* 하나의 회원증으로 춘천시 내 7개 도서관(시립·동내·신사우·소양·남산·서면·청소년도서관) 어느 곳에서든 이용 가능합니다.</p>
						</dd>
					</dl>
					<a href="#" class="btn_join">홈페이지 회원가입하기</a>
				</div>
			</div>
			<!--// cont_join -->
		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../include/footer.jsp" />
	
</div>
<!--// wrap -->

<jsp:include page="include/scripts.jsp" />

</body>
</html>