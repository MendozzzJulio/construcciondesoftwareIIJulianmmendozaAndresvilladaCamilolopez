package app.domain.model;

public class Invoice {
	private MedicalOrder orderNumber;
	private long invoiceID;
	private Patient patient;
	private User doctor;
	private MedicalInsurance medicalInsurance;
	private boolean medicine;
	
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
	public MedicalInsurance getMedicalInsurance() {
		return medicalInsurance;
	}
	public void setMedicalInsurance(MedicalInsurance medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}
	public MedicalOrder getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(MedicalOrder orderNumber) {
		this.orderNumber = orderNumber;
	}
	public boolean isMedicine() {
		return medicine;
	}
	public void setMedicine(boolean medicine) {
		this.medicine = medicine;
	}
	

	

	
	

}
