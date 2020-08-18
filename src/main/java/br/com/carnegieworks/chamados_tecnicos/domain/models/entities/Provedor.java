package br.com.carnegieworks.chamados_tecnicos.domain.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "provedores")
public class Provedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@NotBlank(message = "Nome do provedor é requerido")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotBlank(message = "CNPJ do provedor é requerido")
	@Column(name = "cnpj", nullable = false)
	@CNPJ(message = "Número de cnpj inválido")
	private String cnpj;	
	
	@OneToMany(mappedBy = "provedor")
	@Getter(onMethod = @__({@JsonIgnore}))
	private List<Chamado> chamados = new ArrayList<>();
	

}
