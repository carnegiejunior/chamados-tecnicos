package br.com.carnegieworks.chamados_tecnicos.domain.exceptions;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NotFoundException(String msg) {
		super(msg);
	}
}
