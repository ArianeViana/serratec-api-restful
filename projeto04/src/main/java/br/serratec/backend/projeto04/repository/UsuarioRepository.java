package br.serratec.backend.projeto04.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.serratec.backend.projeto04.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value="FROM Usuario u WHERE u.loginUsuario = ?1")
	Optional<Usuario> buscarPorLogin(String login);
}
