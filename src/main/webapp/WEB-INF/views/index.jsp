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
	<div class="container " style="margin-top: 30px">
		<h2>전체상품</h2>
		<form id="move" action="/" method="get">
		<div class="row justify-content-center">
			<c:forEach var="product" items="${productList }">
				<div class="col-sm-3" style="margin: 10px">
					<div class="card" style="width:100%" >
						<a href="${product.productId}"> <img
							class="card-img-top" src="images/rainbow.png" alt="Card image"></a>
						<div class="card-body">
							<a href="${product.productId}">
								<h4 class="card-title">${product.productName }</h4>
							</a>
							<p class="card-text">${product.price }</p>
						</div>
					</div>
				</div>
				<!-- col end -->
				<input type="text" name="productId" hidden="true"
					value="${product.productId }">
			</c:forEach>
		</div>
		<!-- row end -->

		<h3>${pageObject }</h3>
		
		<input type ="hidden" name="currPage">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-end">
					<li class="page-item ${pageObject.prevPage? "":"disabled" }"><a
						class="page-link" href ="${pageObject.startPage-1 }">Previous</a></li>
					<c:forEach var="page" begin="${pageObject.startPage }" 
						end="${pageObject.endPage }">
						<li class="page-item ${page==pageObject.currPage? "active" : "" }" >
						<a class="page-link" href="${page }">${page }</a></li>
					</c:forEach>
					<li class="page-item ${pageObject.nextPage? "":"disabled" }" name="currPage"><a
						class="page-link" href ="${pageObject.endPage-1 }">Next</a></li>
				</ul>
			</nav>
		</form>
	</div>
	<%@ include file= "include/footer.jsp" %>
</body>
<script>
 var move =$("#move");
 $(".page-link").on("click",function(e){
	 var page= $(this);
	 e.preventDefault();
	 console.log(move);
	 console.log(page.attr("href"));
	 var href = page.attr("href");
	 move.find("input[name='currPage']").val(href);
	 move.submit();
	 });
 $("div.card").on("click", function(e){
	 e.preventDefault();
	 console.log(this);
	 var detail = $(this);
	 console.log( move.attr("action"));
	 move.attr("action","/product/detail");
	 move.append("<input type = 'hidden' name ='productId' value = '" + detail.attr("href") +"'>");
	 console.log(move);
	 });
 
</script>
</html>