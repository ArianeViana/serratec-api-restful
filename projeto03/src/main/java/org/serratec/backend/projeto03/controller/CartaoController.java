package org.serratec.backend.projeto03.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.projeto03.dto.CartaoDTO;
import org.serratec.backend.projeto03.exception.CartaoException;
import org.serratec.backend.projeto03.exception.EmailException;
import org.serratec.backend.projeto03.service.CartaoService;
import org.serratec.backend.projeto03.service.EmailService;
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
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	CartaoService cartaoService;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<CartaoDTO>> buscarTodos(){
		return ResponseEntity.ok(cartaoService.buscarTodos());		
	}
	
	@GetMapping("/buscar/{idCartao}")
	public ResponseEntity<CartaoDTO> buscarPorId(@PathVariable Integer idCartao) throws CartaoException{
		return ResponseEntity.ok(cartaoService.buscarPorId(idCartao));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CartaoDTO cartaoDTO) throws EmailException, MessagingException{
		return ResponseEntity.ok(cartaoService.salvar(cartaoDTO));
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CartaoDTO> listaDTO){
		cartaoService.salvarLista(listaDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idCartao}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCartao, @RequestBody CartaoDTO cartaoDTO) throws CartaoException{
		return ResponseEntity.ok(cartaoService.atualizar(idCartao, cartaoDTO));
	}
	
	@DeleteMapping("/deletar/{idCartao}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCartao){
		cartaoService.deletar(idCartao);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
