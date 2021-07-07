package com.adesoes.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.adesao.Adesao;

@Service
public interface AdesaoService {
	
	public Adesao cadastrar(Adesao adesao) throws Exception;
	
	public List<Adesao> listar();
	
	public Adesao ListarPorId(long id);
	
	public void deletar(long id) throws Exception;
	
	public Adesao editar(long id, Adesao adesao) throws Exception;
	
	public void cancelamento(long idAdesao);
	
	public void pagamentosRealizados(long idAdesao);
	
	public List<Adesao> buscarAdesoesAtivasSemCobranca();
	
	public void incrementarParcelas(long idAdesao);
	
	public void mudarStatusCobranca(long idAdesao, boolean hasCobranca);

}
