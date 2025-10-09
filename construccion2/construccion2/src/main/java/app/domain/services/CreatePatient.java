package app.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;                      
import app.domain.ports.UserPort;
import app.domain.ports.PatientPort;



@Service
public class CreatePatient {  //seguImos el esquema CRUD (CREATE,READ,UPDATE,DELETE)
	@Autowired
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;
	
	//vamos a crear el nuevo (enfermo) paciente 
	public void create(Patient patient) throws Exception {
		// Validamos que quien crea el paciente sea un administrativo
		User administrative = userPort.findById(patient.getAdministrative());
		if (administrative == null || !administrative.getRole().equals(Role.ADMINISTRATIVE)){
			throw new Exception("Solo un usuario administrativo puede crear un paciente");
		}
		// Validamos si el paciente ya existe en el sistema
		if (patientPort.findById(patient) != null) {
            throw new Exception(" Ya existe un paciente con este ID");
        }
        patientPort.save(patient);		
	}
}

	   

