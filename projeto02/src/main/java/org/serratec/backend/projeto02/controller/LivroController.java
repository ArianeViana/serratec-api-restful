package org.serratec.backend.projeto02.controller;

import java.util.List;

import org.serratec.backend.projeto02.model.Livro;
import org.serratec.backend.projeto02.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

	@Autowired
	LivroService livroService;
	
	
	@RequestMapping("/livro")
	public List<Livro> getLivro(){
		return livroService.listaLivro();
	}
	
}
