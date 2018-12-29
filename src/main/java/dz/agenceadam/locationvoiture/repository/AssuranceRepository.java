package dz.agenceadam.locationvoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Assurance;

public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {

	@Query("SELECT a FROM Assurance a join fetch a.voiture v WHERE v.id =?1")
	List<Assurance> findListeAssuranceByVoiture(Integer idVoiture);
}
