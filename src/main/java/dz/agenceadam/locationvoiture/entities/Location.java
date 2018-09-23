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
@Table(name="tb_location")
public class Location implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	
	@Column(name="actived")
	private boolean actived;
	
	@Column(name="total_ttc",scale=2)
	private BigDecimal totalTTC;
	@Column(name="total_ht",scale=2)
	private BigDecimal totalHT;
	@Column(name="prix_unitaire",scale=2)
	private BigDecimal prixUnitaire;
	@Column(name="nbr_jours",scale=2)
	private Integer nombreDeJours;
	@Column(name="remise",scale=2)
	private BigDecimal remise;
	@Column(name="versement",scale=2)
	private BigDecimal versement;
	@Column(name="reste_a_paye",scale=2)
	private BigDecimal resteApaye;
	@Column(name="statut")
	private String statut;
	@Column(name="caution")
	private String caution;
	@Column(name="montant",scale = 2)
	private BigDecimal montant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_RESERVATION")
	private Reservation reservation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_VOITURE")
	private Voiture voiture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CLIENT")
	private Client client;
	
	@Temporal(TemporalType.DATE)
	private Date dateConfirmationLocation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public Reservation getReservation() {
		return reservation;
	}

	@JsonSetter
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@JsonIgnore
	public Voiture getVoiture() {
		return voiture;
	}

	@JsonSetter
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	@JsonIgnore
	public Client getClient() {
		return client;
	}
	
	@JsonSetter
	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateConfirmationLocation() {
		return dateConfirmationLocation;
	}

	public void setDateConfirmationLocation(Date dateConfirmationLocation) {
		this.dateConfirmationLocation = dateConfirmationLocation;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public BigDecimal getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(BigDecimal totalTTC) {
		this.totalTTC = totalTTC;
	}

	public BigDecimal getTotalHT() {
		return totalHT;
	}

	public void setTotalHT(BigDecimal totalHT) {
		this.totalHT = totalHT;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getNombreDeJours() {
		return nombreDeJours;
	}

	public void setNombreDeJours(Integer nombreDeJours) {
		this.nombreDeJours = nombreDeJours;
	}

	public BigDecimal getRemise() {
		return remise;
	}

	public void setRemise(BigDecimal remise) {
		this.remise = remise;
	}

	public BigDecimal getVersement() {
		return versement;
	}

	public void setVersement(BigDecimal versement) {
		this.versement = versement;
	}

	public BigDecimal getResteApaye() {
		return resteApaye;
	}

	public void setResteApaye(BigDecimal resteApaye) {
		this.resteApaye = resteApaye;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", actived=" + actived + ", totalTTC=" + totalTTC + ", totalHT=" + totalHT
				+ ", prixUnitaire=" + prixUnitaire + ", nombreDeJours=" + nombreDeJours + ", remise=" + remise
				+ ", versement=" + versement + ", resteApaye=" + resteApaye + ", statut=" + statut + ", caution="
				+ caution + ", montant=" + montant + ", dateConfirmationLocation=" + dateConfirmationLocation + "]";
	}

	
	
	
	
}
