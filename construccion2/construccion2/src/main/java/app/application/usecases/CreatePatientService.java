package app.application.usecases;

import app.domain.entities.Patient;
import app.domain.entities.enums.Role;
import app.domain.ports.in.CreatePatientUseCase;
import app.domain.ports.out.PatientRepository;

public class CreatePatientService implements CreatePatientUseCase {
	
	private final PatientRepository patientRepository;
	
	public CreatePatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Override
	public Patient create(Patient patient, Role controllerRole) {
		if (controllerRole != Role.AMINISTRATIVE) {
			throw new IllegalArgumentException("Solo un personal administrativo puede crar pacientes.");
		
		}
		if (patientRepository.findById(patient.getId()) != null) {
			throw new IllegalArgumentException("El paciente con id " + patient.getId() + " ya existe.");
		}
		
		return patientRepository.save(patient);
	}

	

}
