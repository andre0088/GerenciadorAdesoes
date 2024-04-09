package com.adesoes.gerenciamento.presentation.dto.cobranca;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class CobrancaRequest {

	private BigDecimal valor;
	
	private int parcela;
	
	private long idAdesao;
	
	private String status;
	
	private LocalDateTime data;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
}
