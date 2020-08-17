package br.com.carnegieworks.chamados_tecnicos.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.carnegieworks.chamados_tecnicos.domain.models.User;
import br.com.carnegieworks.chamados_tecnicos.domain.exceptions.NotFoundException;
import br.com.carnegieworks.chamados_tecnicos.domain.repositories.UserRepository;

@Component("accessManager")
public class AccessManager {
	
	@Autowired
	UserRepository userRepository;
	

	public boolean isOwner(Long id) {
		String username = SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal().toString();
		
		Optional<User> user = this.userRepository.findUserByUserName(username);

		if (!user.isPresent()) throw new NotFoundException("There are not user with id = "+username);
		return user.get().getId().equals(id);
	}
	
	
	public boolean isRequestOwner(Long id) {
		
		return false;
	}
	
}
