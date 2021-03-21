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
 <h2>manage User page</h2>
 	<c:if test="${not empty result}">
		<div class="alert alert-info" role="alert">
		  <c:out value="${result}" />
		</div>
	</c:if>
<br>
 <table class="table ">
  <thead>
    <tr>
      <th scope="col">userId</th>
      <th scope="col">username</th>
      <th scope="col">address1</th>
      <th scope="col">address2</th>
      <th scope="col">email</th>
      <th scope="col">phone</th>
      <th scope="col">delete</th>
    </tr>
  </thead>
 <c:forEach var="user" items="${userList}" >
  <tbody>
    <tr>
      <th scope="row">${user.userId }</th>
      <td>${user.username }</td>
      <td>${user.address1 }</td>
      <td>${user.address2 }</td>
      <td>${user.email }</td>
      <td>${user.phone }</td>
      <form method="post" action ="/admin/deleteUser">
      <td><button type="submit" class="btn btn-danger" value="${user.userId }" name="userId">삭제</button></td>
      </form>
    </tr>
  </tbody>
 </c:forEach>
</table>

</div>
<%@ include file= "../include/footer.jsp" %>
</body>
</html>