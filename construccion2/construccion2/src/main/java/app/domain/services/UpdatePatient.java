package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.ports.PatientPort;


@Service
public class UpdatePatient {
	

	@Autowired
	private PatientPort patientPort;
	
	
	// actualizar info del (enfermito) paciente 
    public void updatePatient(Patient patient) throws Exception {
        Patient existing = patientPort.findById(patient);
        if (existing == null) {
            throw new Exception("Cannot update: patient does not exist");
        }
        patientPort.save(patient);
    }

}
