package br.com.carnegieworks.chamados_tecnicos.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.carnegieworks.chamados_tecnicos.domain.exceptions.NotFoundException;
import br.com.carnegieworks.chamados_tecnicos.domain.models.PageModel;
import br.com.carnegieworks.chamados_tecnicos.domain.models.PageRequestModel;
import br.com.carnegieworks.chamados_tecnicos.domain.models.entities.Provedor;
import br.com.carnegieworks.chamados_tecnicos.domain.repositories.ProvedorRepository;

@Service
public class ProvedorService {

	@Autowired
	ProvedorRepository provedorRepository;

	public Provedor save(Provedor provedor) {
		return this.provedorRepository.save(provedor);

	}

	public Provedor update(Provedor provedor) {
		return this.provedorRepository.save(provedor);
	}

	public Optional<Provedor> getById(Long id) {
		return Optional.ofNullable(this.provedorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Provedor com id: %s não encontrado", id))));
	}
	
	public Optional<List<Provedor>> getAll() {
		return Optional.ofNullable(this.provedorRepository.findAll());
		
	}
	
	public Optional<PageModel<Provedor>> listAllOnLazyMode (Optional<PageRequestModel> optionalPageRequestModel) {
		
		PageModel<Provedor> pageModel = null;
		PageRequestModel pageRequestModel = null;
		Pageable objectPageable = null;
		Page<Provedor> page = null;
		
		if (optionalPageRequestModel.isPresent()) {
			pageRequestModel = optionalPageRequestModel.get();
			objectPageable = PageRequest.of(pageRequestModel.getPage(), pageRequestModel.getSize());
			page = this.provedorRepository.findAll(objectPageable);
			pageModel = new PageModel<>(
					(int) page.getTotalElements(),
					page.getSize(),
					page.getTotalPages(),
					page.getContent());
		}
		
		return Optional.ofNullable(pageModel);
		
		
	}
	
	
}
