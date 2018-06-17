package dz.agenceadam.locationvoiture.service;

import dz.agenceadam.locationvoiture.entities.Client;

public interface IClientService {

	Client save(Client client);
	
	void getAll();
}
