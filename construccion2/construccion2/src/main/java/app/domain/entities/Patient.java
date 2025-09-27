package app.domain.entities;

import app.domain.valueobjects.EmergencyContact;
import app.domain.valueobjects.MedicalInsurance;

public class Patient extends Person {
	
	private EmergencyContact emergencyContact;
	private MedicalInsurance medicalInsurance;
	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public MedicalInsurance getMedicalInsurance() {
		return medicalInsurance;
	}
	public void setMedicalInsurance(MedicalInsurance medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}
	
	
	
}
