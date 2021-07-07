package com.adesoes.gerenciamento.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.exception.IdDuplicadoException;
import com.adesoes.gerenciamento.domain.exception.IdNaoEncontradoException;
import com.adesoes.gerenciamento.domain.model.produto.Produto;
import com.adesoes.gerenciamento.domain.service.ProdutoService;
import com.adesoes.gerenciamento.infrastructure.repository.ProdutoRepository;

@Service
public class ProdutoServiceImp implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public Produto cadastrar(Produto produto) throws Exception {
		
		if(produtoRepository.findById(produto.getProdutoId())!=null) {
			throw new IdDuplicadoException();
		}
		
		return produtoRepository.save(produto);
	}

	@Override
	public List<Produto> listar() {
		
		return produtoRepository.findAll();
	}

	@Override
	public Produto ListarPorId(long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public void deletar(long id) throws Exception {
		if(produtoRepository.findById(id) == null) {
			throw new IdNaoEncontradoException();
		}
		
		produtoRepository.deleteById(id);
		
	}

	@Override
	public Produto editar(long id, Produto produto) throws Exception {
		
		if(produtoRepository.findById(id)==null) {
			throw new IdNaoEncontradoException();
		}
		
		produto.setProdutoId(id);
		return produtoRepository.save(produto);
		
	}

}
