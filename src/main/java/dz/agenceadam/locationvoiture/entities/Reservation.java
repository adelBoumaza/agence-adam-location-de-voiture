package dz.agenceadam.locationvoiture.entities;

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
@Table(name="tb_reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id")
	private Integer id;
	private Boolean nouveauClient;
	@Column(name="actived")
	private Boolean actived;
	@Temporal(TemporalType.DATE)
	@Column(name="date_de_depart")
	private Date dateDeDepart;
	@Temporal(TemporalType.DATE)
	@Column(name="date_de_retour")
	private Date dateDeRetour;
	@Column(name="heure_de_depart")
	private String heureDepart;
	@Column(name="heure_de_retour")
	private String heureRetour;
	@Column(name = "nombre_de_jours",scale = 2)
	private BigDecimal nombreDeJours;
	@Column(name="total_TTC",scale = 2)
	private BigDecimal totalTTC;
	@Column(name="versement",scale = 2)
	private BigDecimal versement;
	@Column(name="reservation_en_attente")
	private Boolean reservationEnAttente;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_client_reservation")
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_voiture_reservation")
	private Voiture voiture;
	
	public Reservation() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getNouveauClient() {
		return nouveauClient;
	}

	public void setNouveauClient(Boolean nouveauClient) {
		this.nouveauClient = nouveauClient;
	}

	public Date getDateDeDepart() {
		return dateDeDepart;
	}

	public void setDateDeDepart(Date dateDeDepart) {
		this.dateDeDepart = dateDeDepart;
	}

	public Date getDateDeRetour() {
		return dateDeRetour;
	}

	public void setDateDeRetour(Date dateDeRetour) {
		this.dateDeRetour = dateDeRetour;
	}
	
	

	public BigDecimal getNombreDeJours() {
		return nombreDeJours;
	}

	public void setNombreDeJours(BigDecimal nombreDeJours) {
		this.nombreDeJours = nombreDeJours;
	}

	public BigDecimal getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(BigDecimal totalTTC) {
		this.totalTTC = totalTTC;
	}

	public Boolean getReservationEnAttente() {
		return reservationEnAttente;
	}

	public void setReservationEnAttente(Boolean reservationEnAttente) {
		this.reservationEnAttente = reservationEnAttente;
	}
	
	

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public BigDecimal getVersement() {
		return versement;
	}

	public void setVersement(BigDecimal versement) {
		this.versement = versement;
	}
	
	

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getHeureRetour() {
		return heureRetour;
	}

	public void setHeureRetour(String heureRetour) {
		this.heureRetour = heureRetour;
	}

	@JsonIgnore
	public Client getClient() {
		return client;
	}
	
	@JsonSetter
	public void setClient(Client client) {
		this.client = client;
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
		return "Reservation [id=" + id + ", nouveauClient=" + nouveauClient + ", dateDeDepart=" + dateDeDepart
				+ ", dateDeRetour=" + dateDeRetour + ", nombreDeJours=" + nombreDeJours + ", totalTTC=" + totalTTC
				+ ", reservationEnAttente=" + reservationEnAttente + "]";
	}

	
	
	
}
