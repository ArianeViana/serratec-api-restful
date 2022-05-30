package br.serratec.backend.projeto04.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.backend.projeto04.DTO.CarroDTO;
import br.serratec.backend.projeto04.DTO.CarroExibicaoDTO;
import br.serratec.backend.projeto04.exception.CarroException;
import br.serratec.backend.projeto04.model.Carro;
import br.serratec.backend.projeto04.model.Servico;
import br.serratec.backend.projeto04.repository.CarroRepository;
import br.serratec.backend.projeto04.repository.ClienteRepository;
import br.serratec.backend.projeto04.repository.ServicoRepository;

@Service
public class CarroService {
	
	@Autowired 
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	
	public CarroDTO transformarModelEmDTO(Carro carro, CarroDTO carroDTO) {
		
		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setMarcaCarro(carro.getMarcaCarro());
		carroDTO.setModeloCarro(carro.getModeloCarro());
		carroDTO.setAnoCarro(carro.getAnoCarro());	
		carroDTO.setIdCliente(carro.getCliente().getIdCliente());
						
		return carroDTO;
	}
	
	public Carro transformarDTOEmModel(CarroDTO carroDTO, Carro carro) {
		
		carro.setMarcaCarro(carroDTO.getMarcaCarro());
		carro.setModeloCarro(carroDTO.getModeloCarro());
		carro.setAnoCarro(carroDTO.getAnoCarro());
		
		if(carroDTO.getIdCliente() != null) {
			carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
		}
		
		
		return carro;
	}
	
	public CarroExibicaoDTO modelToDTOExibicao(Carro carro, CarroExibicaoDTO carroExibicaoDTO) {
		
		carroExibicaoDTO.setIdCarro(carro.getIdCarro());
		carroExibicaoDTO.setMarcaCarro(carro.getMarcaCarro());
		carroExibicaoDTO.setModeloCarro(carro.getModeloCarro());
		carroExibicaoDTO.setAnoCarro(carro.getAnoCarro());	
		carroExibicaoDTO.setIdCliente(carro.getCliente().getIdCliente());
		carroExibicaoDTO.setListaServico(carro.getListaServico());
		
		return carroExibicaoDTO;
	}
	
	public List<CarroExibicaoDTO> buscarTodos(){
		List<Carro> listaCarro = carroRepository.findAll();
		List<CarroExibicaoDTO> listaCarroExibicaoDTO = new ArrayList<>();
		
		for (Carro carro : listaCarro) {
			CarroExibicaoDTO carroExibicaoDTO = new CarroExibicaoDTO();
			modelToDTOExibicao(carro, carroExibicaoDTO);
			listaCarroExibicaoDTO.add(carroExibicaoDTO);
		}
		
		return listaCarroExibicaoDTO;
	}
	
	public CarroExibicaoDTO buscarPorId(Integer idCarro) throws CarroException{
		Optional<Carro> carroBuscado = carroRepository.findById(idCarro);
		
		CarroExibicaoDTO carroExibicaoDTO = new CarroExibicaoDTO();
		
		if(carroBuscado.isPresent()) {
			Carro carro = carroBuscado.get();
			
			
			modelToDTOExibicao(carro, carroExibicaoDTO);	
			return carroExibicaoDTO;
		}
		
		throw new CarroException("O carro com id " + carroExibicaoDTO.getIdCarro() + " não foi encontrado." );
				
	}
	
	public String salvarCarro(CarroDTO carroDTO) {
		
		Carro carro = new Carro();
		
		transformarDTOEmModel(carroDTO, carro);
		
		carroRepository.save(carro);
		
		return "O carro com id " + carro.getIdCarro() + " foi salvo com sucesso!" ;
				
	}
	
	
	public String salvarListaCarro(List<CarroDTO> lista){
		List<Carro> listaCarro = new ArrayList<>();
		

		for (CarroDTO carroDTO : lista) {
			Carro carro = new Carro();
			transformarDTOEmModel(carroDTO, carro);
			listaCarro.add(carro);
		}
		
		carroRepository.saveAll(listaCarro);
		
		return "Todos os carros foram salvos com sucesso!";
		
	}
	
	
	public String atualizar(Integer idCarro, CarroDTO carroDTO) throws CarroException {
		Optional<Carro> carroBuscado = carroRepository.findById(idCarro);
		
		Carro carro = carroBuscado.get();
		
		if(carroBuscado.isPresent()) {
						
			if(carroDTO.getModeloCarro() != null) {
				carro.setModeloCarro(carroDTO.getModeloCarro());
			}
			
			if(carroDTO.getMarcaCarro() != null) {
				carro.setMarcaCarro(carroDTO.getMarcaCarro());
			}
			
			if(carroDTO.getAnoCarro() != null) {
				carro.setAnoCarro(carroDTO.getAnoCarro());
			}
			
			carroRepository.save(carro);
			return "As informações do carro foram atualizadas com sucesso!";			
		}
		
		throw new CarroException("As informações não podem ser atualizadas, o carro com id %d" + carro.getIdCarro() + " não foi encontrado.");
	}
	
	
	public String deletar(Integer idCarro) {
		
		carroRepository.deleteById(idCarro);
		
		return "O carro foi deletado com sucesso!";
		
	}
	
	
	
}
