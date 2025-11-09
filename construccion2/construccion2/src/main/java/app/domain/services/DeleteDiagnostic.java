package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Diagnostic;
import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.DiagnosticPort;
import app.domain.ports.UserPort;

@Service
public class DeleteDiagnostic {
	
	@Autowired
	private DiagnosticPort diagnosticPort;
	@Autowired
	private UserPort userPort;

	public void delete(Diagnostic diagnostic, User doctor) throws Exception {
		
		if (diagnostic == null) {
			throw new Exception("El diagnóstico no puede ser nulo");
		}
		
		if (doctor == null) {
			throw new Exception("Se requiere un doctor para eliminar diagnósticos");
		}
		
		User doctorFromDb = userPort.findById(doctor);
		if (doctorFromDb == null) {
			throw new Exception("El doctor no existe en el sistema");
		}
		
		if (!doctorFromDb.getRole().equals(Role.DOCTOR)) {
			throw new Exception("Solo médicos pueden eliminar diagnósticos");
		}
		
		Diagnostic existingDiagnostic = diagnosticPort.findById(diagnostic);
		if (existingDiagnostic == null) {
			throw new Exception("El diagnóstico a eliminar no existe en el sistema");
		}
		
		if (!existingDiagnostic.getDoctor().getId().equals(doctorFromDb.getId())) {
			throw new Exception("Solo el doctor que creó el diagnóstico puede eliminarlo");
		}
		
		diagnosticPort.delete(diagnostic);
	}
}
