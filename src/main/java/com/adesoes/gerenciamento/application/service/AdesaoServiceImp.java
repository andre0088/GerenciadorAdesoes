package com.adesoes.gerenciamento.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.exception.IdDuplicadoException;
import com.adesoes.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.adesoes.gerenciamento.domain.model.adesao.Adesao;
import com.adesoes.gerenciamento.domain.model.adesao.StatusAdesao;
import com.adesoes.gerenciamento.domain.service.AdesaoService;
import com.adesoes.gerenciamento.infrastructure.repository.AdesaoRepository;

@Service
public class AdesaoServiceImp implements AdesaoService{
	
	@Autowired
	private AdesaoRepository adesaoRepository;

	@Override
	public Adesao cadastrar(Adesao adesao) throws Exception {
		if(adesaoRepository.findById(adesao.getIdAdesao())!=null) {
			throw new IdDuplicadoException();
		}
		
		adesao.cadastrar();
		return adesaoRepository.save(adesao);
	}

	@Override
	public List<Adesao> listar() {
		return adesaoRepository.findAll();
	}

	@Override
	public Adesao ListarPorId(long id) {
		return adesaoRepository.findById(id);
	}

	@Override
	public void deletar(long id) throws Exception {
		if(adesaoRepository.findById(id) == null) {
			throw new IdNaoEncontradoException();
		}
		
		adesaoRepository.deleteById(id);
		
	}

	@Override
	public Adesao editar(long id, Adesao adesao) throws Exception {
		if(adesaoRepository.findById(id)==null) {
			throw new IdNaoEncontradoException();
		}
		adesao.setIdAdesao(id);
		return adesaoRepository.save(adesao);
	}

	@Override
	public void cancelamento(long idAdesao) {
		Adesao adesao = adesaoRepository.findById(idAdesao);
		adesao.setStatus(StatusAdesao.CANCELADA);
		adesaoRepository.save(adesao);
		
	}
	
	@Override
	public void incrementarParcelas(long idAdesao) {
		Adesao adesao = adesaoRepository.findById(idAdesao);
		adesao.setParcelaAtual(adesao.getParcelaAtual()+1);
		adesaoRepository.save(adesao);
	}
	
	@Override
	public void mudarStatusCobranca(long idAdesao, boolean hasCobranca) {
		Adesao adesao = adesaoRepository.findById(idAdesao);
		adesao.setCobrancaEmAndamento(hasCobranca);
		adesaoRepository.save(adesao);
	}
	
	@Override
	public void pagamentosRealizados(long idAdesao) {
		Adesao adesao = adesaoRepository.findById(idAdesao);
		adesao.setStatus(StatusAdesao.FINALIZADA);
		adesaoRepository.save(adesao);
	}

	@Override
	public List<Adesao> buscarAdesoesAtivasSemCobranca() {
		List<Adesao> adesoesPendentesDeCobrancas = new ArrayList<>();
		List<Adesao> adesoes = adesaoRepository.findAll();
		
		if(!adesoes.isEmpty()) {
			for(Adesao adesao: adesoes) {
				if(adesao.getStatus()==StatusAdesao.ATIVA && !adesao.isCobrancaEmAndamento()){
					adesoesPendentesDeCobrancas.add(adesao);
				}
				
			}
		}
		
		
		return adesoesPendentesDeCobrancas;
	}

}
