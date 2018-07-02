<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>

		<div id="contents">
			<div id="conbox">

<%@page import="kolas3.common.login.SessionManager" %>
<%SessionManager Session = new SessionManager(request); %>

<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" src="/kolas3/script/search_script.js"></script>
<script language="JavaScript" src="/kolas3/script/receipMng.js"></script>
<script language="JavaScript" src="/kolas3/script/mybook.js"></script>




<form name="research" method="post" action="/kolas3/book.search_result.do">
<table>
<tr>
      	<td>
      	<table cellspacing=0 width=700 cellpadding = '0' border = '0' >
         	<tr>
         		<td class="white">
         			결과내검색
         		</td>
         	</tr>
         </table>
      	</td>
      </tr>
<tr>
<td class="table">
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
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
			<a href="javascript:search_research();"><img src="/kolas3/images/commonImg/but_search.gif" border=0></a>
		</td>
	</tr>
<input type="hidden" name="resultcount" value="<bean:write name="resultcount" property="resultcount"/>"/>
<input type="hidden" name="sort" value="<bean:write name="sort"/>"/>
<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>"/>
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>"/>
<input type="hidden" name="startpage" value="1"/>
<input type="hidden" name="limitpage" value="<bean:write name="beforelimitpage"/>"/>
<input type="hidden" name="mode" value="2">
</form>
</table>
</td>
</tr>
</table>
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
<form name="sortform" method="post" action="search_result.do">
	<tr >
		<td>
			&nbsp;
		</td>
	</tr>
	<tr >
		<td>
			검색결과
		</td>
		<td alrign="left">
			<logic:present name="resultcount">
				<logic:notEmpty name="resultcount">
					<logic:equal name="resultcount" property="resultcount"value="EMP">
						검색결과 없음
					</logic:equal>
					<logic:notEqual name="resultcount" property="resultcount" value="EMP">
						<bean:write name="resultcount" property="resultcount"/>건 검색
					</logic:notEqual>
				</logic:notEmpty>
			</logic:present>
		</td>
		<td align="right">
			 <select name="sort" onChange="this.form.submit();">
			<logic:present name="sort">
				<logic:notEmpty name="sort">
					<logic:equal name="sort" value="RK DESC">
						<option value="RK DESC" selected>전체</option>
					</logic:equal>
					<logic:notEqual name="sort" value="RK DESC">
						<option value="RK DESC">전체</option>
					</logic:notEqual>

					<logic:equal name="sort" value="IT DESC">
						<option value="IT DESC" selected>표제 내림차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="IT DESC">
						<option value="IT DESC">표제 내림차순</option>
					</logic:notEqual>

					<logic:equal name="sort" value="IT ASC">
						<option value="IT ASC" selected>표제 오름차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="IT ASC">
						<option value="IT ASC">표제 오름차순</option>
					</logic:notEqual>

					<logic:equal name="sort" value="IA DESC">
						<option value="IA DESC" selected>저자 내림차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="IA DESC">
						<option value="IA DESC">저자 내림차순</option>
					</logic:notEqual>

					<logic:equal name="sort" value="IA ASC">
						<option value="IA ASC" selected>저자 오름차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="IA ASC">
						<option value="IA ASC">저자 오름차순</option>
					</logic:notEqual>

					<logic:equal name="sort" value="IP DESC">
						<option value="IP DESC" selected>발행자 내림차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="IP DESC">
						<option value="IP DESC">발행자 내림차순</option>
					</logic:notEqual>


					<logic:equal name="sort" value="IP ASC">
						<option value="IP ASC" selected>발행자 오름차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="IP ASC">
						<option value="IP ASC">발행자 오름차순</option>
					</logic:notEqual>

					<logic:equal name="sort" value="YR DESC">
						<option value="YR DESC" selected>발행년  내림차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="YR DESC">
						<option value="YR DESC">발행년 내림차순</option>
					</logic:notEqual>

					<logic:equal name="sort" value="YR ASC">
						<option value="YR ASC" selected>발행년 오름차순</option>
					</logic:equal>
					<logic:notEqual name="sort" value="YR ASC">
						<option value="YR ASC">발행년 오름차순</option>
					</logic:notEqual>
				</logic:notEmpty>
			</logic:present>
				</select>
			<input type="hidden" name="mode" value="3">
			<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>">
			<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
			<input type="hidden" name="limitpage" value="<bean:write name="beforelimitpage"/>">
			<input type="hidden" name="startpage" value="<bean:write name="startpage"/>">
			</form>
		</td>
	</tr>
