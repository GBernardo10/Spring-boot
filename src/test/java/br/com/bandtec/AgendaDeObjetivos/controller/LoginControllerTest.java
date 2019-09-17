//package br.com.bandtec.AgendaDeObjetivos.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import br.com.bandtec.AgendaDeObjetivos.controller.Credentials;
//import br.com.bandtec.AgendaDeObjetivos.controller.LoginController;
//
//public class LoginControllerTest {
//	private LoginController loginController;
//
//	@Before
//	public void setUp() {
//		loginController = new LoginController();
//	}
//
//	@Test
//	public void loginSuccess() {
//		ResponseEntity<String> response = loginController.validateLogin(new Credentials("igual", "igual"));
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals("Success", response.getBody());
//	}
//
//	@Test
//	public void loginError() {
//
//		ResponseEntity<String> response = loginController.validateLogin(new Credentials("login", "senha"));
//		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//		assertEquals("Failed", response.getBody());
//
//	}
//}
