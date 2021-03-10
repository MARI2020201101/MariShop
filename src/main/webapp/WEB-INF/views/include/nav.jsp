<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">♡</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">대형인형</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">곰인형</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">인형</a>
      </li>    
    </ul >
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <sec:authorize access="hasAuthority('ADMIN')">
    <ul class="navbar-nav">
    	<li class="nav-item">
        <a class="nav-link" href="/admin/manageUser">회원관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">상품관리</a>
      </li>
    </ul>
    </sec:authorize>
  </div>  
</nav>
<br>