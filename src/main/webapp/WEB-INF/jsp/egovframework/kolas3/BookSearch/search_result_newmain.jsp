<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/search_script.js" charset="utf-8"></script>


<logic:notEmpty name="search_result">
	<logic:iterate name="search_result" id="searchlistform" offset="1" length="4">
<table>
<tr>
	<td height=15 valign=bottom class=intro3>
	<bean:write name="searchlistform" property="title_info"/>
	</td>
</tr>
</table>
</logic:iterate>
</logic:notEmpty>


<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
