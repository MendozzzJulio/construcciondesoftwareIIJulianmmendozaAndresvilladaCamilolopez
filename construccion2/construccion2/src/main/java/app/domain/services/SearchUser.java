package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.User;
import app.domain.ports.UserPort;

@Service
public class SearchUser {
	
	@Autowired
	private UserPort userPort;

	public User search(User user) throws Exception {
		
		if (user == null) {
			throw new Exception("Los criterios de búsqueda no pueden ser nulos");
		}
		
		User foundUser = userPort.findById(user);
		if (foundUser == null) {
			throw new Exception("No se encontró el usuario especificado");
		}
		
		return foundUser;
	}
	
	public User searchByDocument(User user) throws Exception {
		
		if (user == null) {
			throw new Exception("Los criterios de búsqueda no pueden ser nulos");
		}
		
		User foundUser = userPort.findByDocument(user);
		if (foundUser == null) {
			throw new Exception("No se encontró el usuario con el documento especificado");
		}
		
		return foundUser;
	}
	
	public User searchByUsername(User user) throws Exception {
		
		if (user == null) {
			throw new Exception("Los criterios de búsqueda no pueden ser nulos");
		}
		
		User foundUser = userPort.findByUsername(user);
		if (foundUser == null) {
			throw new Exception("No se encontró el usuario con el nombre de usuario especificado");
		}
		
		return foundUser;
	}
}
