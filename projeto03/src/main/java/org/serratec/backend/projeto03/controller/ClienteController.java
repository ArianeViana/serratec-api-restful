package org.serratec.backend.projeto03.controller;

import java.util.List;

import org.serratec.backend.projeto03.dto.ClienteDTO;
import org.serratec.backend.projeto03.exception.ClienteException;
import org.serratec.backend.projeto03.model.Cliente;
import org.serratec.backend.projeto03.service.ClienteService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Cliente>> listarTodos(){
		return ResponseEntity.ok(clienteService.listarTodos());
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException{
		return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody ClienteDTO clienteDTO){
		clienteService.salvar(clienteDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/salvar-todos")
	public ResponseEntity<Void> salvarLista(@RequestBody List<Cliente> listaCliente){
		clienteService.salvarTodos(listaCliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
		
	
	@PutMapping("/editar/{idCliente}")
	public ResponseEntity<Void> editar(@PathVariable Integer idCliente, @RequestBody ClienteDTO infoEditada){
		clienteService.editar(idCliente, infoEditada);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("deletar/{idCliente}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCliente){
		clienteService.deletar(idCliente);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
