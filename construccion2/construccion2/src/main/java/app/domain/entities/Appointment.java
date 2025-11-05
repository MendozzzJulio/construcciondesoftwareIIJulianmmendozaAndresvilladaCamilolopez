package app.domain.entities;

import java.sql.Date;


public class Appointment {
	
	private long id;
	private User Doctor;
	private Patient patient;
	private Date date;
	private String reason;
	
	
	public Long getId() {
		return id;
	}
	public void setAppointmentId(Long appointmentId) {
		this.id = appointmentId;
	}
	public User getDoctor() {
		return Doctor;
	}
	public void setDoctor(User doctor) {
		Doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
