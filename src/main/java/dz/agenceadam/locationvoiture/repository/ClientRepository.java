package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.repository.custom.ClientRepositoryCustom;


public interface ClientRepository extends JpaRepository<Client, Integer>,ClientRepositoryCustom{

}
