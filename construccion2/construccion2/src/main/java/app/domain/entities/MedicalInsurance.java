package app.domain.entities;

import java.sql.Date;

/**lo hace camilinPimguin
 * 
 * Entidad que representa el seguro medico
 */


public class MedicalInsurance {
	
	private String companyName; //nombre de la compañia de seguro
	private long policyNumber;  // numero de la poliza
	private boolean policyStatus; // estado de la poliza (activa o inactiva)
	private Date policyValidity; //dias de vigencia de la poliza.
	private Date policyEndDate; //fecha de finalizacion de la poliza
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public boolean isPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(boolean policyStatus) {
		this.policyStatus = policyStatus;
	}
	public Date getPolicyValidity() {
		return policyValidity;
	}
	public void setPolicyValidity(Date policyValidity) {
		this.policyValidity = policyValidity;
	}
	public Date getPolicyEndDate() {
		return policyEndDate;
	}
	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}
	

}
