<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    <input type="text" class="form-control" placeholder="Enter Username" id="username" name="username" autofocus required>
	  </div>
	    <div class="form-group">
	    <label for="password">비밀번호:</label>
	    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password" autofocus required>
	  </div>
	    <div class="form-group">
	    <label for="email">Email address:</label>
	    <input type="email" class="form-control" placeholder="Enter email" id="email" name="email" autofocus required>
	  </div>
	    <div class="form-group">
	    <label for="address1">주소:</label>
	    <input type="text" class="form-control" placeholder="Enter address" id="address1" name="address1" autofocus required>
	  </div>
	    <div class="form-group">
	    <label for="address2">상세 주소:</label>
	    <input type="text" class="form-control" placeholder="Enter address detail" id="address2" name="address2" autofocus required>
	  </div>
	  <div class="form-group">
	    <label for="phone">전화번호:</label>
	    <input type="text" class="form-control" placeholder="Enter phoneNumber" id="phone" name="phone" autofocus required maxlength="11">
	  </div>
	  <button type="button" class="btn btn-primary" id="reg-btn">Submit</button>
	</form>
</div>
<%@ include file= "include/footer.jsp" %>
</body>
</html>
<script>
var idCheck = $("#id-check");
var checked = false;

/* function maxLengthCheck(){
	var phone = $("#phone");
	var maxlength = $("#phone").attr("maxlength")
    if (phone.value.length > maxlength){
    	phone.value = phone.value.substr(0, maxlength));
    }    
  } */
$(idCheck).on("click", function(e){
	e.preventDefault();
	var username = $("#username").val();
	
	console.log(username);
	$.ajax({
		url:"/idCheck",
		type:"post",
		data: username,
		contentType: "application/json; charset=utf-8",
		dataType: "text"		
		}).done(function(result){
			alert(result);
			console.log(result);
			if(result=="사용할 수 있는 닉네임입니다!"){checked = true;}
			else{checked = false;}
			
			});
});
$("#reg-btn").on("click", function(e){
	if(checked == false){
		alert("닉네임을 체크해주세욧!");}
	else $("form").submit();
});
</script>