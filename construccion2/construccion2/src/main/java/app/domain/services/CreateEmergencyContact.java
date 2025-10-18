package app.domain.services;

import app.domain.ports.EmergencyContactPort;
import app.domain.entities.EmergencyContact;

public class CreateEmergencyContact {
	
	private EmergencyContactPort emergencyContactPort;
	

	public void createEmergencyContac(EmergencyContact emergencyContact) throws Exception {
		
		/**
		 * me toco crear el get de PhoneNUmber en la entidad decemergencyContact por que si no sale un error
		 * pero si tenemos el atributo de person ahi deberia de traer el numero de telefono o que?
		 * 
		 * R// 
		 */
		if (emergencyContact.getPhoneNumber() == null ||emergencyContact.getPhoneNumber().length()> 10) {
			throw new Exception("Phone number is required");
		}
			if (emergencyContact.getName() == null) {
				throw new Exception("El nombre del contacto de emergencia no puede estar vacío.");	
		}
	
	    emergencyContactPort.save(emergencyContact);
    }


}


