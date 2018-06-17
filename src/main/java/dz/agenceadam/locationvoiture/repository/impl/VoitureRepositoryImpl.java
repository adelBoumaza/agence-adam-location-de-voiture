package dz.agenceadam.locationvoiture.repository.impl;

import dz.agenceadam.locationvoiture.dao.util.PersistenceUtil;
import dz.agenceadam.locationvoiture.repository.custom.VoitureRepositoryCustom;

public class VoitureRepositoryImpl extends PersistenceUtil implements VoitureRepositoryCustom{

	@Override
	public void getAllTest() {
		
		entityManager.createNativeQuery("select * from tb_voiture");
		
	}

}
