package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.ports.PatientPort;                        //seguImos el esquema CRUD (CREATE,READ,UPDATE,DELETE)

@Service
public class ReadPatient {

	
	@Autowired
	private PatientPort patientPort;
	
	
	 // buscar paciente por id
	  public Patient getPatient(Patient patient) throws Exception {
	        Patient found = patientPort.findById(patient);
	        if (found == null) {
	            throw new Exception("Patient not found");
	        }
	        return found;
	    }
}
