package br.serratec.backend.projeto04.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.backend.projeto04.DTO.ServicoDTO;
import br.serratec.backend.projeto04.exception.EmailException;
import br.serratec.backend.projeto04.exception.ServicoException;
import br.serratec.backend.projeto04.model.Servico;
import br.serratec.backend.projeto04.repository.CarroRepository;
import br.serratec.backend.projeto04.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	EmailService emailService;
	
	
	public ServicoDTO transformarModelEmDTO(Servico servico, ServicoDTO servicoDTO) {
		
		servicoDTO.setIdServico(servico.getIdServico());
		servicoDTO.setValorServico(servico.getValorServico());
		servicoDTO.setServicoPrestado(servico.getServicoPrestado());
		servicoDTO.setDataServico(servico.getDataServico());	
		servicoDTO.setIdCarro(servico.getCarro().getIdCarro());		
		
		return servicoDTO;
	}
	
	public Servico transformarDTOEmModel (ServicoDTO servicoDTO, Servico servico) {
		
		servico.setValorServico(servicoDTO.getValorServico());
		servico.setServicoPrestado(servicoDTO.getServicoPrestado());
		servico.setDataServico(servicoDTO.getDataServico());
		
		if(servicoDTO.getIdCarro() != null) {
			servico.setCarro(carroRepository.findById(servicoDTO.getIdCarro()).get());
		}
		
		return servico;
	}
	
	
	public List<ServicoDTO> buscarTodos(){
		List<Servico> listaServico = servicoRepository.findAll();
		List<ServicoDTO> listaServicoDTO = new ArrayList<>();
		
		for (Servico servico : listaServico) {
			ServicoDTO servicoDTO = new ServicoDTO();
			transformarModelEmDTO(servico, servicoDTO);
			listaServicoDTO.add(servicoDTO);
		}
		
		return listaServicoDTO;
	}
	
	public ServicoDTO buscarPorId(Integer idServico) throws ServicoException{
		Optional<Servico> servicoBuscado = servicoRepository.findById(idServico);
		
		ServicoDTO servicoDTO = new ServicoDTO();
		
		if(servicoBuscado.isPresent()) {
			Servico servico = servicoBuscado.get();
			
			
			transformarModelEmDTO(servico, servicoDTO);	
			return servicoDTO;
		}
		
		throw new ServicoException("O serviço com id " + servicoDTO.getIdServico() + " não foi encontrado." );
				
	}
	
	
	public String salvarServico(ServicoDTO servicoDTO) throws EmailException, MessagingException {
		
		Servico servico = new Servico();
		
		transformarDTOEmModel(servicoDTO, servico);
		
		servicoRepository.save(servico);
		emailService.enviarEmail(servicoDTO);
		
		return "O serviço com id " + servico.getIdServico() + "foi salvo com sucesso!";
				
	}
	
	public String salvarListaServico(List<ServicoDTO> lista){
		List<Servico> listaServico = new ArrayList<>();
		

		for (ServicoDTO servicoDTO : lista) {
			Servico servico = new Servico();
			transformarDTOEmModel(servicoDTO, servico);
			listaServico.add(servico);
		}
		
		servicoRepository.saveAll(listaServico);
		
		return "Todos os serviços foram salvos com sucesso!";
		
	}
	
	
	public String atualizar(Integer idServico, ServicoDTO servicoDTO) throws ServicoException {
		Optional<Servico> servicoBuscado = servicoRepository.findById(idServico);
		
		
		if(servicoBuscado.isPresent()) {
			Servico servico = servicoBuscado.get();
						
			if(servicoDTO.getServicoPrestado() != null) {
				servico.setServicoPrestado(servicoDTO.getServicoPrestado());
			}
			
			if(servicoDTO.getValorServico() != 0) {
				servico.setValorServico(servicoDTO.getValorServico());
			}
			
			if(servicoDTO.getDataServico() != null) {
				servico.setDataServico(servicoDTO.getDataServico());
			}
			
			servicoRepository.save(servico);
			return "As informações do serviço foram atualizadas com sucesso!";			
		}
		
		throw new ServicoException("As informações não podem ser atualizadas, o servico com id " + servicoDTO.getIdServico() + " não foi encontrado.");
	}
	
	
	public String deletar(Integer idServico) {
		
		servicoRepository.deleteById(idServico);
		
		return "O serviço foi deletado com sucesso!";
		
	}
	
	//relatorio
	public List<Servico> relatorioServicos(){
		 return servicoRepository.buscarUltimos();		
		
	}

	
}
