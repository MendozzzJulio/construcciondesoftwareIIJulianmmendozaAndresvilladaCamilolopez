package app.domain.ports;

import app.domain.model.MedicalOrder;

public interface MedicalOrderPort {

	MedicalOrder findById(MedicalOrder medicalOrder);


	
	
}
 