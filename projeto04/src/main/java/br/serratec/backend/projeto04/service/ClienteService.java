package br.serratec.backend.projeto04.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.backend.projeto04.DTO.CarroDTO;
import br.serratec.backend.projeto04.DTO.ClienteDTO;
import br.serratec.backend.projeto04.DTO.ClienteExibicaoDTO;
import br.serratec.backend.projeto04.exception.ClienteException;
import br.serratec.backend.projeto04.model.Carro;
import br.serratec.backend.projeto04.model.Cliente;
import br.serratec.backend.projeto04.repository.CarroRepository;
import br.serratec.backend.projeto04.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	
	public ClienteDTO transformarModelEmDTO(Cliente cliente, ClienteDTO clienteDTO) {
		
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNomeCliente(cliente.getNomeCliente());
		clienteDTO.setCpfCliente(cliente.getCpfCliente());
		clienteDTO.setTelefoneCliente(cliente.getTelefoneCliente());
		clienteDTO.setEmailCliente(cliente.getEmailCliente());
				
		
		return clienteDTO;
	}
	
//	
	public ClienteExibicaoDTO modelToDTOExibicao(Cliente cliente, ClienteExibicaoDTO clienteExibicaoDTO) {
		
		clienteExibicaoDTO.setIdCliente(cliente.getIdCliente());
		clienteExibicaoDTO.setNomeCliente(cliente.getNomeCliente());
		clienteExibicaoDTO.setCpfCliente(cliente.getCpfCliente());
		clienteExibicaoDTO.setTelefoneCliente(cliente.getTelefoneCliente());
		clienteExibicaoDTO.setEmailCliente(cliente.getEmailCliente());		
		clienteExibicaoDTO.setListaCarros(cliente.getListaCarros());	                 
        
		return clienteExibicaoDTO;
	}
	
	
	public Cliente transformarDTOEmModel(ClienteDTO clienteDTO, Cliente cliente) {
		
		cliente.setNomeCliente(clienteDTO.getNomeCliente());
		cliente.setCpfCliente(clienteDTO.getCpfCliente());
		cliente.setTelefoneCliente(clienteDTO.getTelefoneCliente());
		cliente.setEmailCliente(clienteDTO.getEmailCliente());
				
		
		return cliente;
	}
	
	
	public List<ClienteDTO> buscarTodos(){
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();
		
		for (Cliente cliente : listaCliente) {
			ClienteDTO clienteDTO = new ClienteDTO();
			transformarModelEmDTO(cliente, clienteDTO);
			listaClienteDTO.add(clienteDTO);
		}
		
		return listaClienteDTO;
	}
	
	public List<ClienteExibicaoDTO> buscarTodosComCarros(){
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<ClienteExibicaoDTO> listaClienteExibicaoDTO = new ArrayList<>();
		
		for (Cliente cliente : listaCliente) {
			ClienteExibicaoDTO clienteExibicaoDTO = new ClienteExibicaoDTO();
			 modelToDTOExibicao(cliente, clienteExibicaoDTO);
			listaClienteExibicaoDTO.add(clienteExibicaoDTO);
		}
		
		return listaClienteExibicaoDTO;
	}
	
	
	public ClienteExibicaoDTO buscarPorId(Integer idCliente) throws ClienteException{
		Optional<Cliente> clienteBuscado = clienteRepository.findById(idCliente);
		
		ClienteExibicaoDTO clienteExibicaoDTO = new ClienteExibicaoDTO();
		
		if(clienteBuscado.isPresent()) {
			Cliente cliente = clienteBuscado.get();			
			 modelToDTOExibicao(cliente, clienteExibicaoDTO);	
			return clienteExibicaoDTO;
		}
		
		throw new ClienteException("O cliente com id %d não foi encontrado." + clienteExibicaoDTO.getIdCliente());
				
	}
	
	
	public String salvarCliente(ClienteDTO clienteDTO) {
		
		Cliente cliente = new Cliente();
		
		transformarDTOEmModel(clienteDTO, cliente);
		
		clienteRepository.save(cliente);
		
		return "O cliente com id %d foi salvo com sucesso!" + cliente.getIdCliente();
				
	}
	
	
	public String salvarListaCliente(List<ClienteDTO> lista){
		List<Cliente> listaCliente = new ArrayList<>();
		

		for (ClienteDTO clienteDTO : lista) {
			Cliente cliente = new Cliente();
			transformarDTOEmModel(clienteDTO, cliente);
			listaCliente.add(cliente);
		}
		
		clienteRepository.saveAll(listaCliente);
		
		return "Todos os clientes foram salvos com sucesso!";
		
	}
	
	
	
	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> clienteBuscado = clienteRepository.findById(idCliente);
		
		Cliente cliente = clienteBuscado.get();
		
		if(clienteBuscado.isPresent()) {
						
			if(clienteDTO.getNomeCliente() != null) {
				cliente.setNomeCliente(clienteDTO.getNomeCliente());
			}
			
			if(clienteDTO.getCpfCliente() != null) {
				cliente.setCpfCliente(clienteDTO.getCpfCliente());
			}
			
			if(clienteDTO.getTelefoneCliente() != null) {
				cliente.setTelefoneCliente(clienteDTO.getTelefoneCliente());
			}
			
			if(clienteDTO.getEmailCliente() != null) {
				cliente.setTelefoneCliente(clienteDTO.getEmailCliente());
			}
			
			clienteRepository.save(cliente);
			return "As informações do cliente foram atualizadas com sucesso!";			
		}
		
		throw new ClienteException("As informações não podem ser atualizadas, o cliente com id %d" + cliente.getIdCliente() + " não foi encontrado.");
	}
	
	
	public String deletar(Integer idCliente) {
		
		clienteRepository.deleteById(idCliente);
		
		return "O cliente foi deletado com sucesso!";
		
	}
	
	
}
