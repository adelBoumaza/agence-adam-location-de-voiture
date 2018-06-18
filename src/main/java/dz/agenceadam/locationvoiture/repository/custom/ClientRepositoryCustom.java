package dz.agenceadam.locationvoiture.repository.custom;

import java.util.List;

import dz.agenceadam.locationvoiture.entities.Client;


public interface ClientRepositoryCustom{

	List<Client> findAllClientActived();
	

}
