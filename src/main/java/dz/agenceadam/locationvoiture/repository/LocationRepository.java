package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	@Query("Select l From Location l join fetch l.reservation r where r.id =?1")
	Location findOneLocationByReservation(Integer idReservation);
}
