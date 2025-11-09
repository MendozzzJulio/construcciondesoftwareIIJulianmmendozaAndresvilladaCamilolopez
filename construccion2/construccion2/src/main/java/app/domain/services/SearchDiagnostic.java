package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Diagnostic;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.ports.DiagnosticPort;

@Service
public class SearchDiagnostic {
	
	@Autowired
	private DiagnosticPort diagnosticPort;

	public Diagnostic search(Diagnostic diagnostic) throws Exception {
		
		if (diagnostic == null) {
			throw new Exception("Los criterios de búsqueda no pueden ser nulos");
		}
		
		Diagnostic foundDiagnostic = diagnosticPort.findById(diagnostic);
		if (foundDiagnostic == null) {
			throw new Exception("No se encontró el diagnóstico especificado");
		}
		
		return foundDiagnostic;
	}
	
	public List<Diagnostic> searchByPatient(Patient patient) throws Exception {
		
		if (patient == null) {
			throw new Exception("El paciente no puede ser nulo");
		}
		
		List<Diagnostic> diagnostics = diagnosticPort.findByPatient(patient);
		if (diagnostics == null || diagnostics.isEmpty()) {
			throw new Exception("No se encontraron diagnósticos para el paciente especificado");
		}
		
		return diagnostics;
	}
	
	public List<Diagnostic> searchByDoctor(User doctor) throws Exception {
		
		if (doctor == null) {
			throw new Exception("El doctor no puede ser nulo");
		}
		
		List<Diagnostic> diagnostics = diagnosticPort.findByDoctor(doctor);
		if (diagnostics == null || diagnostics.isEmpty()) {
			throw new Exception("No se encontraron diagnósticos para el doctor especificado");
		}
		
		return diagnostics;
	}
}
