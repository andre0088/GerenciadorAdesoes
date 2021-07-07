package com.adesoes.gerenciamento.presentation.dto.cobertura;

import com.adesoes.gerenciamento.presentation.dto.produto.ProdutoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

public class CoberturaResponse {

	private long id;
	
	private String nome;
	
	private String detalhes;
	
	private BigDecimal valor;
	
	@JsonIgnoreProperties("coberturas")
	private List<ProdutoResponse> produtos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<ProdutoResponse> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoResponse> produtos) {
		this.produtos = produtos;
	}

	
	
}
