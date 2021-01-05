package com.qyf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qyf.interfaceService.IEvaluacionServ;
import com.qyf.interfaceService.IMateriaImpServ;
import com.qyf.model.Evaluacion;
import com.qyf.model.Materia_Imp;

@Controller
public class EvaluacionController {
	private String m;
	@Autowired
	private IEvaluacionServ evaluaciones;
	@Autowired
	private IMateriaImpServ materias;
	
	@GetMapping("/materia-imp/{id}/evaluaciones")
	public String consultar(@RequestParam(value="buscar", required=false) String palabra,
			@PathVariable Integer id, Model model) {
		List<Evaluacion> lista = evaluaciones.listar(palabra);
		if(!lista.isEmpty()) {
			for(int i = 0;i < lista.size();i++) {
				if(lista.get(i).getMateria().getId_materia_imp() != id)
					lista.remove(i);
				}
		}
		model.addAttribute("buscar", palabra);
		model.addAttribute("evaluaciones", lista);
		
		return "listaEvaluaciones";
	}
	
	@GetMapping("/materia-imp/{id}/agregar-evaluacion")
	public String agregar(@PathVariable int id, Model model) {
		Evaluacion e = new Evaluacion();
		Materia_Imp m = materias.listarId(id).get();
		e.setMateria(m); //Es necesario asignar la materia
		model.addAttribute("evaluacion", e);
		
		return "agregarEvaluacion";
	}
	
	@GetMapping("/materia-imp/{id_m}/editar-evaluacion/{id_ev}")
	public String form_editar(@PathVariable int id_m,
			@PathVariable int id_ev, Model model) {
		Optional<Evaluacion> e = evaluaciones.listaId(id_ev);
		model.addAttribute("evaluacion", e);
		
		return "editarEvaluacion";
	}
	
	@PostMapping("/saveEval")
	public String guardar(@Validated Evaluacion evaluacion, Model model) {
		evaluaciones.guardar(evaluacion);
		m = evaluacion.getMateria().getId_materia_imp().toString();
		
		return "redirect:/materia-imp/" + m + "/evaluaciones";
	}
	
	@GetMapping("/deleteEval/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		Evaluacion e = evaluaciones.listaId(id).get();
		m = e.getMateria().getId_materia_imp().toString();
		evaluaciones.eliminar(id);
		
		return "redirect:/materia-imp/" + m + "/evaluaciones";
	}
}
