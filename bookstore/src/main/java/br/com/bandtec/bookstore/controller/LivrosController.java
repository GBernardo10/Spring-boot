package br.com.bandtec.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.bookstore.model.Livro;
import br.com.bandtec.bookstore.services.LivroService;

@RestController
public class LivrosController {

	private LivroService service;

	@Autowired
	public LivrosController(LivroService service) {
		this.service = service;
	}

	@GetMapping("/livros/tema/{tema}")
	public ResponseEntity<List<Livro>> buscarLivroPorTema(@PathVariable("tema") String tema) {
		List<Livro> livros = service.buscarPorTema(tema);
		
		if (livros.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(livros);
	}

}
