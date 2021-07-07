package com.adesoes.gerenciamento.application.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.exception.IdDuplicadoException;
import com.adesoes.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.adesoes.gerenciamento.domain.model.cobertura.Cobertura;
import com.adesoes.gerenciamento.domain.service.CoberturaService;
import com.adesoes.gerenciamento.infrastructure.repository.CoberturaRepository;

@Service
public class CoberturaServiceImp implements CoberturaService{
	
	@Autowired
	private CoberturaRepository coberturaRepository;

	@Override
	public Cobertura cadastrar(Cobertura cobertura) throws Exception {
		if(ListarPorId(cobertura.getCoberturaId())!=null) {
			throw new IdDuplicadoException();
		}
		
		return coberturaRepository.save(cobertura);
	}

	@Override
	public List<Cobertura> listar() {
		return coberturaRepository.findAll();
	}

	@Override
	public Cobertura ListarPorId(long id) {
		return coberturaRepository.findById(id);
	}

	@Override
	public void deletar(long id) throws Exception {
		if(coberturaRepository.findById(id) == null) {
			throw new IdNaoEncontradoException();
		}
		
		coberturaRepository.deleteById(id);
		
	}

	@Override
	public Cobertura editar(long id, Cobertura cobertura) throws Exception {
		if(coberturaRepository.findById(id)==null) {
			throw new IdNaoEncontradoException();
		}
		cobertura.setCoberturaId(id);
		return coberturaRepository.save(cobertura);
	}
	
	
	
}
