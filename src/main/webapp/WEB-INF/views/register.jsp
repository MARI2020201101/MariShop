<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
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
<div class ="container">
	<form action="/register" method="post">
	  <div class="form-group">
	    <label for="username">회원 아이디:&nbsp;
	    <button class="btn btn-primary btn-sm" id="id-check">중복체크</button></label>
	    <input type="text" class="form-control" placeholder="Enter Username" id="username" name="username" autofocus>
	  </div>
	    <div class="form-group">
	    <label for="password">비밀번호:</label>
	    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password" autofocus>
	  </div>
	    <div class="form-group">
	    <label for="email">Email address:</label>
	    <input type="email" class="form-control" placeholder="Enter email" id="email" name="email" autofocus>
	  </div>
	    <div class="form-group">
	    <label for="address1">주소:</label>
	    <input type="text" class="form-control" placeholder="Enter address" id="address1" name="address1" autofocus>
	  </div>
	    <div class="form-group">
	    <label for="address2">상세 주소:</label>
	    <input type="text" class="form-control" placeholder="Enter address detail" id="address2" name="address2" autofocus>
	  </div>
	  <div class="form-group">
	    <label for="phone">전화번호:</label>
	    <input type="text" class="form-control" placeholder="Enter phoneNumber" id="phone" name="phone" autofocus>
	  </div>
	  <button type="button" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file= "include/footer.jsp" %>
</body>
</html>
<script>
var idCheck = $("#id-check");
$(idCheck).on("click", function(e){
	e.preventDefault();
	var username = $("#username").val();
	console.log(username);
	$.ajax({
		url:"/idCheck",
		type:"post",
		data: username,
		contentType: "application/json; charset=utf-8",
		dataType: "json"
		}).done(function(result){
			console.log(result);
			alert(result);
			});
});
</script>