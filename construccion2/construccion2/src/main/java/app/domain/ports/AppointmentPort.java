package app.domain.ports;

import app.domain.entities.Appointment;
import java.util.List;

/**
 * Puerto de (interfaz) que definira las operaciones necesarias  para trabajar con citas medicas en el sistema.
 * Actua como una abstraccion entre la capa de dominio y las implementaciones concretas (por ejemplo, una base de datos o almacenamiento en memoria).
 */

public interface AppointmentPort {
	/**
	 * Guarda una nueva cita medica en el sistema.
	 */
	public void save(Appointment appointment) throws Exception;

	/**
	 * Busca una cita medica por su identificador unico.
	 */
	public Appointment findById(int appointmentId) throws Exception;

	/**
	 * Obtendremos todas las citas que estan asociadas a un paciente en especifico.
	 */
	List<Appointment> findByPatient(String patientId) throws Exception;
	/**
	 * Obtendremos todas las citas que estan asociadas a un doctor en especifico.
	 */
	List<Appointment> findByDoctor(String doctorId) throws Exception;
	

}
