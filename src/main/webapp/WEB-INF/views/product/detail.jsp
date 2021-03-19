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
<div class="container" style="margin-top:30px">
<form action="/" method = "get">
<button class="btn btn-info my-3" type="submit" >목록으로</button>
				<input type="hidden" name="currPage"
					value="${ pageObject.currPage }">
							<input type ="hidden" name ="totalCnt" value="${pageObject.totalCnt }">
		<input type ="hidden" name ="keyword" value="${pageObject.cri.keyword }">
		<input type="hidden" name="categoryId" value="${pageObject.cri.categoryId }">
<h2>${product.productName }</h2>
  <div class="row">
    <div class="col-sm">
      <p><img class="card-img-top"  alt="Card image" ></p>
    </div>
    <div class="col-sm">
      <p>${product.price } 원</p>
    </div>

  </div>
  <p>${product.detail }</p>
  </form>
</div>
<%@ include file= "../include/footer.jsp" %>
</body>
</html>