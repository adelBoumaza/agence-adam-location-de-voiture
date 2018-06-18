package dz.agenceadam.locationvoiture.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.repository.ClientRepository;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

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
	public List<Client> findAll() {

		return clientRepository.findAllClientActived();
	}

	@Override
	public Client saveClientWidthUser(Client client, Integer idUser) {
		User user = GenericBuilder.of(User::new)
	    		   .with(User::setId, 1).build();
	    client.setUser(user);
	    clientRepository.save(client);
		return client;
	}

	

}
