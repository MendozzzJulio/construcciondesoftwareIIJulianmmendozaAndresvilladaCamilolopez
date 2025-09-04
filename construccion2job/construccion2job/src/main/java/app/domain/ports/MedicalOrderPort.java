package app.domain.ports;

import java.util.List;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;

public interface MedicalOrderPort {
	public MedicalOrder findById(MedicalOrder  medicalOrder) throws Exception;
	public List<MedicalOrder> findByPet(Patient patient)throws Exception;
	public void save(MedicalOrder medicalOrder) throws Exception;

}
