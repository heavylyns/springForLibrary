<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/kolas3/common/tagcommon.jsp"%>

<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="kolas3.work.BookSearch.Model.*"%>
<%
	String mode = "";
	String rec_keyList = "";
	String db_typeList = "";
	String loanableChk = "";
	String show_method = "";
	String mat_class = "";
	mode = request.getParameter("mode");
	rec_keyList = request.getParameter("rec_keyList");
	db_typeList = request.getParameter("db_typeList");
	loanableChk = request.getParameter("loanableChk");
	show_method = request.getParameter("show_method");
	ReceipMng ReceipMng = new ReceipMng();
	ArrayList result = new ArrayList();
	System.out.println("mode" + mode);
	if (mode.equals("91")) {
		result = ReceipMng.printListAll(rec_keyList, db_typeList, loanableChk);
	} else if (mode.equals("92")) {
		result = ReceipMng.printlistDan(rec_keyList, show_method, loanableChk);
	} else if (mode.equals("93")) {
		result = ReceipMng.printlistYon(rec_keyList, show_method, loanableChk);
	} else {
		result = ReceipMng.printListAll(rec_keyList, db_typeList, loanableChk);
	}
	String re = (String) result.get(0);
	System.out.println(re);
	//re = new String(re.getBytes("UTF-8"),"euc-kr");
	System.out.println(re);
%>

<%=re%>
<%
	response.setHeader("Content-Type", "application/octet-stream");
	response.setHeader("Content-Disposition", "inline; filename=receip.LPS");
	response.setHeader("Content-Discription", "JSP Generated Data");
	response.setHeader("Connection", "close");
%>
