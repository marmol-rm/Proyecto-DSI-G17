function check(input) {
   if (input.value == 0) {
     input.setCustomValidity('Debe ser diferente a 0');
   } else {
     // input is fine -- reset the error message
     input.setCustomValidity('');
   }
}

function eliminarUsuario(id) {
  swal({
  title: "Eliminar",
  text: "Está seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Si) => {
  if (Si) {
    $.ajax({
      url:"/deleteUser/"+id,
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

function eliminarDepartamento(id) {
  swal({
  title: "Eliminar",
  text: "Está seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
    $.ajax({
      url:"/deleteDepto/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="redirect:/departamentos";
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
  text: "Está seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
    $.ajax({
      url:"/deleteMateria/"+id,
      success: function(res){
        console.log(res);
      }
    }).then((Ok)=>{
      if(Ok){
        location.href="/materias";
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
  text: "Está seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Si) => {
  if (Si) {
    $.ajax({
      url:"/deleteCiclo/"+id,
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

function eliminarMateriaImp(id) {
  swal({
  title: "Eliminar",
  text: "Está seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Si) => {
  if (Si) {
    $.ajax({
      url:"/delMateriaImp/"+id,
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

function eliminarEvaluacion(id) {
  swal({
  title: "Eliminar",
  text: "Está seguro?",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
    $.ajax({
      url:"/deleteEval/"+id,
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