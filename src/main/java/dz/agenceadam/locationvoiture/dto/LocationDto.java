package dz.agenceadam.locationvoiture.dto;

import java.math.BigDecimal;


public class LocationDto {
	
	private Integer id;
	private BigDecimal totalTTC;
	private BigDecimal totalHT;
	private BigDecimal prixUnitaire;
	private Integer nombreDeJours;
	private BigDecimal remise;
	private BigDecimal versement;
	private BigDecimal resteApaye;
	private String statut;
	private String caution;
	private BigDecimal montant;
	private Integer idReservation;
	private String heureDepart;
	private String heureRetour;
	private Integer idVoiture;
	private String immatricule;
	private Double kmActuel;
	private String carburantActuel;
	private Integer idClient;
	private String nomClient;
	private String prenomClient;
	private String numeroPasseport;
	private String numeroPermis;
	private String adresse;
	private String tel;
	
	public LocationDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(BigDecimal totalTTC) {
		this.totalTTC = totalTTC;
	}

	public BigDecimal getTotalHT() {
		return totalHT;
	}

	public void setTotalHT(BigDecimal totalHT) {
		this.totalHT = totalHT;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getNombreDeJours() {
		return nombreDeJours;
	}

	public void setNombreDeJours(Integer nombreDeJours) {
		this.nombreDeJours = nombreDeJours;
	}

	public BigDecimal getRemise() {
		return remise;
	}

	public void setRemise(BigDecimal remise) {
		this.remise = remise;
	}

	public BigDecimal getVersement() {
		return versement;
	}

	public void setVersement(BigDecimal versement) {
		this.versement = versement;
	}

	public BigDecimal getResteApaye() {
		return resteApaye;
	}

	public void setResteApaye(BigDecimal resteApaye) {
		this.resteApaye = resteApaye;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
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

	public Integer getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Integer idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getImmatricule() {
		return immatricule;
	}

	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}

	public Double getKmActuel() {
		return kmActuel;
	}

	public void setKmActuel(Double kmActuel) {
		this.kmActuel = kmActuel;
	}

	public String getCarburantActuel() {
		return carburantActuel;
	}

	public void setCarburantActuel(String carburantActuel) {
		this.carburantActuel = carburantActuel;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
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

	public String getNumeroPasseport() {
		return numeroPasseport;
	}

	public void setNumeroPasseport(String numeroPasseport) {
		this.numeroPasseport = numeroPasseport;
	}

	public String getNumeroPermis() {
		return numeroPermis;
	}

	public void setNumeroPermis(String numeroPermis) {
		this.numeroPermis = numeroPermis;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "LocationDto [id=" + id + ", totalTTC=" + totalTTC + ", totalHT=" + totalHT + ", prixUnitaire="
				+ prixUnitaire + ", nombreDeJours=" + nombreDeJours + ", remise=" + remise + ", versement=" + versement
				+ ", resteApaye=" + resteApaye + ", statut=" + statut + ", caution=" + caution + ", montant=" + montant
				+ ", idReservation=" + idReservation + ", heureDepart=" + heureDepart + ", heureRetour=" + heureRetour
				+ ", idVoiture=" + idVoiture + ", immatricule=" + immatricule + ", kmActuel=" + kmActuel
				+ ", carburantActuel=" + carburantActuel + ", idClient=" + idClient + ", nomClient=" + nomClient
				+ ", prenomClient=" + prenomClient + ", numeroPasseport=" + numeroPasseport + ", numeroPermis="
				+ numeroPermis + ", adresse=" + adresse + ", tel=" + tel + "]";
	}
	
	
	

}
