<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" src="/kolas3/script/search_script.js"></script>



<table width="552" height="68" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="10" height="7" align="left" valign="top"><img src="/kolas3/images/BookSearchImg/03img_left_01.gif" width="7" height="7"></td>
    <td width="538" height="7" valign="top" background="/kolas3/images/BookSearchImg/03img_flat.gif"></td>

    <td width="7" height="7" valign="top"><img src="/kolas3/images/BookSearchImg/03img_right_01.gif" width="7" height="7"></td>
  </tr>
  <tr>
    <td width="10" height="54" valign="top" background="/kolas3/images/BookSearchImg/03img_flat_left.gif"></td>
    <td valign="top"><table width="534" height="71" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="10" height="13">&nbsp;</td>
        <td width="511">&nbsp;</td>
        <td width="13">&nbsp;</td>

      </tr>
      <logic:iterate name="insertloan_result" id="result">
      <tr>
        <td height="42">&nbsp;</td>
        <td><span class="style8"><bean:write name="result"/></span></td>
        <td>&nbsp;</td>
      </tr>
      </logic:iterate>
      <tr>
        <td>&nbsp;</td>

        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    <td valign="top" background="/kolas3/images/BookSearchImg/03img_flat_right.gif"></td>
  </tr>
  <tr>
    <td width="10" height="7" valign="top"><img src="/kolas3/images/BookSearchImg/03img_left_02.gif" width="7" height="7"></td>
    <td height="7" valign="top" background="/kolas3/images/BookSearchImg/03img_flat_bottom.gif"></td>

    <td valign="top"><img src="/kolas3/images/BookSearchImg/03img_right_02.gif" width="7" height="7"></td>
  </tr>
</table>
<table width="549" height="24" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="7" colspan="2"></td>
  </tr>
  <tr>
    <td width="456">&nbsp;</td>
    <td width="93"><a href='/kolas3_01/LoanStatus.do'><img src="/kolas3/images/BookSearchImg/bu_d.gif" width="93" height="23"></a></td>

  </tr>
</table>


<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
