package app.application.usecases;

import app.domain.entities.Patient;
import app.domain.ports.PatientPort;

public class PatientRegisterUseCase {
	
	private final PatientPort patientsPort;
	
	public PatientRegisterUseCase(PatientPort patientsPort) {
		this.patientsPort = patientsPort;
	}
	
	public void execute(Patient patient) throws Exception {
		if (patientsPort.findById(patient.getId()) != null) {
			throw new Exception("Patient already exists.");
		}
		patientsPort.save(patient);
	}
}
