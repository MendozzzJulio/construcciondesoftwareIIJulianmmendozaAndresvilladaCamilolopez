package app.adapter.in.client;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.VisitBuilder;
import app.application.usecase.NursesUseCase;
import app.domain.entities.MedicalOrder;
import app.domain.entities.Patient;
import app.domain.entities.Visit;

/**
 * Cliente para el rol Nurse (Enfermeras)
 * Maneja la interacción con enfermeras del sistema
 */
@Component
public class NurseClient {

	private static final String MENU = " ***MENU ENFERMERÍA*** \n1. Registrar visita \n2. Buscar orden médica\n3. Buscar paciente \n4. Salir";		
	private static Scanner reader = new Scanner(System.in);
	
	@Autowired
	private NursesUseCase nursesUseCase;
	@Autowired
	private VisitBuilder visitBuilder;
	
	/**
	 * Muestra el menú y ejecuta la opción seleccionada por la enfermera.
	 * @return true si se debe continuar la sesión, false si se debe terminar.
	 */
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = reader.nextLine();
			switch(option) {
			case "1":{
				// Registrar visita
				Visit visit = readInfoFromVisit();
				nursesUseCase.registerVisit(visit);
				System.out.println("Visita registrada exitosamente");
				return true;
			}
			case "2": {
				// Buscar orden médica
				System.out.println("Ingrese el ID de la orden médica a buscar:");
				long orderId = Long.parseLong(reader.nextLine());
				MedicalOrder searchOrder = new MedicalOrder();
				searchOrder.setId(orderId);
				List<MedicalOrder> orders = nursesUseCase.searchMedicalOrder(searchOrder);
				System.out.println("Órdenes médicas encontradas:");
				for(MedicalOrder order : orders) {
					System.out.println("- ID: " + order.getId() + ", Paciente: " + order.getPatient() + ", Doctor: " + order.getDoctor() + ", Fecha: " + order.getDate());
				}
				return true;
			}
			case "3": {
				// Buscar paciente
				System.out.println("Ingrese el ID del paciente a buscar:");
				long patientId = Long.parseLong(reader.nextLine());
				Patient searchPatient = new Patient();
				searchPatient.setId(patientId);
				List<Patient> patients = nursesUseCase.searchPatient(searchPatient);
				System.out.println("Pacientes encontrados:");
				for(Patient patient : patients) {
					System.out.println("- ID: " + patient.getId() + ", Nombre: " + patient.getName() + " " + patient.getLastName() + ", Documento: " + patient.getDocument());
				}
				return true;
			}
			case "4":{
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
	
	private Visit readInfoFromVisit() throws Exception {
		System.out.println("Ingrese el ID del paciente:");
		String patientId = reader.nextLine();
		System.out.println("Ingrese el ID del doctor:");
		String doctorId = reader.nextLine();
		System.out.println("Ingrese la fecha de la visita (YYYY-MM-DD):");
		String date = reader.nextLine();
		System.out.println("Ingrese el motivo de la visita:");
		String reason = reader.nextLine();
		System.out.println("Ingrese notas de la visita:");
		String notes = reader.nextLine();
		System.out.println("Ingrese el estado de la visita:");
		String status = reader.nextLine();
		
		return visitBuilder.build(patientId, doctorId, date, reason, notes, status);
	}
	
	/**
	 * Inicia la sesión de la enfermera, mostrando el menú en un bucle hasta que decida salir
	 */
	public void session() {
		System.out.println("=== BIENVENIDO AL SISTEMA DE ENFERMERÍA ===");
		boolean session = true;
		while(session) {
			session = menu();
		}
	}
}
