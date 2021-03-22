$( document ).ready(function() {
    console.log( "ready!" );
});


$("#newitem").on("click",function(e){
	console.log("newItem!>>",e)
	newItems();
});


function newItems(){
	alert("ok");
	console.log("newItems");
		var count = $("#count");
		var productId = $("#productId");
		var totalPrice = $("#totalPrice");
		var userId = $("#userId");
		
		
		
	}