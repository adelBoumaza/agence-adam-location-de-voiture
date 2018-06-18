package dz.agenceadam.locationvoiture.repository.custom;

import java.util.List;

import dz.agenceadam.locationvoiture.entities.Voiture;

public interface VoitureRepositoryCustom {

	List<Voiture> findAllVoitureActived();
}
