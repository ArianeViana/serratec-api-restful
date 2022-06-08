package org.serratec.backend.projeto03.service;

import java.util.List;
import java.util.Optional;
import org.serratec.backend.projeto03.dto.ClienteDTO;
import org.serratec.backend.projeto03.exception.ClienteException;
import org.serratec.backend.projeto03.model.Cliente;
import org.serratec.backend.projeto03.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
		
	//camada DTO para receber as informações (front para o back)
	public Cliente transformarClienteDTOEmClienteModel(ClienteDTO clienteDTO, Cliente cliente) {
		
		//não precisamos do id pois ele é automático
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNome(clienteDTO.getNome());
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());
	
		
		return cliente;
	}
	
	
	//camada DTO para retornar as informações (back para o front)
	public ClienteDTO transformarClienteModelEmClienteDTO(ClienteDTO clienteDTO, Cliente cliente) {
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
		
		return clienteDTO;
	}
	
	
	
	//lista todos os clientes
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
	
	//busca o cliente por id (clienteDTO)
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		
		//cliente vazio
		Cliente clienteNoBanco = new Cliente();
		//clienteDTO vazio
		ClienteDTO clienteDTO = new ClienteDTO();
		
		
		if(cliente.isPresent()) {
			//cliente vazio recebe cliente do banco de dados
			clienteNoBanco = cliente.get();
			clienteDTO = transformarClienteModelEmClienteDTO(clienteDTO, clienteNoBanco);
			return clienteDTO;
		}
		throw new ClienteException("Cliente não encontrado");
	}
	
	
	//salva um novo cliente no banco (clienteDTO)
	public void salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		Cliente clienteSalvar = transformarClienteDTOEmClienteModel(clienteDTO, cliente);
		clienteRepository.save(clienteSalvar);
	}
	
	
	//salvar mais de cliente ao mesmo tempo
	//TROCAR PARA DTO
	public void salvarTodos(List<Cliente> listaCliente){
		clienteRepository.saveAll(listaCliente);	
	}
	
	
	//edito as informações dos clientes	
	//chamei a função buscarPorId para comparar o id informado com o id salvo no banco
	public void editar(Integer idCliente, ClienteDTO infoEditada) {
		
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoBanco = new Cliente();
		
		if(cliente.isPresent()) {
			
			clienteNoBanco = cliente.get();
			
			//os if é para conseguir atualizar apenas os dados informados
			if(infoEditada.getCpf() != null) {
				clienteNoBanco.setCpf(infoEditada.getCpf());
			}
			
			if(infoEditada.getDataNascimento() != null) {
				clienteNoBanco.setDataNascimento(infoEditada.getDataNascimento());
			}
			
			if(infoEditada.getEmail() != null) {
				clienteNoBanco.setEmail(infoEditada.getEmail());
			}
			
			if(infoEditada.getNome() != null) {
				clienteNoBanco.setNome(infoEditada.getNome());
			}
			
			if(infoEditada.getNumeroTelefone() != null) {
				clienteNoBanco.setNumeroTelefone(infoEditada.getNumeroTelefone());
			}
			clienteRepository.save(clienteNoBanco);
		}		
		

	}
	
	//deleto um cliente pelo id
	public void deletar(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	
}
