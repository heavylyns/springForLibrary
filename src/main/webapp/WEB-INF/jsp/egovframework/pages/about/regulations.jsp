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
				<span><a href="#">도서관 자치법규</a></span>
			</div>
			<!--// nav -->
		</div>
		<!--// sub_visual -->

		<jsp:include page="include/navbar.jsp" />

		<!-- sub_cont_wrap 공통 클래스 -->
		<div class="sub_cont_wrap">

			<!-- 서브페이지마다 다른 클래스가 붙음 -->
			<h3 class="title_h3">도서관 자치법규</h3>

			<div class="cont_regulations box_list_style_section">
				<div class="box_list_style_article">
					<dl class="box_list_style no_pd">
						<dt>도서관 서비스헌장</dt>
						<dd>
							<i class="bull_blue">&bull;</i>우리 춘천시립도서관 직원 일동은 이용 시민들에게 다양한 정보자료와 수준 높은 문화서비스를 신속·친절·공정하게 제공하기 위하여 다음 사항을 실천하겠습니다.
							<ol>
								<li>1. 우리는 정보화시대를 선도하는 지역 종합정보센터로써 정확하고 신속한 정보를 제공하기 위하여 다양한 도서자료와 정보화시설을 확충해 나가겠습니다.</li>
								<li>2. 우리는 기존 시설의 특성화와 다양한 문화행사, 교양강좌를 통하여 모든 계층의 시민이 평생 동안 이용하며 즐겨 찾고 싶은 학습·문화공간으로 만들어 나가겠습니다.</li>
								<li>3. 우리는 시민들이 편안하고 즐거운 마음으로 도서관을 이용하실 수 있도록 쾌적한 환경 조성에 노력하겠습니다.</li>
								<li>4. 우리는 시민의 건의 사항이나 이용자 불만사항을 신속히 개선하도록 노력하겠습니다.</li>
								<li>5. 우리는 이용자의 의견에 귀 기울이고 적극 수용하는 열린 도서관이 되기 위해 노력하겠습니다.<br />
								이와 같은 우리의 목표를 실천하기 위하여 구체적인 서비스 이행 표준을 설정하고 이를 성실히 이행할 것을 다짐합니다.</li>

							</ol>
						</dd>
					</dl>

					<dl class="box_list_style">
						<dt>서비스 이행표준</dt>
						<dd>
							<i class="bull_blue">&bull;</i>친절하고 신속한 서비스 실천
							<ol>
								<li>1. 방문 이용자에 대하여는 도서관 이용과 소장 자료에 대해 직원들에게 문의하시면 하던 일을 중단하고 친절하게 즉시 안내해 드리겠습니다.
									<ul>
										<li>- 모든 직원은 복장을 단정히 하고 명찰을 패용하여 책임 있는 실명제 근무를 하겠습니다.</li>
										<li>- 장애인과 노약자는 다른 이용자보다 먼저 안내해 드리겠습니다.</li>
										<li>- 사무실 입구에 직원 안내도를 비치하여 업무 담당자를 쉽게 찾을 수 있도록 하겠습니다.</li>
									</ul>
								</li>

								<li>2. 전화문의에 대하여는 걸려온 전화는 벨소리가 3번 이상 울리기 전에 받겠으며, 소속과 성명을 정확히 밝히겠습니다.
									<ul>
										<li>- 다른 부서로 전화를 연결할 때에는 끊어질 경우를 대비하여 해당부서의 전화번호를 미리 알려드리고, 즉시 담당자를 연결해 드리겠습니다.</li>
										<li>- 담당자가 부재중일 경우에는 담당업무가 아니더라도 최선을 다해 답해 드리고, 부족한 부분에 대하여는 반드시 메모를 남긴 후 민원인이 원하는 시기와 장소로 전화를 드리도록 하겠습니다.</li>
										<li>- 전화를 마칠 때는 이용자께서 먼저 수화기를 내린 후 전화를 끊겠습니다.</li>
										<li>- 전화 응대 만족도를 향상시키기 위해 전체직원에 대해 1년에 2회 이상 정기적인 교육을 실시하겠습니다.</li>
									</ul>
								</li>

								<li>3. 홈페이지 이용에 대하여는 매일 1회 이상 인터넷 홈페이지의 가동상태를 점검하고, 접수된 민원을 확인하여 7일 이내 정확한 답변이 되도록 하겠습니다.
									<ul>
										<li>- 홈페이지의 최신성을 유지하기 위하여 월1회 이상 내용을 수정·보완하며 공지사항을 수시로 알려 드리겠습니다.</li>
									</ul>
								</li>
							</ol>
						</dd>
					</dl>

					<dl class="box_list_style">
						<dt>적극적인 봉사행정 실현</dt>
						<dd>
							<ul>
								<li><i class="bull_blue">&bull;</i>도서관 홈페이지를 통하여 도서관에 나오지 않아도 자료의 소장여부를 확인 할 수 있도록 하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>춘천시로 명기된 본인 신분증을 제시하여 회원 등록 하시면 가입 즉시 도서를 대출해 드리겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>관외대출한 도서는 반납예정일 1일 전에 핸드폰 문자전송으로 반납예정일을 알려 드리겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>이용자께서 찾는 자료가 없을 경우에는 대체자료를 안내해 드리고, 미흡할 때는 다른 도서관의 자료를 확인하여 안내 하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>도서관 홈페이지와 자료실의 담당사서를 통하여 희망하는 도서를 신청할 수 있도록 하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>"쓴소리·단소리 코너”를 설치하여 이용자의 작은 소리도 귀 기울이는 소통하는 도서관이 되도록 하겠습니다.</li>
							</ul>
						</dd>
					</dl>

					<dl class="box_list_style">
						<dt>다양한 문화행사 및 <span>평생교육 서비스 제공</span></dt>
						<dd>
							<ul>
								<li><i class="bull_blue">&bull;</i>공시민의 문화 활동 함양을 위하여 다양한 프로그램을 운영하여 문화 욕구 충족에 노력하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>각종 문화행사는 인터넷 홈페이지에 연중 홍보하며, 매월 1회 소식지를 배포하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>관보 및 족보 등 특색 있고 다양한 정보자료를 확충하여 운영하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>주민의 독서의욕 고취와 도서관 이용의 생활화를 위하여 도서관 주간 및 독서의 달에는 다양한 행사를 개최하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>아동들의 조기 독서습관 형성 및 올바른 도서관 이용법 지도를 위해 도서관 체험학습을 수시로 실시하겠습니다.</li>
							</ul>
						</dd>
					</dl>

					<dl class="box_list_style">
						<dt>독서환경 조성 및 <span>편의시설 제공</span></dt>
						<dd>
							<ul>
								<li><i class="bull_blue">&bull;</i>정숙한 분위기 조성을 위하여 소란스런 행위, 휴대폰 소음 등을 매일 수시로 순시하며 지도하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>쾌적한 독서환경을 위하여 각 자료실, 자율학습실, 휴게실 등의 상태를 매일 수시로 점검하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>모든 시설물을 매월 1회 정기적으로 점검하여 이용과 안전에 불편이 없도록 하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>휴게실 환경을 안락하게 조성하여 휴식에 도움을 드리겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>장애인을 위한 편의시설(엘리베이터, 핸드레일, 시각장애자용 점자보도 블록)을 설치하여 도서관 이용에 불편이 없도록 하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>정수기를 설치(휴게실, 1층, 2층)하여 이용자 편의에 제공하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>춘천 버스정보시스템인 “버스도착예정시간 안내” 모니터를 설치하여 이용자 편의에 제공하겠</li>
							</ul>
						</dd>
					</dl>

					<dl class="box_list_style">
						<dt>잘못된 서비스에 대한 시정</dt>
						<dd>
							<ul>
								<li><i class="bull_blue">&bull;</i>우리도서관 방문 시 불친절하다고 판단되는 경우 연락을 주시면 정중한 사과를 드리도록 하겠으며, 해당 직원에게는 철저한 교육을 통해 유사한 사례가 발생하지 않도록 하겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>잘못된 민원처리로 인해 재방문하여 불만을 재기하신 경우에는 조사 후 담당직원을 주의·교육시키고 우선적으로 업무를 처리해 드리겠습니다.</li>
								<li><i class="bull_blue">&bull;</i>도서관 운영관리나 시책추진 등 도서관운영위원회의 좋은 의견은 발전적인 도서관을 만들어 가기 위하여 우선적으로 반영하겠습니다.</li>
							</ul>
						</dd>
					</dl>

					<dl class="box_list_style">
						<dt>이용자께서 <span>협조해 주실 사항</span></dt>
						<dd>
							<i class="bull_blue">&bull;</i>우리 도서관은 이용자 여러분에게 최고의 도서관 서비스를 제공하기 위해 이 헌장을 제정하였사오니 여러분께서도 아래사항을 적극 협조 해 주시길 부탁드립니다.
							<ol>
								<li>1. 도서관은 여러 사람이 함께 쓰는 공공의 재산이므로 각종 시설물을 깨끗이 사용하여 주시고 자료가 훼손·분실되는 일이 없도록 하여 주시기 바랍니다.</li>
								<li>2. 대출하신 자료는 다른 이용자들이 이용하는데 불편함이 없도록 기일 내 반납하여 주시기 바랍니다.</li>
								<li>3. 도서관은 많은 이용자가 함께 사용하는 곳이니 다른 이용자에게 방해가 되지 않도록 정숙을 유지하여 주시기 바랍니다.</li>
								<li>4. 자료실이나 열람실 내에서는 개인 휴대폰을 꺼 놓거나, 매너모드로 바꿔 주시기 바랍니다.</li>
								<li>5. 음식물은 휴게실이나 야외 휴게공간에서, 담배는 지정된 흡연구역을 이용해 주시기 바랍니다.<br />
								음식물은 휴게실이나 야외 휴게공간에서, 담배는 지정된 흡연구역을 이용해 주시기 바랍니다.받았을 경우나 모범이 되고 자랑스럽다고 여겨지는 공무원은 적극적으로 추천하여 널리 알릴 수 있도록 협조하여 주시기 바랍니다.</li>
							</ol>
						</dd>
					</dl>

				</div>
				<!--// box_list_style_section -->
			</div>
			<!--// cont_regulations -->
		</div>
		<!--// sub_cont_wrap -->
	</div>
	<!--// sub_container -->

	<jsp:include page="../include/footer.jsp" />
	
</div>
<!--// wrap -->

<!-- script -->
<jsp:include page="include/scripts.jsp" />
</body>
</html></html>