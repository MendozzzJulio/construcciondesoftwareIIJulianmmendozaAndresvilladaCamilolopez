package app.adapter.in.builder;

import app.adapter.in.validators.DiagnosticValidator;
import app.domain.entities.Diagnostic;

public class DiagnosticBuilder {
	
	private DiagnosticValidator diagnosticValidator;

	public Diagnostic build(String description, String results, String date, String doctorId, String patientId, String severity, String notes) 
		throws Exception {
		Diagnostic diagnostic = new Diagnostic();
		diagnostic.setDescription(diagnosticValidator.descriptionValidator(description));
		diagnostic.setResults(diagnosticValidator.resultsValidator(results));
		diagnostic.setDate(diagnosticValidator.dateValidator(date));
		diagnostic.setSeverity(diagnosticValidator.severityValidator(severity));
		diagnostic.setNotes(diagnosticValidator.notesValidator(notes));
		
		return diagnostic;
	}
}
