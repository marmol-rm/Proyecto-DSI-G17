package com.qyf.controller;

import java.util.List;
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
	public String listar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		//System.out.println(palabra);
		List<Ciclo> lista = service.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("ciclos",lista);
		return "listaCiclos";
	}
	
	@GetMapping("/nuevoCiclo")
	public String agregar(Model model) {
		model.addAttribute("ciclo", new Ciclo());
		return "agregarCiclo";
	}
	
	@PostMapping("/guardarCiclo")
	public String save(@Validated Ciclo c, Model model) {
		model.getAttribute("ciclo");
		service.guardar(c);
		return "redirect:/ciclos";
	}
	
	@GetMapping("/editarCiclo/{id}")
	public String editar(@PathVariable int id, Model model) {
		java.util.Optional<Ciclo> ciclo = service.listarId(id);
		model.addAttribute("ciclo", ciclo);
		return "editarCiclo";
	}
	
	@PostMapping("/editCiclo")
	public String edit(@Validated Ciclo c, Model model) {
		model.getAttribute("ciclo");
		service.guardar(c);
		return "redirect:/departamentos";
	}
	
	@GetMapping("eliminarCiclo/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/ciclos";
	}
}
