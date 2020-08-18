package br.com.carnegieworks.chamados_tecnicos.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carnegieworks.chamados_tecnicos.domain.models.entities.User;

@Repository
public interface UserDetailRepository extends JpaRepository<User, Long> {
	//public Optional<User> findByEmail(String email);
	public Optional<User> findByUserName(String userName);
	
}
