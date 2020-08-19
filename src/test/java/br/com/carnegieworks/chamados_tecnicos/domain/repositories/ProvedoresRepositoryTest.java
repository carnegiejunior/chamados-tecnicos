package br.com.carnegieworks.chamados_tecnicos.domain.repositories;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.carnegieworks.chamados_tecnicos.domain.models.entities.Provedor;
@SpringBootTest
@DisplayName("Repositório Provedor")
class ProvedoresRepositoryTest {

	
	
	@Autowired private ProvedorRepository provedorRepository;
	
	final static String NOME_PROVEDOR = "Geek Telecom -TESTE";
	final static String CNPJ = "00878005000111";
	final static String CNPJ_INVALIDO = "15358505254";
	
	@Test
	void quando_NomeEmBranco_deve_GerarExcecao() {
		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			Provedor provedor = new Provedor(null,"",CNPJ,new ArrayList<>());
			this.provedorRepository.save(provedor);
	    });
		String expectedMessage = "{provedor.nome.required}";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));			
	}
	
	@Test
	void quando_NomeMenorQueCinco_deve_GerarExcecao() {
		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			Provedor provedor = new Provedor(null,"nome",CNPJ,new ArrayList<>());
			this.provedorRepository.save(provedor);
	    });
		String expectedMessage = "{provedor.nome.not.less.than.five}";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));			
	}
	
	@Test
	void quando_CnpjInvalido_deve_GerarExcecao() {
		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			Provedor provedor = new Provedor(null,NOME_PROVEDOR,CNPJ_INVALIDO,new ArrayList<>());
			this.provedorRepository.save(provedor);
	    });
		String expectedMessage = "{provedor.cnpj.invalid}";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));			
	}	

	@Test
	void quando_CnpjNulo_deve_GerarExcecao() {
		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			Provedor provedor = new Provedor(null,NOME_PROVEDOR,null,new ArrayList<>());
			this.provedorRepository.save(provedor);
	    });
		String expectedMessage = "{provedor.cnpj.required}";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));			
	}	

}