</table>
<form name="searchPage">
<table>
<tr>
<td class="table">
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
<tr >
<%if(Session.getAttribute("stand")!=null){%>
<logic:equal name="jong" value="jong">
<td class="field" align="center" width="5%">
<a href="javascript:SelectAll('searchPage')">선택</a>
</td>
</logic:equal>
<%}else{ %>
<!-- <td class="field" align="center" width="5%">
		선택
</td>-->
<%} %>
	<td class="field" align="center" width="5%">
		번호
	</td>
	<td class="field" align="center" width="20%">
		표제
	</td>
	<td class="field" align="center" width="10%">
		저자
	</td>
	<td class="field" align="center" width="10%">
		출판사
	</td>
	<td class="field" align="center" width="5%">
		발행년도
	</td>
	<td class="field" align="center" width="5%">
		자료실
	</td>
	<td class="field" align="center" width="10%">
		자료구분
	</td>
	<logic:equal name="jongbook" value="_book">
	<td class="field" align="center" width="10%">
		자료상태
	</td>
	<td class="field" align="center" width="5%">
		청구기호
	</td>
	</logic:equal>
	<td class="field" align="center" width="5%">
		목차
	</td>
	<td class="field" align="center" width="5%">
		초록
	</td>
</tr>
<logic:notEmpty name="search_result">
	<logic:iterate name="search_result" id="searchlistform">
		<logic:notEmpty name="searchlistform" property="offset">
		<tr width="350">
		<%if(Session.getAttribute("stand")!=null){%>
			<logic:equal name="jong" value="jong">
			<td class="view" align="center" width="5%">
			<input type="checkbox" name="basket<bean:write name="searchlistform" property="offset"/>" value="<bean:write name="searchlistform" property="reckey"/>"/>
			<input type="hidden" name="type<bean:write name="searchlistform" property="reckey"/>" value="<bean:write name="searchlistform" property="msa"/>"/>
			</td>
			</logic:equal>
		<%} %>
			<td class="view" align="center" width="5%">
				<bean:write name="searchlistform" property="offset"/>
			</td>
			<td class="view" align="center" width="20%">
				<a href="javascript:detailview('<bean:write name="searchlistform" property="offset"/>','<bean:write name="searchlistform" property="msa"/>','<bean:write name="searchlistform" property="book_code"/>')">
				<bean:write name="searchlistform" property="title_info"/></a>
			</td>
			<td class="view" align="center" width="10%">
				<bean:write name="searchlistform" property="author_info"/>
			</td>
			<td class="view" align="center" width="10%">
				<bean:write name="searchlistform" property="pub_info"/>
			</td>
			<td class="view" align="center" width="5%">
				<bean:write name="searchlistform" property="pub_year_info"/>
			</td>
			<td class="view" align="center" width="10%">
				<bean:write name="searchlistform" property="place_info"/>
			</td>
			<td class="view" align="center" width="10%">
				<bean:write name="searchlistform" property="userlevelinfo"/>
			</td>
			<logic:equal name="jongbook" value="_book">
			<td class="view" align="center" width="10%">
				<bean:write name="searchlistform" property="workingstatus"/>
			</td>
			<td class="view" align="center" width="10%">
				<bean:write name="searchlistform" property="calno_book"/>
			</td>
			</logic:equal>
			<td class="view" align="center" width="5%">
				<logic:equal name="searchlistform" property="contents_yn" value="Y">
					<a href="javascript:mokchaview('<bean:write name="searchlistform" property="msa"/>','<bean:write name="searchlistform" property="reckey"/>');"><img src="/kolas3/images/BookSearchImg/contents_ico.gif" border=0></a>
				</logic:equal>
			</td>
			<td class="view" align="center" width="5%">
				<logic:equal name="searchlistform" property="abstracts_yn" value="Y">
					<a href="javascript:chorokview('<bean:write name="searchlistform" property="msa"/>','<bean:write name="searchlistform" property="reckey"/>');"><img src="/kolas3/images/BookSearchImg/excerpt_ico.gif" border=0></a>
				</logic:equal>
			</td>
		</tr>
		</logic:notEmpty>
	</logic:iterate>
