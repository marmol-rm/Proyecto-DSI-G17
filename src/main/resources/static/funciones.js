function check(input) {
   if (input.value == 0) {
     input.setCustomValidity('Debe ser diferente a 0');
   } else {
     // input is fine -- reset the error message
     input.setCustomValidity('');
   }
}

function eliminarDepartamento(id) {
  swal({
  title: "Eliminar",
  text: "Esta seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("Your imaginary file is safe!");
  }
});
 }
