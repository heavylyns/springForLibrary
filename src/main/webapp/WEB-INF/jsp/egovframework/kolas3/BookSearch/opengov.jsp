<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript" src="/kolas3/script/search_script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type=text/css href="/kolas3/css/main.css">
<title>기관부호검색</title>
</head>
<body>
<form name="searchgov" method="post" action="book.opengovsearch.do">
<table cellspacing=1 width=300 cellpadding=0 border=0 bgcolor=#CCCCBF>
	<tr>
		<td class='field' align='center'>
			검색어 입력
		</td>
		<td class='field' align='center'>
			<input type="text" name="govname">
		</td>
		<td class='field' align='center'>
			<a href="javascript:search_gov();"><img src="/kolas3/images/commonImg/but_search.gif" border=0></a>
		</td>
	</tr>
</table>
</form>
<logic:notEmpty name="search_result">
<table cellspacing=1 width=300 cellpadding=0 border=0 bgcolor=#CCCCBF>
	<tr>
		<td class='field' align='center'>
			기관
		</td>
	</tr>
	<logic:iterate name="search_result" id="govsearchlist">
		<tr>
			<td class='view' align='left'>&nbsp;&nbsp;
				<a href="javascript:select_gov('
				<bean:write name="govsearchlist" property="class_code"/>
				','<bean:write name="govsearchlist" property="description"/>')">
				<bean:write name="govsearchlist" property="class_code"/>
				<bean:write name="govsearchlist" property="description"/></a>
			</td>
		</tr>
	</logic:iterate>
</table>
</logic:notEmpty>
<table width=300  cellspacing ='1'>
    <tr>
      <td width=300 align=center>
            <a href="JavaScript:self.close()"><img src="/kolas3/images/BookSearchImg/button_close.gif" border=0></a>
      </td>
    </tr>
</table>
</body>
</html>