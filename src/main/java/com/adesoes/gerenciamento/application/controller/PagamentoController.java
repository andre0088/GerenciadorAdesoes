package com.adesoes.gerenciamento.application.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adesoes.gerenciamento.domain.model.pagamento.Pagamento;
import com.adesoes.gerenciamento.domain.service.PagamentoService;
import com.adesoes.gerenciamento.infrastructure.converter.custom.ModelMapperPagamentoService;
import com.adesoes.gerenciamento.presentation.dto.pagamento.PagamentoRequest;
import com.adesoes.gerenciamento.presentation.dto.pagamento.PagamentoResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pagamentos")
@Api(value = "API REST Pagamentos")
@CrossOrigin(origins = "*")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private ModelMapperPagamentoService modelMapper;
	
	@GetMapping
	public List<PagamentoResponse> listar(){
		return pagamentoService.listar()
				.stream()
				.map(modelMapper::pagamentoToResponse)
				.collect(Collectors.toList());
		
	}
	
	@GetMapping("/{idPagamento}")
	public PagamentoResponse ListarPorId(@PathVariable(value="idPagamento")long idPagamento) {
		return modelMapper.pagamentoToResponse(pagamentoService.ListarPorId(idPagamento));
	}
	
	@PostMapping
	public PagamentoResponse cadastrar(@RequestBody PagamentoRequest pagamentoRequest) {
		Pagamento p = null;
		try {
			p = pagamentoService.cadastrar(modelMapper.pagamentoRequestToPagamento(pagamentoRequest));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.pagamentoToResponse(p);
	}
	
	@DeleteMapping("/{idPagamento}")
	public void deletar(@PathVariable(value="idPagamento")long idPagamento) {
		try {
			pagamentoService.deletar(idPagamento);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{idPagamento}")
	public PagamentoResponse editar(@PathVariable(value="idPagamento")long idPagamento,@RequestBody PagamentoRequest pagamentoRequest) {
		Pagamento p = null;
		
		try {
		p = pagamentoService.editar(idPagamento, modelMapper.pagamentoRequestToPagamento(pagamentoRequest));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.pagamentoToResponse(p);
	}
	
	
}
