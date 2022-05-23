package org.serratec.backend.exercicio03.exception;

public class ContaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroConta;
	
	public ContaException(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	
}
