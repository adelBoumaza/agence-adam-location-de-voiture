package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.custom.VoitureRepositoryCustom;

public interface VoitureRepository extends JpaRepository<Voiture, Integer>,VoitureRepositoryCustom{

	@Query("SELECT v FROM Voiture v WHERE v.immatricule =?1")
	Voiture findVoitureByImmatricule(String immatricule);
}
