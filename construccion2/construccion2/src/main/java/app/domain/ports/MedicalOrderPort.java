
package app.domain.ports;


import app.domain.entities.MedicalOrder;


public interface MedicalOrderPort {
	
	public MedicalOrder findById(MedicalOrder medicalOrder) throws Exception;
	
	public void save(MedicalOrder medicalOrder) throws Exception;


}
