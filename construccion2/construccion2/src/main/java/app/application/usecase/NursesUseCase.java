package app.application.usecase;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.MedicalOrder;
import app.domain.entities.Patient;
import app.domain.entities.Visit;
import app.domain.services.CreateVisit;
import app.domain.services.SearchPatient;
import app.domain.services.SearchMedicalOrder;

@Service
public class NursesUseCase {
	
	@Autowired
	private SearchMedicalOrder searchMedicalOrder;
	@Autowired
	private SearchPatient searchPatient;
	@Autowired
	private CreateVisit createVisit;
	
	public void createVisit(Visit visit) throws Exception {
		createVisit.createVisit(visit); 
	}
	
	public List<MedicalOrder> searchMedicalOrder(MedicalOrder medicalOrder) throws Exception {
		return searchMedicalOrder.search(medicalOrder);
	}
	
	public List<Patient> searchPatient(Patient patient) throws Exception {
		return searchPatient.search(patient);
	}


}
