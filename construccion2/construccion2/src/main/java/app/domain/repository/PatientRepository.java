package app.domain.repository;

import java.util.Optional;

import app.domain.entities.Patient;

public interface PatientRepository {
	
	 void save(Patient patient); 
	
	 Optional<Patient> findById(long id);

	
}
