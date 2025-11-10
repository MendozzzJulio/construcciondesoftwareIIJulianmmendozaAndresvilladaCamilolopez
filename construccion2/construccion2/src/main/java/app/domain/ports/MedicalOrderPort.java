
package app.domain.ports;




import java.util.List;

import app.domain.entities.MedicalOrder;
import app.domain.entities.Patient;


public interface MedicalOrderPort {
	
	public List<MedicalOrder> findByPatient(Patient patient) throws Exception;
	public MedicalOrder findById(MedicalOrder medicalOrder) throws Exception;
	public void save(MedicalOrder medicalOrder) throws Exception;


}
