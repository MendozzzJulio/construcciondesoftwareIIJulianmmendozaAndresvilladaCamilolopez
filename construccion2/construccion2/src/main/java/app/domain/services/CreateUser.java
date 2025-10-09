package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.User;
import app.domain.ports.UserPort;

@Service	
public class CreateUser {
	
	@Autowired
	private UserPort userPort;

	
	
	
	public void create(User user) throws Exception{
		
		if (user !=null) {
			throw new Exception("Ya existe un usuario con este documento");	
		}
		if (userPort.findByDocument(user) != null) {
			throw new Exception("Ya existe un usuario con este documento");
		}
		
		
		
		
	}
	
	
	

}
