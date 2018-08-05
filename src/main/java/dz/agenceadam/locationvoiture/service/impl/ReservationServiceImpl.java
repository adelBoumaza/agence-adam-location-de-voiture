package dz.agenceadam.locationvoiture.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.ReservationDaysDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;
import dz.agenceadam.locationvoiture.entities.Reservation;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.ReservationRepository;
import dz.agenceadam.locationvoiture.repository.VoitureRepository;
import dz.agenceadam.locationvoiture.service.IReservationService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.Utilitaire;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private VoitureRepository voitureRepository;
	
	
	@Override
	public List<ReservationResponseDto> allReservationByMonthAndYear(int month, int year, int idUser) {
		
		List<ReservationResponseDto> responses = new ArrayList<>();
		List<Voiture> voitures = voitureRepository.findAllVoitureActived();
		List<Integer> days = Utilitaire.generateDaysOfMonthAndYears(year, month);
		
		List<Reservation> reservations = reservationRepository.allListeResrvationByMonthAndYear(month, year, idUser);
		
		if(!voitures.isEmpty())
		{
			voitures.forEach(v->{
				
				 ReservationResponseDto dto = new ReservationResponseDto(v.getId(), v.getMarque(), v.getModele()); 
				 days.forEach(i->{
						 ReservationDaysDto day = new ReservationDaysDto(i, Boolean.TRUE);
						 dto.getDays().add(day);
				 });
				 responses.add(dto);
			});
		}
		
		if(!reservations.isEmpty())
		{
			Calendar calendar = Calendar.getInstance();
			reservations.forEach(reservation->{
					responses.forEach(response->{
						if(reservation.getVoiture().getId() == response.getIdVoiture())
						{
							
							calendar.setTime(reservation.getDateDeDepart());
							int jourDepart = calendar.get(Calendar.DAY_OF_MONTH);
							calendar.setTime(reservation.getDateDeRetour());
							int jourRetour = calendar.get(Calendar.DAY_OF_MONTH);
							
							response.getDays().stream()
							.filter(action -> action.getJour() >= jourDepart && action.getJour() < jourRetour)
							.forEach(result->{
								result.setDispo(Boolean.FALSE);
							});
							
						}
					});
			});
		}
	
		
		return responses;
	}

}
