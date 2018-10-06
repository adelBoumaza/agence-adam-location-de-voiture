package dz.agenceadam.locationvoiture.controller;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.ReservationDto;
import dz.agenceadam.locationvoiture.dto.ReservationObjectDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;
import dz.agenceadam.locationvoiture.entities.Reservation;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.service.IReservationService;

@RestController
@RequestMapping(value="/api/v1")
public class ReservationController {

	@Autowired
	private IReservationService iReservationService;
	
	private final static Logger LOGGER = Logger.getLogger(ReservationController.class);
	
	@GetMapping(value="/reservation/allReservationByMonthAndYears/{month}/{year}/{idUser}")
	public List<ReservationResponseDto> findAllReservationByMonthAndYears
			(@PathVariable int month,@PathVariable int year,@PathVariable Integer idUser)
	{
		List<ReservationResponseDto> data = iReservationService.allReservationByMonthAndYear(month, year, idUser);
		data.forEach(action->{
			LOGGER.info(action);
		});
		return data;
	}
	
	@PostMapping(value="/reservation/saveOrUpdate/{save}")
	public ReservationDto saveOrUpdateReservation(@RequestBody ReservationDto dto,@PathVariable boolean save) throws ParseException, DataFoundedException
	{
		return iReservationService.saveOrUpdate(dto, save);
	}
	
	@PostMapping(value="/reservation/annuler/{idReservation}")
	public void annulerReservation(@PathVariable Integer idReservation) 
	{
		iReservationService.annulerReservation(idReservation);
	}
	
	@GetMapping(value="/reservation/findOneReservation/{idReservation}")
	public ReservationObjectDto findOneReservation(@PathVariable Integer idReservation)
	{
		return iReservationService.findOneReservation(idReservation);
	}
}
