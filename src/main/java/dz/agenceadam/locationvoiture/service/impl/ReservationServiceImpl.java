package dz.agenceadam.locationvoiture.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.ReservationDaysDto;
import dz.agenceadam.locationvoiture.dto.ReservationDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.Reservation;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
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
	public List<ReservationResponseDto> allReservationByMonthAndYear(int month, int year, int idUser)  {
		
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
			reservations.forEach(reservation->{
					responses.forEach(response->{
						if(reservation.getVoiture().getId() == response.getIdVoiture())
						{
							
							final Date dd = reservation.getDateDeDepart();
							final Date dr = reservation.getDateDeRetour();
							response.getDays().forEach(j->{
								LocalDate localDate = LocalDate.of( year , month , j.getJour());
						        Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
						        if( (date1.after(dd) || date1.equals(dd)) && (date1.before(dr)))
						        {
						        	setDisponibiliteReservation(reservation, j);
						        }else if(date1.equals(dd) && date1.equals(dr))
						        {
						        	setDisponibiliteReservation(reservation, j);
						        }
						        if(!j.getDispo())
						        {
						        	if(date1.equals(dd))
						        	{
						        		j.setDebutReservation(true);
						        	}
						        }
							});
							/*response.getDays().stream()
							.filter(action ->
							(
									action.getJour() >= jourDepart && action.getJour() < jourRetour) || 
									(action.getJour() == jourDepart && action.getJour() == jourRetour)
							)
							.forEach(result->{
								result.setDispo(Boolean.FALSE);
								System.out.println(result);
							});*/
							
						}
					});
			});
		}
		

		
		return responses;
	}


	private void setDisponibiliteReservation(Reservation reservation, ReservationDaysDto j) {
		j.setDispo(Boolean.FALSE);
		j.setIdClient(reservation.getClient().getId());
		j.setNomClient(reservation.getClient().getNom());
		j.setPrenomClient(reservation.getClient().getPrenom());
		j.setIdReservation(reservation.getId());
		j.setDateDepart(reservation.getDateDeDepart());
		j.setDateRetour(reservation.getDateDeRetour());
		j.setNbrJours(reservation.getNombreDeJours());
	}


	@Override
	public ReservationDto saveOrUpdate(ReservationDto dto, boolean save) throws ParseException, DataFoundedException {
		Reservation reservation = GenericBuilder.of(Reservation::new)
				.with(Reservation::setActived, Boolean.TRUE)
				.with(Reservation::setDateDeDepart, IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateDeDepart()))
				.with(Reservation::setDateDeRetour, IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateDeRetour()))
				.with(Reservation::setNombreDeJours, dto.getNombreDeJours())
				.with(Reservation::setNouveauClient, dto.getNouveauClient())
				.with(Reservation::setReservationEnAttente, dto.getReservationEnAttente())
				.with(Reservation::setTotalTTC, dto.getTotalTTC())
				.with(Reservation::setVersement, dto.getVersement() == null ? BigDecimal.ZERO:dto.getVersement())
				.build();
		Voiture voiture = GenericBuilder.of(Voiture::new).with(Voiture::setId, dto.getIdVoiture()).build();
		Client client = null;
		List<Reservation> existingReservation = reservationRepository.verifyExistingReservation(IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateDeDepart()), IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateDeRetour()), dto.getIdVoiture());
		if(existingReservation.isEmpty())
		{
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
		}
		else
		{
			throw new DataFoundedException("les dates se chevauchent avec une autre reservation, veuillez modifier la date de retour svp!");
		}
		return dto;
	}

}