</logic:notEmpty>
</table>
</td>
</tr>
</table>
<input type=hidden name=loanableChk value=yes checked>
</form>
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
	<tr>
		<td align="center">
			<form name="pagemove" method="post" action="/kolas3/book.search_result.do" onSubmit="return false">
			<a href="javascript:firstmove();"><img src=/kolas3/images/BookSearchImg/icon_first.gif border=0 align="absbottom"></a>
			<a href="javascript:leftmove();"><img src=/kolas3/images/BookSearchImg/icon_prev.gif border=0 align="absbottom"></a>
			<a href="javascript:rightmove();"><img src=/kolas3/images/BookSearchImg/icon_next.gif border=0 align="absbottom"></a>
			<a href="javascript:lastmove();"><img src=/kolas3/images/BookSearchImg/icon_last.gif border=0 align="absbottom"></a>
			<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>">
			<input type="hidden" name="sort" value="<bean:write name="sort"/>">
			<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
			<input type="hidden" name="limitpage" value="<bean:write name="beforelimitpage"/>">
			&nbsp;
			<input size="2" type="text" name="startpage" value="<bean:write name="startpage"/>">

			/

			<bean:write name="resultcount" property="pagecount"/>페이지
			<a href="javascript:pagemove();"><image src=/kolas3/images/BookSearchImg/but_move.gif border=0 align="absbottom"></a>
			&nbsp;&nbsp;
			<%
			if(Session.getAttribute("stand")!=null){
			%>
			<logic:equal name="jong" value="jong">
			<a href="javascript:printReceip('<bean:write name="mat_class"/>','searchPage','<bean:write name="jong"/>');">청구기호출력</a>
			&nbsp;&nbsp;&nbsp;대출가능한 책만 출력합니다.
			</logic:equal>
			<%}else{ %>
			<!--
			<a href="javascript:mybook();">개인함</a>
			<a href="/kolas3/pb/main.jsp">개인함보기</a>-->
			<%} %>
			</form>
		</td>
	</tr>
</table>
<form name="firstmove" method="post" action="/kolas3/book.search_result.do">
<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="startpage" value="1">
<input type="hidden" name="limitpage" value="<bean:write name="beforelimitpage"/>">
</form>
<form name="lastmove" method="post" action="/kolas3/book.search_result.do">
<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="startpage" value="<bean:write name="resultcount" property="pagecount"/>">
<input type="hidden" name="limitpage" value="<bean:write name="beforelimitpage"/>">
</form>
<form name="rightmove" method="post" action="/kolas3/book.search_result.do">
<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="startpage" value="<bean:write name="rightstartpage"/>">
<input type="hidden" name="limitpage" value="<bean:write name="beforelimitpage"/>">
</form>
<form name="leftmove" method="post" action="/kolas3/book.search_result.do">
<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="startpage" value="<bean:write name="leftstartpage"/>">
<input type="hidden" name="limitpage" value="<bean:write name="beforelimitpage"/>">
</form>
<form name="detailview" method="post" action="/kolas3/book.detailview_result.do">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="msa">
<input type="hidden" name="offset">
<input type="hidden" name="maxoffset" value="<bean:write name="resultcount" property="resultcount"/>">
<input type="hidden" name="jongbook" value="<bean:write name="jongbook"/>">
<input type="hidden" name="historycount" value="0">
<input type="hidden" name="book_code">
<input type="hidden" name="p_type" value="pop">
</form>
<form name="mokchaview" method="post" action="/kolas3/book.mokchaview.do">
<input type="hidden" name="matcode">
<input type="hidden" name="reckey">
</form>
<form name="chorokview" method="post" action="/kolas3/book.chorokview.do">
<input type="hidden" name="matcode">
<input type="hidden" name="reckey">
</form>
<form name="receip" method="post">
<input type="hidden" name="mode">
<input type="hidden" name="rec_keyList">
<input type="hidden" name="db_typeList">
<input type="hidden" name="mat_class">
<input type="hidden" name="loanableChk">
<input type="hidden" name="show_method">
</form>
<form name="mybookform" method="post">
</form>


</div>
</div>