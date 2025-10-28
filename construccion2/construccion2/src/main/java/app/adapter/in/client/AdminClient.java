package app.adapter.in.client;

import java.util.Scanner;

import app.application.usecase.AdminUseCase;
import app.domain.entities.Patient;

// Se supone que son las opciones del admin
// Este cliente es el encargado de la interaccion con el administrador del sistema
public class AdminClient {
	private static final String MENU = " ***Ingrese una opcion*** \n1. Crear paciente \n2. Crear cita \n3. Crear factura \n4 Actualizar factura \n5. Crear contacto de emergencia \n6. Salir";		
	private static Scanner reader = new Scanner(System.in);
	private AdminUseCase adminUsecase;
	
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = reader.nextLine();
			switch(option) {
			case "1":{
				Patient patient = readInfoFromPatient();
				adminUsecase.createPatient(patient);
			}
			
			}
			
		}catch(Exception e){
		}
		return true;	
	}
	
	private Patient readInfoFromPatient() throws Exception {
		
		System.out.println("Ingrese el numero de cedula del paciente.");
		String document = reader.nextLine();
		System.out.println("Ingrese el nombre del paciente.");
		String name = reader.nextLine();
		System.out.println("Ingrese los apellidos del paciente del paciente.");
		String lastName = reader.nextLine();
		System.out.println("Ingrese el correo electronico del paciente del paciente.");
		String email = reader.nextLine();
		System.out.println("Ingrese la direccion del paciente.");
		String address = reader.nextLine();
		System.out.println("Ingrese el numero de telefono del paciente.");
		String phoneNumber = reader.nextLine();
		System.out.println("Ingrese la fecha de nacimiento del paciente.");
		String dateOfBirth = reader.nextLine();
		
		
        
	}
	
	public void session() {
		boolean session = true;
		while(session) {
			session = menu();
			}
		
	}
	

} // end class
