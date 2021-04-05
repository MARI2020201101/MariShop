<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mari's ToyShop</title>
<meta charset="utf-8">
<%@ include file="../js/bootstrap.jsp"%>
</head>
<link rel="stylesheet" href="css/style.css">
<body>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/nav.jsp"%>
<div class="container" style="margin-top: 30px">
	<form action="/" method="get">
		<button class="btn btn-info my-3" type="submit">목록으로</button>
		<input type="hidden" name="currPage" value="${pageObject.currPage }">
		<input type="hidden" name="totalCnt" value="${pageObject.totalCnt }">
		<input type="hidden" name="keyword" value="${pageObject.cri.keyword }"> 
		<input type="hidden" name="categoryId" value="${pageObject.cri.categoryId }">
			<h1>${product.productName }</h1>
			<hr>
			<div class="image">
				<p><img src = "${product.img }"class="card-img-top" alt="Card image"></p>
			</div>
			<hr>
				<h3>가격 : ${product.price } 원</h3>
				<h3>재고 : ${product.stock } 개</h3>
			<hr>
			<h3>상세 설명</h3>
			<p>${product.detail }</p>
			<div class="imgDiv" ></div>
	</form>
		<br>
		<hr>
		<label for="count">구매 수량 : </label>
		<select class="form-select form-control" style ="width:100px" id ="count">
			<option value=1>1</option>
			<option value=2>2</option>
			<option value=3>3</option>
			<option value=4>4</option>
		</select> 
		<br>
		<input type ="hidden" id ="productId" value="${product.productId}">
		<input type ="hidden" id ="totalPrice" value="${product.price}">
		<sec:authorize access="isAuthenticated()">
		<input type ="hidden" id ="userId" value="<sec:authentication property="principal.user.userId" />">
		</sec:authorize>
		<sec:authorize access="isAuthenticated()"></sec:authorize>
		<button type="button" class="btn btn-warning" id="newitem">장바구니 추가</button>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
<script src = "/js/items.js"></script>
<script src = "/js/detail.js"></script>
</html>