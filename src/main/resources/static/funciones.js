function check(input) {
   if (input.value == 0) {
     input.setCustomValidity('Debe ser diferente a 0');
   } else {
     // input is fine -- reset the error message
     input.setCustomValidity('');
   }
 }
 
function mensajeEliminar(id){
	swal("Esta seguro?", {
	 buttons: ["No", "Si"],
	});
	.then((Si)=> {
	if(Si){
		$.ajax({
			url:"/eliminar/"+id,
			success: function(res){
				console.log(res);
			}
			location.href="/departamentos";
		});
	}});
}
