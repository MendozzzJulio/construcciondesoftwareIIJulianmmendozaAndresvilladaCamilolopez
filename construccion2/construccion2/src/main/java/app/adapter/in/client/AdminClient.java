package app.adapter.in.client;

import app.adapter.in.builder.AppointmentBuilders;
import app.adapter.in.builder.PatientBuilders;

import java.util.Scanner;

import app.application.usecase.AdminUseCase;
import app.domain.entities.Appointment;
import app.domain.entities.Patient;


// Se supone que son las opciones del admin
// Este cliente es el encargado de la interaccion con el administrador del sistema
public class AdminClient {

	private static final String MENU = " ***Ingrese una opcion*** \n1. Crear paciente \n2. Crear cita medica\n3. Crear factura \n4 Actualizar paciente \n5. Crear contacto de emergencia \n6. Salir";		
	private static Scanner reader = new Scanner(System.in);
	private AdminUseCase adminUsecase;
	private PatientBuilders PatientBuilders;
	private AppointmentBuilders AppointmentBuilders;
	
	

/**
     * Muestramos el menú del dia  y ejecutamos  la opción seleccionada por el administrador.
     * @return true si se debe continuar la sesión, false si se debe terminar.
     */
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = reader.nextLine();
			switch(option) {
			case "1":{
				// Creamos el nuevo enfermo 
				Patient patient = readInfoFromPatient();
				adminUsecase.createPatient(patient);
				return true;
			}
			case "2": {
				Appointment appointment = readInfoFromAppointment();
				adminUsecase.createAppointment(appointment);
				return true;
				

			}
			case "3": {

			}
			case "4": {
				System.out.println("Ingrese el id del paciente a actualizar");
				long id = Long.parseLong(reader.nextLine());
				Patient patient = readInfoFromPatient();
				patient.setId(id);
				adminUsecase.updatePatient(patient);
				return true;

			}
			case "5": {

			}
			case "6":{
				System.out.println("Hasta luego \n Cerrando sesion");
				return false;
			}
			default:{
                System.out.println("Ingrese una opcion valida");
                return true;
			}
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
            return true;
		}
	}
	
	
	private Patient readInfoFromPatient() throws Exception {
 /**
 * Solicita al administrador la información necesaria para crear un paciente.
 * @return una instancia de Patient con los datos ingresados.
 * @throws Exception si ocurre un error durante la lectura.
 */
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
		System.out.println("Ingrese el genero del paciente.");
		String gender = reader.nextLine();
		System.out.println("Ingrese el peso del paciente.");
		String weight = reader.nextLine();
		System.out.println("Ingrese la altura del paciente.");
		String height = reader.nextLine();
		return PatientBuilders.build(name, lastName, document, email, phoneNumber, address,dateOfBirth, gender, weight, height);
        
	}

	private Appointment readInfoFromAppointment() throws Exception {
		
		System.out.println("Ingrese el nombre del doctor.");
		String doctorname = reader.nextLine();
		System.out.println("Ingrese el nombre del paciente.");
		String patientname = reader.nextLine();
		System.out.println("Ingrese la fecha de la cita.");
		String date = reader.nextLine();
		
		return AppointmentBuilders.build(doctorname, patientname, date);
	}
	
 /**
* Aca se inicia la sesión del administrador, mostrando el menú en un bucle hasta que decida salir
* */
	public void session() {
		boolean session = true;
		while(session) {
			session = menu();
			}
		
	}
	

} // end class
