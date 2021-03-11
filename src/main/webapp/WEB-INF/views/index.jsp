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
<%@ include file= "include/header.jsp" %>
<%@ include file= "include/nav.jsp" %>
<div class="container " style="margin-top:30px">
<h2>전체상품</h2>
 <div class="row justify-content-center">
<c:forEach var="product" items ="${productList }">
   <div class="col-sm-3" style="margin:10px">  
  		<div class="card style="width:100%" >
	    <img class="card-img-top" src="images/rainbow.png" alt="Card image" >
   		<div class="card-body">
      	<h4 class="card-title">${product.productName }</h4>
      	<p class="card-text">${product.price }</p>
    	</div>
 	 </div>     
    </div><!-- col end -->
</c:forEach>
  </div><!-- row end -->
</div>
<%@ include file= "include/footer.jsp" %>
</body>
</html>