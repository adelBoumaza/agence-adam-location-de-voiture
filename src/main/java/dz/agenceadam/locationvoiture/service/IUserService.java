package dz.agenceadam.locationvoiture.service;

import dz.agenceadam.locationvoiture.entities.User;

public interface IUserService {

	
	User saveUser(User user);
	
	User getByUsername(String username);
	
}