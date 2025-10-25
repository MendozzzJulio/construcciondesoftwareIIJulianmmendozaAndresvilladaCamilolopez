package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.entities.MedicalRecord;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.MedicalRecordPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

@Service
public class CreateMedicalRecord {
	@Autowired
	private MedicalRecordPort medicalRecordPort;
	@Autowired
	private PatientPort patientPort;
	@Autowired
	private UserPort userPort;
	
	
	public void create(MedicalRecord medicalRecord) throws Exception {
		Patient patient = patientPort.findById(medicalRecord.getPatient()); //busco paciente por ID,si no existe lanzo excepcion 
		if(patient == null) {
			throw new Exception(" No se puede crear historia clinica para un paciente no registrado o no valido ");
		}
		User doctor = userPort.findByDocument(medicalRecord.getDoctor()); //busco doctor por documento, si no existe lanzo excepcion
		
		if (doctor == null || doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception(" La historia clinica debe ser registrada por un doctor valido ");
		}
		
		medicalRecord.setPatient(patient); //asigno paciente a la historia clinica
		medicalRecord.setDoctor(doctor); //asigno doctor a la historia clinica
		medicalRecordPort.save(medicalRecord); // lo guardo en la historia clinica
		
	}
	 // con este metodo  actualizamos una historia clinica que ya existe 
	public void update(MedicalRecord medicalRecord) throws Exception{
		Patient patient = patientPort.findByDocument(medicalRecord.getPatient()); //busco paciente por documento, si no existe lanzo excepcion
		if(patient == null) {
			throw new Exception("La historia clinica debe tener un paciente valido");					
		}
		medicalRecordPort.update(medicalRecord); // actualizo la historia clinica y se guarda 
	}

}
