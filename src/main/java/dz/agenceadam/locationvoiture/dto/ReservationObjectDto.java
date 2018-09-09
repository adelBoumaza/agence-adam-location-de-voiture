package dz.agenceadam.locationvoiture.dto;

public class ReservationObjectDto {

	private ReservationDto reservationDto = new ReservationDto();
	private ClientDto clientDto = new ClientDto();
	private VoitureDto voitureDto = new VoitureDto();
	
	public ReservationObjectDto() {
		
	}

	public ReservationDto getReservationDto() {
		return reservationDto;
	}

	public void setReservationDto(ReservationDto reservationDto) {
		this.reservationDto = reservationDto;
	}

	public ClientDto getClientDto() {
		return clientDto;
	}

	public void setClientDto(ClientDto clientDto) {
		this.clientDto = clientDto;
	}

	public VoitureDto getVoitureDto() {
		return voitureDto;
	}

	public void setVoitureDto(VoitureDto voitureDto) {
		this.voitureDto = voitureDto;
	}

	@Override
	public String toString() {
		return "ReservationObjectDto [reservationDto=" + reservationDto + ", clientDto=" + clientDto + ", voitureDto="
				+ voitureDto + "]";
	}
	
	
}
