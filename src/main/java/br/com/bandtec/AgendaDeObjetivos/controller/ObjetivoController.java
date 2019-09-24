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

import br.com.bandtec.AgendaDeObjetivos.model.Objective;
import br.com.bandtec.AgendaDeObjetivos.repository.AllObjective;

@RestController
public class ObjetivoController {

	private AllObjective todosObjetivos;

	@Autowired
	public ObjetivoController(AllObjective todosObjetivos) {
		this.todosObjetivos = todosObjetivos;
	}

	@PostMapping("/objetivos")
	public ResponseEntity<String> cadastraObjetivo(@RequestBody Objective objetivo) {
		todosObjetivos.save(objetivo);
		return ResponseEntity.ok("Sucesso");	
	}

	@GetMapping("/objetivos/data/{data}")
	public List<Objective> buscar(@PathVariable("data") String dataString) {
		LocalDate data = LocalDate.parse(dataString);
		return todosObjetivos.ate(data);
	}
	
	@GetMapping("/objetivos")
	public ResponseEntity<List<Objective>> cadastraObjetivo() {
		return ResponseEntity.ok(todosObjetivos.findAll());	
	}

}
