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
	alert("ok");
	
}


function newItems(){
	alert("ok");
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
			alert("done");
			console.log(xhr);
		}).fail(function(xhr,status,errorThrown){
			console.log(xhr);
			console.log(xhr.responseText);
			console.log(status);
			console.log(errorThrown);
		});
		
		
		
	}