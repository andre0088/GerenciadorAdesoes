package com.adesoes.gerenciamento.domain.model.adesao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.adesoes.gerenciamento.domain.model.cancelamento.Cancelamento;
import com.adesoes.gerenciamento.domain.model.cobranca.Cobranca;
import com.adesoes.gerenciamento.domain.model.contratante.Contratante;
import com.adesoes.gerenciamento.domain.model.produto.Produto;
import com.sun.istack.NotNull;

@Entity
public class Adesao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_adesao")
	private long idAdesao;
	
	@NotNull
	@Column(name = "data_adesao")
	private LocalDateTime data;
	
	@NotNull
	private boolean cobrancaEmAndamento;
	
	@NotNull
	private int parcelaAtual;
	
	@NotNull
	private ModalidadeCobranca modalidade;
	
	@NotNull
	private int numeroDeParcelas;
	
	@NotNull
	@Column(name = "valor_adesao")
	private BigDecimal valor;
	
	@NotNull
	@Column(name = "status_adesao")
	private StatusAdesao status;
	
	@OneToMany
	@JoinColumn(name = "id_adesao")
	private List<Cancelamento> cancelamentos;
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	@NotNull	
	private Contratante contratante;
	
	@OneToMany
	@JoinColumn(name = "id_adesao")
	private List<Cobranca> cobrancas;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	public void cadastrar() {
		this.setCobrancaEmAndamento(false);
		this.setParcelaAtual(1);
		this.setData(LocalDateTime.now());
		this.setStatus(StatusAdesao.ATIVA);
	}

	
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public long getIdAdesao() {
		return idAdesao;
	}

	public void setIdAdesao(long idAdesao) {
		this.idAdesao = idAdesao;
	}

	public ModalidadeCobranca getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeCobranca modalidade) {
		this.modalidade = modalidade;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(int numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusAdesao getStatus() {
		return status;
	}

	public void setStatus(StatusAdesao status) {
		this.status = status;
	}

	public List<Cancelamento> getCancelamentos() {
		return cancelamentos;
	}

	public void setCancelamentos(List<Cancelamento> cancelamentos) {
		this.cancelamentos = cancelamentos;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public List<Cobranca> getCobrancas() {
		return cobrancas;
	}

	public void setCobrancas(List<Cobranca> cobrancas) {
		this.cobrancas = cobrancas;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public boolean isCobrancaEmAndamento() {
		return cobrancaEmAndamento;
	}

	public void setCobrancaEmAndamento(boolean cobrancaEmAndamento) {
		this.cobrancaEmAndamento = cobrancaEmAndamento;
	}

	public int getParcelaAtual() {
		return parcelaAtual;
	}

	public void setParcelaAtual(int parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
	}
	
	
	
}

