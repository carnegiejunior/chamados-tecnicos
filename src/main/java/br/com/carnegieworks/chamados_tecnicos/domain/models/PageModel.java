package br.com.carnegieworks.chamados_tecnicos.domain.models;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageModel<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalElements;
	private int pageSize;
	private int totalPages;
	private List<T> elements;
}