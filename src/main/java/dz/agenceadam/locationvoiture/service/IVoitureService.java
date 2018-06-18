package dz.agenceadam.locationvoiture.service;

import java.util.List;

import dz.agenceadam.locationvoiture.entities.Voiture;

public interface IVoitureService {


	Voiture saveVoitureWidthUser(Voiture voiture,Integer idUser);
	
	List<Voiture> findAll();
	
}
