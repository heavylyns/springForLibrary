<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<%@page import="kolas3.common.login.SessionManager" %>
<%SessionManager Session = new SessionManager(request); %>


<%@page import="java.util.*" %>
<%@page import="kolas3.work.BookSearch.Form.*" %>

<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" src="/kolas3/script/search_script.js"></script>
<script language="JavaScript" src="/kolas3/script/receipMng.js"></script>




         <table width="700" border="0" cellspacing="0" cellpadding="0" border="1" >
         <tr>
         	<td align="left">
         		서지정보
         	</td>
         	<form name="marcview" method="post" action="/kolas3/book.marcview.do">
         	<td align="right">
				<a href="javascript:marcview('<bean:write name="detailviewmsa"/>','<logic:iterate name="detaillist" id="detaillist2" length="1">
				<bean:write name="detaillist2" property="value"/></logic:iterate>');"><image src=/kolas3/images/BookSearchImg/marc_ico_off.gif border=0 align="absbottom"></a>
				<input type="hidden" name="msa">
				<input type="hidden" name="reckey">
			</td>
			</form>
		</tr>
		</table>
<table>
<tr>
<td class="table">
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
<%
	ArrayList detaillist = (ArrayList)request.getAttribute("detaillist");
	for(int i=1; i<detaillist.size()-3;i++){
		DetailViewListForm detaillistform = new DetailViewListForm();
		detaillistform = (DetailViewListForm)detaillist.get(i);
		%>
		<tr>
		<td class="field" align="left" width="200">&nbsp;&nbsp;<%=detaillistform.getTitle()%></td>
		<td class="view2" align="left" width="500">&nbsp;&nbsp;<%=detaillistform.getValue()%></td>
		</tr>
		<%
	}

%>

</table>
</td>
</tr>
<tr>
<td class="white">&nbsp;
</td>
</tr>
<tr>
<td class="white">

<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
	<tr>
		<td align="left" class="white">
			소장정보
		</td>
	</tr>
</table>
</td>
</tr>
<tr>
<td class="table">
<logic:present name="detailviewmsa">
	<logic:notEmpty name="detailviewmsa">
		<logic:equal name="detailviewmsa" value="M">
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
<form name="insert_loan" method="post" action="/kolas3/book.insertloan.do">
<input type="hidden" name="msa" value="<bean:write name="detailviewmsa"/>">
<tr>
		<td class="field" align="center">
			선택
		</td>
		<td class="field" align="center">
			대출상태
		</td>
		<td class="field" align="center">
			청구기호
		</td><td class="field" align="center">
			반납예정일
		</td>
		<td class="field" align="center">
			등록번호
		</td>
		<td class="field" align="center">
			낱권정보
		</td>
		<td class="field" align="center">
			자료실
		</td>
		<td class="field" align="center">
			가격
		</td>
		<td class="field" align="center">
			매체구분
		</td>
	</tr>
<logic:iterate name="sojanglist" id="detailviewlistform" indexId="cnt">
	<tr>
	<logic:equal name="detailviewlistform" property="search_book" value="Y">
		<logic:equal name="detailviewlistform" property="loancheck" value="Y">
			<td class="view2" align="center"><input type="checkbox" name="selbook" value="<bean:write name="detailviewlistform" property="bookkey"/>"></td>
		</logic:equal>
		<logic:equal name="detailviewlistform" property="loancheck" value="N">
			<td class="view2" align="center"><input type="checkbox" name="selbook" value="<bean:write name="detailviewlistform" property="bookkey"/>" disabled></td>
		</logic:equal>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="workingstatus"/></td>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="chungubuho"/></td>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="returnplanday"/></td>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="reg_code"/></td>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="natgun"/></td>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="placeinfo"/></td>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="pay"/></td>
		<td class="orange" align="center"><bean:write name="detailviewlistform" property="matcode"/></td>
	</logic:equal>
	<logic:notEqual name="detailviewlistform" property="search_book" value="Y">
		<logic:equal name="detailviewlistform" property="loancheck" value="Y">
			<td class="view2" align="center">
			<input type="checkbox" name="selbook" value="<bean:write name="detailviewlistform" property="bookkey"/>">
			<input type="hidden" id="<bean:write name="detailviewlistform" property="bookkey"/>" value="<bean:write name="detailviewlistform" property="workingstatus"/>">
			</td>
		</logic:equal>
		<logic:equal name="detailviewlistform" property="loancheck" value="N">
			<td class="view2" align="center"><input type="checkbox" name="selbook" value="<bean:write name="detailviewlistform" property="bookkey"/>" disabled>
			<input type="hidden" id="<bean:write name="detailviewlistform" property="bookkey"/>" value="<bean:write name="detailviewlistform" property="workingstatus"/>">
			</td>
		</logic:equal>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="workingstatus"/></td>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="chungubuho"/></td>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="returnplanday"/></td>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="reg_code"/></td>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="natgun"/></td>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="placeinfo"/></td>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="pay"/></td>
		<td class="view2" align="center"><bean:write name="detailviewlistform" property="matcode"/></td>
	</logic:notEqual>
	</tr>
</logic:iterate>
</table>
</td>
</tr>
</table>
<input type=hidden name=loanableChk value=yes checked>
</form>
<table width="700" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center">
		<logic:present name="maxoffset">
			<logic:notEmpty name="maxoffset">
			<a href="javascript:detailview_first();"><img src=/kolas3/images/BookSearchImg/icon_first.gif border=0 align="absbottom"></a>
			<a href="javascript:detailview_left();"><img src=/kolas3/images/BookSearchImg/icon_prev.gif border=0 align="absbottom"></a>
			<a href="javascript:detailview_right();"><img src=/kolas3/images/BookSearchImg/icon_next.gif border=0 align="absbottom"></a>
			<a href="javascript:detailview_last();"><img src=/kolas3/images/BookSearchImg/icon_last.gif border=0 align="absbottom"></a>
		</logic:notEmpty>
		</logic:present>
		</td>
	</tr>
