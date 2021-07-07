package com.adesoes.gerenciamento.presentation.dto.cobranca;

import java.math.BigDecimal;


public class CobrancaRequest {

	private BigDecimal valor;
	
	private int parcela;
	
	private long idAdesao;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public long getIdAdesao() {
		return idAdesao;
	}

	public void setIdAdesao(long idAdesao) {
		this.idAdesao = idAdesao;
	}
	
	
	
}
