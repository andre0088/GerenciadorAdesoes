package com.adesoes.gerenciamento.domain.model.cobertura;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.adesoes.gerenciamento.domain.model.produto.Produto;
import com.sun.istack.NotNull;

@Entity
public class Cobertura {

	@Id
	@Column(name = "id_cobertura")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long coberturaId;
	
	@Column(name = "nome_cobertura")
	@NotNull
	private String nome;
	
	@Column(name = "detalhes_cobertura")
	@NotNull
	private String detalhes;
	
	@NotNull
	@Column(name = "valor_cobertura")
	private BigDecimal valor;
	
	@ManyToMany(mappedBy = "coberturas",cascade = CascadeType.PERSIST)
	private List<Produto> produtos;


	public long getCoberturaId() {
		return coberturaId;
	}

	public void setCoberturaId(long coberturaId) {
		this.coberturaId = coberturaId;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
	
	
	
}
