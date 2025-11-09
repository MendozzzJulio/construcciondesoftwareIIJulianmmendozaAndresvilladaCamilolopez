package app.adapter.in.client;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.MedicalOrderBuilder;
import app.adapter.in.builder.MedicalRecordBuilder;
import app.adapter.in.builder.PatientBuilders;
import app.application.usecase.DoctorsUseCase;
import app.domain.entities.MedicalOrder;
import app.domain.entities.MedicalRecord;
import app.domain.entities.Patient;

/**
 * Cliente para el rol Doctor (Médicos)
 * Maneja la interacción con médicos del sistema
 */
@Component
public class DoctorClient {

	private static final String MENU = " ***MENU MÉDICO*** \n1. Crear registro médico \n2. Actualizar registro médico\n3. Buscar registros médicos de paciente \n4. Crear orden médica \n5. Crear paciente \n6. Salir";		
	private static Scanner reader = new Scanner(System.in);
	
	@Autowired
	private DoctorsUseCase doctorsUseCase;
	@Autowired
	private MedicalRecordBuilder medicalRecordBuilder;
	@Autowired
	private MedicalOrderBuilder medicalOrderBuilder;
	@Autowired
	private PatientBuilders patientBuilders;
	
	/**
	 * Muestra el menú y ejecuta la opción seleccionada por el médico.
	 * @return true si se debe continuar la sesión, false si se debe terminar.
	 */
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = reader.nextLine();
			switch(option) {
			case "1":{
				// Crear registro médico
				MedicalRecord medicalRecord = readInfoFromMedicalRecord();
				doctorsUseCase.createMedicalRecord(medicalRecord);
				System.out.println("Registro médico creado exitosamente");
				return true;
			}
			case "2": {
				// Actualizar registro médico
				System.out.println("Ingrese el ID del registro médico a actualizar:");
				long id = Long.parseLong(reader.nextLine());
				MedicalRecord medicalRecord = readInfoFromMedicalRecord();
				medicalRecord.setId(id);
				doctorsUseCase.updateMedicalRecord(medicalRecord);
				System.out.println("Registro médico actualizado exitosamente");
				return true;
			}
			case "3": {
				// Buscar registros médicos de paciente
				System.out.println("Ingrese el ID del paciente:");
				long patientId = Long.parseLong(reader.nextLine());
				Patient patient = new Patient();
				patient.setId(patientId);
				List<MedicalRecord> records = doctorsUseCase.searchMedicalRecord(patient);
				System.out.println("Registros médicos encontrados:");
				for(MedicalRecord record : records) {
					System.out.println("- ID: " + record.getId() + ", Diagnóstico: " + record.getDiagnosis() + ", Fecha: " + record.getDate());
				}
				return true;
			}
			case "4": {
				// Crear orden médica
				MedicalOrder medicalOrder = readInfoFromMedicalOrder();
				doctorsUseCase.createMedicalOrder(medicalOrder);
				System.out.println("Orden médica creada exitosamente");
				return true;
			}
			case "5": {
				// Crear paciente
				Patient patient = readInfoFromPatient();
				doctorsUseCase.createPatient(patient);
				System.out.println("Paciente creado exitosamente");
				return true;
			}
			case "6":{
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
	
	private MedicalRecord readInfoFromMedicalRecord() throws Exception {
		System.out.println("Ingrese el ID del paciente:");
		String patientId = reader.nextLine();
		System.out.println("Ingrese el ID del doctor:");
		String doctorId = reader.nextLine();
		System.out.println("Ingrese la fecha (YYYY-MM-DD):");
		String date = reader.nextLine();
		System.out.println("Ingrese el diagnóstico:");
		String diagnosis = reader.nextLine();
		System.out.println("Ingrese el tratamiento:");
		String treatment = reader.nextLine();
		System.out.println("Ingrese notas adicionales:");
		String notes = reader.nextLine();
		
		return medicalRecordBuilder.build(patientId, doctorId, date, diagnosis, treatment, notes);
	}
	
	private MedicalOrder readInfoFromMedicalOrder() throws Exception {
		System.out.println("Ingrese el ID del paciente:");
		String patientId = reader.nextLine();
		System.out.println("Ingrese el ID del doctor:");
		String doctorId = reader.nextLine();
		System.out.println("Ingrese la fecha (YYYY-MM-DD):");
		String date = reader.nextLine();
		System.out.println("Ingrese los ítems de la orden (separados por coma):");
		String items = reader.nextLine();
		
		return medicalOrderBuilder.build(patientId, doctorId, date, items);
	}
	
	private Patient readInfoFromPatient() throws Exception {
		System.out.println("Ingrese el nombre del paciente:");
		String name = reader.nextLine();
		System.out.println("Ingrese el apellido del paciente:");
		String lastName = reader.nextLine();
		System.out.println("Ingrese el documento del paciente:");
		String document = reader.nextLine();
		System.out.println("Ingrese el email del paciente:");
		String email = reader.nextLine();
		System.out.println("Ingrese el teléfono del paciente:");
		String phoneNumber = reader.nextLine();
		System.out.println("Ingrese la dirección del paciente:");
		String address = reader.nextLine();
		System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
		String dateOfBirth = reader.nextLine();
		System.out.println("Ingrese el género (MALE/FEMALE):");
		String gender = reader.nextLine();
		System.out.println("Ingrese el peso:");
		String weight = reader.nextLine();
		System.out.println("Ingrese la altura:");
		String height = reader.nextLine();
		
		return patientBuilders.build(name, lastName, document, email, phoneNumber, address, dateOfBirth, gender, weight, height);
	}
	
	/**
	 * Inicia la sesión del médico, mostrando el menú en un bucle hasta que decida salir
	 */
	public void session() {
		System.out.println("=== BIENVENIDO AL SISTEMA MÉDICO ===");
		boolean session = true;
		while(session) {
			session = menu();
		}
	}
}
