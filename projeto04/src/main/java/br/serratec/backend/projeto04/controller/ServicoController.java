package br.serratec.backend.projeto04.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.backend.projeto04.DTO.Relatorio;
import br.serratec.backend.projeto04.DTO.ServicoDTO;
import br.serratec.backend.projeto04.exception.EmailException;
import br.serratec.backend.projeto04.exception.ServicoException;
import br.serratec.backend.projeto04.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	ServicoService servicoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<ServicoDTO>> buscarTodos(){
		
		return ResponseEntity.ok(servicoService.buscarTodos());
		
	}
	
	@GetMapping("/buscar/{idServico}")
	public ResponseEntity<ServicoDTO> buscarPorId(@PathVariable Integer idServico) throws ServicoException{
		
		return ResponseEntity.ok(servicoService.buscarPorId(idServico));
	}
	
	@GetMapping("/relatorio")
	public ResponseEntity<List<Relatorio>> relatorio(){
		return ResponseEntity.ok(servicoService.relatorioServicos());
		
	}
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ServicoDTO servicoDTO) throws EmailException, MessagingException{
		return ResponseEntity.ok(servicoService.salvarServico(servicoDTO));	
	}
	
	@PostMapping("/salvar-todos")
	public ResponseEntity<String> salvarLista(@RequestBody List<ServicoDTO> lista){
		return ResponseEntity.ok(servicoService.salvarListaServico(lista));
		
	}
	
	@PutMapping("/atualizar/{idServico}")
	public ResponseEntity<String> editar(@PathVariable Integer idServico, @RequestBody ServicoDTO servicoDTO) throws ServicoException{
		return ResponseEntity.ok(servicoService.atualizar(idServico, servicoDTO));
	
	}
	
	@DeleteMapping("deletar/{idServico}")
	public ResponseEntity<String> deletar(@PathVariable Integer idServico){
		return ResponseEntity.ok(servicoService.deletar(idServico));
		
	}

}
