package app.domain.entities;

// Entidad que va representar una visita médica, que puede incluir múltiples procedimientos médicos realizados durante la visita.

public class Visit {
	
	 private Patient patient;

	 private Medicine medicine;

	

	 public Patient getPatient() {
		return patient;
	 }
	 public void setPatient(Patient patient) {
		this.patient = patient;
	 }
	 public Medicine getMedicine() {
		return medicine;
	 }
	 public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	 }
	
	 }
	 
	 

