package app.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.entities.MedicalOrder;
import app.domain.entities.MedicalRecord;
import app.domain.entities.Patient;
import app.domain.services.CreateMedicalOrder;
import app.domain.services.CreateMedicalRecord;
import app.domain.services.CreatePatient;
import app.domain.services.SearchMedicalRecord;
import app.domain.services.UpdateMedicalRecord;

/**
 * Caso de uso para el rol Doctor (Médicos)
 * Funcionalidades: gestión de registros médicos, órdenes médicas y pacientes
 */
@Component
public class DoctorsUseCase {
	
	@Autowired
	private CreateMedicalRecord createMedicalRecord;
	@Autowired
	private UpdateMedicalRecord updateMedicalRecord;
	@Autowired
	private SearchMedicalRecord searchMedicalRecord;
	@Autowired
	private CreateMedicalOrder createMedicalOrder;
	@Autowired
	private CreatePatient createPatient;
	
	/**
	 * Crear un nuevo registro médico
	 * Los médicos documentan consultas, diagnósticos y tratamientos
	 */
	public void createMedicalRecord(MedicalRecord medicalRecord) throws Exception {
		createMedicalRecord.create(medicalRecord);
	}
	
	/**
	 * Actualizar un registro médico existente
	 * Permite modificar información clínica según evolución del paciente
	 */
	public void updateMedicalRecord(MedicalRecord medicalRecord) throws Exception {
		updateMedicalRecord.update(medicalRecord);
	}
	
	/**
	 * Buscar registros médicos de un paciente
	 * Consulta el historial clínico completo para toma de decisiones
	 */
	public List<MedicalRecord> searchMedicalRecord(Patient patient) throws Exception {
		return searchMedicalRecord.search(patient);
	}
	
	/**
	 * Crear una orden médica
	 * Prescribe medicamentos, procedimientos o ayudas diagnósticas
	 */
	public void createMedicalOrder(MedicalOrder medicalOrder) throws Exception {
		createMedicalOrder.create(medicalOrder);
	}
	
	/**
	 * Crear un nuevo paciente
	 * Los médicos pueden registrar pacientes durante consultas
	 */
	public void createPatient(Patient patient) throws Exception {
		createPatient.create(patient);
	}
}
