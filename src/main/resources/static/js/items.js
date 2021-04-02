$( document ).ready(function() {
    console.log( "ready!" );
	listItems();
});


$("#newitem").on("click",function(e){
	console.log("newItem!>>",e)
	if($("#userId").val()==null){
		alert("로그인을 해 주십시요");
	}
	else{
		newItems();
	}
});

function listItems(){
	
	var userId;
	if ($("#userId").val()!=null){
			userId = $("#userId").val();
	
	$.ajax({
		url:"/items/" + userId,
		method: "GET",
		dataType:"json"
	}).done(function(data, status, xhr){
		console.log(data);
		console.log(status);
		console.log(xhr);	
		list(data);
	}).fail(function(xhr, status, errorThrown){
		console.log(xhr);
		console.log(status);
		console.log(errorThrown);
	});
			}
else{return;}
}

function list(data){
	console.log("list>>", data);
	var str = "";
	var items = $("tbody");
	if(data ==null|| data.length ==0){
		items.append("");
		return;
	}
	for(var i = 0, len = data.length || 0; i<len ;i++ ){
		
		str += "<tr>";
		str += "<td>"+ data[i].product.productName + "</td>";
		//str += "<td>"+ data[i].orderItem.count + "<select class=\"form-select mx-3\" id=\"updateCount\">";
		str += "<td>"+ data[i].orderItem.count + "<select class=\"form-select mx-3\" id=\"updateCount"+data[i].orderItem.orderItemId+"\">";
		str += "<option value=\"\">---</option>";
		str += "<option value=1>1</option>";
		str += "<option value=2>2</option>";
		str += "<option value=3>3</option>";
		str += "<option value=4>4</option></select>";
		str += "<button type=\"button\" class=\"btn btn-outline-dark btn-sm mx-3\" onClick=\"updateItems("+data[i].orderItem.orderItemId+","+data[i].product.price+","+data[i].product.productId+")\">변경</button></td>";
		str += "<td>" +data[i].orderItem.totalPrice + "</td>";
		str += "<td><button type=\"button\" class=\"btn btn-outline-danger\" onclick=\"deleteItems("+data[i].orderItem.orderItemId+")\">삭제</button></td>";
		str +=  "</tr>";
	}
	items.append(str);
	
	var totalOrderPrice = 0;
	for(var i = 0, len = data.length || 0; i<len ;i++ ){
		totalOrderPrice += data[i].orderItem.totalPrice;
		
	}
	console.log("totalOrderPrice>>",totalOrderPrice);
	$("#totalOrderPrice").val(totalOrderPrice +" 원");
	

}

function deleteItems(orderItemId){
		$.ajax({
			url:"/items/"+ orderItemId,
			method:"DELETE"
		}).done(function(data, status, xhr){
			alert("삭제되었습니다.");
			console.log(xhr);
			$("td").remove();
			listItems();
		}).fail(function(xhr,status,errorThrown){
			console.log(xhr);
			console.log(xhr.responseText);
			console.log(status);
			console.log(errorThrown);
		});
}

function updateItems(orderItemId,price,productId){
	
	var updateCount = $("[id= updateCount" + orderItemId+"]");
	console.log("orderItemId>>", updateCount);
	console.log("updateCount.val()>>" ,updateCount.val());
	
	var userId = $("#userId").val();
	var count = updateCount.val();
	var totalPrice = count*price;
	
	console.log("price>> ", price);
	console.log("productId>> ", productId);
	console.log("userId>> ", userId);
	console.log("totalPrice>> ", totalPrice);
	var data = {
		"orderItemId" : orderItemId,
		"count" : count,
		"totalPrice" : totalPrice,
		"productId" : productId,
		"userId" : userId	
	}
	
	$.ajax({
		url:"/items/"+ orderItemId,
		method: "PUT",
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8"
	}).done(function(data, status, xhr){
		alert("수량 변경되었습니다.")
		console.log(data);
		$("td").remove();
		listItems();
	}).fail(function(xhr,status,errorThrown){
		console.log(xhr);
		console.log(status);
		console.log(errorThrown);
	});
	

}

function newItems(){
		var count = $("#count").val();
		var productId = $("#productId").val();
		var totalPrice = $("#totalPrice").val()*count;
		var userId = $("#userId").val();
		var data = {	"count" : count,
						"productId" : productId,
						"totalPrice" : totalPrice,
						"userId" : userId }
		
		$.ajax({
			url:"/items/new",
			method:"POST",
			data: JSON.stringify(data),
			contentType:"application/json;charset=utf-8"
			
		}).done(function(data, status, xhr){
			alert("장바구니 담기 성공");
			console.log(xhr);
		}).fail(function(xhr,status,errorThrown){
			console.log(xhr);
			console.log(xhr.responseText);
			console.log(status);
			console.log(errorThrown);
		});
		
		
		
	}