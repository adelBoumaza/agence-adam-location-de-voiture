package dz.agenceadam.locationvoiture.dto;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class ProfileDto {
	
	private Integer id;
	private String nom;
	private String prenom;
	private Boolean actived;
	private String adresse;
    private String nomAgence;
    private String email;
    private String numeTelOne;
    private String numTelTwo;
    private Integer idUser;
    
    public ProfileDto() {
    	
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	


	@Override
	public String toString() {
		return "ProfileDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", actived=" + actived + ", adresse="
				+ adresse + ", nomAgence=" + nomAgence + ", email=" + email + ", logo=" 
				+ ", numeTelOne=" + numeTelOne + ", numTelTwo=" + numTelTwo + ", idUser=" + idUser + "]";
	}
    
}