package app.domain.models;

public class Pacient {
	private Long patientID;
	private Long idNumber;
	private String completeName;
	private String birthdate;
	private String gender;
	private String address;
	private Long phoneNumber;
	private String emailAdress;
	
	public Pacient(Long patientID,Long idNumber, String completeName, String birthdate, String gender, String address,
			Long phoneNumber, String emailAdress) {
		this.setPatientID(patientID);
		this.idNumber = idNumber;
		this.completeName = completeName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAdress = emailAdress;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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


	public Long getPatientID() {
		return patientID;
	}


	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}



}
