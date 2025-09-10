package app.domain.ports;

import app.domain.model.MedicalOrder;

public interface MedicalOrderPort {
/*
	public MedicalOrder findMedicalOrderById(MedicalOrder  medicalOrder) throws Exception;
	public List<MedicalOrder> findByPet(Patient patient)throws Exception;
	public void save(MedicalOrder medicalOrder) throws Exception;
*/
	
	MedicalOrder getMedicalOrderById(String medicalOrderId);


	
	
}
