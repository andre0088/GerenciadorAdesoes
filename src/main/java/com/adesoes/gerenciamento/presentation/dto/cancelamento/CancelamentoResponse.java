package com.adesoes.gerenciamento.presentation.dto.cancelamento;

import java.time.LocalDateTime;

public class CancelamentoResponse {

	private long id;
	
	private LocalDateTime data;
	
	private String motivo;
	
	private long idAdesao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getIdAdesao() {
		return idAdesao;
	}

	public void setIdAdesao(long idAdesao) {
		this.idAdesao = idAdesao;
	}
	
	
}
