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

import br.serratec.backend.projeto04.DTO.ClienteDTO;
import br.serratec.backend.projeto04.DTO.ClienteExibicaoDTO;
import br.serratec.backend.projeto04.exception.ClienteException;
import br.serratec.backend.projeto04.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<ClienteDTO>> buscarTodos(){
		
		return ResponseEntity.ok(clienteService.buscarTodos());
		
	}
	
	@GetMapping("/lista-com-carros")
	public ResponseEntity<List<ClienteExibicaoDTO>> buscarClienteComCarro(){
		
		return ResponseEntity.ok(clienteService.buscarTodosComCarros());
		
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<ClienteExibicaoDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException{
		
		return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO){
		return ResponseEntity.ok(clienteService.salvarCliente(clienteDTO));	
	}
	
	@PostMapping("/salvar-todos")
	public ResponseEntity<String> salvarLista(@RequestBody List<ClienteDTO> lista){
		return ResponseEntity.ok(clienteService.salvarListaCliente(lista));
		
	}
	
	@PutMapping("/atualizar/{idCliente}")
	public ResponseEntity<String> editar(@PathVariable Integer idCliente, @RequestBody ClienteDTO clienteDTO) throws ClienteException{
		return ResponseEntity.ok(clienteService.atualizar(idCliente, clienteDTO));
	
	}
	
	@DeleteMapping("deletar/{idCliente}")
	public ResponseEntity<String> deletar(@PathVariable Integer idCliente){
		return ResponseEntity.ok(clienteService.deletar(idCliente));
		
	}
	
	
	
}
