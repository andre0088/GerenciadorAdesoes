package com.adesoes.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.cobranca.Cobranca;

@Service
public interface CobrancaService {

public Cobranca cadastrar(Cobranca cobranca) throws Exception;
	
	public List<Cobranca> listar();
	
	public Cobranca ListarPorId(long id);
	
	public void deletar(long id) throws Exception;
	
	public Cobranca editar(long id, Cobranca cobranca) throws Exception;
	
}
