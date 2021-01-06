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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qyf.interfaceService.IDepartamentoServ;
import com.qyf.interfaceService.IMateriaServ;
import com.qyf.model.Departamento;
import com.qyf.model.Materia;

@Controller
@RequestMapping
public class MateriaController {
	@Autowired
	private IMateriaServ materias;
	@Autowired
	private IDepartamentoServ deptos;
	
	@RequestMapping("/materias")
	public String form_consultar(
	@RequestParam(value="buscar", required=false) String palabra,
	Model model) {
		List<Materia> lista = materias.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("materias",lista);
		return "listaMaterias";
	}
	
	@GetMapping("/materias/agregar")
	public String form_agregar(Model model) {
		model.addAttribute("materia", new Materia());
		List<Departamento> lista = deptos.listar(null);
		model.addAttribute("departamentos", lista);
		return "agregarMateria";
	}
	
	@GetMapping("/materias/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Optional<Materia> m = materias.listarId(id);
		List<Departamento> lista = deptos.listar(null);
		model.addAttribute("departamentos", lista);
		model.addAttribute("materia", m);
		return "editarMateria";
	}
	
	@PostMapping("/saveMateria")
	public String guardar(@Validated Materia materia, Model model) {
		if(materia.getCodigo().length() == 6 &&
			materia.getDepartamento().getId_depto() != 0)
			materias.guardar(materia);
		
		return "redirect:/materias";
	}
	
	@GetMapping("/deleteMateria/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		materias.delete(id);
		
		return "redirect:/materias";
	}
}
