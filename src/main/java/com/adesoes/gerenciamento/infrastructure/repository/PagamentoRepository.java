package com.adesoes.gerenciamento.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adesoes.gerenciamento.domain.model.pagamento.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

	public Pagamento findById(long id);
	
}
