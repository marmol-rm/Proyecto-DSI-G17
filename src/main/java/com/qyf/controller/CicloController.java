package com.qyf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.qyf.interfaceService.ICicloServ;
import com.qyf.model.Ciclo;

@Controller
@RequestMapping
public class CicloController {
	@Autowired
	private ICicloServ service;
	
	@RequestMapping("/ciclos")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Ciclo> lista = service.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("ciclos",lista);
		return "listaCiclos";
	}
	
	@GetMapping("/ciclos/agregar")
	public String form_agregar(Model model) {
		model.addAttribute("ciclo", new Ciclo());
		return "agregarCiclo";
	}
	
	@PostMapping("/guardarCiclo")
	public String save(@Validated Ciclo c, Model model) {
		service.guardar(c);
		return "redirect:/ciclos";
	}
	
	@GetMapping("/ciclos/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Ciclo> ciclo = service.listarId(id);
		model.addAttribute("ciclo", ciclo);
		return "editarCiclo";
	}
	
	@PostMapping("/editCiclo")
	public String edit(@Validated Ciclo c, Model model) {
		service.guardar(c);
		return "redirect:/ciclos";
	}
	
	@GetMapping("eliminarCiclo/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/ciclos";
	}
}
