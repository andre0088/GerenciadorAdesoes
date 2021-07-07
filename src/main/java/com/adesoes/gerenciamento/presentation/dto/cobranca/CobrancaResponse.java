package com.adesoes.gerenciamento.presentation.dto.cobranca;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.adesoes.gerenciamento.domain.model.cobranca.StatusCobranca;

public class CobrancaResponse implements Serializable{
	
	private long idCobranca;
	
	private LocalDateTime data;
	
	private long idPagamento;
	
	private StatusCobranca status;
	
	private BigDecimal valor;
	
	private int parcela;
	
	private long idAdesao;

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

	public long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public StatusCobranca getStatus() {
		return status;
	}

	public void setStatus(StatusCobranca status) {
		this.status = status;
	}

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
