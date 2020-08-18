package br.com.carnegieworks.chamados_tecnicos.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.carnegieworks.chamados_tecnicos.domain.models.entities.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@ToString @EqualsAndHashCode
public class UserUpdateDTO {
	
	@NotBlank( message = "User name is required")
	@Size(min = 5)
	private String userName;
	
	@Email
	private String email;
	
	@NotBlank( message = "Password is required")
	@Size(min = 7, max = 20,message = "Password must be between 7 and 20")
	private String password;
		
	public User TransformToUser() {
		return new User(null, this.userName, this.email, this.password, null);
	}
	
}
