package br.com.carnegieworks.chamados_tecnicos.domain.dto.user;

import javax.validation.constraints.NotNull;

import br.com.carnegieworks.chamados_tecnicos.domain.enums.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @EqualsAndHashCode
public class UserUpdateRoleDTO {
	
	@NotNull(message = "Role can't be null")
	private Role role;
}
