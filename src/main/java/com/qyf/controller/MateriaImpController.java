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
import com.qyf.interfaceService.ICursoServ;
import com.qyf.interfaceService.IMateriaImpServ;
import com.qyf.interfaceService.IMateriaServ;
import com.qyf.model.Ciclo;
import com.qyf.model.Coordinador;
import com.qyf.model.Curso;
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
	@Autowired
	private ICursoServ cursos;
	
	@RequestMapping("/editarCiclo/{id}/materiasImpartidas")
	public String listar(@RequestParam(value="buscar", required=false) String palabra, 
			 @PathVariable int id, Model model) {
		List<Materia_Imp> lista = impartidas.listar(palabra);
		for(int i = 0;i < lista.size();i++) { //Quita las materias que no pertenecen al ciclo
			if(lista.get(i).getCiclo().getId_ciclo() != id)
				lista.remove(i);
		}
		model.addAttribute("buscar",palabra);
		model.addAttribute("materias", lista);
		
		return "listaMateriasImp";
	}
	
	@GetMapping("/editarCiclo/{id}/agregar")
	public String agregar(@PathVariable Integer id, Model model) {
		Optional<Ciclo> c = ciclos.listarId(id);
		Ciclo ciclo = c.get();
		List<Materia> listaMaterias = materias.listar(null);
		List<Coordinador> listaCoordinadores = catedra.listar();
		Materia_Imp materia = new Materia_Imp();
		materia.setCiclo(ciclo); //Le asigna el ciclo correspondiente
		model.addAttribute("materia", materia);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("catedra", listaCoordinadores);
		
		return "agregarMateriaImp";
	}
	
	@PostMapping("/guardarMateriaImp")
	public String save(@Validated Materia_Imp m, Model model) {
		impartidas.guardar(m);
		
		return "redirect:/ciclos";
	}
	
	@GetMapping("/editarMateriaImp/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Materia_Imp> materia = impartidas.listarId(id);
		List<Materia> listaMaterias = materias.listar(null);
		List<Coordinador> listaCoordinadores = catedra.listar();
		model.addAttribute("catedra", listaCoordinadores);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("materia", materia);
		
		return "editarMateriaImp";
	}
	
	@PostMapping("/editMateriaImp")
	public String edit(@Validated Materia_Imp m, Model model) {
		impartidas.guardar(m);
		
		return "redirect:/ciclos";
	}
	
	@GetMapping("eliminarMateriaImp/{id}")
	public String delete(@PathVariable int id, Model model) {
		impartidas.delete(id);
		
		return "redirect:/ciclos";
	}
}
