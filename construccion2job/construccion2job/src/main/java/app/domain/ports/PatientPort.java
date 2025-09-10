package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {
	

	public Patient getPatientById(String patientId);

	
}


