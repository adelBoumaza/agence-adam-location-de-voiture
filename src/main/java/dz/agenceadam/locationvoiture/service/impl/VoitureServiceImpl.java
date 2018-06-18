package dz.agenceadam.locationvoiture.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.VoitureRepository;
import dz.agenceadam.locationvoiture.service.IVoitureService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService{

	@Autowired
	private VoitureRepository voitureRepository;

	@Override
	public Voiture saveVoitureWidthUser(Voiture voiture, Integer idUser) {
		
		User user = GenericBuilder.of(User::new)
	    		   .with(User::setId, 1).build();
		voiture.setUser(user);
		voitureRepository.save(voiture);
		return voiture;
	}

	@Override
	public List<Voiture> findAll() {

		return voitureRepository.findAllVoitureActived();
	}


}
