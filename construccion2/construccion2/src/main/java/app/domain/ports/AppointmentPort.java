package app.domain.ports;

import app.domain.entities.Appointment;
import app.domain.entities.Patient;
import app.domain.entities.User;

import java.sql.Date;


/**
 * Puerto de (interfaz) que definira las operaciones necesarias  para trabajar con citas medicas en el sistema.
 * Actua como una abstraccion entre la capa de dominio y las implementaciones concretas (por ejemplo, una base de datos o almacenamiento en memoria).
 */

public interface AppointmentPort {
	/**
	 * Guarda una nueva cita medica en el sistema.
	 */
	public void save(Appointment appointment) throws Exception;

	public AppointmentPort findById(Appointment appointment) throws Exception;
	public boolean isDoctorAvailable(User doctor, Date date) throws Exception;
	public boolean isPatientAvailable(Patient patient, Date date) throws Exception;
}
