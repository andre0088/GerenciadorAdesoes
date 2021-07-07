package com.adesoes.gerenciamento.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adesoes.gerenciamento.domain.model.cobranca.Cobranca;

@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{

	public Cobranca findById(long id);
	
}
