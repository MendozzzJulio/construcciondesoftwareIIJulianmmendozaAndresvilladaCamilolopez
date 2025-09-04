package app.domain.model;

public class ProceduresOrder {
	private int orderNumber;
	private String procedureID;
	private int quantity;
	private String frequency;
	private boolean requiresEspecialist;
	private String idTypeEspecialist;
	private int itemID;
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProcedureID() {
		return procedureID;
	}
	public void setProcedureID(String procedureID) {
		this.procedureID = procedureID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public boolean isRequiresEspecialist() {
		return requiresEspecialist;
	}
	public void setRequiresEspecialist(boolean requiresEspecialist) {
		this.requiresEspecialist = requiresEspecialist;
	}
	public String getIdTypeEspecialist() {
		return idTypeEspecialist;
	}
	public void setIdTypeEspecialist(String idTypeEspecialist) {
		this.idTypeEspecialist = idTypeEspecialist;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
 
}
