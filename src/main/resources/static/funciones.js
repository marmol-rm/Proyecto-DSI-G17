function eliminarDepartamento(id){
	swal("Desea eliminar este Departamento?", {
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
