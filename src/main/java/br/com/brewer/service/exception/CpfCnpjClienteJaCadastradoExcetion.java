package br.com.brewer.service.exception;

public class CpfCnpjClienteJaCadastradoExcetion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CpfCnpjClienteJaCadastradoExcetion(String message) {
		super(message);
	}

}