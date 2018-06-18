package dz.agenceadam.locationvoiture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.repository.UserRepository;
import dz.agenceadam.locationvoiture.service.IUserService;


@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository iUserRepository;
	
	@Override
	@Transactional(readOnly = false)
	public User saveUser(User user) {
		return iUserRepository.save(user);
	}
	
	@Override
	public User getByUsername(String username) {
		return iUserRepository.getByUserName(username);
	}

}