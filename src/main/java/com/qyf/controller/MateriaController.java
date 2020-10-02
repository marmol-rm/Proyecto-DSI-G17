package com.qyf.controller;

import java.util.List;

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
	private IMateriaServ service;
	@Autowired
	private IDepartamentoServ dservice;
	
	@RequestMapping("/materias")
	public String listar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		//System.out.println(palabra);
		List<Materia> lista = service.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("materias",lista);
		return "listaMaterias";
	}
	
	@GetMapping("/nuevaMateria")
	public String agregar(Model model) {
		model.addAttribute("materia", new Materia());
		return "agregarMateria";
	}
	
	@PostMapping("/guardarMateria")
	public String save(@Validated Materia m, Model model) {
		model.getAttribute("materia");
		service.guardar(m);
		return "redirect:/materias";
	}
	
	@GetMapping("/datosMateria/{id}")
	public String ver(@PathVariable int id, Model model) {
		java.util.Optional<Materia> m = service.listarId(id);
		model.addAttribute("materia", m);
		return "verMateria";
	}
	
	@GetMapping("/editarMateria/{id}")
	public String editar(@PathVariable int id, Model model) {
		java.util.Optional<Materia> m = service.listarId(id);
		model.addAttribute("materia", m);
		return "editarMateria";
	}
	
	@PostMapping("/editMateria")
	public String edit(@Validated Materia m, Model model) {
		model.getAttribute("materia");
		service.guardar(m);
		return "redirect:/materias";
	}
	
	@GetMapping("eliminarMateria/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/materias";
	}
}
