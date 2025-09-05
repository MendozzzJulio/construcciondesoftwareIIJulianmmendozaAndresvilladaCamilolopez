package app.domain.model;

public class Medication {
	
	private String medicineName;
	private long medicineID;
	private float medicineCost;
	private int dose;
	private long item;
	
	// Como que duracion del tratamiento?
	
	
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public long getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(long medicineID) {
		this.medicineID = medicineID;
	}
	public float getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(float medicineCost) {
		this.medicineCost = medicineCost;
	}
	public int getDose() {
		return dose;
	}
	public void setDose(int dose) {
		this.dose = dose;
	}
	public long getItem() {
		return item;
	}
	public void setItem(long item) {
		this.item = item;
	}
	

	
	
	
	

}
