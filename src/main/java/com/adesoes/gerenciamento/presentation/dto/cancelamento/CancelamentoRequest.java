package com.adesoes.gerenciamento.presentation.dto.cancelamento;


public class CancelamentoRequest {
	
	private String motivo;
	
	private long idAdesao;

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
