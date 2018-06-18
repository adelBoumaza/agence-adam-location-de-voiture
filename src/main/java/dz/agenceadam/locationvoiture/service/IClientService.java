package dz.agenceadam.locationvoiture.service;

import java.util.List;

import dz.agenceadam.locationvoiture.entities.Client;

public interface IClientService {

	Client save(Client client);
	
	List<Client> findAll();
	
	Client saveClientWidthUser(Client client,Integer idUser);
}
