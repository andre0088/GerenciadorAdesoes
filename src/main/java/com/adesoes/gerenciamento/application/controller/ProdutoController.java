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

import com.adesoes.gerenciamento.domain.model.produto.Produto;
import com.adesoes.gerenciamento.domain.service.ProdutoService;
import com.adesoes.gerenciamento.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adesoes.gerenciamento.presentation.dto.produto.ProdutoRequest;
import com.adesoes.gerenciamento.presentation.dto.produto.ProdutoResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/produtos")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ModelMapperService modelMapper;
	
	@GetMapping
	public List<ProdutoResponse> listar(){
		return modelMapper.mapList(produtoService.listar(), ProdutoResponse.class);
	}
	
	@GetMapping("/{produtoId}")
	public ProdutoResponse ListarPorId(@PathVariable(value="produtoId")long produtoId) {
		return modelMapper.convert(produtoService.ListarPorId(produtoId), ProdutoResponse.class);
	}
	
	@PostMapping
	public ProdutoResponse cadastrar(@RequestBody ProdutoRequest produtoRequest) {
		Produto p = null;
		try {
			p = produtoService.cadastrar(modelMapper.convert(produtoRequest, Produto.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return modelMapper.convert(p, ProdutoResponse.class);
	}
	
	@DeleteMapping("/{produtoId}")
	public void deletar(@PathVariable(value="produtoId")long produtoId) {
		try {
			produtoService.deletar(produtoId);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@PutMapping("/{produtoId}")
	public ProdutoResponse editar(@PathVariable(value="produtoId")long produtoId,@RequestBody ProdutoRequest produtoRequest) {
		Produto p = null;
		
		try {
			p = produtoService.editar(produtoId, modelMapper.convert(produtoRequest, Produto.class));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return modelMapper.convert(p, ProdutoResponse.class);
	}
	
	
}
