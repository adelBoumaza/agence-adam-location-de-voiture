package dz.agenceadam.locationvoiture.service;

import java.util.List;

import dz.agenceadam.locationvoiture.dto.VoitureDto;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;

public interface IVoitureService {


	VoitureDto saveOrUpdate(VoitureDto voitureDto,Integer idUser,Boolean save) throws DataFoundedException ;
	
	List<Voiture> findAll();
	
	List<Voiture> findVoitureByMarque(String marque);
	
	List<Object[]> findLastAssuranceVoiture(Integer id) throws DataFoundedException;
	
}
