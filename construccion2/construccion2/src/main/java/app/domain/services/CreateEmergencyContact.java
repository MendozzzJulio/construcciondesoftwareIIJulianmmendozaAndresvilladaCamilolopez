package app.domain.services;

import app.domain.ports.EmergencyContactPort;
import app.domain.entities.EmergencyContact;

public class CreateEmergencyContact {
	
	private EmergencyContactPort emergencyContactPort;
	

	public void create(EmergencyContact emergencyContact) throws Exception {
		
		/**
		 * me toco crear el get de PhoneNUmber en la entidad decemergencyContact por que si no sale un error
		 * pero si tenemos el atributo de person ahi deberia de traer el numero de telefono o que?
		 * 
		 * R// 
		 */
		if (emergencyContact.getPhoneNumber() == null ||emergencyContact.getPhoneNumber().length()> 10) {
			throw new Exception("Phone number is required");
		}

		emergencyContactPort.save(emergencyContact);

	}

}
