package dz.agenceadam.locationvoiture.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.agenceadam.locationvoiture.entities.Voiture;

public interface IVoitureDao extends JpaRepository<Voiture, Integer>{

}
