package com.adesoes.gerenciamento.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adesoes.gerenciamento.domain.model.cancelamento.Cancelamento;

@Repository
public interface CancelamentoRepository extends JpaRepository<Cancelamento, Long>{

	public Cancelamento findById(long id);
	
}
