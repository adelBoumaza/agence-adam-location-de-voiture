package dz.agenceadam.locationvoiture.dto;



public class ClientDto {

	private Integer id;
	private String nom;
	private String prenom;
	private String dateDeNaissance;
	private String adresse;
	private String email;
	private String numeTelOne;
	private String numTelTwo;
	private Boolean typeClient;
	private String numeroPasseport;
	private String numeroDePermis;
	private String dateObtentionPermis;
	private String dateObtentionPassport;
	private String lieuObtentionPermis;
	private String lieuObtentionPasseport;
	private String observation;
	private Integer note;
	private Boolean actived;
	private Boolean endette;
	private Double sommeDette;
	private Boolean clientBloque;
	private Integer idUser;
	
	public ClientDto() {
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

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getNumeroDePermis() {
		return numeroDePermis;
	}

	public void setNumeroDePermis(String numeroDePermis) {
		this.numeroDePermis = numeroDePermis;
	}

	public String getDateObtentionPermis() {
		return dateObtentionPermis;
	}

	public void setDateObtentionPermis(String dateObtentionPermis) {
		this.dateObtentionPermis = dateObtentionPermis;
	}

	public String getDateObtentionPassport() {
		return dateObtentionPassport;
	}

	public void setDateObtentionPassport(String dateObtentionPassport) {
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

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "ClientDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", adresse=" + adresse + ", email=" + email + ", numeTelOne=" + numeTelOne + ", numTelTwo="
				+ numTelTwo + ", typeClient=" + typeClient + ", numeroPasseport=" + numeroPasseport
				+ ", numeroDePermis=" + numeroDePermis + ", dateObtentionPermis=" + dateObtentionPermis
				+ ", dateObtentionPassport=" + dateObtentionPassport + ", lieuObtentionPermis=" + lieuObtentionPermis
				+ ", lieuObtentionPasseport=" + lieuObtentionPasseport + ", observation=" + observation + ", note="
				+ note + ", actived=" + actived + ", endette=" + endette + ", sommeDette=" + sommeDette
				+ ", clientBloque=" + clientBloque + ", idUser=" + idUser + "]";
	}

	
	
	
}
