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

import com.adesoes.gerenciamento.domain.model.adesao.Adesao;
import com.adesoes.gerenciamento.domain.service.AdesaoService;
import com.adesoes.gerenciamento.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adesoes.gerenciamento.presentation.dto.adesao.AdesaoRequest;
import com.adesoes.gerenciamento.presentation.dto.adesao.AdesaoResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/adesoes")
@Api(value = "API REST Adesoes")
@CrossOrigin(origins = "*")
public class AdesaoController {

	@Autowired
	private AdesaoService adesaoService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<AdesaoResponse> listar(){
		return modelMapper.mapList(adesaoService.listar(), AdesaoResponse.class);
		
	}
	
	@GetMapping("/{idAdesao}")
	public AdesaoResponse ListarPorId(@PathVariable(value="idAdesao")long idAdesao) {
		return modelMapper.convert(adesaoService.ListarPorId(idAdesao), AdesaoResponse.class);
	}
	
	@PostMapping
	public AdesaoResponse cadastrar(@RequestBody AdesaoRequest adesaoRequest) {
		Adesao a = null;
		try {
			a = adesaoService.cadastrar(modelMapper.convert(adesaoRequest, Adesao.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.convert(a, AdesaoResponse.class);
	}
	
	@DeleteMapping("/{idAdesao}")
	public void deletar(@PathVariable(value="idAdesao")long idAdesao) {
		try {
			adesaoService.deletar(idAdesao);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{idAdesao}")
	public AdesaoResponse editar(@PathVariable(value="idAdesao")long idAdesao,@RequestBody AdesaoRequest adesaoRequest) {
		Adesao a = null;
		
		try {
			a = adesaoService.editar(idAdesao, modelMapper.convert(adesaoRequest, Adesao.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(a, AdesaoResponse.class);
	}
	
}
