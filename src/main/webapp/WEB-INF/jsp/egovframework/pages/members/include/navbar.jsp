<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    	<div class="sub_nav_section">
			<div class="sub_nav_article styel_2">
				<span <c:if test="${name == 'noticeboard'}">class="active"</c:if>><a href="#">공지사항</a></span>
				<span <c:if test="${name == 'qna'}">class="active"</c:if>><a href="#">묻고 답하기</a></span>
				<span <c:if test="${name == 'freeboard'}">class="active"</c:if>><a href="#">자유게시판</a></span>
				<span <c:if test="${name == 'addToWishlist'}">class="active"</c:if>><a href="#">희망도서 신청</a></span>
				<span <c:if test="${name == 'book_narae'}">class="active"</c:if>><a href="#">책나래</a></span>
				<span <c:if test="${name == 'book_sea'}">class="active"</c:if>><a href="#">책바다</a></span>
				<!--<span><a href="#">책이음</a></span>-->
				<span <c:if test="${name == 'volunteering'}">class="active"</c:if>><a href="#">봉사활동 신청</a></span>
				<span <c:if test="${name == 'mobileCard'}">class="active"</c:if>><a href="#">모바일회원증</a></span>
			</div>
		</div>
		<!--// sub_nav_section -->