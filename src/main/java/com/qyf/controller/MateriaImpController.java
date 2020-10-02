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

import com.qyf.interfaceService.IMateriaImpServ;
import com.qyf.model.Materia_Imp;

@Controller
@RequestMapping
public class MateriaImpController {
	@Autowired
	private IMateriaImpServ service;
	
	@RequestMapping("/materiasImpartidas")
	public String listar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		//System.out.println(palabra);
		List<Materia_Imp> lista = service.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("materias",lista);
		return "listaMatImpartidas";
	}
	
	@GetMapping("/nuevaMateriaImp")
	public String agregar(Model model) {
		model.addAttribute("materia", new Materia_Imp());
		return "agregarMateriaImp";
	}
	
	@PostMapping("/guardarMateriaImp")
	public String save(@Validated Materia_Imp m, Model model) {
		model.getAttribute("materia");
		service.guardar(m);
		return "redirect:/materiasImpartidas";
	}
	
	@GetMapping("/editarMateriaImp/{id}")
	public String editar(@PathVariable int id, Model model) {
		java.util.Optional<Materia_Imp> m = service.listarId(id);
		model.addAttribute("materia", m);
		return "editarMateriaImp";
	}
	
	@PostMapping("/editMateriaImp")
	public String edit(@Validated Materia_Imp m, Model model) {
		model.getAttribute("materia");
		service.guardar(m);
		return "redirect:/materiasImpartidas";
	}
	
	@GetMapping("eliminarMateriaImp/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/materiasImpartidas";
	}
}
