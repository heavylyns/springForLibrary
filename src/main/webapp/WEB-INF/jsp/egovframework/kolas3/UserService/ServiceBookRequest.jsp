<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<%@page import="kolas3.common.login.*" %>
<%
	SessionManager Session = new SessionManager(request);
	String user_manage = (String)Session.getAttribute("USER_MANAGE");
	String book_manage = (String)Session.getAttribute("BOOK_MANAGE");
	if(book_manage!=null  && !book_manage.replaceAll(" ","").equals("")){
		user_manage=book_manage;
	}
%>
<!--

파일명   : ServiceBookRequest.jsp
기능설명: 비치희망 조회를 위한 회원 정보 출력 및 사용자 도서신청 데이터 입력 페이지(회원조회, 신청인, 희망도서, 추천 의견)
작성일   : 2008년/ 08월 20일
작성자   : 개발3부 해외사업팀 신영준

 -->

<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/service.js" charset="utf-8"></script>
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/swap.js" charset="utf-8"></script>

<form action="/kolas3/user.BookRequest.do" method="post" focus="applicant_name" id="LoanRequestForm" name="LoanRequestForm">


	<table width="700" border="0" cellspacing="0" cellpadding="0">

     <tr>
         <td height="250" valign="top">
			<table border="0" cellspacing="0" cellpadding="0" >
			   <tr>
    	 		  <td colspan=3 height=11></td>
			    </tr>
				<tr>
			       <td align=left><img src="/kolas3/images/UserServiceImg/tab_01_on.gif" border="0"></td>
			       <td align=left><a href="/kolas3/user.RequestListBook.do" onFocus='this.blur()'><img src="/kolas3/images/UserServiceImg/tab_02_off.gif" name="menu2_sub_02" border="0" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('menu2_sub_02','','/kolas3/images/UserServiceImg/tab_02_on.gif',1)"></a>
			      	</td>


				</tr>
		    </table>
			  <input type=hidden name=memchk value=0>
		   <table  cellpadding=4 cellspacing=0 border=0>
    		<tr>
        	  <td colspan=4 align=right> √표가 있는 항목은 필수 항목이므로 반드시 입력하여 주십시오.</td>
    		</tr>
		</table>
		<table  border=0 cellpadding=0 cellspacing=0 >
			<tr>
				<td class=table>
        			<table cellspacing=1 border=0 cellpadding=3>
					    <tr>
							<td class=field height=25 width=110 align=center>신청일자</td>
							<td class=view width=190 align="center"><bean:write name="LoanRequestForm"  property="request_date"/></td>
							<td class=view colspan ='3'>&nbsp;<!--
							<a href="JavaScript:member_chk()"><img src="/kolas3/images/commonImg/but_search_member.gif" border=0 align=absbottom></a></td>
					     -->

					   </tr>
					<tr>
						<td class=field width=110 align=center>신 청 자 √</td>
						<td class=view colspan ='3'><input class=box type='text' name='applicant_name' value='<bean:write name="LoanRequestForm"  property="applicant_name"/>'>
							<input type='hidden' name='civil_no_first' value='<bean:write name="LoanRequestForm"  property="civil_no_first"/>'>
							<input type='hidden' name='civil_no_second' value='<bean:write name="LoanRequestForm"  property="civil_no_second"/>'>
							<input type='hidden' name='civil_no_result' value='<bean:write name="LoanRequestForm"  property="civil_no_result"/>'>
						</td>

				   </tr>
					<tr>
						<td class='field' align='center'>우편번호 </td>
						<td class=view colspan ='3'><input class=box type="text" name="zip1" size="3" value='<bean:write name="LoanRequestForm"  property="zip1"/>' onclick="JavaScript:zip_chk('Request');" readonly> - <input class=box type="text" name="zip2" size="3" value='<bean:write name="LoanRequestForm"  property="zip2"/>' onclick="JavaScript:zip_chk('Request');" readonly>&nbsp;<a href="JavaScript:zip_chk('Request')"><img src="/kolas3/images/commonImg/but_search.gif" border=0 align=absbottom></a></td>
					</tr>
					<tr>
						<td class='field' align='center'>주소 </td>
						<td class=view colspan ='3'><input class=box type='text' size=60 name='address1' value='<bean:write name="LoanRequestForm"  property="address1"/>'></td>
					</tr>
					<tr>
						<td class='field' align='center'>전화번호 √</td>
						<td class=view><input class=box type='text' name='tel' value='<bean:write name="LoanRequestForm"  property="tel"/>'></td>
						<td class='field' align='center'>E-Mail √</td>
						<td class=view><input class=box size=22 type='text' name='e_mail' value='<bean:write name="LoanRequestForm"  property="e_mail"/>'></td>
					</tr>
					<tr>
						<td class='field' align='center'>핸드폰번호 </td>
						<td class=view colspan ='3'><input class=box type='text' name='hp_no' value='<bean:write name="LoanRequestForm"  property="hp_no"/>'></td>

					</tr>
					<tr>
						<td class='field' align='center'>SMS수신여부 </td>
						<td class=view><input size=22 type='checkbox' name='sms_yn' value='Y' checked ></td>
						<td class='field' align='center'>우선예약신청 </td>
						<td class=view><input size=22 type='checkbox' name='reservation_yn' value='Y' checked ></td>
					</tr>
					<tr>
						<td height=10 colspan=4 class=view2>&nbsp;</td>
					</tr>
					<tr>
						<td class='field' align='center'>희망도서명 √</td>
						<td class=view colspan ='3'><input class=box type='text' size=56 name='title'></td>
					</tr>
					<tr>
						<td class='field' align='center' >저작자</td>
						<td class=view colspan ='3'><input class=box type='text' name='author'></td>
						<!-- <td class='field' align='center' >관리구분</td>
						<td class=view>
						<select name="mgc">
						<%//if(user_manage.equals("MC")){%>
							<option value="MC" selected>MC</option>
						<%//}else{%>
							<option value="MC">MC</option>
						<%//}	%>
						<%//if(user_manage.equals("MA")){%>
							<option value="MA" selected>MA</option>
						<%//}else{%>
							<option value="MA">MC</option>
						<%//}%>
						</select>
						</td>-->
						<input type="hidden" name="mgc" value="<%=user_manage %>">
            		</tr>
					<tr>
						<td class='field' align='center'>출판사</td>
						<td class=view><input class=box type='text' name='publisher'></td>
						<td class='field' align='center'>출판년</td>
						<td class=view><input class=box size=16 type='text' name='publisher_date' size=4 maxlength=4></td>
					</tr>
					<tr>
						<td class='field' align='center'>추천의견<br>(최대100자)</td>
						<td class=view colspan ='3'><textarea cols=65 rows=4 name='recom_opinion' class=box1></textarea>
					</td>
				</tr>
	         </table>
          </td>
       </tr>
    </table><p>

    <table width=600>
    	<tr align=center>
        	<td colspan=4>여러명이 사용하는 PC의 경우에는 개인정보 보호를 위하여 <br>사용 후에는 반드시 브라우저를 종료하여 주십시오.</td>
   	 	</tr>
	</table><p>
	<table width=600>
    	<tr align=right>
        	<td colspan=2><a href='JavaScript:vdate_bookrequest()'><img src='/kolas3/images/commonImg/icon_submit.gif' border=0></a></td>
	        <td colspan=2 align="left"><a href='JavaScript:canc_click()'><img src='/kolas3/images/commonImg/icon_cancel.gif' border=0></a></td>
    	</tr>
	</table>
                </td>
              </tr>
            </table>
        </form>



<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
