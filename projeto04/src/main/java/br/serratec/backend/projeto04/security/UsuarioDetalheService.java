package br.serratec.backend.projeto04.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.serratec.backend.projeto04.model.Usuario;
import br.serratec.backend.projeto04.repository.UsuarioRepository;

@Service
public class UsuarioDetalheService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.buscarPorLogin(username);
		
		if(usuario.isPresent()) {
			Usuario usuario2 = usuario.get();
			return new User(usuario2.getLoginUsuario(), usuario2.getSenhaUsuario(), new ArrayList<>());
		}
		throw new UsernameNotFoundException("Usuário Incorreto");
	}
}
