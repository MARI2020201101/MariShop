<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Mari's ToyShop</title>
<meta charset="utf-8">
<%@ include file="js/bootstrap.jsp"%>

</head>
<link rel="stylesheet" href="css/style.css">
<style>

</style>
<body>
	<%@ include file="include/header.jsp"%>
	<%@ include file="include/nav.jsp"%>
	<div class="container " style="margin-top: 30px">
		<h2>전체상품</h2>
		<form id="detail" action="/detail" method="get">
			<div class="row justify-content-center">
				<c:forEach var="product" items="${productList }">
					<div class="col-sm-3" style="margin: 10px">
						<div class="card" style="width: 100%">
							<img src = "${product.thumbImg }" class="card-img-top" alt="Card image">
							
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
							<input type ="hidden" name ="totalCnt" value="${pageObject.totalCnt }">
		<input type ="hidden" name ="keyword" value="${pageObject.cri.keyword }">
		<input type="hidden" name="categoryId" value="${pageObject.cri.categoryId }">
			</div>
			<!-- row end -->
		</form>
		<h3>${pageObject }</h3>
		                                                                            
		<form class="form-inline" action="/" method="get">
		<select class="form-control" name="categoryId">
		<option value="" ${pageObject.cri.categoryId==null? "selected":"" }>전체</option>
		<option value=1 ${pageObject.cri.categoryId eq 1? "selected":"" }>대형인형</option>
		<option value=2 ${pageObject.cri.categoryId eq 2? "selected":"" }>곰인형</option>
		<option value=3 ${pageObject.cri.categoryId eq 3? "selected":"" }>인형</option>
		</select>
			<input class="form-control mr-sm-2" id ="keyword" name = "keyword" value="${pageObject.cri.keyword }">
			<button class="btn btn-success my-2 my-sm-0" type="submit" id ="search" >Search</button>
		</form> 
			
		<form id="move" action="/" method="get">
		<input type ="hidden" name ="totalCnt" value="${pageObject.totalCnt }">
		<input type ="hidden" name ="keyword" value="${pageObject.cri.keyword }">
		<input type="hidden" name="categoryId" value="${pageObject.cri.categoryId }">
		<input type="hidden" name="currPage" >
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-end">
					<li class="page-item ${pageObject.prevPage? "":"disabled" }"><a
						class="page-link" href="${pageObject.currPage-1 }">Previous</a></li>
					<c:forEach var="page" begin="${pageObject.startPage }"
						end="${pageObject.endPage }">
						<li class="page-item ${page==pageObject.currPage? "active" : "" }" >
							<a class="page-link" href="${page }">${page }</a>
						</li>
					</c:forEach>
					<li class="page-item ${pageObject.nextPage? "":"disabled" }">
					<a class="page-link" href="${pageObject.currPage+1 }">Next</a></li>
				</ul>
			</nav>
		</form>
	</div>
	<%@ include file="include/footer.jsp"%>
</body>
<script>
 var move =$("#move");
 var detail = $("detail");
 var keyword = $("#keyword").val();
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
</script>
</html>