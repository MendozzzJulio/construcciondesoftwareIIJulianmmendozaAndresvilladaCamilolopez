package app.adapter.in.builder;

import app.adapter.in.validators.MedicalOrderValidator;
import app.domain.entities.MedicalOrder;

public class MedicalOrderBuilder {
	
	private MedicalOrderValidator medicalOrderValidator = new MedicalOrderValidator();
	
	public MedicalOrder build(String patient, String doctor, String date, String items) throws Exception{
		
		MedicalOrder medicalOrder = new MedicalOrder();
		medicalOrder.setPatient(medicalOrderValidator.patientValidator(patient));
		medicalOrder.setDoctor(medicalOrderValidator.userValidator(doctor));
		medicalOrder.setDate(medicalOrderValidator.dateValidator(date));
		medicalOrder.setItems(medicalOrderValidator.itemsValidator(items));
		return medicalOrder;
	}
	

}
