package dz.agenceadam.locationvoiture.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.ReservationDaysDto;
import dz.agenceadam.locationvoiture.dto.ReservationDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.Reservation;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.ClientRepository;
import dz.agenceadam.locationvoiture.repository.ReservationRepository;
import dz.agenceadam.locationvoiture.repository.VoitureRepository;
import dz.agenceadam.locationvoiture.service.IReservationService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.IConstant;
import dz.agenceadam.locationvoiture.util.Utilitaire;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Override
	public List<ReservationResponseDto> allReservationByMonthAndYear(int month, int year, int idUser) {
		
		List<ReservationResponseDto> responses = new ArrayList<>();
		List<Voiture> voitures = voitureRepository.findAllVoitureActived();
		List<Integer> days = Utilitaire.generateDaysOfMonthAndYears(year, month);
		
		List<Reservation> reservations = reservationRepository.allListeResrvationByMonthAndYear(month, year, idUser);
		
		if(!voitures.isEmpty())
		{
			voitures.forEach(v->{
				
				 ReservationResponseDto dto = new ReservationResponseDto(v.getId(), v.getMarque(), v.getModele(),v.getImmatricule(),v.getPrixLocation(),v.getKilommetrage()); 
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


	@Override
	public ReservationDto saveOrUpdate(ReservationDto dto, boolean save) throws ParseException {
		Reservation reservation = GenericBuilder.of(Reservation::new)
				.with(Reservation::setActived, Boolean.TRUE)
				.with(Reservation::setDateDeDepart, IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateDeDepart()))
				.with(Reservation::setDateDeRetour, IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateDeRetour()))
				.with(Reservation::setNombreDeJours, dto.getNombreDeJours())
				.with(Reservation::setNouveauClient, dto.getNouveauClient())
				.with(Reservation::setReservationEnAttente, dto.getReservationEnAttente())
				.with(Reservation::setTotalTTC, dto.getTotalTTC())
				.with(Reservation::setVersement, dto.getVersement())
				.build();
		Voiture voiture = GenericBuilder.of(Voiture::new).with(Voiture::setId, dto.getIdVoiture()).build();
		Client client = null;
		if(dto.getIdClient() == null)
		{
			client = GenericBuilder.of(Client::new)
					.with(Client::setActived, Boolean.TRUE)
					.with(Client::setAdresse, "RAS")
					.with(Client::setClientBloque, Boolean.FALSE)
					.with(Client::setDateDeNaissance, null)
					.with(Client::setLieuDeNaissance, "RAS")
					.with(Client::setEmail, dto.getMail())
					.with(Client::setEndette,Boolean.FALSE)
					.with(Client::setLieuObtentionPasseport,"RAS")
					.with(Client::setLieuObtentionPermis,"RAS")
					.with(Client::setNom,dto.getNom())
					.with(Client::setNote,null)
					.with(Client::setNumeroDePermis,"RAS")
					.with(Client::setNumeroPasseport,"RAS")
					.with(Client::setNumeTelOne,dto.getTel())
					.with(Client::setNumTelTwo,"RAS")
					.with(Client::setObservation,"Client enregisté via une réservation")
					.with(Client::setPrenom,dto.getPrenom())
					.with(Client::setSommeDette,0.0)
					.with(Client::setTypeClient,Boolean.TRUE)
					.with(Client::setDateObtentionPassport,null)
					.with(Client::setDateObtentionPermis,null)
					.build();
			clientRepository.save(client);
		}else
		{
			client = GenericBuilder.of(Client::new).with(Client::setId, dto.getIdClient()).build();
		}
		reservation.setClient(client);
		reservation.setVoiture(voiture);
		if(!save)
		{
			reservation.setId(dto.getId());
		}
		reservationRepository.save(reservation);
		return dto;
	}

}
