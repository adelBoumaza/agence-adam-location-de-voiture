package dz.agenceadam.locationvoiture.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dz.agenceadam.locationvoiture.dto.LocationDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.Dette;
import dz.agenceadam.locationvoiture.entities.Location;
import dz.agenceadam.locationvoiture.entities.Reservation;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.ClientRepository;
import dz.agenceadam.locationvoiture.repository.DetteRepository;
import dz.agenceadam.locationvoiture.repository.LocationRepository;
import dz.agenceadam.locationvoiture.repository.ReservationRepository;
import dz.agenceadam.locationvoiture.repository.VoitureRepository;
import dz.agenceadam.locationvoiture.service.ILocationService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.IConstant;

@Service
@Transactional
public class LocationServiceImpl implements ILocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private DetteRepository detteRepository;

	@Override
	public LocationDto saveOrUpdate(LocationDto dto, boolean save) {
		
		Client client = generateClient(dto);
		Voiture voiture = generateVoiture(dto);
		Reservation reservation = generateReservation(dto);
		clientRepository.save(client);
		voitureRepository.save(voiture);
		reservationRepository.save(reservation);
		Location location = GenericBuilder.of(Location::new)
				.with(Location::setActived, true)
				.with(Location::setCaution, dto.getCaution())
				.with(Location::setDateConfirmationLocation, new Date())
				.with(Location::setMontant, dto.getMontant())
				.with(Location::setNombreDeJours, dto.getNombreDeJours())
				.with(Location::setPrixUnitaire, dto.getPrixUnitaire())
				.with(Location::setRemise, dto.getRemise())
				.with(Location::setResteApaye, dto.getResteApaye())
				.with(Location::setStatut, dto.getStatut())
				.with(Location::setTotalHT, dto.getTotalHT())
				.with(Location::setTotalTTC, dto.getTotalTTC())
				.with(Location::setVersement, dto.getVersement())
				.with(Location::setClient,client)
				.with(Location::setVoiture, voiture)
				.with(Location::setReservation, reservation)
				.build();
		
		locationRepository.save(location);
		
		if(!dto.getStatut().equals(IConstant.Statut.STATUT_PAYE))
		{
			Dette dette = GenericBuilder.of(Dette::new)
					.with(Dette::setNom, dto.getNomClient()).with(Dette::setPrenom, dto.getPrenomClient())
					.with(Dette::setActived, Boolean.TRUE)
					.with(Dette::setResteApayer, dto.getResteApaye())
					.with(Dette::setStatut, dto.getStatut())
					.with(Dette::setTotalTTC, dto.getTotalTTC())
					.with(Dette::setVersement, dto.getVersement())
					.with(Dette::setLocation, location)
					.build();
			detteRepository.save(dette);
		}
		
		
			
		return dto;
	}
	
	private Reservation generateReservation(LocationDto dto) {
		Reservation reservation = reservationRepository.findOne(dto.getIdReservation());
		reservation.setHeureDepart(dto.getHeureDepart());
		reservation.setHeureRetour(dto.getHeureRetour());
		reservation.setReservationEnAttente(Boolean.FALSE);
		
		return reservation;
	}

	private Voiture generateVoiture(LocationDto dto) {
		Voiture voiture = voitureRepository.findOne(dto.getIdVoiture());
		voiture.setKilommetrage(dto.getKmActuel());
		voiture.setImmatricule(dto.getImmatricule());
		voiture.setCarburantActuel(dto.getCarburantActuel());
		
		return voiture;
	}

	
	private Client generateClient(LocationDto dto) {
		Client client   = clientRepository.findOne(dto.getIdClient());
		client.setNom(dto.getNomClient());
		client.setPrenom(dto.getPrenomClient());
		client.setNumeroDePermis(dto.getNumeroPermis());
		client.setNumeroPasseport(dto.getNumeroPasseport());
		client.setNumeTelOne(dto.getTel());
		client.setAdresse(dto.getAdresse());
				
		return client;
	}
	
	
	
}
