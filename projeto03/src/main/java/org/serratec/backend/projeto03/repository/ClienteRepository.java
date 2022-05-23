package org.serratec.backend.projeto03.repository;

import org.serratec.backend.projeto03.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	

}
