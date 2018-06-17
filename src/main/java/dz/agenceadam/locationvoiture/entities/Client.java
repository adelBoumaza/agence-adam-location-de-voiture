package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "TB_CLIENT")
public class Client  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID")
	private Integer id;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String email;
	private String numeroDePermis;
	private Date dateObtention;
	private Date dateExpiration;
	
	
	


	public Client() {
		
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




	public Date getDateObtention() {
		return dateObtention;
	}




	public void setDateObtention(Date dateObtention) {
		this.dateObtention = dateObtention;
	}




	public Date getDateExpiration() {
		return dateExpiration;
	}




	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
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




	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", email=" + email + ", numeroDePermis=" + numeroDePermis + ", dateObtention=" + dateObtention
				+ ", dateExpiration=" + dateExpiration + "]";
	}
	
	
	
	
}
