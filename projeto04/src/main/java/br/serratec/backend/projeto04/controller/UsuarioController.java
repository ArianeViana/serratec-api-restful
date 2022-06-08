package br.serratec.backend.projeto04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.backend.projeto04.DTO.UsuarioDTO;
import br.serratec.backend.projeto04.security.JwtUtil;
import br.serratec.backend.projeto04.security.UsuarioAuthenticationRequest;
import br.serratec.backend.projeto04.security.UsuarioAuthenticationResponse;
import br.serratec.backend.projeto04.security.UsuarioDetalheService;
import br.serratec.backend.projeto04.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioDetalheService usuarioDetalheService;
	
	
	@GetMapping("/buscar")
	public ResponseEntity<List<UsuarioDTO>> buscar(){
		return ResponseEntity.ok(usuarioService.buscarTodos());
	}
	
	@GetMapping("/buscar/{idUsuario}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer idUsuario){
		return ResponseEntity.ok(usuarioService.buscarPorId(idUsuario));
	}
	
	@GetMapping("/buscar-login")
	public ResponseEntity<UsuarioDTO> buscarPorLogin(@RequestParam String username){
		return ResponseEntity.ok(usuarioService.buscarPorLogin(username));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody UsuarioDTO usuarioDTO){
		return ResponseEntity.ok(usuarioService.salvar(usuarioDTO));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> criarAutenticacao(@RequestBody UsuarioAuthenticationRequest usuario) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
		}catch(Exception e){
			throw new Exception("Senha incorreta",e);
		}
		UserDetails usuarioDetalhe = usuarioDetalheService.loadUserByUsername(usuario.getUsername());
		String token = jwtUtil.generateToken(usuarioDetalhe);
		return ResponseEntity.ok(new UsuarioAuthenticationResponse(token));
	}
}
