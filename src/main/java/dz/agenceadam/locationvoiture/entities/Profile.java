package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_profile")
public class Profile  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	private String nom;
	private String prenom;
	private Boolean actived;
	private String adresse;
    private String nomAgence;
    private String email;
    private String numeTelOne;
    private String numTelTwo;

    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FK_USER")
    private User user;
    
    public Profile() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getNumeTelOne() {
		return numeTelOne;
	}

	public void setNumeTelOne(String numeTelOne) {
		this.numeTelOne = numeTelOne;
	}

	public String getNumTelTwo() {
		return numTelTwo;
	}

	public void setNumTelTwo(String numTelTwo) {
		this.numTelTwo = numTelTwo;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	@JsonSetter
	public void setUser(User user) {
		this.user = user;
	}

    
	
    
	
}