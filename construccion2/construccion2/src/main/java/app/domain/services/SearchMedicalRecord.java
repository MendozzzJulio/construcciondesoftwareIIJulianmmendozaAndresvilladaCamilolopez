package app.domain.services;

import app.domain.ports.SearchMedicalRecordPort;
import app.domain.ports.PatientPort;

import java.util.List;

import app.domain.entities.MedicalRecord;
import app.domain.entities.Patient;

public class SearchMedicalRecord {
	
	private PatientPort patientPort;
	
	private SearchMedicalRecordPort medicalRecordPort;
	
	public List<MedicalRecord> search(Patient patient) throws Exception{
		patient = patientPort.findById(patient);
		if (patient == null) {
			throw new Exception(" Se debe consultar historia clinica de un paciente registrado ");
		}
		return medicalRecordPort.findByPatient(patient);
	}
	
	
	
	
	

}
