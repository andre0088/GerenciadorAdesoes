package com.adesoes.gerenciamento.presentation.dto.produto;

import java.util.List;

import com.adesoes.gerenciamento.presentation.dto.cobertura.CoberturaResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ProdutoResponse {

	private long id;
	
	private String nome;
	
	private String descricao;
	
	private String loja;
	
	@JsonIgnoreProperties("produtos")
	private List<CoberturaResponse> coberturas;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public List<CoberturaResponse> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<CoberturaResponse> coberturas) {
		this.coberturas = coberturas;
	}

	
}
