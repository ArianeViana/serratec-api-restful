package org.serratec.backend.exercicio03.controller;

import java.util.List;

import org.serratec.backend.exercicio03.exception.ContaException;
import org.serratec.backend.exercicio03.exception.OperacaoException;
import org.serratec.backend.exercicio03.model.Conta;
import org.serratec.backend.exercicio03.service.ContaService;
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

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	@GetMapping("/lista")
	public List<Conta> listaContas(){
		return contaService.listarContas();
	}
	
	@GetMapping("/{numeroConta}")
	public ResponseEntity<Conta> buscarConta(@PathVariable Integer numeroConta) throws ContaException {
		return ResponseEntity.ok(contaService.buscarConta(numeroConta));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Void> salvarConta(@RequestBody Conta contaNova) {
		contaService.salvarConta(contaNova);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar/{numeroConta}")
	public ResponseEntity<Void> atualizarConta(@PathVariable Integer numeroConta, @RequestBody Conta infoAtualizada) throws ContaException{
		contaService.atualizarConta(numeroConta, infoAtualizada);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deletar/{numeroConta}")
	public ResponseEntity<Void> deletarConta(@PathVariable Integer numeroConta){
		contaService.deletarConta(numeroConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/saque/{numeroConta}")
	public ResponseEntity<Void> sacar(@PathVariable Integer numeroConta, @RequestParam float valor) throws OperacaoException {
		contaService.sacar(numeroConta, valor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/deposito/{numeroConta}")
	public ResponseEntity<Void> depositar(@PathVariable Integer numeroConta, @RequestParam float valor) throws ContaException{
		contaService.depositar(numeroConta, valor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/transferencia/{numeroConta}")
	public ResponseEntity<Void> transferir(@PathVariable Integer numeroConta, @RequestParam float valor, @RequestParam Integer contaDestino) throws OperacaoException {
		contaService.transferir(numeroConta, valor, contaDestino);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
