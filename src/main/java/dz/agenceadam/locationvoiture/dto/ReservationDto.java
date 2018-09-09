package dz.agenceadam.locationvoiture.dto;

import java.math.BigDecimal;


public class ReservationDto {
	private Integer id;
	private Boolean nouveauClient;
	private Boolean actived;
	private String dateDeDepart;
	private String dateDeRetour;
	private BigDecimal nombreDeJours;
	private BigDecimal totalTTC;
	private BigDecimal versement;
	private Boolean reservationEnAttente;
	private Integer  idClient;
	private Integer idVoiture;
	private String nom;
	private String prenom;
	private String tel;
	private String mail;
	private String heureDepart;
	private String heureRetour;
	
	
	public ReservationDto(Integer id, Boolean nouveauClient, Boolean actived, String dateDeDepart, String dateDeRetour,
			BigDecimal nombreDeJours, BigDecimal totalTTC, BigDecimal versement, Boolean reservationEnAttente,
			String heureDepart,
			String heureRetour) {
		super();
		this.id = id;
		this.nouveauClient = nouveauClient;
		this.actived = actived;
		this.dateDeDepart = dateDeDepart;
		this.dateDeRetour = dateDeRetour;
		this.nombreDeJours = nombreDeJours;
		this.totalTTC = totalTTC;
		this.versement = versement;
		this.reservationEnAttente = reservationEnAttente;
		this.heureDepart = heureDepart;
		this.heureRetour = heureRetour;
	}

	public ReservationDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getNouveauClient() {
		return nouveauClient;
	}

	public void setNouveauClient(Boolean nouveauClient) {
		this.nouveauClient = nouveauClient;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public String getDateDeDepart() {
		return dateDeDepart;
	}

	public void setDateDeDepart(String dateDeDepart) {
		this.dateDeDepart = dateDeDepart;
	}

	public String getDateDeRetour() {
		return dateDeRetour;
	}

	public void setDateDeRetour(String dateDeRetour) {
		this.dateDeRetour = dateDeRetour;
	}

	public BigDecimal getNombreDeJours() {
		return nombreDeJours;
	}

	public void setNombreDeJours(BigDecimal nombreDeJours) {
		this.nombreDeJours = nombreDeJours;
	}

	public BigDecimal getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(BigDecimal totalTTC) {
		this.totalTTC = totalTTC;
	}

	public BigDecimal getVersement() {
		return versement;
	}

	public void setVersement(BigDecimal versement) {
		this.versement = versement;
	}

	public Boolean getReservationEnAttente() {
		return reservationEnAttente;
	}

	public void setReservationEnAttente(Boolean reservationEnAttente) {
		this.reservationEnAttente = reservationEnAttente;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Integer idVoiture) {
		this.idVoiture = idVoiture;
	}
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	@Override
	public String toString() {
		return "ReservationDto [id=" + id + ", nouveauClient=" + nouveauClient + ", actived=" + actived
				+ ", dateDeDepart=" + dateDeDepart + ", dateDeRetour=" + dateDeRetour + ", nombreDeJours="
				+ nombreDeJours + ", totalTTC=" + totalTTC + ", versement=" + versement + ", reservationEnAttente="
				+ reservationEnAttente + ", idClient=" + idClient + ", idVoiture=" + idVoiture + "]";
	}
	
	
}
