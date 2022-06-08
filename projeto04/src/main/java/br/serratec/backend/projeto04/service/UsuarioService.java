package br.serratec.backend.projeto04.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.serratec.backend.projeto04.DTO.UsuarioDTO;
import br.serratec.backend.projeto04.model.Usuario;
import br.serratec.backend.projeto04.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UsuarioDTO modelToDTO(Usuario usuario, UsuarioDTO usuarioDTO) {
		
		usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		usuarioDTO.setLoginUsuario(usuario.getLoginUsuario());
		usuarioDTO.setSenhaUsuario(usuario.getSenhaUsuario());
		
		return usuarioDTO;
	}
	
	public Usuario DTOToModel(UsuarioDTO usuarioDTO, Usuario usuario) {
		
		usuario.setLoginUsuario(usuarioDTO.getLoginUsuario());
		usuario.setSenhaUsuario(encoder.encode(usuarioDTO.getSenhaUsuario()));
		
		return usuario;
		
	}
	
	
	//lambda - disponível apos Java8
	
	//buscar todos os usuários
	public List<UsuarioDTO> buscarTodos(){
		return usuarioRepository.findAll()
				.stream()
				.map(usuario -> modelToDTO(usuario, new UsuarioDTO()))
				.collect(Collectors.toList());
	}
	
	public UsuarioDTO buscarPorId(Integer idUsuario) {
		return usuarioRepository.findById(idUsuario)
				.map(usuario -> modelToDTO(usuario, new UsuarioDTO()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	//dá erro, não deixa fazer o equals
	public UsuarioDTO buscarPorLogin(String username) {
		return usuarioRepository.findAll()
				.stream()
				.filter(usuario -> usuario.getLoginUsuario().equals(username))
				.map(usuario -> modelToDTO(usuario, new UsuarioDTO()))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public String salvar(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		DTOToModel(usuarioDTO, usuario);
		usuarioRepository.save(usuario);
		
		return "Usuário salvo com sucesso!";
	}
	
	
	
	
}
