$(btnAddCustomer).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/homework/api-customer",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			console.log('success');
			
		},
		error: function (response) {
			console.log('failed');
			console.log(response);
		}
	});
	location.reload(true);
	
})