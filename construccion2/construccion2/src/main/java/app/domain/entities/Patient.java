package app.domain.entities;

import app.domain.valueobjects.EmergencyContact;
import app.domain.valueobjects.MedicalInsurance;

public class Patient extends Person {
	
	private long id; // Identificador unico para cada paciente 
	private EmergencyContact emergencyContact;
	private MedicalInsurance medicalInsurance;
	
	
	
	
	
	
	
	public Patient(long l23L, String Carlos, String Sura, String pipi) {
		// TODO Auto-generated constructor stub
	}
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
