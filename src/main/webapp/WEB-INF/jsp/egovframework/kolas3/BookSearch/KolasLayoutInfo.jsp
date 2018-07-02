<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>

<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/common.jsp" %>

<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">




<tiles:insert attribute="header"/>
<tiles:insert attribute="menu"/>

<logic:present name="menu_id">

  <logic:equal name="menu_id" value="info_menu1">
	 <tiles:insert attribute="new_data"/>
  </logic:equal>

  <logic:equal name="menu_id" value="info_menu2">
	<tiles:insert attribute="recommend_book"/>
  </logic:equal>

  <logic:equal name="menu_id" value="info_menu3">
	<tiles:insert attribute="lend_best"/>
  </logic:equal>

</logic:present>

<logic:notPresent name="menu_id">

	<tiles:insert attribute="new_data"/>

</logic:notPresent>

		<tiles:insert attribute="tail"/>


<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>


