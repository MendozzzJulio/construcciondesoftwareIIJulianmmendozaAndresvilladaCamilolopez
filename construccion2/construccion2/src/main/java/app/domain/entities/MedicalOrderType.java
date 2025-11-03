package app.domain.entities;

import app.domain.entities.enums.MedicalItemType;

public class MedicalOrderType {
	
	private long id;
	private MedicalItemType item;
	private String description;
	private int itemNumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public MedicalItemType getItem() {
		return item;
	}
	public void setItem(MedicalItemType item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	

}
