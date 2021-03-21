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
      <td><a href=/admin/updateProduct?productId=${product.productId }
      	class="btn btn-warning" name="productId">수정</a></td>

    </tr>
  </tbody>
 </c:forEach>
</table>

</div>
<%@ include file= "../include/footer.jsp" %>
</body>
<c:if test="${not empty result}">
<script>

</script>
</c:if>
</html>