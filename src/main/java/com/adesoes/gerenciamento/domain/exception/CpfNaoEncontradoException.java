package com.adesoes.gerenciamento.domain.exception;

public class CpfNaoEncontradoException extends Exception{

	public CpfNaoEncontradoException() {
		super("Não foi possível encontrar alguém com esse CPF!");
	}
	
}
