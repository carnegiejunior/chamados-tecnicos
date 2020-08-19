package br.com.carnegieworks.chamados_tecnicos.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carnegieworks.chamados_tecnicos.domain.models.entities.Provedor;

@Repository
public interface ProvedorRepository extends JpaRepository<Provedor, Long> {

}
