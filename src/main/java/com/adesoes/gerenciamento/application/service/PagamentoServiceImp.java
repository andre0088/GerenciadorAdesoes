package com.adesoes.gerenciamento.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.exception.IdDuplicadoException;
import com.adesoes.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.adesoes.gerenciamento.domain.exception.ValorInvalidoException;
import com.adesoes.gerenciamento.domain.model.pagamento.Pagamento;
import com.adesoes.gerenciamento.domain.service.AdesaoService;
import com.adesoes.gerenciamento.domain.service.PagamentoService;
import com.adesoes.gerenciamento.infrastructure.repository.PagamentoRepository;

@Service
public class PagamentoServiceImp implements PagamentoService{

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private AdesaoService adesaoService;

	@Override
	public Pagamento cadastrar(Pagamento pagamento) throws Exception {
		if(pagamentoRepository.findById(pagamento.getIdPagamento())!=null) {
			throw new IdDuplicadoException();
		}
		
		if(pagamento.getValor().compareTo(pagamento.getCobranca().getValor())==1) {
			throw new ValorInvalidoException();
		}
		
		
		if(pagamento.getCobranca().getAdesao().getNumeroDeParcelas() == pagamento.getCobranca().getParcela()) {
			adesaoService.pagamentosRealizados(pagamento.getCobranca().getAdesao().getIdAdesao());
		}
		
		adesaoService.mudarStatusCobranca(pagamento.getCobranca().getAdesao().getIdAdesao(),false);
		pagamento.gerar();
		return pagamentoRepository.save(pagamento);
	}

	@Override
	public List<Pagamento> listar() {
		return pagamentoRepository.findAll();
	}

	@Override
	public Pagamento ListarPorId(long id) {
		return pagamentoRepository.findById(id);
	}

	@Override
	public void deletar(long id) throws Exception {
		
		if(pagamentoRepository.findById(id) == null) {
			throw new IdNaoEncontradoException();
		}
		
		pagamentoRepository.deleteById(id);
		
	}

	@Override
	public Pagamento editar(long id, Pagamento pagamento) throws Exception {
		if(pagamentoRepository.findById(id)==null) {
			throw new IdNaoEncontradoException();
		}
		pagamento.setIdPagamento(id);
		return pagamentoRepository.save(pagamento);
	}
	
}
