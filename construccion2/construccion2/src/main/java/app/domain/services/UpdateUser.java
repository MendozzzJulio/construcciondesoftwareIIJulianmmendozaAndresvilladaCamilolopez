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
	
	public void update(User user, User adminUser) throws Exception {
		
		if (user == null) {
			throw new Exception("El usuario a actualizar no puede ser nulo");
		}
		
		if (adminUser == null) {
			throw new Exception("Se requiere un usuario administrador para actualizar usuarios");
		}
		
		User admin = userPort.findById(adminUser);
		if (admin == null) {
			throw new Exception("El usuario administrador no existe en el sistema");
		}
		
		if (!admin.getRole().equals(Role.ADMINISTRATIVE)) {
			throw new Exception("Solo usuarios de Recursos Humanos pueden actualizar usuarios");
		}
		
		User existingUser = userPort.findById(user);
		if (existingUser == null) {
			throw new Exception("El usuario a actualizar no existe en el sistema");
		}
		
		if (user.getName() != null && !user.getName().trim().isEmpty()) {
			existingUser.setName(user.getName());
		}
		
		if (user.getLastName() != null && !user.getLastName().trim().isEmpty()) {
			existingUser.setLastName(user.getLastName());
		}
		
		if (user.getEmail() != null) {
			existingUser.setEmail(user.getEmail());
		}
		
		if (user.getPhoneNumber() != null) {
			existingUser.setPhoneNumber(user.getPhoneNumber());
		}
		
		if (user.getAddress() != null) {
			existingUser.setAddress(user.getAddress());
		}
		
		if (user.getUsername() != null && !user.getUsername().trim().isEmpty()) {
			User existingByUsername = userPort.findByUsername(user);
			if (existingByUsername != null && !existingByUsername.getId().equals(existingUser.getId())) {
				throw new Exception("Ya existe otro usuario con ese nombre de usuario");
			}
			existingUser.setUsername(user.getUsername());
		}
		
		if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
			existingUser.setPassword(user.getPassword());
		}
		
		if (user.getRole() != null) {
			existingUser.setRole(user.getRole());
		}
		
		userPort.save(existingUser);
	}
}
