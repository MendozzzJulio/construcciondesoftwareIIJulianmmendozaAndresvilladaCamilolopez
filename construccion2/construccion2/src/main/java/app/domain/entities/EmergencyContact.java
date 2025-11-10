package app.domain.entities;


//accedemos por medio de herencia a los atributos de la clase persona

public class EmergencyContact extends Person {
	private String relationship;

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
}
