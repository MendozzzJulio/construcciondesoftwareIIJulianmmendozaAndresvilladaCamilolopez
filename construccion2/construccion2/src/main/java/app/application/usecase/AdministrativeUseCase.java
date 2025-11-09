package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.entities.Appointment;
import app.domain.entities.Billing;
import app.domain.entities.EmergencyContact;
import app.domain.entities.Patient;
import app.domain.services.CreateAppointment;
import app.domain.services.CreateBilling;
import app.domain.services.CreateEmergencyContact;
import app.domain.services.CreatePatient;
import app.domain.services.SearchPatient;
import app.domain.services.UpdatePatient;

/**
 * Caso de uso para el rol Administrative (Personal Administrativo)
 * Funcionalidades: gestión de pacientes, citas, facturas y contactos de emergencia
 */
@Component
public class AdministrativeUseCase {
	
	@Autowired
	private CreatePatient createPatient;
	@Autowired
	private UpdatePatient updatePatient;
	@Autowired
	private SearchPatient searchPatient;
	@Autowired
	private CreateAppointment createAppointment;
	@Autowired
	private CreateBilling createBilling;
	@Autowired
	private CreateEmergencyContact createEmergencyContact;
	
	/**
	 * Crear un nuevo paciente en el sistema
	 * El personal administrativo puede registrar pacientes con su información básica
	 */
	public void createPatient(Patient patient) throws Exception {
		createPatient.create(patient);
	}
	
	/**
	 * Actualizar información de un paciente existente
	 * Permite modificar datos de contacto, dirección, etc.
	 */
	public void updatePatient(Patient patient) throws Exception {
		updatePatient.update(patient);
	}
	
	/**
	 * Buscar paciente en el sistema
	 * Permite localizar pacientes para gestión administrativa
	 */
	public Patient searchPatient(Patient patient) throws Exception {
		return (Patient) searchPatient.search(patient);
	}
	
	/**
	 * Programar una nueva cita médica
	 * Valida disponibilidad de doctor y paciente
	 */
	public void createAppointment(Appointment appointment) throws Exception {
		createAppointment.create(appointment);
	}
	
	/**
	 * Crear factura para servicios médicos
	 * Incluye información de seguros médicos y copagos
	 */
	public void createBilling(Billing billing) throws Exception {
		createBilling.create(billing);
	}
	
	/**
	 * Registrar contacto de emergencia para un paciente
	 * Información importante para casos de emergencia
	 */
	public void createEmergencyContact(EmergencyContact emergencyContact) throws Exception {
		createEmergencyContact.create(emergencyContact);
	}
}
