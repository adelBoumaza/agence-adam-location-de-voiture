package dz.agenceadam.locationvoiture.service;

import java.text.ParseException;
import java.util.List;

import dz.agenceadam.locationvoiture.dto.ClientDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;

public interface IClientService {

	Client save(Client client);
	
	List<Client> findAll();
	
	ClientDto saveOrUpdate(ClientDto clientDTO,Integer idUser,Boolean save) throws ParseException, DataFoundedException ;
}
