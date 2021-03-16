<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mari's ToyShop</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="include/header.jsp"%>
	<%@ include file="include/nav.jsp"%>
	<div class="container " style="margin-top: 30px">
		<h2>전체상품</h2>
		<form id="detail" action="/product/detail" method="get">
			<div class="row justify-content-center">
				<c:forEach var="product" items="${productList }">
					<div class="col-sm-3" style="margin: 10px">
						<div class="card" style="width: 100%">
							<img class="card-img-top" alt="Card image">
							<div class="card-body">
								<a href="${product.productId}">
									<h4 class="card-title">${product.productName }</h4>
								</a>
								<p class="card-text">${product.price }</p>
							</div>
						</div>
					</div>
					<!-- col end -->
				</c:forEach>
				<input type="hidden" name="currPage"
					value="${ pageObject.currPage }">
			</div>
			<!-- row end -->
		</form>
		<h3>${pageObject }</h3>
		
		<form class="form-inline" >
		<select class="form-control" name="type">
		<option value="" ${PageObject.cri.type==null? "selected":"" }>전체</option>
		<option value=1 ${PageObject.cri.type eq 1? "selected":"" }>대형인형</option>
		<option value=2 ${PageObject.cri.type eq 2? "selected":"" }>곰인형</option>
		<option value=3 ${PageObject.cri.type eq 3? "selected":"" }>인형</option>
		</select>
			<input class="form-control mr-sm-2" type="search" name = "keyword" value="${PageObject.cri.keyword }">
			<button class="btn btn-success my-2 my-sm-0" type="button" id ="search" >Search</button>
		</form> 
			
		<form id="move" action="/" method="get">
			<input type="hidden" name="categoryId"
				value="${pageObject.cri.categoryId }">
				 <input type="hidden"
				name="currPage">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-end">
					<li class="page-item ${pageObject.prevPage? "":"disabled" }"><a
						class="page-link" href="${pageObject.startPage-1 }">Previous</a></li>
					<c:forEach var="page" begin="${pageObject.startPage }"
						end="${pageObject.endPage }">
						<li class="page-item ${page==pageObject.currPage? "active" : "" }" >
							<a class="page-link" href="${page }">${page }</a>
						</li>
					</c:forEach>
					<li class="page-item ${pageObject.nextPage? "
						":"disabled" }" name="currPage"><a class="page-link"
						href="${pageObject.endPage-1 }">Next</a></li>
				</ul>
			</nav>
		</form>
	</div>
	<%@ include file="include/footer.jsp"%>
</body>
<script>
 var move =$("#move");
 var detail = $("detail");
 
 $(".page-link").on("click", function(e){
	 e.preventDefault();
	 var page= $(this);
	 var href = page.attr("href");
	 move.find("input[name='currPage']").val(href);
	 move.submit();

	 });
 
 $("div.card").on("click", function(e){
	 e.preventDefault();
	 var product = $(this);
	 var href = product.find("a").attr("href");
	 console.log(href);
	 var h = $("<input>");
	 h.attr("type","hidden");
	 h.attr("name", "productId");
	 h.attr("value", href);
	 h.appendTo("#detail");
	 console.log(h);
	 $("#detail").submit();
	 }); 

 var search = $("#search");
 
 search.on("click",function(e){
	 e.preventDefault();
	 console.log(search);
	 
	 })
 
</script>
</html>