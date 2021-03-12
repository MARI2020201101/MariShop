<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mari's ToyShop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>
<%@ include file= "../include/header.jsp" %>
<%@ include file= "../include/nav.jsp" %>
	<div class="container" style="margin-top: 30px">
	<form action = "/admin/insertProduct" method="post">
	<div class="form-group">
	<label for="productName">상품이름 : </label>
    <input type="text" class="form-control" name="productName"></div> 
	 <div class="form-group">
    <label for="img">이미지 디테일 : </label>
    <input type="text" class="form-control" name="img"></div>
	 <div class="form-group">
	<label for="price">상품가격 : </label>
    <input type="text" class="form-control" name="price"></div> 
     <div class="form-group">
	<label for="stock">상품재고 : </label>
    <input type="text" class="form-control" name="stock"></div> 
     <div class="form-group">
    <label for="categoryId">상품카테고리 : </label>
    <select class="form-control" name="categoryId">
      <option value=1 >대형인형</option>
      <option value=2 >곰인형</option>
      <option value=3 >인형</option>
    </select>
     </div>
     <div class="form-group"> 
    <label for="detail">상품디테일 : </label>
    <textarea class="form-control" rows="3" name="detail"></textarea></div>
	<button type="submit" class="btn btn-success my-3">등록</button>
	</form>
	
	</div>
	<%@ include file= "../include/footer.jsp" %>
</body>
</html>