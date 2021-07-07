package com.adesoes.gerenciamento.domain.model.contratante;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {

	public String telefone1;
	
	public String telefone2;

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	@Override
	public String toString() {
		return "Telefone [telefone1=" + telefone1 + ", telefone2=" + telefone2 + "]";
	}
	
	
	
}
