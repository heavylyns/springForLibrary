<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>




<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/search_script.js" charset="utf-8"></script>

<script type="text/javascript" language="javascript">
window.onload=function() {
	changeDate(3);
}
</script>




		<form name=search method="post" action="/kolas3/book.search_result.do" >

<input type="hidden" name="sort" value="RK DESC">
<input type="hidden" name="startpage" value="1">
<input type="hidden" name="mode" value="1">
<input type="hidden" name="limitpage" value="10">
<input type="hidden" name="jongbook" value="new">
<table>
	<tr>
		<td class=table>
			<table cellspacing=1 border=0 cellpadding=0 >
              <tr>
                 <td class=field width=100 align=center rowspan=2>검색일자 </td>
                 <td class=view width=598 height=26>
                       &nbsp;&nbsp;<input type=text name=new_start value="2008/08/23" size=10 maxlength=10 onFocus="JavaScript:Change(1)" onBlur="JavaScript:recover(1)">&nbsp;&nbsp;부터&nbsp;&nbsp;
                       현재까지&nbsp;&nbsp;(입력형식 : yyyymmdd 예:19990101)
               </td>
              </tr>
              <tr>
                  <td class=view width=500 height=26>&nbsp;
                    <input type=radio name=date value=1 onClick="JavaScript:changeDate(1)" >1주&nbsp;&nbsp;
                    <input type=radio name=date value=2 onClick="JavaScript:changeDate(2)">2주&nbsp;&nbsp;
                    <input type=radio checked name=date value=3 onClick="JavaScript:changeDate(3)">1달&nbsp;&nbsp;
                    <input type=radio name=date value=4 onClick="JavaScript:changeDate(4)">2달&nbsp;&nbsp;
                    <input type=radio name=date value=5 onClick="JavaScript:changeDate(5)">3달&nbsp;&nbsp;
                  </td>
              </tr>
	      <tr>
		  <td class=field align=center height=26>자료실</td>
		  <td class=view>&nbsp;
			 <select name=local>
				<option value="">적용안함</option>
				<logic:notEmpty name="search_result">
					<logic:iterate name="search_result" id="placesearchlist">
						<option value="<bean:write name="placesearchlist" property="code"/>">
						<bean:write name="placesearchlist" property="description"/></option>
					</logic:iterate>
				</logic:notEmpty>
			</select>
		   </td>
		    </tr>
				      <tr>
					  <td class=field align=center height=26>등록구분</td>
					  <td class=view>&nbsp;
						<select name=reg_code >
							<OPTION value="">적용안함</OPTION>
							<OPTION value="AA">AA(EM딸림자료1)</OPTION>
						<OPTION value="AB">AB(EM딸림자료2)</OPTION>
						<OPTION value="AC">AC(EM딸림자료3)</OPTION>
						<OPTION value="AD">AD(EM딸림자료4)</OPTION>
						<OPTION value="AE">AE(EM딸림자료5)</OPTION>
						<OPTION value="AF">AF(EM딸림자료6)</OPTION>
						<OPTION value="AG">AG(EM딸림자료7)</OPTION>
						<OPTION value="AH">AH(EM딸림자료8)</OPTION>
						<OPTION value="AI">AI(EM딸림자료9)</OPTION>
						<OPTION value="AJ">AJ(EM딸림자료10)</OPTION>
						<OPTION value="AK">AK(EM딸림자료11)</OPTION>
						<OPTION value="AL">AL(EM딸림자료12)</OPTION>
						<OPTION value="AM">AM(EM딸림자료13)</OPTION>
						<OPTION value="AN">AN(EM딸림자료14)</OPTION>
						<OPTION value="AO">AO(EM딸림자료15)</OPTION>
						<OPTION value="AP">AP(EM딸림자료)</OPTION>
						<OPTION value="AQ">AQ(EM딸림자료16)</OPTION>
						<OPTION value="AR">AR(EM딸림자료17)</OPTION>
						<OPTION value="BA">BA(BM딸림자료1)</OPTION>
						<OPTION value="BB">BB(BM딸림자료2)</OPTION>
						<OPTION value="BC">BC(BM딸림자료3)</OPTION>
						<OPTION value="BD">BD(BM딸림자료4)</OPTION>
						<OPTION value="BM">BM(이동)</OPTION>
						<OPTION value="BS">BS(BM딸림자료)</OPTION>
						<OPTION value="CA">CA(JC딸림자료1)</OPTION>
						<OPTION value="CB">CB(JC딸림자료2)</OPTION>
						<OPTION value="CC">CC(JC딸림자료3)</OPTION>
						<OPTION value="CD">CD(JC딸림자료4)</OPTION>
						<OPTION value="CE">CE(JC딸림자료5)</OPTION>
						<OPTION value="CM">CM(관외대출실)</OPTION>
						<OPTION value="CS">CS(JC딸림자료)</OPTION>
						<OPTION value="EM">EM(관내)</OPTION>
						<OPTION value="GA">GA(GE딸림자료1)</OPTION>
						<OPTION value="GB">GB(GE딸림자료2)</OPTION>
						<OPTION value="GC">GC(GE딸림자료3)</OPTION>
						<OPTION value="GD">GD(GE딸림자료4)</OPTION>
						<OPTION value="GE">GE(족보)</OPTION>
						<OPTION value="GS">GS(GE딸림자료)</OPTION>
						<OPTION value="HD">가등록(논문자료)</OPTION>
						<OPTION value="HG">가등록(교육감자료)</OPTION>
						<OPTION value="HM">한책읽기용도서</OPTION>
						<OPTION value="JA">JA(JU딸림자료1)</OPTION>
						<OPTION value="JB">JB(JU딸림자료2)</OPTION>
						<OPTION value="JC">JC(이동어린이)</OPTION>
						<OPTION value="JD">JD(JU딸림자료3)</OPTION>
						<OPTION value="JE">JE(JU딸림자료4)</OPTION>
						<OPTION value="JF">JF(JU딸림자료5)</OPTION>
						<OPTION value="JG">JG(JU딸림자료6)</OPTION>
						<OPTION value="JS">JS(JU딸림자료)</OPTION>
						<OPTION value="JU">JU(어린이)</OPTION>
						<OPTION value="KA">KA(NB딸림자료1)</OPTION>
						<OPTION value="KB">KB(NB딸림자료2)</OPTION>
						<OPTION value="KC">KC(NB딸림자료3)</OPTION>
						<OPTION value="KD">KD(NB딸림자료4)</OPTION>
						<OPTION value="KE">KE(NB딸림자료5)</OPTION>
						<OPTION value="KF">KF(NB딸림자료6)</OPTION>
						<OPTION value="KG">KG(NB딸림자료7)</OPTION>
						<OPTION value="KP">KP(NB딸림자료)</OPTION>
						<OPTION value="NB">NB(비도서)</OPTION>
						<OPTION value="PE">PE(연속간행물)</OPTION>
						<OPTION value="PL">PL(제본도서)</OPTION>
						<OPTION value="SA">SA(CM딸림자료1)</OPTION>
						<OPTION value="SB">SB(CM딸림자료2)</OPTION>
						<OPTION value="SC">SC(CM딸림자료3)</OPTION>
						<OPTION value="SD">SD(CM딸림자료4)</OPTION>
						<OPTION value="SE">SE(CM딸림자료5)</OPTION>
						<OPTION value="SF">SF(CM딸림자료6)</OPTION>
						<OPTION value="SG">SG(CM딸림자료7)</OPTION>
						<OPTION value="SH">SH(CM딸림자료8)</OPTION>
						<OPTION value="SI">SI(CM딸림자료9)</OPTION>
						<OPTION value="SJ">SJ(CM딸림자료10)</OPTION>
						<OPTION value="SK">SK(CM딸림자료11)</OPTION>
						<OPTION value="SL">SL(CM딸림자료12)</OPTION>
						<OPTION value="SM">SM(CM딸림자료13)</OPTION>
						<OPTION value="SN">SN(CM딸림자료14)</OPTION>
						<OPTION value="SO">SO(CM딸림자료15)</OPTION>
						<OPTION value="SP">SP(CM딸림자료)</OPTION>
					 	</select>
		   </td>
	    </tr>
	      <tr>
		  <td class=field align=center height=26>분류기호(KDC)</td>
		  <td class=view>&nbsp;
			<select name=ten_new >
				<OPTION value="">적용안함</OPTION>
				<OPTION value="0">총류</OPTION>
				<OPTION value="1">철학</OPTION>
				<OPTION value="2">종교</OPTION>
				<OPTION value="3">사회과학</OPTION>
				<OPTION value="4">순수과학</OPTION>
				<OPTION value="5">기술과학</OPTION>
				<OPTION value="6">예술</OPTION>
				<OPTION value="7">언어</OPTION>
				<OPTION value="8">문학</OPTION>
				<OPTION value="9">역사</OPTION>
		 	</select>
		   </td>
	    </tr>
           </table>
		</td>
	</tr>
</table>
<br>
  <table cellspacing=0 cellpadding=0 width=700>
    <tr>
      <td align=right>
        <input type=image src=/kolas3/images/commonImg/but_search.gif border=0>
      </td>
    </tr>
  </table>
    <%
if(request.getParameter("manage_code")!=null){
String mange_code=request.getParameter("manage_code");
%>
<input type="hidden" name="mgc" value="<%=mange_code%>">
<%}%>
 </form>


<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>


