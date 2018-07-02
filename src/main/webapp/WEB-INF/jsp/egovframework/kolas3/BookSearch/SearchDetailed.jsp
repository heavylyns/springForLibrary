<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/search_script.js" charset="utf-8"></script>

<script type="text/javascript">

	function book_search(seq){
		//var url = "http://211.253.88.129:8085/kolas3_01/BookStand/search_simple.do";
		var url = "/kolas3/book.searchSimple.do?p_type=pop";
		window.open(url, "", "width=720, height=500");
	}
</script>
<form name="searchform" method="post" action="/kolas3/book.search_result.do" onSubmit="return search_detail()">


<!--  도서관구분끝  -->
<input type="radio" name="jongbook" value="" checked>종단위검색
<input type="radio" name="jongbook" value="_book">책단위검색
<table>
<tr>
<td class="table">
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
	<tr>
		<td class="field" width="160" align="center">검색항목</td>
		<td class="field" width="430" align="center">검색어</td>
		<td class="field" width="110" align="center">검색조건</td>
	</tr>

	<tr>
		 <td class="view2" align="center">
			<select name="field1">
				<option value="IAL">전체</option>
				<option value="IT">표제</option>
				<option value="IA">저자</option>
				<option value="IP">발행자</option>
				<option value="IK">키워드</option>
			</select>
		</td>
		<td class="view">&nbsp;&nbsp;
			<input type="text" name="value1" size="57" class="box">
		</td>
		<td class="view2" align="center">
			<select name="aon1">
				<option value="AND">AND</option>
				<option value="OR">OR</option>
			</select>
		</td>
	</tr>

	<tr>
		<td class="view2" align="center">
			<select name="field2">
				<option value="IT">표제</option>
				<option value="IA">저자</option>
				<option value="IP">발행자</option>
				<option value="IK">키워드</option>
			</select>
		</td>
		<td class="view">&nbsp;&nbsp;
			<input type="text" name="value2" size="57" class="box">
		</td>
		<td class="view2" align="center">
			<select name="aon2">
				<option value="AND">AND</option>
				<option value="OR">OR</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="view2" align="center">
			<select name="field3">
				<option value="IA">저자</option>
				<option value="IP">발행자</option>
				<option value="IK">키워드</option>
			</select>
		</td>
		<td class="view">&nbsp;&nbsp;
			<!-- <input type="text" name="value3" size="57" class="box"> -->
			<input type="button" onclick="javascript:book_search();" value="도서검색" style="height:30px; width:70px;">
		</td>
		<td class="view2" align="center">
			<select name="aon3">
				<option value="AND">AND</option>
				<option value="OR">OR</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="view2" align="center">
			표준부호
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="buho1">
				<option value="SIB">ISBN</option>
				<option value="SIS">ISSN</option>
				<option value="SST">STRN(한국표준기술보고서번호)</option>
	             <option value="SRN">RNSTRN(보고서번호)</option>
                <option value="SCB">국가서지번호</option>
                <option value="SCA">저작권등록번호</option>
			</select>
			<input type="text" name="buhovalue1" class="box">
		</td>
		<td class="view2" align="center">
			<select name="aon4">
				<option value="AND">AND</option>
				<option value="OR">OR</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="view2" align="center">
			분류부호
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="buho2">
				<option value="KDC">KDC(한국십진분류)</option>
				<option value="DDC">DDC(듀이십진분류)</option>
				<option value="LC">LC</option>
			</select>

			<input type="text" name="buhovalue2" class="box">
		</td>
		<td class="view2" align="center">
			<select name="aon5">
				<option value="AND">AND</option>
				<option value="OR">OR</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="view2" align="center">
			한국대학부호
		</td>
		<td class="view">&nbsp;&nbsp;
			<input type="text" name="buhovalue3" size="3" class="box" readonly>
			<input type="text" name="univname" class="box" readonly>
			<a href="javascript:openpopup('book.openuniv.do')">한국대학부호검색</a>
		</td>
		<td class="view2" align="center">
			<select name="aon6">
				<option value="AND">AND</option>
				<option value="OR">OR</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="view2" align="center">
			한국정부기관부호
		</td>
		<td class="view">&nbsp;&nbsp;
			<input type="text" name="buhovalue4" size="3" class="box" readonly>
			<input type="text" name="govname" class="box" readonly>
			<a href="javascript:openpopup('book.opengov.do')">한국기관검색</a>
		</td>
		<td class="view2" align="center">
			&nbsp;
		</td>
	</tr>
