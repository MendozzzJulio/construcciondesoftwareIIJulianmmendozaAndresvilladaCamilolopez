package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.UserPort;

@Service
public class DeleteUser {
	
	@Autowired
	private UserPort userPort;

	public void delete(User employee) throws Exception {
		
		if (employee == null) {
			throw new Exception("El usuario a eliminar no puede ser nulo");
		}
		
		if (employee == null) {
			throw new Exception("Se requiere un usuario administrador para eliminar usuarios");
		}
		
		User admin = userPort.findById(employee);
		if (admin == null) {
			throw new Exception("El usuario administrador no existe en el sistema");
		}
		
		if (!admin.getRole().equals(Role.ADMINISTRATIVE)) {
			throw new Exception("Solo usuarios de Recursos Humanos pueden eliminar usuarios");
		}
		
		User existingUser = userPort.findById(employee);
		if (existingUser == null) {
			throw new Exception("El usuario a eliminar no existe en el sistema");
		}
		
		if (existingUser.getRole().equals(Role.ADMINISTRATIVE) && admin.getId() != existingUser.getId()) {
			throw new Exception("No se puede eliminar otro usuario administrativo");
		}
		
		userPort.delete(employee);
	}
}
