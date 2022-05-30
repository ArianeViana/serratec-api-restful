package br.serratec.backend.projeto04.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.serratec.backend.projeto04.model.Carro;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
}
