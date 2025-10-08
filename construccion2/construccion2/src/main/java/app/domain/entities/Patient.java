package app.domain.entities;

import app.domain.entities.valueobjects.EmergencyContact;
import app.domain.entities.valueobjects.MedicalInsurance;

public class Patient extends Person {
	
	private long id; // Identificador unico para cada paciente que es diferente a la cedula
	
	  //aca estan los atributos que se extraen de person 
	
	private EmergencyContact emergencyContact; //MAXIMO 1 
	private MedicalInsurance medicalInsurance; //MAXIMO 1
	
	
	public Patient() {}
	
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
