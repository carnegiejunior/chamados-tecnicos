package br.com.carnegieworks.chamados_tecnicos.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginResponseDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	private Long expireIn;
	private String tokenProvider;
}
