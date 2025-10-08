package app.domain.entities;

public class Medicine {
	
	private Long numberOrder;
	private Long id;
	private float dosage;
	private String durationTreatment;
	/*item pero no sabemos como va */
	
	
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

	

}
