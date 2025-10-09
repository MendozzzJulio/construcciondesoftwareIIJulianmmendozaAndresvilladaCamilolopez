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

	public void create(User user) throws Exception{
		
		// Validamos que solo un admin pueda crear usuarios
		if (user == null || user.getRole() != Role.ADMINISTRATIVE) {
			throw new Exception("Solo los administradores pueden crear un usuario");
			} 
		
		//Se valida que no exista un usuario con el mismo documento 
		if (userPort.findByDocument(user) != null) {
			throw new Exception("Ya existe un usuario con este documento");
		}
		//Se valida que no exista un usuario con el mismo nombre de usuario
		if (userPort.findByUsername(user) !=null) {
			throw new Exception("Ya existe un usuario con este nombre de usuario");
		}
		
		// creo que esto no haria falta porque el ID es autogenerado 
		if (userPort.findById(user) !=null) {
			throw new Exception("Ya existe un usuario con este ID");
		}
		
		
		
		userPort.save(user);
		
	}
	

}
