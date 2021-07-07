package com.adesoes.gerenciamento.domain.model.produto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.adesoes.gerenciamento.domain.model.adesao.Adesao;
import com.adesoes.gerenciamento.domain.model.cobertura.Cobertura;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@JsonIgnoreProperties
public class Produto {

	@Id
	@Column(name = "id_produto")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long produtoId;
	
	@Column(name = "nome_produto")
	@NotNull
	private String nome;
	
	@Column(name = "descricao_produto")
	@NotNull
	private String  descricao;
	
	@NotNull
	private String loja;
	
	@OneToMany
	@JoinColumn(name = "id_produto")
	private List<Adesao> adesoes;
	
	@ManyToMany
	@JoinTable(name = "produto_cobertura", 
    joinColumns = @JoinColumn(
	          name = "id_produto", referencedColumnName = "id_produto"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "id_cobertura", referencedColumnName = "id_cobertura"))
	private List<Cobertura> coberturas;

	
	public List<Adesao> getAdesoes() {
		return adesoes;
	}

	public void setAdesoes(List<Adesao> adesoes) {
		this.adesoes = adesoes;
	}

	public long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}

	public List<Cobertura> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<Cobertura> coberturas) {
		this.coberturas = coberturas;
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
	
	
}
