package dz.agenceadam.locationvoiture.dto;

import java.math.BigDecimal;


public class DetteDto {

	private Integer id; 
	private boolean actived;
	private String nom;
	private String prenom;
	private BigDecimal totalTTC;
	private BigDecimal versement;
	private BigDecimal resteApayer;
	private String statut;
	private String dateDeDepart;
	private String dateDeRetour;
	private Integer nombreDeJours;
	private String marque;
	private String modele;
	private Integer idLocation;
	
	public DetteDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
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

	public BigDecimal getResteApayer() {
		return resteApayer;
	}

	public void setResteApayer(BigDecimal resteApayer) {
		this.resteApayer = resteApayer;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Integer getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
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

	public Integer getNombreDeJours() {
		return nombreDeJours;
	}

	public void setNombreDeJours(Integer nombreDeJours) {
		this.nombreDeJours = nombreDeJours;
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

	@Override
	public String toString() {
		return "DetteDto [id=" + id + ", actived=" + actived + ", nom=" + nom + ", prenom=" + prenom + ", totalTTC="
				+ totalTTC + ", versement=" + versement + ", resteApayer=" + resteApayer + ", statut=" + statut
				+ ", dateDeDepart=" + dateDeDepart + ", dateDeRetour=" + dateDeRetour + ", nombreDeJours="
				+ nombreDeJours + ", marque=" + marque + ", modele=" + modele + ", idLocation=" + idLocation + "]";
	}

	
	
}
