<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<!--

파일명   : ServiceBookRequestList.jsp
기능설명: 사용자가 작성한 비치희망도서 정보를 리스트로 출력(진행상태, 총건수, 신청인, 도서명, 저자 등 출력) 및 페이징 처리
작성일   : 2008년/ 08월 20일
작성자   : 개발3부 해외사업팀 신영준

 -->

<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/service.js" charset="utf-8"></script>
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/swap.js" charset="utf-8"></script>


     <table width="700" border="0" cellspacing="0" cellpadding="0">

      <!--

       <tr>
         <td><img src="/kolas3/images/UserServiceImg/ti_05_3.gif" ></td>
       </tr>

        -->
	   <tr>
        <td height="250" valign="top">

         <!---- 희망도서신청 메뉴 테이블 ---->

          <table border="0" cellspacing="0" cellpadding="0" >
            <tr>
               <td colspan=3  height=11></td>
            </tr>
            <tr>
               <td align=left><a href='/kolas3/user.menu_select.do?method=service&menu_id=service_menu3' onfocus='this.blur()'><img src="/kolas3/images/UserServiceImg/tab_01_off.gif" name="menu2_sub_01" border="0"
	                		              			onMouseOut="MM_swapImgRestore()"
	                		              			onMouseOver="MM_swapImage('menu2_sub_01','','/kolas3/images/UserServiceImg/tab_01_on.gif',1)"></a></td>

               <td align=left><img src="/kolas3/images/UserServiceImg/tab_02_on.gif" border="0"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:link action="/kolas3/user.Logout.do?menu_id=RequestBookList"><img src="/kolas3/images/UserServiceImg/bu_ad.gif" border="0"></html:link></td>
	        </tr>
          </table><br>
          <table height="10">
          	<!-- 신청도서 변수 NOT NULL &&  신청도서 전체 검색-->
		<logic:present name="error">

			<logic:notEmpty name="error">
				<tr>
					<td colspan="2" ><img src="/kolas3/images/UserServiceImg/bu_arrow.gif"><strong><font  color="blue"><%= request.getAttribute("error") %></font></strong></td>
				</tr>
			</logic:notEmpty>
		</logic:present>

       	  </table>
<!--  사용자 희망도서 신청 정보 출력 시작 부분 -->

<!--  Request 요청객체에 도서 신청 리스트변수가 존재할 경우 -->

<form name="BookRequestListForm" action="/kolas3/user.RequestListBook.do" method="post" >

