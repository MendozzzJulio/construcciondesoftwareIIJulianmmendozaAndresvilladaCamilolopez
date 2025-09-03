package app.domain.model;

public class Medication {
	
	private int orderNumber;
	private Long idOfTheMedicine;
	private float dose;
	private int item;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getIdOfTheMedicine() {
		return idOfTheMedicine;
	}
	public void setIdOfTheMedicine(Long idOfTheMedicine) {
		this.idOfTheMedicine = idOfTheMedicine;
	}
	public float getDose() {
		return dose;
	}
	public void setDose(float dose) {
		this.dose = dose;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	
	

}
