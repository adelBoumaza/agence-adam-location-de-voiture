package dz.agenceadam.locationvoiture.repository.impl;
import javax.persistence.Query;

import dz.agenceadam.locationvoiture.dao.util.PersistenceUtil;
import dz.agenceadam.locationvoiture.repository.custom.ClientRepositoryCustom;

public class ClientRepositoryImpl extends PersistenceUtil implements ClientRepositoryCustom{

	@Override
	public void getAll() {
		Query query = entityManager.createNativeQuery("select * from tb_client");
		System.out.println(query.getResultList());
	}

	

}
