package org.serratec.backend.exercicio03.repository;

import org.serratec.backend.exercicio03.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
