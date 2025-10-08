package app.domain.services;

import app.domain.entities.Patient;
import app.domain.ports.PatientsPort;                        //seguImos el esquema CRUD (CREATE,READ,UPDATE,DELETE)


public class ReadPatient {
	private final PatientsPort patientsPort;
	
	public ReadPatient(PatientsPort patientsPort) {
		this.patientsPort = patientsPort;
	}
	 // buscar paciente por id
	  public Patient getPatient(Patient patient) throws Exception {
	        Patient found = patientsPort.findById(patient.getId());
	        if (found == null) {
	            throw new Exception("Patient not found");
	        }
	        return found;
	    }
}
