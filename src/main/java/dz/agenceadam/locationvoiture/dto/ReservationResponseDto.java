package dz.agenceadam.locationvoiture.dto;

import java.util.ArrayList;
import java.util.List;


public class ReservationResponseDto {

	private Integer idVoiture;
	private String marque;
	private String modele;
	private String immatricule;
	private Double prixLocation;
	private Double kmActuelle;
	private List<ReservationDaysDto> days = new ArrayList<>();
	private Integer idClient;
	private Integer idReservation;
	private String nomClient;
	private String prenomClient;
	
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

	
	public String getImmatricule() {
		return immatricule;
	}

	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}

	public Double getPrixLocation() {
		return prixLocation;
	}

	public void setPrixLocation(Double prixLocation) {
		this.prixLocation = prixLocation;
	}

	public Double getKmActuelle() {
		return kmActuelle;
	}

	public void setKmActuelle(Double kmActuelle) {
		this.kmActuelle = kmActuelle;
	}

	public ReservationResponseDto(Integer idVoiture, String marque, String modele,
			String immatricule,Double prixLocation,Double kmActuelle) {
		super();
		this.idVoiture = idVoiture;
		this.marque = marque;
		this.modele = modele;
		this.immatricule = immatricule;
		this.prixLocation = prixLocation;
		this.kmActuelle = kmActuelle;
	}
	
	

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	@Override
	public String toString() {
		return "ReservationResponseDto [idVoiture=" + idVoiture + ", marque=" + marque + ", modele=" + modele
				+ ", immatricule=" + immatricule + ", prixLocation=" + prixLocation + ", kmActuelle=" + kmActuelle
				+ ", days=" + days + ", idClient=" + idClient + ", idReservation=" + idReservation + ", nomClient="
				+ nomClient + ", prenomClient=" + prenomClient + "]";
	}


	
	
}
