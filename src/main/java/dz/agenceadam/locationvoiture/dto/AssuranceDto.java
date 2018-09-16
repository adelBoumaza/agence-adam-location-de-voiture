package dz.agenceadam.locationvoiture.dto;

import java.math.BigDecimal;
import java.util.Date;


public class AssuranceDto {

	private String dateExpiration;

	private BigDecimal prixAchat;
	
	private String typeAssurance;
	
	private boolean expiration;
	
	public AssuranceDto() {

	}


	public String getDateExpiration() {
		return dateExpiration;
	}


	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}


	public BigDecimal getPrixAchat() {
		return prixAchat;
	}


	public void setPrixAchat(BigDecimal prixAchat) {
		this.prixAchat = prixAchat;
	}
	

	public String getTypeAssurance() {
		return typeAssurance;
	}


	public void setTypeAssurance(String typeAssurance) {
		this.typeAssurance = typeAssurance;
	}
	
	


	public boolean isExpiration() {
		return expiration;
	}


	public void setExpiration(boolean expiration) {
		this.expiration = expiration;
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
		AssuranceDto other = (AssuranceDto) obj;
		if (dateExpiration == null) {
			if (other.dateExpiration != null)
				return false;
		} else if (!dateExpiration.equals(other.dateExpiration))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AssuranceDto [dateExpiration=" + dateExpiration + ", prixAchat=" + prixAchat + ", typeAssurance="
				+ typeAssurance + "]";
	}
	
	
	
	
	
}
