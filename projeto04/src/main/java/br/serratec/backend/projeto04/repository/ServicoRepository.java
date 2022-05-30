package br.serratec.backend.projeto04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.serratec.backend.projeto04.model.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	
	@Query(value="SELECT * FROM SERVICO_BORRACHARIA ORDER BY SERVICO_DT_DATA DESC LIMIT 5", nativeQuery = true)
	List<Servico> buscarUltimos();
}
