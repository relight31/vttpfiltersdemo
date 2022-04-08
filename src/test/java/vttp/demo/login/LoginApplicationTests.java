package vttp.demo.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp.demo.login.controllers.LoginController;
import vttp.demo.login.repository.LoginRepo;
import vttp.demo.login.services.LoginService;

@SpringBootTest
class LoginApplicationTests {
	@Autowired
	LoginController controller;

	@Autowired
	LoginService service;

	@Autowired
	LoginRepo repo;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldMakeBeans(){
		assertNotNull(controller);
		assertNotNull(service);
		assertNotNull(repo);
	}
}
