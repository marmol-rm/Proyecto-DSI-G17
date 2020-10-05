package com.qyf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ues.edu.dsi215.modelos.Roles;
import com.ues.edu.dsi215.modelos.Usuarios;


@Service
public class UserCostumServiceImpl implements UserDetailsService {
	@Autowired
    private UsuariosService service;

    @Override
    public UserDetails loadUserByUsername(String usermane) throws UsernameNotFoundException {
       Usuarios usuario=service.findByUsername(usermane);
      if(usuario==null){
          System.err.println("NO ENCONTRADO");
          throw new UsernameNotFoundException("Usuario no encontrado");
      }
       return new org.springframework.security.core
               .userdetails
               .User(usuario.getUsername(), usuario.getPassword(), 
                 true, true, true, true, getGrantedAuthorities(usuario));
    }
    private List<GrantedAuthority> getGrantedAuthorities(Usuarios usuario){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();        
        for(Roles rol : usuario.getRoles()){
            System.out.println("NOMBRE ROL: "+rol.getTipoRol());
            authorities.add(new SimpleGrantedAuthority("ROLE_"+rol.getTipoRol()));
            
        }        
        service.updateUserLastLogging(usuario.getId());
        return authorities;
    }
}
