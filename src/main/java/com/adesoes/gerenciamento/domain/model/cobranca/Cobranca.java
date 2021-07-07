package com.adesoes.gerenciamento.domain.model.cobranca;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.adesoes.gerenciamento.domain.model.adesao.Adesao;
import com.adesoes.gerenciamento.domain.model.pagamento.Pagamento;
import com.sun.istack.NotNull;

@Entity
public class Cobranca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cobranca")
	private long idCobranca;
	
	@Column(name = "data_cobranca")
	@NotNull
	private LocalDateTime data;
	
	@OneToOne(mappedBy = "cobranca")
	private Pagamento pagamento;
	
	@NotNull
	@Column(name = "status_cobranca")
	private StatusCobranca status;
	
	@NotNull
	@Column(name = "valor_cobranca")
	private BigDecimal valor;
	
	@NotNull
	private int parcela;
	
	@ManyToOne
	@JoinColumn(name = "id_adesao")
	private Adesao adesao;
	
	public Adesao getAdesao() {
		return adesao;
	}

	public void setAdesao(Adesao adesao) {
		this.adesao = adesao;
	}

	public void gerar(Adesao adesao) {
		this.setAdesao(adesao);
		this.setValor(adesao.getValor().divide(new BigDecimal(adesao.getNumeroDeParcelas())));;
		this.setParcela(adesao.getParcelaAtual());
		this.setData(LocalDateTime.now());
		this.setStatus(StatusCobranca.REALIZADA);
	}

	public long getIdCobranca() {
		return idCobranca;
	}

	public void setIdCobranca(long idCobranca) {
		this.idCobranca = idCobranca;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public StatusCobranca getStatus() {
		return status;
	}

	public void setStatus(StatusCobranca status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
}
