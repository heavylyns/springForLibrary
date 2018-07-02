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
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/loantotal.js" charset="utf-8"></script>


<table width="700" border="0" cellspacing="0" cellpadding="0">

    <!--

    <tr>
      <td><img src="/kolas3/images/UserServiceImg/ti_05_2.gif" ></td>
    </tr>

     -->

    <tr>
       <td height="250" valign="top">
		 <table width="700" height="100%" border="0" cellpadding="0" cellspacing="0" >
	       <tr>
		     <td valign="top">
		      <form action="/LoanTotalLsit.do" method="post" name="LoanTotalForm">
                <table  width = 700 border ='0' cellspacing ='0' cellpadding ='0' >
                  <tr>
					<td valign=bottom>총 대출책수 : <font color=red><bean:write name="LoanTotalForm" property="total_loancount"/></font></td>
					<td valign=bottom>페이지 : <bean:write name="LoanTotalForm" property="current_pagecount"/> / <font color=red><bean:write name="LoanTotalForm" property="total_pagecount"/></font></td>
				 	<td align=right>
					   <a href="/kolas3/user.LoanStatus.do"><img src="/kolas3/images/UserServiceImg/bu_d.gif" border="0"></a>
					   <html:link action="/kolas3/user.Logout.do"><img src="/kolas3/images/UserServiceImg/bu_ad.gif" border="0"></html:link>
 	                </td>
                  </tr>
              </table><br>
              <table width="700" border="0" cellspacing="0" cellpadding="0" bgcolor=black>
                <tr>
                 <td>
                    <table width="700" border="0" cellspacing="1" cellpadding="0">
					<tr class=book_loan_field height="34">
						<td align=center class="field" width=450>서명</td>
						<td align=center class="field" width=70>낱권정보</td>
						<td align=center class="field" width=90>대출일</td>
						<td align=center class="field" width=90>반납일</td>
					</tr>

					<!--  대출 이력조회 리스트 출력 부분  -->

				    <logic:present name="LoanTotalArray">
				       <logic:empty name="LoanTotalArray">

						 <logic:notEqual name="LoanTotalForm" property="term_search_flag" value="search">
						   <tr height=25><td colspan=7 align=center class=view>대출 도서가 없습니다.</td></tr>
						 </logic:notEqual>

						 <logic:equal name="LoanTotalForm" property="term_search_flag" value="search">
						 	<tr height=25><td colspan=7 align=center class=view>검색된 대출 이력이 없습니다.</td></tr>
						 </logic:equal>

					   </logic:empty>

					   <logic:notEmpty name="LoanTotalArray">
					     <logic:iterate name="LoanTotalArray" id="LoanTotalForm">

					       <tr height=25 class=list>
					         <td> <bean:write name="LoanTotalForm" property="title"/> </td>
					         <td align=center>  </td>
					         <td align=center><bean:write name="LoanTotalForm" property="loan_date"/></td>
					         <td align=center><bean:write name="LoanTotalForm" property="return_date"/></td>
					       </tr>

					  </logic:iterate>
                    </table>
                 </td>
               </tr>
                </table><br>
                <!-- ****** 페이징 처리 ************************* -->

		        <table border='0' cellpadding='0' cellspacing='0' width=700 bgcolor=white>
                <tr>
	              <td align=center>
		            <!-- 페이지 처리 파라미터 얻기 -->

	         		<!--이전 페이지 블록링크 출력 (  <<  ) -->

	         		<%
		         		int S_total_pagecount 				= 	0;
						int S_current_pagecount 		= 	0;
						int S_prev_page 						=	0;
						int S_next_page 						= 	0;
						int S_pageGroupStart 				= 	0;
						int S_pageGroupEnd 				=  0;
						int S_width_page                     =	0;


	         			S_total_pagecount 				= 	Integer.parseInt((String)request.getAttribute("total_pagecount"));			// 전체 페이지 개수
    					S_current_pagecount 			= 	Integer.parseInt((String)request.getAttribute("current_pagecount"));	   // 현재페이지
    					S_prev_page 					=	Integer.parseInt((String)request.getAttribute("prev_page"));					// 이전페이지
    					S_next_page 					= 	Integer.parseInt((String)request.getAttribute("next_page"));					// 다음페이지
    					S_pageGroupStart 				= 	Integer.parseInt((String)request.getAttribute("pageGroupStart"));			// 페이지 리스트 그룹시작번
    					S_pageGroupEnd 					=   Integer.parseInt((String)request.getAttribute("pageGroupEnd")); 			// 페이지 리스트 그룹 끝번
    					S_width_page                    =	Integer.parseInt((String)request.getAttribute("width_page"));				     // 선택된 페이지

    					System.out.println("선택된 페이지===>" + S_width_page);
    					System.out.println("S_current_pagecount==>" + S_current_pagecount);


	    				if(S_width_page > 1)
	    				{
	    					S_prev_page=S_pageGroupStart-1;
	    			%>
	    					<a href="javascript:loantotal('<%=S_prev_page %>')">&lt;&lt;</a>
	    			<%
	    				}
	    			%>

	         		<!-- 페이지 바로가기 링크 출력 -->

	         		<%

	         			for(int idx = S_pageGroupStart; idx <= S_pageGroupEnd; idx++)
	         			{
	         				if(S_current_pagecount == idx)
	         					out.println("<b>["+idx+"]</b>");
	         				if(S_current_pagecount != idx)
	         				{
					%>
	         					<a href="javascript:loantotal('<%=idx %>')"><%out.println(" ["+idx+"] ");  %></a>
	         		<%
	         				}
	         			}

	         		%>


	         		<!--다음 페이지 블록링크 출력 (  >>  ) -->

	         		<%
	         			if(S_total_pagecount > S_pageGroupEnd)
	         			{
	         				S_next_page=S_pageGroupEnd+1;
	         		%>
	         				<a href="javascript:loantotal('<%=S_next_page %>')">&gt;&gt;</a>
	         		<%
	         			}
	         		%>

	             </td>
                </tr>
              </table>
              </logic:notEmpty>
		      </logic:present>

              <table width="700" height="30" border="0" cellspacing="0" cellpadding="0" bgcolor=white>
              	 <tr>
              	   <td width="700" height="30" bgcolor=white>&nbsp;</td>
              	</tr>
              </table>
              <table width="700" border="0" cellspacing="0" cellpadding="0" bgcolor=black>
                <tr>
                  <td>
                  	<input type="hidden" name="current_pagecount" value="">
					<logic:present name="search_mode">
					  <logic:empty name="search_mode">

					     <input type="hidden" id="term_search_flag" value="">

				      </logic:empty>
				    </logic:present>

				    <input type="hidden" id="term_search_flag" value="<%=(String)request.getAttribute("search_mode") %>">

				    <input type=hidden name="s_year_h" value="<%=(String)request.getAttribute("s_year")%>">
					<input type=hidden name="s_month_h" value="<%=(String)request.getAttribute("s_month")%>">
					<input type=hidden name="s_day_h" value="<%=(String)request.getAttribute("s_day")%>">
					<input type=hidden name="e_year_h" value="<%=(String)request.getAttribute("e_year")%>">
					<input type=hidden name="e_month_h" value="<%=(String)request.getAttribute("e_month")%>">
					<input type=hidden name="e_day_h" value="<%=(String)request.getAttribute("e_day")%>">
					<input type=hidden name="select_field_h" value="<%=(String)request.getAttribute("select_field")%>">


					<table width="700" border="0" cellspacing="1" cellpadding="0" >
					    <tr height="30" cellspacig="1" bgcolor="#FFFFFF">
						    <td align=center width="80" class=field><b>기간검색</b></td>
							    <td>&nbsp;<select name="s_year" >
									<option value="1995" selected>1995년</option>
									<option value="1996" >1996년</option>
									<option value="1997" >1997년</option>
									<option value="1998" >1998년</option>
									<option value="1999" >1999년</option>
									<option value="2000" >2000년</option>
									<option value="2001" >2001년</option>
									<option value="2002" >2002년</option>
									<option value="2003" >2003년</option>
									<option value="2004" >2004년</option>
									<option value="2005" >2005년</option>
									<option value="2006" >2006년</option>
									<option value="2007" >2007년</option>
									<option value="2008" >2008년</option>
									<option value="2009" >2009년</option>
									<option value="2010" >2010년</option>
									<option value="2011" >2011년</option>
								</select>
								<select name="s_month" >
									<option value="01" selected>1월</option>
									<option value="02" >2월</option>
									<option value="03" >3월</option>
									<option value="04" >4월</option>
									<option value="05" >5월</option>
									<option value="06" >6월</option>
									<option value="07" >7월</option>
									<option value="08" >8월</option>
									<option value="09" >9월</option>
									<option value="10" >10월</option>
									<option value="11" >11월</option>
									<option value="12" >12월</option>
								</select>
								<select name="s_day">
								<option value='01' selected>1일</option>
								<option value='02' >2일</option>
								<option value='03' >3일</option>
								<option value='04' >4일</option>
								<option value='05' >5일</option>
								<option value='06' >6일</option>
								<option value='07' >7일</option>
								<option value='08' >8일</option>
								<option value='09' >9일</option>
								<option value='10' >10일</option>
								<option value='11' >11일</option>
								<option value='12' >12일</option>
								<option value='13' >13일</option>
								<option value='14' >14일</option>
								<option value='15' >15일</option>
								<option value='16' >16일</option>
								<option value='17' >17일</option>
								<option value='18' >18일</option>
								<option value='19' >19일</option>
								<option value='20' >20일</option>
								<option value='21' >21일</option>
								<option value='22' >22일</option>
								<option value='23' >23일</option>
								<option value='24' >24일</option>
								<option value='25' >25일</option>
								<option value='26' >26일</option>
								<option value='27' >27일</option>
								<option value='28' >28일</option>
								<option value='29' >29일</option>
								<option value='30' >30일</option>
								<option value='31' >31일</option>
									</select>&nbsp;&nbsp;부터&nbsp;
									<select name="e_year">
									<option value="1995" >1995년</option>
									<option value="1996" >1996년</option>
									<option value="1997" >1997년</option>
									<option value="1998" >1998년</option>
									<option value="1999" >1999년</option>
									<option value="2000" >2000년</option>
									<option value="2001" >2001년</option>
									<option value="2002" >2002년</option>
									<option value="2003" >2003년</option>
									<option value="2004" >2004년</option>
									<option value="2005" >2005년</option>
									<option value="2006" >2006년</option>
									<option value="2007" >2007년</option>
									<option value="2008" >2008년</option>
									<option value="2009" selected>2009년</option>
									<option value="2010" >2010년</option>
									<option value="2011" >2011년</option>
									</select>
									<select name="e_month" >
									<option value="01" selected>1월</option>
									<option value="02" >2월</option>
									<option value="03" >3월</option>
									<option value="04" >4월</option>
									<option value="05" >5월</option>
									<option value="06" >6월</option>
									<option value="07" >7월</option>
									<option value="08" >8월</option>
									<option value="09" >9월</option>
									<option value="10" >10월</option>
									<option value="11" >11월</option>
									<option value="12" >12월</option>
									</select>
									<select name="e_day" >
									<option value='01' selected>1일</option>
									<option value='02' >2일</option>
									<option value='03' >3일</option>
									<option value='04' >4일</option>
									<option value='05' >5일</option>
									<option value='06' >6일</option>
									<option value='07' >7일</option>
									<option value='08' >8일</option>
									<option value='09' >9일</option>
									<option value='10' >10일</option>
									<option value='11' >11일</option>
									<option value='12' >12일</option>
									<option value='13' >13일</option>
									<option value='14' >14일</option>
									<option value='15' >15일</option>
									<option value='16' >16일</option>
									<option value='17' >17일</option>
									<option value='18' >18일</option>
									<option value='19' >19일</option>
									<option value='20' >20일</option>
									<option value='21' >21일</option>
									<option value='22' >22일</option>
									<option value='23' >23일</option>
									<option value='24' >24일</option>
									<option value='25' >25일</option>
									<option value='26' >26일</option>
									<option value='27' >27일</option>
									<option value='28' >28일</option>
									<option value='29' >29일</option>
									<option value='30' >30일</option>
									<option value='31' >31일</option>
								  </select>&nbsp;&nbsp;까지&nbsp;
	                              <select name="select_field">
									<option value="loan_date"  selected>대출일</option>
									<option value="return_date" > 반납일</option>
	                              </select>&nbsp;&nbsp;로
	                             <td align=center width="70" class=field><a href="javascript:term_search()"><img src="/kolas3/images/commonImg/but_search.gif" border="0"></a></td>
                              </tr>
                          </table>
						</td>
					   </tr>
					 </table>
                    </td>
                  </tr>
                </table><p>&nbsp;</p>
		      </td>
	        </tr>
      </table>
      </form>
    </td>
   </tr>
  </table>
 </td>
 </tr>
</table></td>
  </tr>




<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
