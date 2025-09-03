package app.domain.model;

public class Patient {
	private Long patientID;
	private Long idNumber;
	private String completeName;
	private String birthDate;
	private String gender;
	private String address;
	private Long phoneNumber;
	private String emailAdress;
	
	
	public Long getPatientID() {
		return patientID;
	}
	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}
	public Long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	
	
	
	


}
