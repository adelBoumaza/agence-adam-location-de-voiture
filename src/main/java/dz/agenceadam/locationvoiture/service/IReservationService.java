package dz.agenceadam.locationvoiture.service;

import java.util.List;

import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;

public interface IReservationService {

	List<ReservationResponseDto> allReservationByMonthAndYear(int month,int year,int idUser);
}
