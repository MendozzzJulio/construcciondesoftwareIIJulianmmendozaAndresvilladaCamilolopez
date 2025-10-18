package app.domain.entities;

//* Clase de medicamentos recetados por un doctor a un paciente


public class Medicine {
	
	private User Doctor;
	private Long numberOrder;
	private Long id;
	private int item;
	private float dosage;
	private String durationTreatment;
	
	
	
	public Long getNumberOrder() {
		return numberOrder;
	}
	public void setNumberOrder(Long numberOrder) {
		this.numberOrder = numberOrder;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getDosage() {
		return dosage;
	}
	public void setDosage(float dosage) {
		this.dosage = dosage;
	}
	public String getDurationTreatment() {
		return durationTreatment;
	}
	public void setDurationTreatment(String durationTreatment) {
		this.durationTreatment = durationTreatment;
	}
	public User getDoctor() {
		return Doctor;
	}
	public void setDoctor(User doctor) {
		Doctor = doctor;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}

	

}
