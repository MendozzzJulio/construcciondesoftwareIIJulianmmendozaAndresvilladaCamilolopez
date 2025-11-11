package app.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.entities.MedicalOrder;
import app.domain.entities.Patient;
import app.domain.entities.Visit;
import app.domain.services.CreateVisit;
import app.domain.services.SearchMedicalOrder;
import app.domain.services.SearchPatient;

/**
 * Caso de uso para el rol Nurse (Enfermeras)
 * Funcionalidades: registrar visitas, buscar órdenes médicas y pacientes
 */
@Component
public class NursesUseCase {
	
	@Autowired
	private CreateVisit createVisit;
	@Autowired
	private SearchMedicalOrder searchMedicalOrder;
	@Autowired
	private SearchPatient searchPatient;
	
	/**
	 * Registrar una nueva visita médica
	 * Las enfermeras pueden documentar visitas y intervenciones
	 */
	public void registerVisit(Visit visit) throws Exception {
		createVisit.createVisit(visit);
	}
	
	/**
	 * Buscar órdenes médicas
	 * Permite a las enfermeras consultar las órdenes para ejecutar tratamientos
	 */
	public List<MedicalOrder> searchMedicalOrder(MedicalOrder medicalOrder) throws Exception {
		return searchMedicalOrder.search(medicalOrder);
	}
	
	/**
	 * Buscar paciente en el sistema
	 * Necesario para localizar pacientes durante las rondas médicas
	 */
	public List<Patient> searchPatient(Patient patient) throws Exception {
		return searchPatient.search(patient);
	}
}
