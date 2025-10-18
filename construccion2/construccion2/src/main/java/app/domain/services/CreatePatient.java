package app.domain.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.entities.User;                      
import app.domain.ports.UserPort;
import app.domain.ports.PatientPort;


/**
 * Servicio encargado de la creación y actualización de pacientes.
 * Sigue el esquema CRUD (CREATE, READ, UPDATE, DELETE).
 */

@Service
public class CreatePatient {  
	@Autowired  // Inyección de dependencias para acceder a los datos de usuarios y pacientes
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;
	
	
	
public void createPatient(Patient patient) throws Exception {
		
	 // Validación: Verificamos si ya existe un enfermo  con el mismo documento
		if(patientPort.findByDocument(patient)!=null) {
			throw new Exception("Ya existe una persona con esa cedula");
		}
		// Validación: Número de teléfono debe tener exactamente 10 dígito
		long phoneNumber = patient.getPhoneNumber();
	    if (String.valueOf(phoneNumber).length() != 10) {
	        throw new Exception("El número de teléfono debe tener exactamente 10 dígitos");
	    }
	    
	    if (patient.getBirthdate() == null || patient.getBirthdate().trim().isEmpty()) {
	        throw new Exception(" no puede estar vacío");
	    }

	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    formatter.setLenient(false);

	    try {
	        formatter.parse(patient.getBirthdate().trim());
	    } catch (ParseException e) {
	        throw new Exception(" debe ser una fecha válida en formato dd/MM/yyyy (ej. 15/05/1990)");
	    }
	    
	    if(patient.getSize()<=0) {
	    	throw new Exception("El peso debe ser un valor valido");
	    }
	 // Validación: Peso (weight) debe ser mayor a 0
	    if(patient.getWeigth()<=0) {
	    	throw new Exception("La altura debe ser un valor valido");
	    }
	    
	    if (patient.getEmail() == null || patient.getEmail().trim().isEmpty()) {
	        throw new Exception("El correo electrónico no puede estar vacío");
	    }
	    long patientDocument = patient.getDocument();
	    if (String.valueOf(patientDocument).length() < 6 || String.valueOf(patientDocument).length() >10) {
	        throw new Exception("El número de documento es invalido, debe tener entre 6 y 10 digitos");
	    }

	    // Expresión regular para validar formato de email
	    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    
	 // Validación: El enfermo tiene que estar asignado a un docto
	    if (!patient.getEmail().matches(emailRegex)) {
	        throw new Exception("El correo electrónico no tiene un formato válido (ej. usuario@dominio.com)");
	    }
	    
	    // Validación: Verificar que el doctor exista en el sistema
	    if (patient.getDoctor() == null) {
	        throw new Exception("El paciente debe estar asignado a un doctor");
	    }
	    User doctor = userPort.findByDocument(patient.getDoctor());;
	    if (doctor == null) {
	        throw new Exception("El doctor asignado no existe en el sistema");
	    }
	 // Si todas las validaciones escalan el monte everest(osea exitosas), se guarda el enfermo
		patientPort.save(patient);
		
	}

		public void updatePatient(Patient patient) throws Exception{
			
			// Validación: Verificar si el enfermo existe o es mero fantasma 	
			if(patientPort.findByDocument(patient)==null) {
				throw new Exception("El paciente no existe");
			}
			// Actualiza los datos del enfermo 
			else {
				patientPort.updatePatient(patient);
			}
			
		}
}
        
      
	   

