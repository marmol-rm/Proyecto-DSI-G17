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

import com.qyf.interfaceService.ICicloServ;
import com.qyf.interfaceService.ICoordinadorServ;
import com.qyf.interfaceService.IMateriaImpServ;
import com.qyf.interfaceService.IMateriaServ;
import com.qyf.model.Ciclo;
import com.qyf.model.Coordinador;
import com.qyf.model.Materia;
import com.qyf.model.Materia_Imp;

@Controller
@RequestMapping
public class MateriaImpController {
	@Autowired
	private IMateriaImpServ impartidas;
	@Autowired
	private IMateriaServ materias;
	@Autowired
	private ICicloServ ciclos;
	@Autowired
	private ICoordinadorServ catedra;
	
	@RequestMapping("/editarCiclo/{id}/materiasImpartidas")
	public String listar(@RequestParam(value="buscar", required=false) String palabra, 
			 @PathVariable int id, Model model) {
		List<Materia_Imp> lista = impartidas.listar(palabra);
		model.addAttribute("ciclo", new Ciclo());
		model.addAttribute("buscar",palabra);
		model.addAttribute("materias",lista);
		return "listaMateriasImp";
	}
	
	@GetMapping("/editarCiclo/{id}/agregar/")
	public String agregar(@PathVariable Integer id, Model model) {
		Optional<Ciclo> c = ciclos.listarId(id);
		Ciclo ciclo = c.get();
		List<Materia> listaMaterias = materias.listar(null);
		List<Coordinador> listaCoordinadores = catedra.listar();
		model.addAttribute("materia", new Materia_Imp());
		model.addAttribute("ciclo", ciclo);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("catedra", listaCoordinadores);
		return "agregarMateriaImp";
	}
	
	@PostMapping("/guardarMateriaImp")
	public String save(@Validated Materia_Imp m, Model model) {
		model.getAttribute("materia");
		impartidas.guardar(m);
		return "redirect:/ciclos";
	}
	
	@GetMapping("/editarMateriaImp/{id}")
	public String editar(@PathVariable int id, Model model) {
		java.util.Optional<Materia_Imp> m = impartidas.listarId(id);
		List<Materia> listaMaterias = materias.listar(null);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("materia", m);
		return "editarMateriaImp";
	}
	
	@PostMapping("/editMateriaImp")
	public String edit(@Validated Materia_Imp m, Model model) {
		model.getAttribute("materia");
		impartidas.guardar(m);
		return "redirect:/ciclos";
	}
	
	@GetMapping("eliminarMateriaImp/{id}")
	public String delete(@PathVariable int id, Model model) {
		impartidas.delete(id);
		return "redirect:/ciclos";
	}
}
