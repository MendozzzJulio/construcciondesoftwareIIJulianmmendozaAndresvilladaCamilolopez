package app.adapter.in.client;

import app.adapter.in.builder.AppointmentBuilders;
import app.adapter.in.builder.BillingBuilders;
import app.adapter.in.builder.EmergencyContactBuilder;
import app.adapter.in.builder.PatientBuilders;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.application.usecase.AdminUseCase;
import app.domain.entities.Appointment;
import app.domain.entities.Billing;
import app.domain.entities.EmergencyContact;
import app.domain.entities.Patient;

/**
 * Cliente para el rol Administrative (Personal Administrativo)
 * Maneja la interacción con usuarios administrativos del sistema
 */
@Component
public class AdminClient {

	private static final String MENU = " ***MENU ADMINISTRATIVO*** \n1. Crear paciente \n2. Crear cita médica\n3. Crear factura \n4. Actualizar paciente \n5. Crear contacto de emergencia \n6. Buscar paciente \n7. Acceder a Recursos Humanos \n8. Salir";		
	private static Scanner reader = new Scanner(System.in);
	
	@Autowired
	private AdminUseCase adminUseCase;
	@Autowired
	private PatientBuilders patientBuilders;
	@Autowired
	private AppointmentBuilders appointmentBuilders;
	@Autowired
	private BillingBuilders billingBuilders;
	@Autowired
	private EmergencyContactBuilder emergencyContactBuilder;
	@Autowired
	private HRClient hrClient;
	
	

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
				// Crear paciente
				Patient patient = readInfoFromPatient();
				adminUseCase.createPatient(patient);
				System.out.println("Paciente creado exitosamente");
				return true;
			}
			case "2": {
				// Crear cita médica
				Appointment appointment = readInfoFromAppointment();
				adminUseCase.createAppointment(appointment);
				System.out.println("Cita médica creada exitosamente");
				return true;
			}
			case "3": {
				// Crear factura
				Billing billing = readInfoFromBilling();
				adminUseCase.createBilling(billing);
				System.out.println("Factura creada exitosamente");
				return true;
			}
			case "4": {
				// Actualizar paciente
				System.out.println("Ingrese el id del paciente a actualizar:");
				long id = Long.parseLong(reader.nextLine());
				Patient patient = readInfoFromPatient();
				patient.setId(id);
				adminUseCase.updatePatient(patient);
				System.out.println("Paciente actualizado exitosamente");
				return true;
			}
			case "5": {
				// Crear contacto de emergencia
				EmergencyContact emergencyContact = readInfoFromEmergencyContact();
				adminUseCase.createEmergencyContact(emergencyContact);
				System.out.println("Contacto de emergencia creado exitosamente");
				return true;
			}
			case "6": {
				// Buscar paciente
				System.out.println("Ingrese el id del paciente a buscar:");
				long id = Long.parseLong(reader.nextLine());
				Patient patient = readInfoFromUpdatePatient();
				patient.setId(id);
				adminUseCase.searchPatient(patient);
				System.out.println("Búsqueda de paciente realizada exitosamente");
				return true;
			}
			case "7": {
				// Acceder a Recursos Humanos
				System.out.println("Accediendo al sistema de Recursos Humanos...");
				hrClient.session();
				return true;
			}
			case "8":{
				System.out.println("Hasta luego \nCerrando sesión");
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
	
	
	private Patient readInfoFromUpdatePatient() throws Exception{
		/**
		 * Solicita al administrador la información necesaria para actualizar un paciente.
		 * pero creo que los mensajes deben de ser diferentes ya que es para actualizar una 
		 * informacion ya existentes
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
    
	return patientBuilders.build(name, lastName, document, email, phoneNumber, address, dateOfBirth,gender, weight, height);
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
		return patientBuilders.build(name, lastName, document, email, phoneNumber, address, dateOfBirth, gender, weight, height);
        
	}

	private Appointment readInfoFromAppointment() throws Exception {
		
		System.out.println("Ingrese el nombre del doctor.");
		String doctorname = reader.nextLine();
		System.out.println("Ingrese el nombre del paciente.");
		String patientname = reader.nextLine();
		System.out.println("Ingrese la fecha de la cita.");
		String date = reader.nextLine();
		
		return appointmentBuilders.build(doctorname, patientname, date);
	}
	
	private Billing readInfoFromBilling() throws Exception {
		System.out.println("Ingrese el ID del paciente:");
		String patientId = reader.nextLine();
		System.out.println("Ingrese el monto total:");
		String totalAmount = reader.nextLine();
		System.out.println("Ingrese el copago:");
		String copayment = reader.nextLine();
		System.out.println("Ingrese la fecha de la factura:");
		String date = reader.nextLine();
		System.out.println("Ingrese detalles adicionales:");
		String details = reader.nextLine();
		System.out.println("Ingrese el metodo de pago:");
		String paymentMethod = reader.nextLine();
		
		
		return billingBuilders.build(patientId, totalAmount, copayment, date, details);
		/**
		 * aca hay un error por que el metodo build de billing builders no tiene esos parametros
		 * y ademas esta esperando mas parametros
		 */
	}
	
	private EmergencyContact readInfoFromEmergencyContact() throws Exception {
		System.out.println("Ingrese el nombre del contacto:");
		String name = reader.nextLine();
		System.out.println("Ingrese el apellido del contacto:");
		String lastName = reader.nextLine();
		System.out.println("Ingrese el número de teléfono:");
		String phoneNumber = reader.nextLine();
		System.out.println("Ingrese la relación con el paciente:");
		String relationship = reader.nextLine();
		
		return emergencyContactBuilder.build(name, lastName, phoneNumber, relationship);
	}
	
 /**
* Aca se inicia la sesión del administrador, mostrando el menú en un bucle hasta que decida salir
* */
	public void session() {
		System.out.println("=== BIENVENIDO AL SISTEMA ADMINISTRATIVO ===");
		boolean session = true;
		while(session) {
			session = menu();
		}
		
	}
	

} // end class
