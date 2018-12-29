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
@Table(name="tb_assurance")
public class Assurance implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	
	@Column(name="TYPE_ASSURANCE")
	private String typeAssurance;
	
	@Column(scale = 2,name="PRIX_ACHAT")
	private BigDecimal prixAchat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_VOITURE")
	private Voiture voiture;
	
	public Assurance() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public BigDecimal getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(BigDecimal prixAchat) {
		this.prixAchat = prixAchat;
	}
	
	
    @JsonIgnore
	public Voiture getVoiture() {
		return voiture;
	}

    @JsonSetter
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
    
    

	public String getTypeAssurance() {
		return typeAssurance;
	}

	public void setTypeAssurance(String typeAssurance) {
		this.typeAssurance = typeAssurance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateExpiration == null) ? 0 : dateExpiration.hashCode());
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assurance other = (Assurance) obj;
		if (dateExpiration == null) {
			if (other.dateExpiration != null)
				return false;
		} else if (!dateExpiration.equals(other.dateExpiration))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assurance [id=" + id + ", dateExpiration=" + dateExpiration + ", prixAchat=" + prixAchat + "]";
	}
    
	

	
	
	
	
}
