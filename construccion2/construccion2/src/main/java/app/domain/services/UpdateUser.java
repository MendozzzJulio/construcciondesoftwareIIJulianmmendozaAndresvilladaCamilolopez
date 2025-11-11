package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.UserPort;

@Service
public class UpdateUser {
	
	@Autowired
	private UserPort userPort;
	
	public void update(User employee) throws Exception {
		
		if (employee == null) {
			throw new Exception("El usuario a actualizar no puede ser nulo");
		}
		
		if (employee == null) {
			throw new Exception("Se requiere un usuario administrador para actualizar usuarios");
			}
		
		
		User admin = userPort.findById(employee);
		if (admin == null) {
			throw new Exception("El usuario administrador no existe en el sistema");
		}
		
		if (!admin.getRole().equals(Role.ADMINISTRATIVE)) {
			throw new Exception("Solo usuarios de Recursos Humanos pueden actualizar usuarios");
		}
		
		User existingUser = userPort.findById(employee);
		if (existingUser == null) {
			throw new Exception("El usuario a actualizar no existe en el sistema");
		}
		
		if (employee.getName() != null && !employee.getName().trim().isEmpty()) {
			existingUser.setName(employee.getName());
		}
		
		if (employee.getLastName() != null && !employee.getLastName().trim().isEmpty()) {
			existingUser.setLastName(employee.getLastName());
		}
		
		if (employee.getEmail() != null) {
			existingUser.setEmail(employee.getEmail());
		}
		
		if (employee.getPhoneNumber() != null) {
			existingUser.setPhoneNumber(employee.getPhoneNumber());
		}
		
		if (employee.getAddress() != null) {
			existingUser.setAddress(employee.getAddress());
		}
		
		if (employee.getUsername() != null && !employee.getUsername().trim().isEmpty()) {
			User existingByUsername = userPort.findByUsername(employee);
			if (existingByUsername != null && existingByUsername.getId() != existingUser.getId()) {
				throw new Exception("Ya existe otro usuario con ese nombre de usuario");
			}
			// Error que habia en la linea 62 era porque  getId() retorna un tipo primitivo long, y los tipos primitivos no tienen métodos como equals().
			//Para comparar dos valores long, debes usar el operador == en vez de .equals().
			existingUser.setUsername(employee.getUsername());
		}
		
		if (employee.getPassword() != null && !employee.getPassword().trim().isEmpty()) {
			existingUser.setPassword(employee.getPassword());
		}
		
		if (employee.getRole() != null) {
			existingUser.setRole(employee.getRole());
		}
		
		userPort.save(existingUser);
	}
}
