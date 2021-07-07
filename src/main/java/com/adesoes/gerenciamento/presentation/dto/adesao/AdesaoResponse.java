package com.adesoes.gerenciamento.presentation.dto.adesao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.adesoes.gerenciamento.domain.model.adesao.ModalidadeCobranca;
import com.adesoes.gerenciamento.domain.model.adesao.StatusAdesao;
import com.adesoes.gerenciamento.presentation.dto.cancelamento.CancelamentoResponse;
import com.adesoes.gerenciamento.presentation.dto.cobranca.CobrancaResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class AdesaoResponse {

	private long idAdesao;
	
	private int parcelaAtual;
	
	private boolean cobrancaEmAndamento;
	
	private LocalDateTime data;
	
	private ModalidadeCobranca modalidade;
	
	private int numeroDeParcelas;
	
	private BigDecimal valor;
	
	private StatusAdesao status;
	
	@JsonIgnoreProperties("idAdesao")
	private List<CancelamentoResponse> cancelamentos;
	
	private String ContratanteCpf;
	
	@JsonIgnoreProperties("idAdesao")
	private List<CobrancaResponse> cobrancas;
	
	private String produtoId;

	public long getIdAdesao() {
		return idAdesao;
	}

	public void setIdAdesao(long idAdesao) {
		this.idAdesao = idAdesao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public ModalidadeCobranca getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeCobranca modalidade) {
		this.modalidade = modalidade;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(int numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusAdesao getStatus() {
		return status;
	}

	public void setStatus(StatusAdesao status) {
		this.status = status;
	}

	public List<CancelamentoResponse> getCancelamentos() {
		return cancelamentos;
	}

	public void setCancelamentos(List<CancelamentoResponse> cancelamentos) {
		this.cancelamentos = cancelamentos;
	}

	public String getContratanteCpf() {
		return ContratanteCpf;
	}

	public void setContratanteCpf(String contratanteCpf) {
		ContratanteCpf = contratanteCpf;
	}

	
	public List<CobrancaResponse> getCobrancas() {
		return cobrancas;
	}

	public void setCobrancas(List<CobrancaResponse> cobrancas) {
		this.cobrancas = cobrancas;
	}

	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

	public int getParcelaAtual() {
		return parcelaAtual;
	}

	public void setParcelaAtual(int parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
	}

	public boolean isCobrancaEmAndamento() {
		return cobrancaEmAndamento;
	}

	public void setCobrancaEmAndamento(boolean cobrancaEmAndamento) {
		this.cobrancaEmAndamento = cobrancaEmAndamento;
	}
	
}
