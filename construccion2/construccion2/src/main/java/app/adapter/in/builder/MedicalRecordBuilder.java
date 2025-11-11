package app.adapter.in.builder;

import app.adapter.in.validators.MedicalRecordValidator;
import app.domain.entities.MedicalRecord;

public class MedicalRecordBuilder {
	
	private MedicalRecordValidator medicalRecordValidator;

	public MedicalRecord build(String patient, String doctor,  String symptomatology, String bloodPressure, String temperture, String pulse, String oxygenLevel, String date) 
		throws Exception {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setPatient(medicalRecordValidator.patientValidator(patient));
		medicalRecord.setDate(medicalRecordValidator.dateValidator(date));
		
		return medicalRecord;
	}
}
