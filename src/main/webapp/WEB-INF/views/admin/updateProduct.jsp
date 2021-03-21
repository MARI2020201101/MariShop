<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mari's ToyShop</title>
  <meta charset="utf-8">
<%@ include file="../js/bootstrap.jsp"%>
</head>
<body>
<%@ include file= "../include/header.jsp" %>
<%@ include file= "../include/nav.jsp" %>
	<div class="container" style="margin-top: 30px">
	<form action = "/admin/updateProduct" method="post">
	<div class="form-group">
	 <input type="text" class="form-control" value= "${product.productId}" name="productId" readonly></div> 
	 <div class="form-group">
	<label for="productName">상품이름 : </label>
    <input type="text" class="form-control" value= "${product.productName}" name="productName"></div> 
	 <div class="form-group">
    <label for="img">이미지 디테일 : </label>
    <input type="text" class="form-control" value= "${product.img}" name="img"></div>

	 <div class="form-group">
	<label for="price">상품가격 : </label>
    <input type="text" class="form-control" value= "${product.price}" name="price"></div> 
     <div class="form-group">
	<label for="stock">상품재고 : </label>
    <input type="text" class="form-control" value= "${product.stock}" name="stock"></div> 
    <div class="form-group">
    <label for="categoryId">상품카테고리 : </label>
    <select class="form-control" name="categoryId" >
      <option value=1 <c:if test="${product.categoryId==1} selected"></c:if>>대형인형</option>
      <option value=2 <c:if test="${product.categoryId==2} selected"></c:if>>곰인형</option>
      <option value=3 <c:if test="${product.categoryId==3} selected"></c:if>>인형</option>
    </select>
     </div>
     <div class="form-group"> 
    <label for="detail">상품디테일 : </label>
    <textarea class="form-control" rows="3" name="detail">${product.detail }</textarea></div>
	<button type="submit" class="btn btn-warning my-3">수정</button>
	<a href ="/admin/deleteProduct?productId=${product.productId }" class="btn btn-danger mx-2">삭제</a>
	</form>
	
	</div>
	<%@ include file= "../include/footer.jsp" %>
</body>
</html>