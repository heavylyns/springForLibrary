<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="kolas3.work.BookSearch.Form.*" %>

<%
	String title = "";
	String reg_code = "";
	ArrayList detaillist = (ArrayList)request.getAttribute("detaillist");
	for(int i=1; i<detaillist.size()-3;i++){
		DetailViewListForm detaillistform = new DetailViewListForm();
		detaillistform = (DetailViewListForm)detaillist.get(i);
		if(i==2){
			title = detaillistform.getValue().replace("/\r\n/gi","\n");
		}
	}
	

	ArrayList sojanglist = (ArrayList)request.getAttribute("sojanglist");
	for(int i=1; i<sojanglist.size();i++){
		DetailViewListForm sojanglistform = new DetailViewListForm();
		sojanglistform = (DetailViewListForm)sojanglist.get(i);
		reg_code = sojanglistform.getValue();
	}

%>
<script type="text/javascript">
	
	var v_title = "<%=title%>";
	alert(v_title);
</script>