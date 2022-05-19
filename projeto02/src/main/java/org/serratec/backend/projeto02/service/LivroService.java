package org.serratec.backend.projeto02.service;

import java.util.Arrays;
import java.util.List;

import org.serratec.backend.projeto02.model.Livro;
import org.serratec.backend.projeto02.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	private List<Livro> livros = Arrays.asList(new Livro(1, "Cidadã de Segunda Classe", "Buchi Emecheta"), 
			new Livro(2, "Deuses Americanos", "Neil Gaiman"), 
			new Livro(3, "História da Menina Perdida", "Elena Ferrante"));
	
	public List<Livro> listaLivro() {
		return this.livros;
	}
	
}
