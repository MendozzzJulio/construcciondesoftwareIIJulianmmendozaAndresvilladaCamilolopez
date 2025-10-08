package app.domain.services;

import app.domain.entities.Patient;
import app.domain.ports.PatientsPort;

public class UpdatePatient {
	
	private final PatientsPort patientsPort;
	
	public UpdatePatient(PatientsPort patientsPort) {
		this.patientsPort = patientsPort;
	}
	
	// actualizar info del (enfermito) paciente 
    public void updatePatient(Patient patient) throws Exception {
        Patient existing = patientsPort.findById(patient.getId());
        if (existing == null) {
            throw new Exception("Cannot update: patient does not exist");
        }
        patientsPort.save(patient);
    }

}
