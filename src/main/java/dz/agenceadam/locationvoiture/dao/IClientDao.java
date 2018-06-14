package dz.agenceadam.locationvoiture.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.agenceadam.locationvoiture.entities.Client;


public interface IClientDao extends JpaRepository<Client, Integer>{

}
