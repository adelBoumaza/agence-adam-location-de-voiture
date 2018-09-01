package dz.agenceadam.locationvoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	@Query(value="select * from tb_reservation r "
			+ "JOIN tb_voiture v on v.pk_id = r.fk_voiture_reservation "
			+ "where r.actived = true AND (Month(r.date_de_depart)=?1 or Month(r.date_de_retour)=?1) AND YEAR(r.date_de_depart)=?2 AND v.fk_user=?3 ",nativeQuery=true)
	List<Reservation> allListeResrvationByMonthAndYear(int month,int year,int idUser);
}
