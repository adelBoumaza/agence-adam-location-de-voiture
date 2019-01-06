package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;
import java.util.Arrays;

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

@Entity
@Table(name="tb_profile_picture")
public class ProfilePicture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	
	@Lob
	private byte [] logo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_profile")
	private Profile profile;
	
	private String nomFichier;
	
	public ProfilePicture() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	@Override
	public String toString() {
		return "ProfilePicture [id=" + id + ", profile=" + profile + ", nomFichier="
				+ nomFichier + "]";
	}
	
	
}
