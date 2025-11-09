package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Diagnostic;
import app.domain.entities.Patient;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.DiagnosticPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

@Service
public class CreateDiagnostic {
	
	@Autowired
	private DiagnosticPort diagnosticPort;
	@Autowired
	private UserPort userPort;
	@Autowired
	private PatientPort patientPort;

	public void create(Diagnostic diagnostic) throws Exception {
		
		if (diagnostic == null) {
			throw new Exception("El diagnóstico no puede ser nulo");
		}
		
		if (diagnostic.getDoctor() == null) {
			throw new Exception("El doctor es obligatorio para el diagnóstico");
		}
		
		if (diagnostic.getPatient() == null) {
			throw new Exception("El paciente es obligatorio para el diagnóstico");
		}
		
		if (diagnostic.getDescription() == null || diagnostic.getDescription().trim().isEmpty()) {
			throw new Exception("La descripción del diagnóstico es obligatoria");
		}
		
		if (diagnostic.getDate() == null) {
			throw new Exception("La fecha del diagnóstico es obligatoria");
		}
		
		User doctor = userPort.findById(diagnostic.getDoctor());
		if (doctor == null) {
			throw new Exception("El doctor especificado no existe en el sistema");
		}
		
		if (!doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception("Solo médicos pueden crear diagnósticos");
		}
		
		Patient patient = patientPort.findById(diagnostic.getPatient());
		if (patient == null) {
			throw new Exception("El paciente especificado no existe en el sistema");
		}
		
		diagnosticPort.save(diagnostic);
	}
}
