package dz.agenceadam.locationvoiture.dto;

public class ReservationObjectDto {

	private ReservationDto reservationDto = new ReservationDto();
	private ClientDto clientDto = new ClientDto();
	private VoitureDto voitureDto = new VoitureDto();
	private String dateExpirationAssurance;
	
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

	
	public String getDateExpirationAssurance() {
		return dateExpirationAssurance;
	}

	public void setDateExpirationAssurance(String dateExpirationAssurance) {
		this.dateExpirationAssurance = dateExpirationAssurance;
	}

	@Override
	public String toString() {
		return "ReservationObjectDto [reservationDto=" +dateExpirationAssurance + " "+reservationDto + ", clientDto=" + clientDto + ", voitureDto="
				+ voitureDto + "]";
	}
	
	
}
