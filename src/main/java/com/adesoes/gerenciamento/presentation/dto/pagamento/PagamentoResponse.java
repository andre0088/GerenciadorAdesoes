package com.adesoes.gerenciamento.presentation.dto.pagamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.adesoes.gerenciamento.domain.model.pagamento.StatusPagamento;

public class PagamentoResponse implements Serializable{

	private long idPagamento;
	
	private long idCobranca;
	
	private LocalDateTime data;
	
	private BigDecimal valor;
	
	private StatusPagamento status;

	public long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public long getIdCobranca() {
		return idCobranca;
	}

	public void setIdCobranca(long idCobranca) {
		this.idCobranca = idCobranca;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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
	
	
	
}
