package app.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.UserPort;
import app.domain.ports.PatientPort;
import app.domain.entities.valueobjects.PhoneNumber;

 // Servicio encargado de la creación de pacientes.
 //Sigue el esquema CRUD (CREATE, READ, UPDATE, DELETE).
 
@Service
public class CreatePatient {  
	@Autowired  // Inyección de dependencias para acceder a los datos de usuarios y pacientes
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;
		
	public void createPatient(Patient patient, User creator) throws Exception {
		
		// EL PERSONAL ADMINISTRATIVO TAMBIEN TIENE ACCESO A CREAR PACIENTES 
		// HAY QUE VALIDAR ESO TAMBIEN!
	
		// Validamos que sea creado por un Medico	
		if (userPort.findById(creator) == null || creator.getRole() != Role.DOCTOR) {
			throw new Exception("Solo un doctor puede crear pacientes.");
		}
		
		// Validación: Verificamos si ya existe un enfermo  con el mismo documento
		if(patientPort.findByDocument(patient)!=null) {
			throw new Exception("Ya existe una persona con esa cedula");
			}
				
		// Validar que el numero no sea nulo y que sea de exactamente 10 digitos
		PhoneNumber phoneNumber = patient.getPhoneNumber();
		if (phoneNumber == null || phoneNumber.toString().length() != 10) {
			throw new Exception("El numero de telefono debe tener exactamente 10 digitos.");
			}	
		
		// Validar que el numero no este repetido
		if (patientPort.findByPhoneNumber(patient) != null) {
			throw new Exception("Ya existe un paciente registrado con ese numero de contacto.");
			}
		
		patientPort.save(patient); // Guardar el paciente en el sistema
	}		
}

        
      
	   

