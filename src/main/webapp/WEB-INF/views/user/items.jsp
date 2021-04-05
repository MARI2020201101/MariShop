<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../js/bootstrap.jsp"%>
</head>
<link rel="stylesheet" href="/css/style.css" id ="css">
<body>
<%@ include file= "../include/header.jsp" %>
<%@ include file= "../include/nav.jsp" %>
<div class="container" style="margin-top: 30px">

<form action="/order" method="post" id="orderForm">
<sec:authorize access="isAuthenticated()">
<input type="hidden" name = "userId" id="userId" value="<sec:authentication property="principal.user.userId" />">
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
			</tbody>
		</table>

		<hr>
<h2>총 합계 : </h2>
<input type = "text" class="form-control" readonly id="totalOrderPrice" name="totalOrderPrice">
<br>
<div align="right">
<button type="button" class="btn btn-outline-success" id="orderBtn" >주문하기</button>
</div>
<div id="orderDiv">
	    <div class="form-group">
	    <label for="address1">주소:</label>
	    <input type="text" class="form-control" placeholder="Enter address" id="sample6_address" name="address1" readonly>
	  </div>
	  <input type="button" onclick="sample6_execDaumPostcode()" value="주소입력하기"><br><br>
	    <div class="form-group">
	    <label for="address2">상세 주소:</label>
	    <input type="text" class="form-control" placeholder="상세주소 입력하기" id="address2" name="address2" required>
	  </div>
	  <div class="form-group">
	    <label for="phone">전화번호:</label>
	    <input type="text" class="form-control" placeholder="전화번호 입력하기" id="phone" name="phone" required maxlength="11">
	  </div>
<div align="right">
<button type="button" class="btn btn-outline-success" id="orderCommitBtn" >전송하기</button>
</div> 
</div>
</form>
</div>
<%@ include file= "../include/footer.jsp" %>
</body>
<script src = "/js/items.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_address").value = addr;
                
                } else {
                    document.getElementById("sample6_address").value = '';
                }
            
            }
        }).open();
    }
</script>
</html>