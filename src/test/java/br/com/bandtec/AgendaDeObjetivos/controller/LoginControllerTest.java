package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bandtec.AgendaDeObjetivos.controller.LoginController;
import br.com.bandtec.AgendaDeObjetivos.model.User;
import br.com.bandtec.AgendaDeObjetivos.repository.AllUser;
import br.com.bandtec.AgendaDeObjetivos.service.Credentials;

public class LoginControllerTest {
	private LoginController loginController;
	private AllUser allUser;

	@Before
	public void setUp() {
		allUser = Mockito.mock(AllUser.class);
		loginController = new LoginController(allUser);
	}

	@Test
	public void loginSuccess() {
		Credentials credentials = new Credentials("igual", "igual");
		Mockito.when(allUser.validaLoginESenha(credentials)).thenReturn(new User("nome", 23));
		ResponseEntity<String> response = loginController.existeUsuario(credentials);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Success", response.getBody());
	}

	@Test
	public void loginError() {
		ResponseEntity<String> response = loginController.existeUsuario(new Credentials("login", "senha"));
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		assertEquals("Failed", response.getBody());

	}
}
