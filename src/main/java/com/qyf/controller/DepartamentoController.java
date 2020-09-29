package com.qyf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.qyf.interfaceService.IDepartamentoServ;
import com.qyf.model.Departamento;

@Controller
@RequestMapping
public class DepartamentoController {
	@Autowired
	private IDepartamentoServ service;
	
	@RequestMapping("/departamentos")
	public String listar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		//System.out.println(palabra);
		List<Departamento> lista = service.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("departamentos",lista);
		return "listaDepartamentos";
	}
	
	@GetMapping("/nuevoDepartamento")
	public String agregar(Model model) {
		model.addAttribute("depto", new Departamento());
		return "agregarDepartamento";
	}
	
	@PostMapping("/guardar")
	public String save(@Validated Departamento depto, Model model) {
		model.getAttribute("depto");
		service.guardar(depto);
		return "redirect:/departamentos";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		java.util.Optional<Departamento> depto = service.listarId(id);
		model.addAttribute("depto", depto);
		return "editarDepartamento";
	}
	
	@PostMapping("/edit")
	public String edit(@Validated Departamento depto, Model model) {
		model.getAttribute("depto");
		service.guardar(depto);
		return "redirect:/departamentos";
	}
	
	@GetMapping("eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/departamentos";
	}
}
