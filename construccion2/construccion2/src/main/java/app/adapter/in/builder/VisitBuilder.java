package app.adapter.in.builder;

import app.adapter.in.validators.VisitValidator;
import app.domain.entities.Visit;

public class VisitBuilder {
	
	private VisitValidator visitValidator;

	public Visit build(String patientId, String doctorId, String date, String reason, String notes, String status) 
		throws Exception {
		Visit visit = new Visit();
		visit.setPatient(visitValidator.patientIdValidator(patientId));
		visit.setDoctor(visitValidator.userdoctoridValidator(doctorId));
		visit.setDate(visitValidator.dateValidator(date));
		visit.setReason(visitValidator.reasonValidator(reason));
		visit.setNotes(visitValidator.notesValidator(notes));
		visit.setStatus(visitValidator.statusValidator(status)); /*
																	 * Aquí se asume que la clase Visit tiene un método
																	 * setStatus para establecer el estado de la visita.
																	 * pero no lo tiene y no se si eso es un boolean.
																	 */
		
		return visit;
	}
}
