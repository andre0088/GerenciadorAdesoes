package com.adesoes.gerenciamento.presentation.dto.cancelamento;

import java.time.LocalDateTime;

public class CancelamentoRequest {
	
	private String motivo;
	
	private long idAdesao;
	
	private LocalDateTime data;

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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	

}
