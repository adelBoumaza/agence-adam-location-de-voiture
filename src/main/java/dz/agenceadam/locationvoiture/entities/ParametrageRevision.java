package dz.agenceadam.locationvoiture.entities;

import java.io.Serializable;

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
@Table(name="tb_parametrage_revision")
public class ParametrageRevision implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID")
	private Integer id;
	
	private Integer vidange;
	private Integer filtreAair;
	private Integer filtreAhuile;
	private Integer filtreAgasoil;
	private Integer bougiesAllumage;
	private Integer KitDistribution;
	private Integer kitDembrayage;
	private Integer suspensions;
	private Integer plaquettes;
	private Integer pneus;
	private Integer roulements;
	private Integer rotules;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_VOITURE")
	private Voiture voiture;

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

	public Integer getKitDistribution() {
		return KitDistribution;
	}

	public void setKitDistribution(Integer kitDistribution) {
		KitDistribution = kitDistribution;
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

	public void setRotules(Integer rotules) {
		this.rotules = rotules;
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
		return "ParametrageRevision [id=" + id + ", vidange=" + vidange + ", filtreAair=" + filtreAair
				+ ", filtreAhuile=" + filtreAhuile + ", filtreAgasoil=" + filtreAgasoil + ", bougiesAllumage="
				+ bougiesAllumage + ", KitDistribution=" + KitDistribution + ", kitDembrayage=" + kitDembrayage
				+ ", suspensions=" + suspensions + ", plaquettes=" + plaquettes + ", pneus=" + pneus + ", roulements="
				+ roulements + ", rotules=" + rotules + "]";
	}
	
	
	
}
