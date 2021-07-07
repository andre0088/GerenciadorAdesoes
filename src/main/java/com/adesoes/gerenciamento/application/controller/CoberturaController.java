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

import com.adesoes.gerenciamento.domain.model.cobertura.Cobertura;
import com.adesoes.gerenciamento.domain.service.CoberturaService;
import com.adesoes.gerenciamento.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adesoes.gerenciamento.presentation.dto.cobertura.CoberturaRequest;
import com.adesoes.gerenciamento.presentation.dto.cobertura.CoberturaResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/coberturas")
@Api(value = "API REST Coberturas")
@CrossOrigin(origins = "*")
public class CoberturaController {

	@Autowired
	private CoberturaService coberturaService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<CoberturaResponse> listar(){
		return modelMapper.mapList(coberturaService.listar(), CoberturaResponse.class);
		
	}
	
	@GetMapping("/{coberturaId}")
	public CoberturaResponse ListarPorId(@PathVariable(value="coberturaId")long coberturaId) {
		return modelMapper.convert(coberturaService.ListarPorId(coberturaId), CoberturaResponse.class);
	}
	
	@PostMapping
	public CoberturaResponse cadastrar(@RequestBody CoberturaRequest coberturaRequest) {
		Cobertura c = null;
		try {
			c = coberturaService.cadastrar(modelMapper.convert(coberturaRequest, Cobertura.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.convert(c, CoberturaResponse.class);
	}
	
	@DeleteMapping("/{coberturaId}")
	public void deletar(@PathVariable(value="coberturaId")long coberturaId) {
		try {
			coberturaService.deletar(coberturaId);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{coberturaId}")
	public CoberturaResponse editar(@PathVariable(value="coberturaId")long coberturaId,@RequestBody CoberturaRequest coberturaRequest) {
		Cobertura c = null;
		
		try {
		c = coberturaService.editar(coberturaId, modelMapper.convert(coberturaRequest, Cobertura.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(c, CoberturaResponse.class);
	}
}
