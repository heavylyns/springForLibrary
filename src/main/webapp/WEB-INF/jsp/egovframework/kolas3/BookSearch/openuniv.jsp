<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript" src="/kolas3/script/search_script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type=text/css href="/kolas3/css/main.css">
<title>대학부호검색</title>
</head>
<body>
<form name="searchuniv" method="post" action="book.openunivsearch.do">
<table cellspacing=1 width=300 cellpadding=0 border=0 bgcolor=#CCCCBF>
	<tr>
		<td class='field' align='center'>
			검색어 입력
		</td>
		<td class='field' align='center'>
			<input type="text" name="univname">
		</td>
		<td class='field' align='center'>
			<a href="javascript:search_univ();"><img src="/kolas3/images/commonImg/but_search.gif" border=0></a>
		</td>
	</tr>
</table>
</form>
<logic:notEmpty name="search_result">
<table cellspacing=1 width=300 cellpadding=0 border=0 bgcolor=#CCCCBF>
	<tr>
		<td class='field' align='center'>
			학교
		</td>
	</tr>
	<logic:iterate name="search_result" id="univsearchlist">
		<tr>
			<td class='view' align='left'>&nbsp;&nbsp;
				<a href="javascript:select_univ('
				<bean:write name="univsearchlist" property="class_code"/>
				','<bean:write name="univsearchlist" property="description"/>')">
				<bean:write name="univsearchlist" property="class_code"/>
				<bean:write name="univsearchlist" property="description"/></a>
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