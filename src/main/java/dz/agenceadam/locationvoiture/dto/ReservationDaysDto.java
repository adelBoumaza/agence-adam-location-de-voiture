package dz.agenceadam.locationvoiture.dto;

public class ReservationDaysDto {

	private Integer jour;
	private Boolean dispo;
	
	
	public ReservationDaysDto(Integer jour, Boolean dispo) {
		super();
		this.jour = jour;
		this.dispo = dispo;
	}

	public ReservationDaysDto() {
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
