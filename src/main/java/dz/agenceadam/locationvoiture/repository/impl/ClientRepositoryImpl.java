package dz.agenceadam.locationvoiture.repository.impl;

import java.util.List;

import dz.agenceadam.locationvoiture.dao.util.PersistenceUtil;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.repository.custom.ClientRepositoryCustom;



public class ClientRepositoryImpl extends PersistenceUtil implements ClientRepositoryCustom{

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAllClientActived() {
		
		return entityManager.createQuery("from Client c where c.actived=true").getResultList();
	}

	

	

	

}
