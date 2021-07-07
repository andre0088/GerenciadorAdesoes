package com.adesoes.gerenciamento.domain.model.contratante;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

import com.adesoes.gerenciamento.domain.model.adesao.Adesao;
import com.sun.istack.NotNull;

@Entity
public class Contratante {

	@Id
	private String cpf;
	
	@NotNull
	@Column(name = "nome_contratante")
	private String nome;
	
	@Embedded
	@NotNull
	private Endereco endereco;
	
	@Embedded
	@NotNull
	private Telefone telefone;
	
	@OneToMany
	@JoinColumn(name = "cpf")
	private List<Adesao> adesoes;

	
	public List<Adesao> getAdesoes() {
		return adesoes;
	}

	public void setAdesoes(List<Adesao> adesoes) {
		this.adesoes = adesoes;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}




	
}
