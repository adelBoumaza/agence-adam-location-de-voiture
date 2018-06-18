package dz.agenceadam.locationvoiture.repository.impl;

import java.util.List;

import dz.agenceadam.locationvoiture.dao.util.PersistenceUtil;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.custom.VoitureRepositoryCustom;

public class VoitureRepositoryImpl extends PersistenceUtil implements VoitureRepositoryCustom{

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> findAllVoitureActived() {

		return entityManager.createQuery("from Voiture v where v.actived=true").getResultList();
	}

	

}
