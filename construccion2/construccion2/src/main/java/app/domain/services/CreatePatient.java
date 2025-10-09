package app.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.PatientPort;  
import app.domain.ports.UserPort;

@Service
public class CreatePatient {
	@Autowired
	private UserPort userPort;
	
	@Autowired
	private PatientPort patientPort;
	
	public void create(Patient patient)throws Exception {
		
		User administrative = userPort.findByDocument(patient.getAdministrative());
		
		if(administrative== null || !administrative.getRole().equals(Role.ADMINISTRATIVE)) {
			throw new Exception("El paciente solo puede ser creado por un usuario administrativo");
		}
	
		
		patientPort.save(patient);
		
		
        
        
    }
	
	
	
     
}
