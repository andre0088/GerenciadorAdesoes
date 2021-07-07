package com.adesoes.gerenciamento.domain.exception;

public class IdDuplicadoException extends Exception{
	
	public IdDuplicadoException() {
		super("Esse id já foi cadastrado!");
	}
	
}
