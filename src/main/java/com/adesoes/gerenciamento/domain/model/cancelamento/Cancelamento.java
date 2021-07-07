package com.adesoes.gerenciamento.domain.model.cancelamento;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.adesoes.gerenciamento.domain.model.adesao.Adesao;
import com.sun.istack.NotNull;

@Entity
public class Cancelamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCancelamento;
	
	@NotNull
	@Column(name = "data_cancelamento")
	private LocalDateTime data;
	
	@NotNull
	private String motivo;
	
	@ManyToOne
	@JoinColumn(name = "id_adesao")
	private Adesao adesao;
	
	public void gerar() {
		this.setData(LocalDateTime.now());
	}

	public long getIdCancelamento() {
		return idCancelamento;
	}


	public void setIdCancelamento(long idCancelamento) {
		this.idCancelamento = idCancelamento;
	}


	public Adesao getAdesao() {
		return adesao;
	}

	public void setAdesao(Adesao adesao) {
		this.adesao = adesao;
	}


	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}	
	
	
	
}
