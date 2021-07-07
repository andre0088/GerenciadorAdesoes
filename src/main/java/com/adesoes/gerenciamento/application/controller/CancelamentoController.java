package com.adesoes.gerenciamento.application.controller;

import java.util.List;

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

import com.adesoes.gerenciamento.domain.model.cancelamento.Cancelamento;
import com.adesoes.gerenciamento.domain.service.CancelamentoService;
import com.adesoes.gerenciamento.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adesoes.gerenciamento.presentation.dto.cancelamento.CancelamentoRequest;
import com.adesoes.gerenciamento.presentation.dto.cancelamento.CancelamentoResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/cancelamentos")
@Api(value = "API REST Cancelamentos")
@CrossOrigin(origins = "*")
public class CancelamentoController {
	
	@Autowired
	private CancelamentoService cancelamentoService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<CancelamentoResponse> listar(){
		return modelMapper.mapList(cancelamentoService.listar(), CancelamentoResponse.class);
		
	}
	
	@GetMapping("/{idCancelamento}")
	public CancelamentoResponse ListarPorId(@PathVariable(value="idCancelamento")long idCancelamento) {
		return modelMapper.convert(cancelamentoService.ListarPorId(idCancelamento), CancelamentoResponse.class);
	}
	
	@PostMapping
	public CancelamentoResponse cadastrar(@RequestBody CancelamentoRequest cancelamentoRequest) {
		Cancelamento c = null;
		try {
			c = cancelamentoService.cadastrar(modelMapper.convert(cancelamentoRequest, Cancelamento.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.convert(c, CancelamentoResponse.class);
	}
	
	@DeleteMapping("/{idCancelamento}")
	public void deletar(@PathVariable(value="idCancelamento")long idCancelamento) {
		try {
			cancelamentoService.deletar(idCancelamento);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{idCancelamento}")
	public CancelamentoResponse editar(@PathVariable(value="idCancelamento")long idCancelamento,@RequestBody CancelamentoRequest cancelamentoRequest) {
		Cancelamento c = null;
		
		try {
		c = cancelamentoService.editar(idCancelamento, modelMapper.convert(cancelamentoRequest, Cancelamento.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(c, CancelamentoResponse.class);
	}

	
	
}
