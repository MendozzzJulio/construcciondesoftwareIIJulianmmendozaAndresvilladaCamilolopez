package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.UserPort;

@Service
public class CreateUser {
	@Autowired  
	private UserPort userPort;
	 @Autowired
	 private AuthenticationService authenticationService;
	
	public void create(User employee) throws Exception {
		
		// VALIDACIÓN DE ROL - Sin parámetros adicionales
        authenticationService.validateUserRole(Role.HR);
        
		if (employee == null) {
			throw new Exception("El empleado no puede ser nulo");
		}
		
	
		if (employee.getName() == null || employee.getName().trim().isEmpty()) {
			throw new Exception("El nombre del empleado es obligatorio");
		}
		
		if (employee.getLastName() == null || employee.getLastName().trim().isEmpty()) {
			throw new Exception("El apellido del empleado es obligatorio");
		}
		
		if (employee.getDocument() == 0) {
			throw new Exception("El documento del empleado es obligatorio");
		}
		
		if (employee.getUsername() == null || employee.getUsername().trim().isEmpty()) {
			throw new Exception("El nombre de usuario es obligatorio");
		}
		
		if (employee.getPassword() == null || employee.getPassword().trim().isEmpty()) {
			throw new Exception("La contraseña es obligatoria");
		}
		
		if (employee.getRole() == null) {
			throw new Exception("El rol del empleado es obligatorio");
		}
		
		User existingByDocument = userPort.findByDocument(employee);
		if (existingByDocument != null) {
			throw new Exception("Ya existe un usuario con ese documento");
		}
		
		User existingByUsername = userPort.findByUsername(employee);
		if (existingByUsername != null) {
			throw new Exception("Ya existe un usuario con ese nombre de usuario");
		}
		
		userPort.save(employee);
	}
}
