package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	Usuario findByEmail(String email);
	
	@Query("SELECT u FROM Usuario u WHERE "+
	"CONCAT(u.id_user, u.nombres, u.apellidos, u.email, u.role.nombre) LIKE %?1%")
	List<Usuario> findAll(String key);
}
