package br.com.carnegieworks.chamados_tecnicos.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carnegieworks.chamados_tecnicos.domain.models.User;
import br.com.carnegieworks.chamados_tecnicos.domain.repositories.UserRepository;

@Service
public class UserLoginService {

	@Autowired
	UserRepository userRepository;
	
	public User login(String email, String password) {
		
		Optional<User> user = this.userRepository.login(email, password);
		User result = null;
		if (user.isPresent()){
			result = user.get();
		};
		return result;
	}
	
}