</table>
</td>
</tr>
<tr>
<td>
</td class="white">
	&nbsp;
</tr>
<tr>
<td class="table">
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
<tr>
		<!-- <td class="field" align="center">
			원문정보
		</td>
		<td class="view">
			<input type="checkbox" name="vod" value="v">VOD
			<input type="checkbox" name="won" value="y">원문
			<input type="checkbox" name="cd" value="c">CD
		</td>-->
		<td class="field" align="center">
			정렬조건
		</td>
		<td class="view" colspan="3">&nbsp;&nbsp;
			<select name="sort">
				<option value="RK DESC">전체</option>
				<option value="IT DESC">표제 내림차순</option>
				<option value="IT ASC">표제 오름차순</option>
				<option value="IA DESC">저자 내림차순</option>
				<option value="IA ASC">저자 오름차순</option>
				<option value="IP DESC">발행자 내림차순</option>
				<option value="IP ASC">발행자 오름차순</option>
				<option value="YR DESC">발행년 내림차순</option>
				<option value="YR ASC">발행년 오름차순</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="field" align="center">
			구분
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="msa">
				<option value="">전체</option>
				<option value="M">단행</option>
				<option value="S">연속</option>
				<option value="A">기사</option>
			</select>
		</td>
		<td class="field" align="center">
			자료형태
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="formclass">
				<option value="" selected>전체</option>
                <option value="일반도서" >일반도서</option>
                <option value="학위논문" >학위논문</option>
         		<option value="교과서" >교과서</option>
     		    <option value="학습서" >학습서</option>
    		    <option value="만화" >만화</option>
          		<option value="아동/청소년도서" >아동,청소년도서</option>
         		<option value="잡지" >잡지</option>
            	<option value="신문" >신문</option>
         		<option value="비도서" >비도서</option>
    		    <option value="점자자료" >점자자료</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="field" align="center">
			본문언어
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="textlang">
				<option value="" selected>전체</option>
		        <option value="kor">한국어</option>
	            <option value="eng" >영어</option>
	        	<option value="jpn" >일본어</option>
		        <option value="chi" >중국어</option>
	        	<option value="dut" >독일어</option>
	            <option value="fre" >프랑스어</option>
	            <option value="ita" >이탈리아어</option>
	            <option value="rus" >러시아어</option>
	            <option value="spa" >스페인어</option>
			</select>
		</td>
		<td class="field" align="center">
			요약문언어
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="simplelang">
				<option value="" selected>전체</option>
		        <option value="kor">한국어</option>
	            <option value="eng" >영어</option>
	        	<option value="jpn" >일본어</option>
		        <option value="chi" >중국어</option>
	        	<option value="dut" >독일어</option>
	            <option value="fre" >프랑스어</option>
	            <option value="ita" >이탈리아어</option>
	            <option value="rus" >러시아어</option>
	            <option value="spa" >스페인어</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="field" align="center">
			발행년도
		</td>
		<td colspan="3" class="view">&nbsp;&nbsp;
			<input type="text" name="startyear" class="box" size="5">부터
			<input type="text" name="endyear" class="box" size="5">까지
		</td>
	</tr>
	<tr>
		<td class="field" align="center">
			쪽당출력건수
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="limitpage">
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="30">30</option>
			</select>
		</td>
		<td class="field" align="center">
			자료실
		</td>
		<td class="view">&nbsp;&nbsp;
			<select name="local">
				<logic:notEmpty name="search_result">
					<logic:iterate name="search_result" id="placesearchlist">
						<option value="<bean:write name="placesearchlist" property="code"/>">
						<bean:write name="placesearchlist" property="description"/></option>
					</logic:iterate>
				</logic:notEmpty>
			</select>
		</td>
	</tr>
</table>
</td>
</tr>
</table>
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
<tr>
		<td align="right" colspan="4">
			<input type="image" src="/kolas3/images/commonImg/but_search.gif" border=0>
			&nbsp;&nbsp;
			<a href="javascript:reset();"><img src="/kolas3/images/commonImg/icon_reset.gif" border=0></a>
		</td>
	</tr>
</table>
<input type="hidden" name="startpage" value="1">
<input type="hidden" name="mode" value="0">
<%
if(request.getParameter("manage_code")!=null){
String mange_code=request.getParameter("manage_code");
%>
<input type="hidden" name="mgc" value="<%=mange_code%>">
<%}%>
</form>


<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
