package com.adesoes.gerenciamento.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.cobertura.Cobertura;

@Service
public interface CoberturaRepository extends JpaRepository<Cobertura, Long>{

	public Cobertura findById(long id);
	
}
