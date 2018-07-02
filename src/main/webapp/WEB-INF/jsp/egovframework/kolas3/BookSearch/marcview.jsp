<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript" src="/kolas3/script/search_script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type=text/css href="/kolas3/css/main.css">
<title>Insert title here</title>
</head>
<body>
<table width=600  cellspacing=1 bgcolor=#CCCCBF>
	<tr>
		<td width=14% class=field align=center>
			리더
		</td>
		<td width=86% class=view>&nbsp;&nbsp;
			<logic:notEmpty name="search_result">
				<logic:iterate name="search_result" id="marcviewlist" length="1">
				<bean:write name="marcviewlist" property="value"/><br>
				</logic:iterate>
			</logic:notEmpty>
		</td>
	</tr>
</table>
<table width=600  cellspacing=1 bgcolor=#CCCCBF>
	<tr>
		<td width=7% class=field align=center>TAG</td>
		<td width=7% class=field align=center>IND</td>
		<td width=86% class=field align=center>내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</td>
	</tr>
	<logic:notEmpty name="search_result">
	<logic:iterate name="search_result" id="marcviewlist" offset="1">
		<tr>
				<td class=view align=center><bean:write name="marcviewlist" property="tag"/></td>
				<td class=view align=center><bean:write name="marcviewlist" property="ind"/></td>
				<td class=view>&nbsp;&nbsp;<bean:write name="marcviewlist" property="value"/></td>
		</tr>
	</logic:iterate>
</logic:notEmpty>
</table>
<table width=600  cellspacing ='1'>
    <tr>
      <td width=600 align=center>
            <a href="JavaScript:self.close()"><img src="/kolas3/images/BookSearchImg/button_close.gif" border=0></a>
      </td>
    </tr>
</table>
</body>
</html>



