package com.adesoes.gerenciamento.domain.exception;

public class CpfDuplicadoException extends Exception{

	public CpfDuplicadoException() {
		super("Já existe alguém cadastrado com esse cpf!");
	}
	
}
