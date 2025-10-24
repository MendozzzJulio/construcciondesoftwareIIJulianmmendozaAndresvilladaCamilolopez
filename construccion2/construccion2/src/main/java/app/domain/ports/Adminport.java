package app.domain.ports;

import app.domain.entities.Patient;

public interface Adminport {
	public void createPatient(Patient patient) throws Exception;
	public void updatePatient(Patient patient);
}
