package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Patient;
import app.domain.ports.PatientPort;
@Service
public class SearchPatient {
	
	@Autowired
	private PatientPort patientPort;

	public List<Patient> search(Patient patient) throws Exception {
		
		// y si lo quiere buscar por cedula?
		
		// POR AHORA LO DEJAMOS ASI 
		patient = patientPort.findById(patient);
		if (patient == null) {
			throw new Exception("debe consultar un paciente registrado");
		}
		return patientPort.findByPatient(patient);
	}
	
	

}
