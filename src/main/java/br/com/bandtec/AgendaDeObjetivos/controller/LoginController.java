package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	private TodosUsuarios todosUsuarios;

	@Autowired
	public LoginController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	@PostMapping("/login")
	public ResponseEntity<String> validar(@RequestBody Credentials credentials) {
		if (todosUsuarios.existe(credentials.getLogin(), credentials.getSenha()) == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("erro");
		}
		return ResponseEntity.ok("Sucesso");
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(todosUsuarios.save(usuario));
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> buscarUsuarios() {
		return ResponseEntity.ok(todosUsuarios.findAll());
	}

//	@PostMapping("/login")
//	public ResponseEntity<String> validateLogin(@RequestBody Credentials credentials) {
//		if (credentials.getPassword().equals(credentials.getLogin())) {
//			return ResponseEntity.ok("Success");
//		}
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
//	}
}
