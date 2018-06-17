package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.custom.VoitureRepositoryCustom;

public interface VoitureRepository extends JpaRepository<Voiture, Integer>,VoitureRepositoryCustom{

}
