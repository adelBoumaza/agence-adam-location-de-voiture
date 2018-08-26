package dz.agenceadam.locationvoiture.service;

import java.text.ParseException;
import java.util.List;

import dz.agenceadam.locationvoiture.dto.ReservationDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;

public interface IReservationService {

	List<ReservationResponseDto> allReservationByMonthAndYear(int month,int year,int idUser);
	
	ReservationDto saveOrUpdate(ReservationDto dto,boolean save) throws ParseException;
}
