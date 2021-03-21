<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>Mari's ToyShop</title>
  <meta charset="utf-8">
<%@ include file="js/bootstrap.jsp"%>
</head>
<body>
<%@ include file= "include/header.jsp" %>
<%@ include file= "include/nav.jsp" %>
<div class ="container">
	<c:if test="${not empty error }">
		<div class="alert alert-danger" role="alert">
		  <c:out value="${error}" />
		</div>
	</c:if>
		<c:if test="${not empty logout }">
		<div class="alert alert-info" role="alert">
		  <c:out value="${logout}" />
		</div>
	</c:if>
	<form action="/login" method="post">
	  <div class="form-group">
	    <label for="username">회원 아이디:</label>
	    <input type="text" class="form-control" placeholder="Enter Username" id="username" name="username">
	  </div>
	    <div class="form-group">
	    <label for="password">비밀번호:</label>
	    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
	  </div>
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox"> Remember me ?
	    </label>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file= "include/footer.jsp" %>
</body>
</html>