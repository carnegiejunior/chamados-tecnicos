package br.com.carnegieworks.chamados_tecnicos.domain.exceptions;

public class SQLIntegrityConstraintViolationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SQLIntegrityConstraintViolationException(String msg) {
		super(msg);
	}
}
