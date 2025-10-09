package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.ports.PatientPort;                        //seguImos el esquema CRUD (CREATE,READ,UPDATE,DELETE)

@Service
public class ReadPatient {  // El read es el search 

	
	@Autowired
	private PatientPort patientPort;
	
	
	 // buscar paciente por id
	  public Patient read(Patient patient) throws Exception {
	       if (patientPort.findById(patient) == null) {
	            throw new Exception("No se ha encontrado ningun paciente con ese ID");
	        }
	        return patient;
	    }
}
