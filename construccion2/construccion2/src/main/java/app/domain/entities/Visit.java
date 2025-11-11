package app.domain.entities;

import java.sql.Date;

// Entidad que va representar una visita médica, que puede incluir múltiples procedimientos médicos realizados durante la visita.

public class Visit {
	
	 private Patient patient;
	 private  User doctor;
	 private  String notes;
	 private Date date;
	 private String reason;
	 private Medicine medicine;
	

	

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
	 public User getDoctor() {
		return doctor;
	 }
	 public void setDoctor(User doctor) {
		this.doctor = doctor;
	 }
	 public String getNotes() {
		return notes;
	 }
	 public void setNotes(String notes) {
		this.notes = notes;
	 }
	
	 }
	 
	 

