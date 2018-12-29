package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="tb_dette")
public class Dette implements Serializable{

	@Column(name="PK_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	@Column(name="actived")
	private boolean actived;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="total_ttc")
	private BigDecimal totalTTC;
	@Column(name="versement")
	private BigDecimal versement;
	@Column(name="reste_a_payer")
	private BigDecimal resteApayer;
	@Column(name="statut")
	private String statut;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_location")
	private Location location;
	
	public Dette() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
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

	public BigDecimal getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(BigDecimal totalTTC) {
		this.totalTTC = totalTTC;
	}

	public BigDecimal getVersement() {
		return versement;
	}

	public void setVersement(BigDecimal versement) {
		this.versement = versement;
	}

	public BigDecimal getResteApayer() {
		return resteApayer;
	}

	public void setResteApayer(BigDecimal resteApayer) {
		this.resteApayer = resteApayer;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@JsonIgnore
	public Location getLocation() {
		return location;
	}

	@JsonSetter
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Dette [id=" + id + ", actived=" + actived + ", nom=" + nom + ", prenom=" + prenom + ", totalTTC="
				+ totalTTC + ", versement=" + versement + ", resteApayer=" + resteApayer + ", statut=" + statut + "]";
	}
	
	
	
	
	
	
}
