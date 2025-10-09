package app.domain.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.MedicalOrder;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.UserPort;
import app.domain.ports.MedicalOrderPort;
import app.domain.ports.PatientPort;

@Service // Marca la clase como un servicio de negocio.
public class CreateMedicalOrder {
	
	@Autowired  // Inyecta la dependencia del puerto de usuario. Asi mismo con los diferentes puertos.
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;
	@Autowired
	private MedicalOrderPort medicalOrderPort;
	
	public void Create(MedicalOrder medicalOrder) throws Exception{
		User doctor = userPort.findByDocument(medicalOrder.getDoctor());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("Las ordenes solo pueden ser creadas por un doctor");
        }
        
        Patient patient = patientPort.findById(medicalOrder.getPatient());
        if (patient==null) {
        	throw new Exception("Las ordenes medicas deben de asociarse a un paciente");
        	
        }
        
        medicalOrder.setDate(new Date(System.currentTimeMillis()));
        medicalOrder.setPatient(patient);
        medicalOrder.setDoctor(doctor);
        
        medicalOrderPort.save(medicalOrder);
	}
}
