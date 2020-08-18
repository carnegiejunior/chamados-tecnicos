package br.com.carnegieworks.chamados_tecnicos.domain.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "chamados")
public class Chamado implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "provedor_id")
	private Provedor provedor;

}
