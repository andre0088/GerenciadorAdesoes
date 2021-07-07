package com.adesoes.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.cobertura.Cobertura;

@Service
public interface CoberturaService {
	
	public Cobertura cadastrar(Cobertura cobertura) throws Exception;
	
	public List<Cobertura> listar();
	
	public Cobertura ListarPorId(long id);
	
	public void deletar(long id) throws Exception;
	
	public Cobertura editar(long id, Cobertura cobertura) throws Exception;
	
}
