package br.serratec.backend.exercicio04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.backend.exercicio04.DTO.LivroDTO;
import br.serratec.backend.exercicio04.exception.LivroException;
import br.serratec.backend.exercicio04.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<LivroDTO>> buscarTodos(){
		return ResponseEntity.ok(livroService.listaLivros());		
	}
		
	
	@GetMapping("/buscar/{idLivro}")
	public ResponseEntity<LivroDTO> buscarPorId(@PathVariable Integer idLivro) throws LivroException{
		return ResponseEntity.ok(livroService.buscarPorId(idLivro));
	}
	
	@GetMapping("/lista/ordenada")
	public ResponseEntity<List<LivroDTO>> listaOrdenada(@RequestParam String ordem) {
		return ResponseEntity.ok(livroService.listaOrdenada(ordem));
	}
	
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody LivroDTO livroDTO){
		return ResponseEntity.ok(livroService.salvar(livroDTO));
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<LivroDTO> livrosSalvosDTO){
		livroService.salvarLista(livrosSalvosDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idLivro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idLivro, @RequestBody LivroDTO infoAtualizadaDTO) throws LivroException{
		return ResponseEntity.ok(livroService.atualizar(idLivro, infoAtualizadaDTO));
	}
	
	@DeleteMapping("/deletar/{idLivro}")
	public ResponseEntity<String> deletar(@PathVariable Integer idLivro){
		return ResponseEntity.ok(livroService.deletar(idLivro)); 
		
	}
}