<logic:present name="RequestBookArray">

    <!-- 신청도서 리스트변수가 NULL 일 경우 -->

    <logic:empty name="RequestBookArray">

    	<!--  신청도서 NULL && 조건검색이 아닐 경우 -->


    	<logic:equal name="BookRequestListForm" property="keyword" value="">

          <table border=0>
	        <tr>
	          <td width=80% >총 신청서: <font color=red><bean:write name="BookRequestListForm" property="total_bookcount"/></font>건</td>
	          <td width=20% align=right >페이지 : <font color=red><bean:write name="BookRequestListForm" property="current_pagecount"/></font> / <bean:write name="BookRequestListForm" property="total_pagecount"/></td>
	        </tr>
          </table>

          <table border='0' cellpadding='0' cellspacing='0' >
            <tr>
              <td class=table>
               <table width=600 cellspacing=1 cellpadding='3' cellspacing='1'>
                 <tr>
					<td class=field width=40 align=center height=25>번 호</td>
					<td class=field width=70 align=center>신청인</td>
					<td class=field width=250 align=center>신청 도서명</td>
					<td class=field width=90 align=center>저 자</td>
					<td class=field width=70 align=center>신청일</td>
					<td class=field width=80 align=center>진행상태</td>
					<td class=field width=80 align=center>취소사유</td>
                 </tr>
                 <tr>
                   <td align=center colspan=6 class=view>신청한 도서가 없습니다.</td>
                 </tr>
               </table>
              </td>
            </tr>
          </table>

        </logic:equal>


        <!-- 신청 도서 NULL && 전체 신청도서 검색 일 경우 -->

        <logic:notEqual name="BookRequestListForm" property="keyword" value="">

          <table border=0>
            <tr>
              <td width=100% class=Comment colspan=2>
	             검색 조건	: <font color=red><bean:write name="BookRequestListForm" property="search_str"/></font>&nbsp;&nbsp;
	             검색어		: <font color=red><bean:write name="BookRequestListForm" property="keyword"/></font>
	          </td>
	        </tr>
            <tr>
              <td width=80% class=Comment>검색된 신청서: <font class=HighLight><bean:write name="BookRequestListForm" property="total_bookcount"/></font></td>
		      <td width=20% align=right class=Comment><font class=HighLight><bean:write name="BookRequestListForm" property="current_pagecount"/></font> / <bean:write name="BookRequestListForm" property="total_pagecount"/></td>
            </tr>
          </table>

           <table border='0' cellpadding='0' cellspacing='0' >
            <tr>
              <td class=table>
               <table width=600 cellspacing=1 cellpadding='3' cellspacing='1'>
                 <tr>
					<td class=field width=40 align=center height=25>번 호</td>
					<td class=field width=70 align=center>신청인</td>
					<td class=field width=250 align=center>신청 도서명</td>
					<td class=field width=90 align=center>저 자</td>
					<td class=field width=70 align=center>신청일</td>
					<td class=field width=80 align=center>진행상태</td>
					<td class=field width=80 align=center>취소사유</td>
                 </tr>
                 <tr>
                   <td align=center colspan=6 class=view>신청한 도서가 없습니다.</td>
                 </tr>
               </table>
              </td>
            </tr>
          </table>

        </logic:notEqual>

	</logic:empty>


	<!-- 신청도서 변수가 NOT NULL  -->

	<logic:notEmpty name="RequestBookArray">

	   <logic:equal name="BookRequestListForm" property="keyword" value="">

	      <table border=0>
	        <tr>
	          <td width=80% >총 신청서: <font color=red><bean:write name="BookRequestListForm" property="total_bookcount"/></font>건</td>
	          <td width=20% align=right >페이지 : <font color=red><bean:write name="BookRequestListForm" property="current_pagecount"/></font> / <bean:write name="BookRequestListForm" property="total_pagecount"/></td>
	        </tr>
          </table>

	  </logic:equal>


	  <!-- 신청도서 변수 NOT NULL &&  신청도서 조건 검색-->

	  <logic:notEqual name="BookRequestListForm" property="keyword" value="">

          <table border=0>
            <tr>
              <td width=100% class=Comment colspan=2>
	             검색 조건	: <font color=red><bean:write name="BookRequestListForm" property="search_str"/></font>&nbsp;&nbsp;
	             검색어		: <font color=red><bean:write name="BookRequestListForm" property="keyword"/></font>
	          </td>
	        </tr>
            <tr>
              <td width=80% class=Comment>검색된 신청서: <font class=HighLight><bean:write name="BookRequestListForm" property="total_bookcount"/></font></td>
		      <td width=20% align=right class=Comment><font class=HighLight><bean:write name="BookRequestListForm" property="current_pagecount"/></font> / <bean:write name="BookRequestListForm" property="total_pagecount"/></td>
            </tr>
          </table>

        </logic:notEqual>

          <table border='0' cellpadding='0' cellspacing='0' >
            <tr>
              <td class=table>

            <!--  비치희망도서 리스트 출력 부분  -->

               <table width=600 cellspacing=1 cellpadding='3' cellspacing='1'>
                 <tr>
					<td class=field width=40 align=center height=25>번 호</td>
					<td class=field width=70 align=center>신청인</td>
					<td class=field width=250 align=center>신청 도서명</td>
					<td class=field width=90 align=center>저 자</td>
					<td class=field width=70 align=center>신청일</td>
					<td class=field width=80 align=center>진행상태</td>
					<td class=field width=80 align=center>취소사유</td>
                 </tr>

                  <!-- 비치희망 신청도서 리스트 반복 출력  -->

	           <logic:iterate id="BookRequestListForm" name="RequestBookArray">

	              <tr class="list" onMouseOver='this.style.backgroundColor="#d7dee8"' onMouseOut='this.style.backgroundColor=""'>
		            <td align=center><bean:write name="BookRequestListForm" property="book_no"/></td>
		            <td align=center><bean:write name="BookRequestListForm" property="applicant_name"/></td>
		            <td><a href="javascript:requestDetailControl('<bean:write name="BookRequestListForm" property="rec_key"/>')"><bean:write name="BookRequestListForm" property="book_title"/></a>
		            <td align=center><bean:write name="BookRequestListForm" property="book_author"/></td>
		            <td align=center><bean:write name="BookRequestListForm" property="request_date"/></td>
		            <td align=center><bean:write name="BookRequestListForm" property="furnish_status"/>&nbsp;</td>
		            <td align=center><bean:write name="BookRequestListForm" property="cancel_reason"/>&nbsp;</td>
	             </tr>
	           </logic:iterate>
             </table>
           </td>
         </tr>
       </table>

       <!--  리스트 출력 페이징 처리 부분 -->

       <table width=600 border=0 cellpadding=3 cellspacing=1>
         <tr>
           <td colspan=5 class=trans align=center>
         		<!-- 페이지 처리 파라미터 얻기 -->

         		<!--이전 페이지 블록링크 출력 (  <<  ) -->

         		<%

    				int S_total_pagecount 			= 	Integer.parseInt((String)request.getAttribute("total_pagecount"));			// 전체 페이지 개수
    				int S_current_pagecount 		= 	Integer.parseInt((String)request.getAttribute("current_pagecount"));	   // 현재페이지
    				int S_prev_page 				=	Integer.parseInt((String)request.getAttribute("prev_page"));					// 이전페이지
    				int S_next_page 				= 	Integer.parseInt((String)request.getAttribute("next_page"));					// 다음페이지
    				int S_pageGroupStart 			= 	Integer.parseInt((String)request.getAttribute("pageGroupStart"));			// 페이지 리스트 그룹시작번
    				int S_pageGroupEnd 				=   Integer.parseInt((String)request.getAttribute("pageGroupEnd")); 			// 페이지 리스트 그룹 끝번
    				int S_width_page                =	Integer.parseInt((String)request.getAttribute("width_page"));				     // 선택된 페이지


    				if(S_width_page > 1)
    				{
    					S_prev_page=S_pageGroupStart-1;
    			%>
    					<a href="javascript:requestListControl('<%=S_prev_page %>')">&lt;&lt;</a>
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
         					<a href="javascript:requestListControl('<%=idx %>')"><%= idx %></a>
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
         				<a href="javascript:requestListControl('<%=S_next_page %>')">&gt;&gt;</a>
         		<%
         			}
         		%>


           </td>
         </tr>
       </table>

         <!-- 검색 폼 위치 -->

           <table width=600 cellspacing=0 cellpadding=0 width=600 height=43>
	         <tr>
	           <td  align='center'>

	            <% if(request.getAttribute("chk_name") !=null)
	                 {
	            	    String Rchk_name =""+request.getAttribute("chk_name");
  	                    if(Rchk_name.equals("1"))
  	                    {
  	                          out.println("<input type=checkbox  name='chk_name' value='1'  checked>신청인");
	                	}
	                    else{
	                    	out.println("<input type=checkbox  name='chk_name' value='1'>신청인");
	               		}
	            	 }

	            	else
	            	{
	            		out.println("<input type=checkbox  name='chk_name' value='1'checked>신청인");
	            	}

	            	if(request.getAttribute("chk_title") !=null)
	            	{
  	                	String Rchk_name =""+request.getAttribute("chk_title");
  	                	 if(Rchk_name.equals("2"))
  	                	 {
  	                		out.println("<input type=checkbox  name='chk_title' value='2' checked>도서명");
  	                	 }
  	                	 else{
  	                		out.println("<input type=checkbox  name='chk_title' value='2' >도서명");
  	                	 }
	            	}
	            	else
	            	{
	            		out.println("<input type=checkbox  name='chk_title' value='2' >도서명");
	            	}
	             %>

		         <html:text styleClass="tComboKey" name="BookRequestListForm" property="keyword" size="15" maxlength="30"/>
		         <input type=hidden name="current_pagecount" value="1">

		         <a href=javascript:search_check();><img src='/kolas3/images/commonImg/but_search.gif' border=0 align=absmiddle alt='찾기'></a>
	           </td>
	         </tr>
          </table>
       </logic:notEmpty>
      </logic:present>
      </form>

      <%if(request.getAttribute("current_pagecount")==null)
          {
            	out.println("<input type='hidden' id='page' value='1'>");
          }
         else
         {
        	 out.println("<input type='hidden' id='page'  value='"+request.getAttribute("current_pagecount")+" ' >");
         }%>

      </td>
    </tr>
   </table>




<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>

