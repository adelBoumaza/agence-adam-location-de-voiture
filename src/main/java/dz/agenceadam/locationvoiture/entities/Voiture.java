package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@SuppressWarnings("serial")
@Table(name = "tb_voiture")
@Entity
public class Voiture  implements Serializable{
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	
	@Column(name="MARQUE")
	private String marque;
	
	@Column(name="MODELE")
	private String modele;
	
	@Column(name="TYPE_VEHICULE")
	private String typeVehicule;
	
	@Column(name="IMMATRICULE")
	private String immatricule;
	
	@Column(name="PRIX_ACHAT")
	private Double prixAchat;
	
	@Column(name="COULEUR")
	private String couleur;
	
	@Column(name="KM_ACTUEL")
	private Double kilommetrage;
	
	@Column(name="CARBURANT_ACTUEL")
	private String carburantActuel;
	
	@Column(name="PRIX_LOCATION")
	private Double prixLocation;
	
	@Column(name="ROUE_DE_SECOURS")
	private Boolean roueDeSecours;
	
	@Column(name="ANNEE_FABRICATION")
	private Integer anneeFabrication;
	
	@Column(name="OBSERVATION")
	private String observation;
	
	@Column(name="ENERGIE")
	private String energie;
	
	@Column(name="ACTIVED")
	private Boolean actived;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_USER")
	private User user;
	
	@OneToMany(mappedBy = "voiture")
	private List<Assurance> listeAssurance;

	
	public Voiture() {

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



	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Double getPrixLocation() {
		return prixLocation;
	}

	public void setPrixLocation(Double prixLocation) {
		this.prixLocation = prixLocation;
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



	@JsonIgnore
	public User getUser() {
		return user;
	}


    @JsonSetter
	public void setUser(User user) {
		this.user = user;
	}
    
    


    @JsonIgnore
	public List<Assurance> getListeAssurance() {
		return listeAssurance;
	}


    @JsonSetter
	public void setListeAssurance(List<Assurance> listeAssurance) {
		this.listeAssurance = listeAssurance;
	}



	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", immmatricule=" + immatricule + ", prixAchat=" + prixAchat
				+ ", prixLocation=" + prixLocation + ", energie=" + energie + "]";
	}
	
	
	
	
	
	
}
