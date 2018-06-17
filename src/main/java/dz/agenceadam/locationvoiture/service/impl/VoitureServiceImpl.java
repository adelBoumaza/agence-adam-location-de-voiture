package dz.agenceadam.locationvoiture.service.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.repository.VoitureRepository;
import dz.agenceadam.locationvoiture.service.IVoitureService;

@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService{

	@Autowired
	private VoitureRepository voitureRepository;
	@Override
	public void getAllTest() {
		
		voitureRepository.getAllTest();
		
	}

}
