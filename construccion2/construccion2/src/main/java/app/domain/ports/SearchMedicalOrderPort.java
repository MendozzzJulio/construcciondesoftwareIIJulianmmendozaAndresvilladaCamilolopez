package app.domain.ports;

import java.util.List;

import app.domain.entities.MedicalOrder;

public interface SearchMedicalOrderPort {

	public List<MedicalOrder> findByMedicalOrder(MedicalOrder medicalOrder) throws Exception;
	

}
