package dz.agenceadam.locationvoiture.repository;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.custom.VoitureRepositoryCustom;


public interface VoitureRepository extends JpaRepository<Voiture, Integer>,VoitureRepositoryCustom{

	@Query("SELECT v FROM Voiture v WHERE v.immatricule =?1")
	Voiture findVoitureByImmatricule(String immatricule);
	
	@Query("SELECT v.id,v.modele FROM Voiture v WHERE v.marque =?1")
	List<Voiture> findVoitureByMarque(String marque);
	
	@Query
	(
		value = "select max(a.date_expiration),v.km_actuel from tb_voiture v join tb_assurance a on v.pk_id = a.fk_voiture where v.pk_id=?1"
		,nativeQuery = true
	)
	List<Object[]> findLastAssuranceVoiture(Integer id);
}
