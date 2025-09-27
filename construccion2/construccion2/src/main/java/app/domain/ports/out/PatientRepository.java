package app.domain.ports.out;

import app.domain.entities.Patient;

public interface PatientRepository {
	
	Patient save(Patient patient);
	Patient findById(long id);
	

	


	
}
