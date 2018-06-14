package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_VOITURE")
@Entity
public class Voiture  implements Serializable{
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	@Column(name="MARQUE")
	private String marque;
	@Column(name="IMMATRICULE")
	private String immatricule;
	@Column(name="PRIX_ACHAT")
	private Double prixAchat;
	@Column(name="PRIX_LOCATION")
	private Double prixLocation;
	@Column(name="ENERGIE")
	private String energie;
	
	public Voiture() {

	}
	
	public Voiture(String marque, String immatricule, Double prixAchat, Double prixLocation, String energie) {
		super();
		this.marque = marque;
		this.immatricule = immatricule;
		this.prixAchat = prixAchat;
		this.prixLocation = prixLocation;
		this.energie = energie;
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

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", immatricule=" + immatricule + ", prixAchat=" + prixAchat
				+ ", prixLocation=" + prixLocation + ", energie=" + energie + "]";
	}
	
	
	
	
	
	
}
