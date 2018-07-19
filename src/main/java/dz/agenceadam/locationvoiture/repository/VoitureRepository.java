package dz.agenceadam.locationvoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.custom.VoitureRepositoryCustom;

public interface VoitureRepository extends JpaRepository<Voiture, Integer>,VoitureRepositoryCustom{

	@Query("SELECT v FROM Voiture v WHERE v.immatricule =?1")
	Voiture findVoitureByImmatricule(String immatricule);
	
	@Query("SELECT v.modele FROM Voiture v WHERE v.marque =?1")
	List<String> findVoitureByMarque(String marque);
}
