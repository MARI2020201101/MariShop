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

<div class="container " style="margin-top:30px">
 <h2>manage Product page</h2>
 <div>
  	<c:if test="${not empty result}">
		<div class="alert alert-info" role="alert">
		  <c:out value="${result}" />
		</div>
	</c:if>
</div>
 <a href=/admin/insertProduct class="btn btn-info my-3 float-right" name="productId">상품등록</a>
<br>
 <table class="table ">
  <thead>
    <tr>
      <th scope="col">ProductId</th>
      <th scope="col">productName</th>
      <th scope="col">stock</th>
      <th scope="col">price</th>
      <th scope="col">categoryId</th>
      <th scope="col">update</th>
    </tr>
  </thead>
 <c:forEach var="product" items="${productList}" >
  <tbody>
    <tr>
      <th scope="row">${product.productId }</th>
      <td>${product.productName }</td>
      <td>${product.stock }</td>
      <td>${product.price }</td>
      <td>${product.categoryId }</td>
      <td><a href="/admin/updateProduct?productId=${product.productId }"
      	class="btn btn-warning" name="productId">수정</a></td>

    </tr>
  </tbody>
 </c:forEach>
</table>
<form id="move" action="/admin/manageProduct" method="get">
<input type ="hidden" name ="totalCnt" value="${pageObject.totalCnt }">
		<input type ="hidden" name ="keyword" value="${pageObject.cri.keyword }">
		<input type="hidden" name="categoryId" value="${pageObject.cri.categoryId }">
		<input type="hidden" name="currPage" >
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
<%@ include file= "../include/footer.jsp" %>
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