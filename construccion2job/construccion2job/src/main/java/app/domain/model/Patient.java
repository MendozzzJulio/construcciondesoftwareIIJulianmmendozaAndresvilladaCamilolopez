package app.domain.model;

public class Patient {
	
	private Long patientIdCard;
	private String completeName;
	private String birthDate;
	private String gender;
	private String address;
	private Long phoneNumber;
	private String emailAdress;
	
	

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

	public Long getPatientIdCard() {
		return patientIdCard;
	}

	public void setPatientIdCard(Long patientIdCard) {
		this.patientIdCard = patientIdCard;
	}
	public MedicalInsurance getMedicalInsurance() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	


}
