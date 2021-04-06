<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
	<div class="float-right"><!-- 회원메뉴 start -->
		<sec:authorize access="!isAuthenticated()">
			<a href="/login" class="btn btn-link btn-sm" role="button">로그인</a>
			<a href="/register" class="btn btn-link btn-sm" role="button">회원가입</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="/user/items" class="btn btn-link btn-sm" role="button">장바구니</a>
			<!-- <a href="/items/<sec:authentication property="principal.user.userId" />" class="btn btn-link btn-sm" role="button">장바구니JSON</a> -->
			<a href="/logout" class="btn btn-link btn-sm" role="button">로그아웃</a>
		</sec:authorize>
	</div><!-- 회원메뉴 end  -->
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>Mari's ToyShop</h1>
  <p>러블리 큐트 마리 인형가게에 오신 것을 환영합니다!</p> 
</div>
</header>