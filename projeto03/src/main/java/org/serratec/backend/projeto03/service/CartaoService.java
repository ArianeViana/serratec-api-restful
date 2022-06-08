package org.serratec.backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.projeto03.dto.CartaoDTO;
import org.serratec.backend.projeto03.exception.CartaoException;
import org.serratec.backend.projeto03.exception.EmailException;
import org.serratec.backend.projeto03.model.Cartao;
import org.serratec.backend.projeto03.model.Cliente;
import org.serratec.backend.projeto03.repository.CartaoRepository;
import org.serratec.backend.projeto03.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EmailService emailService;
	
	
	public CartaoDTO transformarModelEmDTO(Cartao cartao, CartaoDTO cartaoDTO) {
		
		cartaoDTO.setDataValidade(cartao.getDataValidade());
		cartaoDTO.setIdCartao(cartao.getIdCartao());
		cartaoDTO.setLimiteCartao(cartao.getLimiteCartao());
		cartaoDTO.setNomeTitular(cartao.getNomeTitular());
		cartaoDTO.setNumeroCartao(cartao.getNumeroCartao());
		cartaoDTO.setIdCliente(cartao.getCliente().getIdCliente());
				
		return cartaoDTO;
		
	}
	
	public Cartao transformarDTOEmModel(Cartao cartao, CartaoDTO cartaoDTO) {
		
		cartao.setDataValidade(cartaoDTO.getDataValidade());
		cartao.setLimiteCartao(cartaoDTO.getLimiteCartao());
		cartao.setNomeTitular(cartaoDTO.getNomeTitular());
		cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
		
		if(cartaoDTO.getIdCliente() != null) {
			cartao.setCliente(clienteRepository.findById(cartaoDTO.getIdCliente()).get());
			
		}
		
		return cartao;
		
	}
	
	public List<CartaoDTO> buscarTodos(){
		List<Cartao> lista = cartaoRepository.buscarTodosDesc();
		List<CartaoDTO> listaDTO = new ArrayList<>();
		
		for (Cartao cartao : lista) {
			CartaoDTO cartaoDTO = new CartaoDTO();
			transformarModelEmDTO(cartao, cartaoDTO);
			listaDTO.add(cartaoDTO);			
		}
		
		return listaDTO;		
	}
	
	
	public CartaoDTO buscarPorId(Integer idCartao) throws CartaoException {
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		
		Cartao cartaoNoBanco = new Cartao();
		CartaoDTO cartaoDTO = new CartaoDTO();
		
		if(cartao.isPresent()) {
			cartaoNoBanco = cartao.get();
			transformarModelEmDTO(cartaoNoBanco, cartaoDTO);
			return cartaoDTO;			
		}
		
		throw new CartaoException("Cartão com o id informado não encontrado");
	}
	
	
	public String salvar(CartaoDTO cartaoDTO) throws EmailException, MessagingException {
		Cartao cartao = new Cartao();
		transformarDTOEmModel(cartao, cartaoDTO);
		cartaoRepository.save(cartao);			
		
		emailService.emailTeste(cartaoDTO);
		
		return "O cartão criado foi com o id: " + cartao.getIdCartao();
	}
	

	
	public void salvarLista(List<CartaoDTO> listaDTO) {
		List<Cartao> lista = new ArrayList<>();
		
		for (CartaoDTO cartaoDTO : listaDTO) {
			Cartao cartao = new Cartao();
			transformarDTOEmModel(cartao, cartaoDTO);
			lista.add(cartao);			
		}
		
		cartaoRepository.saveAll(lista);
	}
	
	
	public String atualizar(Integer idCartao, CartaoDTO cartaoDTO) throws CartaoException {
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		
		Cartao cartaoNoBanco = new Cartao();
		
		if(cartao.isPresent()) {
			cartaoNoBanco = cartao.get();
			
			if(cartaoDTO.getNomeTitular() != null) {
				cartaoNoBanco.setNomeTitular(cartaoDTO.getNomeTitular());
			}
			
			if(cartaoDTO.getNumeroCartao() != null) {
				cartaoNoBanco.setNumeroCartao(cartaoDTO.getNumeroCartao());
			}
			
			if(cartaoDTO.getDataValidade() != null) {
				cartaoNoBanco.setDataValidade(cartaoDTO.getDataValidade());
			}
			
			if(cartaoDTO.getLimiteCartao() != null) {
				cartaoNoBanco.setLimiteCartao(cartaoDTO.getLimiteCartao());				
			}
			
			cartaoRepository.save(cartaoNoBanco);
			return "O cartão foi atualizado com sucesso";		
		}
		
		throw new CartaoException("Não foi possível atualizar o cartão");	
		
	}
	
	public void deletar(Integer idCartao) {
		cartaoRepository.deleteById(idCartao);			
	}
	
	
	
	
}
