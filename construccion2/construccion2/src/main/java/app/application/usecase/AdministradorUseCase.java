package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Billing;
import app.domain.entities.EmergencyContact;
import app.domain.entities.Appointment;
import app.domain.entities.Patient;
import app.domain.ports.Adminport;
import app.domain.services.CreateBilling;
import app.domain.services.CreateEmergencyContact;
import app.domain.services.CreatePatient;
import app.domain.services.CreateAppointment;


@Service
public class AdministradorUseCase {
	// Servicios necesarios
	@Autowired
	private Adminport adminport;
	
	// Método para crear el enfermo 
	public void createPatient(Patient patient) throws Exception {
		createPatient.createPatient(patient);
	}
	// Método para actualizar el  enfermo 
	public void updatePatient(Patient patient) throws Exception {	
		createPatient.updatePatient(patient);		
	}
	// Método para crear la cita y que tales 
	public void createAppointment(Appointment appointment) throws Exception {	
		createAppointment.createAppointment(appointment);		
	}
	// Método para crear la factura pa que paguen esos parceros 
	public void createBilling(Billing billing) throws Exception {	
		createBilling.createBilling(billing);		
	}
	// Método para crear el contacto de emergencia
	public void createEmergencyContact(EmergencyContact emergencyContact) throws Exception {	
		createEmergencyContact.createEmergencyContac(emergencyContact);	
		//los nombres despues del punto deben de coincidir con los nombres de los metodos en los servicios
	}
	

}
