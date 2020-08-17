package br.com.carnegieworks.chamados_tecnicos.infraestructure;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiErrorList extends ApiError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<String> errors;
	
	public ApiErrorList(int code, String msg, Date date, List<String> errors) {
		super(code, msg, date);
		this.errors = errors;
	}

}
