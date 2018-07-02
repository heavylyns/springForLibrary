<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<%
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
response.setHeader("Cache-Control","no-cache");

%>

<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/service.js" charset="utf-8"></script>
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/swap.js" charset="utf-8"></script>


	<table width="700" border="0" cellspacing="0" cellpadding="0">
      <tr>
 <td height="250" valign="top">
   <form method="post" name="LoanDelayForm" >
      <table border ='0' cellspacing =0 cellpadding ='0'>
       <tr>
 	     <td>
           <table width = 700 border ='0' cellspacing ='0' cellpadding ='0'>
             <tr>
             	<!-- 대출 등급 여부에 따라 불량회원 제적회원을 결정한다. -->
			    <logic:present name="STOP_USER">
			      <logic:notEmpty name="STOP_USER">
			       <tr>
				    <td colspan="2" ><img src="/kolas3/images/UserServiceImg/bu_arrow.gif"><strong><font  color="blue"><%=request.getAttribute("STOP_USER") %></font></strong></td>
				   </tr>
				  </logic:notEmpty>
				</logic:present>

				<logic:equal name="LoanStatusForm"  property="inferior_class"  value="2">
		    	  <tr>
		    		<td colspan="2" ><img src="/kolas3/images/UserServiceImg/bu_arrow.gif"><strong><font  color="blue"><bean:write name="LoanStatusForm" property="error_code"/></font></strong></td>
				  </tr>
				</logic:equal>

				<logic:present name="USER_MESSAGE">
		 	      <logic:notEmpty name="USER_MESSAGE">
		           <tr>
		             <td colspan="2" ><strong><font  color="blue"><%= (String)request.getAttribute("USER_MESSAGE") %></font></strong><br><br><br></td>
		           </tr>
		          </logic:notEmpty>
		        </logic:present>




		        <tr >
		          <td valign=bottom >
		             <table width = 700 border ='0' cellspacing ='0' cellpadding ='0'>
		               <tr>
		                 <logic:present name="COUNT_MESSAGE">
		 	               <logic:notEmpty name="COUNT_MESSAGE">
		                     <td ><%=request.getAttribute("COUNT_MESSAGE") %>&nbsp;&nbsp;</td>
		                  </logic:notEmpty>
		                </logic:present>
						 <td align=right bgcolor=white>
		                       <a href='JavaScript:list_delay();'><img src="/kolas3/images/UserServiceImg/bu_ab.gif" border="0"></a>
		                       <html:link action="/kolas3/user.Logout.do"><img src="/kolas3/images/UserServiceImg/bu_ad.gif" border="0"></html:link>
                         </td>
		               </tr>
		               <tr >
		                 <td colspan="2">&nbsp; </td>
		               </tr>
		            </table>


             <tr>
             <td colspan="2"  bgcolor=black>
 	            <table width = 700 border ='0' cellspacing ='1' cellpadding ='1'>
 	             <tr class=table height="34" >
			 	 	<td align=center class="field" width="310">서명</td>
					<td align=center class="field" width="60">낱권정보</td>


				<!--  예약기능사용여 "Y" 일경우 "예약일/<br>대출일" 항목 출력  그렇지 않을 경우 "대출일" 항목 출력  -->
				<!-- 예약기능사용여부 "Y" 일경우 "예약만기일/<br>반납예정일" 항목 출력 그렇지 않을 경우 "반납예정일" 항목출력 -->

					<td align=center class="field" width="75">대출일</td>
					<td align=center class="field" width="75">반납예정일</td>
					<td align=center class="field" width="40">연체<br>일수</td>


				<!--  예약기능사용여부 "Y" 일경우 "상태(순번)" 항목출력 그렇지 않을 경우 "상태" 항목 출력 -->

				<logic:equal name="LoanStatusForm"  property="use_reserv"  value="Y">
					<td align=center class="field" width="60">상태(순번)</td>
				</logic:equal>

				<logic:notEqual name="LoanStatusForm"  property="use_reserv"  value="Y">
					<td align=center class="field" width="60">상태</td>
				</logic:notEqual>


				<!-- 반납연기 사용여부 "Y" 일경우 "취소" 항목  + "연기" 항목설정  그렇지 않을 경우 "취소" 항목설정 -->

					<td align=center class='field' width="40">취소</td>
					<td align=center class='field' width="40">연기</td>

              </tr>


              <!-- 대출 현황목록 데이터가 없을 경우 -->

              <logic:present name="LoanStatusList" >
                <logic:empty name="LoanStatusList">
              		<tr height=25 bgcolor=white><td colspan=15 align=center>등록된 자료가 없습니다.</td></tr>
              	</logic:empty>

              <!-- 대출 현황목록 데이터가 존재할  경우 -->

              	<logic:notEmpty name="LoanStatusList">
              	  <logic:iterate name="LoanStatusList"  id="LoanStatusForm" >

              		<!--  서명  -->
              		<tr height=25 bgcolor="white">
              			<td><bean:write name="LoanStatusForm" property="title" /></td>
              			<td align=center><bean:write name="LoanStatusForm" property="vol" /></td>

              		<!-- 예약사용할 경우 예약일  -->
              		 <logic:equal name="LoanStatusForm" property="status" value="예약중">
              			<td align=center><bean:write name="LoanStatusForm" property="reservation_date" /></td>
              		</logic:equal>

              		<!-- 예약사용하지 않을 경우 대출일  -->
              		<logic:notEqual name="LoanStatusForm" property="status" value="예약중">
              			<td align=center><bean:write name="LoanStatusForm" property="loan_date" /></td>
              		</logic:notEqual>

              		<!-- 예약사용할 경우 예약만기일  -->
              		 <logic:equal name="LoanStatusForm" property="status" value="예약중">
              			<td align=center><bean:write name="LoanStatusForm" property="reservation_expire_date" /></td>
              		</logic:equal>

              		<!-- 예약사용하지 않을 경우 반납예정일  -->
              		<logic:notEqual name="LoanStatusForm" property="status" value="예약중">
              			<td align=center><bean:write name="LoanStatusForm" property="return_plan_date" /></td>
              		</logic:notEqual>

              			<!--  연체일수  -->
              			<td align=center><bean:write name="LoanStatusForm" property="delay_date" /></td>

              			<!--  대출상태  -->
              			<td align=center><bean:write name="LoanStatusForm" property="status" /></td>

              		<logic:equal name="LoanStatusForm" property="status" value="예약중">
              			<td align=center><input type=checkbox name='reserv_ca' value="<bean:write name="LoanStatusForm" property="coloan_reckey"/>"></td>
              			<td align=center></td>
              		</logic:equal>

              		<logic:notEqual name="LoanStatusForm" property="status" value="예약중">
              			<td align=center></td>
              		</logic:notEqual>

              		<logic:equal name="LoanStatusForm" property="use_delay" value="Y">
              		  <logic:equal name="LoanStatusForm" property="inferior_class" value="0">
              		    <logic:lessEqual name="LoanStatusForm" property="delay_date" value="0">
              		       <logic:equal name="LoanStatusForm" property="loan_manage_code" value="">
              		         <logic:equal name="LoanStatusForm" property="status" value="대출중">
              		         <logic:equal name="LoanStatusForm" property="todaydelaycheck" value="Y">
              		           <td align=center><input type=checkbox name='delay_ca' value="<bean:write name="LoanStatusForm" property="coloan_reckey"/>"></td>
                           	</logic:equal>
                           	<logic:notEqual name="LoanStatusForm" property="todaydelaycheck" value="Y">
                           	<td align=center></td>
                           	</logic:notEqual>
                            </logic:equal>
                          </logic:equal>
                        </logic:lessEqual>
                     </logic:equal>
                    </logic:equal>

                    <logic:equal name="LoanStatusForm" property="use_delay" value="Y">
              		  <logic:equal name="LoanStatusForm" property="inferior_class" value="0">
              		    <logic:greaterEqual name="LoanStatusForm" property="delay_date" value="1">
              		       <logic:equal name="LoanStatusForm" property="loan_manage_code" value="">
              		         <logic:equal name="LoanStatusForm" property="status" value="대출중">
              		           <td align=center></td>
                            </logic:equal>
                          </logic:equal>
                        </logic:greaterEqual>
                     </logic:equal>
                    </logic:equal>

                    <logic:equal name="LoanStatusForm" property="use_delay" value="Y">
              		  <logic:equal name="LoanStatusForm" property="inferior_class" value="0">
              		    <logic:lessEqual name="LoanStatusForm" property="delay_date" value="0">
              		       <logic:equal name="LoanStatusForm" property="loan_manage_code" value="">
              		         <logic:equal name="LoanStatusForm" property="status" value="반납연기">
              		           <td align=center><input type=checkbox name='delay_ca' value="<bean:write name="LoanStatusForm" property="coloan_reckey"/>"></td>
                            </logic:equal>
                          </logic:equal>
                        </logic:lessEqual>
                     </logic:equal>
                    </logic:equal>

                    <logic:equal name="LoanStatusForm" property="use_delay" value="Y">
              		  <logic:equal name="LoanStatusForm" property="inferior_class" value="0">
              		    <logic:greaterEqual name="LoanStatusForm" property="delay_date" value="1">
              		       <logic:equal name="LoanStatusForm" property="loan_manage_code" value="">
              		         <logic:equal name="LoanStatusForm" property="status" value="반납연기">
              		           <td align=center></td>
                            </logic:equal>
                          </logic:equal>
                        </logic:greaterEqual>
                     </logic:equal>
                    </logic:equal>



                    <logic:notEqual name="LoanStatusForm" property="use_delay" value="Y">
              		    <td align=center></td>
                     </logic:notEqual>

                    <logic:notEqual name="LoanStatusForm" property="inferior_class" value="0">
              		    <td align=center></td>
                     </logic:notEqual>
              		</tr>
                  </logic:iterate>
               </logic:notEmpty>
              </logic:present>
        	</table>
          </td>
         </tr>
         <tr bgcolor='white'>
 	       <td><br><br>



      	      <table  width = 700 border ='0' cellspacing =0 cellpadding ='0'>
		      <tr bgcolor='white'>
			    <td align="right" bgcolor=white width = 380>
			      <logic:equal name="LoanStatusForm" property="use_reserv" value="1">
 			        <a href='javascript:reserve_cancel();'><img alt='대출예약을 취소합니다' src='/kolas3/images/UserServiceImg/bu_aa.gif' border=0></a>
 			      </logic:equal>
 			      <logic:equal name="LoanStatusForm" property="use_reserv" value="2">
 			         <a href='javascript:reserve_cancel();'><img alt='대출예약을 취소합니다' src='/kolas3/images/UserServiceImg/bu_aa.gif' border=0></a>
 			      </logic:equal>
 		 	    </td>
 		 	    <td width=10></td>
 		 	      <logic:equal name="LoanStatusForm" property="use_delay" value="Y">
              		  <logic:equal name="LoanStatusForm" property="inferior_class" value="0">
              		    <logic:lessEqual name="LoanStatusForm" property="delay_date" value="0">
              		      <logic:equal name="LoanStatusForm" property="loan_manage_code" value="">
                               <td align="left" bgcolor=white width = 310><a href='JavaScript:return_delay();'><img alt='대출반납을 연기합니다.' src='/kolas3/images/UserServiceImg/bu_ac.gif' border='0'></a></td>
                          </logic:equal>
                        </logic:lessEqual>
                     </logic:equal>
                    </logic:equal>
			   </tr>
			  </table>
			</td>
          </tr>
        </table>
	  </td>
    </tr>
  </table>
  <input type=hidden name=coloan_reckey value="">
  <input type=hidden name=book_key value="">
 </form>
                </td>
              </tr>
            </table>




<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>

