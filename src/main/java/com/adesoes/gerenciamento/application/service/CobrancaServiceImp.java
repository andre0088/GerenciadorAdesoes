package com.adesoes.gerenciamento.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.exception.IdDuplicadoException;
import com.adesoes.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.adesoes.gerenciamento.domain.exception.ParcelaInvalidaException;
import com.adesoes.gerenciamento.domain.exception.ValorInvalidoException;
import com.adesoes.gerenciamento.domain.model.adesao.Adesao;
import com.adesoes.gerenciamento.domain.model.adesao.ModalidadeCobranca;
import com.adesoes.gerenciamento.domain.model.cobranca.Cobranca;
import com.adesoes.gerenciamento.domain.service.AdesaoService;
import com.adesoes.gerenciamento.domain.service.CobrancaService;
import com.adesoes.gerenciamento.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adesoes.gerenciamento.infrastructure.rabbitmq.RabbitmqConstantes;
import com.adesoes.gerenciamento.infrastructure.rabbitmq.RabbitmqService;
import com.adesoes.gerenciamento.infrastructure.repository.CobrancaRepository;
import com.adesoes.gerenciamento.presentation.dto.cobranca.CobrancaResponse;

@Service
public class CobrancaServiceImp implements CobrancaService{

	@Autowired
	private CobrancaRepository cobrancaRepository;
	
	@Autowired
	private AdesaoService adesaoService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	@Scheduled(cron = "0/10 * * * * *")
	public void agendar() {
		List<Adesao> adesoes = adesaoService.buscarAdesoesAtivasSemCobranca();
		
		for(Adesao adesao : adesoes) {
			Cobranca cobranca = new Cobranca();
			cobranca.gerar(adesao);
			try {
				cobranca = cadastrar(cobranca);
				this.rabbitmqService.enviaMensagem(RabbitmqConstantes.FILA_COBRANCA, modelMapper.convert(cobranca, CobrancaResponse.class));
				System.out.println("Cobrança enviada com sucesso!");
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	@Override
	public Cobranca cadastrar(Cobranca cobranca) throws Exception {
		if(cobrancaRepository.findById(cobranca.getIdCobranca())!=null) {
			throw new IdDuplicadoException();
		}
		if(cobranca.getParcela() > cobranca.getAdesao().getNumeroDeParcelas() || cobranca.getParcela()<0) {
			throw new ParcelaInvalidaException();
		}
		if(cobranca.getAdesao().getModalidade() == ModalidadeCobranca.AVISTA 
				&& cobranca.getValor().compareTo(cobranca.getAdesao().getValor())==1) {
			throw new ValorInvalidoException();
		}
		if(cobranca.getAdesao().getModalidade() == ModalidadeCobranca.RECORRENTE 
				&& cobranca.getValor().compareTo((cobranca.getAdesao().getValor()
						.divide(new BigDecimal(cobranca.getAdesao().getNumeroDeParcelas()))))==1) {
			throw new ValorInvalidoException();
		}
		
		adesaoService.mudarStatusCobranca(cobranca.getAdesao().getIdAdesao(), true);
		
		if(cobranca.getAdesao().getModalidade() == ModalidadeCobranca.RECORRENTE && cobranca.getAdesao().getParcelaAtual() < cobranca.getAdesao().getNumeroDeParcelas()){
			adesaoService.incrementarParcelas(cobranca.getAdesao().getIdAdesao());
		}
		
		return cobrancaRepository.save(cobranca);
	}

	@Override
	public List<Cobranca> listar() {
		return cobrancaRepository.findAll();
	}

	@Override
	public Cobranca ListarPorId(long id) {
		return cobrancaRepository.findById(id);
	}

	@Override
	public void deletar(long id) throws Exception {
		if(cobrancaRepository.findById(id) == null) {
			throw new IdNaoEncontradoException();
		}
		
		cobrancaRepository.deleteById(id);
		
	}

	@Override
	public Cobranca editar(long id, Cobranca cobranca) throws Exception {
		if(cobrancaRepository.findById(id)==null) {
			throw new IdNaoEncontradoException();
		}
		
		cobranca.setIdCobranca(id);
		return cobrancaRepository.save(cobranca);
		
	}
	
	
	
	
}
