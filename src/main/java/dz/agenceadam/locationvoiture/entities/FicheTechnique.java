package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@Table(name = "TB_FICHE_TECHNIQUE")
public class FicheTechnique implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	private Boolean actived;
	private Integer kmRevision;
	private BigDecimal prixIntervention;
	private String typeRevision;
	@Temporal(TemporalType.DATE)
	private Date dateIntervention;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_VOITURE")
	private Voiture voiture;
	
	public FicheTechnique() {
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
	
	

	public Date getDateIntervention() {
		return dateIntervention;
	}

	public void setDateIntervention(Date dateIntervention) {
		this.dateIntervention = dateIntervention;
	}

	@JsonIgnore
	public Voiture getVoiture() {
		return voiture;
	}

	@JsonSetter
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	@Override
	public String toString() {
		return "FicheTechnique [id=" + id + ", actived=" + actived + ", kmRevision=" + kmRevision
				+ ", prixIntervention=" + prixIntervention + ", typeRevision=" + typeRevision + "]";
	}
	
	
}
