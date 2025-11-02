package app.domain.entities;

import java.sql.Date;
import java.util.List;



public class MedicalOrder {
	
	private long id;
	private Patient patient;
	private User doctor;
	private Date date;
	private List<MedicalOrderType> items;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public User getDoctor() {
		return doctor;
	}
	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<MedicalOrderType> getItems() {
		return items;
	}
	public void setItems(List<MedicalOrderType> items) {
		this.items = items;
	} 
	
	
	
	

}
