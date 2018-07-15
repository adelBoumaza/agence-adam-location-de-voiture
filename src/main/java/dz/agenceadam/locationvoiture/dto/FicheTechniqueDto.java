package dz.agenceadam.locationvoiture.dto;

import java.math.BigDecimal;


public class FicheTechniqueDto {

	private Integer id;
	private Boolean actived;
	private Integer kmRevision;
	private BigDecimal prixIntervention;
	private String typeRevision;
	private String dateIntervention;
	private Integer idVoiture;
	
	public FicheTechniqueDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public Integer getKmRevision() {
		return kmRevision;
	}

	public void setKmRevision(Integer kmRevision) {
		this.kmRevision = kmRevision;
	}

	public BigDecimal getPrixIntervention() {
		return prixIntervention;
	}

	public void setPrixIntervention(BigDecimal prixIntervention) {
		this.prixIntervention = prixIntervention;
	}

	public String getTypeRevision() {
		return typeRevision;
	}

	public void setTypeRevision(String typeRevision) {
		this.typeRevision = typeRevision;
	}

	public Integer getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Integer idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getDateIntervention() {
		return dateIntervention;
	}

	public void setDateIntervention(String dateIntervention) {
		this.dateIntervention = dateIntervention;
	}
	
	
	
}
