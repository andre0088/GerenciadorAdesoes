package com.adesoes.gerenciamento.infrastructure.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.adesoes.gerenciamento.domain.model.adesao.Adesao;

@Repository
public interface AdesaoRepository extends PagingAndSortingRepository<Adesao, Long>{
	
	public List<Adesao> findAll();
	
	public Adesao findById(long id);
	
	/*@Query(
			value = "select a from adesao as a where a.status_adesao = 3 and a.cobranca_em_andamento = false"
	)
	public List<Adesao> buscarAdesoesAtivasSemCobranca();*/

}
