package br.com.carnegieworks.chamados_tecnicos.domain.dto.provedor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.carnegieworks.chamados_tecnicos.domain.enums.Role;
import br.com.carnegieworks.chamados_tecnicos.domain.models.entities.Provedor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @EqualsAndHashCode
public class ProvedorSaveDTO {

	@NotBlank( message = "{provedor.nome.required}")
	@Size(min = 5, message = "{provedor.nome.not.less.than.five}")
	private String nome;
	
	@NotBlank( message = "{provedor.cnpj.required}")
	@CNPJ(message = "{provedor.cnpj.invalid}")
	private String cnpj;
	
	@NotNull( message = "Role is required")
	private Role role;
	
	public Provedor TransformToUser() {
		//return new User(null, this.userName, this.email, encryptPassword(this.password), this.role);
		return null;
	}
	
	
	
}
