package dz.agenceadam.locationvoiture.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.repository.custom.ClientRepositoryCustom;


public interface ClientRepository extends JpaRepository<Client, Integer>,ClientRepositoryCustom{

	@Query("SELECT c FROM Client c JOIN FETCH c.user u "
			+ " WHERE c.nom = ?1 AND c.prenom = ?2 AND c.dateDeNaissance =?3 AND u.id =?4")
	Client findByNomAndPrenomAndDateDeNaissance(String nom,String prenom,Date dateDeNaissance,Integer idUser);
}
