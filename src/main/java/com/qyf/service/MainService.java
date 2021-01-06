package com.qyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IMainService;
import com.qyf.model.Role;
import com.qyf.model.Tipo_Solicitud;
import com.qyf.model.Usuario;
import com.qyf.repository.IRole;
import com.qyf.repository.ITipoSolicitud;
import com.qyf.repository.IUsuario;

@Service
public class MainService implements IMainService {
	@Autowired
	private IRole roles;
	@Autowired
	private ITipoSolicitud tipos_sol;
	@Autowired
	private IUsuario users;

	@Override
	public void inicializar() {
		long n = roles.count();
		if(n != 0) { //Crea roles
			Role e = new Role("Estudiante","Rol de estudiante");
			roles.save(e);
			Role c = new Role("Coordinador","Rol del coordinador de catedra");
			roles.save(c);
			Role j = new Role("Jefe de Departamento","Rol del jefe de departamento");
			roles.save(j);
			Role a = new Role("Admin","Rol de administrador del sistema");
			roles.save(a);
		}
		
		n = tipos_sol.count();
		if(n != 0) { //Crea tipos de solicitud
			Tipo_Solicitud rep = new Tipo_Solicitud("Solicitud de evaluacion repetida");
			tipos_sol.save(rep);
			Tipo_Solicitud d = new Tipo_Solicitud("Solicitud de evaluacion diferida");
			tipos_sol.save(d);
			Tipo_Solicitud rev = new Tipo_Solicitud("Solicitud de revision de evaluacion");
			tipos_sol.save(rev);
			Tipo_Solicitud c = new Tipo_Solicitud("Solicitud de cambio de fecha de evaluacion");
			tipos_sol.save(c);
		}
		
		n = users.count();
		if(n == 0) { //Crea el usuario admin
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String pass = encoder.encode("sysadmin");
			Usuario admin = new Usuario("admin",pass,1,roles.findById(4).get());
			users.save(admin);
		}
	}
}
