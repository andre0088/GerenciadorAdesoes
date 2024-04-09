package com.adesoes.gerenciamento.presentation.dto.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.adesoes.gerenciamento.domain.model.pagamento.StatusPagamento;

public class PagamentoRequest {
	
	private long idCobranca;
	
	private BigDecimal valor;
	
	private StatusPagamento status;
	
	private LocalDateTime data;

	public long getIdCobranca() {
		return idCobranca;
	}

	public void setIdCobranca(long idCobranca) {
		this.idCobranca = idCobranca;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public void setStatus(StatusPagamento status) {
		this.status = status;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	
}
