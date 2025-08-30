package app.domain.models;

public class MedicationOrden {
	private Long orderNumber;
	private Long patientID;
	private Long doctorID;
	private String date;
	
	
	public MedicationOrden(Long orderNumber, Long patientID, Long doctorID, String date) {
		super();
		this.orderNumber = orderNumber;
		this.patientID = patientID;
		this.doctorID = doctorID;
		this.date = date;
	}
	
	public Long getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getPatientID() {
		return patientID;
	}
	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}
	public Long getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(Long doctorID) {
		this.doctorID = doctorID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
