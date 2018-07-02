<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    	<div class="sub_nav_section">
			<div class="sub_nav_article">
				<span class="go_nav_article">
					<a href="#">도서관 안내</a>
					<ul class="go_nav_link">
						<li><a href="#">춘천시립도서관</a></li>
						<li><a href="#">청소년도서관</a></li>
						<li><a href="#">동내도서관</a></li>
						<li><a href="#">신사우도서관</a></li>
						<li><a href="#">소양도서관</a></li>
						<li><a href="#">남산도서관</a></li>
						<li><a href="#">서면도서관</a></li>
					</ul>
				</span>
				<span <c:if test="${name == 'join_info'}">class="active"</c:if>><a href="/about/join">회원가입</a></span>
				<span <c:if test="${name == 'greeting'}">class="active"</c:if>><a href="/about/greeting">인사말</a></span>
				<span <c:if test="${name == 'history'}">class="active"</c:if>><a href="/about/history">연혁</a></span>
				<span <c:if test="${name == 'regulations'}">class="active"</c:if>><a href="/about/regulations">도서관 자치법규</a></span>
				<span <c:if test="${name == 'charter'}">class="active"</c:if>><a href="/about/charter">도서관 헌장</a></span>
			</div>
		</div>