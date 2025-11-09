package app.domain.ports;

import java.util.List;

import app.domain.entities.Diagnostic;
import app.domain.entities.Patient;
import app.domain.entities.User;

public interface DiagnosticPort {
	
	public void save(Diagnostic diagnostic) throws Exception;
	public Diagnostic findById(Diagnostic diagnostic) throws Exception;
	public List<Diagnostic> findByPatient(Patient patient) throws Exception;
	public List<Diagnostic> findByDoctor(User doctor) throws Exception;
	public void delete(Diagnostic diagnostic) throws Exception;
}
