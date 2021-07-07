package com.adesoes.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.cancelamento.Cancelamento;

@Service
public interface CancelamentoService {

	public Cancelamento cadastrar(Cancelamento cancelamento) throws Exception;
	
	public List<Cancelamento> listar();
	
	public Cancelamento ListarPorId(long id);
	
	public void deletar(long id) throws Exception;
	
	public Cancelamento editar(long id, Cancelamento cancelamento) throws Exception;
	
}
