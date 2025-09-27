package app.domain.ports.out;

import app.domain.entities.Patient;

public interface PatientRepository {
	
	void save(Patient patient);

	Patient findById(long id);

	boolean existsById(long id);


	
}
