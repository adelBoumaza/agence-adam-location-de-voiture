package dz.agenceadam.locationvoiture.dto;

import java.util.Date;

public class ReservationDaysDto {

	private Integer jour;
	private Boolean dispo;
	private Date date;
	
	
	public ReservationDaysDto(Integer jour, Boolean dispo,Date date) {
		super();
		this.jour = jour;
		this.dispo = dispo;
		this.date  = date;
	}

	public ReservationDaysDto(Integer jour, Boolean dispo) {
		super();
		this.jour = jour;
		this.dispo = dispo;
	} 
	public ReservationDaysDto() {
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getJour() {
		return jour;
	}

	public void setJour(Integer jour) {
		this.jour = jour;
	}

	public Boolean getDispo() {
		return dispo;
	}

	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}

	@Override
	public String toString() {
		return "ReservationDaysDto [jour=" + jour + ", dispo=" + dispo + "]";
	}
	
	
}
