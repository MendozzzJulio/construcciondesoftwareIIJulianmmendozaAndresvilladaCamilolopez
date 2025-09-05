package app.domain.model;

import java.util.List;

public class MedicalOrder {
	

		private int orderNumber;
	    private String patientIdCard;
	    private String doctorIdCard;
	    private String creationDate;
	    private String typeOrder;
	    private boolean active;
	    private List<Item> items; // Relación uno a muchos
	    
	    
	    
	    
		public int getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(int orderNumber) {
			this.orderNumber = orderNumber;
		}
		public String getPatientIdCard() {
			return patientIdCard;
		}
		public void setPatientIdCard(String patientIdCard) {
			this.patientIdCard = patientIdCard;
		}
		public String getDoctorIdCard() {
			return doctorIdCard;
		}
		public void setDoctorIdCard(String doctorIdCard) {
			this.doctorIdCard = doctorIdCard;
		}
		public String getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(String creationDate) {
			this.creationDate = creationDate;
		}
		public String getTypeOrder() {
			return typeOrder;
		}
		public void setTypeOrder(String typeOrder) {
			this.typeOrder = typeOrder;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public List<Item> getItems() {
			return items;
		}
		public void setItems(List<Item> items) {
			this.items = items;
		}

	

}
