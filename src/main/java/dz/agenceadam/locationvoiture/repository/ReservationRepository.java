package dz.agenceadam.locationvoiture.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	@Query(value="SELECT * from tb_reservation r "
			+ "JOIN tb_client c on c.pk_id  = r.fk_client_reservation "
			+ "JOIN tb_voiture v on v.pk_id = r.fk_voiture_reservation "
			+ "where r.actived = true AND (Month(r.date_de_depart)<=?1 AND Month(r.date_de_retour)>=?1) AND YEAR(r.date_de_depart)=?2 AND v.fk_user=?3 ",nativeQuery=true)
	List<Reservation> allListeResrvationByMonthAndYear(int month,int year,int idUser);
	
	
	@Query(value="SELECT * from tb_reservation r "
			+ "WHERE r.actived = true "
			+ "AND (date_de_depart  >= ?1  and date_de_depart  <=  ?2  ) AND (date_de_retour >= ?1 ) "
			+ "AND fk_voiture_reservation=?3 ",nativeQuery=true)
	List<Reservation> verifyExistingReservation(Date dateDeDepart,Date dateDeRetour,Integer idVoiture);
	
	@Query(value="From Reservation r join fetch r.voiture join fetch r.client where r.id =?1")
	Reservation findOneReservation(Integer idReservation);
}
