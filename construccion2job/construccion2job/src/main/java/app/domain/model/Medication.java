package app.domain.model;

public class Medication {
	
	private MedicalOrder medicalOrder;
	private long medicineID;
	private float dose;
	private Item itemId;
	
	
	public MedicalOrder getMedicalOrder() {
		return medicalOrder;
	}
	public void setMedicalOrder(MedicalOrder medicalOrder) {
		this.medicalOrder = medicalOrder;
	}
	public long getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(long medicineID) {
		this.medicineID = medicineID;
	}
	public float getDose() {
		return dose;
	}
	public void setDose(float dose) {
		this.dose = dose;
	}
	public Item getItemId() {
		return itemId;
	}
	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}
	

	
	
	

	
	
	
	

}
