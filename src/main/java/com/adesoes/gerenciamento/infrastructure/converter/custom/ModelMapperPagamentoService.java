package com.adesoes.gerenciamento.infrastructure.converter.custom;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.pagamento.Pagamento;
import com.adesoes.gerenciamento.presentation.dto.pagamento.PagamentoRequest;
import com.adesoes.gerenciamento.presentation.dto.pagamento.PagamentoResponse;

@Service
public interface ModelMapperPagamentoService {
	
	public PagamentoResponse pagamentoToResponse(Pagamento pagamento);
	
	public Pagamento pagamentoRequestToPagamento(PagamentoRequest pagamentoRequest);
		
	
}
