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
import br.com.carnegieworks.chamados_tecnicos.domain.models.entities.User;
import br.com.carnegieworks.chamados_tecnicos.domain.repositories.UserRepository;

@Service
public class UserService{

	@Autowired
	UserRepository userRepository;
	
	
	public User save(User user) {
		return this.userRepository.save(user);
	}

	public User update(User user) {
		return this.userRepository.save(user);
	}
	

	public User getById(Long id) {
		return this.userRepository.findById(id).orElseThrow(
				()-> new NotFoundException("Usuário não encontrato com o id: "+id)
				);
	}

	public Optional<User> getOptionalById(Long id) {
		return this.userRepository.findById(id);
	}
	
	
	public Optional<PageModel<User>> listAllOnLazyMode(Optional<PageRequestModel> optionalPageRequestModel){
		
		PageModel<User> pageModel = null;
		PageRequestModel pageRequestModel = null;
		Pageable objectPageable = null;
		Page<User> page = null;
		
		if (optionalPageRequestModel.isPresent()) {
			pageRequestModel = optionalPageRequestModel.get();
			objectPageable = PageRequest.of(pageRequestModel.getPage(), pageRequestModel.getSize());
			page = this.userRepository.findAll(objectPageable);
			pageModel = new PageModel<>(
					(int) page.getTotalElements(),
					page.getSize(),
					page.getTotalPages(),
					page.getContent());
		}
		
		return Optional.ofNullable(pageModel);
	
	}
	
	public List<User> getAll(){
		return this.userRepository.findAll();
	}
	
//	public User login(String email, String password) {
//		
//		Optional<User> user = this.userRepository.login(email, password);
//		User result = null;
//		if (user.isPresent()){
//			result = user.get();
//		};
//		return result;
//	}
	
	public int updateRole(User user) {
		return this.userRepository.updateRole(user.getId(), user.getRole());
	}

	
	
	
}
