package dz.agenceadam.locationvoiture.dto;

public class ProfilePictureDto {
	
	private Integer id;
	private byte [] logo;
	private Integer idProfile;
	private String nomFichier;
	
	public ProfilePictureDto() {
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

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	
	
}
