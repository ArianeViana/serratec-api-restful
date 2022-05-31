package br.serratec.backend.projeto04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.backend.projeto04.DTO.CarroDTO;
import br.serratec.backend.projeto04.DTO.CarroExibicaoDTO;
import br.serratec.backend.projeto04.exception.CarroException;
import br.serratec.backend.projeto04.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroService carroService;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<CarroDTO>> buscarTodos(){
		
		return ResponseEntity.ok(carroService.buscarTodos());
		
	}
	
	@GetMapping("/lista-com-servicos")
	public ResponseEntity<List<CarroExibicaoDTO>> buscarTodosComServico(){
		
		return ResponseEntity.ok(carroService.buscarTodosComServico());
		
	}
	
	@GetMapping("/buscar/{idCarro}")
	public ResponseEntity<CarroExibicaoDTO> buscarPorId(@PathVariable Integer idCarro) throws CarroException{
		
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CarroDTO carroDTO){
		return ResponseEntity.ok(carroService.salvarCarro(carroDTO));	
	}
	
	@PostMapping("/salvar-todos")
	public ResponseEntity<String> salvarLista(@RequestBody List<CarroDTO> lista){
		return ResponseEntity.ok(carroService.salvarListaCarro(lista));
		
	}
	
	@PutMapping("/atualizar/{idCarro}")
	public ResponseEntity<String> editar(@PathVariable Integer idCarro, @RequestBody CarroDTO carroDTO) throws CarroException{
		return ResponseEntity.ok(carroService.atualizar(idCarro, carroDTO));
	
	}
	
	@DeleteMapping("deletar/{idCarro}")
	public ResponseEntity<String> deletar(@PathVariable Integer idCarro){
		return ResponseEntity.ok(carroService.deletar(idCarro));
		
	}
	
	
	
}
