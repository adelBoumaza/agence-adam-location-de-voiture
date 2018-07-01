package dz.agenceadam.locationvoiture.service.impl;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.ClientDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.repository.ClientRepository;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.IConstant;

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
	public Client saveClientWidthUser(ClientDto clientDto, Integer idUser) throws ParseException, DataFoundedException{
		Client client = GenericBuilder.of(Client::new)
				.with(Client::setActived, Boolean.TRUE)
				.with(Client::setAdresse, clientDto.getAdresse())
				.with(Client::setClientBloque, Boolean.FALSE)
				.with(Client::setDateDeNaissance, IConstant.IDateFormat.DD_MM_YYYY.parse(clientDto.getDateDeNaissance()))
				.with(Client::setLieuDeNaissance, clientDto.getDateDeNaissance())
				.with(Client::setEmail, clientDto.getEmail())
				.with(Client::setEndette,Boolean.FALSE)
				.with(Client::setLieuObtentionPasseport,clientDto.getLieuObtentionPasseport())
				.with(Client::setLieuObtentionPermis,clientDto.getLieuObtentionPermis())
				.with(Client::setNom,clientDto.getNom())
				.with(Client::setNote,clientDto.getNote())
				.with(Client::setNumeroDePermis,clientDto.getNumeroDePermis())
				.with(Client::setNumeroPasseport,clientDto.getNumeroPasseport())
				.with(Client::setNumeTelOne,clientDto.getNumeTelOne())
				.with(Client::setNumTelTwo,clientDto.getNumTelTwo())
				.with(Client::setObservation,clientDto.getObservation())
				.with(Client::setPrenom,clientDto.getPrenom())
				.with(Client::setSommeDette,clientDto.getSommeDette())
				.with(Client::setTypeClient,Boolean.TRUE)
				.build();
		
		if(clientDto.getDateObtentionPassport() != null)
		{
			client.setDateObtentionPassport(IConstant.IDateFormat.DD_MM_YYYY.parse(clientDto.getDateObtentionPassport()));
		}
		if(clientDto.getDateObtentionPermis() != null)
		{
			client.setDateObtentionPermis(IConstant.IDateFormat.DD_MM_YYYY.parse(clientDto.getDateObtentionPermis()));
		}

		User user = GenericBuilder.of(User::new)
	    		   .with(User::setId, idUser).build();
	    client.setUser(user);
	    Client clientEntity = clientRepository.findByNomAndPrenomAndDateDeNaissance
	    		(client.getNom(),
	    		client.getPrenom(),
	    		IConstant.IDateFormat.DD_MM_YYYY.parse(clientDto.getDateDeNaissance()),
	    		idUser);
	    if(clientEntity != null)
	    {
	    	throw new DataFoundedException("client existe");
	    }
	    clientRepository.save(client);
		return client;
	}

	

}
