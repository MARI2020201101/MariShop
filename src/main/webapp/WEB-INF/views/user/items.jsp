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
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">상품</th>
      <th scope="col">구매수량</th>
      <th scope="col">총 가격</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
  </tbody>
</table>
</div>
<%@ include file= "../include/footer.jsp" %>
</body>
<script src = "/js/items.js"></script>
</html>