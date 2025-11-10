package app.domain.entities;

import java.sql.Date;

public class MedicalRecord {
	
	private User doctor;
	
	private String symptomatology;
	private double bloodPressure;
	private double temperature;
	private int pulse;
	private int oxygenLevel;
	private Date date;
	private Patient patient;
	
	
	public User getDoctor() {
		return doctor;
	}
	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public String getSymptomatology() {
		return symptomatology;
	}
	public void setSymptomatology(String symptomatology) {
		this.symptomatology = symptomatology;
	}
	
	public Date getDate() {
		return date;
	}

	public double getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public int getOxygenLevel() {
		return oxygenLevel;
	}
	public void setOxygenLevel(int oxygenLevel) {
		this.oxygenLevel = oxygenLevel;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	

}
