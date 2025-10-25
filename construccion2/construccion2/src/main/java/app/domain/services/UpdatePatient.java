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
    public void update(Patient patient) throws Exception {
        if(patientPort.findById(patient) == null) {
            throw new Exception("El paciente que intenta actualizar no existe");
        }
        
        patientPort.save(patient);
    }

}
 	