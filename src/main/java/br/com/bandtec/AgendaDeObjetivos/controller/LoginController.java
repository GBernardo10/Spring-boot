package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.bandtec.AgendaDeObjetivos.repository.AllUser;
import br.com.bandtec.AgendaDeObjetivos.service.Credentials;;

@RestController
public class LoginController {

	private AllUser allUser;

	@Autowired
	public LoginController(AllUser allUser) {
		this.allUser = allUser;
	}

	@PostMapping("/login")
	public ResponseEntity<String> existeUsuario(@RequestBody Credentials credentials) {
		if (allUser.validaLoginESenha(credentials) == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
		}
		return ResponseEntity.ok("Success");
	}

}
