package br.serratec.backend.exercicio04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.serratec.backend.exercicio04.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Integer> {
	
	
}
