package com.qyf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.qyf.model.Usuario;
import com.qyf.repository.IUsuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class IUsuarioTest {
	
	@Autowired
	private IUsuario repo;
	
	//@Autowired
	//private TestEntityManager entityManager;
	
	@Test
	public void testCrearUsuario() {
		Usuario user = new Usuario();
		user.setActivo(1);
		user.setEmail("mr14015@ues.edu.sv");
		user.setPassword("1234");
		user.setApellidos("Molina");
		user.setNombres("Marcelo");
		repo.save(user);
	}
}
