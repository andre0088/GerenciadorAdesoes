package com.adesoes.gerenciamento.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adesoes.gerenciamento.domain.model.produto.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public Produto findById(long id);
	
}
