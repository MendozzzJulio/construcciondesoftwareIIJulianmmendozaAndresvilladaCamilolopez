package app.domain.model;

public class Invoice {
	private long invoiceID;
	private Patient patient;
	private User doctor;
	private MedicalInsurance insuranceCompanyName;
	private MedicalInsurance policyNumber;
	private MedicalInsurance policyValidity;
	
	public long getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
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
	public MedicalInsurance getPolicyValidity() {
		return policyValidity;
	}
	public void setPolicyValidity(MedicalInsurance policyValidity) {
		this.policyValidity = policyValidity;
	}
	public void setMedicalOrder(MedicalOrder medicalOrder) {
		// TODO Auto-generated method stub
		
	}
	public boolean isMedicine() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getMedicalOrderId() {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	
	

}
