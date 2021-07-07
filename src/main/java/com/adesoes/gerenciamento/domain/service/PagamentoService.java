package com.adesoes.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.pagamento.Pagamento;


@Service
public interface PagamentoService {

	public Pagamento cadastrar(Pagamento pagamento) throws Exception;
	
	public List<Pagamento> listar();
	
	public Pagamento ListarPorId(long id);
	
	public void deletar(long id) throws Exception;
	
	public Pagamento editar(long id, Pagamento pagamento) throws Exception;
	
}
