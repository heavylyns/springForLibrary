<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/header.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/left.jsp" %>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp" %>


<link rel="stylesheet" type="text/css" href="/kolas3/css/main.css">
<script language="JavaScript" type="text/JavaScript" src="/kolas3/script/search_script.js" charset="utf-8"></script>

<script type="text/javascript" language="javascript">
window.onload=function() {
	search_new_main();
}
</script>



<form name=searchnewmain method="post" action="result_new_main.do">
<input type="hidden" name="sort" value="RK">
<input type="hidden" name="startpage" value="1">
<input type="hidden" name="mode" value="1">
<input type="hidden" name="limitpage" value="10">
<input type="hidden" name="jongbook" value="new">
<input type="hidden" name="local" value="">
<input type="hidden" name="reg_code" value="">
<input type="hidden" name="ten_new" value="">
<input type="hidden" name="new_start" value="">
</form>

<%@include file="/WEB-INF/jsp/egovframework/kolas3/footer.jsp" %>
