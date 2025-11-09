package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.MedicalRecord;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.MedicalRecordPort;
import app.domain.ports.UserPort;

@Service
public class UpdateMedicalRecord {
	
	@Autowired
	private MedicalRecordPort medicalRecordPort;
	@Autowired
	private UserPort userPort;

	public void update(MedicalRecord medicalRecord) throws Exception {
		
		if (medicalRecord == null) {
			throw new Exception("El registro médico no puede ser nulo");
		}
		
		MedicalRecord existingRecord = medicalRecordPort.findById(medicalRecord);
		if (existingRecord == null) {
			throw new Exception("El registro médico a actualizar no existe en el sistema");
		}
		
		if (medicalRecord.getDiagnosis() != null && !medicalRecord.getDiagnosis().trim().isEmpty()) {
			existingRecord.setDiagnosis(medicalRecord.getDiagnosis());
		}
		
		if (medicalRecord.getTreatment() != null && !medicalRecord.getTreatment().trim().isEmpty()) {
			existingRecord.setTreatment(medicalRecord.getTreatment());
		}
		
		if (medicalRecord.getNotes() != null && !medicalRecord.getNotes().trim().isEmpty()) {
			existingRecord.setNotes(medicalRecord.getNotes());
		}
		
		if (medicalRecord.getDate() != null) {
			existingRecord.setDate(medicalRecord.getDate());
		}
		
		medicalRecordPort.save(existingRecord);
	}
}
