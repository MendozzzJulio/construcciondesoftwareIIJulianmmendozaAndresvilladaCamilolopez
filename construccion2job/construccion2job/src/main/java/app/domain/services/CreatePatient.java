package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;	

public class CreatePatient {
	
	private PatientPort patientPort;

	public void create(Patient patient) throws Exception {
		
		if (patientPort == null) {
			throw new Exception("El paciente no puede ser nulo");
		}
	
	    patientPort.save(patient);}
		
	}
