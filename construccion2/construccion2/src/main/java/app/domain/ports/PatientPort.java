package app.domain.ports;

import java.util.List;

import app.domain.entities.Patient;




public interface PatientPort {
	
	
	
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


	public Patient findByDocument(Patient patient);

	/*
	 * Actualiza la informacion de un paciente en el sistema
	 */
	public void updatePatient(Patient patient);


	public List<Patient> findByPatient(Patient patient);



	

	



}
