package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.MedicalOrder;
import app.domain.ports.MedicalOrderPort;
import app.domain.ports.SearchMedicalOrderPort;


@Service
public class SearchMedicalOrder {
	@Autowired
	private MedicalOrderPort  medicalOrderPort;
	@Autowired
	private SearchMedicalOrderPort searchMedicalOrderPort;
	
	public List<MedicalOrder> search(MedicalOrder medicalOrder) throws Exception {
		medicalOrder = medicalOrderPort.findById(medicalOrder);
		if (medicalOrder == null) {
			throw new Exception("debe consultar una orden medica registrada");
		}
		return searchMedicalOrderPort.findByMedicalOrder(medicalOrder);
	}
	
	
}
