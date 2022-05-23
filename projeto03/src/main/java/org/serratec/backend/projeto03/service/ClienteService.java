package org.serratec.backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto03.model.Cliente;
import org.serratec.backend.projeto03.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	//lista todos os clientes
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
	//busca o cliente por id
	public Cliente buscarPorId(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		
		//cliente vazio
		Cliente clienteNoBanco = new Cliente();
		
		if(cliente.isPresent()) {
			//cliente vazio recebe cliente do banco de dados
			clienteNoBanco = cliente.get();
		}
		return clienteNoBanco;
	}
	
	//salva um novo cliente no banco
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	//salvar mais de cliente ao mesmo tempo
	public void salvarTodos(List<Cliente> listaCliente){
		clienteRepository.saveAll(listaCliente);	
	}
	
	//edito as informações dos clientes	
	//chamei a função buscarPorId para comparar o id informado com o id salvo no banco
	public void editar(Integer idCliente, Cliente infoEditada) {
		Cliente clienteNoBanco = buscarPorId(idCliente);
		
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
	
	//deleto um cliente pelo id
	public void deletar(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	
}
