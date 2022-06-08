package org.serratec.backend.projeto03.repository;

import java.util.List;

import org.serratec.backend.projeto03.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository <Cartao, Integer>{

	@Query(value="select * from cartao order by cartao_cd_id desc", nativeQuery = true)
	List<Cartao> buscarTodosDesc();
}
