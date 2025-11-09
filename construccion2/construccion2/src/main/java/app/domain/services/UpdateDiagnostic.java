package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Diagnostic;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.DiagnosticPort;
import app.domain.ports.UserPort;

@Service
public class UpdateDiagnostic {
	
	@Autowired
	private DiagnosticPort diagnosticPort;
	@Autowired
	private UserPort userPort;

	public void update(Diagnostic diagnostic, User doctor) throws Exception {
		
		if (diagnostic == null) {
			throw new Exception("El diagnóstico no puede ser nulo");
		}
		
		if (doctor == null) {
			throw new Exception("Se requiere un doctor para actualizar diagnósticos");
		}
		
		User doctorFromDb = userPort.findById(doctor);
		if (doctorFromDb == null) {
			throw new Exception("El doctor no existe en el sistema");
		}
		
		if (!doctorFromDb.getRole().equals(Role.DOCTOR)) {
			throw new Exception("Solo médicos pueden actualizar diagnósticos");
		}
		
		Diagnostic existingDiagnostic = diagnosticPort.findById(diagnostic);
		if (existingDiagnostic == null) {
			throw new Exception("El diagnóstico a actualizar no existe en el sistema");
		}
		
		if (!existingDiagnostic.getDoctor().getId().equals(doctorFromDb.getId())) {
			throw new Exception("Solo el doctor que creó el diagnóstico puede actualizarlo");
		}
		
		if (diagnostic.getDescription() != null && !diagnostic.getDescription().trim().isEmpty()) {
			existingDiagnostic.setDescription(diagnostic.getDescription());
		}
		
		if (diagnostic.getResults() != null && !diagnostic.getResults().trim().isEmpty()) {
			existingDiagnostic.setResults(diagnostic.getResults());
		}
		
		if (diagnostic.getSeverity() != null && !diagnostic.getSeverity().trim().isEmpty()) {
			existingDiagnostic.setSeverity(diagnostic.getSeverity());
		}
		
		if (diagnostic.getNotes() != null && !diagnostic.getNotes().trim().isEmpty()) {
			existingDiagnostic.setNotes(diagnostic.getNotes());
		}
		
		diagnosticPort.save(existingDiagnostic);
	}
}
