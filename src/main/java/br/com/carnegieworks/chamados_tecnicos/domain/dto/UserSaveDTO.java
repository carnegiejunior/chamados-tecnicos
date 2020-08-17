package br.com.carnegieworks.chamados_tecnicos.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.carnegieworks.chamados_tecnicos.domain.enums.Role;
import br.com.carnegieworks.chamados_tecnicos.domain.models.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@ToString @EqualsAndHashCode
public class UserSaveDTO {
	
	@NotBlank( message = "User name is required")
	@Size(min = 5, message = "User name must be at least 5 letters")
	private String name;
	
	@Email
	private String email;
	
	@NotBlank( message = "Password is required")
	@Size(min = 7, max = 20,message = "Password must be between 7 and 20")
	private String password;
	
	@NotNull( message = "Role is required")
	private Role role;
	
	
	public User TransformToUser() {
		return new User(null, this.name, this.email, this.password, this.role);
		
	}
	
}
