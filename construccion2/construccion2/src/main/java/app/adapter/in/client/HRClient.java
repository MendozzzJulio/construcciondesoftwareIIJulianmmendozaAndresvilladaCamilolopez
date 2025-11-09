package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.UserBuilder;
import app.application.usecase.HRUseCase;
import app.domain.entities.User;

/**
 * Cliente para el rol HR (Recursos Humanos)
 * Maneja la interacción con usuarios de recursos humanos del sistema
 */
@Component
public class HRClient {

	private static final String MENU = " ***MENU RECURSOS HUMANOS*** \n1. Crear empleado \n2. Actualizar empleado\n3. Eliminar empleado \n4. Buscar empleado por ID \n5. Buscar empleado por documento \n6. Buscar empleado por username \n7. Salir";		
	private static Scanner reader = new Scanner(System.in);
	
	@Autowired
	private HRUseCase hrUseCase;
	@Autowired
	private UserBuilder userBuilder;
	
	/**
	 * Muestra el menú y ejecuta la opción seleccionada por el usuario de HR.
	 * @return true si se debe continuar la sesión, false si se debe terminar.
	 */
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = reader.nextLine();
			switch(option) {
			case "1":{
				// Crear empleado
				User employee = readInfoFromEmployee();
				User hrUser = getCurrentHRUser(); // En un sistema real, esto vendría del contexto de seguridad
				hrUseCase.createEmployee(employee, hrUser);
				System.out.println("Empleado creado exitosamente");
				return true;
			}
			case "2": {
				// Actualizar empleado
				System.out.println("Ingrese el ID del empleado a actualizar:");
				long id = Long.parseLong(reader.nextLine());
				User employee = readInfoFromEmployee();
				employee.setId(id);
				User hrUser = getCurrentHRUser();
				hrUseCase.updateEmployee(employee, hrUser);
				System.out.println("Empleado actualizado exitosamente");
				return true;
			}
			case "3": {
				// Eliminar empleado
				System.out.println("Ingrese el ID del empleado a eliminar:");
				long id = Long.parseLong(reader.nextLine());
				User employee = new User();
				employee.setId(id);
				User hrUser = getCurrentHRUser();
				hrUseCase.deleteEmployee(employee, hrUser);
				System.out.println("Empleado eliminado exitosamente");
				return true;
			}
			case "4": {
				// Buscar empleado por ID
				System.out.println("Ingrese el ID del empleado a buscar:");
				long id = Long.parseLong(reader.nextLine());
				User searchUser = new User();
				searchUser.setId(id);
				User foundUser = hrUseCase.searchEmployee(searchUser);
				System.out.println("Empleado encontrado: " + foundUser.getName() + " " + foundUser.getLastName() + " - Rol: " + foundUser.getRole());
				return true;
			}
			case "5": {
				// Buscar empleado por documento
				System.out.println("Ingrese el documento del empleado a buscar:");
				long document = Long.parseLong(reader.nextLine());
				User searchUser = new User();
				searchUser.setDocument(document);
				User foundUser = hrUseCase.searchEmployeeByDocument(searchUser);
				System.out.println("Empleado encontrado: " + foundUser.getName() + " " + foundUser.getLastName() + " - Rol: " + foundUser.getRole());
				return true;
			}
			case "6": {
				// Buscar empleado por username
				System.out.println("Ingrese el username del empleado a buscar:");
				String username = reader.nextLine();
				User searchUser = new User();
				searchUser.setUsername(username);
				User foundUser = hrUseCase.searchEmployeeByUsername(searchUser);
				System.out.println("Empleado encontrado: " + foundUser.getName() + " " + foundUser.getLastName() + " - Rol: " + foundUser.getRole());
				return true;
			}
			case "7":{
				System.out.println("Hasta luego \nCerrando sesión");
				return false;
			}
			default:{
                System.out.println("Ingrese una opción válida");
                return true;
			}
			}
		} catch(Exception e){
			System.out.println("Error: " + e.getMessage());
            return true;
		}
	}
	
	private User readInfoFromEmployee() throws Exception {
		System.out.println("Ingrese el nombre del empleado:");
		String name = reader.nextLine();
		System.out.println("Ingrese el apellido del empleado:");
		String lastName = reader.nextLine();
		System.out.println("Ingrese el documento del empleado:");
		String document = reader.nextLine();
		System.out.println("Ingrese el email del empleado:");
		String email = reader.nextLine();
		System.out.println("Ingrese el teléfono del empleado:");
		String phoneNumber = reader.nextLine();
		System.out.println("Ingrese la dirección del empleado:");
		String address = reader.nextLine();
		System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
		String dateOfBirth = reader.nextLine();
		System.out.println("Ingrese el username:");
		String username = reader.nextLine();
		System.out.println("Ingrese la contraseña:");
		String password = reader.nextLine();
		System.out.println("Ingrese el rol (DOCTOR, NURSE, ADMINISTRATIVE):");
		String role = reader.nextLine();
		
		return userBuilder.build(name, lastName, document, email, phoneNumber, address, dateOfBirth, username, password, role);
	}
	
	private User getCurrentHRUser() {
		// En un sistema real, esto vendría del contexto de seguridad/sesión
		// Por ahora simulamos un usuario HR
		User hrUser = new User();
		hrUser.setId(1L); // ID simulado del usuario HR actual
		return hrUser;
	}
	
	/**
	 * Inicia la sesión del usuario de HR, mostrando el menú en un bucle hasta que decida salir
	 */
	public void session() {
		System.out.println("=== BIENVENIDO AL SISTEMA DE RECURSOS HUMANOS ===");
		boolean session = true;
		while(session) {
			session = menu();
		}
	}
}
