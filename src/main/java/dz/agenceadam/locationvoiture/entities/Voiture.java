package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@SuppressWarnings("serial")
@Table(name = "TB_VOITURE")
@Entity
public class Voiture  implements Serializable{
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	@Column(name="MARQUE")
	private String marque;
	@Column(name="MATRICULE")
	private String matricule;
	@Column(name="PRIX_ACHAT")
	private Double prixAchat;
	@Column(name="PRIX_LOCATION")
	private Double prixLocation;
	@Column(name="ENERGIE")
	private String energie;
	private Boolean actived;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_USER")
	private User user;

	
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

	

	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
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



	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", matricule=" + matricule + ", prixAchat=" + prixAchat
				+ ", prixLocation=" + prixLocation + ", energie=" + energie + "]";
	}
	
	
	
	
	
	
}
