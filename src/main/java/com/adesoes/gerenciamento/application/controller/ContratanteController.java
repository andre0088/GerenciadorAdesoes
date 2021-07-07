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

import com.adesoes.gerenciamento.domain.model.contratante.Contratante;
import com.adesoes.gerenciamento.domain.service.ContratanteService;
import com.adesoes.gerenciamento.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adesoes.gerenciamento.presentation.dto.contratante.ContratanteRequest;
import com.adesoes.gerenciamento.presentation.dto.contratante.ContratanteResponse;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value="/contratantes")
@Api(value = "API REST Contratantes")
@CrossOrigin(origins = "*")
public class ContratanteController {
		
	@Autowired
	private ContratanteService contratanteService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<ContratanteResponse> listar(){
		return modelMapper.mapList(contratanteService.listar(), ContratanteResponse.class);
	}
	
	@GetMapping("/{cpf}")
	public ContratanteResponse listarPorCpf(@PathVariable(value="cpf")String cpf){
		Contratante c = null;
		try {
			c = contratanteService.listarPorCpf(cpf);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(c, ContratanteResponse.class);
	}
	
	@PostMapping
	public ContratanteResponse cadastrar(@RequestBody ContratanteRequest contratanteRequest) {
		Contratante c = null;
		try {
			c = contratanteService.cadastrar(modelMapper.convert(contratanteRequest, Contratante.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.convert(c, ContratanteResponse.class);
	}
	
	@DeleteMapping("/{cpf}")
	public void deletar(@PathVariable(value="cpf")String cpf) {
		try {
			contratanteService.deletar(cpf);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{cpf}")
	public ContratanteResponse editar(@PathVariable(value="cpf")String cpf,@RequestBody ContratanteRequest contratanteRequest) {
		Contratante c = null;
		
		try {
			c = contratanteService.editar(cpf, modelMapper.convert(contratanteRequest, Contratante.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(c, ContratanteResponse.class);
	}
	
	
}
