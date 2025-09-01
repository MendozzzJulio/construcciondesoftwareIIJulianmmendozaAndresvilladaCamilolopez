package app.domain.model;

public class MedicalInsurance {
	
	private String insuranceCompanyName;
	private Long policyNumber;
	private boolean policyStatus;
	private String policyValidity;
	private String policyTermination;
	
	
	
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public Long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(Long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public boolean isPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(boolean policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	public String getPolicyValidity() {
		return policyValidity;
	}
	public void setPolicyValidity(String policyValidity) {
		this.policyValidity = policyValidity;
	}
	public String getPolicyTermination() {
		return policyTermination;
	}
	public void setPolicyTermination(String policyTermination) {
		this.policyTermination = policyTermination;
	}

}
