package com.qyf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.qyf.interfaceService.IDepartamentoServ;
import com.qyf.interfaceService.IJefeServ;
import com.qyf.model.Departamento;
import com.qyf.model.Jefes_Depto;

@Controller
@RequestMapping
public class DepartamentoController {
	@Autowired
	private IDepartamentoServ departamentos;
	@Autowired
	private IJefeServ jefes;
	
	@RequestMapping("/departamentos")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Departamento> deptos = departamentos.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("departamentos", deptos);
		return "listaDepartamentos";
	}
	
	@GetMapping("/departamentos/agregar")
	public String form_agregar(Model model) {
		model.addAttribute("depto", new Departamento());
		List<Jefes_Depto> lista_jefes = jefes.listar();
		model.addAttribute("jefes", lista_jefes);
		return "agregarDepartamento";
	}
	
	@PostMapping("/guardarDepto")
	public String guardar(@Validated Departamento depto, Model model) {
		departamentos.guardar(depto);
		return "redirect:/departamentos";
	}
	
	@GetMapping("/departamentos/editar/{id}")
	public String form_editar(@PathVariable int id, Model model) {
		Optional<Departamento> depto = departamentos.listarId(id);
		List<Jefes_Depto> lista_jefes = jefes.listar();
		model.addAttribute("depto", depto);
		model.addAttribute("jefes", lista_jefes);
		return "editarDepartamento";
	}
	
	@PostMapping("/editDepto")
	public String editar(@Validated Departamento depto, Model model) {
		departamentos.guardar(depto);
		return "redirect:/departamentos";
	}
	
	@GetMapping("eliminarDepartamento/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		departamentos.delete(id);
		return "redirect:/departamentos";
	}
}
