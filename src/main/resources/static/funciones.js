function check(input) {
   if (input.value == 0) {
     input.setCustomValidity('Debe ser diferente a 0');
   } else {
     // input is fine -- reset the error message
     input.setCustomValidity('');
   }
}

function estadoCiclo(estado){
  if(estado.value == 1){
    text.setCustomValidity('Activo');
  } else{
    text.setCustomValidity('Inactivo');
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
.then((Si) => {
  if (Si) {
    $.ajax({
      url:"/eliminarDepartamento/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/departamentos";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarUsuario(id) {
  swal({
  title: "Eliminar",
  text: "Esta seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Si) => {
  if (Si) {
    $.ajax({
      url:"/eliminarUnuario/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/usuarios";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarMateria(id) {
  swal({
  title: "Eliminar",
  text: "Esta seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Si) => {
  if (Si) {
    $.ajax({
      url:"/eliminarMateria/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/Materias";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}

function eliminarCiclo(id) {
  swal({
  title: "Eliminar",
  text: "Esta seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Si) => {
  if (Si) {
    $.ajax({
      url:"/eliminarCiclo/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/ciclos";
      }
    });
    swal("Eliminado!", {
      icon: "success",
    });
  } else {
    swal("No pasa nada.");
  }
});
}