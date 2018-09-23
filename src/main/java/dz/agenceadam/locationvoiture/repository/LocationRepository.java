package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.agenceadam.locationvoiture.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
