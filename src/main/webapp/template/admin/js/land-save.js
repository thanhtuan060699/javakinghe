	$('#btnAddLand').click(function(){
					var data={};
					var buildingTypes=[];
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
		
					$.ajax({
						type: "GET",
						url: "http:/localhost:8080/homework/api-land",
						data: JSON.stringify(data),
						dataType: "json",
						contentType:"application/json",

						success: function (response) {
							console.log('success');
							location.reload(true);
						},
						error: function (response) {
							console.log('failed');
							console.log(response);
							location.reload(true);
						}
					});
					location.reload(true);
				});