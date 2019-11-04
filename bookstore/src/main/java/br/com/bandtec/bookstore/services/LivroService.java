package br.com.bandtec.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.bandtec.bookstore.model.Livro;

@Service
public class LivroService {

	private List<Livro> livros;

	public List<Livro> buscarPorTema(String tema) {
		return todosLivro().stream().filter(livro -> livro.comTema(tema)).collect(Collectors.toList());
	}

	private List<Livro> todosLivro() {
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro("Senhor dos Aneis", "Ficcao"));
		livros.add(new Livro("Kotlin ou Java", "Drama"));
		livros.add(new Livro("Harry Potter", "Fantasia"));
		return livros;
	}

}
