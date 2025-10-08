package app.domain.ports;

import app.domain.entities.Patient;



public interface PatientPort {
	
    public void save(Patient patient) throws Exception;
	/*
	 * guarda un paciente en el sistema 
	 */
	
	public Patient findById(long id) throws Exception;
	/*
	 * Busca un paciente por su identificador unico (id)
	 */

	



}
