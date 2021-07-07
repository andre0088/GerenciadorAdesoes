package com.adesoes.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.contratante.Contratante;

@Service
public interface ContratanteService {

	public Contratante cadastrar(Contratante contratante) throws Exception;
	
	public List<Contratante> listar();
	
	public Contratante listarPorCpf(String cpf);
	
	public void deletar(String cpf) throws Exception;
	
	public Contratante editar(String cpf, Contratante contratante) throws Exception;
		
}
