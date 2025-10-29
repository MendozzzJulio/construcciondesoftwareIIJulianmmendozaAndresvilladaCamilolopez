package app.domain.ports;

import java.util.List;

import app.domain.entities.Patient;

public interface PatientPort {

	// Me doy cuenta de que todos estos findby pueden ser solo uno y listo.
	/*
	 * por ejemplo hacemos findBy(Patient patient) y ya cuando los usemos obtenemos
	 * toda la info del paciente que luego filtraremos mediante los gettersss
	 */

	/*
	 * Busca un paciente por su identificador unico (id)
	 */
	public Patient findById(Patient patient) throws Exception;

	/*
	 * Busca un paciente por su nombre
	 */

	public Patient findByName(Patient patient) throws Exception;

	/*
	 * guarda un paciente en el sistema
	 */
	public void save(Patient patient) throws Exception;

	/*
	 * Busca al paciente por su numero de documento
	 */
	public Patient findByDocument(Patient patient) throws Exception;

	/*
	 * Actualiza la informacion de un paciente en el sistema
	 */
	public void updatePatient(Patient patient) throws Exception;

	public List<Patient> findByPatient(Patient patient);

	public Patient findByPhoneNumber(Patient patient);

}
