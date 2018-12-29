package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@SuppressWarnings("serial")
@Entity
@Table(name = "tb_client")
public class Client  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	private String lieuDeNaissance;
	private String adresse;
	private String email;
	private String numeTelOne;
	private String numTelTwo;
	private Boolean typeClient;
	private String numeroPasseport;
	private String numeroDePermis;
	@Temporal(TemporalType.DATE)
	private Date dateObtentionPermis;
	@Temporal(TemporalType.DATE)
	private Date dateObtentionPassport;
	private String lieuObtentionPermis;
	private String lieuObtentionPasseport;
	private String observation;
	private Integer note;
	private Boolean actived;
	private Boolean endette;
	private Double sommeDette;
	private Boolean clientBloque;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_USER")
	private User user;
	
	
	


	public Client() {
		
	}
	
	




	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}






	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}






	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getNumeroDePermis() {
		return numeroDePermis;
	}




	public void setNumeroDePermis(String numeroDePermis) {
		this.numeroDePermis = numeroDePermis;
	}




	public String getAdresse() {
		return adresse;
	}






	public void setAdresse(String adresse) {
		this.adresse = adresse;
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






	public Boolean getTypeClient() {
		return typeClient;
	}






	public void setTypeClient(Boolean typeClient) {
		this.typeClient = typeClient;
	}






	public String getNumeroPasseport() {
		return numeroPasseport;
	}






	public void setNumeroPasseport(String numeroPasseport) {
		this.numeroPasseport = numeroPasseport;
	}






	public Date getDateObtentionPermis() {
		return dateObtentionPermis;
	}






	public void setDateObtentionPermis(Date dateObtentionPermis) {
		this.dateObtentionPermis = dateObtentionPermis;
	}






	public Date getDateObtentionPassport() {
		return dateObtentionPassport;
	}






	public void setDateObtentionPassport(Date dateObtentionPassport) {
		this.dateObtentionPassport = dateObtentionPassport;
	}






	public String getLieuObtentionPermis() {
		return lieuObtentionPermis;
	}






	public void setLieuObtentionPermis(String lieuObtentionPermis) {
		this.lieuObtentionPermis = lieuObtentionPermis;
	}






	public String getLieuObtentionPasseport() {
		return lieuObtentionPasseport;
	}






	public void setLieuObtentionPasseport(String lieuObtentionPasseport) {
		this.lieuObtentionPasseport = lieuObtentionPasseport;
	}






	public String getObservation() {
		return observation;
	}






	public void setObservation(String observation) {
		this.observation = observation;
	}






	public Boolean getEndette() {
		return endette;
	}






	public void setEndette(Boolean endette) {
		this.endette = endette;
	}






	public Double getSommeDette() {
		return sommeDette;
	}






	public void setSommeDette(Double sommeDette) {
		this.sommeDette = sommeDette;
	}






	public Boolean getClientBloque() {
		return clientBloque;
	}






	public void setClientBloque(Boolean clientBloque) {
		this.clientBloque = clientBloque;
	}






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


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	



	public Integer getNote() {
		return note;
	}






	public void setNote(Integer note) {
		this.note = note;
	}






	@JsonIgnore
	public User getUser() {
		return user;
	}


    


    public Boolean getActived() {
		return actived;
	}






	public void setActived(Boolean actived) {
		this.actived = actived;
	}






	@JsonSetter
	public void setUser(User user) {
		this.user = user;
	}






	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", adresse=" + adresse + ", email=" + email + ", numeTelOne=" + numeTelOne + ", numTelTwo="
				+ numTelTwo + ", typeClient=" + typeClient + ", numeroPasseport=" + numeroPasseport
				+ ", numeroDePermis=" + numeroDePermis + ", dateObtentionPermis=" + dateObtentionPermis
				+ ", dateObtentionPassport=" + dateObtentionPassport + ", lieuObtentionPermis=" + lieuObtentionPermis
				+ ", lieuObtentionPasseport=" + lieuObtentionPasseport + ", observation=" + observation + ", note="
				+ note + ", actived=" + actived + ", endette=" + endette + ", sommeDette=" + sommeDette
				+ ", clientBloque=" + clientBloque + "]";
	}




   

	
	
}
