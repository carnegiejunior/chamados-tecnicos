package br.com.carnegieworks.chamados_tecnicos.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class UserLoginDTO {
	
	@Email(message = "Invalid email address")
	private String email;
	
	@NotBlank( message = "Password required")
	@Size(min = 3, max = 10)
	private String password;
}
