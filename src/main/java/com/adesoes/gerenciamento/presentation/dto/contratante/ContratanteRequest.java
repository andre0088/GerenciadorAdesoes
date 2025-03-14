package com.adesoes.gerenciamento.presentation.dto.contratante;

import com.adesoes.gerenciamento.domain.model.contratante.Endereco;
import com.adesoes.gerenciamento.domain.model.contratante.Telefone;

public class ContratanteRequest {
	
	private String cpf;
	
	private String nome;
	
	private Endereco endereco;
	
	private Telefone telefone;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
