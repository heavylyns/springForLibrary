<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/service.js" charset="utf-8"></script>
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/swap.js" charset="utf-8"></script>



 <form method="post" action="/kolas3/user.login.do" id="LoginForm" name="LoginForm">

  <table width="700" border="0" cellspacing="0" cellpadding="0">

    <!--

    <tr>
     <td><img src="/kolas3/images/UserServiceImg/ti_05_2.gif" ></td>
   </tr>

    -->

   <tr>
      <td height="250" valign="top">

         	<logic:present name="path">
         		<logic:equal name="path" value="/delivery.do">

         			<input type=hidden name="url" value="/delivery.do"/>

         		</logic:equal>
         		<logic:equal name="path" value="/service_move.do">

         			<input type=hidden name="url" value="/service_move.do"/>

         		</logic:equal>

         		<logic:equal name="path" value="/insertloan.do">

         			<input type=hidden name="url" value="/insertloan.do"/>

         		</logic:equal>

         		<logic:equal name="path" value="/menu_select.do?method=service&menu_id=service_menu1">

         			<input type=hidden name="url" value="/menu_select.do?method=service&menu_id=service_menu1"/>

         		</logic:equal>

         		<logic:equal name="path" value="/menu_select.do?method=service&menu_id=service_menu3">

         			<input type=hidden name="url" value="/menu_select.do?method=service&menu_id=service_menu3"/>

         		</logic:equal>

         		<logic:equal name="path" value="/LoanStatus.do">

         			<input type=hidden name="url" value="/LoanStatus.do"/>

         		</logic:equal>

         		<logic:equal name="path" value="/LoanTotalLsit.do?mode=default">

         			<input type=hidden name="url" value="/LoanTotalLsit.do?mode=default"/>

         		</logic:equal>

         		<logic:equal name="path" value="/RequestDateView.do">

         			<input type=hidden name="url" value="/RequestDateView.do"/>

         		</logic:equal>

         		<logic:equal name="path" value="/RequestListBook.do">

         			<input type=hidden name="url" value="/RequestListBook.do"/>

         		</logic:equal>

         		<logic:equal name="path" value="/LoanTotalLsit.do">

         			<input type=hidden name="url" value="/LoanTotalLsit.do"/>

         		</logic:equal>

         	</logic:present>

         	<%
         		String []Temparray = (String[])request.getAttribute("data");

         		if(Temparray !=null)
         		{
         			for(int i =0;  i < Temparray.length; i++)
         			{
            %>
						<input type=hidden name="rec_key" value="<%=Temparray[i] %>"/>
			<%
         			}
         		}
         	%>



     <table width="600" border="0" cellspacing="0" cellpadding="0">
       <tr align="center" valign="top">
    	<td>
    	<table width="500" height="150" border="0" cellspacing="0" cellpadding="0">
    		<tr>
    			<td background="/kolas3/images/UserServiceImg/login_background2.gif">
    				<table>
    					<tr>
    						<td height="55" width="330">&nbsp;</td>
							<td>&nbsp;</td>
    					</tr>
    					<tr>
    						<td>&nbsp;
    						</td>
    						<td>
    							<input type="password" name="user_no" size="18" class="box">
    						</td>
    					</tr>
						<tr>
    						<td>&nbsp;
    						</td>
    						<td>
    							<input type="password" name="civil_no" maxlength="7" size="18" class="box">
    						</td>
    					</tr>
    					<tr>
    						<td>&nbsp;
    						</td>
    						<td align="center">
    							<input type=image src="/kolas3/images/UserServiceImg/bu01.gif" border="0" onClick='conv_click4();return false;'>
    						</td>

    					</tr>
    				</table>
    			</td>
    		</tr>
    	</table>
       </td>
      </tr>
    </table>

    <table border="0" cellpadding="40" cellspacing="0">
      <tr>
        <td>
          <table width=500 border=0 cellspacing=0 cellpadding=3>
           <tr height=90>
	        <td width="83">&nbsp;</td>
            <td width="617"></td>
           </tr>
         </table>
       </td>
     </tr>
    </table>

  </td>
 </tr>
</table>
</form>




<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>


