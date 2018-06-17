package dz.agenceadam.locationvoiture.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.repository.ClientRepository;
import dz.agenceadam.locationvoiture.service.IClientService;

@Service
@Transactional
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client save(Client client) {
		
		return clientRepository.save(client);
	}

	@Override
	public void getAll() {
		clientRepository.getAll();
	}

}
