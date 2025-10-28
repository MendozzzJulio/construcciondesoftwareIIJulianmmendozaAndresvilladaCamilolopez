package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;


public class CreateUser {
	@Autowired  
	private UserPort userPort;
	
	// En este clase creamos al empleado de la clinica asignandole un rol 
	
	/*
	 * Se debe validar que sea creado por un admin
	 * 
	 * Se debe asignar un rol al empleado */
	
	public void crate(User employee) throws Exception {

		// Validar que el rol sea valido
		
		}

		// Lógica para guardar el empleado en  	 sistema (omitir implementación)
		
		
		
		
	}
	
	
	

