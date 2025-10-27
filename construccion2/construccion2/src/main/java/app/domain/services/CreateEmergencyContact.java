package app.domain.services;

import app.domain.ports.EmergencyContactPort;
import app.domain.entities.EmergencyContact;
import app.domain.entities.valueobjects.PhoneNumber;

public class CreateEmergencyContact {
	
	private EmergencyContactPort emergencyContactPort;
	

	public void createEmergencyContac(EmergencyContact emergencyContact) throws Exception {
		
		PhoneNumber phoneNumber = emergencyContact.getPhoneNumber();
		if (phoneNumber == null || phoneNumber.toString().length() != 10) {
			throw new Exception("El numero de telefono debe tener exactamente 10 digitos.");
			}	
		if(emergencyContact.getName() == null) {
			throw new Exception("El nombre del contacto de emergencia no puede estar vacio.");
		}
		
		if(emergencyContact.getLastName() == null) {
			throw new Exception("El Apellido del contacto de emergencia no puede estar vacio.");
		}
		
		emergencyContactPort.save(emergencyContact);
		
    }
	
	}





