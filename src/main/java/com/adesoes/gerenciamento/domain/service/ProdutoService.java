package com.adesoes.gerenciamento.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.model.produto.Produto;

@Service
public interface ProdutoService {

	public Produto cadastrar(Produto produto) throws Exception;
	
	public List<Produto> listar();
	
	public Produto ListarPorId(long id);
	
	public void deletar(long id) throws Exception;
	
	public Produto editar(long id, Produto produto) throws Exception;
	
}
