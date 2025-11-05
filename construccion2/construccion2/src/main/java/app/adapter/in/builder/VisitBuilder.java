package app.adapter.in.builder;

import app.adapter.in.validators.VisitValidator;
import app.domain.entities.Visit;

public class VisitBuilder {
	
	private VisitValidator visitValidator;

	public Visit build(String patientId, String doctorId, String date, String reason, String notes, String status) 
		throws Exception {
		Visit visit = new Visit();
		visit.setPatientId(visitValidator.patientIdValidator(patientId));
		visit.setDoctorId(visitValidator.doctorIdValidator(doctorId));
		visit.setDate(visitValidator.dateValidator(date));
		visit.setReason(visitValidator.reasonValidator(reason));
		visit.setNotes(visitValidator.notesValidator(notes));
		visit.setStatus(visitValidator.statusValidator(status));
		
		return visit;
	}
}
