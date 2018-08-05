package dz.agenceadam.locationvoiture.dto;

import java.util.ArrayList;
import java.util.List;

public class ReservationResponseDto {

	private Integer idVoiture;
	private String marque;
	private String modele;
	private List<ReservationDaysDto> days = new ArrayList<>();
	
	public ReservationResponseDto() {}

	public Integer getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Integer idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	
	

	public List<ReservationDaysDto> getDays() {
		return days;
	}

	public void setDays(List<ReservationDaysDto> days) {
		this.days = days;
	}

	public ReservationResponseDto(Integer idVoiture, String marque, String modele) {
		super();
		this.idVoiture = idVoiture;
		this.marque = marque;
		this.modele = modele;
	}

	@Override
	public String toString() {
		return "ReservationResponseDto [idVoiture=" + idVoiture + ", marque=" + marque + ", modele=" + modele
				+ ", days=" + days + "]";
	}
	
	
}
