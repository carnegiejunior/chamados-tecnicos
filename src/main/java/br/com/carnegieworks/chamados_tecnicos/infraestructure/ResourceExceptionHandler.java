package br.com.carnegieworks.chamados_tecnicos.infraestructure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.carnegieworks.chamados_tecnicos.domain.exceptions.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiError> handleNotFoundException(NotFoundException notFoundException){
		
		ApiError error = new ApiError(
				HttpStatus.NOT_FOUND.value(), 
				notFoundException.getMessage(), 
				new Date()
		);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException accessDeniedException){
		
		ApiError error = new ApiError(
				HttpStatus.FORBIDDEN.value(), 
				accessDeniedException.getMessage(), 
				new Date()
		);
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}
	

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ApiError> handleBadCredentialException(BadCredentialsException badCredentialsException){
		
		ApiError error = new ApiError(
				HttpStatus.UNAUTHORIZED.value(), 
				badCredentialsException.getMessage(), 
				new Date()
		);
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	}

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException){
		
		ApiError error = new ApiError(
				HttpStatus.CONFLICT.value(), 
				dataIntegrityViolationException.getRootCause().getMessage(), 
				new Date()
		);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> errors = new ArrayList<>();
		
		ex.getBindingResult().getAllErrors().forEach( error -> {
			errors.add(error.getDefaultMessage());
		});
		
		String defaultMessage = "Invalid fields";
		
		ApiErrorList errorList = new ApiErrorList(HttpStatus.BAD_REQUEST.value(),defaultMessage,new Date(),errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
		
	}
	
}
