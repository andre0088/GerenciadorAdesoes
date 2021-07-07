package com.adesoes.gerenciamento.infrastructure.converter.custom;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.pagamento.Pagamento;
import com.adesoes.gerenciamento.domain.service.CobrancaService;
import com.adesoes.gerenciamento.presentation.dto.pagamento.PagamentoRequest;
import com.adesoes.gerenciamento.presentation.dto.pagamento.PagamentoResponse;

@Service
public class ModelMapperPagamentoServiceImp implements ModelMapperPagamentoService{

	@Autowired
	private CobrancaService cobrancaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PagamentoResponse pagamentoToResponse(Pagamento pagamento) {
		return modelMapper.map(pagamento, PagamentoResponse.class);
	}

	@Override
	public Pagamento pagamentoRequestToPagamento(PagamentoRequest pagamentoRequest) {
		Pagamento pagamento = new Pagamento();
		pagamento.setCobranca(cobrancaService.ListarPorId(pagamentoRequest.getIdCobranca()));
		pagamento.setValor(pagamentoRequest.getValor());
		
		return pagamento;
	}

}
