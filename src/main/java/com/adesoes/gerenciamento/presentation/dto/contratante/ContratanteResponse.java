package com.adesoes.gerenciamento.presentation.dto.contratante;

import com.adesoes.gerenciamento.domain.model.contratante.Endereco;
import com.adesoes.gerenciamento.domain.model.contratante.Telefone;
import com.adesoes.gerenciamento.presentation.dto.adesao.AdesaoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class ContratanteResponse {

	private String cpf;
	
	private String nome;
	
	private Endereco endereco;
	
	private Telefone telefone;
	
	@JsonIgnoreProperties("ContratanteCpf")	
	private List<AdesaoResponse> adesoes;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public List<AdesaoResponse> getAdesoes() {
		return adesoes;
	}

	public void setAdesoes(List<AdesaoResponse> adesoes) {
		this.adesoes = adesoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
