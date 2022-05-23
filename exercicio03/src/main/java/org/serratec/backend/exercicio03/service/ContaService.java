package org.serratec.backend.exercicio03.service;

import java.util.List;

import org.serratec.backend.exercicio03.exception.ContaException;
import org.serratec.backend.exercicio03.exception.OperacaoException;
import org.serratec.backend.exercicio03.model.Conta;
import org.serratec.backend.exercicio03.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;
		
	//retorna todas as contas
	public List<Conta> listarContas(){
		return contaRepository.findAll();
	}
	
	//pesquisa conta pelo número
	public Conta buscarConta(Integer numeroConta) throws ContaException {
		Conta contaBuscada = new Conta();
		for (Conta conta : listarContas()) {
			if(conta.getNumeroConta().equals(numeroConta)) {
				contaBuscada = conta;
			}
		}
		
		if(contaBuscada.getNumeroConta() == null) {
			throw new ContaException(numeroConta);
		}
		
		return contaBuscada;
	}
	
	
	//adiciona nova conta
	public void salvarConta(Conta contaNova) {
		contaRepository.save(contaNova);
	}
	
	//atualiza informações da conta
	public void atualizarConta(Integer numeroConta, Conta infoAtualizada) throws ContaException {
		Conta contaAtualizada = new Conta();
		for(Conta conta: listarContas()) {
			if(conta.getNumeroConta().equals(numeroConta)) {
				contaAtualizada = conta;
				
				if(infoAtualizada.getNomeTitular() != null) {
					contaAtualizada.setNomeTitular(infoAtualizada.getNomeTitular());
				}
				
				if(infoAtualizada.getNumeroConta() != null) {
					contaAtualizada.setNumeroConta(infoAtualizada.getNumeroConta());
				}
				
				contaRepository.save(contaAtualizada);
				
			}
		}
		
		if(contaAtualizada.getNumeroConta() == null) {
			throw new ContaException(numeroConta);
		}
	}
	
	//deleta uma conta
	public void deletarConta(Integer numeroConta) {
		Conta contaParaDeletar = new Conta();
		for (Conta conta : listarContas()) {
			if(conta.getNumeroConta().equals(numeroConta)) {
				contaParaDeletar = conta;				
			}
		}			
		contaRepository.delete(contaParaDeletar);		
	}
	
	
	//operação saque
	public void sacar(Integer numeroConta, float valor) throws OperacaoException {
		Conta contaOperacao = new Conta();
		for(Conta conta: listarContas()) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				contaOperacao = conta;
				contaOperacao.setSaldo(contaOperacao.getSaldo() - valor);
			}
		}
		
		if(contaOperacao.getSaldo() < valor) {
			throw new OperacaoException(valor);
		}
		
			
		contaRepository.save(contaOperacao);
	}
	
	//operacao depósito
	public void depositar(Integer numeroConta, float valor) throws ContaException{
		Conta contaOperacao = new Conta();
		for(Conta conta: listarContas()) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				contaOperacao = conta;
				contaOperacao.setSaldo(contaOperacao.getSaldo() + valor);
			}
		}
		
		if(contaOperacao.getNumeroConta() == null) {
			throw new ContaException(numeroConta);
		}
		
				
		contaRepository.save(contaOperacao);
	}
	
	//operação transferencia
//	public void transferir(Integer numeroConta, float valor, Integer contaDestino) throws OperacaoException, ContaException{
//		Conta contaSaque = new Conta();
//		Conta contaDeposito = new Conta();
//		
//		for(Conta conta1: listarContas()) {
//			if (conta1.getNumeroConta().equals(numeroConta)) {
//				contaSaque = conta1;
//				contaSaque.setSaldo(contaSaque.getSaldo() - valor);
//				contaRepository.save(contaSaque);
//			}
//		}
//		
//		for(Conta conta2: listarContas()) {
//			if(conta2.getNumeroConta().equals(contaDestino)) {
//				contaDeposito = conta2;
//				contaDeposito.setSaldo(contaDeposito.getSaldo() + valor);
//				contaRepository.save(contaDeposito);
//			}
//		}
//		
//		if(contaSaque.getSaldo() < valor) {
//			throw new OperacaoException(valor);
//		}
//		
//		if(contaDeposito.getNumeroConta() == null) {
//			throw new ContaException(contaDestino);
//		}
//		
//		
//	}

	
}
