package org.serratec.backend.exercicio02.controller;

import java.util.List;
import org.serratec.backend.exercicio02.model.Livro;
import org.serratec.backend.exercicio02.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroService livroService;
	
	@GetMapping("/lista")
	public List<Livro> getListaLivro() {
		return livroService.listaLivro();
	}
	
	@GetMapping("/lista/{idPosicao}")
	public Livro getIdLivro(@PathVariable int idPosicao) {
		return livroService.idLivro(idPosicao);
	}
	
	@PostMapping("/adicionar") 
	public void adicionar(@RequestBody Livro livro) {
		livroService.adicionar(livro);
	}
	
	@PutMapping("/editar/{idPosicao}")
	public void editar(@PathVariable int idPosicao, @RequestBody Livro infoEditada) {
		livroService.editar(idPosicao, infoEditada);
	}
	
	@DeleteMapping("/deletar/{idPosicao}")
	public void deletar(@PathVariable int idPosicao) {
		livroService.deletar(idPosicao);
	}
}
