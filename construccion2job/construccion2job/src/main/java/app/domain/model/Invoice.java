package app.domain.model;

public class Invoice {
	private long invoiceID;
	private User pacient;
	private User doctor;
	private MedicalInsurance insuranceCompanyName;
	private MedicalInsurance policyNumber;
	private MedicalInsurance policyValidity;
	

	

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public MedicalInsurance getInsuranceCompanyName() {
		return insuranceCompanyName;
	}

	public void setInsuranceCompanyName(MedicalInsurance insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public MedicalInsurance getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(MedicalInsurance policyNumber) {
		this.policyNumber = policyNumber;
	}

	

	public long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public User getPacient() {
		return pacient;
	}

	public void setPacient(User pacient) {
		this.pacient = pacient;
	}

	public MedicalInsurance getPolicyValidity() {
		return policyValidity;
	}

	public void setPolicyValidity(MedicalInsurance policyValidity) {
		this.policyValidity = policyValidity;
	}
	
	
	
	

}
