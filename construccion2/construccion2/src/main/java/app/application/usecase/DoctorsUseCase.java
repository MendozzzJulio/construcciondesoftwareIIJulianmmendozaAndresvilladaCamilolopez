package app.application.usecase;


import org.springframework.beans.factory.annotation.Autowired;
import app.domain.entities.MedicalOrder;
import app.domain.services.CreateMedicalOrder;

public class DoctorsUseCase {
	@Autowired
	private CreateMedicalOrder createMedicalOrder;
	
	
	public void createMedicalOrder(MedicalOrder medicalOrder) throws Exception {
		
			createMedicalOrder.create(medicalOrder);	
	}


}
