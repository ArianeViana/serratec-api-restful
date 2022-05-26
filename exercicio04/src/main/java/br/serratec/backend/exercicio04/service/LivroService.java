package br.serratec.backend.exercicio04.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.serratec.backend.exercicio04.DTO.LivroDTO;
import br.serratec.backend.exercicio04.exception.LivroException;
import br.serratec.backend.exercicio04.model.Livro;
import br.serratec.backend.exercicio04.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public LivroDTO transformarModelEmDTO(Livro livro, LivroDTO livroDTO) {
		
		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTituloLivro(livro.getTituloLivro());
		livroDTO.setAutorLivro(livro.getAutorLivro());
		livroDTO.setCategoriaLivro(livro.getCategoriaLivro());
		livroDTO.setDataPublicacao(livro.getDataPublicacao());
		
		return livroDTO;	
		
	}
	
	
	public Livro transformarDTOEmModel(LivroDTO livroDTO, Livro livro) {
		
		livro.setTituloLivro(livroDTO.getTituloLivro());
		livro.setAutorLivro(livroDTO.getAutorLivro());
		livro.setCategoriaLivro(livroDTO.getCategoriaLivro());
		livro.setDataPublicacao(livroDTO.getDataPublicacao());
		
		return livro;
		
	}
	
	public List<LivroDTO> listaLivros(){
		List<Livro> listaModel = livroRepository.findAll();
		List<LivroDTO> listaDTO = new ArrayList<>();
		
		for (Livro livroModel : listaModel) {
			LivroDTO livroDTO = new LivroDTO();
			transformarModelEmDTO(livroModel, livroDTO);
			listaDTO.add(livroDTO);
		}		
		
		return listaDTO;		
	}
	
	public LivroDTO buscarPorId(Integer idLivro) throws LivroException {
		Optional<Livro> livroBuscado = livroRepository.findById(idLivro);
		
		Livro livroModel = new Livro();
		LivroDTO livroDTO = new LivroDTO();
		
		if(livroBuscado.isPresent()) {
			livroModel = livroBuscado.get();
			transformarModelEmDTO(livroModel, livroDTO);
			return livroDTO;		
		}
		
		throw new LivroException("Livro com o id informado não foi encontrado");		
	}
	
	
	public String salvar(LivroDTO livroDTO) {
		Livro livroSalvoModel = new Livro();
		
		transformarDTOEmModel(livroDTO, livroSalvoModel);
		livroRepository.save(livroSalvoModel);
		
		return "O livro foi salvo com o id: " + livroSalvoModel.getIdLivro();
		
	}
	
	public void salvarLista(List<LivroDTO> livrosSalvosDTO) {
		List<Livro> livrosSalvos = new ArrayList<>();	
		
		for(LivroDTO livroDTO : livrosSalvosDTO) {
			Livro livroModel = new Livro();
			transformarDTOEmModel(livroDTO, livroModel);
			livrosSalvos.add(livroModel);			
		}
		
		livroRepository.saveAll(livrosSalvos);	
		
	}
	
	public String atualizar(Integer idLivro, LivroDTO infoAtualizadaDTO) throws LivroException {
		Optional<Livro> livroBuscado = livroRepository.findById(idLivro);
		
		Livro livroModel = new Livro();
		
		if(livroBuscado.isPresent()) {
			livroModel = livroBuscado.get();
			
			if(infoAtualizadaDTO.getTituloLivro() != null) {
				livroModel.setTituloLivro(infoAtualizadaDTO.getTituloLivro());
			}
			
			if(infoAtualizadaDTO.getAutorLivro() != null) {
				livroModel.setAutorLivro(infoAtualizadaDTO.getAutorLivro());
			}
			
			if(infoAtualizadaDTO.getCategoriaLivro() != null) {
				livroModel.setCategoriaLivro(infoAtualizadaDTO.getCategoriaLivro());
			}
			
			if(infoAtualizadaDTO.getDataPublicacao() != null) {
				livroModel.setDataPublicacao(infoAtualizadaDTO.getDataPublicacao());
			}
			
			livroRepository.save(livroModel);
			return "Livro atualizado com sucesso";
		}
		
		throw new LivroException("Livro com o id informado não foi encontrado");
		
	}
	
	public String deletar(Integer idLivro) {
		livroRepository.deleteById(idLivro);
		return "Livro excluído com sucesso!";
	}
	
}
