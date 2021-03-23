<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수량 변경 페이지</title>
</head>
<body>
<%@ include file="../js/bootstrap.jsp"%>
<div class="container">
<br>
<h2>수량 변경 페이지</h2>
<hr>
<select class="form-select form-control" id="updateCount">
							<option value="">---</option>
							<option value=1>1</option>
							<option value=2>2</option>
							<option value=3>3</option>
							<option value=4>4</option>
					</select>
					<button type="button" id="update" class="btn btn-outline-dark my-3" onClick="window.close()">변경</button>
</div>
</body>
<script src = "/js/items.js"></script>
</html>