package app.domain.ports;

import app.domain.entities.MedicalRecord;

public interface MedicalRecordPort {
	
	public void save(MedicalRecord medicalRecord) throws Exception;
	public void update(MedicalRecord medicalRecord) throws Exception;
	
	

}
