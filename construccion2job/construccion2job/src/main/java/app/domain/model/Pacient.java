package app.domain.model;

public class Pacient extends Person{
	private String insuranceCompanyName;
	private String policyNumber;
	private boolean policyStatus;
	private String policyValidity;
	private String gender;
	
	
	
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
