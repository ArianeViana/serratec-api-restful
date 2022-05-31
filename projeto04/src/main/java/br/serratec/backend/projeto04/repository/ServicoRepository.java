package br.serratec.backend.projeto04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.serratec.backend.projeto04.DTO.Relatorio;
import br.serratec.backend.projeto04.model.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	
	@Query(value="select \r\n"
			+ "cli.cliente_tx_nome as nome,\r\n"
			+ "c.carro_tx_modelo as modelo,\r\n"
			+ "s.servico_prestado as servico,\r\n"
			+ "s.servico_num_valor as valor\r\n"
			+ "from servico_borracharia s\r\n"
			+ "inner join carro c on(s.carro_id = c.carro_cd_id)\r\n"
			+ "inner join cliente cli on(c.cliente_id = cli.cliente_cd_id)\r\n"
			+ "order by s.servico_cd_id desc\r\n"
			+ "limit 5", nativeQuery = true)
	List<Relatorio> buscarUltimosServicos();
	
//	List<Servico> findTop5ByOrderByDataServicoDesc();
	
}
