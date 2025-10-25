package app.domain.ports;

import java.util.List;

import app.domain.entities.MedicalRecord;
import app.domain.entities.Patient;

public interface SearchMedicalRecordPort {
	
	public SearchMedicalRecordPort findById(Patient patient) throws Exception;
	public List<MedicalRecord> findByPatient(Patient patient)throws Exception;
}
