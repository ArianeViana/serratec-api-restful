package org.serratec.backend.exercicio02.service;

import java.util.ArrayList;
import java.util.List;
import org.serratec.backend.exercicio02.model.Livro;
import org.springframework.stereotype.Service;


@Service
public class LivroService {
		
	public List<Livro> livros = new ArrayList<>();	

	public List<Livro> listaLivro() {
		return this.livros;
	}
	
	public List<Livro> idLivro(int idPosicao) {			
		List <Livro> livroEscolhido = new ArrayList<>();
		livroEscolhido.add(livros.get(idPosicao));		
		return livroEscolhido;
		
	}

	
	public void adicionar(Livro livro) {
		livros.add(livro);
	}
	
	public void editar(int idPosicao, Livro infoEditada) {
		Livro livroEditado = livros.get(idPosicao);
		
		livroEditado.setId(infoEditada.getId());
		livroEditado.setTitulo(infoEditada.getTitulo());
		livroEditado.setAutor(infoEditada.getAutor());
	}
	
	public void deletar(int idPosicao) {
		livros.remove(idPosicao);
	}
}
