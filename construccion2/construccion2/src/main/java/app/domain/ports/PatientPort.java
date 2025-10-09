package app.domain.ports;

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
	

	



}
