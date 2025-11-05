package app.adapter.in.builder;

import app.adapter.in.validators.MedicalRecordValidator;
import app.domain.entities.MedicalRecord;

public class MedicalRecordBuilder {
	
	private MedicalRecordValidator medicalRecordValidator;

	public MedicalRecord build(String patientId, String doctorId, String date, String diagnosis, String treatment, String notes) 
		throws Exception {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setPatientId(medicalRecordValidator.patientIdValidator(patientId));
		medicalRecord.setDoctorId(medicalRecordValidator.doctorIdValidator(doctorId));
		medicalRecord.setDate(medicalRecordValidator.dateValidator(date));
		medicalRecord.setDiagnosis(medicalRecordValidator.diagnosisValidator(diagnosis));
		medicalRecord.setTreatment(medicalRecordValidator.treatmentValidator(treatment));
		medicalRecord.setNotes(medicalRecordValidator.notesValidator(notes));
		
		return medicalRecord;
	}
}
