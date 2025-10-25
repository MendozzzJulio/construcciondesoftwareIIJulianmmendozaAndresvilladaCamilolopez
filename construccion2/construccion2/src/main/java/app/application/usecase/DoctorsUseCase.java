package app.application.usecase;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import app.domain.entities.MedicalOrder;
import app.domain.services.CreateMedicalOrder;
import app.domain.services.CreateMedicalRecord;
import app.domain.services.SearchMedicalRecord;
import app.domain.entities.MedicalRecord;
import app.domain.entities.Patient;



public class DoctorsUseCase {
	@Autowired
	private CreateMedicalOrder createMedicalOrder;
	@Autowired
	private CreateMedicalRecord createMedicalRecord;
	@Autowired
	private SearchMedicalRecord searchMedicalRecord;
	
	/*
	 * Llama al servicio para crear una nueva historia clínica.
		Puede lanzar una excepción si hay errores en la validación (por ejemplo, paciente o doctor no válidos).
	 */
	public void createMedicalRecord(MedicalRecord medicalRecord) throws Exception {
		createMedicalRecord.create(medicalRecord);
	}
	//LlamO al servicio para actualizar una historia clínica existente.
	public void updateMedicalRecord(MedicalRecord medicalRecord) throws Exception {
		createMedicalRecord.update(medicalRecord);
	}
	
	public List<MedicalRecord> searchMedicalRecord(Patient patient) throws Exception{
		return searchMedicalRecord.search(patient); //Busca todas las historias clínicas asociadas a un paciente.
		                                            //Retorna una lista de objetos MedicalRecords.
	}

	public void createMedicalOrder(MedicalOrder medicalOrder) throws Exception {
			createMedicalOrder.create(medicalOrder);	
	}


}
