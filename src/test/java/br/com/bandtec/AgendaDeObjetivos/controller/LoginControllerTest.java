package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {

	@Test
	public void loginSuccess() {
		LoginController loginController = new LoginController();

		ResponseEntity<String> response = loginController.validateLogin(new Credentials("login", "password"));
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Success", response.getBody());
	}

	public void loginError() {

	}
}
