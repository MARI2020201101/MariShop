<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../js/bootstrap.jsp"%>
</head>
<body>
<%@ include file= "../include/header.jsp" %>
<%@ include file= "../include/nav.jsp" %>
<div class="container" style="margin-top: 30px">
<sec:authorize access="isAuthenticated()">
<input type="hidden" id="userId" value="<sec:authentication property="principal.user.userId" />">
</sec:authorize>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">상품명</th>
					<th scope="col">구매수량</th>
					<th scope="col">총 가격</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
	<!-- 			<tr>
					<td>productName</td>
					<td>count 
						<button type="button" class="btn btn-outline-dark btn-sm" onClick="updateItems()">변경</button>
					</td>
					<td>totalPrice</td>
				</tr> -->
			</tbody>
		</table>

		<hr>
<h2>총 합계 : </h2>
<input type = "text" class="form-control" readonly id="totalOrderPrice">
</div>
<%@ include file= "../include/footer.jsp" %>
</body>
<script src = "/js/items.js"></script>
</html>