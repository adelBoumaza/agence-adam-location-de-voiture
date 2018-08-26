package dz.agenceadam.locationvoiture.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.ReservationDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;
import dz.agenceadam.locationvoiture.service.IReservationService;

@RestController
@RequestMapping(value="/api/v1")
public class ReservationController {

	@Autowired
	private IReservationService iReservationService;
	
	@GetMapping(value="/reservation/allReservationByMonthAndYears/{month}/{year}/{idUser}")
	public List<ReservationResponseDto> findAllReservationByMonthAndYears
			(@PathVariable int month,@PathVariable int year,@PathVariable Integer idUser)
	{
		return iReservationService.allReservationByMonthAndYear(month, year, idUser);
	}
	
	@PostMapping(value="/reservation/saveOrUpdate/{save}")
	public ReservationDto saveOrUpdateReservation(@RequestBody ReservationDto dto,@PathVariable boolean save) throws ParseException
	{
		return iReservationService.saveOrUpdate(dto, save);
	}
}
