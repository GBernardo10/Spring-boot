package br.com.bandtec.AgendaDeObjetivos.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjetivoController {

	private TodosObjetivos todosObjetivos;

	@Autowired
	public ObjetivoController(TodosObjetivos todosObjetivos) {
		this.todosObjetivos = todosObjetivos;
	}

	@PostMapping("/objetivos")
	public ResponseEntity<String> cadastraObjetivo(@RequestBody Objetivo objetivo) {
		todosObjetivos.save(objetivo);
		return ResponseEntity.ok("Sucesso");	
	}

	@GetMapping("/objetivos/data/{data}")
	public List<Objetivo> buscar(@PathVariable("data") String dataString) {
		LocalDate data = LocalDate.parse(dataString);
		return todosObjetivos.ate(data);
	}

}
