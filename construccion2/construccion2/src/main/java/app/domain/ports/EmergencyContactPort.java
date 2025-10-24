package app.domain.ports;

import app.domain.entities.EmergencyContact;
import app.domain.entities.Person;

public interface EmergencyContactPort {
	
	public void save (EmergencyContact emergencyContact) throws Exception;
	public EmergencyContact findByPhoneNumber(Person person) throws Exception;

}
