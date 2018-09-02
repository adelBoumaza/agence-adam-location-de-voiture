package dz.agenceadam.locationvoiture.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ReservationDaysDto {

	private Integer jour;
	private Boolean dispo;
	private Integer idClient;
	private Integer idReservation;
	private String nomClient;
	private String prenomClient;
	private Date   dateDepart;
	private Date   dateRetour;
	private BigDecimal nbrJours;
	


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
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	
	public BigDecimal getNbrJours() {
		return nbrJours;
	}
	public void setNbrJours(BigDecimal nbrJours) {
		this.nbrJours = nbrJours;
	}
	@Override
	public String toString() {
		return "ReservationDaysDto [jour=" + jour + ", dispo=" + dispo + ", idClient=" + idClient + ", idReservation="
				+ idReservation + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", dateDepart="
				+ dateDepart + ", dateRetour=" + dateRetour + ", nbrJours=" + nbrJours + "]";
	}
	
	
	
	
}
