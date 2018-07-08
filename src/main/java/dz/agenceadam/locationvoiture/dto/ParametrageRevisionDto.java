package dz.agenceadam.locationvoiture.dto;



public class ParametrageRevisionDto {
	private Integer id;
	private Integer vidange;
	private Integer filtreAair;
	private Integer filtreAhuile;
	private Integer filtreAgasoil;
	private Integer bougiesAllumage;
	private Integer kitDistribution;
	private Integer kitDembrayage;
	private Integer suspensions;
	private Integer plaquettes;
	private Integer pneus;
	private Integer roulements;
	private Integer rotules;
	private Integer idVoiture;
	private String marque;
	private String modele;
	private String couleur;
	private String immatricule;
	
	public ParametrageRevisionDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVidange() {
		return vidange;
	}

	public void setVidange(Integer vidange) {
		this.vidange = vidange;
	}

	public Integer getFiltreAair() {
		return filtreAair;
	}

	public void setFiltreAair(Integer filtreAair) {
		this.filtreAair = filtreAair;
	}

	public Integer getFiltreAhuile() {
		return filtreAhuile;
	}

	public void setFiltreAhuile(Integer filtreAhuile) {
		this.filtreAhuile = filtreAhuile;
	}

	public Integer getFiltreAgasoil() {
		return filtreAgasoil;
	}

	public void setFiltreAgasoil(Integer filtreAgasoil) {
		this.filtreAgasoil = filtreAgasoil;
	}

	public Integer getBougiesAllumage() {
		return bougiesAllumage;
	}

	public void setBougiesAllumage(Integer bougiesAllumage) {
		this.bougiesAllumage = bougiesAllumage;
	}

	
	
	public Integer getKitDembrayage() {
		return kitDembrayage;
	}

	public void setKitDembrayage(Integer kitDembrayage) {
		this.kitDembrayage = kitDembrayage;
	}

	public Integer getSuspensions() {
		return suspensions;
	}

	public void setSuspensions(Integer suspensions) {
		this.suspensions = suspensions;
	}

	public Integer getPlaquettes() {
		return plaquettes;
	}

	public void setPlaquettes(Integer plaquettes) {
		this.plaquettes = plaquettes;
	}

	public Integer getPneus() {
		return pneus;
	}

	public void setPneus(Integer pneus) {
		this.pneus = pneus;
	}

	public Integer getRoulements() {
		return roulements;
	}

	public void setRoulements(Integer roulements) {
		this.roulements = roulements;
	}

	public Integer getRotules() {
		return rotules;
	}
	
	

	public Integer getKitDistribution() {
		return kitDistribution;
	}

	public void setKitDistribution(Integer kitDistribution) {
		this.kitDistribution = kitDistribution;
	}

	public void setRotules(Integer rotules) {
		this.rotules = rotules;
	}

	public Integer getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Integer idVoiture) {
		this.idVoiture = idVoiture;
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

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getImmatricule() {
		return immatricule;
	}

	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}

	@Override
	public String toString() {
		return "ParametrageRevisionDto [id=" + id + ", vidange=" + vidange + ", filtreAair=" + filtreAair
				+ ", filtreAhuile=" + filtreAhuile + ", filtreAgasoil=" + filtreAgasoil + ", bougiesAllumage="
				+ bougiesAllumage + ", kitDistribution=" + kitDistribution + ", kitDembrayage=" + kitDembrayage
				+ ", suspensions=" + suspensions + ", plaquettes=" + plaquettes + ", pneus=" + pneus + ", roulements="
				+ roulements + ", rotules=" + rotules + ", idVoiture=" + idVoiture + ", marque=" + marque + ", modele="
				+ modele + ", couleur=" + couleur + ", immatricule=" + immatricule + "]";
	}
	
	
	
	
	
}
