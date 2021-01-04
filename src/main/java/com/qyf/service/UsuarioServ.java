package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IUsuarioServ;
import com.qyf.model.Role;
import com.qyf.model.Usuario;
import com.qyf.repository.IUsuario;

@Service
public class UsuarioServ implements IUsuarioServ{
	
	@Autowired
	private IUsuario data;
	
	@Override
	public List<Usuario> listar(String key) {
		if(key!=null) {
			return (List<Usuario>) data.findAll(key);
		}
		else
		return (List<Usuario>) data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(Long id) {

		return data.findById(id);
	}

	@Override
	public int guardar(Usuario user) {
		int res=0;
		Usuario u = data.save(user);
		if(!u.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(Long id) {
		data.deleteById(id);
	}

	@Override
	public void iniciarAdmin(Role r) {
		long vacio = data.count();
		if(vacio == 0) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPass = encoder.encode("sysadmin");
			Usuario admin = new Usuario("admin",encodedPass,1,r);
			data.save(admin);
		}
	}

	@Override
	public Usuario listarEmail(String email) {
		
		return data.findByEmail(email);
	}
}
