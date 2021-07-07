package com.adesoes.gerenciamento.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adesoes.gerenciamento.domain.model.cobranca.Cobranca;
import com.adesoes.gerenciamento.domain.service.CobrancaService;
import com.adesoes.gerenciamento.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adesoes.gerenciamento.presentation.dto.cobranca.CobrancaRequest;
import com.adesoes.gerenciamento.presentation.dto.cobranca.CobrancaResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("cobrancas")
@Api(value = "API REST Cobrancas")
@CrossOrigin(origins = "*")
public class CobrancaController {

	@Autowired
	private CobrancaService cobrancaService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<CobrancaResponse> listar(){
		return modelMapper.mapList(cobrancaService.listar(), CobrancaResponse.class);
		
	}
	
	@GetMapping("/{idCobranca}")
	public CobrancaResponse ListarPorId(@PathVariable(value="idCobranca")long idCobranca) {
		return modelMapper.convert(cobrancaService.ListarPorId(idCobranca), CobrancaResponse.class);
	}
	
	@DeleteMapping("/{idCobranca}")
	public void deletar(@PathVariable(value="idCobranca")long idCobranca) {
		try {
			cobrancaService.deletar(idCobranca);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{idCobranca}")
	public CobrancaResponse editar(@PathVariable(value="idCobranca")long idCobranca,@RequestBody CobrancaRequest cobrancaRequest) {
		Cobranca c = null;
		
		try {
			c = cobrancaService.editar(idCobranca, modelMapper.convert(cobrancaRequest, Cobranca.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(c, CobrancaResponse.class);
	}
	
}
