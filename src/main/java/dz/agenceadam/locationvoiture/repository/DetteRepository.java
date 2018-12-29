package dz.agenceadam.locationvoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Dette;

public interface DetteRepository extends JpaRepository<Dette, Integer>{

	@Query(value="SELECT dette.pk_id,dette.nom,dette.prenom,"
			+"dette.total_ttc,dette.versement,dette.reste_a_payer,"
			+"dette.statut,reserv.date_de_depart,reserv.date_de_retour,reserv.nombre_de_jours,"
			+"tbv.marque,tbv.modele "
			+"FROM tb_dette dette " 
			+"join tb_location tbl on tbl.pk_id = dette.fk_location "
			+"join tb_reservation reserv on reserv.pk_id =tbl.fk_reservation "
			+"join tb_voiture tbv on tbv.pk_id = reserv.fk_voiture_reservation "  
			+"join tb_client cl on cl.pk_id = tbl.fk_client " 
			+"join tb_user user on user.pk_id = cl.fk_user " 
			+"where user.pk_id =?1",
	nativeQuery=true)
	List<Object[]> findAllDettesByUser(Integer id);
}
