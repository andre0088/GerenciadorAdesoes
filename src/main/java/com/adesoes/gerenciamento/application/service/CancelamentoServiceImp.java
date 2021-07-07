package com.adesoes.gerenciamento.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.exception.IdDuplicadoException;
import com.adesoes.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.adesoes.gerenciamento.domain.model.cancelamento.Cancelamento;
import com.adesoes.gerenciamento.domain.service.AdesaoService;
import com.adesoes.gerenciamento.domain.service.CancelamentoService;
import com.adesoes.gerenciamento.infrastructure.repository.CancelamentoRepository;

@Service
public class CancelamentoServiceImp implements CancelamentoService{

	@Autowired
	private CancelamentoRepository cancelamentoRepository;
	
	@Autowired
	private AdesaoService adesaoService;

	@Override
	public Cancelamento cadastrar(Cancelamento cancelamento) throws Exception {
		if(cancelamentoRepository.findById(cancelamento.getIdCancelamento())!=null) {
			throw new IdDuplicadoException();
		}
		
		cancelamento.gerar();
		adesaoService.cancelamento(cancelamento.getAdesao().getIdAdesao());
		return cancelamentoRepository.save(cancelamento);
	}

	@Override
	public List<Cancelamento> listar() {
		return cancelamentoRepository.findAll();
	}

	@Override
	public Cancelamento ListarPorId(long id) {
		return cancelamentoRepository.findById(id);
	}

	@Override
	public void deletar(long id) throws Exception {
		if(cancelamentoRepository.findById(id) == null) {
			throw new IdNaoEncontradoException();
		}
		
		cancelamentoRepository.deleteById(id);
		
		
	}

	@Override
	public Cancelamento editar(long id, Cancelamento cancelamento) throws Exception {
		if(cancelamentoRepository.findById(id)==null) {
			throw new IdNaoEncontradoException();
		}
		cancelamento.setIdCancelamento(id);
		return cancelamentoRepository.save(cancelamento);
	}
	
	
}
