package com.jquispeluyo.micrometer;

import static org.junit.Assert.assertTrue;

import com.jquispeluyo.micrometer.mongo.IUsuarioRepo;
import com.jquispeluyo.micrometer.mongo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MicrometerApplicationTests {

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setNombre("lmanzo");
		us.setClave(encoder.encode("123"));

		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		us.setRoles(roles);
		Usuario retorno = repo.save(us);

		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
