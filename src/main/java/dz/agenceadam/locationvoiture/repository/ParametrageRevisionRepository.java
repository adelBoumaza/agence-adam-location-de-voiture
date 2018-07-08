package dz.agenceadam.locationvoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.ParametrageRevision;

public interface ParametrageRevisionRepository extends JpaRepository<ParametrageRevision, Integer>{

	@Query("SELECT p FROM ParametrageRevision p join fetch p.voiture v")
	List<ParametrageRevision>	findAllParametrageRevision();
}
