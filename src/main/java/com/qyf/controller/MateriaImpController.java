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
import com.qyf.model.Curso;
import com.qyf.model.Materia;
import com.qyf.model.Materia_Imp;

@Controller
@RequestMapping
public class MateriaImpController {
	private String c;
	@Autowired
	private IMateriaImpServ impartidas;
	@Autowired
	private IMateriaServ materias;
	@Autowired
	private ICicloServ ciclos;
	@Autowired
	private ICoordinadorServ catedra;
	
	@RequestMapping("/ciclos/{id}/materias-imp")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, 
			 @PathVariable Integer id, Model model) {
		List<Materia_Imp> lista = impartidas.listar(palabra);
		if(!lista.isEmpty()) {
			for(int i = 0;i < lista.size();i++) { //Quita las materias que no pertenecen al ciclo
				if(lista.get(i).getCiclo().getId_ciclo() != id)
					lista.remove(i);
			}
		}
		model.addAttribute("buscar", palabra);
		model.addAttribute("materias", lista);
		
		return "listaMateriasImp";
	}
	
	@GetMapping("/ciclos/{id}/agregar-materia")
	public String form_agregar(@PathVariable Integer id, Model model) {
		Materia_Imp materia = new Materia_Imp();
		Optional<Ciclo> c = ciclos.listarId(id);
		materia.setCiclo(c.get()); //Le asigna el ciclo correspondiente
		List<Materia> listaMaterias = materias.listar(null);
		List<Coordinador> listaCoordinadores = catedra.listar();
		model.addAttribute("materia", materia);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("catedra", listaCoordinadores);
		
		return "agregarMateriaImp";
	}
	
	@GetMapping("/ciclos/editar-materia-imp/{id}")
	public String form_editar(@PathVariable int id, Model model) {
		Optional<Materia_Imp> materia = impartidas.listarId(id);
		List<Materia> listaMaterias = materias.listar(null);
		List<Coordinador> listaCoordinadores = catedra.listar();
		model.addAttribute("catedra", listaCoordinadores);
		model.addAttribute("materias", listaMaterias);
		model.addAttribute("materia", materia);
		
		return "editarMateriaImp";
	}
	
	@PostMapping("/saveMateriaImp")
	public String guardar(@Validated Materia_Imp m, Model model) {
		c = m.getCiclo().getId_ciclo().toString();
		impartidas.guardar(m);
		
		return "redirect:/ciclos/"+ c +"/materias-imp";
	}
	
	@GetMapping("/editar-materia-imp/{id}/cambiar-contrasena")
	public String establecer(@PathVariable int id, Model model) {
		Optional<Materia_Imp> m = impartidas.listarId(id);
		model.addAttribute("curso", m);
		
		return "establecerContrasena";
	}
	
	@PostMapping("/saveContrasena")
	public String guardarContra(@Validated Materia_Imp materia, Model model) {
		c = materia.getId_materia_imp().toString();
		impartidas.guardar(materia);
		
		return "redirect:/ciclos/editar-materia-imp/"+ c;
	}
	
	@GetMapping("/delMateriaImp/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		Optional<Materia_Imp> m = impartidas.listarId(id);
		c = m.get().getCiclo().getId_ciclo().toString();
		impartidas.eliminar(id);
		
		return "redirect:/ciclos/"+ c +"/materias-imp";
	}
}
