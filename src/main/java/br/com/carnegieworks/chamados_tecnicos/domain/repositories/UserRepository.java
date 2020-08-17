package br.com.carnegieworks.chamados_tecnicos.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.carnegieworks.chamados_tecnicos.domain.models.User;
import br.com.carnegieworks.chamados_tecnicos.domain.enums.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT DISTINCT u FROM users u WHERE u.email = ?1 AND u.password = ?2")
	public Optional<User> login(String email, String password);

	@Query("SELECT DISTINCT u FROM users u WHERE u.email = ?1")
	public Optional<User> findUserByEmail(String email);
	
	//public Optional<User> findByEmail(String email);
	
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE users SET role = ?2 WHERE id = ?1")
	public int updateRole(Long id, Role role);
	
}