</table>
<br>
<table width="700" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center">
		<a href="javascript:insertloanfox();"><image src=/kolas3/images/BookSearchImg/search_bu_30.gif border=0 align="absbottom"></a>
		<a href="javascript:history.go(-<bean:write name="historycount"/>);"><image src=/kolas3/images/BookSearchImg/icon_prescreen.gif border=0 align="absbottom"></a>
		<%
		if(Session.getAttribute("stand")!=null){
			%>
			&nbsp;&nbsp;
			<a href="javascript:printReceip2('0','insert_loan','jong','<logic:iterate name="detaillist" id="detaillist2" length="1"><bean:write name="detaillist2" property="value"/></logic:iterate>','<bean:write name="detailviewmsa"/>');">청구기호출력</a>
			&nbsp;&nbsp;&nbsp;대출가능한 책만 출력합니다.
			<%}%>
		</td>
	</tr>
</table>
<br>
		</logic:equal>
<!--  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  -->
		<logic:notEqual name="detailviewmsa" value="M">
<table cellspacing=1 width=700 cellpadding = '0' border = '0' >
<tr>
		<td class="field" align="center">
			대출상태
		</td>
		<td class="field" align="center">
			권호
		</td>
		<td class="field" align="center">
			발행일
		</td>
		<td class="field" align="center">
			입수일
		</td>
		<td class="field" align="center">
			청구기호
		</td>
		<td class="field" align="center">
			등록번호
		</td>
		<td class="field" align="center">
			자료실
		</td>
		<td class="field" align="center">
			반납예정일
		</td>
	</tr>
<logic:iterate name="sojanglist" id="detailviewlistform">
	<tr>
		<logic:equal name="detailviewlistform" property="search_book" value="Y">
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="workingstatus"/></td>
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="gunhoname"/></td>
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="pubyear"/></td>
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="inputyear"/></td>
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="chungubuho"/></td>
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="recnum"/></td>
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="placeinfo"/></td>
			<td class="orange" align="center"><bean:write name="detailviewlistform" property="returnplanday"/></td>
		</logic:equal>
		<logic:notEqual name="detailviewlistform" property="search_book" value="Y">
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="workingstatus"/></td>
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="gunhoname"/></td>
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="pubyear"/></td>
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="inputyear"/></td>
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="chungubuho"/></td>
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="recnum"/></td>
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="placeinfo"/></td>
			<td class="view2" align="center"><bean:write name="detailviewlistform" property="returnplanday"/></td>
		</logic:notEqual>
	</tr>
</logic:iterate>
</table>
</td>
</tr>
</table>
<table width="700" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center">
		<logic:present name="maxoffset">
		<logic:notEmpty name="maxoffset">
			<a href="javascript:detailview_first();"><img src=/kolas3/images/BookSearchImg/icon_first.gif border=0 align="absbottom"></a>
			<a href="javascript:detailview_left();"><img src=/kolas3/images/BookSearchImg/icon_prev.gif border=0 align="absbottom"></a>
			<a href="javascript:detailview_right();"><img src=/kolas3/images/BookSearchImg/icon_next.gif border=0 align="absbottom"></a>
			<a href="javascript:detailview_last();"><img src=/kolas3/images/BookSearchImg/icon_last.gif border=0 align="absbottom"></a>
		</logic:notEmpty>
		</logic:present>
		</td>
	</tr>
</table>
<br>
<table width="700" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center">
			<a href="javascript:history.go(-<bean:write name="historycount"/>);"><image src=/kolas3/images/BookSearchImg/icon_prescreen.gif border=0 align="absbottom"></a>
		</td>
	</tr>
</table>

		</logic:notEqual>
	</logic:notEmpty>
</logic:present>
<logic:present name="maxoffset">
<logic:notEmpty name="maxoffset">
<form name="detailview_first" method="post" action="/kolas3/book.detailview_result.do">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="msa" value="<bean:write name="detailviewmsa"/>">
<input type="hidden" name="offset" value="1">
<input type="hidden" name="historycount" value="<bean:write name="historycount"/>">
</form>
<form name="detailview_last" method="post" action="/kolas3/book.detailview_result.do">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="msa" value="<bean:write name="detailviewmsa"/>">
<input type="hidden" name="offset" value="<bean:write name="maxoffset"/>">
<input type="hidden" name="historycount" value="<bean:write name="historycount"/>">
</form>
<form name="detailview_left" method="post" action="/kolas3/book.detailview_result.do">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="msa" value="<bean:write name="detailviewmsa"/>">
<input type="hidden" name="offset" value="<bean:write name="offset"/>">
<input type="hidden" name="historycount" value="<bean:write name="historycount"/>">
</form>
<form name="detailview_right" method="post" action="/kolas3/book.detailview_result.do">
<input type="hidden" name="sort" value="<bean:write name="sort"/>">
<input type="hidden" name="beforequery" value="<bean:write name="beforequery"/>">
<input type="hidden" name="msa" value="<bean:write name="detailviewmsa"/>">
<input type="hidden" name="offset" value="<bean:write name="offset"/>">
<input type="hidden" name="historycount" value="<bean:write name="historycount"/>">
</form>
</logic:notEmpty>
</logic:present>


<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
