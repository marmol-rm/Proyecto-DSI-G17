package com.qyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qyf.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer>{
	
	Usuario findByCorreo(String email);

	@Modifying
	@Query("update Usuario u set u.password = :password where u.id_user = :id")
	void updatePassword(@Param("password") String password, @Param("id") int id);
}
