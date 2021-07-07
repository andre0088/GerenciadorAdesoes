package com.adesoes.gerenciamento.presentation.dto.pagamento;

import java.math.BigDecimal;

public class PagamentoRequest {
	
	private long idCobranca;
	
	private BigDecimal valor;

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

	
}
