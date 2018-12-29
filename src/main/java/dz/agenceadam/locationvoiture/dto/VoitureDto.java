package dz.agenceadam.locationvoiture.dto;

import java.util.ArrayList;
import java.util.List;


public class VoitureDto {

	private Integer id;

	private String marque;
	
	private String modele;
	
	private String typeVehicule;
	
	private String immatricule;
	
	private Double prixAchat;
	
	private String couleur;
	
	private Double kilommetrage;
	
	private String carburantActuel;
	
	private Double prixLocation;
	
	private Boolean roueDeSecours;
	
	private Integer anneeFabrication;
	
	private String observation;
	
	private String energie;
	
	private Boolean actived;
	
	private Integer idUser;

	private List<AssuranceDto> listeAssuranceDto = new ArrayList<>();
	
	
	
	
	public VoitureDto(Integer id, String marque, String modele, String typeVehicule, String immatricule,
			Double prixAchat, String couleur, Double kilommetrage, String carburantActuel, Double prixLocation,
			Boolean roueDeSecours, Integer anneeFabrication, String observation, String energie, Boolean actived) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.typeVehicule = typeVehicule;
		this.immatricule = immatricule;
		this.prixAchat = prixAchat;
		this.couleur = couleur;
		this.kilommetrage = kilommetrage;
		this.carburantActuel = carburantActuel;
		this.prixLocation = prixLocation;
		this.roueDeSecours = roueDeSecours;
		this.anneeFabrication = anneeFabrication;
		this.observation = observation;
		this.energie = energie;
		this.actived = actived;
	}


	public VoitureDto() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getTypeVehicule() {
		return typeVehicule;
	}


	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}


	public String getImmatricule() {
		return immatricule;
	}


	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}


	public Double getPrixAchat() {
		return prixAchat;
	}


	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public Double getKilommetrage() {
		return kilommetrage;
	}


	public void setKilommetrage(Double kilommetrage) {
		this.kilommetrage = kilommetrage;
	}


	public String getCarburantActuel() {
		return carburantActuel;
	}


	public void setCarburantActuel(String carburantActuel) {
		this.carburantActuel = carburantActuel;
	}


	public Double getPrixLocation() {
		return prixLocation;
	}


	public void setPrixLocation(Double prixLocation) {
		this.prixLocation = prixLocation;
	}


	public Boolean getRoueDeSecours() {
		return roueDeSecours;
	}


	public void setRoueDeSecours(Boolean roueDeSecours) {
		this.roueDeSecours = roueDeSecours;
	}


	public Integer getAnneeFabrication() {
		return anneeFabrication;
	}


	public void setAnneeFabrication(Integer anneeFabrication) {
		this.anneeFabrication = anneeFabrication;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getEnergie() {
		return energie;
	}


	public void setEnergie(String energie) {
		this.energie = energie;
	}


	public Boolean getActived() {
		return actived;
	}


	public void setActived(Boolean actived) {
		this.actived = actived;
	}


	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public List<AssuranceDto> getListeAssuranceDto() {
		return listeAssuranceDto;
	}


	public void setListeAssuranceDto(List<AssuranceDto> listeAssuranceDto) {
		this.listeAssuranceDto = listeAssuranceDto;
	}
	
	
	
}
