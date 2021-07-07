package com.adesoes.gerenciamento.domain.model.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.adesoes.gerenciamento.domain.model.cobranca.Cobranca;
import com.sun.istack.NotNull;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pagamento")
	private long idPagamento;
	
	@OneToOne
	@JoinColumn(name="id_cobranca")
	private Cobranca cobranca;
	
	@NotNull
	@Column(name = "data_pagamento")
	private LocalDateTime data;
	
	@NotNull
	@Column(name = "valor_pagamento")
	private BigDecimal valor; 
	
	@NotNull
	@Column(name = "status_pagamento")
	private StatusPagamento status;
	
	public void gerar() {
		this.setData(LocalDateTime.now());
		this.setStatus(StatusPagamento.REALIZADO);
	}

	public long getIdPagamento() {
		return idPagamento;
	}



	public void setIdPagamento(long idPagamento) {
		this.idPagamento = idPagamento;
	}



	public Cobranca getCobranca() {
		return cobranca;
	}

	public void setCobranca(Cobranca cobranca) {
		this.cobranca = cobranca;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public void setStatus(StatusPagamento status) {
		this.status = status;
	}
	
	
}
