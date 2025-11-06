package app.adapter.in.builder;

import app.adapter.in.validators.DiagnosticAidValidator;
import app.domain.entities.DiagnosticAid;

public class DiagnosticAidBuilder {
	
	private DiagnosticAidValidator diagnosticAidValidator;

	public DiagnosticAid build(String name, String description, String cost, String requirements) 
		throws Exception {
		DiagnosticAid diagnosticAid = new DiagnosticAid();
		diagnosticAid.setOrderNumber(diagnosticAidValidator.nameValidator(name));
		diagnosticAid.setDescription(diagnosticAidValidator.descriptionValidator(description));
		diagnosticAid.setCost(diagnosticAidValidator.costValidator(cost));
		diagnosticAid.setRequirements(diagnosticAidValidator.requirementsValidator(requirements));
		
		return diagnosticAid;
	}
}
