package app.domain.services;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.UserPort;

public class UpdateUser {
	
	private UserPort userPort;
	
	//actaulizamos usuario
	
	public void update(User user)throws Exception{
		
		//Valido que solo un admin pueda actualizar los usarios
		if (user == null || user.getRole() != Role.ADMINISTRATIVE) {
			throw new Exception("Solo los administradores pueden actualizar un usuario");
		}
		//Valido que el usuario exista
		if(userPort.findById(user) == null) {
			throw new Exception("El usuario no existe");
		}
		
		
	}

}
