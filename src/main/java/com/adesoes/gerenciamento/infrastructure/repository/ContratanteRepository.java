package com.adesoes.gerenciamento.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adesoes.gerenciamento.domain.model.contratante.Contratante;

@Repository
public interface ContratanteRepository extends JpaRepository<Contratante, String>{
	
	
}
