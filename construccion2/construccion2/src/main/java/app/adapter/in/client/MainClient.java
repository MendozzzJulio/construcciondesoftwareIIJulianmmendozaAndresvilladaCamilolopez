package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.ports.UserPort;

/**
 * Cliente principal que maneja el login y redirecciona según el rol del usuario
 */
@Component
public class MainClient {
	
	private static Scanner reader = new Scanner(System.in);
	
	@Autowired
	private UserPort userPort;
	@Autowired
	private AdminClient adminClient;
	@Autowired
	private HRClient hrClient;
	@Autowired
	private DoctorClient doctorClient;
	@Autowired
	private NurseClient nurseClient;
	
	/**
	 * Método principal que inicia el sistema
	 */
	public void start() {
		System.out.println("=== SISTEMA DE GESTIÓN MÉDICA ===");
		System.out.println("Bienvenido al sistema de información de la clínica");
		
		boolean continueSession = true;
		while(continueSession) {
			try {
				User loggedUser = login();
				if(loggedUser != null) {
					redirectToRoleClient(loggedUser);
				}
				
				System.out.println("\n¿Desea iniciar otra sesión? (s/n):");
				String response = reader.nextLine();
				continueSession = response.equalsIgnoreCase("s") || response.equalsIgnoreCase("si");
				
			} catch(Exception e) {
				System.out.println("Error en el sistema: " + e.getMessage());
				System.out.println("Intente nuevamente...\n");
			}
		}
		
		System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
	}
	
	/**
	 * Maneja el proceso de login del usuario
	 */
	private User login() {
		try {
			System.out.println("\n--- LOGIN ---");
			System.out.println("Ingrese su nombre de usuario:");
			String username = reader.nextLine();
			System.out.println("Ingrese su contraseña:");
			String password = reader.nextLine();
			
			// Crear usuario para búsqueda
			User searchUser = new User();
			searchUser.setUsername(username);
			
			// Buscar usuario en el sistema
			User foundUser = userPort.findByUsername(searchUser);
			
			if(foundUser == null) {
				System.out.println("Usuario no encontrado. Verifique sus credenciales.");
				return null;
			}
			
			// Validar contraseña (en un sistema real sería con hash)
			if(!foundUser.getPassword().equals(password)) {
				System.out.println("Contraseña incorrecta. Verifique sus credenciales.");
				return null;
			}
			
			System.out.println("Login exitoso. Bienvenido " + foundUser.getName() + " " + foundUser.getLastName());
			System.out.println("Rol: " + foundUser.getRole());
			
			return foundUser;
			
		} catch(Exception e) {
			System.out.println("Error durante el login: " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * Redirecciona al cliente apropiado según el rol del usuario
	 */
	private void redirectToRoleClient(User user) {
		Role userRole = user.getRole();
		
		switch(userRole) {
			case ADMINISTRATIVE:
				System.out.println("\nRedirigiendo al sistema administrativo...");
				adminClient.session();
				break;
				
			case DOCTOR:
				System.out.println("\nRedirigiendo al sistema médico...");
				doctorClient.session();
				break;
				
			case NURSE:
				System.out.println("\nRedirigiendo al sistema de enfermería...");
				nurseClient.session();
				break;
				
			default:
				// Para roles administrativos que pueden acceder a HR
				if(userRole == Role.ADMINISTRATIVE) {
					System.out.println("\n¿Desea acceder al sistema de Recursos Humanos? (s/n):");
					String response = reader.nextLine();
					if(response.equalsIgnoreCase("s") || response.equalsIgnoreCase("si")) {
						System.out.println("Redirigiendo al sistema de Recursos Humanos...");
						hrClient.session();
					} else {
						System.out.println("Redirigiendo al sistema administrativo...");
						adminClient.session();
					}
				} else {
					System.out.println("Rol no reconocido o sin permisos de acceso al sistema.");
				}
				break;
		}
	}
}
