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
	private boolean debutReservation;
	private boolean finReservation;
	private String heureDepart;
	private String heureRetour;
	private Boolean reservationEnAttente;
	


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
	
	public boolean getDebutReservation() {
		return debutReservation;
	}
	public void setDebutReservation(boolean debutReservation) {
		this.debutReservation = debutReservation;
	}
	
	
	public boolean isFinReservation() {
		return finReservation;
	}
	public void setFinReservation(boolean finReservation) {
		this.finReservation = finReservation;
	}
	
	
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getHeureRetour() {
		return heureRetour;
	}
	public void setHeureRetour(String heureRetour) {
		this.heureRetour = heureRetour;
	}
	
	
	public Boolean getReservationEnAttente() {
		return reservationEnAttente;
	}
	public void setReservationEnAttente(Boolean reservationEnAttente) {
		this.reservationEnAttente = reservationEnAttente;
	}
	@Override
	public String toString() {
		return "ReservationDaysDto [jour=" + jour + ", dispo=" + dispo + ", idClient=" + idClient + ", idReservation="
				+ idReservation + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", dateDepart="
				+ dateDepart + ", dateRetour=" + dateRetour + ", nbrJours=" + nbrJours + ", debutReservation="
				+ debutReservation + "]";
	}
	
	
	
	
}
