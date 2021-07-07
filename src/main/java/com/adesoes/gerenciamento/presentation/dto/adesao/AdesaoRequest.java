package com.adesoes.gerenciamento.presentation.dto.adesao;

import java.math.BigDecimal;

import com.adesoes.gerenciamento.domain.model.adesao.ModalidadeCobranca;

public class AdesaoRequest {
	
	private ModalidadeCobranca modalidade;
	
	private int numeroDeParcelas;
	
	private BigDecimal valor;
	
	private String contratanteCpf;
	
	private long idProduto;

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

	public String getContratanteCpf() {
		return contratanteCpf;
	}

	public void setContratanteCpf(String contratanteCpf) {
		this.contratanteCpf = contratanteCpf;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}


}
