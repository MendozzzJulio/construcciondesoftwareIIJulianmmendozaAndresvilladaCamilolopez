package app.adapter.in.builder;

import app.adapter.in.validators.EmergencyContactValidator;
import app.domain.entities.EmergencyContact;

public class EmergencyContactBuilder {
	
	private EmergencyContactValidator emergencyContactValidator;

	public EmergencyContact build(String name, String lastName, String phoneNumber, String relationship) 
		throws Exception {
		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setName(emergencyContactValidator.nameValidator(name));
		emergencyContact.setLastName(emergencyContactValidator.lastNameValidator(lastName));
		emergencyContact.setPhoneNumber(emergencyContactValidator.phoneValidator(phoneNumber));
		emergencyContact.setRelationship(emergencyContactValidator.relationshipValidator(relationship));
		
		return emergencyContact;
	}
}
