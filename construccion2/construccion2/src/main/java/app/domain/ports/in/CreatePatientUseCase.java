package app.domain.ports.in;
import app.domain.entities.Patient;
import app.domain.entities.enums.Role;


public interface CreatePatientUseCase {
	
	Patient create(Patient patient, Role role);
	

	

}
