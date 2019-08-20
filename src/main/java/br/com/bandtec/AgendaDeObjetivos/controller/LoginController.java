package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@PostMapping("/login")
	public ResponseEntity<String> validateLogin(@RequestBody Credentials credentials) {
		if (credentials.getPassword().equals(credentials.getLogin())) {
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
	}
}
