package app.application.usecases;

import app.domain.entities.Patient;
import app.domain.ports.PatientsPort;

public class PatientRegisterUseCase {
	
	private final PatientsPort patientsPort;
	
	public PatientRegisterUseCase(PatientsPort patientsPort) {
		this.patientsPort = patientsPort;
	}
	
	public void execute(Patient patient) throws Exception {
		if (patientsPort.findById(patient.getId()) != null) {
			throw new Exception("Patient already exists.");
		}
		patientsPort.save(patient);
	}
}
