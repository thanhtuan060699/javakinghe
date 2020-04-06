	
function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$('#btnAddAppointment').click(function(){
					var vars={};
					var data={};
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
					data['idCustomer']=getUrlVars()["id"];
					$.ajax({
						type: "POST",
						url: "http://localhost:8080/homework/api-appointment",
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