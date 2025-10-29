package app.domain.entities;

import app.domain.entities.enums.Gender;

public class Patient extends Person{

	
	private  Gender gender;
	private double weigth;
	private double height;
	private User doctor;
	private EmergencyContact emergencyContact;
	
	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getWeigth() {
		return weigth;
	}
	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double size) {
		this.height = size;
	}
	public User getDoctor() {
		return doctor;
	}
	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	
	

}
