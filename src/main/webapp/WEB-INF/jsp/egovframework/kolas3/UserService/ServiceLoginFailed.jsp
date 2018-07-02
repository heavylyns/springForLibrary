<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/service.js" charset="utf-8"></script>
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/swap.js" charset="utf-8"></script>



<table width="700" border="0" cellspacing="0" cellpadding="0">
   <tr>
    <td height="250" valign="top">
      <table width=600 border=0 cellspacing=0 cellpadding=0>
        <tr>
         <td height=20>&nbsp;</td></tr><tr><td align=center><br><br><br><br><br><br>
          <table width=259 height=160 border=0 cellspacing=1 cellpadding=4>
            <!-- 사용자 ID / PASSWORD 입력 로그인 방식일 경우 -->
		<logic:present name="LoginForm">
             <logic:equal name="LoginForm" property="login_flag" value="USER_ID">
               <tr>
                <td class=view2 align=center width=259 height=160 background="/kolas3/images/UserServiceImg/book_loan_bgimage02.gif"><br><br><font color=blue><bean:write name="LoginForm" property="user_id"/></font> 와 일치하는<br> 사용자ID가 없습니다.!!<br><br>
                  <table width=259 border=0 cellspacing=1 cellpadding=4>
                    <tr>
                      <td align=center height=25><a href=javascript:history.go(-1)><img src="/kolas3/images/commonImg/icon_prescreen.gif"  border="0"></a></td>
                    </tr>
                 </table>
               </td>
             </tr>
           </logic:equal>

            <!-- 대출자 번호 입력 로그인 방식일 경우 -->

           <logic:equal name="LoginForm" property="login_flag" value="USER_NO">
             <tr>
               <td class=view2 align=center width=259 height=160 background="/kolas3/images/UserServiceImg/book_loan_bgimage02.gif"><br><br><font color=blue><bean:write name="LoginForm" property="user_no"/></font> 과 일치하는<br> 대출자번호가 없습니다.!!<br><br>
                 <table width=259 border=0 cellspacing=1 cellpadding=4>
                   <tr>
                     <td align=center height=25><a href=javascript:history.go(-1)><img src="/kolas3/images/commonImg/icon_prescreen.gif"  border="0"></a></td>
                   </tr>
                </table>
               </td>
             </tr>
           </logic:equal>
           <!-- 카드비번 입력 로그인 방식일 경우 -->

           <logic:equal name="LoginForm" property="login_flag" value="USER_CARD">
             <tr>
               <td class=view2 align=center width=259 height=160 background="/kolas3/images/UserServiceImg/book_loan_bgimage02.gif"><br><br><font color=blue><bean:write name="LoginForm" property="user_no"/></font> 과 일치하는<br> 대출자번호가 없습니다.!!<br><br>
                 <table width=259 border=0 cellspacing=1 cellpadding=4>
                   <tr>
                     <td align=center height=25><a href=javascript:history.go(-1)><img src="/kolas3/images/commonImg/icon_prescreen.gif"  border="0"></a></td>
                   </tr>
                </table>
               </td>
             </tr>
           </logic:equal>
		</logic:present>
		<logic:empty name="LoginForm">
             <tr>
               <td class=view2 align=center width=259 height=160 background="/kolas3/images/UserServiceImg/book_loan_bgimage02.gif"><br><br><font color=blue></font> 대출자 번호를 입력 하세요.<br><br>
                 <table width=259 border=0 cellspacing=1 cellpadding=4>
                   <tr>
                     <td align=center height=25><a href=javascript:history.go(-1)><img src="/kolas3/images/commonImg/icon_prescreen.gif"  border="0"></a></td>
                   </tr>
                </table>
               </td>
             </tr>
		</logic:empty>
         </table>
        </td>
      </tr>
     </table>
    </td>
   </tr>
  </table>




<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
