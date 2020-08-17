package br.com.carnegieworks.chamados_tecnicos.domain.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.carnegieworks.chamados_tecnicos.domain.enums.Role;
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
@Entity(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Size(min = 5)
	@NotBlank(message = "User name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email
	private String email;

	@NotNull
	@NotBlank(message = "Password is required")
	@Getter(onMethod = @__({ @JsonIgnore }))
	@Setter(onMethod = @__({ @JsonProperty }))
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(updatable = false)
	private Role role;

	
}
